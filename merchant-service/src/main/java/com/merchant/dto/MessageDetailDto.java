package com.merchant.dto;

import com.merchant.model.MerchantsMessage;

public class MessageDetailDto {

	private String resultType;
	private String resultCode;
	private String errorMsg;
	private MerchantsMessage message;
	public MessageDetailDto(String resultType, String resultCode,
			String errorMsg) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}
	public MessageDetailDto(String resultType, String resultCode,
			MerchantsMessage message) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.message = message;
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

	public MerchantsMessage getMessage() {
		return message;
	}

	public void setMessage(MerchantsMessage message) {
		this.message = message;
	}

	 
}
