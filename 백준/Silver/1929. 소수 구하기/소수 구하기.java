import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {


		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[m+1];
		

		for(int i=0; i<=m; i++) {
			arr[i] = i;
		}
		arr[1]=0;
		
		for(int j=2; j<=m/2 ; j++) {
			if(arr[j]!=0) {
				int now = arr[j];
				for(int k=now+now; k<=m ; k+=now) {
					arr[k]=0;
				}
			}
		}
		
		for(int l=n; l<=m; l++) {
			if(arr[l]!=0) {
				System.out.println(arr[l]);
			}
		}
		

	}



}