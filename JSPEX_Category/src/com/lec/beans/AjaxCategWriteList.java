package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxCategWriteList extends AjaxCategWriteResult {
	private int ca_depth;
	private int ca_parent;
	
	@JsonProperty("data")
	private List<CategoryDTO> list;  // 데이터 목록
	
	public List<CategoryDTO> getList() {
		return list;
	}
	public void setList(List<CategoryDTO> list) {
		this.list = list;
	}
	public int getCa_depth() {
		return ca_depth;
	}
	public void setCa_depth(int ca_depth) {
		this.ca_depth = ca_depth;
	}
	public int getCa_parent() {
		return ca_parent;
	}
	public void setCa_parent(int ca_parent) {
		this.ca_parent = ca_parent;
	}
	
}