package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1138 {
	// BOJ / 1138번 / 한 줄로 서기 / 구현 / 실버2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] h = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			h[i] = Integer.parseInt(stk.nextToken());
		}
		ArrayList<Integer> answer = new ArrayList<>();
		// 키가 큰 사람부터 위치를 잡아준다.
		for(int i=n; i>0; i--) {
			answer.add(h[i-1], i);
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i)+ " ");
		}
	}
}
