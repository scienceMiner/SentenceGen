package com.scienceminer.sentence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scienceminer.sentence.PhraseStructure.STYPES;
import com.scienceminer.sentence.Words.Genre;
import com.scienceminer.sentence.Words.SUBJECTOBJECT;

public class WordMap {

	
	private class MultiKey {
		private STYPES _stype;
		private Genre _genre;
		private MultiKey(STYPES s, Genre g)
		{
			_stype = s;
			_genre = g;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this) return true;
			if (!(o instanceof MultiKey)) {
				return false;
			}
			
			MultiKey user = (MultiKey) o;
			
			return user._stype.equals(_stype) && user._genre == _genre;
		}
		
		@Override
		public int hashCode() {
			int result = 2039;
			result = 31 * result + _stype.hashCode();
			result = 31 * result + _genre.hashCode();
			
			return result;
		}
	}
	
	
	Map<MultiKey,List<String>> _wordMap = new HashMap<MultiKey,List<String>>();
	
	
	WordMap()
	{
		_wordMap = new HashMap<MultiKey, List<String>>();
	}
	
	
	boolean put(STYPES s, String word)
	{
		return put(s,Genre.ALL,word,null);
	}
	
	boolean put(STYPES s, String word, SUBJECTOBJECT so)
	{
		return put(s,Genre.ALL,word,so);
	}
	
	boolean put(STYPES s, Genre g, String word, SUBJECTOBJECT so)
	{
		MultiKey mKey = new MultiKey(s,g);
		if (_wordMap.get(mKey) != null)
		{
			List<String> wordList = _wordMap.get(mKey);
			return wordList.add(word);
		}
		else
		{
			List<String> wordList = new ArrayList<String>();
			wordList.add(word);
			_wordMap.put(mKey,  wordList);
			return true;
		}
	}
	
	List<String> get(STYPES s)
	{
		List<String> allGenreList = new ArrayList<String>();
		
		for (Genre g : Genre.values())
		{
			MultiKey mk = new MultiKey(s,g);
			if (_wordMap.containsKey(mk))
			{
				allGenreList.addAll(_wordMap.get(mk));
			}
		}
		
		return allGenreList;
	}
	
	
	List<String> get(STYPES s, Genre g)
	{
		MultiKey mk = new MultiKey(s,g);
		return _wordMap.get(mk);
	}
	
	
	
}
