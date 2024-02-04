2. 입출력

#### StringBuffer sb = new StringBuffer();
sb.append("+\n");<br>
System.out.println(sb.toString);<br>
StringBuffer는 가변(mutable)한 문자열을 처리하기 위한 클래스입니다. <br>
즉, 새로운 문자열을 추가하거나 변경하게 되면 “기존의 객체”로 추가 및 변경이 됩니다.<br>
<br>
#### BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
출력을 위해서는 bw.write(mydeque.getFirst().value + " ") 후 bw.flush() 와 bw.close() 를 모두 사용해주어야한다. <br>
- bw.write(" ") : 값 추가 write
- bw.flush() : write 에 저장된 값을 출력함과 동시에 비워주는 역할이고, 뜻: 한꺼번에 쏟다, 붓다
- bw.close() : 끝 마무리해주는 역할이라고 한다. <br>
<br>

##### *BufferedReader, Scanner 둘은 같이 쓰면 안됨, 두개 선언하니 뒤에 선언한게 한줄 건너뛰고 읽어옴.,.
System.in 은 실행프로그램에서 하나만 생성이 되고 이를 여러격체들이 공유하는 형태<br>
// 들어오는 데이터가 많을 때는 Scanner보다 br이 시간복잡도에서 유리 <br>
#### BufferedReader
br.close(); //BufferedReader를 더 이상 사용할 필요가 없게 되면 close()를 통해서 입력 스트림을 닫고 사용하던 자원을 해제 <br>
s = br.readLine().toCharArray(); //띄어쓰기 없는 문자형을 char[] s 로 <br>
<br>
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));<br>
// BufferedReader: 컴퓨팅에서 버퍼는 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역이다.<br>
// InputStreamReader: 문자단위(character) 데이터로 변환시키는 중간다리 역할을 한다. <br>
// System.in: 값을 입력받는 클래스 <br>
		
<br>
#### StringTokenizer
StringTokenizer st = new StringTokenizer(br.readLine());  //readLine(): 한줄 읽어오기 <br>
// StringTokenizer: 문자열을 우리가 지정한 구분자로 문자열을 쪼개주는 클래스입니다. <br>

int n = Integer.parseInt(st.nextToken()); //첫번째값. 값 받아오기전 readline으로 줄 읽어와야험 <br>
int m = Integer.parseInt(st.nextToken()); //두번째값 받아옴 <br>
<br>

#### Scanner
Scanner sc = new Scanner(System.in); <br>
int N = sc.nextInt(); // nextInt() Int타입으로 리턴	 <br>
String sNum = sc.next(); // next() String타입으로 리턴 <br>
char[ ] cNum = sNum.toCharArray(); //String -> char[] 변환 <br>
<br>
Scanner는 기본적으로 공백을 기준으로 값을 구분하여 입력받는다.<br>
Scanner의 디폴트 구분자는 space이다.<br>
<br>
