package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14720 {
	// BOJ 우유 축제  / 14720  / 구현,그리디 알고리즘, dp / 브3 
	public static void main(String[] args) throws IOException {
		// 딸기우유 0 -> 초코우유 1 -> 바나나 우유 2 -> 딸기 우유 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		
		while(N-- > 0) {
			if(Integer.parseInt(st.nextToken()) == count%3){
				count++;
			}
		}
		System.out.println(count);
	}
}
