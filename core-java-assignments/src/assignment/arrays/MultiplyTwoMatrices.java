package assignment.arrays;

public class MultiplyTwoMatrices {

	public static void main(String[] args) {
		int a[][]= {{2,2,2},{3,3,3},{4,4,4}};
		int b[][]= {{2,2,2},{3,3,3},{4,4,4}};
		int c[][]=new int[3][3];
		
		System.out.println("First Matrix:");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Second Matrix:");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Multiplication of Matrices");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				c[i][j]=a[i][j]*b[i][j];
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}

	}

}
