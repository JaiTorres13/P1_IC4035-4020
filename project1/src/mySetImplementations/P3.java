package mySetImplementations;

import java.util.ArrayList;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P3<E> extends AbstractIntersectionFinder<E> {


	
	public P3(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) {
		
		ArrayList<Integer> allElements = null;
//		allElements.sort(null);
		MySet<Integer> t = new Set2<>();
		Integer e = allElements.get(0);
		Integer c = 1;
		Integer m = null;
		for (int i=1; i<=allElements.size(); i++) {
		      if (i < allElements.size() && allElements.get(i).equals(e)) 
		          c++;
		      else { 
				if (c == m) 
		             t.add(e);    // m is as in the previous discussion
		          e = allElements.get(i); 
		          c = 1; 
		      } 
		}
		
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		// TODO Auto-generated method stub
		return null;
	}

}
