package problemSolve4;

public class PM_12913 {
	// PM / 12913번 / 땅따먹기 / DP  / Level2 
	public static void main(String[] args) {

		solution(new int[][] {
			{1,2,3,5},
			{5,6,7,8},
			{4,3,2,1},
		});
	}
	
    public static int solution(int[][] land) {        
        int answer = 0;
        
        int dp[][] = new int[land.length][land[0].length];
        
        dp[0] = land[0].clone();
        
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                // 전 행의 같은 열을 제외한 열의 최댓값과 더해준다. 
                for(int k=0; k<4; k++) {
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][k]+land[i][j]);
                }
            }
        }
        
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        return answer;
    }

}
