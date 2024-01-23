import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter사용
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int n = Integer.parseInt(st.nextToken());
//		int l = Integer.parseInt(st.nextToken());

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n;i++) { 
			a[i]=sc.nextInt();
		}
		
		int[] ans = new int[n]; // 정답배열
		
		Stack<Integer> mystack = new Stack<>();
		mystack.push(0); // 처음에는 항상 스택이 비어 있으므로 최초 값을 push해 초기화 .?
		//index값 0 push
		
		for(int i =1; i<n; i++) {
			while(!mystack.isEmpty() && a[mystack.peek()] < a[i]) { //a[0] <a[1] | //i=3일때: 9, 5(2), 4(1), 8
				ans[mystack.pop()] = a[i]; // 정답 배열에 오큰수를 현재 수열로 저장하기
				// peek한 값 pop해. 0 | ans[0] = a[1] 오큰수 저장
			}
			mystack.push(i); // i값 push. 1 | 신규데이터 push
			
		}

		
		while(!mystack.isEmpty()) {
			//for문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때까지 스택에 쌓인 index에 -1을 넣고
			ans[mystack.pop()]=-1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int j=0;j<n;j++) {
			bw.write(ans[j]+" ");
		}
		bw.write("\n");
		
		bw.flush(); 
		bw.close();
	}


}