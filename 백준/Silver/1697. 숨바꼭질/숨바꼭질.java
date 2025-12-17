import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int result = bfs(N, K);

        System.out.println(result);
    }
    
    static int bfs(int start, int target) {
        
        int[] dist = new int[MAX + 1];                  // 각 위치까지의 시간 기록
        Arrays.fill(dist, -1);                      // 방문하지 않은 곳은 -1로 초기화

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();                         // 현재 위치를 꺼냄
            
            if(cur == target) return dist[cur];         // 목표 위치에 도달했다면 해당 위치까지 걸린 시간 반환
            
            int next1 = cur - 1;                        // 이동 경우 1: -1
            if(next1 >= 0 && dist[next1] == -1) {
                dist[next1] = dist[cur] + 1;
                q.add(next1);
            }
            
            int next2 = cur + 1;
            if(next2 <= MAX && dist[next2] == -1) {     // 이동 경우 2: +1
                dist[next2] = dist[cur] + 1;
                q.add(next2);
            }
            
            int next3 = cur * 2;
            if(next3 <= MAX && dist[next3] == -1) {     // 이동 경우 3: *2
                dist[next3] = dist[cur] + 1;
                q.add(next3);
            }
        }
        
        return -1;
    }

}