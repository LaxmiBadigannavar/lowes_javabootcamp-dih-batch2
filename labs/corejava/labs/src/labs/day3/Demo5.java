package labs.day3;

class Book{
	public String title;
	public String author;
	public int price;
	
	public void printBookInfo() {
		System.out.println("Title: "+ title + " Author: "+author+" Price: "+price);
	}
}
public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book bookobj1 = new Book();
		bookobj1.title="Learn Java in 21 Days";
		bookobj1.author="abc";
		bookobj1.price=100;
		
		Book bookobj2 = new Book();
		bookobj2.title="Learn c in 21 Days";
		bookobj2.author="xyz";
		bookobj2.price=200;
		
		bookobj1.printBookInfo();
		bookobj2.printBookInfo();

		
	}

}
