package sorting.algorithms;

public abstract class InsertionSort extends BubbleSort{
	
	public static void SortInsert(int[] numberSet){
		int temp = 0;		
		
		for(int i = 0; i<numberSet.length;i++){
			for(int j = i; j>=0; j--){
				if(j>0 && numberSet[j] < numberSet[j-1]){					
					temp = numberSet[j];
					numberSet[j] = numberSet[j-1];
					numberSet[j-1] = temp;
				}
			}
		}		
		
		System.out.print("\n\nInsertion Sort: ");
		for(int i = 0; i<numberSet.length; i++){
			System.out.print(numberSet[i] + " ");			
		}
	}
}
