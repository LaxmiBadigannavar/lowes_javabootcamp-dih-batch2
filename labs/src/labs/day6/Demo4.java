package labs.day6;

public class Demo4 {

	public static void main(String[] args) {
		System.out.println("Performance test:");
		long startTime=System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer("Hello");
		for (int i=0;i<=100000;i++) {
			sb.append("World");
		}
		
		System.out.println("Time taken by StringBuffer: "+(System.currentTimeMillis()-startTime)+" ms");
		System.out.println("****************************");
	
		StringBuilder sb1 = new StringBuilder("Hello");
		for (int i=0;i<=100000;i++) {
			sb1.append("World");
		}
		
		System.out.println("Time taken by StringBuilder: "+(System.currentTimeMillis()-startTime)+" ms");
	}

}
