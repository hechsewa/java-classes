package zad2;

public class Student extends Pracownik{
	public Student(String pesel_, double brutto_) {
		super(pesel_,brutto_);
	}
	public double Netto(){
		double netto = 0.8* getBrutto();
		return netto;
	}
}
