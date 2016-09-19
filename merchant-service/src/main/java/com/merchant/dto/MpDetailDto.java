package com.merchant.dto;

import com.merchant.model.MerchantsMp;

public class MpDetailDto {

	private String resultType;
	private String resultCode;
	private String errorMsg;
	private MerchantsMp mp;

	public MpDetailDto(String resultType, String resultCode, String errorMsg) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}

	public MpDetailDto(String resultType, String resultCode, MerchantsMp mp) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.mp = mp;
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

	public MerchantsMp getMp() {
		return mp;
	}

	public void setMp(MerchantsMp mp) {
		this.mp = mp;
	}

}
