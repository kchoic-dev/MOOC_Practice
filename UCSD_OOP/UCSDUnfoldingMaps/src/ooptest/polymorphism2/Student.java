package ooptest.polymorphism2;

public class Student extends Person{
	public void method1() {
		  System.out.println("Student1");
		  super.method1(); // super �� compile time�� binding
		  method2();  // this �� runtime�� binding
		}
		public void method2() {
			System.out.println("Student2");
		}
}
