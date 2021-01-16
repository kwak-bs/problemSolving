package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_3009 {
	// BOJ / 3009번 / 네 번째 점 / 구현, 기하학 / 브3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		
		int[] x = new int[3];
		int[] y = new int[3];
		int ans_x, ans_y;
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		if(x[0] == x[1]) {
			ans_x = x[2];
		}
		else {
			ans_x = (x[1] == x[2]) ? x[0] : x[1];
		}
		
		if(y[0] == y[1]) {
			ans_y = y[2];
		}
		else {
			ans_y = (y[1] == y[2]) ? y[0] : y[1];
		}
		
		System.out.println(ans_x + " " + ans_y);
	}

}
