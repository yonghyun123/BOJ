package sw_expert.Array1;

import java.util.Scanner;

public class Babygin_BT {
	
	public static Scanner sc;
	public static int []arr;
	public static int []bucket;
	public static int result;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		arr = new int[6];
		bucket = new int[12];
		result = 2;
		
		for(int i = 0; i < 6; i++){
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < arr.length; i++){
			bucket[arr[i]] += 1;
		}
		//find babygin
		for(int i = 0; i < bucket.length; i++){
			if(bucket[i] >= 3){
				bucket[i] -= 3;
				result -= 1;
				i = 0;
			}
			if(bucket[i] >= 1 && bucket[i+1] >= 1 && bucket[i+2] >= 1){
				result -= 1;
				bucket[i] -= 1;
				bucket[i+1] -= 1;
				bucket[i+2] -= 1;
				i = 0;
			}
		}
		
		if(result == 0){
			System.out.println("baby-gin");
		}
	}
}
