package problemSolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2108 {
	// BOJ / 2108번 / 통계학 / 구현, 정렬 / 실4
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		//입력
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 1. 산술 평균 ,소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += arr[i];
		}
		System.out.println((int)Math.round((double)sum / n));
		
		// 2.중앙값
		Arrays.sort(arr);
		System.out.println(arr[arr.length/2]);
		
		// 3.최빈값 , 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
		int [] freq = new int [8001];

		int maxFreq = 0;
		int maxIdx = 0;
		boolean flag = false;
		
		// 이 부분에서 꽤나 고생함 이중 for문 (int j =0; j<freq.lenth)로 구성한 건 멍청한 실수였음.
		for(int i=0; i<arr.length; i++) {
			freq[arr[i]+4000]++;
			if(maxFreq < freq[arr[i]+4000]) {
				maxFreq = freq[arr[i]+4000];
			}
		}

		for(int i=0; i<freq.length; i++) {
			if(freq[i] == maxFreq) {
				if(flag) { // true일경우 , 즉 2번째일 경우
					maxIdx = i-4000;
					break;
				}
				maxIdx = i-4000; 
				flag = true; // 어차피 2번째가 최대빈도값이 아니더라도 if(freq[i] == maxFreq)에 속하지 않기 때문에 if문에 다시 들어올 수 없다.
			}
		}
		if(n == 1) {
			System.out.println(arr[0]);
		} else {
			System.out.println(maxIdx);			
		}
		
		// 4. 범위
		System.out.println(arr[arr.length-1] - arr[0]);
	}
}
