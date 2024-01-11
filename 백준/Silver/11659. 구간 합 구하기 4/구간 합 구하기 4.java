import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = 
				new StringTokenizer(bufferedReader.readLine());
									//readLine(): 예제 첫번째줄을 읽어왔다
		int n = Integer.parseInt(stringTokenizer.nextToken()); //첫번째값
		int m = Integer.parseInt(stringTokenizer.nextToken()); //두번째값 받아옴
		
		long[] s = new long[n+1]; //숫자데이터 long형. 0번째 데이터 무시하고 바로바로받기
		stringTokenizer = //한줄 쭉 읽어오고싶을때 stringTokenizer
				new StringTokenizer(bufferedReader.readLine());
		for(int i=1;i<=n;i++) {
			s[i]=s[i-1]+Integer.parseInt(stringTokenizer.nextToken());
		}
				
		for(int j=0;j<m;j++) {
			stringTokenizer = 
					new StringTokenizer(bufferedReader.readLine());
			int a = Integer.parseInt(stringTokenizer.nextToken()); 
			int b = Integer.parseInt(stringTokenizer.nextToken()); 
			System.out.println(s[b]-s[a-1]);
			
		}
	}
}