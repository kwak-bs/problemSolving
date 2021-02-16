package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {
	// BOJ / 2609번 / 최대공약수와 최소공배수  / 수학 / 실5
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		int gcd = getGcd(Math.max(n, m), Math.min(n, m));
		
		int lcm = getLcm(Math.max(n, m), Math.min(n, m),gcd);
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	public static int getGcd(int a, int b) {
		int result = b;
		
		while(a % b != 0) {
			
			result = a % b;
			
			a = b;
			b = result;
		}
		
		return result;
	}
	
	public static int getLcm(int a, int b, int gcd) {
		
		return a*b/gcd;
	}
}
