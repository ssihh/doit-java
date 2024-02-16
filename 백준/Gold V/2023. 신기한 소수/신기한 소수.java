import java.util.*;
import java.io.*;

class Main {

	public static int n;

	public static void DFS(int jari, int num) {
		if (jari == n) { // n 인자값 사용
			System.out.println(num);
			return;
		}

		for (int i = 1; i < 10; i += 2) { // 2씩증가 홀수
			if (isPrime(num * 10 + i)) {
				DFS(jari + 1, num * 10 + i);
			}
		}
	}

	public static boolean isPrime(int num) {

		// 나눌 범위 초기값 0,1이면 다 나눠지니까 안댐! 2부터
		for (int i = 2; i <= Math.sqrt(num); i++) { // 제곱근이하<=까지
			if (num % i == 0) {
				return false; // 나눠지면 소수아님 false
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Reader 3
		StringTokenizer st = new StringTokenizer(br.readLine()); // 왜 빨간줄? IOException 아하

		n = Integer.parseInt(st.nextToken());

		DFS(1, 2);
		DFS(1, 3);
		DFS(1, 5);
		DFS(1, 7);

	}
}
