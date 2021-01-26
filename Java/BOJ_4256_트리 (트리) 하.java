package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4256 {
	// BOJ / 4256번 / 트리 / 트리 / 골5
	static int in[], pre[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			pre = new int[n+1];
			in = new int[n+1];
			
			// 전위 입력
			stk = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=n; i++) {
				pre[i] = Integer.parseInt(stk.nextToken()); 
			}
			// 중위 입력
			stk = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=n; i++) {
				in[i] = Integer.parseInt(stk.nextToken()); 
			}
			
			postOrder(1, n, 1);
			System.out.println();
		}
	}
	
	// 전 후 중(출력) 
	public static void postOrder(int start, int end, int root) {
		
		for(int i=start; i<=end; i++) {
			if(in[i] == pre[root]) {
				//전, 왼쪽 서브 트리는 pre배열에서 root(index) + 1 
				postOrder(start, i-1, root+1);
				
				//후, 오른쪽 서브 트리는 pre배열 root(index) + in배열 왼쪽 서브 트리의 크기(i) + 1
				//에서 초기 start 빼주면댐
				postOrder(i+1, end, root + i + 1 - start );
				
				//출력
				System.out.print(pre[root]+" ");
			}
		}
	}
}
