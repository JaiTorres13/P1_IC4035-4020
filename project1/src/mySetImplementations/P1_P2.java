package mySetImplementations;

import interfaces.MySet;
import setIntersectionFinders.AbstractIntersectionFinder;

public class P1_P2<E> extends AbstractIntersectionFinder<E>{

	MySet<Integer> t = new Set2<>();
	MySet<Integer> c = new Set1<>();
	
	
	public P1_P2(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
