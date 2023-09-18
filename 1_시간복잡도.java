// tip: each public class is put in its own file
public class main
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        //1~100 사이 값 랜덤 선택
        int findNumber = (int)(Math.random()*100); //Math.random(): 0~1(1은 미포함) 구간에서 부동소수점의 난수를 생성
        for(int i=0; i<100; i++){
            if(i==findNumber){
                System.out.println(i);
                break;
            }
        }

        //System.out.println("Hello, world!");
    }
}
