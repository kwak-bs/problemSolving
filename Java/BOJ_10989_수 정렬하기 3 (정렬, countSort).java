package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989 {
	// BOJ / 10989번 / 수 정렬하기 3 / 정렬 / 실버 5
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[100001];
		
		for(int i=0; i<n; i++) {
			num[Integer.parseInt(br.readLine())]++;
		}
		
		
		for(int i=1; i< 10001; i++) {
			while(num[i]>0) {
				sb.append(i).append('\n');
				num[i]--;
			}
		}
		
		System.out.println(sb);
	}
}
