import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        
        int n = numbers.length;
        HashSet<Integer> hs = new HashSet<>(); //Int
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                hs.add(numbers[i]+numbers[j]); //hs.add()
            }
        }
        
        Iterator<Integer> iter = hs.iterator(); //<Integer> 해도되고 안해도되고
        answer = new int[hs.size()]; //hs.size(); answer 크기 초기화 해줘야 오류 안남
        
        int c=0;
        while(iter.hasNext()){ //iter.hasNext()
            answer[c++]=iter.next();  //iter.next()
        }

        Arrays.sort(answer); //정렬
        return answer;
    }
}