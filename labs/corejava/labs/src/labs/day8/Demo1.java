package labs.day8;

public class Demo1 {

	public static void main(String[] args) {
		int a=10;
		int b=0;
		int c=0;
		try {
			c=a/b;
		}
		catch(ArithmeticException exp) {
			System.out.println("invalid number");
		}
		System.out.println(c);
	}

}
