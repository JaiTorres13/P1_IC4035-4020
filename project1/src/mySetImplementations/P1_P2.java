package mySetImplementations;

import java.util.Iterator;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1_P2<E> extends AbstractIntersectionFinder<E>{

	public P1_P2(String name) {
		super(name);
	}


	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {

		if (this.getName() == "P1") {
			Set1<E> set1 = (Set1<E>) t[0];
			for(int i=1; i<t.length; i++) {
				for(int j=0;j<set1.size();j++) {
					Object [] e = set1.toArray();
					if(!t[i].contains((E) e[j])) {
						set1.remove((E) e[j]);
					}
				}
			}
			return set1;
		}
		if(this.getName() == "P2") {
			Set2<E> set2 = (Set2<E>)t[0];
			for(int i=1; i<t.length; i++) {
				Iterator<Integer> iterset = (Iterator<Integer>) set2.iterator();
			while(iterset.hasNext()) {
				if(!t[i].contains((E) iterset.next()))
					iterset.remove();
			}
			}
//			for(int i=1; i<t.length; i++) {
//				for(int j=0;j<set2.size();j++) {
//					Object [] e = set2.toArray();
//					if(!t[i].contains((E) e[j])) {
//						set2.remove((E) e[j]);
//					}
//				}
//			}
			return set2;
		}
		return null;
	}

}
