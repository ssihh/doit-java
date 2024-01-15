import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 두줄만 받잖어 그땐 Scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}

		Arrays.sort(s);
		
		int c=0;
		for(int i=0; i<n; i++) {
			int k=s[i];
			int a=0;
			int b=n-1;
			while(a<b) {
				if(s[a]+s[b] < k) {
					a++;
				}
				else if(s[a]+s[b] >k) {
					b--;
				}else {
					if(a!=i && b!=i) {
						c++;
						break;
					}
					
					if(a==i) {
						a++;
					}
					else if(b==i) {
						b--;
					}
					//k가 4일때: 0, 1, 3, 4 
				}
			}	
		}		

		
		System.out.println(c);

	}
}