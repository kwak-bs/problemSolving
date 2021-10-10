package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2263 {
	// BOJ / 2263번 / 트리의 순회 / 재귀, 분할정복 / 골드3
	static int n, inOrder[], postOrder[], preOrder[], index;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		inOrder = new int[n];
		postOrder = new int[n];
		preOrder = new int[n];
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			inOrder[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk= new StringTokenizer(br.readLine(), " ");
		for(int i =0; i<n; i++) {
			postOrder[i] = Integer.parseInt(stk.nextToken());
		}
		
		getPreOrder(0, n-1, 0, n-1);
		
		for(int v : preOrder) {
			System.out.print(v + " ");
		}
	}
	
	public static void getPreOrder(int is, int ie, int ps, int pe) {
		
		// is, ie는 in-order의 시작과 끝.
		// ps, pe는 post-order의 시작과 끝.
		
		if(is <= ie && ps <= pe) {
			preOrder[index++] = postOrder[pe];
			
			int pos = is;
			for(int i=is; i<= ie; i++) {
				if(inOrder[i] == postOrder[pe]) {
					pos = i;
					break;
				}
			}
			// 왼쪽 
			getPreOrder(is, pos-1, ps, ps+pos-is-1);
			// 오른쪽
			getPreOrder(pos+1, ie, ps+pos-is, pe-1);
		}
	}
}
