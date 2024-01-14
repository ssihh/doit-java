import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 두줄만 받잖어 그땐 Scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] s = new int[n+1];

		for (int i = 1; i <= n; i++) {
			s[i] = i; //2=1+1 
		}
		// 1,2,3, 4, 5, 6, 7, 8, 9,10

		int sindex = 1;
		int eindex = 1;
		int sum =1;
		int c = 1;
		
		while(eindex!=n) {
			if(sum==n) {
				eindex++; 
				sum+=s[eindex];
				c++;
			}
			else if(sum<n){
				eindex++; 
				sum+=s[eindex];
			}
			else if(sum>n) {
				sum-=s[sindex];
				sindex++; //뺀다음에 ++해야하니 뒤로
			}
		}


		System.out.println(c);

	}
}