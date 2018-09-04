package io.bigbearbro.eos4j.client.pack;

import java.security.InvalidParameterException;
/**
 * 
 * @author wangyan
 *
 */
public class AssetQuantity {
	/**
	 * 解析 "1.00 EOS" 到 "1.00 4,EOS@eosio.token"
	 * @param quantity 数额带符号
	 * @param contractAccount 合约账号
	 * @param precision 精度
	 * @return
	 */
	public static String parse(String quantity, String contractAccount, String precision) {
		String[] v = quantity.split(" ");
		if(v.length != 2) {
			throw new InvalidParameterException("quantity invalid");
		}
		String amount = v[0];
		String symbol = v[1];
		return String.format("%s %s,%s@%s", amount, precision, symbol, contractAccount);
	}
}
