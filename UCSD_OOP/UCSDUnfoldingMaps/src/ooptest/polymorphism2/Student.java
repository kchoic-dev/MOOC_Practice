package ooptest.polymorphism2;

public class Student extends Person{
	public void method1() {
		  System.out.println("Student1");
		  super.method1(); // super 는 compile time에 binding
		  method2();  // this 는 runtime에 binding
		}
		public void method2() {
			System.out.println("Student2");
		}
}
