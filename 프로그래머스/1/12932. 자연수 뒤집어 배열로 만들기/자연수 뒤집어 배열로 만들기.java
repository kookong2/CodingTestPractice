class Solution {
    public long[] solution(long n) {
        
        int digits = String.valueOf(n).length();
        long answer[] = new long[digits];
        
        for(int i = 0; i < digits; i++){
            answer[i] = n % 10;
            n /= 10;
        }
        
        return answer;
    }
}