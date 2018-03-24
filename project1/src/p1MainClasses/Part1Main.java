package p1MainClasses;

import java.io.FileNotFoundException;
import java.util.Scanner;

import dataGenerator.DataGenerator;
import dataGenerator.DataReader;
import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.P1_P2;
import mySetImplementations.P3;
import mySetImplementations.P4;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import timeCollection.StrategiesTimeCollection;

/**
 * 
 * @author JaiTorres13
 * 	Jainel Marie Torres Santos (843-14-8932) (Sec. 030)
 *@author CesarJustiniano 
 *	Cesar Andres Justiniano Santiago (840-15-3720)(Sec. 030)
 *
 */
public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length > 1)
			System.out.println("Must be one parameter.");

		// creates an array of type IntersectionFinder
		IntersectionFinder[] FinderInt = new IntersectionFinder[4]; 
		FinderInt[0] = new P1_P2("P1");
		FinderInt[1] = new P1_P2("P2");
		FinderInt[2] = new P3("P3");
		FinderInt[3] = new P4("P4"); 

		// The user can select the type of strategy in the terminal
		if (args.length != 0) { 

			int strategy = Integer.parseInt(args[0])-1;
			System.out.println("Final set by " + FinderInt[strategy].getName() + ":" +
					FinderInt[strategy].intersectSets(unionIntFinder(args[0])));

		}
		// If the user does not apply a method, the default choice is to apply all methods
		else { 

			for(int i = 0; i < FinderInt.length ; i++){

				System.out.println("Final set by " + FinderInt[i].getName() + ":" +
						FinderInt[i].intersectSets(unionIntFinder(Integer.toString( i + 1))));

			}
		}
	}

	/**
	 * @param arg
	 * returns an object of type MySet[], converting a three dimension array to an array of type MySet[]
	 */
	private static MySet[] unionIntFinder(String arg) throws FileNotFoundException {

		DataReader datar = new DataReader();
		Object [][][] dS = datar.readDataFiles();
		MySet[] t = new MySet[dS[0].length];

		for(int j = 0 ; j<dS[0].length ; j++) {

			t[j] = new Set2();       

			if(arg.equals("1"))
				t[j] = new Set1();  

			for(int i =0 ; i<dS.length ; i++) {
				for( int k=0 ; k< dS[i][j].length; k++) {

					t[j].add(dS[i][j][k]);

				}
			}
		}
		return t;
	}
}