package trip.practice;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter you input: ");
		String input = scan.nextLine();
		
		WordPalindrome wpObj = new WordPalindrome(input);
	}
}
