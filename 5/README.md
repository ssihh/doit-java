5. 탐색 

#### 소수판별함수 암기
static boolean isPrime(int num){<br>
 for(int i=2; num/2<= i; i++) // 2~num/2 까지 나누어지는 수가있으면 F<br>
  if(num % i ==0)<br>
   return false;<br>
 return true; //소수면 true<br>
}<br>

#### boolean[] v = new boolean[n+1];
boolean[] : 초기값 false<br>
Boolean[] : 초기값 null<br>
<br>

#### 인접리스트
ArrayList<.Integer>[] a = new ArrayList[n+1]; //크기선언해줄때 대괄호<br>
a[i] = new ArrayList<.Integer>(); //크기없이 타입만 선언 소괄호<br>
<br>
