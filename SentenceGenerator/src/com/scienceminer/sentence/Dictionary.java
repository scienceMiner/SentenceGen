package com.scienceminer.sentence;

import java.util.ArrayList;
import java.util.Collection;

public class Dictionary {

	
	public static Collection< Entry > nouns = new ArrayList< Entry >();
	
	{
		nouns.add( new Entry("Ethan", GrammarEnum.N ));
		nouns.add( new Entry("Deborah", GrammarEnum.N ));
		nouns.add( new Entry("A football team", GrammarEnum.N ));
		nouns.add( new Entry("The Monkees", GrammarEnum.N ));
	}
	
	

	public static Collection< Entry > determiner = new ArrayList< Entry >();
	
	{
		
		determiner.add( new Entry("The", GrammarEnum.D));
		determiner.add( new Entry("A", GrammarEnum.D ));
		
	}
	

	public static Collection< Entry > verb = new ArrayList< Entry >();
	
	{
		verb.add( new Entry("run", GrammarEnum.V,"runs" ) );
		verb.add( new Entry("read", GrammarEnum.V, "reads" ) );
		
	}
	
	
}
