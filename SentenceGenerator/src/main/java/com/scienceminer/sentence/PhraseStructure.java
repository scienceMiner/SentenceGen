package com.scienceminer.sentence;

import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
import java.util.Random; 

 
public class PhraseStructure { 

private static Random rnd = new Random(); 
  
public enum STYPES { 
	
	S(false), N(true), NP(false), VP(false), PP(false), V(true),T(true), D(true), A(true);

	private boolean _terminal; 
	STYPES(boolean terminus) 
	{
		setTerminal(terminus) ; 
	}

	private void setTerminal(boolean terminus) { 
		_terminal = terminus; 
	}

	public boolean isTerminal() { 
		return _terminal; 
	}

}

		private class RHS { 
			List<STYPES> entries;
			
			public RHS(STYPES...arg) // could have boolean terminus, STYPES... arg 
			{
				entries = new ArrayList<STYPES>();
				for (STYPES s : arg)
					entries.add(s);
			}
		}


		private static final Map<STYPES, List<RHS>> grammar = new HashMap<STYPES, List<RHS>>();

		static { 

			PhraseStructure ps = new PhraseStructure(); 
	
			List<RHS> sTargetList = new ArrayList<RHS>(); 
			RHS target1 = ps.new RHS(STYPES.NP,STYPES.VP);
			sTargetList.add(target1);
			RHS target2 = ps.new RHS(STYPES.NP,STYPES.T,STYPES.VP);
			sTargetList.add(target2);
			grammar.put(STYPES.S, sTargetList) ; 
		
			List<RHS> vpTargetList = new ArrayList<RHS>(); 
			RHS target3 = ps.new RHS(STYPES.V,STYPES.NP);
			vpTargetList.add(target3);
			grammar.put(STYPES.VP, vpTargetList) ; 
			
			List<RHS> npTargetList = new ArrayList<RHS>();
			RHS target5 = ps.new RHS(STYPES.D,STYPES.N);
			npTargetList.add(target5) ; 
			RHS target6 = ps.new RHS(STYPES.N); 
			npTargetList.add (target6); 
			RHS target7 = ps.new RHS(STYPES.D,STYPES.A, STYPES.N); 
			npTargetList.add (target7); 
			grammar.put(STYPES.NP, npTargetList);
			
		}
		
		
		public List<STYPES> generate( STYPES initSType ) 
		{
			if (!initSType. isTerminal()) 
			{
				List<STYPES> finalList = new ArrayList<STYPES>();
				List<RHS> sTargets = grammar.get(initSType); 
				RHS chosen = sTargets.get(rnd.nextInt(sTargets.size()));
				for (STYPES chosenType : chosen. entries) 
				{
					List<STYPES> result = generate(chosenType);
					finalList.addAll(result);
				}

				return finalList;
			}
			else
			{
				List<STYPES> finalList = new ArrayList<STYPES>();
				finalList.add(initSType);
				return finalList;
			}

		}
			
		
		public static void main(String[] args) 
		{
			PhraseStructure ps = new PhraseStructure(); 
			
			List<STYPES> test = ps.generate(STYPES.S);
			
			for (STYPES item : test) { System.out. print(item); }
		}
			
		
}



