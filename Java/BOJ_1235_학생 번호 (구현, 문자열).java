package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_1235 {
	// BOJ / 1235번 / 학생 번호 / 구현 / 실버4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String input[] = new String[n];
		
		for(int i=0; i<input.length; i++) {
			input[i] = br.readLine();
		}
		
		int k = 1;
		while(k < input[0].length()) {
			HashSet<String> set = new HashSet<>();
			for(int i=0; i<input.length; i++) {
				String number = input[i].substring(input[i].length()-k, input[i].length());
				set.add(number);
			}
			if(set.size() == n) {
				break;
			}
			k++;
		}
		System.out.println(k);
	}
}
