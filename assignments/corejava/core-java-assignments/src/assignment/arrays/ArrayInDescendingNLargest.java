package assignment.arrays;

public class ArrayInDescendingNLargest {

	public static void main(String[] args) {
		int[] array= {10,52,26,38,45,36};
		int tmp=0;
		System.out.println("Array in Descending Order:");
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]<array[j]) {
					tmp=array[i];
					array[i]=array[j];
					array[j]=tmp;
				}
				
			}
			
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("Largest Number in Array: "+array[0]);
		System.out.println("Second Largest Number: "+array[1]);
		System.out.println("Third Largest Number:"+array[2]);
	
	}

}
