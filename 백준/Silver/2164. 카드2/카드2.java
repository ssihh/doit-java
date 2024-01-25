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

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while(q.size()!=1) {
			q.poll();
			q.add(q.poll());
		}
		
		System.out.println(q.peek());
		
	}

}