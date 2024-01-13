import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 두줄만 받잖어 그땐 Scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		long[] s = new long[n];
		s[0] = sc.nextInt() % m;

		for (int i = 1; i < n; i++) {
			s[i] = (s[i - 1] + sc.nextInt()) % m;
		}

		long[] c = new long[m];

		for (int j = 0; j < n; j++) {
			c[(int)s[j]]++;
		}

		long answer = c[0]; //c*c연산에서 오버플로우 발생가능
		for (int k = 0; k < m; k++) {
			if (c[k] > 1) { // 나머지의 값이 같은데 2개이상일때
				answer += (c[k] * (c[k] - 1)) / 2;
			}
		}

		System.out.println(answer);

	}
}