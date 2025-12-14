import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';   // 문자 1/0을 숫자로 변환
            }
        }

        bfs(0, 0);                           // 시작점은 (0, 0) = (1, 1)

        System.out.println(dist[N - 1][M - 1]); 


    }

    // BFS
    static void bfs(int sx, int sy) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sx, sy});                 // 시작 좌표를 큐에 넣기
        visited[sx][sy] = true;                     // 시작점 방문 처리
        dist[sx][sy] = 1;                           // 시작 칸도 지나간 칸 수에 포함이므로 1부터 시작

        while(!q.isEmpty()) {

            int[] cur = q.poll();                   // 현재 좌표 꺼내기
            int x = cur[0];
            int y = cur[1];

            // 4방향 탐색
            for(int dir = 0; dir < 4; dir++) {

                int nx = x + dx[dir];               // 다음 x
                int ny = y + dy[dir];               // 다음 y

                // 범위 밖이면 스킵
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽(0) 이면 스킵
                if(map[nx][ny] == 0) continue;

                // 이미 방문했다면 스킵
                if(visited[nx][ny]) continue;

                // 새로운 칸
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;      // 최단거리 갱신(현재거리 + 1)
                q.offer(new int[]{nx, ny});         // 큐에 넣어서 다음에 확장
            }
        }
    }
}