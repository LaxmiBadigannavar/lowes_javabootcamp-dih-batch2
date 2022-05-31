package labs.day6;

public class Demo6 {

	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6,7};
		System.out.println("For loop: ");
		for (int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println("For each loop: ");
		for (int number:a) {
			System.out.println(number);
		}

	}

}
