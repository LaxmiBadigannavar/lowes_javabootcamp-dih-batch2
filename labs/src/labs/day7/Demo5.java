package labs.day7;

public class Demo5 {

	public static void main(String[] args) {
		char[] srcArray = {'h','e','l','l','o'};
		char[] destnArray=new char[5];
		System.arraycopy(srcArray, 0, destnArray, 0, 5);
		System.out.println(String.valueOf(destnArray));
		

	}

}
