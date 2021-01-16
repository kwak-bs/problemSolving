package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2953 {

	// BOJ 나는 요리사다  / 2953  / 수학, 구현, 사칙연산 / 브3 
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] num = new int[4];
		int sum = 0;
		int [] sum_arr = new int[5];

		
		for(int i=0; i<5; i++) { // 입력 , sum_arr에 합의 값들 넣어줌
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<4; j++) {
				num[j] = Integer.parseInt(st.nextToken());
				sum += num[j];
			}
			sum_arr[i] = sum; 
			sum =0;
		}
		
		int max = sum_arr[0];
		int idx = 0;
		
		for(int i=1; i<5; i++) { // 비교 
			if(max < sum_arr[i]) {
				max = sum_arr[i];
				idx = i;
			}
		}
		System.out.println((idx+1)+" "+ max);
	}
}
