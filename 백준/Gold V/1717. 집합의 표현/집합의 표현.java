import java.util.*;
import java.io.*;

class Main {
	
	private static int[] parent;
	
	private static int Find(int u) { //재귀다
		if(u == parent[u]) return u; //대표노드값이 같으면 return
		
		parent[u] = Find(parent[u]);
		
		return parent[u];
	}
	
	private static void Union(int u,int v) {
		u = Find(u);
		v = Find(v);
		
		if(u!=v) { // if 대표노드가 다르면 연결
			int max = Math.max(u, v);
			int min = Math.min(u, v);
			parent[max]=min;
		}
	}
	
	private static void Check(int u, int v) {
		u = Find(u);
		v = Find(v);
		
		if(u==v) System.out.println("YES");
		else System.out.println("NO");
		
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Reader 3
    	StringTokenizer st = new StringTokenizer(br.readLine()); //왜 빨간줄? IOException 아하
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	parent = new int[n+1];
    	for(int i=1; i<=n; i++) {
    		parent[i]=i; //자기자신 초기화
    	}
    	
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
        	int q = Integer.parseInt(st.nextToken());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	if(q==0) { //0 연결일 때
        		Union(u,v);            	
        	}
        	else if(q==1){ //1 연결되어있는지 확인할 때
            	Check(u,v);
        	}
    	}
    	
    	/*
7 8
0 1 3
0 3 7
0 7 6
0 4 2
0 2 5
1 3 6
1 4 5
1 1 5
y,y,n
    	 */

    }
}
