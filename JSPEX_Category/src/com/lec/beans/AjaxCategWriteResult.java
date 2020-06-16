package com.lec.beans;

public class AjaxCategWriteResult {
	private int count;   // 데이터 개수
	private String status;  // 처리 결과
	
	public AjaxCategWriteResult() {}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
