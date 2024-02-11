8. 그래프

### 8-3. 위상정렬 & 진입차수(Indegree) | 인접리스트, 큐 


		indegree = new int[n+1]; //진입차수
		a = new ArrayList[n+1]; //인접리스트
		for(int i=1; i<=n;i++) {
			a[i] = new ArrayList<Integer>(); //인접리스트
		}
		
		for(int j=0; j<m; j++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			a[s].add(e);
			indegree[e]++; //e에 +1하고 0으로 둘건 냅도.
		}

		wesang();
		System.out.println("\n");
	}
	
	private static void wesang() { //위상정렬
		Queue<Integer> q = new LinkedList<>();

		for(int i=1; i<=n; i++) {
			if(indegree[i]==0) {
				q.offer(i); //진입차수(indegree)가 0인 것들 다 q에 넣어줘 : 3, 4
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");
			for(int next : a[now]) { // 현재노드에서 갈 수 있는 다음거를 들고와
				indegree[next]--; // indegree -1
				if(indegree[next]==0) { // 마이너스하고 0 이면 값 큐에 넣어줘
					q.offer(next);
				}
			}
		}



### 8-2. 유니온(Union) & 파인드(Find) | 재귀함수

	private static void union(int a, int b) {
		//대표노드를 찾아서 연결
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b] = a; 
		}
		
	}
	
	private static int find(int i) {
		if(i == parent[i]) {
			return i;
		}
		else {
			return parent[i] = find(parent[i]);
			//경로압축 로직: 빠져나올때마다 그때의 대표노드 값을 업데이트
		}
		
	}

	private static void checkSame(int a, int b) {
		if(find(a)==find(b)) { //대표노드가 같은 원소a,b인가?
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
