3. 자료구조 <br>

#### Scanner
Scanner sc = new Scanner(System.in); <br>
int N = sc.nextInt(); // nextInt() Int타입으로 리턴	 <br>
String sNum = sc.next(); // next() String타입으로 리턴 <br>
char[ ] cNum = sNum.toCharArray(); //String -> char[] 변환 <br>
<br>
Scanner는 기본적으로 공백을 기준으로 값을 구분하여 입력받는다.<br>
Scanner의 디폴트 구분자는 space이다.<br>
