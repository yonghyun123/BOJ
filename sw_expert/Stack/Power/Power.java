package sw_expert.Stack.Power;

import java.util.Scanner;

public class Power {
	public static int T = 0;
	public static Scanner sc;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			int tmpT = sc.nextInt();
			int base = sc.nextInt(); // 밑
			int expon = sc.nextInt(); // 지수
			System.out.println("#" + tmpT + " " + recursion(base,expon));
			
		}
	}
	
	public static int recursion(int base, int expon){
		if(expon == 1){
			return base;
		} else {
			return base * recursion(base, expon-1);
		}
		
	}

}
