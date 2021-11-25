package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	// BOJ / 1244번 / 스위치 켜고 끄기 / 구현 / 브론즈2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		int s = Integer.parseInt(br.readLine());

		for(int i=0; i<s; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(stk.nextToken());
			int num = Integer.parseInt(stk.nextToken());
			
			if(sex == 1) {
				arr = isBoy(arr, num);
			}
			else {
				arr = isGirl(arr, num);
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			if((i+1) % 20 == 0) System.out.println();
		}
	}
	
	public static int[] isBoy(int [] arr, int num) {
		
		for(int i=0; i<arr.length; i++) {
			if( (i+1) % num == 0 ) {
				arr[i] = arr[i] == 1 ? 0 : 1;
			}
		}
		return arr;
	}
	
	public static int[] isGirl (int [] arr, int num) {
		
		int index = num-1; 
		int left = index-1;
		int right = index+1;
		arr[index] = arr[index] == 1 ? 0 : 1;
		while(left >= 0 && right < arr.length) {
			if(arr[left] == arr[right]) {
				arr[left] = arr[left] == 1 ? 0 : 1;
				arr[right] = arr[right] == 1 ? 0 : 1;

			}
			else break;
			left--;
			right++;
		}
		
		return arr;
	}
}
