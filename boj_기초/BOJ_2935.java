package boj_기초;

import java.util.Scanner;

public class BOJ_2935 {
	public static Scanner sc;
	public static String N1, N2;
	public static String op;
	public static void main(String[] args) {
		 sc = new Scanner(System.in);
		 
		 N1 = sc.nextLine();
		 op = sc.next();
		 N2 = sc.next();
		 int len = 0;
		 int len2 = 0;
		 
		 String result = "1";
		 switch (op) {
			case "*":
				if(N1.length() == 1 && N2.length() == 1) result ="1";
				else if(N1.length() == 1 || N2.length() == 1){
					len = Math.max(N1.length(), N2.length());
					for(int i = 0; i < len-1; i++){
						result += "0";
					}
				} else {
					len = N1.length() - 1;
					len2 = N2.length() -1;
					
					for(int i = 0; i < len + len2; i++){
						result += "0";
					}
				}
				break;
			case "+":
				if(N1.length() == 1 && N2.length() == 1) result ="2";
				else if(N1.length() == 1 || N2.length() == 1){
					len = Math.max(N1.length(), N2.length());
					for(int i = 0; i < len-2; i++){
						result += "0";
					}
					result += "1";
					//입력받은 두 수가 같으면
				} else if(N1.equals(N2)){
					result = "2";
					for(int i = 0; i < N1.length()-1; i++){
						result += "0";
					}
				}
				// 두수의 크기도 다르고 1도 아닐때
				else {
					len = N1.length();
					len2 = N2.length();
					int minLen = Math.min(len, len2);
					int maxLen = Math.max(len, len2);
					
					for(int i = maxLen-1; i > 0; i--){
						if(i == minLen) result += "1";
						else result += "0";
					}
				}
				break;
			default:
				break;
		 }
		 
		 System.out.println(result);
	}
}
