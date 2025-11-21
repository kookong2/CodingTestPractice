import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < c; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int [] scores = new int[n];
            double sum = 0;
            for(int j = 0; j < n; j++){
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }

            sum /= (double)n;
            double count = 0;
            for(int j = 0; j < n; j++){
                if(scores[j] > sum){
                    count++;
                }
            }

            count /= (double)n;
            count *= 100;
            String s = String.format("%.3f", count);
            sb.append(s + "%\n");
        }

        System.out.println(sb);

    }
}