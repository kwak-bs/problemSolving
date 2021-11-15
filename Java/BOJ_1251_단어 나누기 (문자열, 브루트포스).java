package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1251 {
	// BOJ / 1251�� / �ܾ� ������ / ���� / �ǹ�5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for(int i=1; i<input.length()-1; i++) {
			for(int j=i+1; j<input.length(); j++) {
				// �� �ܾ�� ������
				String a = input.substring(0, i);
				String b = input.substring(i, j);
				String c = input.substring(j, input.length());
				StringBuilder sb = new StringBuilder();
				// ���� ������ 
				a = reverse(a);
				b = reverse(b);
				c = reverse(c);
				pq.add(sb.append(a).append(b).append(c).toString());
			}
		}
		
		System.out.println(pq.poll());
	}
	
	public static String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
}
