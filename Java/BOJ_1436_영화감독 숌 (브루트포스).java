package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {
	// BOJ / 1436번 / 영화감독 숌 / 브루트포스 / 실버5
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		
		int num = 0;
		
		while(n > 0) {
			num++;
			String s = Integer.toString(num);
			
			if(s.contains("666")) {
				n--;
			}
		}
		
		System.out.println(num);
	}
}
