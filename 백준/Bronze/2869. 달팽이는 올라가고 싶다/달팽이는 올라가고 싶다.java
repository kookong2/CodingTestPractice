import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int up = scanner.nextInt();
        int down = scanner.nextInt();
        int length = scanner.nextInt();

        int day = (length - down) / (up - down);

        if((length - down) % (up - down) != 0) {
            day++;
        }

        System.out.println(day);

    }
}