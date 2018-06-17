package sw_expert.List.Encript2;

import java.util.ArrayList;
import java.util.Scanner;

public class Encript2 {
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<String> encList;
	private static ArrayList<String> opList;

	public static void main(String[] args) {
		int T = 0;
		while (T++ < 10) {

			encList = new ArrayList<>();
			opList = new ArrayList<>();

			int numOfEnc = sc.nextInt();
			for (int i = 0; i < numOfEnc; i++) {
				encList.add(sc.next());
			}

			int numOfOp = sc.nextInt();
			for (int i = 0; i < numOfOp; i++) {
				String chOp = sc.next();
				switch (chOp) {
				case "I": insert(); break;
				case "D": delete(); break;
				default: break;
				}

			}

			System.out.print("#" + T + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(encList.get(i) + " ");
			}
			System.out.println();
		}
	}

	public static void delete() {
		int startLoc = sc.nextInt();
		int delNum = sc.nextInt();
		for (int j = 0; j < delNum; j++) {
			encList.remove(startLoc);
		}
	}

	public static void insert() {
		int startLoc = sc.nextInt();
		int addNum = sc.nextInt();
		for (int j = 0; j < addNum; j++) {
			encList.add(startLoc + j, sc.next());
		}
	}

}
