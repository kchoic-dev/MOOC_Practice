package ooptest.inheritance;

public class Student extends Person{

	private int id;
	public Student(String n){
		super(n);
		System.out.print("#3 ");
	}
	public Student(){
		this("student");
		// this.setName("Student");//=> compile error
		System.out.print("#2 ");
	}
	
	public int getId(){
		return id;
	}

}
