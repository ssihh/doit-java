import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 두줄만 받잖어 그땐 Scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] s = new int[n];
		for(int i =0; i<n;i++) {
			s[i] = sc.nextInt();
		}


		int sum = 0;
		int c = 0;
		
		for(int j=0;j<n-1;j++) {
			for(int k=j+1; k<n; k++) {
				sum = s[j]+s[k];
				if(sum==m) {
					c++;
				}
			}
		}


		System.out.println(c);

	}
}