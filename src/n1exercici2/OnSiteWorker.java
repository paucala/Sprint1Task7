package n1exercici2;

public class OnSiteWorker extends Worker {
	private static int gas;

	public OnSiteWorker(String name, String surname, int salaryPerHour, int gas) {
		super(name, surname, salaryPerHour);
		OnSiteWorker.gas = gas;
	}

	public static int getGas() {
		return gas;
	}

	public static void setGas(int gas) {
		OnSiteWorker.gas = gas;
	}

	@Override
	public int calculateSalary(int hoursPerMonth) {
		int salary = super.calculateSalary(hoursPerMonth) + OnSiteWorker.gas;
		return salary;
	}

	
	
	
	
}
