package 구현;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 백준 14888 연산자끼어넣기 
 * 완전탐색
 * 이건 꼭 풀어야해
 */
public class BOJ_14888 {
	public static Scanner sc = new Scanner(System.in);
	public static int n;
	public static ArrayList<Integer> solutionResult = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int[] a = {93, 30, 55};
		int[] b = {1,  30, 5} ;
		
		ArrayList<Integer> result = solution(a,b);
		int[] ret = new int[result.size()];
		ret = convertIntegers(result);
		
		for(int i = 0; i < ret.length; i++){
			System.out.print(ret[i] + " ");
		}
		
	}
	
	public static ArrayList<Integer> solution(int[] progresses, int[] speeds){
		
		int loopCnt = progresses.length;
		int []result = new int[loopCnt];
		int resetCnt = 1;
		
		
		for(int i = 0 ; i < loopCnt; i++){
			result[i] = (100 - progresses[i]) / speeds[i];
			
		}
		
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i]);	
		}
		
		
		for(int i = 0; i < loopCnt-1; i++){
			if(result[i] >  result[i+1]) {
				result[i+1] = result[i];
				resetCnt += 1;
			} else {
				System.out.println("resetCnt = "+resetCnt);
				solutionResult.add(resetCnt);
				resetCnt = 1;
				
				if(i == loopCnt -2){
					solutionResult.add(resetCnt);
				}
			}
		}
	
		
		
		return solutionResult;
		
	}
	
	public static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
	

}
