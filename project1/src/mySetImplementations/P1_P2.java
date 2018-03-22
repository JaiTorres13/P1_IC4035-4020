package mySetImplementations;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1_P2<E> extends AbstractIntersectionFinder<E>{

	public P1_P2(String name) {
		super(name);
		name = "P1_P2";

	}


	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {

		if (this.getName() == "1") {
			Set1<E> set1 = (Set1<E>) t[0];
			for(int i=1; i<t.length; i++) {
				for(E e: set1) {
					if(!t[i].contains(e)) {
						set1.remove(e);
					}
				}
			}
			return set1;
		}
		if(this.getName() == "2") {
			Set2<E> set2 = (Set2<E>) t[0];
			for(int j=1; j<t.length; j++) {
				for(E s: set2) {
					if(!t[j].contains(s)) {
						set2.remove(s);
					}
				}
			}
			return set2;
		}
		return null;
	}

}
