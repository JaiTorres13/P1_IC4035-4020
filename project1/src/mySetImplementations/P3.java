package mySetImplementations;

import java.util.ArrayList;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P3<E> extends AbstractIntersectionFinder<E> {


	public P3(String name) {
		super(name);
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
	
		ArrayList<Integer> allElements = new ArrayList<Integer>();
		
		for(Object o: t) {
			allElements.add((Integer) o);
		}
		
		allElements.sort(null);
		MySet<E> solT = new Set2<>();
		E e = (E) allElements.get(0);
		Integer c = 1;
		Integer m = t.hashCode();
		for (int i=1; i<=allElements.size(); i++) {
		      if (i < allElements.size() && allElements.get(i).equals(e)) 
		          c++;
		      else { 
				if (c == m) 
		             solT.add(e);    // m is as in the previous discussion
		          e = (E) allElements.get(i); 
		          c = 1; 
		      } 
		}
		if(c == m)
			solT.add((E) allElements.get(allElements.size() - 1));
		return solT;
	}

}
