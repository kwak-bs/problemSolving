package problemSolve4;

public class PM_77485 {
	// PM / 77485번 / 행렬 테두리 회전하기 / 구현  / Level2 / 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
	public static void main(String[] args) {

		solution(6,6,new int[][] {
			{2,2,5,4},
			{3,3,6,6},
			{5,1,6,3},
		});
	}
	
    static int map[][],n,m;
    static int dr[] = {1,0,-1,0}; // 상 우 하 좌
    static int dc[] = {0,1,0,-1};
	
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int t = queries.length;
        n = rows;
        m = columns;
        map = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = i * m + (j+1);
            }
        }
        int idx = 0;
        while(t-- > 0) {
            int r1 = queries[idx][0]-1;
            int c1 = queries[idx][1]-1;
            int r2 = queries[idx][2]-1;
            int c2 = queries[idx][3]-1;

            int min = rotate(r1,c1,r2,c2);         
            answer[idx] = min;
            idx++;
        }
        return answer;
    }
    
    public static int rotate(int r1, int c1, int r2, int c2) {
        
        // 훗날 넣어주기 위한 값
        int later = map[r1][c1];
        int y = r1;
        int x = c1;
        int d = 0; // 상 우 하 좌
        int min = map[r1][c1];
        
        while(d < 4) {
            int nr = y + dr[d];
            int nc = x + dc[d];
            if(nr >= r1 && nc >= c1 && nr <= r2 && nc <= c2) {
                map[y][x] = map[nr][nc];
                if(min > map[nr][nc]) {
                    min = map[nr][nc];
                }
                y = nr;
                x = nc;
            }
            else {
                d++;
            }
        }
        map[r1][c1+1] = later;
        return min;
    }

}
