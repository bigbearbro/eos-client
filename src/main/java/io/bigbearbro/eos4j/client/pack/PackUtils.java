package io.bigbearbro.eos4j.client.pack;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.bigbearbro.eos4j.client.exception.PackException;
import io.bigbearbro.eos4j.utils.ByteBuffer;
import io.bigbearbro.eos4j.utils.ByteUtils;

/**
 * pack object
 * 
 * @author wangyan
 *
 */
public class PackUtils {

	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}

	private static List<Field> getClassFields(Class<?> clazz) {
		List<Field> ret = new ArrayList<Field>();
		fillParentClassFields(clazz, ret);
		return ret;
	}

	private static void fillParentClassFields(Class<?> clazz, List<Field> list) {
		Class<?> parent = clazz.getSuperclass();
		if (parent != null) {
			fillParentClassFields(parent, list);
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			list.add(field);
		}
	}

	public static void pack(Object obj, ByteBuffer bf, PackType pt) {
		switch (pt) {
		case asset:
			bf.concat(ByteUtils.writeAsset(obj.toString()));
			break;
		case key:
			bf.concat(ByteUtils.writeKey(obj.toString()));
			break;
		case name:
			bf.concat(ByteUtils.writeName(obj.toString()));
			break;
		case hexString:
			bf.concat(ByteUtils.writeHexString(obj.toString()));
			break;
		case string:
			bf.concat(ByteUtils.writeString(obj.toString()));
			break;
		case uint8:
			bf.concat(ByteUtils.writeUint8(obj.toString()));
			break;
		case uint16:
			bf.concat(ByteUtils.writeUint16(obj.toString()));
			break;
		case uint32:
			if (obj instanceof Date) {
				bf.concat(ByteUtils.writeUint32(String.valueOf(((Date) obj).getTime() / 1000)));
			} else {
				bf.concat(ByteUtils.writeUint32(obj.toString()));
			}
			break;
		case varint32:
			bf.concat(ByteUtils.writeVarint32(obj.toString()));
			break;
		case bytes:
			ByteBuffer databf = new ByteBuffer();
			packObj(obj, databf);
			bf.concat(new byte[] { (byte) databf.getBuffer().length });
			bf.concat(databf.getBuffer());
			break;
		case object:
			packObj(obj, bf);
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("rawtypes")
	public static void packObj(Object o, ByteBuffer bf) {
		if (o == null) {
			return;
		}
		List<Field> fields = getClassFields(o.getClass());
		int size = fields.size();
		for (int i = 0; i < size; i++) {
			Field f = fields.get(i);
			Pack p = f.getAnnotation(Pack.class);
			if (p != null) {
				Object value = getFieldValueByName(f.getName(), o);
				if (value == null) {
					throw new PackException("obj can not be null");
				}
				// 按类型打包
				PackType pt = p.value();
				if (value instanceof List) {
					List list = (List) value;
					bf.concat(ByteUtils.writeVarint32(String.valueOf(list.size())));
					for (Object item : list) {
						pack(item, bf, pt);
					}
				} else {
					pack(value, bf, pt);
				}
			}
		}
	}

}
