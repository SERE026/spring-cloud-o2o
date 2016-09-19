package com.merchant.dto;

import com.merchant.model.MerchantsSupplier;

public class SupplierDetailDto {

	private String resultType;
	private String resultCode;
	private String errorMsg;
	private MerchantsSupplier supplier;

	public SupplierDetailDto(String resultType, String resultCode,
			String errorMsg) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}

	public SupplierDetailDto(String resultType, String resultCode,
			MerchantsSupplier supplier) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.supplier = supplier;
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

	public MerchantsSupplier getSupplier() {
		return supplier;
	}

	public void setSupplier(MerchantsSupplier supplier) {
		this.supplier = supplier;
	}

}
