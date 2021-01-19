package problemSolve;

import java.util.Stack;

public class PM_64061 {

	public static void main(String[] args) {
		
	      int board[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1 }};
	      int moves[] = {1,5,3,5,1,2,1,4};
		
		PM_64061 c = new PM_64061();
		
		c.solution(board, moves);
	}
	
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        boolean flag = false;
        Stack<Integer> st = new Stack();

        for(int i=0; i<moves.length; i++) {
        	for(int j=0; j<board.length; j++) {
        		// 내려가면서 인형 찾으면 스택에 push
        		if(board[j][moves[i]-1] != 0) {
        			//System.out.println("이거 만남 : " + board[j][moves[i]-1]);
        			// push하기 전 일단 검사.
            		if(!st.isEmpty()) {
            			if(board[j][moves[i]-1] == st.peek()) {
            				st.pop();
                			board[j][moves[i]-1] = 0;
                			answer += 2;
                			// peek과 같으면 flag = true;
                			flag = true;
                			break;
            			}
            		}
            		// peek 과 같지 않으면 flag = false;
            		if(!flag) {
            			st.push(board[j][moves[i]-1]);
            			board[j][moves[i]-1] = 0;
            			//넣었으면 break;
            			break;
            		}
        		}
        	}
        	flag = false;
        }
        
        System.out.println(answer);
        return answer;
    }
}
