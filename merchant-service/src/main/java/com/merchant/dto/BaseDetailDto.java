package com.merchant.dto;

public class BaseDetailDto<T> {

	private String resultType;
	private String resultCode;
	private String errorMsg;
	private T data;

	public BaseDetailDto(String resultType, String resultCode, String errorMsg) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}

	public BaseDetailDto(String resultType, String resultCode, T data) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.data = data;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
