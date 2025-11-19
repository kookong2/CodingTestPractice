import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int result = Integer.parseInt(br.readLine());
        
        while (true){
            String s = br.readLine();
            
            if(s.equals("=")) break;
            
            int num = Integer.parseInt(br.readLine());
            
            if(s.equals("+")) result += num;
            else if(s.equals("-")) result -= num;
            else if(s.equals("*")) result *= num;
            else result /= num;
        }

        System.out.println(result);
    }
}