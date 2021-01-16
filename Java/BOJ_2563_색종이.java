package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {
	// BOJ / 2563번 / 색종이 / 구현, 브루트포스 알고리즘 / 실5
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		boolean arr [][] = new boolean[101][101];
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 점 하나당 넓이는 1이다.
			for(int j = x; j < x+10; j++) {
				for(int k=y; k< y+10; k++) {
					if(arr[j][k] == true) {
						continue;
					}
					else{
						arr[j][k] = true;						
					}
				}
			}
		}
		
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				if(arr[i][j] == true) {
					sum++;
				}
			}
		}
		
		System.out.println(sum);
	}

}
