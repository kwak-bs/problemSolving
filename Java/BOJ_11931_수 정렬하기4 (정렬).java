package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BOJ_11931 {
	// BOJ / 11931번 / 수 정렬하기 4 / 정렬 / 실버5
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		boolean []num = new boolean[2000001];
		
		for(int i=0; i<n; i++) {
			num[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		
		for(int i=num.length-1; i>=0; i--) {
			if(num[i]) {
				sb.append(i-1000000).append("\n");
			}
		}
		System.out.println(sb);
	}
}
