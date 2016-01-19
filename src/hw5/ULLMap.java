import java.util.*; /* java.util.Set needed only for challenge problem. */

/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key. 
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */ 
public class ULLMap<K,V> implements Map61B<K, V>,Iterable<K>{ 
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the first pair in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list. 
      */
    private Entry front;
    private int size;

    public ULLMap(){
    	front = new Entry(null,null,null);
    	size =0;
    }
    public Iterator<K> iterator(){
    	return new ULLMapIter(this);
    }
    
    public class ULLMapIter implements Iterator<K>{
    	public Entry p;
    	public ULLMapIter(ULLMap<K,V> u){
    		p = front.next;
    	}
    	
    	public K next(){
    		if (hasNext()){
    			K key = p.key;
    			p = p.next;
    			return key;
    		}
    		throw new NoSuchElementException();
    	}
    	public boolean hasNext(){
    		return (p!=null);
    	}
    public void remove() {
        throw new UnsupportedOperationException();
    }
    }
    

    @Override
    public V get(K key) { 
    Entry p = front.next.get(key);
    if (p!=null && p.val!=null){
    	return p.val;
    }
        return null; 
    }

    @Override
    public void put(K key, V val) { 
    Entry p = front;
    while(p.next!=null){
    	if (p.next.key.equals(key)){
    		p.next.val = val;
    		return;
    	}
    	p = p.next;
    }
    p.next = new Entry(key,val,null);
    size++;
    }

    @Override
    public boolean containsKey(K key) {    
        return front.next.get(key)!=null; 
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
    	size = 0;
    	front.next = null;
    }


    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry {
    
        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k,V v, Entry n) { 
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K k) { 
            Entry p = this;
            while(p!=null){
            	if(p.key.equals(k)){
            		return p;
            	}
            	p = p.next;
            }
            return null; 
        }

        /** Stores the key of the key-value pair of this node in the list. */
        private K key; 
        /** Stores the value of the key-value pair of this node in the list. */
        private V val; 
        /** Stores the next Entry in the linked list. */
        private Entry next;
    
    }

    /* Methods below are all challenge problems. Will not be graded in any way. 
     * Autograder will not test these. */
    @Override
    public V remove(K key) { 
        Entry p = front.next.get(key);
        if (p!=null){
        	V v = p.val;
        	p.val = null;
        	return v;
        }
        return null;
    }

    @Override
    public V remove(K key, V value) { 
        Entry p = front.next;
        V r = null;
        while(p.next!=null){
        	if(p.next.key==key&&p.next.val==value){
        		r = p.next.val;
        		p.next = p.next.next;
        	}else{
        	p = p.next;
        	}
        }
        size--;
        return r;
    }

    @Override
    public Set<K> keySet() { 
    	Set<K> set=new HashSet<K>();
    	Entry p = front.next;
    	while(p!=null){
    		set.add(p.key);
    	}
    	return set;
    }
    
    public static <K,V> ULLMap<V,K> invert(ULLMap<K,V> umap){
    	ULLMap<V,K> newmap = new ULLMap<V,K>();
    	for (K i : umap){
    		newmap.put(umap.get(i), i);
    	}
    	return newmap;
    }


}