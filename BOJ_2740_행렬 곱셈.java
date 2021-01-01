package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2740 {
	// BOJ / 2740¹ø / Çà·Ä °ö¼À / ¼öÇÐ / ºê1
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Çà·Ä A	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int y1 = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int A[][] = new int[y1][x1];
		for(int i=0; i<y1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// Çà·Ä B	
		st = new StringTokenizer(br.readLine(), " ");
		int y2 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int B[][] = new int[y2][x2];
		for(int i=0; i<y2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x2; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// Çà·Ä °ö¼À
		int ans [][] = new int [y1][x2];
		for(int i=0; i<y1; i++) {
			for(int j=0; j<x2; j++) {
				for(int k=0; k<x1; k++) {
					ans[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		
		for(int i=0; i<y1; i++) {
			for(int j=0; j<x2; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}
