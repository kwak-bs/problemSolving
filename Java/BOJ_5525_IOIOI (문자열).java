package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525 {
	// BOJ / 5525번 / IOIOI / 분할 정복 / 실버2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		char arr [] = br.readLine().toCharArray();
		
		int count = IOIOI(arr, n, m);
		
		System.out.println(count);
	}
	
	public static int IOIOI(char[] arr, int n, int m) {
		int answer = 0;
		int patternCnt = 0;
		
		for(int i=1; i<m-1; i++) {
			if(arr[i-1] == 'I' && arr[i] == 'O' && arr[i+1] == 'I') {
				patternCnt++;
				
				if(patternCnt == n) {
					answer++;
					patternCnt--; // 다음 인덱스의 패턴을 확인 할 때 중복되므로 미리 하나 빼줘야함
				}
				
				i++; // 'O'를 기준으로 비교해야하기 때문에 두 칸을 뛴다. 
			}
			// 패턴과 다를 땐 카운트를 0으로 해준다. 
			else patternCnt = 0;
		}
		return answer;
	}
}
