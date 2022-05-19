package labs.day7;

public class Demo1 {
	static void minNumber(int numbs[]) {
		int min = numbs[0];
		for (int i=1;i<numbs.length;i++) {
			if(min>numbs[i]){
				min=numbs[i];
			}	
		}
		System.out.println("minimum number in the arrays is: "+min);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {9,2,5,4};
		minNumber(a);
	}

}
 