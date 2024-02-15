class Solution {
    
    public int[] room = new int[24*60 + 11];
    
    public void to_min (String t1, String t2) {
        int tm1 =Integer.parseInt(t1.substring(0,2)) * 60 
            + Integer.parseInt(t1.substring(3));
        int tm2 =Integer.parseInt(t2.substring(0,2)) * 60 
            + Integer.parseInt(t2.substring(3));
        
        for(int i=tm1 ; i<tm2+10; i++){
            room[i]++;
        }
        
        // System.out.println(tm1+" ,"+(tm2+10));
        // System.out.print(room[950]);
        
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        int n = book_time.length;
        
        for(int i=0; i<n; i++){
            to_min(book_time[i][0], book_time[i][1]);
        }
        
        
        for(int i=0; i<room.length; i++){
            if(answer<room[i])
                answer=room[i];
        }
        
        return answer;
    }
}