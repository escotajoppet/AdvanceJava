package numbers.to.words;

import java.util.Scanner;

public class MainNumbersToWords extends Convert{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Your Number: ");
		String numbers = scan.nextLine();
		
		converToWords(numbers);
		System.out.println();
		main(null);
	}
}
