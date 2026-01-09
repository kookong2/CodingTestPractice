import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void move(int N, int start, int mid, int end)  {

        // N이 1일 때 재귀함수 종료 메소드 작성
        if(N==1) {
            sb.append(start + " " + end).append("\n");
            return;
        }

        move(N-1,start,end,mid); // 1~N-1 원판까지 mid 위치로 이동하기 위한 함수
        sb.append(start + " " + end).append("\n"); // N 원판을 end 위치로 옮기는 함수
        move(N-1,mid,start,end); // 1~N-1 원판들을 mid 위치에서 end 위치로 옮기는 함수 
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 원판의 개수 입력

        //하노이 탑은 최소 [2^n -1] 번 움직임으로 모두 옮길 수 있습니다.
        sb.append((int) (Math.pow(2,N)-1)).append("\n");

        move(N,1,2,3);

        System.out.println(sb);


    }
}
