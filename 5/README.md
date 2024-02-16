5. 탐색 

#### 23. 연결 요소의 개수 구하기
- void 타입 메소드에 return 키워드가 사용되었다면, 이는 값을 반환 하는 것이 아니라 메소드를 종료 하는 것입니다.
- next의 방문 체크 후 DFS 재귀

		public static void DFS(int i) {
			if(visited[i]) {
				return; //메소드를 종료
			}
			
		visited[i]=true;
		
		for(int next : a[i]) {
			if(!visited[next]) { //아잇 당연히 next의 방문을 체크해야지
				DFS(next);

- 인접리스트 대괄호[ㄷ] 

		ArrayList<.Integer>[] a = new ArrayList[n+1]; //크기선언해줄때 대괄호<br>
		a[i] = new ArrayList<.Integer>(); //크기없이 타입만 선언 소괄호<br>


<br>

#### 24. 신기한 소수 찾기 : 소수 판별 함수, 인자값 사용
- 소수 판별 함수 isPrime(i)
1) <=Math.sqrt : 제곱근 이하 까지
2) num % i == 0 이면 return false : 나눠지면 소수 아님

		public static boolean isPrime(int num) {
	
			// 나눌 범위 초기값 0,1이면 다 나눠지니까 안댐! 2부터
			for (int i = 2; i <= Math.sqrt(num); i++) { // 제곱근이하<=까지
				if (num % i == 0) {
					return false; // 나눠지면 소수아님 false
				}
			}
			return true;		}

1) void 타입 메소드에 return 키워드가 사용: 메소드를 종료 하는 것입니다.
2) jari == n : 인자값 사용. 상수 4 사용 아님

		public static void DFS(int jari, int num) {
			if (jari == n) { // n 인자값 사용
				System.out.println(num);
				return; //메소드 종료
			}
	
			for (int i = 1; i < 10; i += 2) { // 2씩증가 홀수
				if (isPrime(num * 10 + i)) {
					DFS(jari + 1, num * 10 + i);
				}
			}	}

<br>


#### 25. 친구 관계 파악하기 : 방문한 노드에서 빠져나올 때 visited[false]
- 방문노드에서 빠져나올 때 visited[i] = false 해주는건 깊이를 count할 때 필요. 단순 방문 용도면 불필요.
- 도착 인자 활용 boolean arrive;
- 여긴 5명 사이클이 있는 친구관계가 있는지 확인을 위한 것으로 상수 5 사용해야함 O. 인자값 n 사용하면 안댐 X


		private static void DFS(int v, int depth) {
			//여기서는 상수 5
	  		if (depth == 5 || arrive) { //리턴으로 빠져나가면서 이미 도착한애가 arrive가 true면 딴데로 안가고 리턴해줌
				arrive = true;
				return;			}
	
			visited[v] = true;
			for (int i : a[v]) {
				if(!visited[i]) {  //i: 인접리스트 a[i]노드와 연결된 '노드'
					DFS(i, depth+1); //재귀함수 깊이우선
				}	}
			
			visited[v] = false; //역으로 빠져나올 때 노드를 false
			//끝까지 가거나 이미 방문한 노드에서 뒤로 빠져나올 때 false로 바꿔줌		}

<br>


#### BFS dx,dy 미로 국룰 : q.offer(new int[ ] {i, j}); | 미로 탐색

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; // 상하좌우 탐색위한 배열선언
	static boolean[][] visited; // 방문도 차원
	static int[][] a;
	static int n, m;
 
	private static void BFS(int i, int j) {
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

<br>

#### Collections.sort() 와 Arrays.sort() 차이 | DFS와 BFS
Collections.sort(): 컬렉션(List,Set..)을 정렬. Ex) ArrayList<>() a; <br>
Arrays.sort(): 보편적으로 배열을 정렬<br>
<br>


#### BFS 국룰

	private static void BFS(int v, int b) {
 		Queue<Integer> q = new LinkedList<>(); // 큐 선언
		q.offer(v); //먼저 값 하나 넣어주고 q.offer(): 큐 맨뒤에 값 삽입
		visited[v] = true; //방문표시

		while (!q.isEmpty()) { //q가 비워지면 끝남
			int now = q.poll(); // now에 담아서 출력도 하고 인접리스트 방문 | q.poll(): 큐의 첫번째 요소를 삭제 및 반환
			System.out.print(now + " ");

			for (int i : a[now]) { // 인접리스트 방문
				if (!visited[i]) { //방문하지 않았던 노드라면 실행
					q.offer(i); //q.offer(): 큐 맨뒤에 값 삽입
					visited[i] = true; ////방문표시
				}
			}
		}
	}



Queue<.Integer> q = new LinkedList<>();<br>
q.poll(): 큐의 첫번째 요소를 삭제 및 반환<br>
q.offer(): 큐 맨뒤에 값 삽입. offer()은 큐만 해당! add()는 큐가 꽉 찬 경우 IllegalStateException 에러 발생<br>
q.peek(): 큐 맨 앞의 값 반환<br>


#### 28. 트리의 지름 : Edge(e, value) Class 생성
- maxi , distance[maxi] : 인덱스에는 명칭뒤에 i 붙이기. 값이랑 비교해야함. 인덱스 비교X

		int maxi=1; //인덱스 i 표시 인덱스 1부터. BFS를 1부터 했으니 0은 패스
		for(int i=1; i<=n; i++) { 
			if(distance[maxi] < distance[i]) { // maxi인 distance 값 비교
				maxi=i; //maxi : max 값을 가지고 있는 인덱스 i값을 넣어줌
			}		}

- class Edge 선언 : class Main 밖에다가 선언. import 처럼
1) public Edge : 바로 반환값없이 퍼블릭 엣지 바로 해도 됨.
2) this.v = v; : 타입 없이 됨.
3) a[s].add(new Edge(e,w)); : 인접리스트에 Edge 클래스 넣을 때

		class Edge { //class 이렇게 쓰는거 맞는지 정리..
		int v; //정점
		int w; //가중치
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}	}
		a[s].add(new Edge(e,w)); //인접리스트에 Edge 추가. public Edge(v,w) 함수 활용

- ArrayList<.Edge>[] : Edge 클래스로 ArrayList 선언

		static ArrayList<Edge>[] a;
		a = new ArrayList[n+1]; //노드 개수만큼
		for(int i =1; i<n+1;i++) {
			a[i]=new ArrayList<>();
		}

- Queue<Integer> q : 큐는 Integer로. Edge로 안해도 됨. 거리배열에 트리의 지름 따로 저장할 거기 때문.
- crt, next 명칭 활용.

		public static void BFS(int num) {
			Queue<Integer> q = new LinkedList<>();
			q.offer(num); //큐 인티저?
			visited[num]=true;
			
			while(!q.isEmpty()) {
				int crt = q.poll();
				for(Edge next : a[crt]) {
					if(!visited[next.v]) {
						q.offer(next.v);
						visited[next.v]=true;
						distance[next.v]=distance[crt] + next.w;
					}		}		}		}


<br>

#### boolean[] v = new boolean[n+1];
boolean[] : 초기값 false<br>
Boolean[] : 초기값 null<br>
<br>


