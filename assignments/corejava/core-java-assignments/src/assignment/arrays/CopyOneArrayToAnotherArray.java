package assignment.arrays;

public class CopyOneArrayToAnotherArray {

	public static void main(String[] args) {
		int[] a = {10,20,30,40,50};
		System.out.println("First array");
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		int[] b = a.clone();
		System.out.println("second array");
		for (int i=0;i<b.length;i++) {
			System.out.print(b[i]+" ");
		}

	}

}
