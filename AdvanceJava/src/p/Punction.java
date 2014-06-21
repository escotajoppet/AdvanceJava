package p;

import java.util.Scanner;

public class Punction {
//	public static void main(String[] args){
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Enter Number: ");
//		int input = scan.nextInt();
//		
//		int result = 0;
//		int[] arrayResult1 = {5, 9, 6, 3, 2, 1, 4, 8, 7};
//		int[] arrayResult2 = {5, 9, 6, 3, 2, 1, 4, 8, 7};
//		int[] arrayResult3 = {5, 9, 6, 3, 2, 1, 4, 8, 7};
//		int[] arrayResult4 = {5, 9, 6, 3, 2, 1, 4, 8, 7};
//
//		result = factorialI(input);
//		System.out.println(result);
//
//		result = factorialR(input);
//		System.out.println(result);
//
//		result = fibonacciI(input);
//		System.out.println(result);
//
//		result = fibonacciR(input);
//		System.out.println(result);
//		
//		System.out.println();
//		
//		arrayResult1 = sortA(arrayResult1);
//		for (int i = 0; i < arrayResult1.length; i++) {
//			System.out.println(arrayResult1[i]);
//		}
//		
//		System.out.println();
//		
//		arrayResult2 = sortAA(arrayResult2);
//		for (int i = 0; i < arrayResult2.length; i++) {
//			System.out.println(arrayResult2[i]);
//		}
//		
//		System.out.println();
//		
//		arrayResult3 = sortD(arrayResult3);
//		for (int i = 0; i < arrayResult3.length; i++) {
//			System.out.println(arrayResult3[i]);
//		}
//		
//		System.out.println();
//		
//		arrayResult4 = sortDD(arrayResult4);
//		for (int i = 0; i < arrayResult4.length; i++) {
//			System.out.println(arrayResult4[i]);
//		}
//	}
	
	public int factorialI(int num){
		int res = 1;
		
		if(num==1)
			return 1;
		else{
			for(int i = 1; i<=num; i++){
				res *= i; 
			}
		}			
		
		return res;
	}
	
	public int factorialR(int num){		
		return num==1 ? 1 : num * factorialR(num-1);
	}
	
	public int fibonacciI(int num){
		int num1 = 0;
		int num2 = 1;
		int res = 0;
		
		if(num<2)
			return 1;
		else{
			for(int i = 0; i<num; i++){
				res = num1 + num2;
				num2 = num1;
				num1 = res;
			}
		}			
		
		return res;
	}
	
	public int fibonacciR(int num){		
		return num<2 ? num : fibonacciR(num-1) + fibonacciR(num-2);		
	}
	
	public int[] sortA(int[] num){
		int temp = 0;
		
		for(int i = 0; i<num.length; i++){
    		for(int j = num.length-1; j>i; j--){
    			if(num[j] < num[j-1]){
    				temp = num[j];
    				num[j] = num[j-1];
    				num[j-1] = temp;
    			}
    		}
    	}
		
		return num;
	}
	
	public int[] sortD(int[] num){
		int temp = 0;
		
		for(int i = 0; i<num.length; i++){
    		for(int j = num.length-1; j>i; j--){
    			if(num[j] > num[j-1]){
    				temp = num[j];
    				num[j] = num[j-1];
    				num[j-1] = temp;
    			}
    		}
    	}
		
		return num;
	}
	
	public int[] sortDD(int[] num){
		int temp = 0;
		
		for(int i = 0; i<num.length; i++){
			for(int j = 0; j<num.length; j++){
				if(num[i] > num[j]){
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
		return num;
	}
	
	public int[] sortAA(int[] num){
		int temp = 0;
		
		for(int i = 0; i<num.length; i++){
			for(int j = 0; j<num.length; j++){
				if(num[i] < num[j]){
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
		return num;
	}
}