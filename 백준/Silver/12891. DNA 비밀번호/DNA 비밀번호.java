import java.util.*;
import java.io.*;

public class Main {
	// 전역변수 스태틱 타입 변수명;
	static int[] checkArr; // 비밀번호 체크 배열, require
	static int[] myArr; // 현재상태 문자수 count
	static int check4; // 몇개의 문자와 관련된 개수를 충족했는지, 최대값 4.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[] s = new char[n]; // string
		s = br.readLine().toCharArray();
//		System.out.println(Arrays.toString(s));
		
		checkArr = new int[4];
		myArr = new int[4];
		check4 = 0;
		
		st = new StringTokenizer(br.readLine()); //readLine해줘야딩
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0) {
				check4++; // 0이면 체크할 필요가 없으니까
			}
		}

		// 첫번째 단위 카운트해줌
		for (int j = 0; j < m; j++) {
			Add(s[j]);
		}
		
		int result=0; //결과값 최종 출력값 
		
		if (check4==4) {
			result++;
		}

		for (int k=m; k<n; k++) {
			Add(s[k]); //k = m : 추가되는값, 오른쪽값
			Remove(s[k-m]); // k-m : 빠지는값, 왼쪽값
			if (check4==4) {
				result++;
			}
		}


		System.out.println(result);
		br.close();
	}

	private static void Add(char s) {
		switch (s) {
			case 'A': {
				myArr[0]++;
				if (myArr[0] == checkArr[0]) {
					check4++;
				}
				break;
			}
			
			case 'C': {
				myArr[1]++;
				if (myArr[1] == checkArr[1]) {
					check4++;
				}
				break;
			}
			
			case 'G': {
				myArr[2]++;
				if (myArr[2] == checkArr[2]) {
					check4++;
				}
				break;
			}
			
			case 'T': {
				myArr[3]++;
				if (myArr[3] == checkArr[3]) {
					check4++;
				}
				break;
			}
		}

	}
	
	private static void Remove(char s) {
		switch (s) {
			case 'A': {
				if (myArr[0] == checkArr[0]) { 
					check4--;
				}
				myArr[0]--; //조건 체크 후 --
				break;
			}
			
			case 'C': {
				if (myArr[1] == checkArr[1]) { 
					check4--;
				}
				myArr[1]--; //조건 체크 후 --
				break;
			}
			
			case 'G': {
				if (myArr[2] == checkArr[2]) { 
					check4--;
				}
				myArr[2]--; //조건 체크 후 --
				break;
			}
			
			case 'T': {
				if (myArr[3] == checkArr[3]) { 
					check4--;
				}
				myArr[3]--; //조건 체크 후 --
				break;
			}
		}

	}
	
	
	

}