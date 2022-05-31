package labs.day6;

public class Demo2 {

	public static void main(String[] args) {
		
		StringBuffer sb= new StringBuffer("Hello");
		System.out.println(sb);
		
		//append
		sb.append("World");
		System.out.println("string appended: "+sb);
		
		//insert
		sb.insert(0,"world");
		System.out.println("String inserted: "+sb);

		//replace
		sb.replace(0, 3,"012345");
		System.out.println("String Replace: "+sb);
		
		//delete
		sb.delete(1, 3);
		System.out.println("String delete: "+sb);

		
		//reverse
		sb.reverse();
		System.out.println("String reversed: "+sb);
	}

}
