package com.scienceminer.sentence;

public class Entry {

	
	private String _word;
	private GrammarEnum _type;
	private String _pluralWord;
	
	public enum Number {
		Singular,
		Plural;
	}
	
	Entry(String w, GrammarEnum t)
	{
		new Entry(w,t,w);
	}
	
	Entry(String w, GrammarEnum t, String pWord )
	{
		_word = w;
		_type = t;
		setPluralWord(pWord);
	}
	
	public String getWord() {
		return _word;
	}
	public void setWord(String word) {
		this._word = word;
	}
	
	public GrammarEnum getType() {
		return _type;
	}
	public void setType(GrammarEnum type) {
		this._type = type;
	}

	public String getPluralWord() {
		return _pluralWord;
	}

	public void setPluralWord(String _pluralWord) {
		this._pluralWord = _pluralWord;
	}
	
	
}
