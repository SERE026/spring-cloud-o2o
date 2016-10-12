package com.icloud.dto;

import com.icloud.model.MerchantsAccount;

public class TokenMessageDto {

	private String resultType;
	private String resultCode;
	private String errorMsg;
	private String grantType;
	private MerchantsAccount userInfo;
	

	public TokenMessageDto() {
		super(); 
	}

	public TokenMessageDto(String resultType, String resultCode, String errorMsg, String grantType) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
		this.grantType = grantType;
	}

	public TokenMessageDto(String resultType, String resultCode, String grantType, MerchantsAccount userInfo) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.grantType = grantType;
		this.userInfo = userInfo;
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
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public MerchantsAccount getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(MerchantsAccount userInfo) {
		this.userInfo = userInfo;
	}

}
