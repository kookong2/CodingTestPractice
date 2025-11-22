import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int year = 2007;
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        System.out.println(week[dayOfWeek.getValue() - 1]);
    }
}