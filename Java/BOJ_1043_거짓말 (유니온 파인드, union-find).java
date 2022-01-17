package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1043 {
	// BOJ / 1043번 / 거짓말 / 유니온 파인드  / 골드4
	static int parent[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		parent = new int[n+1];
		Arrays.fill(parent, -1);
		stk = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<know; i++) {
			int temp = Integer.parseInt(stk.nextToken());
			parent[temp] = temp;
		}
		
		list = new ArrayList[m];
		for(int i=0; i<m; i++) {
			list[i] = new ArrayList<>();
		}
		int idx = 0;
		while(idx < m) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int k = Integer.parseInt(stk.nextToken());
			
			for(int i=0; i<k; i++) {
				list[idx].add(Integer.parseInt(stk.nextToken()));
			}

			if(list[idx].size() > 1) doUnion(idx);
			idx++;
		}
		
		int answer = 0;
		
		for(int i=0; i<list.length; i++) {
			boolean isExag = true;
			for(int j=0; j<list[i].size(); j++) {
				int value = list[i].get(j);
				int p = find(value);
				if(p == parent[p]) {
					isExag = false;
					break;
				}
			}
			if(isExag) answer++;
		}
		System.out.println(answer);
	}
	
	public static void doUnion(int idx) {
		int first = list[idx].get(0);
		
		for(int i=1; i<list[idx].size(); i++) {
			union(first, list[idx].get(i));
		}
	}
	
	public static int find(int a) {
		if(parent[a] == a || parent[a] < 0 ) {
			return a;
		}
		else return parent[a] = find(parent[a]);
	}
	
	public static void union(int a,int b) {
		a = find(a);
		b = find(b);

		if(a != b) {
			// a가 root이면 b의 부모는 a 
			if( a == parent[a]) {
				parent[b] = a;
			}
			// a가 root가 아니면 a의 부모는 b
			else {
				parent[a] = b;
			}
		}
	}
}
