import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static boolean arrive;
	static Queue<Integer> q = new LinkedList<>();
	static int n; // 노드수

//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		// 들어오는 데이터가 많을 때는 Scanner보다 br이 시간복잡도에서 유리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter사용
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
//		int n = Integer.parseInt(br.readLine()); //br만 선언해서 한줄씩

//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
		a = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			a[i] = new ArrayList<Integer>();// 인접리스트 초기화하기
		}


		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
			a[e].add(s);
		}

		for (int s = 1; s < n + 1; s++) { //번호가 작은 것을 먼저 방문하기위해 정렬하기
			Collections.sort(a[s]);
		}
		
		DFS(v, 1);
		System.out.print("\n");

		visited = new boolean[n + 1];
		BFS(v, 1);

	}

	private static void DFS(int v, int depth) {
		// TODO Auto-generated method stub

		visited[v] = true;
		System.out.print(v + " ");

		for (int i : a[v]) {
			if (!visited[i]) { // i: 인접리스트 a[i]노드와 연결된 '노드'
				DFS(i, depth + 1);

			}
		}

//		visited[v] = false; //역으로 빠져나올 때 노드를 false
		// 끝까지 가거나 이미 방문한 노드에서 뒤로 빠져나올 때 false로 바꿔줌

	}
	
	private static void BFS(int v, int b) {
		// TODO Auto-generated method stub
		q.offer(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");

			for (int i : a[now]) {
				if (!visited[i]) {
					q.offer(i);
					visited[i] = true;
				}

			}
		}

	}

}