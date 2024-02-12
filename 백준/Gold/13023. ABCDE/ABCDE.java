import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static int n;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 인접리스트
		a = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		//초기화
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[u].add(v);
			a[v].add(u);
			
		}
		
		// 방문 배열
		visited = new boolean[n];

		// answer 1,0
		answer = 0; 
		
		// DFS실행
		for(int i=0; i<n; i++) {
			if(answer==1) break; //5명 count해서 1되면 탈출
			if(!visited[i]) {
				DFS(i, 1);
			}
		}

		System.out.println(answer);

	}

	private static void DFS(int v, int count) {

		if(count==5) {
			answer=1; //5명 돼면 answer 1
			return;
		}
		
		visited[v]=true;
		
		for(int i : a[v]) {
			if(!visited[i]) {
				DFS(i, count+1);
			}
		}
		
		visited[v]=false; //이거 해주니까 됨 나오면서 문닫?..

	}



}
