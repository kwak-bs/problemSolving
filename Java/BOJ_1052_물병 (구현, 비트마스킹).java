package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052 {
	// BOJ / 1052번 / 물병 / 구현, 비트마스킹 / 실버1
	static int n,k;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		int init = n;
		
		while(true) {
			int count = 0;
			int current = n;
			
			while(current != 0) {
				if(current % 2 != 0) {
					count++;
				}
				current = current >> 1;
			}
			
			if(count <= k) {
				break;
			}
			// 2의 보수와 &연산을 통해 가장 작은 자릿수를 더한다. 
			n+= n & (-n);
		}
		System.out.println(n - init);
	}
}
