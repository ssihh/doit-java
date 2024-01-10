package example;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // nextInt() Int타입으로 리턴
		
		String sNum = sc.next(); // next() String타입으로 리턴
		char[] cNum = sNum.toCharArray(); //String -> char[] 변환
		int sum=0;
		for(int i =0; i<cNum.length; i++) {
			sum +=cNum[i]-'0';
		}
		System.out.print(sum);
	}
}
