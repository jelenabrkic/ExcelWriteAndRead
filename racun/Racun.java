package racun;

public class Racun {

	private String brRacuna;
	private double stanje;
	
	
	public String getBrRacuna() {
		return this.brRacuna;
	}
	
	public double getStanje() {
		return this.stanje;
	}
	
	public Racun(String brRacuna, double stanje) {
		this.brRacuna = brRacuna;
		this.stanje = 0;
	}
	
	public double dodavanjeNovca(double uplata)
	{
		stanje = stanje + uplata;
		return uplata;
		
	}
	
	public double uzimanjeNovca(double novacZaIsplatu)
	{
		stanje = stanje - novacZaIsplatu;
		return novacZaIsplatu;
	}
	
	

}
