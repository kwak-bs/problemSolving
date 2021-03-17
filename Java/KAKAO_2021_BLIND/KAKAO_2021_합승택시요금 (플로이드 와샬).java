package problemSolve3;

public class KAKAO_2021_합승택시요금 {
	
	public static void main(String[] args) {

		
		KAKAO_2021_합승택시요금 c = new KAKAO_2021_합승택시요금();
		int n = 6;
		int s = 4;
		int a = 6; 
		int b = 2;
		
		int fares[][] = {
				{4,1,10},
				{3,5,24},
				{5,6,2},
				{3,1,41},
				{5,1,24},
				{4,6,50},
				{2,4,66},
				{2,3,22},
				{1,6,25}
		};
		
		c.solution(n, s, a, b, fares);
	}
	static int [][] dist = new int[200][200];
	static final int INF = 40000000; 
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        
        // dist 배열 초기화
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if( i == j) dist[i][j] = 0;
        		else dist[i][j] = INF;
        	}
        }
        
        // fares를 바탕으로 dist 배열 업데이트
        for(int[] edge : fares) {
        	dist[edge[0]-1][edge[1]-1] = edge[2];
        	dist[edge[1]-1][edge[0]-1] = edge[2];
        }
        
        //플로이드 와샬
        floyd(n);
        
        s--;
        a--;
        b--;
        // 완전 탐색
        for(int k=0; k<n; k++) {
        	answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        return answer;
    }
    
    public static void floyd(int n) {
    	
    	for(int k=0; k<n; k++) { // 경유지
    		for(int i=0; i<n; i++) { // 시작점 
    			for(int j=0; j<n; j++) { // 도착점 
    				if(dist[i][k] + dist[j][k] < dist[i][j]) {
    					dist[i][j] = dist[i][k] + dist[k][j];
    				}
    			}
    		}
    	}
    }
}
