import java.util.*;

class Solution {
    
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        // 세로 길이 저장
        n = maps.length;
        // 가로 길이 저장
        m = maps[0].length;
    
        return bfs(maps);
    }
    
    public int bfs(int[][] maps){
        
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        // 시작 좌표를 큐에 삽입
        q.offer(new int[] {0, 0});
        // 시작 지점 거리 1로 설정
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            
            // 현재 좌표 꺼내기
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            // 4방향 탐색
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // 맵 범위 체크, 범위 밖이면 무시
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                
                // 벽이면 이동 불가
                if(maps[nr][nc] == 0) {
                    continue;
                }
                
                // 이미 방문한 칸이면
                if(dist[nr][nc] != 0) {
                    continue;
                }
                
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[] {nr, nc});
            }
        }
        
        // 도착점에 도달 못했으면
        if(dist[n - 1][m - 1] == 0) return -1;

        // 도착점 최단거리 반환
        return dist[n - 1][m - 1];
    }
}