package problemSolve4;

public class PM_12905 {
	// PM / 12905번 / 가장 큰 정사각형 찾기 / DP  / Level2 
	public static void main(String[] args) {

		solution(new int[][] {
			{0,1,1,1},
			{1,1,1,1},
			{1,1,1,1},
			{0,1,1,0},
		});
	}

    public static int solution(int [][]board){
        
        int answer = Integer.MIN_VALUE;
        int r = board.length;
        int c = board[0].length;
        
        // 1*1 표를 방지하기위해 길이+1
        int [][]dp = new int[r+1][c+1];
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                dp[i+1][j+1] = board[i][j];
            }
        }

        for(int i=1; i<r+1; i++) {
            for(int j=1; j<c+1; j++) {
                if(dp[i][j] == 0 ) continue;
                int left = dp[i][j-1];
                int up = dp[i-1][j];
                int lu = dp[i-1][j-1];
                
                dp[i][j] = Math.min(left,Math.min(up,lu))+1;
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer * answer;
    }
}
