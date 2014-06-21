package sorting.algorithms;

import java.util.Scanner;

public class MainMethod extends InsertionSort{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String temp = "";
		
		System.out.print("Enter length of array: ");
		temp = scan.nextLine();
		
		int[] numberSet = new int[Integer.parseInt(temp)];
		
		System.out.println("\n\nEnter a set of numbers");
		
		for(int i = 0; i<numberSet.length;i++){
			temp = scan.nextLine();			
			numberSet[i] = Integer.parseInt(temp);
		}
		
		System.out.print("\n\nSet of Numbers: ");
		
		for(int i = 0; i<numberSet.length; i++){
			System.out.print(numberSet[i] + " ");
		}
		
		
		
		SortSelect(numberSet);
		//SortBubble(numberSet);
		//SortInsert(numberSet);
	}
}
