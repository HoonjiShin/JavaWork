package com.lec.java.class03;

public class Numeric {

	// 멤버변수
	private char ch;
	private byte operator;
	private byte operator1;
	private int opernad2;
	
	//기본 생성자
	public Numeric() {}
	
	//매개변수 있는 생성자
	public Numeric(char ch,byte operator,byte operator1,int opernad2) {
		this.ch =ch;
		this.operator=operator;
		this.operator1=operator1;
		this.opernad2=opernad2;
	}

	public char getCh() {return ch;}
	public byte getOperator() {return operator;}
	public byte getOperator1() {return operator1;}
	public int getOpernad2() {return opernad2;}
	public void setCh(char ch) {this.ch = ch;}
	public void setOperator(byte operator) {this.operator = operator;}
	public void setOperator1(byte operator1) {this.operator1 = operator1;}
	public void setOpernad2(int opernad2) {this.opernad2 = opernad2;}

	}
