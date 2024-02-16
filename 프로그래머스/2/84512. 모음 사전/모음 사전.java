import java.util.*;
import java.io.*;

class Solution {
    public String[] alpha = {"A", "E", "I", "O", "U"};
    public ArrayList<String> sazon = new ArrayList<>();
    
    public void DFS(int len, String str){
        
        sazon.add(str); //저장하고
        
        if(len == 5) { // 5면 아래 for문 수행안하고 리턴 메소드 종료
            return;
        }
        
        for(int i=0; i<5; i++){
            if(len<5){
                DFS(len+1, str.concat(alpha[i]));
            }
        }
        
    }
    
    public int solution(String word) {
        int answer = 0;
        
        DFS(0, "");
        
        int n = sazon.size();
        
        for(int i=0; i<n; i++){
            if(word.equals(sazon.get(i))){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}