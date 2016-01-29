package ooptest.polymorphism;

public class Student extends Person{

	public Student(String n){
		super(n);
	}
	
	public boolean isAsleep(int hr)
	{
		return 2< hr && 8> hr;
	}

}
