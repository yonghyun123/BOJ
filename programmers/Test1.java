package programmers;

import java.util.Arrays;

public class Test1 {
	
	public static void main(String []args){
		int []arr = {4,2,1};
		System.out.println(solution(arr));
		
	}
	
	public static boolean solution(int []arr){
		Arrays.sort(arr);
		for(int i = 0; i < arr.length -1; i++){
			if(arr[i+1] - arr[i] != 1){
				return false;
			}
		}
		
		return true;
	}

}
