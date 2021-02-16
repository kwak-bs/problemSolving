package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
	// BOJ / 6588번 / 골드 바흐의 추측  / 수학 / 실1
	static final int N = 1000000;
	static boolean prime[] = new boolean[N+1];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		makePrime();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				break;
			}
			
			int mid = n /2;

			boolean flag = false;
			
			for(int i=2; i<=mid; i++) {
				if(!prime[i] && !prime[n-i] ) {
					flag = true;
					sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
					break;
				}
			}

			if(!flag) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void makePrime() {
		
		// 1은 소수가 아니다. 
		// 소수는 false, 소수가 아니면 true
		prime[0] = prime[1] = true; 
		
		for(int i=2; i<Math.sqrt(N)+1; i++) {
			
			if(prime[i] == true) {
				continue;
			}
			for(int j=i*i ; j< N+1; j = j+i ) {
				prime[j] = true;
			}
		}
	}
}
