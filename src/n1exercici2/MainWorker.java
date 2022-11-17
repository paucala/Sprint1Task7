package n1exercici2;

public class MainWorker {

	public static void main(String[] args) {
		OnlineWorker w1 = new OnlineWorker("Pere", "Garcia", 10);
		OnSiteWorker w2 = new OnSiteWorker("Laura", "Ortin", 12, 15);
		
		System.out.println(w1.toString(120));
		System.out.println(w2.toString(140));
		
		useSaludar(w1);

	}
	@SuppressWarnings("deprecation")
	public static void useSaludar(Worker w) {
		w.saludar();
	}

}
