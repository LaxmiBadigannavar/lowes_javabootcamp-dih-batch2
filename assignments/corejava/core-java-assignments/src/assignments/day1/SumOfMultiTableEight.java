package assignments.day1;

public class SumOfMultiTableEight {

	public static void main(String[] args) {
		int n=8,multi=1,sum=0;
		System.out.println("table of "+n);
		for(int i=1;i<=10;i++) {
			multi=n*i;
			System.out.println(multi);
			sum=sum+multi;
		}
		System.out.println("Sum of addition of table 8 is "+sum);
	}
}