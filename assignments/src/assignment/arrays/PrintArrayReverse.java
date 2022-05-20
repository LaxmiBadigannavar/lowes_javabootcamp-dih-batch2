package assignment.arrays;

public class PrintArrayReverse {

	public static void main(String[] args) {
		int[] input = {10,20,30,40,50};
		System.out.println("Original the Array: ");
		for(int j:input) {
			System.out.print(j+" ");
		}
		System.out.println();
		System.out.println("*******************************");
		System.out.println();
		System.out.println("Print the Array in reverse order: ");
		//System.out.println(input.length);
		for(int i=input.length-1;i>=0;i--) {
			System.out.print(input[i]+" ");
		}


	}

}
