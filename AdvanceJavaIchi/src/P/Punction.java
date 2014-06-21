package P;

public class Punction {
	
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
		if(num==1)
			return 1;
		else
			return num * factorialR(num-1);
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
		if(num==0 || num==1)
			return num;
		else
			return fibonacciR(num-1) + fibonacciR(num-2);
		
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