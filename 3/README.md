3. 자료구조 <br>

#### 메모리초과
해결: 배열을 선언할 때, 적당한 크기로 배열의 사이즈를 할당합니다. long->int <br>
연속되는 자연수 배열선언없이 하니까 메모리 1/3로 줄어듬<br>
<br>
#### 조합 C _ Combination:조합
5C3 = 5x4x3 / 3x2x1<br>
조합은 여러 개의 원소 중에서 몇 개를 순서에 관계없이 뽑아내는 것<br>
가령 1,2,3,4 네 개의 수 가운데서 세 개씩 뽑아 모은 조합은 123, 124, 134, 234 의 네 가지<br>
<br>
#### long 형 선언
문제 5번 int형 long으로 바꿔주니까 정답처리됐다.. int*int에서 int범위 벗어날 수 있기 때문에 long형으로 선언해버리기<br>
long형으로 선언했는데 int형으로 써야할때만 형변환(int)ㄱㄱ<br>
<br>
#### BufferedReader, StringTokenizer
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));<br>
// BufferedReader: 컴퓨팅에서 버퍼는 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역이다.<br>
// InputStreamReader: 문자단위(character) 데이터로 변환시키는 중간다리 역할을 한다. <br>
// System.in: 값을 입력받는 클래스 <br>
<br>
StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());  //readLine(): 예제 첫번째줄을 읽어왔다<br>
// StringTokenizer: 문자열을 우리가 지정한 구분자로 문자열을 쪼개주는 클래스입니다.<br>

int n = Integer.parseInt(stringTokenizer.nextToken()); //첫번째값<br>
int m =
#### Scanner
Scanner sc = new Scanner(System.in); <br>
int N = sc.nextInt(); // nextInt() Int타입으로 리턴	 <br>
String sNum = sc.next(); // next() String타입으로 리턴 <br>
char[ ] cNum = sNum.toCharArray(); //String -> char[] 변환 <br>
<br>
Scanner는 기본적으로 공백을 기준으로 값을 구분하여 입력받는다.<br>
Scanner의 디폴트 구분자는 space이다.<br>
<br>
 Integer.parseInt(stringTokenizer.nextToken()); //두번째값 받아옴<br>
<br>

