package mySetImplementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P4<E> extends AbstractIntersectionFinder<E> {
	
	public P4(String name) {
		super(name);
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		
		ArrayList<Integer> allElements = new ArrayList<Integer>();
		
		for(int i=0; i<t.length;i++){
			for(Object o: t[i]) {
				allElements.add((Integer) o);
			}
		}
		
		HashMap<E, Integer> map = new HashMap<>(); 
		Integer m = t.length;
		for (Integer e : allElements) { 
		     Integer c = map.getOrDefault(e, 0); 
		     map.put((E) e, c+1); 
		}
		MySet<E> s = new Set2<>(); 

		for (Map.Entry<E, Integer> entry : map.entrySet())
		     if (entry.getValue() == m) 
		        s.add(entry.getKey());
		
		return s;
	}

}
