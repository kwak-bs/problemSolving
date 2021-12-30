package problemSolve7;

import java.util.Stack;

public class PM_42584_2 {
	// PM / 42584번 / 스택 / 주식가격 / Level2
	public static void main(String[] args) {
		
		int [] prices = {1,2,3,2,3};
		solution(prices);
	}
	
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> start = new Stack<>();
        int i = 0;
        start.add(i);
        
        for(i=1; i<prices.length; i++) {
        	while(!start.isEmpty() && prices[i] < prices[start.peek()]) {
        		int index = start.pop();
        		answer[index] = i - index;
        	}
        	start.add(i);
        }
        return answer;
    }

}
