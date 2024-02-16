5. 탐색 

#### 23. 연결 요소의 개수 구하기
- void 타입 메소드에 return 키워드가 사용되었다면, 이는 값을 반환 하는 것이 아니라 메소드를 종료 하는 것입니다.
- next의 방문 체크 후 DFS 재귀
- DFS ([return], for, if, DFS)

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

#### 26. DFS와 BFS : Collections.sort(arraylist)
- Collections.sort(a[i]) : 배열아닌 ArrayList<Integer>의 정렬

		for(int i=1; i<=n; i++) {
			Collections.sort(a[i]);
		}

  
- BFS 국룰 (Q, while, for, if)

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
					}		}		}		}

<br>

#### 27. 미로탐색 : q.offer(new int[ ] {i, j});
- Queue<int[]> q : 좌표 값 넣기위한 int[] 배열타입 큐
- q.offer(new int[] {x,y}); : q에 배열 값 넣을 때
- 지도에 바로바로 +1 count 해주고 목표 좌표값 출력

	  	public static void BFS(int x, int y) {
			 Queue<int[]> q = new LinkedList<>(); //int[] int 배열 큐
			 q.offer(new int[] {x,y}); // 큐에 int 배열 넣기
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
							 map[nx][ny] = map[cx][cy] + 1; //지도에 +1 카운트 표시
							 if(nx==n-1 && ny==m-1) return; // 목표 도달 메소드 종료
						 }
					 }
				 }

- 띄어쓰기 없는 지도 입력 받을 때
  
		map = new int[n][m];		
		for(int i=0; i<n; i++) {
			String s = br.readLine(); // 한줄 읽어와서
			for(int j=0; j<m; j++) {
				map[i][j]= s.charAt(j) - '0'; //시간줄임 substring안쓰고
			}
		}

<br>

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
			q.offer(num); //큐 인티저? ㄴㄴ
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


#### Queue<.Integer> q = new LinkedList<>();<br>
q.poll(): 큐의 첫번째 요소를 삭제 및 반환<br>
q.offer(): 큐 맨뒤에 값 삽입. offer()은 큐만 해당! add()는 큐가 꽉 찬 경우 IllegalStateException 에러 발생<br>
q.peek(): 큐 맨 앞의 값 반환<br>


#### boolean[] v = new boolean[n+1];
boolean[] : 초기값 false<br>
Boolean[] : 초기값 null<br>
<br>


