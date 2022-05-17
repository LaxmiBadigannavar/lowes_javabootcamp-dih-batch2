package labs.day4;
class Student{
	public int rollNo;
	public String name;
	static public String schoolName="ABC School";
}
public class Demo4 {

	public static void main(String[] args) {
		Student stud1= new Student();
		stud1.rollNo=1;
		stud1.name="abc";
		
		Student stud2 = new Student();
		stud2.rollNo=2;
		stud2.name="xyz";
		
		System.out.println("RollNo: "+stud1.rollNo+" name "+stud1.name+" School Name "+Student.schoolName);
		System.out.println("RollNo: "+stud2.rollNo+" name "+stud2.name+" School Name "+Student.schoolName);

	}

}
