package dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class CwDB {
	protected LinkedList<Entry> dict;
	private String filename;
	
	public CwDB(String filename_) {
		filename = filename_;
	}
	
	public void add(String word_, String clue_) {
		Entry ent = new Entry(word_,clue_);
		dict.add(ent);
	}
	
	public Entry get(String word_){
		int i = 0;
		Entry ent = new Entry("not", "found");
		while (dict.get(i).getWord() != word_ || i == dict.size()) {
			if(dict.get(i).getWord()== word_) {
				ent = dict.get(i);
			}
			else i++;
			}
		return ent;
		}
	
	
	public void remove(String word_) {
		for (int i = 0; i < dict.size(); i++) {
			if(dict.get(i).getWord() == word_) {
				dict.remove(i);
			}
		}
	}
	
	public void saveDB(String filename) {
		
	}
	
	public int getSize() {
		return dict.size();
	}
	
	protected void createDB(String filename) throws FileNotFoundException {
		FileInputStream in = new FileInputStream(filename);
		
	}
}
