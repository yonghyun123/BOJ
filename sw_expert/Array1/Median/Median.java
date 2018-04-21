package sw_expert.Array1.Median;

import java.util.Scanner;

public class Median {
	
	public static int T = 0;
	public static Scanner sc;
	public static int []input;
	public static int []bucket;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			int max = -1;
			input = new int[1000];
			bucket = new int[101];
			int result = 0;
			int tmpT = sc.nextInt();
			
			//bucket 완성
			for(int i = 0; i < 1000; i++){
				input[i] = sc.nextInt();
				bucket[input[i]] += 1;
			}
			
			for(int i = 0; i < 100; i++){
				if(bucket[i] >= max){
					max = bucket[i];
					result = i;
				}
			}
			
			System.out.println("#"+tmpT+" "+result);
			
		}

	}

}
