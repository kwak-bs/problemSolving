package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2920 {
	// BOJ / 2920번 / 음계 / 구현 / 브2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String asc = "1 2 3 4 5 6 7 8";
		String des = "8 7 6 5 4 3 2 1";
		
		String input = br.readLine();
		
		if(input.equals(asc)) {
			System.out.println("ascending");
		} else if(input.equals(des)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}
