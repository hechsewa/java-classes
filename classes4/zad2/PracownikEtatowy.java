package zad2;

public class PracownikEtatowy extends Pracownik{
	public double etat = 0.75;
	
	public PracownikEtatowy(String pesel_,double brutto_) {
		super(pesel_, brutto_);
	}

	public double Netto(){
		double netto = etat * getBrutto();
		return netto;
	}
}
