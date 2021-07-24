package problemSolve6;

import java.util.Stack;

public class PM_81303 {
	// PM / 81303�� / ǥ ���� / ����, �ڷᱸ�� / Level3 / 2021 īī�� ä�뿬���� ���Ͻ�
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
        	// ���� ������ ���ÿ� �־��ش�.
        	else if(op == 'C') {
        		remove.push(k);
        		n--;
        		// ������ ������ ������ ���ҿ����� �ϳ� �ٿ��ش�.
        		if(n <= k) {
        			k--;
        		}
        	}
        	// ���� ����
        	else if(op == 'Z') {
        		int z = remove.pop();
        		n++;
        		// ������ ���Ұ� k �����̸� k�� �ϳ� �÷��ش�.
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
