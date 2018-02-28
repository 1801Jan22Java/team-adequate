package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;

import com.revature.beans.*;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//funWithCaves(ac);
		
		funWithBears(ac);
		
		// close AC after we're done with it 
		((AbstractApplicationContext) ac).close();
	}
	
	static void funWithBears(ApplicationContext ac) {
		Bear b1 = (BearWithSetter) ac.getBean("bearWithSetter");
		b1.methodInBear();
		
		Bear b2 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b2.methodInBear();
	}
	
	static void funWithCaves(ApplicationContext ac) {
		
		Cave c = (Cave) ac.getBean("cave");
		
		System.out.println(c.toString());
		
		Cave c1 = (Cave) ac.getBean("cave");
		
		System.out.println(c.toString());
		
		// same cave, because the cave bean is singleton-scoped by default
		
		System.out.println("Cave id: = "+c.getId());
		System.out.println("Cave name: = "+c.getName());
		
		
		
	}

}
