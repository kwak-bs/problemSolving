package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819 {
	// BOJ / 10819번 / 차이를 최대로 / 브루트포스 / 실2
	
	static int n, ans;
	static int num[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = 0;
		num = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		// 첫 순열부터 탐색하기 위해 정렬.
		Arrays.sort(num);
		
		do {
			int max = 0;
			
			for(int i=0; i<n-1; i++) {
				max += Math.abs(num[i] - num[i+1]);
			}
			ans = Math.max(ans, max);
		} while(next_permutation());
		
		System.out.println(ans);
	}
	
	public static boolean next_permutation() {
		int i = num.length-1;
		
		// 오른쪽 영역이 내림차순이 끝나는 시점.
		while(i>0 && num[i-1] >= num[i]) {
			i -= 1;
		}
		
		// 다음 순열이 없을때
		if(i <= 0) {
			return false;
		}
		
		// 우측 영역 비교
		int j = num.length-1;
		while(num[j] <= num[i-1]) {
			j -= 1;
		}
		
		// swap
		int temp = num[i-1];
		num[i-1] = num[j];
		num[j] = temp;
		
		// 오름차순
		j = num.length-1;
		while(i<j) {
			temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			
			i++;
			j--;
		}
		return true;
	}
}
