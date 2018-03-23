package timeCollection;


import java.util.ArrayList;
import java.util.Map;

import interfaces.IntersectionFinder;
import interfaces.MySet;

import java.util.AbstractMap.SimpleEntry;


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
    
    public void runTrial(Object[][][] dataset) { 
    	MySet<E>[] data = null ;
    	int m = dataset[0].length;
    	int n = dataset.length;
    	for(int j = 0; j < m; j++) {
			data[j]= null;
			for(int i = 0; i < n; i++) {
				for(int k = 0; k < dataset[i][j].length; k++)
					data[j].add((E) dataset[i][j][k]);
			}
		}
    	 strategy.intersectSets(data);
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