import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 인접 행렬 생성 ( 정점 번호 1 ~ N )
        graph = new int[N+1][N+1];

        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb.toString());

    }

    // DFS
    static void dfs(int now) {

        visited[now] = true;            // 현재 정점 방문 처리
        sb.append(now).append(' ');     // 방문 순서 기록(출력)

        // 인접 행렬은 i를 1부터 증가시키면 작은 번호부터 보장
        for(int i = 1; i <= N; i++) {
            if(graph[now][i] == 1 && !visited[i]) dfs(i);
        }
    }

    // BFS
    static void bfs(int start) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);             // 시작 정점을 큐에 넣기
        visited[start] = true;          // 큐에 넣는 순간 방문 처리

        while(!queue.isEmpty()) {       // 큐가 빌 때까지 반복

            int now = queue.poll();     // 큐에서 하나 꺼내기
            sb.append(now).append(' '); // 방문 순서 기록 (출력)

            for(int i = 1; i <= N; i++) {
                if(graph[now][i] == 1 && !visited[i]) {
                    
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}