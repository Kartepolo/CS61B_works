package ngordnet;
import java.util.TreeMap;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
public class TimeSeries<V extends Number> extends TreeMap<Integer,V>{
	
	public TimeSeries() {
		super();
	}
	public Collection<Number> years(){
		Set<Integer> s = this.keySet();
		HashSet<Number> result = new HashSet<Number>();
		for (Integer i : s){
			result.add(i);
		}
		return result;
	}
	public Collection<Number> data(){
		Collection<V> v = this.values();
		HashSet<Number> result = new HashSet<Number>();
		for (V i : v){
			result.add(i);
		}
		return result;
	}
	public <X extends Number> TimeSeries<X> plus(TimeSeries<?> t2){
		Set<Integer> s1 = this.keySet();
		Set<Integer> s2 = t2.keySet();
		TimeSeries<X> result = new TimeSeries<X>();
		for (Integer i : s2 ){
			if (s1.contains(i)) {
				Number v = this.get(i).floatValue() + t2.get(i).floatValue();
				result.put(i, (X)v);
			}else{
				result.put(i, (X)t2.get(i));
			}
		}
		return result;
	}
	public <X extends Number> TimeSeries<X> dividedBy(TimeSeries<?> x) {
		Set<Integer> s1 = this.keySet();
		Set<Integer> s2 = x.keySet();
		TimeSeries<X> result = new TimeSeries<X>();
		for (Integer i : s2 ){
			if (s1.contains(i)) {
				Number v = this.get(i).floatValue() / x.get(i).floatValue();
				result.put(i, (X)v);
		}
		}
		return result;
	}
	
}
