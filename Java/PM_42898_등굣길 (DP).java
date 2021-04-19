package problemSolve4;

public class PM_42898 {
	// PM / 42898번 / 등굣길 / DP  / Level4
	public static void main(String[] args) {
		solution(4,3,new int[][] {{2,2}});
	}
	
    public static int solution(int m, int n, int[][] puddles) {
        int dp[][] = new int[n][m];
        for(int i =0; i<puddles.length; i++) {
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        // 물 만나면 break
        for(int i=0; i<m; i++) {
            if(dp[0][i] == -1) break;
            dp[0][i] = 1;
        }
        for(int i=0; i<n; i++) {
            if(dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dp[i][j] == -1 ) {
                    dp[i][j] = 0;
                    continue;
                }
                if(dp[i][j] != 0 ) continue;
                if(i > 0 && j > 0) {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;   
                }
            }
        }
        return dp[n-1][m-1] % 1000000007;
    }
}
