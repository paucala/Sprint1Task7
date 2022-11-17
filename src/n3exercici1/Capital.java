package n3exercici1;

@SerializeJson (path = "capitals.json")
public class Capital {
		
	@JsonElement (key = "Country")
	private String country;
	
	@JsonElement
	private String capital;
		
	public Capital (String country, String capital) {
		this.country = country;
		this.capital = capital;
	}
	
	public String getCountry() {
		return country;
	}
	public String getCapital() {
		return capital;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	

}
