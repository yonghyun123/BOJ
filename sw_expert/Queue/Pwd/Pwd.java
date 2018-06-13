package sw_expert.Queue.Pwd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pwd {
	public static Scanner sc;
	public static int T = 0;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		while(T++ < 10){
			int tmpT = sc.nextInt();
			int idx = 1;
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 0; i < 8; i++){
				int inputNum = sc.nextInt();
				q.add(inputNum);
			}
			
			while(!isZero(q)){
				int val = q.poll();
				if(val < idx) val = 0;
				else val -= idx;
				q.add(val);
				idx += 1;
				if(idx > 5) idx = 1;
				
			}
			System.out.print("#" + T + " ");
			for(int item : q){
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean isZero(Queue<Integer> q){
		for(Integer item : q){
			if(item <= 0) return true;
		}
		return false;
	}

}
