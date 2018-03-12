package p1MainClasses;

import java.io.FileNotFoundException;

import dataGenerator.DataGenerator;
import dataGenerator.DataReader;
import mySetImplementations.P1_P2;
import mySetImplementations.P3;
import mySetImplementations.P4;

public class Part1Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		FilesGeneratorMain fg = new FilesGeneratorMain();
		P1_P2<String> s1 = new P1_P2<String>("Parameters.txt");
		P3<String> s2 = new P3<String>("Parameters.txt");
		P4 <String> s3 = new P4 <String>("Parameters.txt");
		DataGenerator dg = new DataGenerator(0, 0, 0);
		DataReader dr = new DataReader();
	}
	public String Allresults(String res) {
		return res;
	}
}