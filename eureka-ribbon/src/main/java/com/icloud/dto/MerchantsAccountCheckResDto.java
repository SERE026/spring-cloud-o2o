package com.icloud.dto;


/**
 * 商户帐户是否存在Dto
 * @author luoqw 2016-9-7上午10:10:57
 */
public class MerchantsAccountCheckResDto {
	private String resultType;
	private String resultCode;
	private String errorMsg;
	private boolean resultCheck;

	public MerchantsAccountCheckResDto() {
		super();
	}

	public MerchantsAccountCheckResDto(String resultType, String resultCode, String errorMsg) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}

	public MerchantsAccountCheckResDto(String resultType, String resultCode, boolean resultCheck) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.resultCheck = resultCheck;
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

	public boolean isResultCheck() {
		return resultCheck;
	}

	public void setResultCheck(boolean resultCheck) {
		this.resultCheck = resultCheck;
	}

}
