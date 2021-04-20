package problemSolve4;

import java.util.Arrays;

public class PM_49191 {
	// PM / 49191번 / 순위 / 플로이드 와샬  / Level3
    static final int INF = 987654321;
	public static void main(String[] args) {

		solution(5, new int[][] {
			{4,3},
			{4,2},
			{3,2},
			{1,2},
			{2,5},
		});
	}
	
    public static int solution(int n, int[][] results) {
        int answer = 0;
        boolean [][] c = new boolean[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
            // win -> lose 한 방향 그래프 
            c[results[i][0]][results[i][1]] = true;
        }
        
        for(int k=1; k<=n; k++) { // 경유지
            for(int i=1; i<=n; i++) { // 출발지 
                for(int j=1; j<=n; j++) { // 도착지
                    if(i != j && c[i][k] && c[k][j]) {
                        // i 선수를 통해 j 선수와의 상대적인 순위를 알 수 있음.
                        c[i][j] = true;
                    }
                }
            }
        }
 
        for(int i=1; i<=n; i++) { // i 선수 기준
            boolean pass = true;
            for(int j=1; j<=n; j++) { // j 선수들 (상대) 탐색
                // i 기준 j 선수들의 상대적인 순위를 한 번이라도 알 지 못하면 i선수의 정확한 순위를 알 수 업음, 즉 i 기준 모든 노드들에 접근 가능해야한다. 
                if(i != j && !(c[i][j] || c[j][i])) {
                    pass = false;
                    break;
                }
            }
            if(pass) answer++;
        }
        return answer;
    }
}
