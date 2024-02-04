5. 탐색 

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
q.offer(): 큐 맨뒤에 값 삽입. add()는 큐가 꽉 찬 경우 IllegalStateException 에러 발생<br>
q.peek(): 큐 맨 앞의 값 반환<br>

#### DFS 국룰

	private static void DFS(int v, int depth) {
		if (depth == 5 || arrive) { //리턴으로 빠져나가면서 이미 도착한애가 arrive가 true면 딴데로 안가고 리턴해줌
			arrive = true;
			return;
		}

		visited[v] = true;
		for (int i : a[v]) {
			if(!visited[i]) {  //i: 인접리스트 a[i]노드와 연결된 '노드'
				DFS(i, depth+1); //재귀함수 깊이우선
			}
		}
		
		visited[v] = false; //역으로 빠져나올 때 노드를 false
		//끝까지 가거나 이미 방문한 노드에서 뒤로 빠져나올 때 false로 바꿔줌

	}

#### 소수판별함수 암기
static boolean isPrime(int num){<br>
 for(int i=2; num/2<= i; i++) // 2~num/2 까지 나누어지는 수가있으면 F<br>
  if(num % i ==0)<br>
   return false;<br>
 return true; //소수면 true<br>
}<br>
<br>
#### boolean[] v = new boolean[n+1];
boolean[] : 초기값 false<br>
Boolean[] : 초기값 null<br>
<br>

#### 인접리스트
ArrayList<.Integer>[] a = new ArrayList[n+1]; //크기선언해줄때 대괄호<br>
a[i] = new ArrayList<.Integer>(); //크기없이 타입만 선언 소괄호<br>
<br>
