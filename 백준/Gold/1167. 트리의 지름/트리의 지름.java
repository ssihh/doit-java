import java.util.*;
import java.io.*;

class Edge{ //class는 Main밖에다가 입력
	int e; //목적지 노드 O
	int value; //에지의 가중치 ㅡ 간선길이
	public Edge(int e, int value) { //i.o; | i.value;
		this.e=e;
		this.value = value;
	}
}

public class Main {

	static boolean[] visited; // 방문도 차원
	static int[] distance; //거리 저장 배열
	static ArrayList<Edge>[] a;
	static int n, m;


	
//	static boolean arrive;
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		// 들어오는 데이터가 많을 때는 Scanner보다 br이 시간복잡도에서 유리
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter사용
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		int v = Integer.parseInt(st.nextToken());
//		int n = Integer.parseInt(br.readLine()); //br만 선언해서 한줄씩

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		

		
		a = new ArrayList[n+1]; //노드 개수만큼
		for(int i =1; i<n+1;i++) {
			a[i]=new ArrayList<Edge>();
		}
		
		for(int j=0;j<n;j++) { //A인접리스트에 그래프 데이터 저장하기
			int s = sc.nextInt(); //start
			while(true) {
				int e=sc.nextInt(); //end
				if(e==-1) {
					break;
				}
				int value = sc.nextInt();
				a[s].add(new Edge(e, value));
			}
		}
		
		visited = new boolean[n+1];
		distance = new int[n+1];
		BFS(1);
		int max=1;
		for(int i=2;i<=n;i++) {
			if(distance[max] < distance[i]) {
				max=i; //트리의지름에 해당되는 2개의 노드중 하나로 시작점 설정
			}
		}
		
		visited = new boolean[n+1]; //6
		distance = new int[n+1];
		BFS(max);
		Arrays.sort(distance); //Array's'.어레이스
		System.out.println(distance[n]); //0,1,2,3,4,5
		
		
	}

	private static void BFS(int node) {
		Queue<Integer> q = new LinkedList<>(); // 데이터가 두개들어가니까 배열로
		q.offer(node); // 노드 처음시작점을 넣어주는것(0,0)
		visited[node] = true; //방문 t
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for(Edge i : a[now]) {
				int ne = i.e;  //괄호 필요없네
				int nv = i.value;
				if(!visited[ne]) {
					q.offer(ne);
					visited[ne]=true;
					distance[ne]= distance[now] + nv;
				}
				
			}

		}
	}


}