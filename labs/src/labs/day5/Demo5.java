package labs.day5;

public class Demo5 {

	public static void main(String[] args) {
		String s1="Mark";
		String s2="Mark";
		String s3="Paul";
		String s4="PAUL";
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		System.out.println(s3.compareTo(s1));
		System.out.println(s3.compareTo(s4));
		System.out.println(s3.compareToIgnoreCase (s4));
		

	}

}
