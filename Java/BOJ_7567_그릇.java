package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7567 {
	//BOJ / 7567번 / 그릇  / 구현 / 브2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String input = br.readLine();
		
		String [] arr = input.split("");
		
		int height = 10;
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1].equals(arr[i])) {
				height += 5;
			}
			else 
				height += 10;
		}
		System.out.println(height);
	}

}
