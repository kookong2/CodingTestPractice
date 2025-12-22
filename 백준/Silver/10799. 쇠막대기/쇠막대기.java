import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        Deque<Character> stack = new ArrayDeque<>();
        int pieces = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                stack.pop(); // 일단 '(' 하나는 닫힘 (레이저든 막대끝이든)
                if (s.charAt(i - 1) == '(') {
                    // "()" 레이저: 현재 열려있는 막대 수만큼 조각 추가
                    pieces += stack.size();
                } else {
                    // 막대기 끝: 마지막 조각 1개 추가
                    pieces += 1;
                }
            }
        }

        System.out.println(pieces);
    }
}