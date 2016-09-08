package com.icloud.dto;

import java.util.ArrayList;
import java.util.List;

import com.icloud.model.MerchantsMp;

public class QueryMpResponseDto {

	private String resultType;
	private String resultCode;
	private String errorMsg;
	private int offset = 1;
	private int pageSize = 10;
	private List<MerchantsMp> mp = new ArrayList<MerchantsMp>();

	public QueryMpResponseDto() {
		super();
	}

	public QueryMpResponseDto(String resultType, String resultCode, String errorMsg) {
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}

	public QueryMpResponseDto(String resultType, String resultCode, String errorMsg, int offset, int pageSize) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
		this.offset = offset;
		this.pageSize = pageSize;
	}

	public QueryMpResponseDto(String resultType, String resultCode, int offset, int pageSize, List<MerchantsMp> mp) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.offset = offset;
		this.pageSize = pageSize;
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

	public List<MerchantsMp> getMp() {
		return mp;
	}

	public void setMp(List<MerchantsMp> mp) {
		this.mp = mp;
	}

}
