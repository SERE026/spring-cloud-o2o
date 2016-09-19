package com.icloud.dto;

import java.util.ArrayList;
import java.util.List;

import com.icloud.model.MerchantsSupplier;


public class SupplierQueryDto extends BaseDto {
 
	private int offset = 1;
	private int pageSize = 10;
	private List<MerchantsSupplier> Merchantses = new ArrayList<MerchantsSupplier>();

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

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<MerchantsSupplier> getMerchantses() {
		return Merchantses;
	}

	public void setMerchantses(List<MerchantsSupplier> merchantses) {
		Merchantses = merchantses;
	}

	public SupplierQueryDto(String resultType, String resultCode,
			String errorMsg, int offset, int pageSize) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
		this.offset = offset;
		this.pageSize = pageSize;
	}

	public SupplierQueryDto(String resultType, String resultCode, int offset,
			int pageSize, List<MerchantsSupplier> merchantses) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.offset = offset;
		this.pageSize = pageSize;
		Merchantses = merchantses;
	}

}
