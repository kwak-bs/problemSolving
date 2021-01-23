package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {
	// BOJ / 17219번 / 비밀번호 찾기 /	해쉬 / 실4
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			map.put(stk.nextToken(), stk.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			System.out.println(map.get(br.readLine()));
		}
	}
}
