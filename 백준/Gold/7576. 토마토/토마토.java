import java.util.*;
import java.io.*;

class Main {

	public static int n;
	public static int m;
	public static boolean[][] visited;
	public static int[][] map;
	public static int t0;
	public static Queue<int[]> q = new LinkedList<>();
	public static int day;
	
	public static void BFS() {
		
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		while(!q.isEmpty() && t0 !=0 ) { //논리연산자 하나라도 해당되면 그만!, null을 계속 뱉더라
			int[] c = q.poll();
//			System.out.println(Arrays.toString(c));
			int cx = c[0];
			int cy = c[1];
	
			for(int i=0; i<4; i++) { //4방향
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx>=0 && ny>=0 && nx<m && ny<n) { //좌표 유효성 검사
					if(map[nx][ny]==0 && !visited[nx][ny]) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						map[nx][ny] = map[cx][cy] + 1;
						t0 --;
						day = map[nx][ny]; //출력값
					}
				}
			}
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Reader 3
		StringTokenizer st = new StringTokenizer(br.readLine()); // 왜 빨간줄? IOException 아하

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[m][n];
		map = new int[m][n];

		for (int i = 0; i < m; i++) { //행
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) { //열
				int t = Integer.parseInt(st.nextToken());
				map[i][j] = t;
				if (t == 0) {
					t0 ++;
				}
				else if(t == 1) { //출발지가 여러갠데 어카지
					q.offer(new int[] {i,j}); // 이렇게 바로 
//					System.out.println(i+", "+j);
					visited[i][j] = true;
				}
			}
		}
		
		if(t0==0) {
			System.out.println(0);
		}
		else {
			BFS();
			if(t0==0) { //갑자기 무채색될때 저장하면 돌아옴
				System.out.println(day-1);
			}
			else {
				System.out.println(-1);
			}
		}
		
		

	}
}
