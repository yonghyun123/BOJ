package 구현;

import java.util.Scanner;
import java.util.Stack;

//로또
public class BOJ_6603 {
	
	public static Scanner sc = new Scanner(System.in);
	public static int[] arr;
	public static int n;
	public static void main(String[] args) {
		 // combination 이용
		
		while(true){
			if( (n = sc.nextInt()) != 0 ){
				Stack<Integer> st = new Stack<>();
				arr = new int[n];
				for(int i = 0; i < n; i++){
					arr[i] = sc.nextInt();
				}
				
				combination(st, 6);
				System.out.println();
			} else{
				break;
			}
		}

	}
	
	public static void combination(Stack<Integer> st, int depth){
		if(depth == 0){
			printStack(st);
		}
		int start = st.empty() ? 0 : st.lastElement() + 1;
		for(int i = start; i < arr.length; i++){
			st.push(i);
			combination(st, depth-1);
			st.pop();
		}
	}
	
	public static void printStack(Stack<Integer> st){
		for(int item: st){
			System.out.print(arr[item] + " ");
		}
		System.out.println();
	}

}
