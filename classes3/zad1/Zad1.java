package zad1;

import java.util.LinkedList;

public class Zad1 {

	/*public void finalVar(final double var){ //wartosc przekazywana jako parametr funkcji nie może być edytowana wewnątrz tej funkcji
		var = 2;
	}*/
	
	public static void finalList(final LinkedList<Double> list){
//list jest obiektem klasy LinkedList z pakietu util więc ma stałą referencję do obiektu list ale tutaj nie przypisujemy referencji do obiektu a jedynie wywołujemy metody
		double a = 2.0;
		double b = 3.2;
		list.add(a);
		list.add(b);
		list.remove(a);
		/* LinkedList<Double> lista2 = new LinkedList<Double>();
		list = lista2; */
	}
	
	public static void main(String[] args){
		LinkedList<Double> list = new LinkedList<Double>();
		finalList(list);
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
