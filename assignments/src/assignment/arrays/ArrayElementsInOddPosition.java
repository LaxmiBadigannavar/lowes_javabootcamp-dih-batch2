package assignment.arrays;

public class ArrayElementsInOddPosition {

	public static void main(String[] args) {
		int array[]= {10,20,30,40,50,60,70,80,90};
		int i=1;
		System.out.println("Elements in odd position: ");
		while(i<array.length) {
			System.out.print(array[i]+" ");
			i=i+2;
		}


	}

}
