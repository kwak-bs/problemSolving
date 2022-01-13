package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024 {
	// BOJ / 1024�� / ������ �� / ? / �ǹ�2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken()); // �迭 ����� ��
		int l = Integer.parseInt(stk.nextToken()); // �迭 �ּ� ����
		StringBuilder sb = new StringBuilder();
		boolean brk = false;
		
		while(l <= 100) {
			// ¦���� 1�� �� ���ְ�, Ȧ���� �Ȼ��� 
			int temp = l % 2 == 0 ? 1 : 0;
			// �ʱ갪 
			int value = (n / l) - (l/2) + temp;
			if(value < 0) {
				l++; 
				continue;
			}
			int sum = 0;
			int arr[] =  new int[l];
			
			for(int i=0; i<l; i++) {
				sum += value;
				arr[i] = value;
				value++;
			}
			if(sum == n) {
				for(int v : arr) {
					sb.append(v).append(" ");
				}
				brk = true;
				break;
			}
			l++;
		}
		if(brk) {
			System.out.println(sb);			
		}
		else {
			System.out.println(-1);
		}
	}
}
