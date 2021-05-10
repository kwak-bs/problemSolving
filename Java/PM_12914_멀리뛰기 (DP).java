package problemSolve5;

public class PM_12914 {
	// PM / 12914¹ø / ¸Ö¸® ¶Ù±â /   / Level3 
	public static void main(String[] args) {

		solution(4);
	}
	
    public static long solution(int n) {
        long answer = 0;
        
        long dp[] = new long[n+1];
        dp[1] = 1;
        if(n <= 2) return n;
        dp[2] = 2;
        for(int i=3; i<dp.length; i++) {
        	dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        answer = dp[n] % 12345678;
        return answer;
    }
}
