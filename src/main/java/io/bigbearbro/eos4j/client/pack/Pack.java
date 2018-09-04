package io.bigbearbro.eos4j.client.pack;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * EOS字节打包注解
 * @author wuwei
 *
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Pack {
	/**
	 * 打包类型
	 * @return
	 */
	PackType value() default PackType.object;

}
