import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    ArrayList<Integer>[] a = new ArrayList[n+1];
	    for (int i = 1; i <= n; i++) {
	      a[i] = new ArrayList<>();
	    }
	    int[] indegree = new int[n + 1]; // 진입차수배열
	    int[] selfBuild = new int[n + 1]; // 자기자신을 짓는데 걸리는 시간
	    for (int i = 1; i <= n; i++) {
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      selfBuild[i] = Integer.parseInt(st.nextToken()); // 해당 건물을 짓기 위한 시간
	      while (true) { // 인접리스트 초기화
	        int preTemp = Integer.parseInt(st.nextToken());
	        if (preTemp == -1)
	          break;
	        a[preTemp].add(i); //4번째 건물에 4 3 1 -1 이면, selfBuild=4, 3.add(4), 1.add(4) 
	        // preTemp->i 로 가니까 preTemp[3]에 i(4) 추가. 와 헷갈림 
	        // 3노드에서 -> 4노드로 감.
	        indegree[i]++; // 진입차수 배열 초기화 i(4)로 들어오는 preTemp[3]에 대해 ++
	      }
	    }
	    // 위상 정렬
	    Queue<Integer> queue = new LinkedList<>();
	    for (int i = 1; i <= n; i++) {
	      if (indegree[i] == 0) {
	        queue.offer(i); //1
	      }
	    }
	    int[] result = new int[n + 1];
	    while (!queue.isEmpty()) {
	      int now = queue.poll(); //1(10):  |  3(4):
	      for (int next : a[now]) { //1: 2,3,4  |  3: 4,5
	        indegree[next]--;
	        result[next] = Math.max(result[next], result[now] + selfBuild[now]);
	        //						0 			, 10								
	        if (indegree[next] == 0) {
	          queue.offer(next);
	        }
	      }
	    }
	    for (int i = 1; i <= n; i++) {
	      System.out.println(result[i] + selfBuild[i]);
	    }
	  }
	}

