package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10816 {
	//BOJ / 10816번 / 숫자 카드2  / 해쉬 / 실4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int card [] = new int [20000001]; // 음수 값도 고려한 배열 길이
		
		stk = new StringTokenizer(br.readLine(), " ");
		
	
		for(int i=0; i<n; i++) {
			card[Integer.parseInt(stk.nextToken())+10000000]++;
		}
		
		int m = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<m; i++) {
			sb.append(card[Integer.valueOf(stk.nextToken())+10000000] + " ");
		}
		
		System.out.println(sb.toString());
		// map을 쓰는 것 보다 배열을 만들어 생성하는 것이 더 시간이 효율적이라함. 
		// (생성시에 시간복잡도가 높다고 일단 판단.) 
		
	}
}
