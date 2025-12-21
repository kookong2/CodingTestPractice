class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;

        // n개 컴퓨터에 대한 방문 배열 초기화
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
        
    }
    
    void dfs(int cur, int n, int[][] computers) {
        // 현재 컴퓨터를 방문 처리
        visited[cur] = true;
        
        // cur과 연결 가능한 모든 컴퓨터를 확인
        for(int next = 0; next < n; next++) {
            // 연결되어 있고 아직 방문을 안한 경우
            if(computers[cur][next] == 1 && !visited[next]) {
                // 그 컴퓨터로 이동해서 계속 탐색
                dfs(next, n, computers);
            }
        }
    }
}