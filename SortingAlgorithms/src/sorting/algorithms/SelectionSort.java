package sorting.algorithms;

public abstract class SelectionSort {
	public static void SortSelect(int[] numberSet){
		int temp = 0;
		int index = 0;
		
		for(int i = 0; i<numberSet.length; i++){
			temp = numberSet[i];		
			
			for(int j = i+1; j<numberSet.length; j++){				
				if(numberSet[j] < temp){
					index = j;
					temp = numberSet[j];
				}
			}

			numberSet[index] = numberSet[i];
			numberSet[i] = temp;	
		}
		
		System.out.print("\n\nSelection Sort: ");
		for(int i = 0; i<numberSet.length; i++){
			System.out.print(numberSet[i] + " ");			
		}
	}
}
