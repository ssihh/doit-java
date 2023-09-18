import java.util.Scanner;
// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N 선언해서 뭐함
        
        //입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;

        for(int i = 0; i < cNum.length; i++){
            sum+=cNum[i]-'0';
        }
        System.out.print(sum);


        //System.out.println("Hello, world!");
    }
}
