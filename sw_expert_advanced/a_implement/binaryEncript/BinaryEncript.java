package sw_expert_advanced.a_implement.binaryEncript;

import java.util.Scanner;

public class BinaryEncript {
	public static Scanner sc = new Scanner(System.in);
	public static int T = 0;
	public static String[] encript = {
			"0001101",
			"0011001",
			"0010011",
			"0111101",
			"0100011",
			"0110001",
			"0101111",
			"0111011",
			"0110111",
			"0001011"
	};

	public static void main(String[] args) {
		int N = sc.nextInt();

		while(T++ < N){
			int result = 0;
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			for(int i = 0; i < row; i++){
				String input = sc.next();
				if(!input.contains("1")) continue;
				for(int j = 0; j < input.length() - 56; j++){
					String subStr = input.substring(j, j+56);
					if(isEncript(subStr)){
//						System.out.println(subStr);
						result = getValidation(subStr);
					} 
				}
			}
			System.out.println("#"+T+" "+result);
		}

	}
	public static int getValidation(String input){
		int[] resultArr = new int[8];
		int k = 0;
		for(int i = 0; i < 8; i++){
			
			for(int j = 0; j < 10; j++){
				String temp = input.substring(k, k+7);
				if(encript[j].equals(temp)){
					resultArr[i] = j;
					break;
				}
			}
			k += 7;
		}
		int left = 0;
		int right = 0;
		for(int i = 0; i < 8; i++){
			if(i % 2 == 0){
				left += resultArr[i];
			} else {
				right += resultArr[i];
			}
		}
		if( ( (left*3 + right) % 10) ==0){
			return left+right;
		} else return 0;
	}
	public static boolean isEncript(String subStr){
		int trueIdx = 0;
		while(true){
			if(trueIdx == 56){
				return true;
			}
			if(hasEncript(subStr.substring(trueIdx, trueIdx+7))){
				trueIdx += 7;
			} else {
				return false;
			}
		}
	}
	
	public static boolean hasEncript(String susubStr){
		for(int i = 0; i < 10; i++){
			if(encript[i].equals(susubStr)){
				return true;
			}
		}
		return false;
	}

}
