package problemSolve4;

public class PM_43105 {
	// PM / 43105번 / 정수 삼각형 / DP  / Level3
	public static void main(String[] args) {
		solution( new int[][] {
			{7},
			{3,8},
			{8,1,0},
			{2,7,4,4},
			{4,5,2,6,5}
		});
	}
	
    public static  int solution(int[][] triangle) {
        int n = triangle.length;
        int [][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        int max = Integer.MIN_VALUE;
        for(int i=1; i<n; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                // 맨 왼쪽.
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                
                // 맨 오른쪽 
                else if(j==triangle[i].length-1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                
                // 가운데 
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j]+triangle[i][j]);
                }
                // 최댓값을 매번 초기화 해준다. 
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
}
