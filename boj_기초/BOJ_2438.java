package boj_기초;

import java.util.Scanner;

public class BOJ_2438 {
	public static Scanner sc;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i++){
			for(int j = 0; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
