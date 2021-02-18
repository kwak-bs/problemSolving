package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1748 {
	// BOJ / 1748번 / 수 이어 쓰기1  / 수학 / 실3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String strN = br.readLine();
		int n = Integer.parseInt(strN);
		
		int nine = 9;
		int count = 0;
		int temp = 0;
		for(int i=1; i<strN.length(); i++) {
			temp += nine;
			count += nine * i;
			
			nine *= 10;
		}
		int result = count + (strN.length() * (n - temp));
		
		System.out.println(result);
	}
}
