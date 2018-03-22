package p1MainClasses;

import java.io.FileNotFoundException;
import java.util.Scanner;

import dataGenerator.DataGenerator;
import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.P1_P2;
import mySetImplementations.P3;
import mySetImplementations.P4;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {

//		FilesGeneratorMain fg = new FilesGeneratorMain();
//		DataGenerator dg = new DataGenerator(0, 0, 0);
		Scanner scan = new Scanner(System.in);
		String strategy;
		DataReader dr = new DataReader();

		Object [][][] data = dr.readDataFiles();
		

		P1_P2<Integer> s1 = new P1_P2<Integer>("1");
		P1_P2<Integer> s2 = new P1_P2<Integer>("2");
		P3<Integer> s3 = new P3<Integer>("3");
		P4<Integer> s4 = new P4<Integer>("4");
		
		
		do{
			System.out.println("My Set menu:");
			System.out.println("1. Use P1 strategy");
			System.out.println("2. Use P2 strategy");
			System.out.println("3. Use P3 strategy");
			System.out.println("4. Use P4 strategy");
			System.out.println("5. Exit program");
			System.out.println("Only press ENTER to use all strategies");
			
			System.out.print("Enter option: ");
			strategy = scan.next();
			
			switch(strategy){
				case "":
					
//					System.out.println("Final set by P1: " + s1.intersectSets( (MySet<Integer>[]) data));
//					System.out.println("Final set by P2: " + s2.intersectSets( (MySet<Integer>[]) data));
//					System.out.println("Final set by P3: " + s3.intersectSets( (MySet<Integer>[]) data));
//					System.out.println("Final set by P4: " + s4.intersectSets( (MySet<Integer>[]) data));
					break;
				case "1":
					Set1<Integer> union1 = toArray1(data);
					System.out.println("Final set by P1: " + s1.intersectSets( (MySet<Integer>[]) union1.toArray()));
					break;
				case "2":
					Set2<Integer> union2 = toArray2(data);
					System.out.println("Final set by P2: " + s2.intersectSets( (MySet<Integer>[]) union2.toArray()));
					break;
				case "3":
					Set2<Integer> union3 = toArray2(data);
					System.out.println("Final set by P3: " + s3.intersectSets( (MySet<Integer>[]) union3.toArray()));
					break;
				case "4":
					Set2<Integer> union4 = toArray2(data);
					System.out.println("Final set by P4: " + s4.intersectSets( (MySet<Integer>[]) union4.toArray()));
					break;
				case "5":
					System.out.println("Thank you for using this program.");
					break;
				default:
					System.out.println("Invalid input, please try again.\n");
			}
			
		}while(strategy != "5");
		
		scan.close();
	}
	
	public String Allresults(String res) {
		return res;
	}
	
	public static Set1<Integer> toArray1(Object [][] data){
		Set1<Integer> set1 = new Set1<Integer>();
		for(int i=0;i<data.length;i++)
			for(int j=0;j<data.length;j++)
				set1.add((Integer) data[i][j]);
		
		return set1;
	}
	
	public static Set2<Integer> toArray2(Object [][] data){
		Set2<Integer> set2 = new Set2<Integer>();
		for(int i=0;i<data.length;i++)
			for(int j=0;j<data.length;j++)
				set2.add((Integer) data[i][j]);
		
		return set2;
	}
}