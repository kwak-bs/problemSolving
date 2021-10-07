package problemSolve7;

import java.util.Stack;

public class PM_81303 {
	// PM / 81303번 / 2021 카카오 채용형 인턴 / 자료구조 / 표 편집
	public static void main(String[] args) {
		
		solution(8, 2, new String[] {
				"D 2","C","U 3","C","D 4","C","U 2","Z","Z"
		});
	}
	
	public static String solution(int n, int k, String[] cmd) {
		String answer = "";
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> remove = new Stack<>();
		
		for(int i=0; i<cmd.length; i++) {
			String split[] = cmd[i].split(" ");
			
			if(split[0].equals("D")) {
				k += Integer.parseInt(split[1]);
				if(k < 0) k = 0;
			}
			else if(split[0].equals("U")) {
				k -= Integer.parseInt(split[1]);
				if(k < 0) k = 0;
			}
			else if(split[0].equals("C")) {
				remove.push(k);
				n--;
				if(n <= k) {
					k--;
				}
			}
			else if(split[0].equals("Z")) {
				int z = remove.pop();
				n++;
				if(z <= k) {
					k++;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			sb.append("O");
		}
		
		while(!remove.isEmpty()) {
			int index = remove.pop();
			
			sb.insert(index, "X");
		}
		answer = sb.toString();

		return answer;
	}
}
