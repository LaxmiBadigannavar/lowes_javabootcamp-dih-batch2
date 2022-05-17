package labs.day3;

class Book2{
	public String title;
	public String author;
	public int price;
	
	public Book2(String title,String author, int price ) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public void printBookInfo() {
		System.out.println("Title: "+ title + " Author: "+author+" Price: "+price);
	}
}

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book2 obj1 = new Book2("Learnn Java","Smith",100);
		obj1.printBookInfo();
		
		Book2 obj2 = new Book2("Learn C","Sam",100);
		obj2.printBookInfo();

	}

}
