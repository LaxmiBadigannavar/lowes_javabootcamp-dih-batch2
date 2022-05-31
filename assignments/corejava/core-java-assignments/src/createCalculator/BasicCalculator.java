package createCalculator;
import java.util.Scanner;

public class BasicCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First number: ");
		double firstNumber = sc.nextDouble();
		
		System.out.println("Enter Second number: ");
		double secNumber = sc.nextDouble();
		
		System.out.println("Select: ");
		System.out.println("1 :Add");
		System.out.println("2 :Substrct");
		System.out.println("3 :Multiply");
		System.out.println("4 :Divide");
		
		double ans=0;
		int selected = sc.nextInt();
		switch(selected){
			case 1:
					ans=firstNumber+secNumber;
					break;
					
			case 2:
					ans=firstNumber-secNumber;
					break;
					
			case 3:
					ans=firstNumber*secNumber;
					break;
					
			case 4:	
					ans=firstNumber/secNumber;
					break;
								
			default: 
					System.out.println("Not in the list");
					break;
				
		}
		System.out.println("Result is: "+ans);
	}

}
