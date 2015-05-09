import java.util.Date;


public class Posten {
	String bezeichnung;
	Date   datum;
	double betrag;
	
	public Posten(Date datum, String bezeichnung, double betrag) {
		this.bezeichnung = bezeichnung;
		this.datum = datum;
		this.betrag = betrag;
	}
}
