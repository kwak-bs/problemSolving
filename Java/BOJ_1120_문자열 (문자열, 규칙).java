package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120 {
	// BOJ / 1120번 / 문자열 / 문자열 / 실버4
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		
		String a = stk.nextToken();
		String b = stk.nextToken();
		
		// a와 b가 최대로 같은 지점을 미리 찾는다. (중앙에 위치) 
		// 그 다음 앞 뒤의 차이를 빼준다. 
		int max = 0;
		
		for(int i=0; i<=b.length()-a.length(); i++) {
			String temp = b.substring(i, i+a.length());
			int count = 0;
			for(int j=0; j<a.length(); j++) {
				if(temp.charAt(j) == a.charAt(j)) {
					count++;
				}
			}
			
			max = Math.max(max, count);
		}
		System.out.println(a.length() - max);
	}
}
