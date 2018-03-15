package mySetImplementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P4<E> extends AbstractIntersectionFinder<E> {
	
	public P4(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
public static void main (String [] args) {
	
	ArrayList<Integer> allElements = null;
	HashMap<Integer, Integer> map = new HashMap<>(); 
	Integer m = null;
	for (Integer e : allElements) { 
	     Integer c = map.getOrDefault(e, 0); 
	     map.put(e, c+1); 
	}
	MySet<Integer> t = new Set2<>(); 

	for (Map.Entry<Integer, Integer> entry : map.entrySet())
	     if (entry.getValue() == m) 
	        t.add(entry.getKey()); 
}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		// TODO Auto-generated method stub
		return null;
	}

}
