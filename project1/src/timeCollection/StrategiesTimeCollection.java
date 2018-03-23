package timeCollection;


import java.util.ArrayList;
import java.util.Map;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

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
    
    public void runTrial(Integer[][][] dataset) { 
    	
    	MySet<Integer>[] data = new MySet[dataset.length];
    	int m = dataset.length;
    	int n = dataset[0].length;
    	
    	if(strategy.getName().equals("1")){
    		for(int i = 0; i < m; i++) {
    			data[i] =  new Set1<>();
    			for(int j = 0; j < n; j++) {
    				for(int k = 0; k < dataset[i][j].length; k++)
    					data[i].add( dataset[i][j][k]);
    			}
        	}
    	}
    	else{
    		for(int i = 0; i < m; i++) {
    			data[i] =  new Set2<>();
    			for(int j = 0; j < n; j++) {
    				for(int k = 0; k < dataset[i][j].length; k++)
    					data[i].add( dataset[i][j][k]);
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