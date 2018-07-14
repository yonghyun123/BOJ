package 구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2333 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<int[]> contentBox = new ArrayList<>();
	public static int depth;
	public static int numOfBox;
	public static int hp;
	public static int result;
	
	public static int resultTime = 100000;
	

	public static void main(String[] args) {
		depth = sc.nextInt();
		numOfBox = sc.nextInt();
		hp = 10;
		result = 0;
		
		
		for(int i = 0; i < numOfBox; i++){
			int trashTime = sc.nextInt();
			int incHp = sc.nextInt();
			int boxHeight =sc.nextInt();
			int[] temp = {trashTime, incHp, boxHeight};
			contentBox.add(temp);
		}
		
		Collections.sort(contentBox, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] > o2[0]) return 1;
				else return -1;
			}
		});
		System.out.println(resultTime);
	}
	
}
