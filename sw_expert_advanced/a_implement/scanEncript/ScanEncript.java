package sw_expert_advanced.a_implement.scanEncript;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScanEncript {
	public static Scanner sc = new Scanner(System.in);
	public static Map<Character, String> hexToBinary = new HashMap<>();
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
		hexToBinary.put('0', "0000");
		hexToBinary.put('1', "0001");
		hexToBinary.put('2', "0010");
		hexToBinary.put('3', "0011");
		hexToBinary.put('4', "0100");
		hexToBinary.put('5', "0101");
		hexToBinary.put('6', "0110");
		hexToBinary.put('7', "0111");
		hexToBinary.put('8', "1000");
		hexToBinary.put('9', "1001");
		hexToBinary.put('A', "1010");
		hexToBinary.put('B', "1011");
		hexToBinary.put('C', "1100");
		hexToBinary.put('D', "1101");
		hexToBinary.put('E', "1110");
		hexToBinary.put('F', "1111");
		
//		int T = sc.nextInt();
		
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		for(int i = 0; i < row; i++){
			String inputStr = sc.next();
			String newStr = "";
			for(int j = 0; j < inputStr.length(); j++){
				char temp = inputStr.charAt(j);
				newStr += hexToBinary.get(temp);
			}
			System.out.println(newStr);
			//변환끝
			char flip = newStr.charAt(0);
			int cnt = 0;
			int []cntArr = new int[4];
			
			for(int j = 1, k = 0; j < newStr.length()-1; j++,k++){
				if(cnt == 4){
					//원래는 여기서 최대공약수 실행
					int result = 0;
					while((result = gcd(cntArr[0],gcd(cntArr[1],gcd(cntArr[2],cntArr[3])))) >= 2){
						for(int a = 0; a < cntArr.length; a++){
							cntArr[a] /= 2;
						}
					}
					j = j-1;
					cnt = 0;
					k = 0;
					continue;
				}
				if(flip != newStr.charAt(j)){
					cntArr[cnt] = k;
					cnt++;
					flip = newStr.charAt(j);
					k = 0;
				}	
			}
		}
	}
	// a > b
	public static int gcd(int a, int b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
		
	}

}
