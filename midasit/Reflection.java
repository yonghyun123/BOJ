package midasit;

import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class c = Class.forName(args[0]);
			Method[] m = c.getDeclaredMethods();
			for(int i = 0; i < m.length; i++){
				System.out.println(m[i].toString());
			}
		}catch(Throwable e){
			
		}

	}

}
