package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918 {
	// BOJ / 16918¹ø / º½¹ö¸Ç / ±¸Çö, ½Ã¹Ä·¹ÀÌ¼Ç , ±×·¡ÇÁ / ½Ç¹ö1
	static boom map[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());
		map = new boom[r][c];
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = new boom(str.charAt(j), 0);
			}
		}
		
		int seconds = 1;
		boolean btn = false;
		while(seconds < n) {
			
			seconds++;
			if(!btn) {
				plant(r,c, seconds);
			}
			else if(btn) {
				explode(r,c, seconds);
			}
			btn = !btn;
		}
		// Ãâ·ÂºÎ
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(map[i][j].status);
			}
			System.out.println();
		}
	}
	
	public static void plant(int r, int c, int s) {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				boom now = map[i][j];
				char nowStatus = now.status;
				
				if(nowStatus == '.') {
					boom newBoom = new boom('O', s);
					map[i][j] = newBoom;
				}
			}
		}
	}
	
	public static void explode (int r, int c, int s) {
		
		boolean flag[][] = new boolean[r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				boom now = map[i][j];
				char nowStatus = now.status;
				int nowTime = now.time;
				
				// ÆøÅºÀÌ Á¸ÀçÇÏ°í 3ÃÊ Àü¿¡ ¼³Ä¡µÈ ÆøÅºÀÌ¸é 
				if(nowStatus == 'O' && s - nowTime >= 3) {
					// ÇöÀç À§Ä¡ÀÇ ÆøÅº Á¦°Å
					flag[i][j] = true;
					for(int t=0; t<4; t++) {
						int nr = i + dr[t];
						int nc = j + dc[t];
						
						// ÁÖº¯ À§Ä¡ ÆøÅº Á¦°Å 
						if(nr >= 0 && nr <r && nc>= 0 && nc<c) {
							flag[nr][nc] = true;
						}
					}
				}
			}
		}
		// µ¿½Ã ´Ù¹ßÀû ÆøÅºÀ» ÅÍÆ®·ÁÁà¾ßÇÑ´Ù. 
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(flag[i][j]) {
					//ÆøÅº Á¦°Å
					boom remove= new boom('.' , 0);
					map[i][j] = remove;
				}
			}
		}
	}
	
	private static class boom {
		char status;
		int time;
		public boom (char status, int time) {
			this.status = status;
			this.time = time;
		}
	}
}
