import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
       
        HashSet<Integer> hashset = new HashSet<>();
        for(int i =0; i<numbers.length-1; i++)
            for(int j=i+1; j<numbers.length; j++){
                hashset.add(numbers[i]+numbers[j]);
            }
        
        
        int[] answer = new int[hashset.size()];
        Iterator<Integer> iterator = hashset.iterator();

        // for (int j=0; j< hashset.size(); j++){
        //     answer[j] = (int)iterator.next();
        // }
        
        int k=0;
        while(iterator.hasNext()){
            answer[k++]=iterator.next();
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
