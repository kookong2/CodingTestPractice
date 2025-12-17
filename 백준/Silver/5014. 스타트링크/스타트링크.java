import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dist = new int[F + 1];                        // dist[x] = x 층까지 버튼 누른 횟수
        Arrays.fill(dist, -1);                          // 방문하지 않은 층은 -1로 표시

        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);                                           // 시작 층을 큐에 넣기
        dist[S] = 0;                                        // 시작 층은 0번 누른 상태로 방문 처리

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == G) break;                            // 목표 층이면 종료

            int up = cur + U;                               // 위로 이동했을 때 계산
            if(up <= F && dist[up] == -1) {                 // 건물 범위 안이고 아직 방문 안했으면
                dist[up] = dist[cur] + 1;                   // 버튼 1번 더 누른 거리로 기록
                q.add(up);
            }

            int down = cur - D;                             // 아래로 이동했을 때 층 계산
            if(down >= 1 && dist[down] == -1) {             // 1층 이사이고 아직 방문 안 했으면
                dist[down] = dist[cur] + 1;                 // 버튼 1번 더 누른 거리로 기록
                q.add(down);                                // 다음 탐색 대상으로 큐에 추가
            }
        }

        if(dist[G] == -1) {                                 // 목표 층에 도달하지 못했다면
            System.out.println("use the stairs");           // 요구 문구 출력
        } else {                                            // 도달 했다면
            System.out.println(dist[G]);                    // 최소 버튼 횟수 출력
        }
    }

}