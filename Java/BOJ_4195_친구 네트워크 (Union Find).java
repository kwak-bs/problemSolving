package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195 {
	//BOJ / 4195번 / 친구 네트워크  / 해시 / 골2
	static HashMap<String, Integer> map;
	static int parent[], relation[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			parent = new int[n*2]; // 부모값 저장 배열 
			relation = new int [n*2]; // 관계 수 저장 배열
			
			for(int i=0; i<n*2; i++) {
				parent[i] = i;
				relation[i] = 1; // 모든 관계는 1로 초기화.
			}
			
			int idx = 0; // 부모인덱스와 친구 인덱스를 같게 해준다. 
			map = new HashMap<>();
			for(int i=0; i<n; i++) {
				stk= new StringTokenizer(br.readLine(), " ");

				String s1 = stk.nextToken();
				String s2 = stk.nextToken();
				
				// 이미 들어가있는 친구 이름이면 pass.
				if(!map.containsKey(s1)) { 
					map.put(s1, idx++);
				}
				if(!map.containsKey(s2)) {
					map.put(s2, idx++);
				}
				sb.append(union(map.get(s1), map.get(s2)) +"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	public static int union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		// 이미 이어진 친구 관계면 relation[p1 || p2] 아무거나 반환한다.
		if(p1 == p2) {
			return relation[p2];
		}
		if(p1 > p2) {
			parent[p1] = p2;
			// 더 작은쪽으로 부모값이 결정되는데, 마찬가지로 관계 배열도 더 작은 쪽 인덱스로 더해준다.
			relation[p2] += relation[p1];
			return relation[p2];
		}
		else {
			parent[p2] = p1;
			relation[p1] += relation[p2];
			return relation[p1];
		}
	}
}
