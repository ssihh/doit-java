import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		// readLine(): 예제 첫번째줄을 읽어왔다
		int n = Integer.parseInt(stringTokenizer.nextToken()); // 첫번째값
		int m = Integer.parseInt(stringTokenizer.nextToken()); // 두번째값 받아옴

		long[][] s = new long[n + 1][n + 1]; // 숫자데이터 long형. 0번째 데이터 무시하고 바로바로받기

		for (int i = 1; i <= n; i++) {
			stringTokenizer = // 한줄 쭉 읽어오고싶을때 stringTokenizer
					new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= n; j++) {

					s[i][j] = s[i - 1][j] + s[i][j - 1] + Integer.parseInt(stringTokenizer.nextToken()) - s[i-1][j-1];

			}
		}

		for (int k = 0; k < m; k++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x1 = Integer.parseInt(stringTokenizer.nextToken());
			int y1 = Integer.parseInt(stringTokenizer.nextToken());
			int x2 = Integer.parseInt(stringTokenizer.nextToken());
			int y2 = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1]);

		}

	}
}