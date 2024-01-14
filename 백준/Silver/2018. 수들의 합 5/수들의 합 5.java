import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 두줄만 받잖어 그땐 Scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//배열 안넣어줘도됨

		int sindex = 1;
		int eindex = 1;
		int sum =1;
		int c = 1;
		
		while(eindex!=n) {
			if(sum==n) {
				eindex++; 
				sum+=eindex;
				c++;
			}
			else if(sum<n){
				eindex++; 
				sum+=eindex;
			}
			else if(sum>n) {
				sum-=sindex;
				sindex++; //뺀다음에 ++해야하니 뒤로
			}
		}


		System.out.println(c);

	}
}