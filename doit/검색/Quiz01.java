package doit.검색;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] arr = new int[num+1];
		
		for(int i = 0; i < num; i++){
			arr[i] = sc.nextInt();
		}
		
		System.out.print("search input:");
		int key = sc.nextInt();
		
		int idx  = seqSearchSen(arr, num, key);
		
		if(idx == -1){
			System.out.println("-1");
		} else{
			System.out.println("find!");
		}
		
		
	}
	public static int seqSearchSen(int[] arr, int n, int key){
		arr[n] = key;
		int i = 0;
		for(i = 0; i < n; i++){
			if(arr[i] == key) break;
		}
		return i == n ? -1 : i;
	}

}
