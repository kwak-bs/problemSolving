package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
	// BOJ / 13305�� / ������ / �׸��� / �ǹ�4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // ������ ����
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int road[] = new int[n-1]; // ���ø� �մ� ������ ����
		
		for(int i=0; i<n-1; i++) {
			road[i] = Integer.parseInt(stk.nextToken());
		}
		
		int cost[] = new int[n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(stk.nextToken());
		}
		
		// �������� ����. -> �ּ� �⸧������ ������ �� �ִ�.
		// 5 -> 2 -> 4 -> 1  => 5 -> 2 -> 2 -> 1;
		
		long answer = 0; // ����� �� ��
		long minCost = cost[0]; // ��������� �ּ� �⸧��.
		for(int i=0; i<road.length; i++) {
			if(minCost > cost[i]) {
				minCost = cost[i];
			}
			answer += (road[i] * minCost);
		}
		
		System.out.println(answer);
	}
}