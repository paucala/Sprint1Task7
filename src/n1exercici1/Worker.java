package n1exercici1;

public class Worker {
	private String name;
	private String surname;
	private int salaryPerHour;
	
	public Worker(String name, String surname, int salaryPerHour) {
		this.name = name;
		this.surname = surname;
		this.salaryPerHour = salaryPerHour;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getSalaryPerHour() {
		return salaryPerHour;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setSalaryPerHour(int salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}
	public int calculateSalary(int hours) {
		int salary = hours * this.salaryPerHour;
		return salary;
	}

	public String toString(int hours) {
		return "Name: " + getName() + ", Surname: " + getSurname() + ", Salary: " + calculateSalary(hours);
	}
	

}
