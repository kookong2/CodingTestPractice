class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.length() > 1){
            
            int oneCnt = 0;
            
            for(int i = 0; i < s.length(); i++){
                
                if(s.charAt(i) == '0') answer[1]++;
                else oneCnt++;
            }
            
            s = Integer.toBinaryString(oneCnt);
            answer[0]++;
        }
        return answer;
    }
}