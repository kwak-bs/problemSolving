package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;


public class BOJ_11478 {
	// BOJ / 11478번 / 서로 다른 부분 문자열의 개수 / 문자열 / 실버3


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String[] str = new String[s.length()];
		int answer = 0;
		for(int i=0; i<s.length(); i++) {
			str[i] = s.substring(i);
		}
		Arrays.sort(str);
		// 주어진 String이 가질 수 있는 모든 부분 문자열의 갯수에서 
		// lcp(최대 공통 접두사의 길이)의 총 합을 뺀다.
		answer += str[0].length();
		// 1. 어떤 부분 문자열은 어떤 접미사의 접두사이다. 
		// 2. 어떤 두 접미사끼리 서로 같은 부분이 있다면 그 부분은 부분문자열중 생김새가 같은 문자열이다. 
		// 3. 따라서 총 부분 문자열의 갯수에서 생김새가 같은 문자열(lcp)의 모든 갯수를 뺀다. 
		for(int i=1; i<str.length; i++)  {
			answer += (str[i].length() - getCommon(str[i-1], str[i]));
		}
		System.out.println(answer);
	}
	public static int getCommon (String s1, String s2) {
		int result = 0; 
		
		for(int i=0; i<s1.length(); i++) {
			if(i >= s2.length()) break;
			if(s1.charAt(i) == s2.charAt(i)) result++;
			else break;
		}
		return result;
	}
}
