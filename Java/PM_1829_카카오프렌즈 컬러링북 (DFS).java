package problemSolve4;

public class PM_1829 {
	// PM / 1829번 / 카카오프렌즈 컬러링북 / DFS / Level2 / 2017 카카오코드 예선
    static int N,M,cntMax;
    static boolean [][]v;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
	public static void main(String[] args) {
		solution(6,4,new int[][] {
			{1,1,1,0},
			{1,2,2,0},
			{1,0,0,1},
			{0,0,0,1},
			{0,0,0,3},
			{0,0,0,3},
		});
	}
	
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        v = new boolean [m][n];
        N = n;
        M = m;
        cntMax = Integer.MIN_VALUE;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!v[i][j] && picture[i][j] != 0 ) {
                    numberOfArea++;
                    cntMax = 0;
                    int count = dfs(picture, picture[i][j],i,j);        
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    // 재귀를 통해 사방탐색한다. 
    public static int dfs(int[][]picture, int color, int r, int c) {
        v[r][c] = true;
        cntMax++;
        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < M && nc >=0 && nc < N) {
                if(!v[nr][nc] && color == picture[nr][nc]) {
                    dfs(picture, color, nr, nc);
                }
            }
        }
        return cntMax;
    }
}
