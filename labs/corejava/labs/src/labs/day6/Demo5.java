package labs.day6;

public class Demo5 {

	public static void main(String[] args) {
		int a[] = new int[3];//declaration and instantiation
		a[0]=10;
		a[1]=20;
		a[2]=30;
		//a[3]=40;//array index bound exception
		
		for(int i=0;i<3;i++) {
			System.out.println(a[i]);

		}

	}
}