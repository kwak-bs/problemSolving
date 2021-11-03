package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1063 {
	// BOJ / 1063번 / 킹 / 구현, 시뮬레이션 / 실버4
	static int board[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		String king = stk.nextToken();
		String stone = stk.nextToken();
		int n = Integer.parseInt(stk.nextToken());
		
		board = new int[8][8];
		
		// 1: king , 2: stone
		int kr = '8' - king.charAt(1);
		int kc = king.charAt(0) -'A';
		board[kr][kc] = 1;
		int sr = '8' - stone.charAt(1);
		int sc = stone.charAt(0) - 'A';
		board[sr][sc] = 2;
		
		int ckr = kr; // current king row 
		int ckc = kc;
		int csr = sr;
		int csc = sc;

		while(n-- > 0) {
			String op = br.readLine();
			
			switch(op) {
			case "R" : 
				int nkr = ckr ;
				int nkc = ckc + 1; 
				if(!checkBoundary(nkr, nkc)) {
					break;
				}
				if(checkSamePosition(nkr, nkc, csr, csc)) {
					csc++;
					if(!checkBoundary(csr, csc)) {
						csc--;
						break;
					}
				}
				ckr = nkr;
				ckc = nkc;
				break;
			case "L" : 
				nkr = ckr ;
				nkc = ckc - 1; 
				if(!checkBoundary(nkr, nkc)) {
					break;
				}
				if(checkSamePosition(nkr, nkc, csr, csc)) {
					csc--;
					if(!checkBoundary(csr, csc)) {
						csc++;
						break;
					}
				}
				ckr = nkr;
				ckc = nkc;
				break;
			case "B" : 
				nkr = ckr + 1;
				nkc = ckc; 
				if(!checkBoundary(nkr, nkc)) {
					break;
				}
				if(checkSamePosition(nkr, nkc, csr, csc)) {
					csr++;
					if(!checkBoundary(csr, csc)) {
						csr--;
						break;
					}
				}
				ckr = nkr;
				ckc = nkc;
				break;
			case "T" : 
				nkr = ckr - 1;
				nkc = ckc; 
				if(!checkBoundary(nkr, nkc)) {
					break;
				}
				if(checkSamePosition(nkr, nkc, csr, csc)) {
					csr--;
					if(!checkBoundary(csr, csc)) {
						csr++;
						break;
					}
				}
				ckr = nkr;
				ckc = nkc;
				break;
			case "RT" : 
				nkr = ckr - 1;
				nkc = ckc + 1; 
				if(!checkBoundary(nkr, nkc)) {
					break;
				}
				if(checkSamePosition(nkr, nkc, csr, csc)) {
					csc++;
					csr--;
					if(!checkBoundary(csr, csc)) {
						csc--;
						csr++;
						break;
					}
				}
				ckr = nkr;
				ckc = nkc;
				break;
			case "LT" : 
				nkr = ckr - 1;
				nkc = ckc - 1; 
				if(!checkBoundary(nkr, nkc)) {
					break;
				}
				if(checkSamePosition(nkr, nkc, csr, csc)) {
					csc--;
					csr--;
					if(!checkBoundary(csr, csc)) {
						csc++;
						csr++;
						break;
					}
				}
				ckr = nkr;
				ckc = nkc;
				break;
			case "RB" : 
				nkr = ckr + 1;
				nkc = ckc + 1; 
				if(!checkBoundary(nkr, nkc)) {
					break;
				}
				if(checkSamePosition(nkr, nkc, csr, csc)) {
					csc++;
					csr++;
					if(!checkBoundary(csr, csc)) {
						csc--;
						csr--;
						break;
					}
				}
				ckr = nkr;
				ckc = nkc;
				break;
			case "LB" : 
				nkr = ckr + 1;
				nkc = ckc - 1; 
				if(!checkBoundary(nkr, nkc)) {
					break;
				}
				if(checkSamePosition(nkr, nkc, csr, csc)) {
					csc--;
					csr++;
					if(!checkBoundary(csr, csc)) {
						csc++;
						csr--;
						break;
					}
				}
				ckr = nkr;
				ckc = nkc;
				break;
			}
		}
		char kingC = (char)(ckc+'A');
		String answerKing = kingC+"" + (8-ckr)+"";
		char stoneC = (char)(csc + 'A');
		String answerStone = stoneC+"" + (8-csr)+"";
		System.out.println(answerKing);
		System.out.println(answerStone);
	}
	
	public static boolean checkBoundary(int nkr, int nkc) {
		
		if(!(nkr >=0 && nkr < 8 && nkc >= 0 && nkc < 8)) {
			return false;
		}
		
		return true;
	}
	
	public static boolean checkSamePosition(int nkr, int nkc, int csr,int csc) {
		
		if(nkr == csr && nkc == csc) {
			return true;
		}
		return false;
	}
}
