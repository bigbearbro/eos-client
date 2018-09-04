package io.bigbearbro.eos4j.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCurrencyBalanceRequest {
	/**
	 * 合约地址
	 */
	String code;
	/**
	 * 待查询余额的账户
	 */
	String account;
	/**
	 * 代币符号
	 */
	String symbol;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
}
