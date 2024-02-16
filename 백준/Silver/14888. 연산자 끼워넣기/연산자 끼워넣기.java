import java.util.*;
import java.io.*;

class Main {

	public static int n;
	public static int[] number, oper;
	public static int max = -1000000000, min = 1000000000;

	public static void DFS(int idx, int num) {
		if (idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) { // 연산자 4종류만큼 +, -, *, /

			if (oper[i] > 0) { // 연산자 개수가 남아있을 때
				
				oper[i]--; //연산자 사용 
				switch (i) {
				case 0:
					DFS(idx + 1, num + number[idx]);
					break;
				case 1:
					DFS(idx + 1, num - number[idx]);
					break;
				case 2:
					DFS(idx + 1, num * number[idx]);
					break;
				case 3:
					DFS(idx + 1, num / number[idx]);
					break;
				// idx+1 값이 가니까 다음 숫자를 활용한 계산 가능
				}
				oper[i]++;// 빼준곳에서 다시 ++원복
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		//전역변수 n을 써야디
		
		number = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int s = Integer.parseInt(st.nextToken());
			number[i] = s;
		}

		oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) { // 4개자나!!!
			int o = Integer.parseInt(st.nextToken());
			oper[i] = o;
		}

		DFS(1, number[0]);

		System.out.println(max);
		System.out.println(min);

	}
}
