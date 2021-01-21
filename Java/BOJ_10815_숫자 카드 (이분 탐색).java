package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
	//BOJ / 10816번 / 숫자 카드  / 이분 탐색 / 실4
	
	static int m, n;
	static int num[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine());
		
		num = new int [n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		// 들어온 배열을 오름차순으로 정렬.
		Arrays.sort(num);
		
		m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<m; i++) {
			int data = Integer.parseInt(stk.nextToken());
			
			if(binarySearch(data)) {
				sb.append(1 + " ");
			}
			else {
				sb.append(0 + " ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	// 이분 탐색
	public static boolean binarySearch(int number) {
		int leftIndex = 0;
		int rightIndex = n -1;
		
		while(leftIndex <= rightIndex) {
			int midIndex = (leftIndex + rightIndex) / 2;
			int mid = num[midIndex];
			
			if(number < mid) {
				rightIndex = midIndex - 1;
			}
			else if(number > mid) {
				leftIndex = midIndex + 1;
			}
			else return true;
		}
		return false;
	}
}
