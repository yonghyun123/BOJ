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

public class A extends D{

	@Override
	public void B1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void B2() {
		// TODO Auto-generated method stub
		
	}
	
}