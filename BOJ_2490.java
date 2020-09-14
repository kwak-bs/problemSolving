package problemSolve;

import java.util.Scanner;

public class BOJ_2490 {
	// BOJ / 2490¹ø / À·³îÀÌ / ±¸Çö / ºê2
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				int n = sc.nextInt();
				sum += n;
			}
			
			switch(sum) {
			case 0 :
				System.out.println("D");
				break;
			case 1 :
				System.out.println("C");
				break;
			case 2 :
				System.out.println("B");
				break;
			case 3 :
				System.out.println("A");
				break;
			case 4 :
				System.out.println("E");
				break;
			}
			sum = 0;
		}
		
		
		
		
	}

}
