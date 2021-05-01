package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
	// BOJ / 17298번 / 오큰수 / 스택, 자료구조 / 골드4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int arr [] = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		for(int i=0; i<n; i++) {
			// 현재 스택에 들어 있는 값 = 직전 index
			// 현재 값이 직전 인덱스들의 값보다 크면 배열의 직전 인덱스의 값을 비교해가며 현재 값을 넣는다.
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				arr[st.pop()] = arr[i];
			}
			st.add(i);
		}
		while(!st.isEmpty()) {
			arr[st.pop()] = -1;
		}
		for(int i=0; i<n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}
