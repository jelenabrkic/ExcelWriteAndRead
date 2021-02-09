package automobil;

public class Automobil {

	private String marka;
	private String model;
	private int serijskiBroj;
	private String vlasnikAutomobila;
	
	public Automobil(String marka, String model, int serijskiBroj, String vlasnikAutomobila)
	{
		this.marka = marka;
		this.model = model;
		this.serijskiBroj = serijskiBroj;
		this.vlasnikAutomobila = vlasnikAutomobila;
	}
	
	public String getMarka() 
	{
		return this.marka;
	}
	
	public String getModel() 
	{
		return this.model;
	}
	
	public int getSerijskiBroj()
	{
		return this.serijskiBroj;
	}
	
	public void setVlasnikAutomobila(String vlasnikAutomobila)
	{
		this.vlasnikAutomobila = vlasnikAutomobila;
	}
	
	public String getVlasnikAutomobila()
	{
		return this.vlasnikAutomobila;
	}
	

	
}
