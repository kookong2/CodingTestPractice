import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());                    // 전체 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());           // 시작 사람
        int target = Integer.parseInt(st.nextToken());          // 목표 사람

        int M = Integer.parseInt(br.readLine());                // 관계 수

        graph = new ArrayList[N+1];

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited = new boolean[N+1];

        dfs(start, target, 0);

        System.out.println(answer);

    }

    // dfs
    static void dfs(int now, int target, int cnt) {

        visited[now] = true;                                    // 현재 사람 방문 처리

        // 목표 사람에 도달
        if(now == target) {
            answer = cnt;                                       // 현재까지 누적된 촌수가 정답
            return;
        }

        // 현재 사람과 연결된 사람들 탐색
        for(int next : graph[now]) {
            if(!visited[next]) dfs(next, target, cnt+1);    // 아직 방문을 안했으면 촌수 + 1 더 깊이 탐색
        }
    }

}