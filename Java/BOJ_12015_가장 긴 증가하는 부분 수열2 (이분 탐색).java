package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12015 {
	// BOJ / 12015번 / 가장 긴 증가하는 부분 수열 2 / 이분 탐색 / 골드 2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int num [] = new int[n];
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add(0);
		for(int i=0; i<n; i++) {
			int value = num[i] = Integer.parseInt(stk.nextToken());
			
			if(al.get(al.size()-1) < value) {
				al.add(value);
			}
			else {
				int start = 0;
				int end = al.size()-1;
				
				while(start < end) {
					int mid = (start + end) / 2;
					
					if(al.get(mid) >= value) {
						end = mid;
					}
					else {
						start = mid + 1;
					}					
				}
				// value 값에 맞게 리스트를 최신화 한다.
				al.set(end, value);
			}
		}
		
		System.out.println(al.size() - 1);
	}
}
