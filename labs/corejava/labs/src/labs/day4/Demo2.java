package labs.day4;


class Parent{
	public void parentMethod() {}
}
class Child extends Parent{
	public void childMethod() {}
}
public class Demo2 {
	public static void main(String[] args) {
		Parent p= new Parent();
		p.parentMethod();
		
		Child c= new Child();
		c.childMethod();

	}

}
