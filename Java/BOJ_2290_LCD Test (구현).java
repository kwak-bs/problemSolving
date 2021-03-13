package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290 {
	// BOJ / 2290번 / LCD Test / 구현 / 실버2
	
	static final int c[][] = {
			{1,1,1,0,1,1,1}, // 0
			{0,0,1,0,0,1,0}, // 1
	        {1,0,1,1,1,0,1}, // 2
	        {1,0,1,1,0,1,1}, // 3
	        {0,1,1,1,0,1,0}, // 4
	        {1,1,0,1,0,1,1}, // 5
	        {1,1,0,1,1,1,1}, // 6
	        {1,0,1,0,0,1,0}, // 7
	        {1,1,1,1,1,1,1}, // 8
	        {1,1,1,1,0,1,1}  // 9
	};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int s = Integer.parseInt(stk.nextToken());
		String n = stk.nextToken();
		int l = n.length();
		
		// s가 1일경우 행의 최대 길이는 5이다. 즉, s가 1일 경우의 각 행 별로 구하고 s배 해준다.
		for(int i=0; i<5; i++) {
			// 가로선 구하기
			if(i == 0 || i == 2 || i == 4) {
				for(int j=0; j<l; j++) {
					int now = n.charAt(j) - '0';
					
					if(j != 0) {
						System.out.print(" ");
					}
					System.out.print(" ");

					if((i==0 && c[now][0] == 1) || (i == 2 && c[now][3] == 1)
							|| (i == 4 && c[now][6] == 1)) {
						for(int k=0; k<s; k++) {
							System.out.print("-");
						}
					}
					else {
						for(int k=0; k<s; k++) {
							System.out.print(" ");
						}
					}
					System.out.print(" ");
				}
				System.out.println();
			}
			// 세로선 구하기 
			else {
                for (int h=0; h<s; h++) {
                    for (int j=0; j<l; j++) {
                        int now = n.charAt(j) - '0';
                        if (j != 0) {
                            System.out.print(" ");
                        }
                        if ((i == 1 && c[now][1] == 1) || (i == 3 && c[now][4] == 1)) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                        for (int k=0; k<s; k++) {
                            System.out.print(" ");
                        }
                        if ((i == 1 && c[now][2] == 1) || (i == 3 && c[now][5] == 1)) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
			}
		}
	}
}
