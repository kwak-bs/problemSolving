package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 {
	// BOJ / 1068번 / 트리 / 트리 / 실1
	
	static int n;
	static int[][] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		tree = new int [n][2]; // [n][0] = 부모 노드, [n][1] = 자식 수
		int answer = 0 ;
		
		for(int i=0; i<n; i++) {
			tree[i][0] = Integer.parseInt(stk.nextToken());
		}
		
		int delete = Integer.parseInt(br.readLine());
		
		setChild();
				
		remove(delete);
		
		// 지우려는 게 루트 노드가 아닐 경우
		if(tree[delete][0] != -1) {
			for(int i=0; i<n; i++) {
				if(tree[i][0] > -2) {
					if(tree[i][1] == 0) {
						answer++;
					}
				}
			}			
		}
		System.out.println(answer);
	}
	
	public static void setChild() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 현재 노드(i)와 부모가 같으면 i[1](자식 수)에 ++한다. 
				if(i == tree[j][0]) {
					tree[i][1]++;
				}
			}
		}
	}
	
	public static void remove(int del) {
		
		// 지우려는게 루트 노드면 그냥 return
		if(tree[del][0] == -1) {
			return ;
		}
		
		// 루트 노드가 아니면 
		else {
			// 그 부모의 자식 수를 -1 빼준다.
			tree[tree[del][0]][1]--;
			
			// 노드를 삭제한다.(-2)
			tree[del][0] = -2;
			
			// 만약 삭제한 노드가 자식이 있을 경우
			if(tree[del][1] > 0) {
				for(int i=0; i<n; i++) {
					if(tree[i][0] == del) {
						// 재귀를 통해 연쇄삭제
						remove(i);
					}
				}
			}
		}
	}
}
