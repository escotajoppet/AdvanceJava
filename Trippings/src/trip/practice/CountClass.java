package trip.practice;

import java.util.Scanner;

public class CountClass {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int sm = 0;
		int lg = 0;
		
		display("Enter First Number: ");
		int fNum = Integer.parseInt(scan.nextLine());
		
		display("Enter Second Number: "); 
		int sNum = Integer.parseInt(scan.nextLine());
		
		lg = fNum >= sNum ? fNum : sNum;
		sm = fNum < sNum ? fNum : sNum;
		
		for(int i = lg; i>=sm; i--){
			display(i + " ");
		}
		
		display("\n\n");
		main(null);
	}
	
	public static void display(String message){
		System.out.print(message);
	}
}
