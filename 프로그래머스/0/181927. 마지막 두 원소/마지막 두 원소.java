import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list) {
        int temp = 0;
        int l = num_list.length;
        int[] answer = new int[l + 1];
        
        if(num_list[l - 1] > num_list[l - 2])
            temp = num_list[l - 1] - num_list[l - 2];
        else
            temp = num_list[l - 1] * 2;
        
        for(int i = 0; i < l; i++){
            answer[i] = num_list[i];
        }
        
        answer[l] = temp;
        
        return answer;
    }
}