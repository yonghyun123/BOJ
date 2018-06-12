package boj_기초;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_11650 {
	
	public static Scanner sc;
	public static int N;
	public static ArrayList<int[]> input;

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		sc = new Scanner(System.in);
		N = sc.nextInt();
		
		input = new ArrayList<>();
		
		for(int i = 0; i < N; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int []temp = {x,y};
			input.add(temp);
		}
		
		for(int i = 0; i < input.size(); i++){
			for(int j = 0; j <input.size()-1 -i; j++){
				if(input.get(j)[0] >input.get(j+1)[0]){
					Collections.swap(input, j, j+1);
				} else if(input.get(j)[0] == input.get(j+1)[0]){
					if(input.get((j))[1] > input.get(j+1)[1]){
						Collections.swap(input, j, j+1);
					}
				}
			}
		}
		for(int[] item : input){
			System.out.println(item[0]+" "+item[1]);
		}
		
	}
	
}

