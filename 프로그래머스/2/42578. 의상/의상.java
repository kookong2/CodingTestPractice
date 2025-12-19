import java.util.*; 

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();   
        
        int answer = 1;
        
        for(int i = 0; i < clothes.length; i++) {
            // 의상 종류 별로 몇개씩 있는지 hash에 저장해주기
            // getOrDefult(key, 0) 있으면 key 반환 없으면 0 반환
            // 의상이 있으면 기존 개수 + 1 없으면 0 + 1
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); 
            
            // 위 코드가 이것과 같음
            // if (map.containsKey(type)) {
            //     map.put(type, map.get(type) + 1);
            // } else {
            //     map.put(type, 1);
            // }
        }
        

        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);   // 조합 -> 안입는 경우도 고려하기 위해 + 1
        }
        
        answer -= 1; // 모두 안입음일 경우가 들어가 있으므로 -1 해주기
        
        // 전체 흐름
        // 1. 의상 종류별로 개수를 센다.
        // 2. 각 종류마다 입는다 / 안입는다를 고려해 곱한다.
        // 3. 전부 안 입는 경우를 생각해 1을 뺀다.
        
        return answer;
    }
}