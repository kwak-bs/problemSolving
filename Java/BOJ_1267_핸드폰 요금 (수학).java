package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1267 {
	// BOJ / 1267번 / 핸드폰 요금 / 수학 / 브론즈3
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int y = 0;
		int m =0;
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			int t = Integer.parseInt(stk.nextToken());
			
			int tempy = t / 30;
			y += (10 + (tempy *10));
			
			int tempm = t / 60;
			m += (15 + (tempm *15));
		}
		
		if(y < m) {
			System.out.println("Y " + y);
		}
		else if(y > m) {
			System.out.println("M " + m);
		}
		else {
			System.out.println("Y M "+y);
		}
	}
}
