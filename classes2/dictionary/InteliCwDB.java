package dictionary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import dictionary.Entry;
import java.util.Random;
import java.util.regex.*;


public class InteliCwDB extends CwDB {
	public InteliCwDB() {
		super();
	}
	
	public LinkedList<Entry> findAll(String pattern){
		LinkedList<Entry> list = new LinkedList<Entry>();
		Pattern compiledPattern = Pattern.compile(pattern);
		for (int i = 0; i < dict.size(); i++) {
			Matcher matcher = compiledPattern.matcher(dict.get(i).getWord());
			if(matcher.matches()) {
				list.add(dict.get(i));
			}
		}
		return list;
	}
	public Entry getRandom() {
		Random rand = new Random();
		int a = rand.nextInt(11);
		return dict.get(a);
	}
	
	public Entry getRandom(int length) {
		Random rand = new Random();
		Entry ent = new Entry("not", "found");
		int a = rand.nextInt(11);
		int wordSize = dict.get(a).getWord().length();
		while(wordSize != length) {
			wordSize = dict.get(a).getWord().length();
			if(wordSize == length) {
				ent = dict.get(a);
			}
			else a = rand.nextInt(11);
		}
		return ent;
	}
	
	public Entry getRandom(String pattern) {
		Random rand = new Random();
		Pattern compiledPattern = Pattern.compile(pattern);
		
		Entry ent = new Entry("not", "found");
		int a = rand.nextInt(11); //change 11  
		String word = dict.get(a).getWord();
		Matcher matcher = compiledPattern.matcher(dict.get(a).getWord());
		while(matcher.matches() != true) {
			matcher = compiledPattern.matcher(dict.get(a).getWord());
			word = dict.get(a).getWord();
			if(matcher.matches()) {
				ent = dict.get(a);
			}
			else a = rand.nextInt(11);
		}
		return ent;
	}
	
	/*public void add(String word, String clue) {
		Entry ent = new Entry(word, clue);
		dict.add(ent);
		int i = 0;
		while(dict.get(i).getWord().compareTo(word) <= 0) {
			if(dict.get(i).getWord().compareTo(word) <= 0) {
				i++; 
			}
				else dict.add(i, dict.getLast());
			}
		}
		//dodaje w porzadku alfabetycznym*/
	
	public static void main(String [] args) throws IOException{
		InteliCwDB cwdb = new InteliCwDB();
		cwdb.createDB("C:/Users/asus1/Desktop/studia/s3/java-classes/classes2/dictionary/cwdb.txt");
		//cwdb.add("Anitka", "przemi³a dziewczyna");
		System.out.println(cwdb.get("bafomet").getClue());
		cwdb.saveDB("C:/Users/asus1/Desktop/studia/s3/java-classes/classes2/dictionary/cwdb.txt");
		System.out.println(cwdb.getSize());
		Entry entRandom = cwdb.getRandom();
		System.out.println("Random entry: " + entRandom.getWord() + " " + entRandom.getClue());
	}
}
