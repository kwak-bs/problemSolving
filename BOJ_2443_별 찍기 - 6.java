package problemSolve;

import java.util.Scanner;

public class BOJ_2443 {
	//BOJ / 2231¹ø / º° Âï±â - 6 / ±¸Çö / ºê3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) { // n¸¸Å­ µ·´Ù
			for(int k=n-i; k<n; k++) { // ¾Õ¿¡ ¶ç¾î¾²±â
				System.out.print(" ");
			}
			for(int j=i; j<2*n-i-1; j++) { // º°Âï±â 
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
