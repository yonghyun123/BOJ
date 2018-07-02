package boj_기초;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2455 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0;
		int[] peopleArr = new int[4];
		for(int i = 0; i < 4; i++){
			int out = sc.nextInt();
			int in = sc.nextInt();
			
			if(i == 0){
				result = in;
				peopleArr[i] = in;
				continue;
			}
			result = result - out + in;
			peopleArr[i] = result;
		}
		
		Arrays.sort(peopleArr);
		System.out.println(peopleArr[3]);
	}

}
