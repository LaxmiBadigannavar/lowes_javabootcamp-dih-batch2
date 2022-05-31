package labs.day8;

class UseAlreayLoggedInException extends Exception{
	public UseAlreayLoggedInException() {
		System.out.println("User already logged in");
	}
}
class Authentication{
	private boolean isLoggedIn=false;
	public void logIn(String email,String password) throws UseAlreayLoggedInException {
		if(!isLoggedIn) {
			if(email.equals("admin")&&password.equals("123")) {
				isLoggedIn=true;
				System.out.println("login sucessfull");
			}	
			else {
				System.out.println("Login failed!,tru again");
			}
		}
		else {
			throw new UseAlreayLoggedInException();
		}
	}
}
public class Demo4 {

	public static void main(String[] args) {
		Authentication auth = new Authentication();
		try {
			auth.logIn("admin", "123");
		}
		catch( UseAlreayLoggedInException e){
			e.printStackTrace();
		}
		
		try {
			auth.logIn("admin", "123");
		}
		catch( UseAlreayLoggedInException e){
			System.out.println("You are already Loggedin");
		}


	}

}
