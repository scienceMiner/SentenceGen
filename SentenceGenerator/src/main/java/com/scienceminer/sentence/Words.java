package com.scienceminer.sentence;

import java.util.List;
import java.util.Random;

import com.scienceminer.sentence.PhraseStructure.STYPES;

public class Words {
 
	
	protected enum Genre {
		HOME,
		WORK,
		ALL;
	}
	
	protected enum SUBJECTOBJECT {
		SUBJECT,
		OBJECT;
	}
	
	protected class Word {
		private String _word;
		STYPES _sType;
		Genre _genre;
		SUBJECTOBJECT _subobj = null;
		
		Word(String w, STYPES s)
		{
			setWord(w);
			_sType = s;
		}
		
		Word(String w, STYPES s, SUBJECTOBJECT so)
		{
			setWord(w);
			_sType = s;
			_subobj = so;
		}

		public String getWord() {
			return _word;
		}

		public void setWord(String _word) {
			this._word = _word;
		}
				
	}
	
	public String match(STYPES s)
	{
		List<String> options = wordMap.get(s);
		Random rnd = new Random();
		return options.get(rnd.nextInt(options.size()));
	}
	
	private static final WordMap wordMap = new WordMap();
	
	static {
		
		wordMap.put(STYPES.D,Genre.HOME, "Our", SUBJECTOBJECT.SUBJECT);
		wordMap.put(STYPES.D, "The");
		wordMap.put(STYPES.D, "A");
		wordMap.put(STYPES.A, "happy");
		wordMap.put(STYPES.A, "strange");
		wordMap.put(STYPES.A, "stinky");
		wordMap.put(STYPES.A, "loud");
		wordMap.put(STYPES.A, "eccentric");
		wordMap.put(STYPES.A, "blocked");
		wordMap.put(STYPES.V, "find");
		wordMap.put(STYPES.V, "run");
		wordMap.put(STYPES.V, "examine");
		wordMap.put(STYPES.V, "tests");
		wordMap.put(STYPES.V, "fills");
		wordMap.put(STYPES.V, "walk");
		wordMap.put(STYPES.V, "sleep");
		wordMap.put(STYPES.N, "woman");
		wordMap.put(STYPES.N, "alien");
		wordMap.put(STYPES.N, "pensioner");
		wordMap.put(STYPES.N , "man");
		wordMap.put(STYPES.N , "squirrels");
		wordMap.put(STYPES.N, "person");
		wordMap.put(STYPES.T, "will");
		wordMap.put(STYPES.T, "won't");
		
		
	}
	
	public static void main(String[] args)
	{
		for (;; ) {
			PhraseStructure ps = new PhraseStructure();
			Words words = new Words();
			List<STYPES> test = ps.generate(STYPES.S);
			for (STYPES item : test) { System.out.print(item); }
			System.out.println();
			for (STYPES item : test) { System.out.print(words.match(item) + " "); }
			System.out.println("\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	}

}