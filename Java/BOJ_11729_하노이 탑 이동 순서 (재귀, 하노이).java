package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
	// BOJ / 11729�� / �ϳ��� ž �̵� ���� / ��� / �ǹ�1
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int) (Math.pow(2, n)-1)).append("\n");
		
		Hanoi(n,1,2,3);
		
		System.out.println(sb);
	}
	/*
	 * n : ������ ����
	 * start : ����� 
	 * mid : �߰����� (�������� ���� ���� �̵��ؾ� �ϴ� ���)
	 * end : ������
	 */
	public static void Hanoi(int n, int start, int via, int end) {

		if(n == 1) {
			sb.append(start + " " + end).append("\n");
			return;
		}
		
		// N-1���� 1 -> 2�� �̵�
		Hanoi(n-1, start, end, via);
		
		// 1���� 1 -> 3�� �̵�
		sb.append(start + " " + end).append("\n");
		
		// n-1���� �ٽ� 2 -> 3�� �̵�
		Hanoi(n-1, via, start, end);
	}
}
