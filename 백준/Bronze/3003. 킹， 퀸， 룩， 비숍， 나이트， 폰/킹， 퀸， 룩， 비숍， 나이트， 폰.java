import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr1 = new int[6];
        int [] arr2 = {1,1,2,2,2,8};
        int [] answer = new int[6];

        for(int i = 0; i < 6; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
            answer[i] = arr2[i] - arr1[i];
        }

        for(int i = 0; i < 6; i++){
            System.out.print(answer[i] + " ");
        }
    }
}