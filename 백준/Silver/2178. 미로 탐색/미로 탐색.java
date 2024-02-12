import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] a;
	static boolean[][] visited;
	static int n;
	static int m;
	static int answer;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 맵 초기화

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken(); // String으로 nextToken받아오고
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j + 1)); // 한개씩 Int로 맵에 넣기
				// substring 뜻: 부분문자열

			}
		}

		// 방문 배열
		visited = new boolean[n][m];

		// BFS실행
		BFS(0, 0);
		System.out.println(map[n - 1][m - 1]);

	}

	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		while (!q.isEmpty()) {
			int[] crt = q.poll();
			int cx = crt[0];
			int cy = crt[1];

			for (int i = 0; i < 4; i++) { // 4방향
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) { // 좌표 유효성 검사하기
					if (map[nx][ny] == 1 && !visited[nx][ny]) { // 맵길 && 방문하지 않은곳
						q.offer(new int[] { nx, ny });
						visited[nx][ny] = true;
						map[nx][ny] = map[cx][cy] + 1; //그전 메모값에 +1
					}
				}

			}

		}

	}

}
