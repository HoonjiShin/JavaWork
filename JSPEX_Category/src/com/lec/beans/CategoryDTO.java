package com.lec.beans;

public class CategoryDTO {
	private int ca_uid;
	private String ca_name;
	private int ca_depth;
	private int ca_parent;
	private int ca_order;
	
	public CategoryDTO() {
		super();
	}

	public CategoryDTO(int ca_uid, String ca_name, int ca_depth, int ca_parent, int ca_order) {
		super();
		this.ca_uid = ca_uid;
		this.ca_name = ca_name;
		this.ca_depth = ca_depth;
		this.ca_parent = ca_parent;
		this.ca_order = ca_order;
	}

	public int getCa_uid() {
		return ca_uid;
	}

	public void setCa_uid(int ca_uid) {
		this.ca_uid = ca_uid;
	}

	public String getCa_name() {
		return ca_name;
	}

	public void setCa_name(String ca_name) {
		this.ca_name = ca_name;
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

	public int getCa_order() {
		return ca_order;
	}

	public void setCa_order(int ca_order) {
		this.ca_order = ca_order;
	}
	
	
	
}
