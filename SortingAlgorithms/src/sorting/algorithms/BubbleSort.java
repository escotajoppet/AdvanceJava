package sorting.algorithms;

public abstract class BubbleSort extends SelectionSort{
	
    public static void SortBubble(int[] numberSet) {
    	int temp = 0;
    	
    	for(int i = 0; i<numberSet.length; i++){
    		for(int j = numberSet.length-1; j>i; j--){
    			if(numberSet[j] < numberSet[j-1]){
    				temp = numberSet[j];
    				numberSet[j] = numberSet[j-1];
    				numberSet[j-1] = temp;
    			}
    		}
    	}
    	
    	System.out.print("\n\nBubble Sort: ");
		for(int i = 0; i<numberSet.length; i++){
			System.out.print(numberSet[i] + " ");			
		}
    }
}
