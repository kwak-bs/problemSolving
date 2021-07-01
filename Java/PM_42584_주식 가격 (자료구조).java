package problemSolve6;

public class PM_42584 {
	// PM / 42584번 / 주식가격 / 스택,큐 / Level2 
	public static void main(String[] args) {
		solution(new int[] {1,2,3,2,3});
	}
	
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<answer.length-1; i++) {
            answer[i] = 0;
            for(int j= i+1; j<prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }
        }
        return answer;
    }

}
