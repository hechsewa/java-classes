package dictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class CwDB {
	protected LinkedList<Entry> dict = new LinkedList<Entry>();
	private String filename;
	
	public CwDB() {
	}
	
	public void add(String word_, String clue_){
		Entry ent = new Entry(word_,clue_);
		dict.add(ent);
	}
	
	public Entry get(String word_){
		
		Entry ent = new Entry("not", "found");
		for(Entry i : dict) {
			if(i.getWord()== word_) {
				ent = i;
			}
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
	
	public void saveDB(String filename) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		for(Entry i : dict) {
			String word = i.getWord();
			String clue = i.getClue();
			out.println(word);
			out.println(clue);
		}
	out.close();	
	}
	
	public int getSize() {
		return dict.size();
	}
	
	protected void createDB(String filename) throws FileNotFoundException {
		//FileInputStream in = new FileInputStream(filename);
		Scanner s = new Scanner(new File(filename));
		while(s.hasNextLine()) {
			String word = s.nextLine();
			String clue = s.nextLine();
			add(word, clue);
		}
		
		s.close();
	}
}
