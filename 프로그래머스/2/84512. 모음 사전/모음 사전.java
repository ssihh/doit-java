import java.util.*; //에러뜨면 import 해보자

class Solution {
    String[] alpha = {"A", "E", "I", "O", "U"};
    ArrayList<String> words; 
    //List 인터페이스를 구현한 클래스이기 때문에 저장된 값의 순서를 유지하고 중복을 허용한다. 
    
    public void create_words(int lev, String str) { //0,""
        words.add(str); //words.get(i) = "" : 첫번째(0) 값은 ""임
        for (int i = 0; i < 5; i++) {
            if (lev < 5) { //lev 0
                create_words(lev+1, str.concat(alpha[i])); //A
            }
            else break;
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        words  = new ArrayList<String>();
        create_words(0, ""); //함수 호출
        for (int i = 0; i < words.size(); i++) {
            if (word.equals(words.get(i))) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}

