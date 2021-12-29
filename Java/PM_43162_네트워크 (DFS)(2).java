package problemSolve7;

public class PM_43162 {
	// PM / 43162번 / dfs / 네트워크 / Level3
	public static void main(String[] args) {
		
		int n = 3;
		int [][] computers = {
					{1,1,0},
					{1,1,0},
					{0,0,1},
				};
		solution(n, computers);
	}
	static boolean v[];
    public static int solution(int n, int[][] computers) {
    	int answer = 0;
    	
    	v = new boolean[n];
    	
    	for(int i=0; i<n; i++) {
    		if(!v[i]) {
    			answer++;
    			dfs(n,computers, i);
    		}
    	}
    	System.out.println(answer);
        return answer;
    }
    
    public static void dfs(int n, int [][]computers, int node) {
    	
    	v[node] = true;
    	
    	for(int i=0; i<n; i++) {
    		if(!v[i] && computers[node][i] == 1) {
    			dfs(n, computers, i);
    		}
    	}
    }
}
