package problemSolve4;

import java.util.HashSet;
import java.util.Set;

public class PM_49994 {
	// PM / 49994번 / 방문 길이 / 구현  / Level2
	public static void main(String[] args) {
		solution("ULURRDLLU");
	}
	
    public static int solution(String dirs) {
        int answer = 0;
        
        int board[][] = new int[11][11];

        int r = 5;
        int c = 5;
        Set<String> set = new HashSet<>();
        for(int i=0; i<dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int ny = r;
            int nx = c;
            switch(dir) {
                case 'U' :
                    ny++;
                    break;
                case 'D' :
                    ny--;
                    break;
                case 'L' :
                    nx--;
                    break;
                case 'R' :
                    nx++;
                    break;
            }
            
            if(ny >= 0 && ny < 11 && nx >= 0 && nx < 11) {
                if(!set.contains(""+r+c+ny+nx)) {
                    // 오고 가는 좌표 둘다 넣어줌
                    set.add(""+r+c+ny+nx);
                    set.add(""+ny+nx+r+c);
                    r = ny;
                    c = nx; 
                }
                else {
                    r = ny;
                    c = nx; 
                }
            }
        }
        answer = set.size() / 2;
        return answer;
    }
}
