package boj_기초;
interface B {
	public void B1();
	public void B2();
}

abstract class C{
	public void C1(){
		System.out.println("ddd");
	}
	abstract public void C2();
}

abstract class D extends C implements B{
	public void C1(){
		
	}
	public void C2(){
		System.out.println("ddd");
	}
}

interface E extends B{
	public void E1();
	public void E2();
}

//이걸 꼭 기억하자
public class A {
	
	public static void main(String[] args){
		boolean[] visited = new boolean[5];
		int[] board = new int[4];
		test(visited);
		System.out.println(visited[0]);
	}
	
	public static void test(boolean[] copy){
		copy[0] = true;
	}
}