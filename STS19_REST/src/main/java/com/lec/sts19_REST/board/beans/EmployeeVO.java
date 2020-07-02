package com.lec.sts19_REST.board.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee") //<employee>라는 태그로 전체 클래스가 정의됨.
public class EmployeeVO {
	
	@XmlAttribute
	private Integer id; //id 라는 attribute
	
	@XmlElement
	private String name; //<name> 라는 element
	
	@XmlElement
	private int age; //<age> 라는 element
	
	@XmlElement
	private int [] score; // <score> 라는 elements
	
	//annotaion이 없으면 xml에 포함x
	private double point;
	
	public EmployeeVO() {
		super();
	}

	public EmployeeVO(Integer id, String name, int age, int[] score, double point) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.point = point;
	}
	
	//getter만 제공: read-only 속성, immutable
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int[] getScore() {
		return score;
	}
	public double getPoint() {
		return point;
	}
	
	
}
