package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {
	// BOJ / 2798번 / 블랙잭 / 브루트포스 알고리즘/ 브2
	static int m, n;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//입력1
		n = Integer.parseInt(st.nextToken());
		m =	Integer.parseInt(st.nextToken());
		
		int [] input = new int [n];
		st = new StringTokenizer(br.readLine(), " ");
		
		//입력2
		for(int i=0; i<input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bF(input));
		
	}
	
	public static int bF(int[] input) {
		int sum = 0;
		
		// 카드는 총 3개. 첫 번째 카드는 0 ~ length-2, 두번째  1 ~ length-1, 세번째 2 ~ length까지
		for(int i=0; i<input.length - 2; i++) {
			for(int j= i+1; j<input.length -1; j++) {
				for(int k=j+1; k<input.length; k++) {
					//세 장의 카드를 더함
					int temp = input[i] + input[j] + input[k];
					
					// 같으면 return 및 종료.
					if( temp == m) {
						return temp;
					}
					
					// 다르면 sum 갱신 (단, 조건은 sum보다 크고 m보다 작을 경우 )
					else if(temp > sum && temp < m ){
						sum = temp;
					}
				}
			}
		}
		return sum;
	}
}
