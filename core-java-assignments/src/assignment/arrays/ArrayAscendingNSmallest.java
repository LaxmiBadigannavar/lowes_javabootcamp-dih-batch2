package assignment.arrays;
//Program to sort array in ascending order and print Smallest number*/
public class ArrayAscendingNSmallest {

	public static void main(String[] args) {
		int[] array= {10,52,26,38,45,36};
		int tmp=0;
		System.out.println("Array in Ascending Order:");
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]) {
					tmp=array[i];
					array[i]=array[j];
					array[j]=tmp;
				}
				
			}
			
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("Smallest Number in Array: "+array[0]);
		System.out.println("Second Smallest Number:"+array[1]);
	}

}
