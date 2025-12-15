import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());                    // 컴퓨터 수
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {

            String line = br.readLine().trim();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> sizes = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                // 집(1)이고 아직 방문 전이면 새 단지 시작
                if(map[i][j] == 1 && !visited[i][j]){
                    cnt = 0;
                    dfs(i, j);
                    sizes.add(cnt);
                }
            }
        }

        Collections.sort(sizes);                            // 오름차순 정렬
        System.out.println(sizes.size());                   // 단지 수 출력
        for(int size : sizes) System.out.println(size);       // 단지별 집 수 출력
    }

    // dfs
    static void dfs(int r, int c) {

        visited[r][c] = true;                               // 방문 처리
        cnt++;                                              // 집 개수 증가

        for(int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            // 범위 안 + 방문 안함 + 집(1)인 경우만 탐색
            if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) dfs(nr, nc);
        }
    }

}