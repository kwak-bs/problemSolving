package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2304 {
	// BOJ / 2304�� / â�� �ٰ��� / �ڷᱸ�� / �ǹ�2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Pillar> pillars = new ArrayList<>();
		StringTokenizer stk;
		int maxH = 0;
		int maxI = 0;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(stk.nextToken());
			int h = Integer.parseInt(stk.nextToken());
			
			pillars.add(new Pillar(idx, h));
			// �ִ� ���̸� ���Ѵ�.
			if(h > maxH) maxH = h;
		}
		// �ε����� ������������ ���� �� 
		Collections.sort(pillars);
		for(int i=0; i<pillars.size(); i++)  {
			// ���� ���� ����� �ε����� ���Ѵ�. 
			if(pillars.get(i).height == maxH) {
				maxI = i;
				break;
			}
		}
		// ���� ���� ����� �������� ���� �ʺ� 
		for(int i=0; i<maxI; i++) {
			for(int j=i+1; j<=maxI; j++) {
				if(pillars.get(i).height <= pillars.get(j).height) {
					 answer += (pillars.get(j).index - pillars.get(i).index) * pillars.get(i).height;
					 i = j;
				}
			}
		}
		// ������ �ʺ� 
		for(int i=n-1; i>maxI; i--) {
			for(int j=i-1; j>= maxI; j--) {
				if(pillars.get(i).height <= pillars.get(j).height) {
					answer += (pillars.get(i).index - pillars.get(j).index) * pillars.get(i).height;
					i = j;
				}
			}
		}
		// ��ü �ʺ� + ��� ���� ���� ��� 
		System.out.println(answer+maxH);
	}
	
	private static class Pillar implements Comparable<Pillar> {
		int index, height;
		
		public Pillar(int index, int height) {
			this.index = index;
			this.height = height;
		}
	
		@Override
		public int compareTo(Pillar o) {
			
			return this.index - o.index;
		}
	}
}
