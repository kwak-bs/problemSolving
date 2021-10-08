package problemSolve7;

public class PM_86971_2 {
	// PM / 86971번 / 위클리 챌린지 / dfs / 9주차_전력망을 둘로 나누기
	public static void main(String[] args) {
		solution(9, new int[][] {
			{9,7},
			{8,7},
			{4,7},
			{1,3},
			{3,2},
			{4,3},
			{5,4},
			{4,6},
		});
	}
    static boolean map[][], visit[];
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        map = new boolean[n+1][n+1];
        visit = new boolean[n+1];
        
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;
        }
        
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = false;
            map[wires[i][1]][wires[i][0]] = false;
            
            int a = dfs(wires[i][0], 0);
            int b = dfs(wires[i][1], 0);
            
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;

            answer = Math.min(answer, Math.abs(a-b));
        }
        return answer;
    }
    
    public static int dfs (int node ,int count) {
        
        visit[node] = true;
        int sum = 1;
        for(int i=1; i<visit.length; i++){ 
            if(!visit[i] && map[node][i]){
                sum += dfs(i, count+1);
            }
        }
        visit[node] = false;

        return sum;
    }

}
