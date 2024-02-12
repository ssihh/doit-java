import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());

		// 인접리스트
		a = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		// 방문 배열
		visited = new boolean[n + 1];

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);

	}

	private static void DFS(int num, int jari) {
		if (jari == n) {
			System.out.println(num);
		}

		for (int i = 1; i <= 9; i++) {
			if (i % 2 != 0 && isPrime(num * 10 + i)) {
				DFS(num * 10 + i, jari + 1);
			}
		}

	}

	private static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;

	}

}
