package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10973 {
	// BOJ / 10973번 / 이전 순열 / 수학 / 실3
	
	static int n;
	static int num[];
	static StringBuffer sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		num = new int [n];
		sb = new StringBuffer();
		boolean possible = false;
		int mark = 0;
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i=num.length-1; i>=1; i--) {
			// 좌측 인덱스 값이 더 큰 최초 인덱스를 mark에 저장 
			if(num[i] < num[i-1]) {
				possible = true;
				mark = i;
				break;
			}
		}
		
		if(possible) {
			solution(mark);
		}
		else {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}
	
	public static void solution(int mark) {
		int max = 0;
		int maxIdx = -1;
		
		for(int i=num.length-1; i>=mark; i--) {
			// 우측 영역중 mark-1의 값보다 작은 값들중 최댓값 선택 
			if(num[mark-1] > num[i]) {
				if(max < num[i]) {
					max = num[i];
					maxIdx = i;
				}
			}
		}
		
		// swap
		int temp = max;
		num[maxIdx] = num[mark-1];
		num[mark-1] = max;
		
		Integer ans[] = new Integer[n];
		
		// 레퍼 타입으로 변환 (내림차순을 위해)
		for(int i=0; i<n; i++) {
			ans[i] = num[i];
		}
		
		// 우측 영역 내림차순 정렬
		Arrays.sort(ans, mark, num.length, Collections.reverseOrder());
		
		for(int i=0; i<num.length; i++) {
			sb.append(ans[i]).append(" ");
		}
	}
}
