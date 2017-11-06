package zad2;

import java.util.LinkedList;

public class Kadry {
	private LinkedList<Pracownik> kadry = new LinkedList<Pracownik>();
	
	public void add(String pesel_, double br) {
		int year = Character.getNumericValue(pesel_.charAt(0))*10 +
				Character.getNumericValue(pesel_.charAt(1));
		if(year<92 && year>17) {
			Pracownik etat = new PracownikEtatowy(pesel_, br);
			kadry.add(etat);
		}
		else {
			Pracownik student = new Student(pesel_, br);
			kadry.add(student);
		}
	}
	
	public void remove(String pesel_) {
		for (int i=0; i<kadry.size(); i++) {
			if(kadry.get(i).getPesel().equals(pesel_)) {
				kadry.remove(i);
			}
		}
	}
	
	public void find(String pesel_) {
		for (int i=0; i<kadry.size(); i++) {
			if(kadry.get(i).getPesel().equals(pesel_)) {
				System.out.println("Found at index: " + i);
				System.out.println("Pesel: " + pesel_ + " Brutto: " + kadry.get(i).getBrutto());
			}
		}
	}
	
	public void changeBrutto(String pes, double brutto_) {
		for(Pracownik p : kadry) {
			if(p.getPesel().equals(pes)) {
				p.setBrutto(brutto_);
				break;
			}
		}
	}
	
	public double getBrutto(String pes) {
		double br = 0;
		for(Pracownik p : kadry) {
			if(p.getPesel().equals(pes)) {
				br = p.getBrutto();
			}
		}
		return br;
	}
	
	public double getNetto(String pes) {
		double ntt = 0;
		for(Pracownik p : kadry) {
			if(p.getPesel().equals(pes)) {
				ntt = p.Netto();
			}
		}
		return ntt;
	}
	
	public void sortList() { //sortuje wedlug brutto rosnaco
		kadry.sort(new SortBrutto());
	}
	
	public void printOut(){
        for (Pracownik p : kadry){
            System.out.println(p.getPesel());
            System.out.println(p.getBrutto());
        }
    }
	
	public static void main(String[] argv) {
		Kadry list = new Kadry();
		list.add("97070605523", 3000);
		list.add("64020611710", 2000);
		list.find("97070605523");
		System.out.println("Netto: " + list.getNetto("64020611710") + " Brutto: " +
		list.getBrutto("64020611710"));
		list.changeBrutto("64020611710", 2300);
		System.out.println("Brutto after change: " + list.getBrutto("64020611710"));
		list.sortList();
		list.printOut();
		list.remove("97070605523");
	}
}
