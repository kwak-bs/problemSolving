package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
	// BOJ / 11729번 / 하노이 탑 이동 순서 / 재귀 / 실버1
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int) (Math.pow(2, n)-1)).append("\n");
		
		Hanoi(n,1,2,3);
		
		System.out.println(sb);
	}
	/*
	 * n : 원판의 갯수
	 * start : 출발지 
	 * mid : 중간지점 (도착지로 가기 위한 이동해야 하는 장소)
	 * end : 목적지
	 */
	public static void Hanoi(int n, int start, int via, int end) {

		if(n == 1) {
			sb.append(start + " " + end).append("\n");
			return;
		}
		
		// N-1개를 1 -> 2로 이동
		Hanoi(n-1, start, end, via);
		
		// 1개를 1 -> 3로 이동
		sb.append(start + " " + end).append("\n");
		
		// n-1개를 다시 2 -> 3로 이동
		Hanoi(n-1, via, start, end);
	}
}
