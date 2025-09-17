class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        int temp = 0;
        
        for(int i = 0; i < numbers.length; i++){
            temp += numbers[i];
            answer = (double)temp / numbers.length;
        }
      
        return answer;
    }
}