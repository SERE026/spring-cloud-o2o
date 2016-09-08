package com.merchant.dto;

public class PageResponseDto extends BaseResponseDto{

	private Integer offset;
	private Integer pageSize;
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
}
