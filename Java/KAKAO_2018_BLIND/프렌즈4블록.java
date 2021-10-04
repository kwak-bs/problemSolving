package problemSolve2;

public class PM_test_2 {

	static char ch[][], copy[][];
	static int M,N;
	
	public static void main(String[] args) {

		int m = 6;
		int n = 6;
		String board[] = {"TTTANT", "RRFACC", "RRRFCC","TRRRAA", "TTMMMF", "TMMTTJ"};
		
		PM_test_2 c = new PM_test_2();
		c.solution(m, n, board);
	}
	
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        ch = new char[M][N];
        copy= new char[M][N];
        
        boolean change= true;
        
        for(int i=0; i<m; i++) {
        	ch[i] = board[i].toCharArray();
        	copy[i] = board[i].toCharArray();
        }
        
        while(change) {
        	// false로 초기화 
        	change = false;
        	
        	// 게임 진행.
    		// 게임은 ch 배열로 진행한다. ch배열을 기준으로 변경된 블록은 copy 배열에다가 최신화 해준다.
        	change = blockGame();
        	
        	// 블록이 변경된게 있다면
        	if(change) {
            	// 없어진 블록 확인해서 밑으로 내려 주기. 최신화된 copy배열로 진행한다.
        		downBlock();
        		
        		// 바뀐 블록 ch로 옮겨주기.
        		for(int i=0; i< M; i++) {
        			for(int j=0; j<N; j++) {
        				ch[i][j] = copy[i][j];
        			}
        		}
        	}
        }
    	System.out.println(answer);
        
        return answer;
    }
    
    public static boolean blockGame () {
    	boolean flag = false;
    	
    	// 게임은 1턴 진행한다. solution()의 while문을 통해서 턴은 계속 진행 
    	for(int i=0; i<M; i++) {
    		for(int j=0; j<N; j++) {
    			// 행, 열이 끝 변으로 가면 break;
    			if( i == M-1 || j == N-1) {
    				break;
    			}

    			if(ch[i][j] != 'x') {
    				char temp = ch[i][j];
    				int count = 0;

    				// 2x2 블록 체크.
    				a : for(int k=i; k<i+2; k++) {
    						for(int l=j; l<j+2; l++) {

    							if(temp != ch[k][l]) {
    								break a;
    							}
    							// 같으면 count++;
    							else {
    								count++;
    								if(count == 4) {
    									break a;
    								}
    							}
    						}
    					}
    				
    				// 2x2 블록들이 같으면 없어지는 블록은 'x'으로 바꿔주고 copy 배열에 임시 저장 
    				if(count == 4 ) {
    					flag = true;
    					for(int k=i;  k<i+2; k++) {
    						for(int l=j; l < j+2; l++) {
    							copy[k][l] = 'x';
    						}
    					}
    				}
    				
    				// count 초기화
    				count = 0;
    			}
    		}		
    	}
    	return flag;
    }
    
    // 내리기
    public static void downBlock() {
    	boolean down = true;
    	
    	//가장 아래에 있는 블록들을 먼저 내리고 그 위에 있는 블록들을 내리기 위해 while문 사용.
    	while(down) {
    		down = false;
    		
    		for(int i=0; i<M; i++) {
    			for(int j=0; j<N; j++) {
    				
    				if(copy[i][j] == 'x') {
    					if(i-1 >= 0 && copy[i-1][j] != 'x') {
    						
    						copy[i][j]=copy[i-1][j];
    						copy[i-1][j] = 'x';
    						down = true;

    					}
    				}
    			}
    		}
    	}
    }
}
