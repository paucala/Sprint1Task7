package n1exercici2;

public class OnlineWorker extends Worker {
	private static final int INTERNET = 15;

	public OnlineWorker(String name, String surname, int salaryPerHour) {
		super(name, surname, salaryPerHour);
	}

	public static int getInternet() {
		return INTERNET;
	}

	@Override
	public int calculateSalary(int hoursPerMonth) {
		int salary = super.calculateSalary(hoursPerMonth) + INTERNET;
		return salary;
	}
	

	
	

}
