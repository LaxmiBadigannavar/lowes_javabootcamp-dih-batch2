package assignment.arrays;

import java.util.Scanner;

public class LeftRotateAnArray {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7};
		System.out.println("Input array");
		for(int in:input) {
			System.out.print(in+" ");
		}
		System.out.println();
		int[] output=new int[input.length];
		Scanner sc =new Scanner(System.in);
		System.out.println("For how many elements it has to rotate left: ");
		int divideBy=sc.nextInt();
		int rotationPoint = divideBy;
		int i=0;
		while(rotationPoint<input.length) {
			output[i]=input[rotationPoint];
			i++;
			rotationPoint++;
		}
		rotationPoint=0;
		while(rotationPoint<divideBy) {
			output[i]=input[rotationPoint];
			i++;
			rotationPoint++;
		}
		System.out.println("Left Rotated Array: ");
		for(int k:output) {
			System.out.print(k+" ");
		}	
		sc.close();
	}
}
