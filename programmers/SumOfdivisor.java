package programmers;

import java.util.Scanner;

public class SumOfdivisor {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(retCenterWord(""));
		

	}
	
	public static String retCenterWord(String inputStr){
		
		String retCenterStr = new String();
		int divideLen = inputStr.length() / 2 -1;
		
		if(inputStr == null) return null;
		
		if(inputStr.length() % 2 == 1){
			retCenterStr = String.valueOf(inputStr.charAt(inputStr.length() / 2));
		} else {
			retCenterStr = inputStr.substring(divideLen, divideLen+2);
		}
		
		return retCenterStr;
	}

}
