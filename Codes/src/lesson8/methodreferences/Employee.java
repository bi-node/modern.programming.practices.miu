package lesson8.methodreferences;

public class Employee {
	String name;
	int salary;
	
	public Employee(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}

