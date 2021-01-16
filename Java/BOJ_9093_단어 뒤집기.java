package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9093 {
	// BOJ / 9093번 / 단어 뒤집기 / 문자열 / 브1
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 스택 사용해봣는데 시간 초과뜸 
		for(int i =0 ; i<n; i++) {
			String input = br.readLine();
			String [] temp = input.split(" ");
			
			for(int j=0; j<temp.length; j++) {
				StringBuffer sf = new StringBuffer(temp[j]);
				System.out.print(sf.reverse()+" ");
			}
			System.out.println();
		}
	}
}
