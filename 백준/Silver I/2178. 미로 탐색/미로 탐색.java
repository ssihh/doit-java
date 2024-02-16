import java.util.*;
import java.io.*;

class Main {
	
	public static int[][] map;
	public static boolean[][] visited;
	public static int n;
	public static int m;
	
	public static void BFS(int x, int y) {
		
		 Queue<int[]> q = new LinkedList<>();
		 q.offer(new int[] {x,y});
		 visited[x][y]=true;
		 
		 int[] dx = {0,0,-1,1};
		 int[] dy = {1,-1,0,0};
		 
		 while(!q.isEmpty()) {
			 int[] crt = q.poll();
			 int cx = crt[0];
			 int cy = crt[1];
			 for(int i=0; i<4; i++) {
				 int nx = cx + dx[i];
				 int ny = cy + dy[i];
				 if(nx>=0 && ny>=0 && nx<n && ny<m) {
					 if(map[nx][ny]==1 && !visited[nx][ny]) {
						 q.offer(new int[] {nx, ny});
						 map[nx][ny] = map[cx][cy] + 1;
						 if(nx==n-1 && ny==m-1) return; // 목표 도달 메소드 종료
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

		visited = new boolean[n][m];
		
		map = new int[n][m];		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j]= s.charAt(j) - '0';
			}
		}
		
		int x=0; int y=0;
	    BFS(x,y);
		
	    System.out.println(map[n-1][m-1]);

	}
}
