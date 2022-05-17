package labs.day4;
class A1{
	public void test1() {
		
	}
	
}
class B extends A1{
	public void test2() {
		
	}
}
class C extends B{
	public void test3() {
		
	}
}

public class Demo3 {

	public static void main(String[] args) {
	A1 a =new A1();
	a.test1();
	
	B b= new B();
	b.test1();
	b.test2();
	
	C c=new C();
	c.test1();
	c.test2();
	c.test3();
		
	}

}
