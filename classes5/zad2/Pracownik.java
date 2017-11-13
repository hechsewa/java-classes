package zad2;

import pesel.PESEL;

public abstract class Pracownik{
	private String pesel;
	private double brutto = 0;

	public Pracownik(String pesel_, double brutto_){
		if(PESEL.check(pesel_)){
			pesel = pesel_;
		}
		else System.out.println("Wrong pesel");
		brutto = brutto_;
	}

	public void setBrutto(double brutto_) {
		brutto = brutto_;
	}
	
	public double getBrutto() {
		return brutto;
	}
	
	public String getPesel() {
		return pesel;
	}
	
	public abstract double Netto();
	
}

