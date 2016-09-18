package com.merchant.dto;

import java.util.ArrayList;
import java.util.List;

import com.merchant.model.MerchantsMessage;

/**
 * 列表查询结果dto
 * @author luoqw 
 * 2016-9-7上午10:11:30
 * @param <T>
 */
public class BaseQueryDto<T> {
	
	private String resultType;
	private String resultCode;
	private String errorMsg;
	private int offset = 1;
	private int pageSize = 10;
	private List<T> list = new ArrayList<T>();

	public BaseQueryDto(String resultType, String resultCode, String errorMsg, int offset, int pageSize) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
		this.offset = offset;
		this.pageSize = pageSize;
	}
	

	public BaseQueryDto(String resultType, String resultCode, int offset, int pageSize, List<T> list) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.offset = offset;
		this.pageSize = pageSize;
		this.list = list;
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

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
