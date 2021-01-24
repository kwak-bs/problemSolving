package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425 {
	// BOJ / 14425번 / 문자열 집합 / 해쉬 / 실3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		HashSet<String> set = new HashSet<>();
		int answer = 0;
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		
		for(int i=0; i<m; i++) {
			String test = br.readLine();
			
			if(set.contains(test)) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
