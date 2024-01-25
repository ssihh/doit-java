import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// 들어오는 데이터가 많을 때는 Scanner보다 br이 시간복잡도에서 유리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); //br만 선언해서 한줄씩

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int first = Math.abs(o1);
			int second = Math.abs(o2);
			
			if(first == second) { //절대값이 같으면 음수 우선 정렬
				return o1 > o2 ? 1 : -1; //'>' 기준 오른쪽이 작은 거니까 1 
				// 양수리턴 내림차순, 음수리턴 오름차순
			}
			
			return first - second; //첫번째 데이터가 크면 양수 리턴, 두번째 데이터가 크면 음수
			//음수냐 양수냐로 비교정렬 기준을 세움. 절대값 작은 데이터 우선. 오름차순
			// 양수리턴 내림차순, 음수리턴 오름차순
		});
		
		for(int i=0; i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(a);
			}
		}

	}

}