package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {
	//BOJ / 10870번 / 피보나치 수 5 / 수학, DP / 브2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) { // 0 예외처리. 안하면 런타임 에러뜸 
			System.out.println(0);
			return;
		}
		
		int f[] = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		
		for(int i=2; i<f.length; i++) {
			f[i] = f[i-2]+f[i-1];
		}

		if(n == 1) {
			System.out.println(1);
		} else {
			System.out.println(f[n]);			
		}
	}
}
