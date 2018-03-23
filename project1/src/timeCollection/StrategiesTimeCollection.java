package timeCollection;


import java.util.ArrayList;
import java.util.Map;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

import java.util.AbstractMap.SimpleEntry;

/**
 * 
 * @author JaiTorres13
 * 	Jainel Marie Torres Santos (843-14-8932) (Sec. 030)
 *@author CesarJustiniano 
 *	Cesar Andres Justiniano Santiago (840-15-3720)(Sec. 030)
 *
 */
public class StrategiesTimeCollection<E> 
extends ArrayList<Map.Entry<Integer, Float>> { 
	private IntersectionFinder<E>strategy;    // the strategy
	private float sum;   


	public StrategiesTimeCollection(IntersectionFinder<E>strategy) { 
		this.strategy = strategy; 
	} 

	public String getStrategyName() { 
		return strategy.getName(); 
	}

	/**
	 * 
	 * @param dataset
	 *  It changes a three dimension array to an array of sets of type MySet[] and runs 
	 *  the strategy, depending of the one that is chosen.
	 */
	public void runTrial(Integer[][][] dataset) { 

		MySet<Integer>[] data = new MySet[dataset[0].length];
		int m = dataset[0].length;
		int n = dataset.length;

		if(strategy.getName().equals("P1")){
			for(int j = 0; j < m; j++) {
				data[j] =  new Set1<>();
				for(int i = 0; i < n; i++) {
					for(int k = 0; k < dataset[i][j].length; k++)
						data[j].add( dataset[i][j][k]);
				}
			}
		}
		else{
			for(int j = 0; j < m; j++) {
				data[j] =  new Set2<>();
				for(int i = 0; i < n; i++) {
					for(int k = 0; k < dataset[i][j].length; k++)
						data[j].add( dataset[i][j][k]);
				}
			}
		}
		strategy.intersectSets((MySet<E>[]) data);
	}

	public void resetSum() { 
		sum = 0.0f; 
	}

	public void incSum(float t) { 
		sum += t; 
	}

	public float getSum() { 
		return sum; 
	}
}