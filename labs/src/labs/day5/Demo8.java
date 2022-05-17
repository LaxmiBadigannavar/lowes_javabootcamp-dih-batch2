package labs.day5;

public class Demo8 {

	public static void main(String[] args) {
		String message="Welcome to Java training";
		System.out.println(message.substring(0,7));	
		
		System.out.println("Original String: "+message);
		System.out.println("Subsring string from index 7: "+message.substring(7));
		System.out.println("Subsring string from index 0 to 7: "+message.substring(0,7));
		
		String str = "Welcome Home";
		System.out.println("Original message: "+str);
		System.out.println("Substring from index 8: "+str.substring(8));
		
	}

}
