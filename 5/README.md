5. 탐색 


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

#### boolean[] v = new boolean[n+1];
boolean[] : 초기값 false<br>
Boolean[] : 초기값 null<br>
<br>

#### 인접리스트
ArrayList<.Integer>[] a = new ArrayList[n+1]; //크기선언해줄때 대괄호<br>
a[i] = new ArrayList<.Integer>(); //크기없이 타입만 선언 소괄호<br>
<br>
