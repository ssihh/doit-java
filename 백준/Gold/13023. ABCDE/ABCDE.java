import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<Integer>[] a;
	static boolean[] visited;
	static boolean arrive;

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
//		n = sc.nextInt();
		a = new ArrayList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();// 인접리스트 초기화하기
		}

		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
			a[e].add(s);
		}

		arrive = false;
		for (int k = 0; k < n; k++) {
			DFS(k, 1);
			if (arrive) {
				break; //이미 5개 도달했으면 다음 노드 DFS 그만하고 for문 탈출
			}
		}

		if(arrive) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}

	private static void DFS(int v, int depth) {
		// TODO Auto-generated method stub
		if (depth == 5 || arrive) { //리턴으로 빠져나가면서 이미 도착한애가 arrive가 true면 딴데로 안가고 리턴해줌
			arrive = true;
			return;
		}

		visited[v] = true;
		for (int i : a[v]) {
			if(!visited[i]) {  //i: 인접리스트 a[i]노드와 연결된 '노드'
				DFS(i, depth+1); 
			}
		}
		
		visited[v] = false; //역으로 빠져나올 때 노드를 false
		//끝까지 가거나 이미 방문한 노드에서 뒤로 빠져나올 때 false로 바꿔줌

	}



}