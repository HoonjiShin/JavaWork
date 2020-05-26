package com.lec.beans;

/*
 *  DTO : Data Transfer Object
 *  	데이터를 담아 나르기 위한 객체
 *  
 *  게시글 DTO, 회원DTO...등등 필요한 데이터 객체들 만큼 정의
 *  
 *  Bean 객체이다.
 *
 */

public class WriteDTO {
	private int uid;
	private String subject;
	private String content;
	private String name;
	private int viewCnt;
	private String regDate;
	
	/*
	 * 개발시 다음 3가지 네이밍은 일치시켜주는 것이 좋다. 
	 * 클래스 필드명 = DB필드명 = form 의 name 명
	 */
	
	public WriteDTO() {
		super();
	}

	public WriteDTO(int uid, String subject, String content, String name, int viewCnt) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
		
	}

	public int getUid() {
		System.out.println("getuid호출");
		return uid;
	}

	public void setUid(int uid) {
		System.out.println("set("+uid+")호출");
		this.uid = uid;
	}

	public String getSubject() {
		System.out.println("getsubject호출");
		return subject;
	}

	public void setSubject(String subject) {
		System.out.println("setSubject("+subject+")호출");
		this.subject = subject;
	}

	public String getContent() {
		System.out.println("getContent호출");
		return content;
	}

	public void setContent(String content) {
		System.out.println("setContent("+content+")호출");
		this.content = content;
	}

	public String getName() {
		System.out.println("getName호출");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName("+name+")호출");
		this.name = name;
	}

	public int getViewcnt() {
		System.out.println("getViewcnt호출");
		return viewCnt;
	}

	public void setViewcnt(int viewCnt) {
		System.out.println("setViewcnt("+viewCnt+")호출");
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		System.out.println("getRegDate호출");
		return regDate;
	}

	public void setRegDate(String regDate) {
		System.out.println("setRegDate("+regDate+")호출");
		this.regDate = regDate;
	}
	
	//테스트,개발용으로 toString() 오버라이딩 하면 좋다.
	@Override
	public String toString() {
		return "WriteDTO]" + uid + " : " + subject + " : " + content + " : " + name + " : " + viewCnt + " : " + regDate;
	}
	
}
