package problemSolve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_9625 {
	//BOJ / 9625번 / BABBA  / dp / 브1
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] dpA = new int [n];
		int [] dpB = new int [n];
		
		dpA[0] = 0; // n=1일때, B
		dpB[0] = 1; 
		
		if(n >1) {
			dpA[1] = 1; // n=2일때, BA
			dpB[1] = 1;			
		}
		
		for(int i =2; i<n; i++) { // 규칙 찾아주면 쉬움 
			dpA[i] = dpA[i-2] + dpA[i-1];
			dpB[i] = dpB[i-2] + dpB[i-1];
		}
		
		System.out.println(dpA[n-1] + " "+dpB[n-1]);
	}
}
