package assignment.arrays;

import java.util.Scanner;

public class RightRotateAnArray {

	public static void main(String[] args) {
		int[] input = {10,20,30,40,50};
		System.out.print("Input Array: ");
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}
		System.out.println();
		System.out.println("For how many elements it has rotate right: ");
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int last=0;
		while(n>0) {
			last=input[input.length-1];
			for(int i=input.length-1;i>0;i--) {
			input[i]=input[i-1];
			}
		input[0]=last;
		n--;
		}
		System.out.println("Right Rotated Array");
		for(int j=0;j<input.length ;j++) {
			System.out.print(input[j]+" ");
		}
		scanner.close();
	}

}
