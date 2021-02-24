package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
	// BOJ / 11723번 / 집합 / 비트마스킹 / 실버5
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		int S = 0;
		int n = 0;
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			String comm = stk.nextToken();
			
			if(!(comm.equals("empty") || comm.equals("all"))) {
				n = Integer.parseInt(stk.nextToken());
			}
			
			if(comm.equals("add")) {
				S = S | (1 << n);
			} 
			else if(comm.equals("check")) {
				if((S & (1 << n)) > 0) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			else if(comm.equals("remove")) {
				S = S & ~(1 << n);
			}
			else if(comm.equals("toggle")) {
				S = S ^ (1 << n);
			}
			else if(comm.equals("all")) {
				S = (1 << 21) -1;
			}
			else if(comm.equals("empty")) {
				S = 0;
			}
		}
		System.out.println(sb);
	}
}
