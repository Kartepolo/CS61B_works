// not very efficient; better use two hashmaps
package ngordnet;
import java.util.*;
public class YearlyRecord {
	private HashMap<String,Number> data;
	private ArrayList<Number> ranking;
	private int size;
	private HashMap<Number,Integer> quick;
	public YearlyRecord() {
		data = new HashMap<String,Number>();
		ranking = new ArrayList<Number>();
		size = 0;
		quick = new HashMap<Number,Integer>();
	}
	public YearlyRecord(HashMap<String, ? extends Number> h){
		data = new HashMap<String,Number>(h);
		ranking = new ArrayList<Number>(h.values());
		quick = new HashMap<Number,Integer>();
		size = h.size();
	}
	public void put(String word, Number val) {
		data.put(word, val);
		size ++;	
		ranking.add(val);
	}
	public Number count(String word) {
		return data.get(word);
	}
	public int size() {
		return size;
	}
	public class item implements Comparator<Map.Entry<String, Number>> {
		public int compare(Map.Entry<String, Number> m1, Map.Entry<String, Number> m2) {
			return (int) (m1.getValue().doubleValue() - m2.getValue().doubleValue());
		}
	}
	private ArrayList<Map.Entry<String, Number>> getlist() {
		ArrayList<Map.Entry<String, Number>> result = new ArrayList<Map.Entry<String, Number>>(data.entrySet());
		Collections.sort(result, new item());
		return result;
	}
	public Collection<Number> counts() {
		Collections.sort(ranking,new Comparator<Number>() {
			public int compare(Number n1, Number n2) {
				return (int) (n2.doubleValue() - n1.doubleValue());
			}
		});
		ArrayList<Number> r = new ArrayList<Number>(ranking);
		Collections.reverse(r);
		return r;
	}
	public Collection<String> words() {
		List<Map.Entry<String, Number>> mappingList = getlist();
		ArrayList<String> result = new ArrayList<String>();
		for (Map.Entry<String, Number> m : mappingList) {
			result.add(m.getKey());
		}
		return result;
	}
	public int rank(String word) {
		Number c = data.get(word);
		if (!quick.containsKey(c)) {
			Collections.sort(ranking,new Comparator<Number>() {
				public int compare(Number n1, Number n2) {
					return (int) (n2.doubleValue() - n1.doubleValue());
				}
			});
			int count = 1;
			quick = new HashMap<Number,Integer>();
			for (Number n : ranking) {
				quick.put(n, count);
				count++;
			}
		}
		return quick.get(c);
	}
}
