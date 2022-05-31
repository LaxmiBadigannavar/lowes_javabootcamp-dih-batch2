package labs.day2;

class Test{
	int x=10;
	static int y=10;
	public void getNumber() {
		int z=10;
		System.out.println("Local variable:"+z);
	}
	public void foo(){
		System.out.println("instance variable" + x);
		System.out.println("static variable" + y);
	}
}
public class Demo1 {

	public static void main(String[] args) {
		Test test = new Test();
		test.getNumber();
		System.out.println("static variable: "+Test.y);
		
	}

}
