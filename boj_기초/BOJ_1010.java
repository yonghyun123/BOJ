package boj_기초;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1010 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int i = 0; i < T; i++){
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			//분모
			BigInteger result = new BigInteger("1");
			int temp = k;
			
			for(int j = 0; j < k; j++){
				result = result.multiply(BigInteger.valueOf(n));
				n--;
			}
			
			for(int j = 0; j < k; j++){
				result = result.divide(BigInteger.valueOf(temp));
				temp--;
			}
			
			System.out.println(result);
		}
	}

}
