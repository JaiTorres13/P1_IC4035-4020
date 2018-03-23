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

/**
 * 
 * @author JaiTorres13
 * 	Jainel Marie Torres Santos (843-14-8932) (Sec. 030)
 *@author CesarJustiniano 
 *	Cesar Andres Justiniano Santiago (840-15-3720)(Sec. 030)
 *
 */
public class Part2Main {

	//default parameters
	private static int[] parms = {10, 50, 1000, 50000, 1000, 200};

	public static void main(String[] args) throws CloneNotSupportedException{
	
		
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

		/*Strategies*/	
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1_P2<Integer>("P1")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1_P2<Integer>("P2")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P3<Integer>("P3")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P4<Integer>("P4")));
		/**/

		ec.run();    // runs all the strategies

		// save the results for each strategy in the file allResuls.txt
		try {
			ec.saveResults();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

}



