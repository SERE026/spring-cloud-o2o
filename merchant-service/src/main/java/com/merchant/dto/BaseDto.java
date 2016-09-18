package com.merchant.dto;

/**
 * 通用dto
 * @author luoqw
 * 2016-9-7上午10:13:30
 */
public class BaseDto {

	private String resultType;
	private String resultCode;
	private String errorMsg;

	public BaseDto() {

	}

	public BaseDto(String resultType, String resultCode) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
	}

	public BaseDto(String resultType, String resultCode, String errorMsg) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
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

}
