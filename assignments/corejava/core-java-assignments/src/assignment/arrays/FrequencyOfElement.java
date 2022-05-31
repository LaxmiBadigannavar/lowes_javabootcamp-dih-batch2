package assignment.arrays;
//Program to find the frequency of each element in the array
//&&
//program to print duplicate elements of an array
//&&
//Program to remove duplicate elements from the array

public class FrequencyOfElement {

	public static void main(String[] args) {
		int a[]= {1,2,8,3,2,5,6,5,6,5,1};
		int b[]= new int[a.length];
		int visited=-1;
		
		for(int i=0;i<a.length;i++) {
			int count=1;
			for(int j=i+1;j<a.length;j++) {
				if((a[i]==a[j])) {
					count++;
					b[j]=visited;
				}
			}
				if(b[i]!=visited) 
					b[i]=count;
		}
		System.out.println("-----------------------------------");
		System.out.println("Element| Frequency");
		System.out.println("-----------------");
		
		for(int i=0;i<b.length;i++) {
			if(b[i]!=visited) 
				System.out.println(" "+a[i]+"       "+b[i]);
		}
		System.out.println("----------------------");
		System.out.println();
		
		
		//printing duplicates of an array
		System.out.println(" Duplicate Elements in the array:");
		for(int k=0;k<b.length;k++) {
				if((b[k]!=visited) && b[k]>1) {
				System.out.print(a[k]+"  ");
			}	
		}
		
		//Removing duplicate elements from the array
		System.out.println();
		System.out.println();
		System.out.println("Removing duplicate elements from the array::");
		System.out.println("############################");
		int output[]=new int[a.length];
		int count=0;
		for(int i=0;i<b.length;i++) {
			if(b[i]==1) {
				output[count]=a[i];
				count++;
			}
		}
		for (int i=0;i<a.length;i++) {
			System.out.print(output[i] +"  ");
		}

}
}
