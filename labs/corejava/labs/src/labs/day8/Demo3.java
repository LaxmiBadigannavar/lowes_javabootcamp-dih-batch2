package labs.day8;
class InsufficientFundException extends Exception{
	public InsufficientFundException() {
		System.out.println("Insuffient Amount");
		
	}
}
class Bank{
	private int balance=10000;
	public void deposit(int amount) {
		balance = balance+amount;
	}
	public void withDraw(int amount)throws InsufficientFundException {
		 	if(amount<balance) {
		 		balance = balance-amount;
		 	}
		 	else {
		 		throw new InsufficientFundException();
		 	}
	}
	
}
public class Demo3 {

	public static void main(String[] args) throws InsufficientFundException {
		// TODO Auto-generated method stub
		Bank b1=new Bank();
		b1.deposit(10000);
		try {
			b1.withDraw(15000);
		}
		catch(InsufficientFundException exp) {
			System.out.println("Insufficient fund");
		}

	}

}
