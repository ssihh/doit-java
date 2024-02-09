7. 정수론

#### 에라토스테네스의 체
Math.sqrt(m): 제곱근, square root<br>
int[m+1]: 디폴트값 = 0<br>

		//제곱근까지만 확인해도 전체 버위 소수를 판별가능. 16=4*4일 때, 4까지만 소수 판별 진행
		for(int j=2; j<=Math.sqrt(m) ; j++) { 
			if(arr[j]!=0) {
				for(int k=j+j; k<=m ; k+=j) {
					arr[k]=0;
				}
			}
		}
