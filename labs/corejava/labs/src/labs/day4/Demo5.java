package labs.day4;
class Counter{
	static int count;
	public Counter(){
		count++;
		System.out.println(count);
		
	}
}
public class Demo5 {

	public static void main(String[] args) {
		Counter c1= new Counter();
		Counter c2= new Counter();
		Counter c3= new Counter();
	}

}
