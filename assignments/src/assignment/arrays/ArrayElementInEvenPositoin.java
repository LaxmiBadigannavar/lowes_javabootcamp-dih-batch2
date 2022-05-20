package assignment.arrays;

public class ArrayElementInEvenPositoin {

	public static void main(String[] args) {
		int array[]= {10,20,30,40,50,60,70,80,90};
		int i=0;
		System.out.println("Elements in even position: ");
		while(i<array.length) {
			System.out.print(array[i]+" ");
			i=i+2;
		}

	}

}
