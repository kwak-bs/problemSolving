package problemSolve6;

public class PM_72413 {
	// PM / 72413번 / 합승 택시 요금 / 플로이드 와샬  / Level3 / 2021 KAKAO BLIND
	public static void main(String[] args) {
		
		Solution(6,4,6,2,new int[][] {
			{4,1,10},
			{3,5,24},
			{5,6,2},
			{3,1,41},
			{5,1,24},
			{4,6,50},
			{2,4,66},
			{2,3,22},
			{1,6,25},
		});
	}
	static final int INF = 9999999;
	static int [][] dist;
	public static int Solution(int n, int s, int a, int b, int[][] fares) {
		int answer = INF;
		
		dist = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		for(int i=0; i<fares.length; i++) {
			dist[fares[i][0]][fares[i][1]] = fares[i][2];
			dist[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		
		FloydWarshall(n);
		
		for(int k=1; k<=n; k++) {
			answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);			
		}
		
		System.out.println(answer);
		return answer; 
	}
	
	public static void FloydWarshall(int n) {
		
		for(int k=1; k<=n; k++) { // 경유지
			for(int i=1; i<=n; i++) { // 출발지
				for(int j=1; j<=n; j++) { // 도착지
					if(dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		} 
	}
}
