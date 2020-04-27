package practice.cardcompany;

public class Company {

	private int cardNumber = 10000;

	private Company() {
	}

	private static Company instance = null;

	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}

	public Card createCard() {
		cardNumber++;

		return new Card(cardNumber);
	}

	// 필요한 변수, 메소드, 생성자 정의하기
		//카드번호 발급 /관리
} // end class
