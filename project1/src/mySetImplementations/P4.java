package mySetImplementations;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
public class P4<E> extends AbstractIntersectionFinder<E> {

	public P4(String name) {
		super(name);
	}

	/**
	 * @param t
	 * returns a new set, comparing the value of the hashmaps of the files.
	 */
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
