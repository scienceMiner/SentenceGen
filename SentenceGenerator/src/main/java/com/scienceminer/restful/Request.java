package com.scienceminer.restful;

import java.util.List;

import com.scienceminer.sentence.PhraseStructure;
import com.scienceminer.sentence.Words;
import com.scienceminer.sentence.PhraseStructure.STYPES;

public class Request {

	private final long id;
	private final String content;
	PhraseStructure ps = new PhraseStructure();
	Words words = new Words();
	
	public Request(long id, String content) {
		this.id = id;
		StringBuffer buffStr = new StringBuffer();
		
		List<STYPES> test = ps.generate(STYPES.S);
		
		for (STYPES item : test) {buffStr.append(words.match(item) + " "); }

		this.content = buffStr.toString();
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}