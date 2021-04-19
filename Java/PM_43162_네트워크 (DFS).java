package problemSolve4;

public class PM_43162 {

    static boolean v[];
    static int N;
	public static void main(String[] args) {

		solution(3 , new int[][] {
			{1,1,0},
			{1,1,0},
			{0,0,1},
		});
	}
	
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        v = new boolean[N];
        for(int i=0; i<N; i++) {
            if(!v[i]) {
                v[i] = true;
                answer++;
                dfs(i,computers);
            }
        }
        return answer;
    }
    
    public static void dfs(int node, int[][] computers) {
        
        for(int i=0; i<N; i++) {
            if(computers[node][i] == 1 && !v[i]) {
                v[i]= true;
                dfs(i, computers);
            }
        }
    }

}
