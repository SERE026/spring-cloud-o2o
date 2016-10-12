package com.icloud.dto;

import com.icloud.model.MerchantsAccount;
 

/**
 * 商户帐户 账号密码验证Dto
 * 
 * @author luoqw 2016-9-7上午10:10:57
 */
public class AccountLoginCheckDto {

	private String resultType;
	private String resultCode;
	private String errorMsg;
	private boolean resultCheck;
	private MerchantsAccount accout;

	public boolean isSuccess(){
		return ("success".endsWith(resultType) && "10000".endsWith(resultCode) );
	}
	
	public AccountLoginCheckDto(String resultType, String resultCode, String errorMsg) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}

	public AccountLoginCheckDto(String resultType, String resultCode, String errorMsg, boolean resultCheck) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
		this.resultCheck = resultCheck;
	}

	public AccountLoginCheckDto(String resultType, String resultCode, boolean resultCheck,
			MerchantsAccount accout) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.resultCheck = resultCheck;
		this.accout = accout;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrorMsg() {
		if (!resultCheck) {
			errorMsg = "用户名或密码错误";
		}
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isResultCheck() {
		return resultCheck;
	}

	public void setResultCheck(boolean resultCheck) {
		this.resultCheck = resultCheck;
	}

	public MerchantsAccount getAccout() {
		return accout;
	}

	public void setAccout(MerchantsAccount accout) {
		this.accout = accout;
	}

}
