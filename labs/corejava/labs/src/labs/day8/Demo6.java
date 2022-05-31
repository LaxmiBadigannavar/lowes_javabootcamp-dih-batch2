package labs.day8;

public class Demo6 {

	public static void main(String[] args) {
		//case1: Exception not occured
		try {
			int c=10/5;
			System.out.println(c);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Finally called");
		}
		//case2: Exception  occured but not handled
		try {
			int c=10/0;
			System.out.println(c);
		}finally {
			System.out.println("Finally called");
		}
		
		//case3: Exception  occured and handled

		
		try {
			int c=10/0;
			System.out.println(c);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Finally called");
		}

	}

}
