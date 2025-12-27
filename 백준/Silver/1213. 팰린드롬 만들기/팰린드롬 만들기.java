import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] counter;
    static String str;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        counter = new int[26];
        sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            counter[c - 'A'] += 1;
        }

        if (!isPalindrome()) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < counter.length; i++) {
            for (int j = 1; j <= counter[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }

            counter[i] = counter[i] % 2;
        }

        String left = sb.toString();
        String right = sb.reverse().toString();

        System.out.println(left + getCenter() + right);
    }

    private static String getCenter() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 1) sb.append((char) (i + 'A'));
        }

        return sb.toString();
    }

    private static boolean isPalindrome() {
        int oddCount = 0;
        for (int count : counter) {
            if (count % 2 == 1) oddCount++;
        }

        return oddCount <= 1;
    }
}