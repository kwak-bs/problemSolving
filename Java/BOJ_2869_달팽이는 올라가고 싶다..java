package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {
	// BOJ / 2869번 / 달팽이는 올라가고 싶다 / 수학 / 브2
	// 시간초과 주의해야 하는 문제다 for문 금지. 수학적으로 접근해야함
	public static void main(String[] args) throws IOException {
		
		long st = System.currentTimeMillis();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(stn.nextToken());
		int b = Integer.parseInt(stn.nextToken());
		int v = Integer.parseInt(stn.nextToken());
		
		int day = 0; // 올라가는 일
		
		day = ( v - b ) / (a - b) ; // ( 총 높이 - 내려가는 길이) / ( 올라가는 길이 - 내려가는 길이)
		
		if( ( v - b ) % (a - b) != 0 )
			day++;
		
		System.out.println(day);
		
		long et = System.currentTimeMillis();
		long dt = et - st;
		System.out.println("걸린 시간: " + dt/1000.0 + " 초");
		
	}
}
