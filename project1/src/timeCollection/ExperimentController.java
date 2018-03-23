package timeCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.AbstractMap;
import java.util.ArrayList;

import dataGenerator.DataGenerator;
import interfaces.MySet;
import mySetImplementations.P1_P2;
import mySetImplementations.P3;
import mySetImplementations.P4;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

/**
 * This class represents an object data type that is able to carry the 
 * necessary experiments to estimate execution times of particular 
 * strategies to solve the set intersections problem as in p1_40354020_172. 
 * 
 * @author pedroirivera-vega
 *
 */
public class ExperimentController{
	
	private int n = 10;
	private int m = 50;
	private int initialSize = 1000;           // initial size to be tested
	private int repetitionsPerSize = 50000;    // experimental repetitions per size
	private int incrementalSizeStep = 1000;   // change of sizes (size delta)
	private int finalSize = 200;             // last size to be tested
	
	private ArrayList<StrategiesTimeCollection<Integer>> resultsPerStrategy; 
	// The i-th position will contain a particular strategy being tested. 
	// At the end, the i-th position will also contain a list of 
	// pairs (n, t), where t is the estimated time for size n for
	// the strategy at that position. 
	
	public ExperimentController(int n, int m, int is, int fs, int iss, int rps) { 
		this.n = n;
		this.m = m;
		initialSize = is; 
		repetitionsPerSize = rps; 
		incrementalSizeStep = iss; 
		finalSize = fs; 
		resultsPerStrategy = new ArrayList<>();

	}
	
	public void addStrategy(StrategiesTimeCollection<Integer> strategy) { 
		resultsPerStrategy.add(strategy); 
	}

	public <E> void run() throws CloneNotSupportedException { 
		StrategiesTimeCollection<Integer> [] resultsPerStrategy = new StrategiesTimeCollection[4]; 
		resultsPerStrategy[0] = new StrategiesTimeCollection<Integer>(new P1_P2("1"));
		resultsPerStrategy[1] = new StrategiesTimeCollection<Integer>(new P1_P2("2"));
		resultsPerStrategy[2] = new StrategiesTimeCollection<Integer>(new P3("3"));
		resultsPerStrategy[3] = new StrategiesTimeCollection<Integer>(new P4("4"));
		
		if (resultsPerStrategy.length == 0)
			throw new IllegalStateException("No strategy has been added."); 
		for (int size=initialSize; size<=finalSize; size+=incrementalSizeStep) { 

	// For each strategy, reset the corresponding internal variable that will be used to store the sum 
	// of times that the particular strategy exhibits for the current size size.
	for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy) 
	    strategy.resetSum();    // set to 0 an internal instance variable used to accumulate sum of times
			
	// Run all trials for the current size. 
	for (int r = 0; r<repetitionsPerSize; r++) {
	
	// The following will be the common dataset to be used in the current trial by all the strategies being
    // tested. Here, that data set is generated by a method that gets as input (parameter values): n, m, size. 
    // Where n and m are the number of companies and number of crime events, respective. The generated
    // must satisfy: size  =  i=1nj=1m(dataset[i][j].length)
	DataGenerator dg = new DataGenerator(n,m, size);
    Integer[][][] dataset = (Integer[][][]) dg.generateData();  // data set for this trial of given size

    // Apply each one of the strategies being tested using the previous dataset (of size size) as input; 
    // and, for each, estimate the time that the execution takes.
    for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy) {	
        long startTime = System.nanoTime();  // Measure system’s clock time before.
        strategy.runTrial(dataset);          // Run the strategy using the data in dataset.        
        long endTime = System.nanoTime();    // Measure system’s clock time after.

                       int estimatedTime = (int) (endTime-startTime);   // The estimated time.
        // Accumulate the estimated time (add it) to sum of times that the current strategy has 
        // so far accumulated  on the previous trials for datasets of the current size. 
        strategy.incSum(estimatedTime);    				
    }
    
	MySet<Integer>[] t = new MySet[dataset.length];
		if(resultsPerStrategy.equals("1")){
    		for(int i = 0; i < m; i++) {
    			t[i] =  new Set1<>();
    			for(int j = 0; j < n; j++) {
    				for(int k = 0; k < dataset[i][j].length; k++)
    					t[i].add( dataset[i][j][k]);
    			}
        	}
    	}
    	else if (resultsPerStrategy.equals("2") || resultsPerStrategy.equals("3")|| resultsPerStrategy.equals("4") ){
    		for(int i = 0; i < m; i++) {
    			t[i] =  new Set2<>();
    			for(int j = 0; j < n; j++) {
    				for(int k = 0; k < dataset[i][j].length; k++)
    					t[i].add( dataset[i][j][k]);
    			}
        	}
    	}
	}
	// For each strategy, compute the average time for the current size.	
	for (StrategiesTimeCollection<Integer> strategy : resultsPerStrategy)
	    strategy.add( new AbstractMap.SimpleEntry<Integer, Float>
	                      (size, (strategy.getSum()/((float) repetitionsPerSize)))
	                ); 
	
	
	}

}


	public void saveResults() throws FileNotFoundException { 
		
		PrintStream out = new PrintStream(new File("src/inputFiles", "allResults.txt"));
		out.print("Size");
		for (StrategiesTimeCollection<Integer> trc : resultsPerStrategy) 
			out.print("\t" + trc.getStrategyName()); 
		out.println();

		int numberOfExperiments = resultsPerStrategy.get(0).size(); 
		for (int i=0; i<numberOfExperiments; i++) {
			out.print(resultsPerStrategy.get(0).get(i).getKey());
			for (StrategiesTimeCollection<Integer> trc : resultsPerStrategy)
				out.print("\t" + trc.get(i).getValue());
			out.println(); 
		}
			
		out.close();
		
	}
}


