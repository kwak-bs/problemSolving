package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_1972 {
	// BOJ / 1972번 / 놀라운 문자열 / 해쉬셋 / 실버3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			
			if(input.equals("*")) {
				break;
			}
			
			if(surprising(input)) {
				sb.append(input + " is surprising.\n");
			}
			else {
				sb.append(input + " is NOT surprising.\n");
			}
		}
		System.out.print(sb);
	}
	
	public static boolean surprising(String s) {
		int D = 0;
		int size = s.length()-2;
		// set으로 surprising한지 판단한다.
		while(D <= size) {
			HashSet<String> set = new HashSet<>();
			for(int i=0; i<=size; i++) {
				if(i+1+D < s.length()) {
					String temp = s.charAt(i)+"" + s.charAt(i+1+D)+"";
					if(!set.add(temp)) {
						return false;
					}
				}
			}
			D++;
		}
		
		
		return true;
	}
}
