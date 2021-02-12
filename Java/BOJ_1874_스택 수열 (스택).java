package problemSolve2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
	// BOJ / 1874번 / 스택 수열 / 스택 / 실3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		
		int num[] = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		int start = 0;
		
		for(int i=0; i<n; i++) {
			int value = num[i];
			
			// value값 까지 push한 이력이 없을경우 stack에 value값 까지 push한 후 
			// 마지막 원소를 pop한다. push일땐 +를 sb에 저장, pop일땐 -저장 한다.
			if(value > start ) {
				for(int j=start + 1; j<=value; j++) {
					st.push(j);
					sb.append("+").append("\n");
				}
				
				start = value;
			}
			 
			else if(st.peek() != value) {
				System.out.println("NO");
				return;
			}
			
			// (1) value가 start보다 크면 value값 까지 push 하고 peek을 pop한다.
			// (2) value가 start보다 작으면 (직전값 -1)이면 peek을 pop한다.
			st.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(sb);
	}
}
