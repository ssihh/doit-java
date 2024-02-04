import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; // 상하좌우 탐색위한 배열선언
	static boolean[][] visited; // 방문도 차원
	static int[][] a;
	static int n, m;

//	static boolean arrive;
	static Queue<Integer> q = new LinkedList<>();

//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		// 들어오는 데이터가 많을 때는 Scanner보다 br이 시간복잡도에서 유리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter사용
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
//		int v = Integer.parseInt(st.nextToken());
//		int n = Integer.parseInt(br.readLine()); //br만 선언해서 한줄씩

//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
		a = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken(); //10110111
			for (int j = 0; j < m; j++) { // 공백이 없어요
				a[i][j] = Integer.parseInt(s.substring(j, j + 1)); //1
				;
			}
		}

		BFS(0, 0);
		System.out.println(a[n-1][m-1]);
	}

	private static void BFS(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>(); // 데이터가 두개들어가니까 배열로
		q.offer(new int[] { i, j }); // 노드 처음시작점을 넣어주는것(0,0)
		visited[i][j] = true; //방문 t
		
		while (!q.isEmpty()) {
			int now[] = q.poll();

			for (int d = 0; d < 4; d++) { // 상하좌우탐색을 위해 4번
				int x = now[0] + dx[d]; // 첫번째[0]가 x값
				int y = now[1] + dy[d]; // [1]가 y값
				if (x >= 0 && y >= 0 && x < n && y < m) { //좌표 유효성 검사
					if (a[x][y] != 0 && !visited[x][y]) { //갈 수 있는 칸 && 방문 검사하기
						// 이제 갈 수 있는 곳이다.
						q.offer(new int[] { x, y }); //넣어주고
						visited[x][y] = true; //방문 t
						a[x][y] = a[now[0]][now[1]] + 1; // 핵심: 시작점에서 자기자신까지 오는 최단거리

					}
				}

			}

		}

	}


}