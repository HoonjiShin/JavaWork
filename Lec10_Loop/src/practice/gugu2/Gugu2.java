package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {

		for (int dan = 2; dan <= 9; dan += 3) {
			for (int i = 1; i <= 9; i++) {
				int j = 0;
				while (j < 3) {
					if (dan + j == 10)
						break;
					else {
						System.out.print((dan + j) + " x " + i + " = " + ((dan + j) * i) + "\t");
						j++;
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}