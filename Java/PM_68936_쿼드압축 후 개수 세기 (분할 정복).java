package problemSolve4;

public class PM_68936 {
	// PM / 68936번 / 쿼드압축 후 개수 세기 / 분할 정복  / Level2 / 월간 코드 챌린지 시즌1
	public static void main(String[] args) {

		solution(new int[][] {
			{1,1,0,0},
			{1,0,0,0},
			{1,0,0,1},
			{1,1,1,1}
		});
	}
    static int zero = 0;
    static int one = 0;
	
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
    
        int n = arr.length;
        
        dc(arr,n, 0, 0);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
    public static void dc(int [][]arr, int n, int r, int c) {
        int num = arr[r][c];
        for(int i = r; i<r + n; i++) {
            for(int j=c; j<c+n; j++) {
                if(num != arr[i][j]) {
                    return;
                }
            }
        }
        if(num == 0) {
            zero++;
            return;
        }
        if(num == 1) {
            one++;
            return;
        }
        // 우측 상단
        dc(arr, n/2, r, c);
        // 좌측 상단
        dc(arr, n/2, r, c + n/2);
        // 우측 하단
        dc(arr, n/2, r+n/2, c);
        // 좌측 하단
        dc(arr, n/2, r+n/2, c+n/2);
    }

}
