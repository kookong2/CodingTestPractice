import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine();

        HashMap<String, Integer> map = new HashMap<>();
        String strTemp = "";
        for (int i = 1; i < S.length() + 1; i++) {
            strTemp += S.charAt(i - 1);
            if (i % 3 == 0) {
                map.put(strTemp, map.getOrDefault(strTemp, 0) + 1);
                strTemp = "";
            }
        }
        Boolean b = false;
        int[] PKHT = {13, 13, 13, 13};
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                b = true;
            }
            switch (key.charAt(0)) {
                case 'P':
                    PKHT[0]--;
                    break;
                case 'K':
                    PKHT[1]--;
                    break;
                case 'H':
                    PKHT[2]--;
                    break;
                case 'T':
                    PKHT[3]--;
                    break;
            }
        }
        if (b) {
            System.out.println("GRESKA");
        } else {
            System.out.println(PKHT[0] + " " + PKHT[1] + " " + PKHT[2] + " " + PKHT[3] + " ");
        }
    }
}