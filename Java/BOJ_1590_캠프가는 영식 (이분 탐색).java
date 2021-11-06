package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1590 {
	// BOJ / 1059�� / ķ������ ���� / �̺� Ž�� / �ǹ�3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int t = Integer.parseInt(stk.nextToken());
		
		ArrayList<Integer> bus = new ArrayList<>();
		int answer = -1;
		while(n-- > 0) {
			stk = new StringTokenizer(br.readLine() , " ");
			int s = Integer.parseInt(stk.nextToken()); // ���� �ð� 
			int l = Integer.parseInt(stk.nextToken()); // ���� 
			int c = Integer.parseInt(stk.nextToken()); // ��� 
			for(int i=0; i<c; i++) {
				bus.add(s + (i *l));
			}
		}
		Collections.sort(bus);
		
		int s = 0;
		int e = bus.size();
		while (s < e) {
			int m = (s + e) >> 1;
			int time = bus.get(m);

			if(time >= t) {
				answer = bus.get(m) - t;
				e--;
			}
			else if(time < t) {
				s++;
			}
		}
		
		System.out.println(answer);
	}
}
