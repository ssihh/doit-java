import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 두줄만 받잖어 그땐 Scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}

		Arrays.sort(s);

		int si = 0;
		int ei = n - 1;
		int c = 0;

		while (si < ei) {
			if (m > s[si] + s[ei]) {
				si++;
			} else if (m < s[si] + s[ei]) {
				ei--;
			} else {
				c++;
				si++;
				ei--;
			}
		}

		System.out.println(c);

		/* 이것도 맞는데 시간이 쫌더 걸리는듓 모든경우를 다봐서 그런가
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
		*/
		
	}
}
