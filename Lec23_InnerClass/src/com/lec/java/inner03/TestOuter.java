package com.lec.java.inner03;

public class TestOuter {
	private int value; //outer value 1
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	// inner class
	public class TestInner {
		private int value; //inner value 2

		public TestInner(int value) {
			this.value = value;
		}
		public void printValue() {
			int value = 10; //지역변수 value 3
			System.out.println("3.value= "+value);
			System.out.println("2.value= "+this.value);
			System.out.println("1.value= "+TestOuter.this.value);

		}

	}

} // end class TestOuter














