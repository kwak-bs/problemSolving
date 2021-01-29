package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5052 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			String arr [] = new String[n]; 
			boolean result = true;
			
			for(int i=0; i<n; i++) {
				arr[i] = br.readLine();
			}
			
			// 탐색을 최소화 하기 위해 정렬을 한다. 
			Arrays.sort(arr);
			
			for(int i =1; i<n; i++) {
				// 비교하려는 두 문자열이 접두어가 같으면 false
				if(arr[i].startsWith(arr[i-1])) {
					result = false;
					break;
				}
			}
			
			if(result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
