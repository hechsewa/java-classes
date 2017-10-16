package dictionary;

import java.util.LinkedList;
import dictionary.Entry;
import java.util.Random;
import java.util.regex.*;


public class InteliCwDB extends CwDB {
	public InteliCwDB(String filename) {
		super(filename);
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
	
	public void add(String word, String clue) {}
}
