package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_18870 {
	// BOJ / 18870번 / 좌표 압축 / 정렬  / 실버2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		
		int num[] = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int temp[] = num.clone();
		
		Arrays.sort(num);
		
		int cnt = 0;
		int flag = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			if(flag == num[i]) continue;

			hm.put(num[i], cnt++);
			flag = num[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i : temp) {
			sb.append(hm.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}
