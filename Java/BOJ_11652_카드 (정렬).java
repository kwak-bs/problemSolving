package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_11652 {
	// BOJ / 11652번 / 카드 / 정렬 / 실버 4
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		long card [] = new long[n];
		
		for(int i=0; i<n; i++) {
			card[i] = Long.parseLong(br.readLine());
		}
		// 오름차순 정렬이므로, 같은 갯수를 같는 카드라면 어차피 작은 수가 answer로 지정됨.
		Arrays.sort(card);
		
		int count = 1; // 최소 1장은 존재하기 때문
		int max = 1; 
		
		// 처음에 0으로 초기화 해줄라고 했다가 생각해보니 
		// 모든 카드들이 1장씩 밖에 없으면 0이 출력됨 그래서 
		// 첫 번째 인덱스로 초기화
		long answer = card[0];
		
		for(int i=1; i<n; i++) {
			// 이 전의 카드와 같은 카드면 count 증가
			if(card[i] == card[i-1]) {
				count++;
			} else {
				// 아니면 다시 1로 초기화.
				count = 1;
			}
			
			if(max < count ) {
				max = count;
				answer = card[i];
			}
		}
		
		System.out.println(answer);
	}
}

