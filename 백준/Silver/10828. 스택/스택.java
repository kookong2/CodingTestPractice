import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stack = new int[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            switch (cmd[0]) {
                case "push":
                    int num = Integer.parseInt(cmd[1]);
                    push(num);
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }

        System.out.print(sb.toString());
    }

    public static void push(int num) {
        stack[size] = num;
        size++;
    }

    public static int pop() {
        if(size == 0) return -1;
        else {
            int res = stack[size-1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0) return 1;
        else return 0;
    }

    public static int top(){
        if(size == 0) return -1;
        else return stack[size - 1];
    }
}