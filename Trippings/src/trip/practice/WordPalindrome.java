package trip.practice;

public class WordPalindrome {
	public WordPalindrome(String str){
		String[] strSplit = str.split(" ");
		String[] newStrSplit = new String[strSplit.length];
		int count = 0;
		
		for(int i = strSplit.length-1; i>=0; i--){
			newStrSplit[count] = strSplit[i];
			count++;
		}
		
		for(int i = 0; i<newStrSplit.length; i++){
			System.out.println(newStrSplit[i]);
		}
	}
}
