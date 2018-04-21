package sw_expert.Array1.Flatten;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	public static Scanner sc;
	public static int T = 0;
	
	public static void main(String[] args){
		sc = new Scanner(System.in);
		while(T++ < 10){
			int dump = sc.nextInt();
			int []input = new int[100];
			
			for(int i = 0; i < 100; i++){
				input[i] = sc.nextInt();
			}
			Arrays.sort(input);
			
			for(int i = 0; i < dump; i++){
				input[0] += 1;
				input[99] -= 1;
				Arrays.sort(input);
				
				if(input[0] == input[99]){
					break;
				}
			}
			int result = input[99] - input[0];
			System.out.println("#"+T+" "+result);
		}
	}

}
