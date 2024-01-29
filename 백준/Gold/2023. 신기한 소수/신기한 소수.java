import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	public static void main(String[] args) throws IOException {
		// 들어오는 데이터가 많을 때는 Scanner보다 br이 시간복잡도에서 유리
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter사용
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		int n = Integer.parseInt(br.readLine()); //br만 선언해서 한줄씩

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		DFS(2,1); //일의자리 소수는 2,3,5,7이므로 4개 수에서만 시작
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
		
	}
		

	private static void DFS(int num, int jarisu) {
		// TODO Auto-generated method stub
		if(jarisu ==n) {
			if(isPrime(num)) {
				System.out.println(num); //소수면 숫자 출력
			}
			return;
		}
		
		for(int i=1; i<10; i++) {
			if(i%2==0) {
				continue; //짝수라면 더 이상 탐색할 필요가 없음
			}
			if(isPrime(num*10+i)) {
				DFS(num*10+i, jarisu+1);
			}
		}
	}


	private static boolean isPrime(int num) { //소수 판변 암기
		// TODO Auto-generated method stub
		for(int i=2; i<num/2;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

}