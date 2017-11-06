package zad2;

import java.util.Comparator;

public class SortBrutto implements Comparator<Pracownik> {
	
	public int compare(Pracownik p1, Pracownik p2) {
		if(p1.getBrutto() > p2.getBrutto()) {
			return 1;
		}
		else if(p1.getBrutto() == p2.getBrutto()) {
			return 0;
		}
		else return -1;
	}
	
	
}
