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
        	// false�� �ʱ�ȭ 
        	change = false;
        	
        	// ���� ����.
    		// ������ ch �迭�� �����Ѵ�. ch�迭�� �������� ����� ����� copy �迭���ٰ� �ֽ�ȭ ���ش�.
        	change = blockGame();
        	
        	// ����� ����Ȱ� �ִٸ�
        	if(change) {
            	// ������ ��� Ȯ���ؼ� ������ ���� �ֱ�. �ֽ�ȭ�� copy�迭�� �����Ѵ�.
        		downBlock();
        		
        		// �ٲ� ��� ch�� �Ű��ֱ�.
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
    	
    	// ������ 1�� �����Ѵ�. solution()�� while���� ���ؼ� ���� ��� ���� 
    	for(int i=0; i<M; i++) {
    		for(int j=0; j<N; j++) {
    			// ��, ���� �� ������ ���� break;
    			if( i == M-1 || j == N-1) {
    				break;
    			}

    			if(ch[i][j] != 'x') {
    				char temp = ch[i][j];
    				int count = 0;

    				// 2x2 ��� üũ.
    				a : for(int k=i; k<i+2; k++) {
    						for(int l=j; l<j+2; l++) {

    							if(temp != ch[k][l]) {
    								break a;
    							}
    							// ������ count++;
    							else {
    								count++;
    								if(count == 4) {
    									break a;
    								}
    							}
    						}
    					}
    				
    				// 2x2 ��ϵ��� ������ �������� ����� 'x'���� �ٲ��ְ� copy �迭�� �ӽ� ���� 
    				if(count == 4 ) {
    					flag = true;
    					for(int k=i;  k<i+2; k++) {
    						for(int l=j; l < j+2; l++) {
    							copy[k][l] = 'x';
    						}
    					}
    				}
    				
    				// count �ʱ�ȭ
    				count = 0;
    			}
    		}		
    	}
    	return flag;
    }
    
    // ������
    public static void downBlock() {
    	boolean down = true;
    	
    	//���� �Ʒ��� �ִ� ��ϵ��� ���� ������ �� ���� �ִ� ��ϵ��� ������ ���� while�� ���.
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
