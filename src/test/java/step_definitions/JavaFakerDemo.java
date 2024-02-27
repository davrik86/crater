package step_definitions;

import com.github.javafaker.Faker;

public class JavaFakerDemo {
 
	public static void main(String[] args) {
		Faker fake= new Faker();
		
		System.out.println(fake.address().streetAddress());
		
		
		
		
	}
}
