package positive.negative;

import java.util.Scanner;

public class PositiveNegative {	
	public static void main(String[] args){
		display("Enter a number: ");
		getInput();
	}
	
	public static void getInput(){
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		try{
			int test = Integer.parseInt(input);
			
			if(Character.toString(input.charAt(0)).equals("-")){
				if(Integer.parseInt(input.substring(1)) == 0)
					display("Invalid Input");
				else
					display("Negative Number");				
			} else if(test==0)
				display("Zero");
			else
				display("Positive Number");
			
		} catch(Exception e){
			display("Invalid Input");			
		}
		
		getInput();
	}
	
	public static void display(String message){
		System.out.println(message);
	}
}
