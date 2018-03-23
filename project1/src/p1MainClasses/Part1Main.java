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
import timeCollection.StrategiesTimeCollection;


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
				case "1":
					MySet<Integer>[] dataP1 = dataConverter1(data);
					Set1<Integer> setP1 =  (Set1<Integer>) s1.intersectSets(dataP1);
					System.out.println("Final set by P1: " + setP1);
					break;
				case "2":
					MySet<Integer>[] dataP2 = dataConverter2(data);
					Set2<Integer> setP2 = (Set2<Integer>) s2.intersectSets(dataP2);
					System.out.println("Final set by P2: " + setP2);
					break;
				case "3":
					MySet<Integer>[] dataP3 = dataConverter2(data);
					Set2<Integer> setP3 = (Set2<Integer>) s3.intersectSets(dataP3);
					System.out.println("Final set by P3: " + setP3);
					break;
				case "4":
					MySet<Integer>[] dataP4 = dataConverter2(data);
					Set2<Integer> setP4 = (Set2<Integer>) s4.intersectSets(dataP4);
					System.out.println("Final set by P4: " + setP4);
					break;
				case "5":
					System.out.println("Thank you for using this program.");
					break;
				default:
					MySet<Integer>[] data1 = dataConverter1(data);
					Set1<Integer> set1 =  (Set1<Integer>) s1.intersectSets(data1);
					MySet<Integer>[] data2 = dataConverter2(data);
					Set2<Integer> set2 = (Set2<Integer>) s2.intersectSets(data2);
					MySet<Integer>[] data3 = dataConverter2(data);
					Set2<Integer> set3 = (Set2<Integer>) s3.intersectSets(data3);
					MySet<Integer>[] data4 = dataConverter2(data);
					Set2<Integer> set4 = (Set2<Integer>) s4.intersectSets(data4);
					
					System.out.println("Final set by P1: " + set1);
					System.out.println("Final set by P2: " + set2);
					System.out.println("Final set by P3: " + set3);
					System.out.println("Final set by P4: " + set4);
					break;
			}
			
		}while(!strategy.equals("5"));
		
		
		scan.close();
	}
	
	public String Allresults(String res) {
		return res;
	}
	
	public static MySet<Integer>[] dataConverter1(Object [][][] dataSet){
		MySet<Integer>[] data = new MySet[dataSet[0].length];
    	int m = dataSet[0].length;
    	int n = dataSet.length;
    	for(int j = 0; j < m; j++) {
			data[j] = new Set1<Integer>();
			for(int i = 0; i < n; i++) {
				for(int k = 0; k < dataSet[i][j].length; k++)
					data[j].add((Integer) dataSet[i][j][k]);
			}
		}
		
		return data;
	}
	
	public static MySet<Integer>[] dataConverter2(Object [][][] dataSet){
		MySet<Integer>[] data = new MySet[dataSet[0].length];
    	int m = dataSet[0].length;
    	int n = dataSet.length;
    	for(int j = 0; j < m; j++) {
			data[j] = new Set2<Integer>();
			for(int i = 0; i < n; i++) {
				for(int k = 0; k < dataSet[i][j].length; k++)
					data[j].add((Integer) dataSet[i][j][k]);
			}
		}
		
		return data;
	}
}