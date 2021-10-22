package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1292 {
	// BOJ / 1292번 / 쉽게 푸는 문제 / 구현 / 실버5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		
		int num[] = new int[1001];
		int answer = 0;
		int index = 1;
		loop :
		for(int i=1; i<=1000; i++) {
			for(int j=index; j<index+i; j++) {
				if(j > 1000) {
					break loop;
				}
				num[j] = i;
			}
			index += i;
		}
		
		for(int i=a; i<=b; i++) {
			answer += num[i];
		}
		System.out.println(answer);
	}

}
