package problemSolve7;


public class PM_49191 {
	// PM / 49191�� / �÷��̵�-�ͼ� / ����
	public static void main(String[] args) {
		int n = 5;
		int [][] results = {
				{4,3},
				{4,2},
				{3,2},
				{1,2},
				{2,5},
			};
		solution(n, results);
	}
	
    public static int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean a[][] = new boolean[n+1][n+1];
        
        for(int i=0; i<results.length; i++) {
                a[results[i][0]][results[i][1]] = true;
        }
        // �÷��̵� �ͼ��� ��� ���� üũ
        for(int k=1; k<a.length; k++) {
            for(int i=1; i<a.length; i++) {
                for(int j=1; j<a.length; j++) {
                    if(i != j && a[i][k] && a[k][j]) {
                        a[i][j] = true;
                    }
                }
            }
        }
        
        for(int i=1; i<n+1; i++) {
            boolean pass = true;
            for(int j=1; j<n+1; j++) {
            	// �� �� �ϳ��� false�� ������ �� �� ����. 
                if(i != j && !a[i][j] && !a[j][i]) {
                    pass = false;
                    break;
                }
            }
            if(pass) answer++;
        }
        System.out.println(answer);
        return answer;
    }
}
