package problemSolve6;

public class PM_60059 {
	// PM / 60059�� / �ڹ���� ���� / ����, ���ڿ� / Level2 / 2020 KAKAO BLIND
	public static void main(String[] args) {

		solution(new int[][] {
			{0,1,1},
			{1,0,0},
			{0,1,1}
		}, new int[][] {
			{0,1,1,0},
			{1,1,0,0},
			{0,0,1,0}
		});
	}
	
    public static boolean solution(int[][] key, int[][] lock) {
    	int offset = key.length-1;
    	
    	for(int i=0; i<lock.length+offset; i++) {
    		for(int j=0; j<lock.length+offset; j++) {
    			for(int rot=0; rot<4; rot++) {
    				int map[][] = new int[lock.length+(2*offset)][lock.length+(2*offset)];
    				
    				for(int r=0; r<lock.length; r++) {
    					for(int c=0; c<lock.length; c++) {
    						map[r+offset][c+offset] = lock[r][c];
    					}
    				}
    				
    				key = rotate(key);
    				if(check(map, key,lock,i,j,offset)) {
    					return true;
    				};
    			}
    		}
    	}
        return false;
    }
    
    // �ð� ���� 90�� ȸ��
    public static int[][] rotate(int [][]key) {
    	int result[][] = new int[key.length][key.length];
    	
    	for(int i=0; i<key.length; i++) {
    		for(int j=0; j<key.length; j++) {
    			result [j][key.length-i-1] = key[i][j];
    		}
    	}
    	return result;
    }
    
    public static boolean check(int [][]map, int[][] key,int[][] lock, int s, int e,int offset) {

    	for(int i=0; i<key.length; i++) {
    		for(int j=0; j<key.length; j++) {
    			// 2�� �Ǽ� - key�� ����� lock�� ���Ⱑ ������ xor ��Ʈ ������ �ؾ��Ѵ�. 
    			if(map[i+s][j+e] == 1 && key[i][j] == 1) {
    				map[i+s][j+e] = 0;
    			}
    			//lock �� ���Ⱑ 0�� ��� 
    			else if(map[i+s][j+e] == 0) {
    				map[i+s][j+e] = key[i][j];    				
    			}
    		}
    	}
    	
    	// 1�� �Ǽ� - ���ο� �迭�� lock�� �˻��Ͽ��� �Ѵ�. 
		for(int r=0; r<lock.length; r++) {
			for(int c=0; c<lock.length; c++) {
				if(map[r+offset][c+offset] == 0) {
					return false;
				}
			}
		}
    	return true;
    }
}
