package sw_expert.String.String;

import java.util.Scanner;
import java.util.regex.Pattern;

public class String1 {
	public static Scanner sc;
	public static int T = 0;
	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		while(T++ < 10){
			int tmpT = sc.nextInt();
			String pattern = sc.next();
			String text = sc.next();
			int result = 0;
			
			
			while(text.contains(pattern)){
//				System.out.println(text);
				result += 1;
				text = text.replaceFirst(pattern, "");
			}

			System.out.println(result);
			
		}
	}

}
