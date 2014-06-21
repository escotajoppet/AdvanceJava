package numbers.to.words;

public abstract class Convert {
	private static int numberLength = 0;
	private static String convToWords = "";
	
	public static int getNumberLength() {
		return Convert.numberLength;
	}

	public static void setNumberLength(int numberLength) {
		Convert.numberLength = numberLength;
	}

	public static void converToWords(String numbers){
		int num = Integer.parseInt(numbers);
		numbers = Integer.toString(num);
		
		String toWords = "";
		setNumberLength(numbers.length());;
		
		switch (getNumberLength()) {
			case 1:
				toWords = oneDigit(numbers);
				break;
			case 2:			
				toWords = twoDigits(numbers);
				break;
			case 3:			
				toWords = threeDigits(numbers);
				break;
			case 4:			
				toWords = fourDigits(numbers);
				break;
			case 5:			
				toWords = fiveDigits(numbers);
				break;
			case 6:			
				toWords = sixDigits(numbers);
				break;
			case 7:		
				toWords = sevenDigits(numbers);
				break;
			case 8:			
				break;
			case 9:			
				break;
			case 10:			
				break;
			default:
				break;
		}
		
		System.out.println("Words: " + toWords.trim());
	}
	
	public static String oneDigit(String numbers){
		int num = Integer.parseInt(numbers);
		
		switch(num){
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
			default:
				if(getNumberLength()>1)
					return "";
				else
					return "zero";
		}
	}
	
	public static String twoDigits(String numbers){
		int secondDigit = Integer.parseInt(Character.toString(numbers.charAt(0)));
		int firstDigit = Integer.parseInt(Character.toString(numbers.charAt(1)));
		
		String pre = "";
		String post = "";
		
		if(secondDigit>1){
			switch(secondDigit){
				case 2:
					pre = "twenty";
					break;
				case 3:
					pre = "thirty";
					break;
				case 4:
					pre = "fourty";
					break;
				case 5:
					pre = "fifty";
					break;
				case 6:
					pre = "sixty";
					break;
				case 7:
					pre = "seventy";
					break;
				case 8:
					pre = "eighty";
					break;
				case 9:
					pre = "ninety";
					break;
			}
			
			post = oneDigit(Character.toString(numbers.charAt(1)));
		
		} else {
			if(secondDigit==0){
				pre = oneDigit(numbers);
			} else{
				switch (firstDigit) {
					case 1:			
						pre = "eleven";
						break;
					case 2:				
						pre = "twelve";
						break;
					case 3:				
						pre = "thirteen";
						break;
					case 4:				
						pre = "fourteen";
						break;
					case 5:				
						pre = "fifteen";
						break;
					case 6:				
						pre = "sixteen";
						break;
					case 7:				
						pre = "seventeen";
						break;
					case 8:				
						pre = "eighteen";
						break;
					case 9:				
						pre = "nineteen";
						break;
					case 0:
						pre = "ten";
						break;
				}
			}
		}
		
		convToWords = pre.trim() + " " + post.trim();
		return convToWords.trim();
	}
	
	public static String threeDigits(String numbers){
		int thirdDigit = Integer.parseInt(Character.toString(numbers.charAt(0)));
		
		String pre = "";
		String post = "";
		
		pre = oneDigit(Integer.toString(thirdDigit)) + (thirdDigit<1 ? "" : " hundred");
		post = twoDigits(numbers.substring(1));
		
		convToWords = pre.trim() + " " + post.trim();
		return convToWords.trim();
	}
	
	public static String fourDigits(String numbers){
		int fourthDigit = Integer.parseInt(Character.toString(numbers.charAt(0)));
		
		String pre = "";
		String post = "";
		
		pre = oneDigit(Integer.toString(fourthDigit)) + " thousand";
		post = threeDigits(numbers.substring(1));
	
		convToWords = pre.trim() + " " + post.trim();
		return convToWords.trim();
	}

	public static String fiveDigits(String numbers){
		int fifthFourthDigit =  Integer.parseInt(numbers.substring(0, 2));
		
		String pre = "";
		String post = "";
		
		pre = twoDigits(Integer.toString(fifthFourthDigit)) + " thousand";
		post = threeDigits(numbers.substring(2));

		convToWords = pre.trim() + " " + post.trim();
		return convToWords.trim();
	}
	
	public static String sixDigits(String numbers){
		int sixthFifthFourthDigit =  Integer.parseInt(numbers.substring(0, 3));
		String pre = "";
		String post = "";
		
		switch(Integer.toString(sixthFifthFourthDigit).length()){
			case 1:
				pre = oneDigit(Integer.toString(sixthFifthFourthDigit));
				break;
			case 2:
				pre = twoDigits(Integer.toString(sixthFifthFourthDigit)) + " thousand";
				break;
			case 3:
				pre = threeDigits(Integer.toString(sixthFifthFourthDigit)) + " thousand";
				break;
			default:
				pre = "";
				break;
		}
		
		post = threeDigits(numbers.substring(3));
		
		convToWords = pre.trim() + " " + post.trim();
		return convToWords.trim();
	}
	
	public static String sevenDigits(String numbers){
		int seventh =  Integer.parseInt(Character.toString(numbers.charAt(0)));
		
		String pre = "";
		String post = "";
		
		pre = oneDigit(Integer.toString(seventh)) + " million";
		post = sixDigits(numbers.substring(1));
		
		convToWords = pre.trim() + " " + post.trim();
		return convToWords.trim();
	}
}
