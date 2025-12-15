import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());                    // 컴퓨터 수
        M = Integer.parseInt(br.readLine().trim());                    // 연결 쌍 수
        
        graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];
        
        dfs(1);

        System.out.println(count);

    }

    // dfs
    static void dfs(int cur) {

        visited[cur] = true;
        
        // 현재 컴퓨터와 연결된 모든 컴퓨터 순회
        for(int next : graph[cur]) {
            
            // 아직 방문하지 않은 컴퓨터라면
            if(!visited[next]) {
                count++;                                // 감염된 컴퓨터 수 증가
                dfs(next);                              // 해당 컴퓨터로 DFS 진행
            }
        }
    }

}