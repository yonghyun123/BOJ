package sw_expert.Arrary1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class babygin_ES {
	public static Scanner sc;
	public static ArrayList<Integer> N1;
	
	public static ArrayList<ArrayList<Integer>> permArr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		permArr = new ArrayList<>();
		N1 = new ArrayList<>();
		
		for(int i = 0; i < 6; i++){
			int temp = sc.nextInt();
			N1.add(temp);
		}
		
		perm(permArr, N1, 6, 0);
		
		for(ArrayList<Integer> item : permArr){
			for(int element : item){
				System.out.print(element);
			}
			System.out.println();
		}

		//순열만들기	
	}
	public static void perm(ArrayList<ArrayList<Integer>> perm, ArrayList<Integer> arr, int N, int depth){
		if(N == depth){
			ArrayList<Integer>temp = new ArrayList<>(arr);
			perm.add(temp);
			return;
		}
		for(int i = depth; i < N; i++){
			Collections.swap(arr, i, depth);
			perm(perm, arr, N, depth+1);
			Collections.swap(arr, i, depth);
		}
	}
	

}
