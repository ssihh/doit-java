import java.io.*;
import java.util.*;

class Edge {
	int v;
	int w;

	public Edge(int v, int w) { // public Edge | new Edge(v,w)
		this.v = v;
		this.w = w;
	}
}

public class Main {

	static ArrayList<Edge>[] a;
	static boolean[] visited;
	static int[] distance;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		a = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Edge>(); // new 뉴뉴
		}

		// 입력 마지막 -1일때 다음줄 읽어
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			while (true) {
				int e = Integer.parseInt(st.nextToken());
				if (e == -1) {
					break;
				}
				int w = Integer.parseInt(st.nextToken());
				a[s].add(new Edge(e, w)); // Edge 값 add하는 법
				// a[e].add(new Edge(i, w));

			}
		}

		// 방문 배열, 거리 배열
		visited = new boolean[n + 1];
		distance = new int[n + 1];

		int maxboyu = 1; // 트리의 지름 max 보유 배열[answer] 번째 값

		// BFS실행
		BFS(1);

		for (int i = 2; i <= n; i++) {
			if (distance[maxboyu] < distance[i]) {
				maxboyu = i;
			}
		}

		// 방문 배열, 거리 배열 다시 초기화 하고 BFS
		visited = new boolean[n + 1];
		distance = new int[n + 1];
		BFS(maxboyu);

		Arrays.sort(distance); // ㄷ ㄷ정렬해서 큰값 뒤로 가게하고
		System.out.println(distance[n]); // 그 큰값을 출력해버림

	}

	private static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int crt = q.poll();
			for (Edge i : a[crt]) {
				int iv = i.v;
				int iw = i.w;
				if (!visited[iv]) {
					q.offer(iv);
					visited[iv] = true;
					distance[iv] = distance[crt] + iw;
				}
			}
		}

	}

}
