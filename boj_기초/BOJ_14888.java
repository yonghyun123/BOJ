package boj_기초;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_14888 {
	public static Scanner sc;
	public static int N;
	public static ArrayList<Integer> operand;
	public static ArrayList<Character> chOp;
	public static int[] intOp;
	public static ArrayList<Integer> resultList;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		operand = new ArrayList<>();
		chOp = new ArrayList<>();
		resultList = new ArrayList<>();

		N = sc.nextInt();
		intOp = new int[4];

		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			operand.add(temp);
		}

		// operator input
		for (int i = 0; i < 4; i++) {
			intOp[i] = sc.nextInt();
		}

		// convert intOp to charOp
		for (int i = 0; i < intOp.length; i++) {
			for (int j = 0; j < intOp[i]; j++) {
				switch (i) {
				case 0:
					chOp.add('+');
					break;
				case 1:
					chOp.add('-');
					break;
				case 2:
					chOp.add('*');
					break;
				case 3:
					chOp.add('/');
					break;
				default:
					break;
				}
			}
		}
		// main logic - make operator permutation
		perm(0);
		//
		Collections.sort(resultList);
		System.out.println(resultList.get(resultList.size()-1));
		System.out.println(resultList.get(0));
	}

	public static void perm(int depth) {
		if (depth == chOp.size()) {
			// for(char ch : chOp){
			// System.out.print(ch + " ");
			// }
			// System.out.println();
			resultList.add(solution());
			return;
		}

		for (int i = depth; i < chOp.size(); i++) {
			Collections.swap(chOp, i, depth);
			perm(depth + 1);
			Collections.swap(chOp, i, depth);
		}
	}

	// 
	public static int solution(){
		int total = operand.get(0);
		for(int i = 1; i < operand.size(); i++){
			int op2 = operand.get(i);
			switch(chOp.get(i-1)){
				case '+' : total += op2; break;
				case '-' : total -= op2; break;
				case '*' : total *= op2; break;
				case '/' : total /= op2; break;
				default :  break;
			}
		}
		return total;
	}

}
