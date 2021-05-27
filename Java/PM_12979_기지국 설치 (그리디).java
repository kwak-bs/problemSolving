package problemSolve5;

public class PM_12979 {
	// PM / 12979번 / 기지국 설치 / 그리디  / Level3 / Summer/Winter Coding
	public static void main(String[] args) {
		solution(11, new int[] {4,11}, 1);
	}
	
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;
        int position = 1;
        
        while(position <= n) {
        	
        	// 현재 위치가 기지국 범위에 포함된 위치라면 기지국 설치 x
        	if(si < stations.length && position >= stations[si] - w) {
        		// 기지국에 설치된 최대 범위 다음 칸으로 옮김
        		position = stations[si] + w+1;
        		si++;
        	}
        	// 현재 위치가 기지국 범위에 포함되지 않은 위치라면 기지국 설치
        	else {
        		answer++;
        		// 최대 범위만큼 옮김
        		position += (2 * w + 1);
        	}
        }
        return answer;
    }

}
