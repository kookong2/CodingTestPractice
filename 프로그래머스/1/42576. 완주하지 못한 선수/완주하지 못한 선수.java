import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        
        for(String p : participant) {
            
            // getOrDefault 메서드를 사용하여 이미 해시맵에 존재하는 이름이면 값을 증가
            // 존재하지 않으면 0을 기본값으로 설정하고 1을 더해줌
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // completion 배열을 순회하면서 각 완주자의 이름의 값을 해시맵에서 감소
        for(String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 해시맵을 순회하면서 값이 0이 아닌 키(참가자 이름)를 찾음
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return answer;
    }
}