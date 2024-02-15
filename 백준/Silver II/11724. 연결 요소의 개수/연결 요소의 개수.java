import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] a; // 인접리스트
	static boolean[] visited; // 방문체크 초기값 false 소문자 b,

	public static void main(String[] args) throws IOException {
		// 들어오는 데이터가 많을 때는 Scanner보다 br이 시간복잡도에서 유리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter사용
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
//		int n = Integer.parseInt(br.readLine()); //br만 선언해서 한줄씩

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		a = new ArrayList[n + 1]; // 인접리스트 선언 괄호 파악
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) { // 인접리스트 초기화하기
			a[i] = new ArrayList<Integer>();
		}

		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
			a[e].add(s);

		}

		int answer = 0;
		for (int k = 1; k < n + 1; k++) {
			if (!visited[k]) {
				answer++;
				DFS(k);
			}
		}

		System.out.println(answer);

	}

	private static void DFS(int v) {
		// TODO Auto-generated method stub
		if (visited[v]) {
			return; // 이미 방문한거면 패스 빠져나가
		}

		visited[v] = true;
		for (int i : a[v]) {
			DFS(i);
		}
	}

}