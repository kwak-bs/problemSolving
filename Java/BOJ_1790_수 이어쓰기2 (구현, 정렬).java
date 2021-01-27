package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1790 {
	// BOJ / 1790번 / 수 이어 쓰기 2 / 정렬, 구현 / 실1
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		long n = Integer.parseInt(stk.nextToken());
		long k = Integer.parseInt(stk.nextToken());
		
		long temp = k;
		long nCount = 9;
		long nLength = 1;
		long num = 0;
		
		while(temp > nCount * nLength) {
			temp -= nCount * nLength;
			
			num += nCount;
			
			nCount *= 10;
			nLength += 1;
			
		}
		
		// 최종적으로 num까지 숫자가 쌓인다. 
		// k는 1부터 가능하기 때문에 0부터 시작하는 배열에 맞게 -1 해준다.
		num = (num + 1) + (temp-1) / nLength ;
		
		if(num > n) {
			System.out.println(-1);
		}
		else {
			int index = (int)((temp-1) % nLength);
			System.out.println(Long.toString(num).charAt(index));
		}
	}
}
