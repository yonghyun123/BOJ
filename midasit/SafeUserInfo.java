package midasit;

import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * 
 * 당신에게 회사 웹사이트의 "회원가입모듈"을 만드는 과제가 주어졌습니다. 아이디와 패스워드를 입력 받고, 
 * 아이디와 패스워드가 생성규칙에 부합한다면 "T" 부합하지 않는다면 "F"를 출력하는 프로그램을 작성해 주시기 바랍니다.
아이디 패스워드 생성 규칙은 다음과 같습니다.

아이디는 6-12자 이내의 “알파벳 소문자와 숫자의 조합”만 입력 받을 수 있어야 합니다.
패스워드는 8~16자 이내의 “알파벳 소문자와 숫자의 조합”만을 입력 받을 수 있어야 합니다.
아이디/패스워드에는 숫자와 알파벳 소문자가 한 개 이상씩 포함되어야 합니다. (예, tiger123, monkey2)
패스워드는 연속으로 동일한 3개의 문자 또는 숫자를 포함 할 수 없습니다. (예, abcd111ab, abaaacdef5)
입력

입력은 표준 입력(stdin)으로 주어집니다.
첫 번째 줄에는 아이디, 두 번째 줄에는 패스워드를 입력합니다.

출력

출력은 표준 출력(stdout)으로 이루어집니다.
아이디와 패스워드가 생성규칙에 모두 부합한다면 “T” 부합하지 않는다면 “F”를 출력합니다.

tiger1
monkey09

출력
T

<예2>
입력
rabbit
monkey

출력
F
 */
public class SafeUserInfo {
	public static Scanner sc;
	public static  String patternStr = "^[a-z]*$"; //소문자인지 영문인지 검사
	public static String patternNum = "^[0-9]*$"; //숫자인지 검사
	public static String patternMix = "^[a-z0-9]*$";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		
		String id = sc.next();
		String pwd = sc.next();
		
		if(isUserInfo(id, pwd)){
			System.out.println("T");
		} else {
			System.out.println("F");
		}
	}
	
	public static boolean isUserInfo(String id, String pwd){
		if(id.length() < 6 || id.length() > 12){
			return false;
		}
		if(pwd.length() < 8 || pwd.length() > 12){
			return false;
		}
		//id가 소문자+숫자로 이뤄져있는지 검사
		if(Pattern.matches(patternMix, id)) {
			//first, mix str
			if(Pattern.matches(patternNum, id) || Pattern.matches(patternStr, id)){
				return false;
			}
		} else {
			return false;
		}
		
		//pwd가 소문자+숫자로 이뤄져있는지 검사
		if(Pattern.matches(patternMix, pwd)) {
			if(Pattern.matches(patternNum, pwd) || Pattern.matches(patternStr, pwd)){
				return false;
			}
		} else {
			return false;
		}
		
		for(int i = 0; i < pwd.length()-2; i++){
			if(pwd.charAt(i) == pwd.charAt(i+1) && pwd.charAt(i+1) == pwd.charAt(i+2)){
				return false;
			}
		}
		
		return true;
	}

}
