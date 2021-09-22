package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15686 {
	// BOJ / 15686번 / 치킨 배달 / 완전 탐색,구현, 자료구조 / 골드5
	static int map[][];
	static int n,m, answer;
	static ArrayList<Dot> chicken, house;
	static Stack<Dot> select;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		chicken = new ArrayList<>(); // 치킨집
		house = new ArrayList<>(); // 집 	
		map = new int[n][n];
		answer = Integer.MAX_VALUE;
		select = new Stack<>(); // 선택된 치킨집
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 1) {
					house.add(new Dot(i, j));
				}
				else if(map[i][j] == 2) {
					chicken.add(new Dot(i, j));
				}
			}
		}
		selectChicken(0, 0);
		System.out.println(answer);
	}
	// 조합을 통해 치킨집 완전 탐색 
	public static void selectChicken(int start, int depth) {
		
		if(depth == m) {
			int sum = 0;
			// 각 집마다 치킨 거리를 구한 후 도시 치킨 거리의 합을 구한다. 
			for(int i=0; i<house.size(); i++) {
				int r1 = house.get(i).r;
				int c1 = house.get(i).c;
				int min = Integer.MAX_VALUE;
				for(Dot s : select) {
					int r2 = s.r;
					int c2 = s.c;
					min = Math.min(min, getDistance(r1,c1,r2,c2));
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			select.push(new Dot(chicken.get(i).r, chicken.get(i).c));
			selectChicken(i+1, depth+1);
			select.pop();
		}
	}
	
	public static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
}

class Dot {
	int r, c;
	public Dot(int r, int c) {
		this.r=r;
		this.c=c;
	}
}