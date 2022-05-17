package labs.day5;

import java.util.Arrays;

public class Demo9 {

	public static void main(String[] args) {
		String email = "mark@gmail.com";
		String[] result = email.split("@");
		System.out.println(Arrays.toString(result));
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}
