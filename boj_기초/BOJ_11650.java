package boj_기초;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
//		
//		for(int i = 0; i < input.size(); i++){
//			for(int j = 0; j <input.size()-1 -i; j++){
//				if(input.get(j)[0] >input.get(j+1)[0]){
//					Collections.swap(input, j, j+1);
//				} else if(input.get(j)[0] == input.get(j+1)[0]){
//					if(input.get((j))[1] > input.get(j+1)[1]){
//						Collections.swap(input, j, j+1);
//					}
//				}
//			}
//		}
		
		Collections.sort(input, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				// TODO Auto-generated method stub
//				for(int i = 0; i < a.length; i++){
//					System.out.println("a["+i+"] = "+a[i]);
//				}
//				for(int i = 0; i < b.length; i++){
//					System.out.println("b["+i+"] = "+b[i]);
//				}
				if(a[0] == b[0]) return a[1]-b[1];
				else return a[0]-b[0];
			}
		});
		for(int[] item : input){
			System.out.println(item[0]+" "+item[1]);
		}
		
	}
	
}

