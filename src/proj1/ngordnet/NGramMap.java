package ngordnet;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import java.util.Map;
public class NGramMap {
	private HashMap<Integer,YearlyRecord> yrs;
	private TimeSeries<Double> ts;
	public NGramMap(String words, String count) {
		String[] tmp;
		String s;
		int y;
		YearlyRecord yr;
		yrs = new HashMap<Integer,YearlyRecord>();
		ts = new TimeSeries<Double>();
		try {
		BufferedReader input1 = new BufferedReader(new FileReader(words));
		while ((s = input1.readLine())!=null) {
			tmp = s.split("\t");
			y = Integer.parseInt(tmp[1]);
			if (yrs.containsKey(y)) {
				yrs.get(y).put(tmp[0],Integer.parseInt(tmp[2]));
			}else {
				yr = new YearlyRecord();
				yr.put(tmp[0],Integer.parseInt(tmp[2]));
				yrs.put(y, yr);
			}
		}
		input1.close();
		tmp = null;
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
		BufferedReader input2 = new BufferedReader(new FileReader(count));
		while ((s = input2.readLine())!=null) {
			tmp = s.split(",");
			ts.put(Integer.parseInt(tmp[0]),Double.parseDouble(tmp[1]));
		}
		input2.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Number countInYear(String word, int year) {
		return yrs.get(year).count(word);
	}
	public YearlyRecord getRecord(int year) {
		return yrs.get(year);
	}
	public <x extends Number> TimeSeries<x> countHistory(String word) {
		Collection<Integer> years = yrs.keySet();
		TimeSeries<x> t = new TimeSeries<x>();
		for (Integer y : years) {
			Number n = yrs.get(y).count(word);
			if (n!=null) t.put(y, (x) n);
		}
		return t;
	}
	public <x extends Number> TimeSeries<x> countHistory(String word,int start, int end) {
		Collection<Integer> years = yrs.keySet();
		TimeSeries<x> t = new TimeSeries<x>();
		for (int y : years) {
			if (y >= start && y <= end) {
				Number n = yrs.get(y).count(word);
				if (n!=null) t.put(y, (x) n);
			}
		}
		return t;
	}
	public <x extends Number> TimeSeries<x> totalCountHistory() {
		Collection<Integer> years = ts.keySet();
		TimeSeries<x> t = new TimeSeries<x>();
		for (Integer y : years) {
			t.put(y, (x)ts.get(y));
		}
		return totalCountHistory(ts.firstKey(),ts.lastKey());
	}
	public <x extends Number> TimeSeries<x> totalCountHistory(int start, int end) {
		Collection<Integer> years = ts.keySet();
		TimeSeries<x> t = new TimeSeries<x>();
		for (int y : years) {
			if (y >= start && y <= end) {
				t.put(y, (x)ts.get(y));
			}
		}
		return t;
	}
	public TimeSeries<Double> weightHistory(String word) {
		return countHistory(word).dividedBy(totalCountHistory());
	}
	public TimeSeries<Double> weightHistory(String word,int start, int end) {
		return countHistory(word, start, end).dividedBy(totalCountHistory(start, end));
	}
	public TimeSeries<Double> summedWeightHistory(String[] words){
		return summedWeightHistory(words,ts.firstKey(),ts.lastKey());
	}
	public TimeSeries<Double> summedWeightHistory(String[] words, int start, int end){
		TimeSeries<Double> t = new TimeSeries<Double>();
		for (String w : words) {
			if (t.isEmpty()){
				t = weightHistory(w, start, end);
			}else{
			t = t.plus(weightHistory(w, start, end));
			}
		}
		return t;
	}
}
