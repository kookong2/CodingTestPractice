import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < tCase; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.add(new int[]{j, num});
                pq.add(num);
            }

            int cnt = 0;

            while (!q.isEmpty()) {
                int[] cur = q.poll();                   // 맨 앞 문서 꺼내기

                if(cur[1] == pq.peek()) {               // 현재 문서가 최고 중요도면 출력
                    pq.poll();                          // 최고 중요도 제거
                    cnt++;                              // 출력 횟수

                    if(cur[0] == M) break;              // 찾는 문서면 종료
                } else {                                // 최고 중요도가 아니며
                    q.add(cur);                         // 뒤로 보내기
                }
            }

            System.out.println(cnt);
        }
    }

}