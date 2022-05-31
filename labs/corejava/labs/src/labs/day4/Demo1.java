package labs.day4;

class Employee{
	String firstName;
	String lastName;
	String emailId;
	public void getFullName() {
		System.out.println(firstName+" "+lastName);
		
	}
}
class FullTimeEmp extends Employee{
		int annualSalary;
	}
class PartTimeEmp extends Employee{
		int hourSalary;
	}

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FullTimeEmp fte =new FullTimeEmp();
		fte.firstName="Mark";
		fte.lastName="Smith";
		
		PartTimeEmp pte =new PartTimeEmp();
		pte.firstName="Paul";
		pte.lastName="Watson";
		
		fte.getFullName();
		pte.getFullName();
		
		
	}

}
