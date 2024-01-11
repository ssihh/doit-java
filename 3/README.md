3. 자료구조 <br>

#### Scanner
Scanner sc = new Scanner(System.in); <br>
int N = sc.nextInt(); // nextInt() Int타입으로 리턴	 <br>
String sNum = sc.next(); // next() String타입으로 리턴 <br>
char[ ] cNum = sNum.toCharArray(); //String -> char[] 변환 <br>
<br>
Scanner는 기본적으로 공백을 기준으로 값을 구분하여 입력받는다.<br>
Scanner의 디폴트 구분자는 space이다.<br>
<br>
#### BufferedReader, StringTokenizer
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));<br>
// 컴퓨팅에서 버퍼는 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역이다.<br>
StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());  //readLine(): 예제 첫번째줄을 읽어왔다<br>
// StringTokenizer 클래스는 문자열을 우리가 지정한 구분자로 문자열을 쪼개주는 클래스입니다.<br>

int n = Integer.parseInt(stringTokenizer.nextToken()); //첫번째값<br>
int m = Integer.parseInt(stringTokenizer.nextToken()); //두번째값 받아옴<br>
