package ngordnet;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.introcs.In;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
public class WordNet {
	private ArrayList<WordNode> wnarray;
	private Digraph wngraph;
	
	public WordNet(String Synsetsloc, String Hyponymloc){
		int tmpID;
		String tmpsynset,defi;
		String[] tmpString,hypos;
		In input = new In(Synsetsloc);
		wnarray = new ArrayList<WordNode>();
		while (input.hasNextLine()){
			tmpString = input.readLine().split(",");
			tmpID = 	Integer.parseInt(tmpString[0]);
			tmpsynset = tmpString[1];
			defi = tmpString[2];
			wnarray.add(new WordNode(tmpID,tmpsynset,defi));
		}
		wngraph = new Digraph(wnarray.size());
		input = new In(Hyponymloc);
		while (input.hasNextLine()){
			tmpString = input.readLine().split(",");
			hypos = new String[tmpString.length-1];
			tmpID = 	Integer.parseInt(tmpString[0]);
			System.arraycopy(tmpString, 1, hypos, 0, hypos.length);
			for (String s : hypos){
				wngraph.addEdge(tmpID, Integer.parseInt(s));
			}
		}
		
	}
	public boolean isNoun(String word){
		for (WordNode w : wnarray){
			if (w.has_item(word)) return true;
		}
		return false;
	}
	
	public String[] nouns(){
		ArrayList<String> result = new ArrayList<String>();
		for (WordNode w :wnarray){
			for (String s : w.getitem()){
				result.add(s);
			}
		}
		return result.toArray(new String[result.size()]);
	}
	
	public String[] hyponyms(String hypernym){
		int hyperID;
		Set<Integer> Hyper = new TreeSet<Integer>();
		Set<Integer> hypos;
		ArrayList<String> result = new ArrayList<String>();
		for (WordNode w : wnarray){
			if (w.has_item(hypernym)){
				hyperID = w.getID();
				Hyper.add(hyperID);
			}
		}
		hypos = GraphHelper.descendants(wngraph, Hyper);
		for (int i :hypos){
			for (String s : wnarray.get(i).getitem()){
				if (!result.contains(s))
				result.add(s);
			}
		}
		return result.toArray(new String[result.size()]);
	}


}
