package problemSolve5;

public class PM_12907 {
	// PM / 12907번 / 거스름돈 / 구현 / Level3 
	public static void main(String[] args) {
		solution(5, new int[] {1,2,5});
	}
	
    public static int solution(int n, int[] money) {
        int answer = 0;
        
        int dp[] = new int[100001];
        dp[0] = 1;
        for(int val : money) {
        	for(int i=1; i<=n; i++) {
        		if(i >= val) {
        			dp[i] = dp[i] + dp[i-val];
        		}
        	}
        }
        answer = dp[n];
        return answer;
    }
}
