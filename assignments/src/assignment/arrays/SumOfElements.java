package assignment.arrays;

public class SumOfElements {

	public static void main(String[] args) {
		double[] numbers = {100.50,240.44,300.36,445.60};
		double sum=0.0;
		for(double num:numbers) {
			sum=sum+num;
		}
		System.out.println("Sum of all the elements in arrays: "+sum);
	}

}
