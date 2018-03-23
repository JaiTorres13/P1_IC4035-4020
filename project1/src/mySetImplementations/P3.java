package mySetImplementations;
import java.util.ArrayList;
import java.util.Comparator;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

/**
 * 
 * @author JaiTorres13
 * 	Jainel Marie Torres Santos (843-14-8932) (Sec. 030)
 *@author CesarJustiniano 
 *	Cesar Andres Justiniano Santiago (840-15-3720)(Sec. 030)
 *
 */
public class P3<E> extends AbstractIntersectionFinder<E> {


	public P3(String name) {
		super(name);
	}

	/**
	 * @param t
	 * returns a new set, comparing the contents of t in an arraylist
	 * with the input file.
	 */
	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {


		ArrayList<Integer> allElements = new ArrayList<Integer>();

		for(int i=0; i<t.length;i++){
			for(Object o: t[i]) {
				allElements.add((Integer) o);
			}
		}

		allElements.sort(null);
		MySet<E> solT = new Set2<>();
		E e = (E) allElements.get(0);
		Integer c = 1;
		Integer m = t.length;
		for (int i=1; i<allElements.size(); i++) {
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
			solT.add( (E) allElements.get(allElements.size() - 1));
		return solT;
	}

}
