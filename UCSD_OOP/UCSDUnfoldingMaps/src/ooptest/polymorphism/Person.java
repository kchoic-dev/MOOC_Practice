package ooptest.polymorphism;

public class Person {

	private String name;
	public Person(String n){
		this.name = n;
	}
	public boolean isAsleep(int hr){
		return 22<hr || 7>hr;
	}
	
	public String toString() {
		return this.name;
	}
	public void status (int hr)
	{
		if (this.isAsleep(hr))
			System.out.println("Noe offline: "+ this);
		else
			System.out.println("Now online: "+ this);
		
	}
}
