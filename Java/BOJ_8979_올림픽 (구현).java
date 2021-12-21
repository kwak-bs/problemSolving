package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_8979 {
	// BOJ / 8979번 / 올림픽 / 구현 / 실버5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		int arr[][] = new int[n+1][3];
		for(int i=1; i<=n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(stk.nextToken());
			int g= Integer.parseInt(stk.nextToken());
			int s= Integer.parseInt(stk.nextToken());
			int b= Integer.parseInt(stk.nextToken());
			arr[index][0] = g;
			arr[index][1] = s;
			arr[index][2] = b;
 		}
		
		int count = 1;
		for(int i=1; i<=n; i++) {
			if(i == k) continue;
			
			// 금 
			if(arr[i][0] > arr[k][0] ) {
				count++;
			}
			// 은
			else if(arr[i][0] == arr[k][0] && arr[i][1] > arr[k][1]) {
				count++;
			}
			// 동
			else if(arr[i][0] == arr[k][0] && arr[i][1] == arr[k][1] && arr[i][2] > arr[k][2]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
