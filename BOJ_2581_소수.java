package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2581 {
	// BOJ / 2563번 / 소수 / 수학, 정수론, 소수 판정 / 실4
	static int min;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st2.nextToken());
		
		min = Integer.MAX_VALUE;
		sum = 0;

		for(int i=m; i<=n; i++) {
			isPrime(i);
		}

		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	
	public static void isPrime(int num) {
		if( num < 2 ) {
			return;
		}
		
		for(int i = 2; i<num; i++) {
			if(num % i ==0) {
				return;
			}
		}
		
		//소수면 sum에 더함
		sum += num;
		
		// 최솟값 바꿔줌
		if(min > num) {
			min = num;
		}
	}
}
