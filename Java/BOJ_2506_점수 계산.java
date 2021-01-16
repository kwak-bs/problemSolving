package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2506 {
	// BOJ / 2506번 / 점수 계산 / 수학, 구현, 사칙연산 / 브3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		int sum = 0;
		int point = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(arr[0] == 0) { //첫 문제에 따라 sum 결정
			sum = 0;
		}
		else {
			sum = 1;
		}
		
		for(int i=1; i<arr.length; i++) { // 두 번째 문제부터 비교하면서 값 계산
			if(arr[i-1] == 1 && arr[i-1] == arr[i]) {
				point++;
				sum += point;
			}
			else if(arr[i] == 1 && arr[i-1] == 0){
				point = 1;
				sum += point;
			}
		}
		System.out.println(sum);
	}
}
