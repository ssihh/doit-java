import java.util.*;
import java.io.*;

public class Main {

	private static int[] parent;
	public static void main(String[] args) throws IOException {


		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		parent = new int[n+1];
		for(int i =0; i<=n;i++) {
			parent[i] =i;
		}
		
		for( int j=0; j<m;j++ ) {
			int q = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(q==0) { // union
				union(a,b);
			}
			else { // a,b 대표노드가 같은지
				checkSame(a,b);
			}
		}
		

	}
	private static void union(int a, int b) {
		//대표노드를 찾아서 연결
		int ua = find(a);
		int ub = find(b);
		int min = Math.min(ua,  ub);
		if(ua!=ub) {
			parent[ub] = ua; 
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
		if(find(a)==find(b)) { //대표노드가 같은 원소a,b인가? | parent 아님!!! find로 대표노드값 업데이트 치면서 확인
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
