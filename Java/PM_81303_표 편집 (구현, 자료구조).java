package problemSolve6;

import java.util.Stack;

public class PM_81303 {
	// PM / 81303번 / 표 편집 / 구현, 자료구조 / Level3 / 2021 카카오 채용연계형 인턴십
	public static void main(String[] args) {
		
		solution(8,2, new String[] {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"});
	}

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> remove = new Stack<>();
        
        for(int i=0; i<cmd.length; i++) {
        	char op = cmd[i].charAt(0);
        	
        	if(op == 'U') {
        		k -= Integer.parseInt(cmd[i].substring(2)+"");

        	}
        	else if(op == 'D') {
        		k += Integer.parseInt(cmd[i].substring(2)+"");
        	}
        	// 삭제 연산은 스택에 넣어준다.
        	else if(op == 'C') {
        		remove.push(k);
        		n--;
        		// 삭제된 연산이 마지막 원소였으면 하나 줄여준다.
        		if(n <= k) {
        			k--;
        		}
        	}
        	// 복구 연산
        	else if(op == 'Z') {
        		int z = remove.pop();
        		n++;
        		// 복구된 원소가 k 이하이면 k를 하나 늘려준다.
        		if(z <= k) {
        			k++;
        		}
        	}
        }
        
        for(int i=0; i<n; i++) {
        	sb.append("O");
        }
        while(!remove.isEmpty()) {
        	int idx = remove.pop();
        	
        	sb.insert(idx, "X");
        }
        answer = sb.toString();
        
        System.out.println(answer);
        return answer;
    }
}
