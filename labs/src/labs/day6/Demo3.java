package labs.day6;

public class Demo3 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());
		
		sb.append("Hello");
		System.out.println(sb.capacity());
		
		sb.append("Welcome to Java class");
		System.out.println(sb.capacity());
	}

}
