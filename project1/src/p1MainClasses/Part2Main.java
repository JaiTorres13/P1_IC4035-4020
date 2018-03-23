package p1MainClasses;

import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.Scanner;

import dataGenerator.DataGenerator;
import dataGenerator.DataReader;
import timeCollection.ExperimentController;
import interfaces.MySet;
import mySetImplementations.P1_P2;
import mySetImplementations.P3;
import mySetImplementations.P4;
import timeCollection.StrategiesTimeCollection;

public class Part2Main {
	
	private static int[] parms = {10, 50, 1000, 50000, 1000, 200};
	
	public static void main(String[] args) throws CloneNotSupportedException{
		// min size, max size, size increment, number of trials per size/strategy
		
			if (args.length > 6)
				System.out.println("Unexpected number of parameters. Must be <= 6.");
			for (int i=0; i<args.length; i++)
				parms[i] = Integer.parseInt(args[i]); 
			
			// Parm1: initial size
			// Parm2: final size to consider
			// Parm3: incremental steps (size)
			// Parm4: trials per size
			ExperimentController ec = new timeCollection.ExperimentController(parms[0], parms[1], parms[2], parms[3], 
					parms[4],  parms[5]); 
			
			/**/	
			ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1_P2<Integer>("P1")));
			ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1_P2<Integer>("P2")));
			ec.addStrategy(new StrategiesTimeCollection<Integer>(new P3<Integer>("P3")));
			ec.addStrategy(new StrategiesTimeCollection<Integer>(new P4<Integer>("P4")));
			/**/

			ec.run();    // run the experiments on all the strategies added to the controller object (ec)
			
			// save the results for each strategy....
			try {
				ec.saveResults();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
			
	}
		
	

