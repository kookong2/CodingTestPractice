import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        long t = Long.parseLong(br.readLine());

        long tempX = (x + t) %(2L * w);
        if(tempX > w) tempX = 2L * w - tempX;

        long tempY = (y + t) %(2L * h);
        if(tempY > h) tempY = 2L * h - tempY;

        System.out.println(tempX + " " + tempY);

    }
}