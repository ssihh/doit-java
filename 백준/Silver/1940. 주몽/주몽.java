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

	}
}