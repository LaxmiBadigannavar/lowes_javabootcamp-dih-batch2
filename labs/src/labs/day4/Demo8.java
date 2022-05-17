package labs.day4;
class A{
	static int a;
	static {
		a=20;
		System.out.println(a);
	}
	public void test() {
		 	System.out.println(a);
	}
}
public class Demo8 {

	public static void main(String[] args) {
	 A obj= new A();
	 obj.test();

	}

}
