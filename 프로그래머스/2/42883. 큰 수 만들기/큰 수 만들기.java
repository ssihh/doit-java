class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
    
        int idx=0; //max값 인덱스 초기값
        
        for(int i=0; i<number.length()-k; i++){ // i 6번실행 :0~5까지 . 6번 max 채워줘야함
            int max=0;
            for(int j=idx; j<=i+k; j++){ //for문 초기시작값이 idx이고 ; j는 줏대있게 1씩증가
                //i최대 5 + k 4 = 9 까지는 탐색해야하니 j<=i+k(9)
                //i가 1씩 증가하니 j 탐색 범위 끝도 1(i)씩증가, 시작값만 index
                
                int n = number.charAt(j)-'0'; 
                //i는 들어가지 않아 i는 단지 큰수만들 횟수 6번 진행한다는 뜻
                //실제로 탐색하는 범위는 j
                if(max < n){
                    max = n;
                    idx=j+1; //다음 인덱스
                }
            }
            answer.append(max); 
            //탐색완료한 max값 넣어줌 10개숫자중 4개제거위해 6번실행
        }
        
        
        return answer.toString();
    }
}