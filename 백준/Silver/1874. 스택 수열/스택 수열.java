import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		
		for(int i=0; i<n;i++) {
			s[i]=sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		int num=1;
		boolean psb = true;
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<n;i++) {
			// 4 3 6 8
			if(s[i]>=num) { //num은 점차 증가함 n까지
				while(s[i]>=num) {
//					System.out.print(num);
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
			else {					// s[i]값 < num 일때 pop 수행해 수열 원소를 꺼냄
				int t = stack.pop();
				if(t>s[i]) { // t=4 > s[i]=3
					psb = false;
					System.out.println("NO");
					break; //for문 탈출
				}
				else {
					sb.append("-\n"); // 추가할 필요없이 스택에서 pop만 하면 될때. 2,1 > 8
				}
				
			}
			
		}
		
		
		if(psb) {
			System.out.println(sb.toString());
		}
		
		
		
		
	}




}