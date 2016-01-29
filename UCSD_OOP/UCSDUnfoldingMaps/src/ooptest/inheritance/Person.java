package ooptest.inheritance;

public class Person {

	private String name;
	public Person(String n) {
		this.name = n;
		System.out.print("#1 ");	
	}
	public String getName(){
		return this.name;
	}
	public void setName(String n){
		this.name = n;
	}
}
