import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] s;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String line = br.readLine();

            if (line == null || line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            s = new int[k];
            for(int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            selected = new int[6];
            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int idx, int depth) {

        if (depth == 6) {
            for(int i = 0; i < 6; i++) {
                sb.append(selected[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for(int i = idx; i < k; i++) {
            selected[depth] = s[i];
            dfs(i+1, depth+1);
        }
    }

}