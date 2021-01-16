package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1547 {
	//BOJ / 1547번 /  공 / 구현 / 브3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		
		boolean [] cup = new boolean[4];
		
		cup[1] = true; // 공이 있는 컵 위치 
		cup[2] = false;
		cup[3] = false;
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			boolean temp = false;
			temp = cup[y]; // 1번 컵에 항상 공이 있으니 1번 컵을 기준으로 swap
			cup[y] = cup[x];
			cup[x] = temp;
		}
		
		for(int i=1; i<cup.length; i++) {
			if(cup[i] == true) {
				System.out.println(i);
				break;
			}
		}
	}
}
