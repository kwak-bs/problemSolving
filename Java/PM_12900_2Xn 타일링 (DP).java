package problemSolve4;

public class PM_12900 {
	// PM / 12900번 / 2 X n 타일링 / DP  / Level2 
	public static void main(String[] args) {

		solution(4);
	}
    public static int solution(int n) {
        int answer = 0;
        
        int dp[] = new int[n+1];
        dp[0] = 0;
        if(n > 0) {
            dp[1]=1;
        }
        if(n > 1) {
            dp[2] = 2;
        }
        for(int i=3; i<n+1; i++) {
            dp[i] = (dp[i-1] +dp[i-2]) % 1000000007;
        }
        answer = dp[n] % 1000000007;
        return answer;
    }
}
