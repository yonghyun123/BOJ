package boj_기초;

import java.util.Scanner;

public class BOJ_2920 {
	public static Scanner sc;
	public static int []input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		input = new int[8];
		
		for(int i = 0; i < 8; i++){
			input[i] = sc.nextInt();
		}
		if(isAscSorted(input)) System.out.println("ascending");
		else if(isDescSorted(input)) System.out.println("descending");
		else System.out.println("mixed");
	}
	public static boolean isAscSorted(int []input){
		
		for(int i = 0; i < input.length-1; i++){
			if(input[i] > input[i+1]) return false;
		}
		return true;
	}
	public static boolean isDescSorted(int []input){
		for(int i = 0; i < input.length-1; i++){
			if(input[i] < input[i+1]) return false;
		}
		return true;
	}

}
