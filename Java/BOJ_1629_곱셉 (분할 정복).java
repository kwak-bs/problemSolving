package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1629 {
	// BOJ / 1629¹ø / °ö¼À / ¼öÇÐ / ½Ç¹ö1
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");	
		
		long a = Long.parseLong(stk.nextToken());
		long b = Long.parseLong(stk.nextToken());
		long c = Long.parseLong(stk.nextToken());
		
		System.out.println(cal(a,b,c) % c);
	}
	
	public static long cal(long a , long b, long c) {
		// Àç±Í¸¦ ÀÌ¿ëÇÑ °ÅµìÁ¦°ö °ø½Ä
		if(b == 1) return a;
		long n = cal(a, b/2, c) %c;
		
		if(b % 2 == 0) return (n * n) % c;
		else return (((n*n)%c)*a)%c;
	}
}
