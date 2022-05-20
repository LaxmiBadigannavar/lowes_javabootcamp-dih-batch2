package labs.day8;
class Customer{
	public void Display() {
		System.out.println("Displaying");
	}
}
public class Demo9 {

	public static void main(String[] args) {
		
		String str="Mark";
		System.out.println(str);
		
		String str1=null;
		try {
			//System.out.println(str1);
			System.out.println(str1.length());
			
			
			//Customer customer = new Customer();
			//customer.Display();
			
			Customer customer1 =null;
			customer1.Display();
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
