import java.util.*;
import java.io.*;

public class Main {

    static int N,d,k,c,arr[],eat[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken()); 
		 d = Integer.parseInt(st.nextToken()); 
		 k = Integer.parseInt(st.nextToken()); 
		 c = Integer.parseInt(st.nextToken()); 
		 arr = new int[N];
		 eat = new int[d+1]; 
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(slide());
    }
        
        private static int slide() {
        eat[c] = 3001;
		int type = 1;
		for(int i=0; i<k; i++) {
			if(eat[arr[i]] <= 0) type ++;
			eat[arr[i]] ++;
		}
		
		int max = type;
		for(int i=0; i<N; i++) {
			
			int end = (i+k)%N;
			
			if(--eat[arr[i]] == 0) type-- ;
			if(eat[arr[end]]++ == 0) type ++;
			
			max = Math.max(max, type);
		}
		
		return max;
	}

}