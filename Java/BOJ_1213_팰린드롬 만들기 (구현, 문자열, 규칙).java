package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {
	// BOJ / 1213번 / 팰린드롬 만들기 / 구현 / 실버4
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int [] alp = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			alp[str.charAt(i)-'A']++;
		}
		
		int midIndex = 0, odd = 0;
		
		for(int i=0; i<alp.length; i++) {
			if(alp[i] % 2 != 0) {
				midIndex = i;
				odd++;
			}
		}
		// 짝수일 때는 홀수 갯수가 존재하면 안되고, 홀수 일 때는 홀수 갯수가 1이상 존재하면 안됨
		if((str.length() % 2 == 0 && odd > 0) ||  (str.length() % 2 != 0 && odd > 1)) {
			System.out.println("I'm Sorry Hansoo");
		}
		else {
			StringBuilder answer = new StringBuilder();
			StringBuilder reverse = new StringBuilder();
			// 알파벳 갯수 / 2 만큼 앞에다가 추가 + midIndex 알파벳 + reverse 한 값 
			for(int i=0; i<alp.length; i++) {
				for(int j=0; j<alp[i]/2; j++) {
					String value= (char)(i+'A')+"";
					reverse.append(value);
				}
			}
			answer.append(reverse);
			if(str.length() % 2 != 0) answer.append((char)(midIndex + 'A')+"");
			answer.append(reverse.reverse().toString());
			System.out.println(answer);
		}
	}
}
