package problemSolve4;

public class PM_68645 {
	// PM / 68645번 / 삼각 달팽이 / 구현  / Level2 / 월간 코드 챌린지 시즌1
	public static void main(String[] args) {
		
		solution(4);
	}
    static int[] answer;
    static int[][] map;
    public static int[] solution(int n) {
    	
    	
        map = new int[n][n];
        answer = new int[(n*(n+1)) / 2];
        
        int r = -1;
        int c = 0;
        int num = 1;
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                // 아래
                if(i % 3 == 0) {
                    r++;
                }
                // 오른쪽
                else if(i % 3 == 1) {
                    c++;
                }
                // 좌측 상단
                else if(i % 3 == 2) {
                    r--;
                    c--;
                }
                map[r][c] = num++;
            }
        }
        int k = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] != 0) {
                    answer[k++] = map[i][j];
                }
            }
        }
        return answer;
    }
}
