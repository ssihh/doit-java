import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter사용
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		Deque<Node> mydeque = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			int now = Integer.parseInt(st.nextToken());
			// 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
			
			while(!mydeque.isEmpty() && mydeque.getLast().value>now) {
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now, i));// 얜왜 그림이랑 좌우 바꿔놨냐
			
			//범위에서 벗어난 값은 덱에서 제거
			if(mydeque.getFirst().index <= i-l) {
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value + " ");
			
		} 
		
		bw.flush();
		bw.close();
		
		
	}

	static class Node {
		public int value;
		public int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}


}