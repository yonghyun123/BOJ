package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 괴짜 보물 지도
30점
  문제의 입력값은 각 언어의 표준입력(stdin) 함수를, 출력값은 표준출력(stdout) 함수를 사용해주세요.
괴짜 보물 지도
어떤 보물 사냥꾼이 가로, 세로 크기가 각각 n인 matrix로 구성된 보물지도를 가지고 있다.

Matrix의 각 node에는 방향 정보(R, L, B, F)와 숫자(이동 가중치)가 존재한다.

R : Right
L : Left
B : Backward
F : Forward
위치 표기를 [x, y]로 하고 왼쪽 최상단을 [0, 0]으로 할 때, 보물 사냥꾼의 최초 출발 방향은 [0, 0]에서 y가 증가하는 방향이다.

왼쪽 최하단은 [0, n-1]이다.
오른쪽 최상단은 [n-1, 0]이다.
오른쪽 최하단은 [n-1, n-1]이다.
최초 출발 시 직전 진행 방향은 B로 간주한다.
직전 진행 방향 + matrix의 방향 정보에 의해 다음 진행 방향이 결정되고 가중치만큼 이동한다. 표로 표기하면 다음과 같다.

직전 진행 방향   node 방향 정보   다음 진행 방향
F(↑)   F(↑)   F(↑)
F(↑)   R(→)   R(→)
F(↑)   L(←)   L(←)
F(↑)   B(↓)   B(↓)
R(→)   F(↑)   R(→)
R(→)   R(→)   B(↓)
R(→)   L(←)   F(↑)
R(→)   B(↓)   L(←)
L(←)   F(↑)   L(←)
L(←)   R(→)   F(↑)
L(←)   L(←)   B(↓)
L(←)   B(↓)   R(→)
B(↓)   F(↑)   B(↓)
B(↓)   R(→)   L(←)
B(↓)   L(←)   R(→)
B(↓)   B(↓)   F(↑)
이전에 방문했던 node에 다시 방문하였을 때, 다음 진행 방향이 이미 탐색한 진행 방향으로 결정되는 경우 해당 node에 보물이 존재한다. (보물이 존재하지 않는 경우는 없다.)

보물이 존재하는 node의 정보를 출력하는 프로그램을 작성하시오.

입력 형식
표준 입력을 통하여 입력받는다.

첫 번째 줄에는 정사각형 matrix 한 변의 크기 n이 주어진다.

두 번째 줄부터 노드의 정보가 순차적으로 주어진다.

[0, 0] ~ [n-1, n-1]까지 순차적으로 노드에 정보가 채워진다.

입력 예 1

5
F1 B1 R1 L2 F1
F1 L2 L1 L2 F1
F1 B1 B1 L2 F1
F1 L2 R1 L2 F1
L3 L1 B2 L3 B1
보물 사냥꾼이 이동한 경로
1(↓)   X   X   X   X
2(↓)   8(↓)   X   7(←)-11(←)   X
3(↓)   X   X   X   X
4(↓)   9(→)   X   10(↑)   X
5(→)   X   X   6(↑)   X
입력 예 2
5
F4 B1 R1 L2 F1
F1 R1 R1 R1 F1
F1 R1 F1 R1 L2
F1 R1 R1 R1 F1
L4 L1 B2 R3 L2
보물 사냥꾼이 이동한 경로
1(↓)   X   X   X   X
X   7(→)   8(↓)-18(→)   19(↓)   X
X   6(↑)-12(→)   5(←)-9(↓)-13(→)-17(↑)-21(←)   14(↓)-20(←)   4(←)
X   11(↑)   10(←)-16(↑)   15(←)   X
2(→)   X   X   X   3(↑)
출력 형식
보물이 존재하는 node의 좌표

'입력 예1'의 출력 :
3 1
'입력 예2'의 출력 :
2 2

입/출력 예시
⋇ 입출력 형식을 잘 지켜주세요.
␣ : 공백
↵ : 줄바꿈
−⇥ : 탭
보기 입력 1
5
F1 B1 R1 L2 F1
F1 L2 L1 L2 F1
F1 B1 B1 L2 F1
F1 L2 R1 L2 F1
L3 L1 B2 L3 B1
출력 1
3 1
 * @author yonghyun
 *
 */
public class Ex02 {
	public static String B, F, R, L; // ↓ ↑ ← ↑
	public static String[][] board;
	public static int x, y;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            int[][] visited = new int[n][n];
            board = new String[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for(int j = 0; j < row.length; j++){
                	board[i][j] = row[j];
                }
            }
             
            String first = "B";
            searchNode(board, visited, first, 0, 0);
            System.out.println(x+","+y);
        }

	}
	
	public static void searchNode(String[][] board, int[][] visited, String prev, int row, int col){

		visited[row][col] = 1;
		int nextRow = 0;
		int nextCol = 0;
		String curlook = null;
		
		switch (prev) {
		
		case "F":

			if(board[row][col].contains("F")){
				curlook = "F";
				nextRow = row - (board[row][col].charAt(1) -'0');
				nextCol = col;
				
			} else if(board[row][col].contains("R")){
				curlook = "R";
				nextRow = row;
				nextCol = col + (board[row][col].charAt(1) -'0');
			} else if(board[row][col].contains("L")){
				curlook = "L";
				nextRow = row;
				nextCol = col - (board[row][col].charAt(1) -'0');
			} else if(board[row][col].contains("B")){
				curlook = "B";
				nextRow = row + (board[row][col].charAt(1) -'0');
				nextCol = col;
			}
			break;

		case "R":
			if(board[row][col].contains("F")){
				curlook = "R";
				nextRow = row;
				nextCol = col + (board[row][col].charAt(1) -'0');
			} else if(board[row][col].contains("R")){
				curlook = "B";
				nextRow = row + (board[row][col].charAt(1) -'0');
				nextCol = col;
			} else if(board[row][col].contains("L")){
				curlook = "F";
				nextRow = row - (board[row][col].charAt(1) -'0');
				nextCol = col;
			} else if(board[row][col].contains("B")){
				curlook = "L";
				nextRow = row; 
				nextCol = col - (board[row][col].charAt(1) -'0');
			}
			break;

		case "L":
			if(board[row][col].contains("F")){
				curlook = "L";
				nextRow = row;
				nextCol = col- (board[row][col].charAt(1) -'0');
			} else if(board[row][col].contains("R")){
				curlook = "F";
				nextRow = row - (board[row][col].charAt(1) -'0');
				nextCol = col;
			} else if(board[row][col].contains("L")){
				curlook = "B";
				nextRow = row + (board[row][col].charAt(1) -'0');
				nextCol = col;
			} else if(board[row][col].contains("B")){
				curlook = "R";
				nextRow = row;
				nextCol = col + (board[row][col].charAt(1) -'0');
			}
			break;

		case "B":
			if(board[row][col].contains("F")){
				curlook = "B";
				System.out.println("ddd");
				nextRow = row + (board[row][col].charAt(1) -'0');
				nextCol = col;
			} else if(board[row][col].contains("R")){
				curlook = "L";
				nextRow = row;
				nextCol = col - (board[row][col].charAt(1) -'0');
			} else if(board[row][col].contains("L")){
				curlook = "R";
				nextRow = row;
				nextCol = col + (board[row][col].charAt(1) -'0');
			} else if(board[row][col].contains("B")){
				curlook = "F";
				nextRow = row - (board[row][col].charAt(1) -'0');
				nextCol = col;
			}
			break;

		default:
			break;
		}
		System.out.println(nextRow+","+nextCol);
		if(visited[nextRow][nextCol] == 0){
			searchNode(board, visited, curlook, nextRow, nextCol);	
		} else {
			x = col;
			y = row;
			return;
		}
		
	}
}
