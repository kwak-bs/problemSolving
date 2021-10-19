package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2304 {
	// BOJ / 2304번 / 창고 다각형 / 자료구조 / 실버2
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
			// 최대 높이를 구한다.
			if(h > maxH) maxH = h;
		}
		// 인덱스별 오름차순으로 정렬 후 
		Collections.sort(pillars);
		for(int i=0; i<pillars.size(); i++)  {
			// 가장 높은 기둥의 인덱스를 구한다. 
			if(pillars.get(i).height == maxH) {
				maxI = i;
				break;
			}
		}
		// 가장 높은 기둥을 기준으로 왼쪽 너비 
		for(int i=0; i<maxI; i++) {
			for(int j=i+1; j<=maxI; j++) {
				if(pillars.get(i).height <= pillars.get(j).height) {
					 answer += (pillars.get(j).index - pillars.get(i).index) * pillars.get(i).height;
					 i = j;
				}
			}
		}
		// 오른쪽 너비 
		for(int i=n-1; i>maxI; i--) {
			for(int j=i-1; j>= maxI; j--) {
				if(pillars.get(i).height <= pillars.get(j).height) {
					answer += (pillars.get(i).index - pillars.get(j).index) * pillars.get(i).height;
					i = j;
				}
			}
		}
		// 전체 너비 + 가운데 가장 높은 기둥 
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
