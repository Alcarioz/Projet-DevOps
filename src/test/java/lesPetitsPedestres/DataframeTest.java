package lesPetitsPedestres;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DataframeTest extends TestCase {
	
	public DataframeTest(String testName){		
		super(testName);
	}
	
	public static Test suite(){
		return new TestSuite( DataframeTest.class );
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testprintAll(){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(9);
		list1.add(48);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Bonjour");
		list2.add("Oui");
		list2.add("Non");
		Series<Integer> serie1 = new Series("Serie1",list1);
		Series<String> serie2 = new Series("Serie2",list2);
		ArrayList<Series> series = new ArrayList<Series>();
		series.add(serie1);
		series.add(serie2);
		Dataframe test = new Dataframe(series);
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newOut));
		
		test.printAll();
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("  Serie1 Serie2"));
		assertTrue(outPut.contains("0 5 Bonjour"));
		assertTrue(outPut.contains("1 9 Oui"));
		assertTrue(outPut.contains("2 48 Non"));
	}
	
	public void testprintAllFile() throws IOException{
		Dataframe test = new Dataframe("Test.csv");
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newOut));
		
		test.printAll();
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("  Sexe Prénom Année de naissance Langage Marque"));
		assertTrue(outPut.contains("0 M Thibault 1994 TypeScript ACER"));
		assertTrue(outPut.contains("1 F Béatrice 1984 Java HP"));
		assertTrue(outPut.contains("2 M Karim 1982 Python ACER"));
		assertTrue(outPut.contains("3 M Jeremy 1979 Java ACER"));
		assertTrue(outPut.contains("4 M Benjamin 1996 C DELL"));
	}
	
	public void testWrongFile() throws IOException{
		
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newOut));
		
		@SuppressWarnings("unused")
		Dataframe test = new Dataframe("TestInexistant.csv");
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("Le fichier est introuvable !"));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testprintFirst(){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(9);
		list1.add(48);
		list1.add(42);
		list1.add(3);
		list1.add(7);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Bonjour");
		list2.add("Oui");
		list2.add("Non");
		list2.add("Bonsoir");
		list2.add("Test");
		list2.add("DevOps");
		Series<Integer> serie1 = new Series("Serie1",list1);
		Series<String> serie2 = new Series("Serie2",list2);
		ArrayList<Series> series = new ArrayList<Series>();
		series.add(serie1);
		series.add(serie2);
		Dataframe test = new Dataframe(series);
	
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(newOut));
		
		test.printFirst();
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("  Serie1 Serie2"));
		assertTrue(outPut.contains("0 5 Bonjour"));
		assertTrue(outPut.contains("1 9 Oui"));
	}
	
	public void testprintFirst2() throws IOException, SizeException{
		Dataframe test = new Dataframe("Test.csv");
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newOut));
		
		test.printFirst(2);
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("  Sexe Prénom Année de naissance Langage Marque"));
		assertTrue(outPut.contains("0 M Thibault 1994 TypeScript ACER"));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testprintLast(){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(9);
		list1.add(48);
		list1.add(42);
		list1.add(3);
		list1.add(7);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Bonjour");
		list2.add("Oui");
		list2.add("Non");
		list2.add("Bonsoir");
		list2.add("Test");
		list2.add("DevOps");
		Series<Integer> serie1 = new Series("Serie1",list1);
		Series<String> serie2 = new Series("Serie2",list2);
		ArrayList<Series> series = new ArrayList<Series>();
		series.add(serie1);
		series.add(serie2);
		Dataframe test = new Dataframe(series);
	
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(newOut));
		
		test.printLast();
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("3 42 Bonsoir"));
		assertTrue(outPut.contains("4 3 Test"));
		assertTrue(outPut.contains("5 7 DevOps"));
	}
	
	public void testprintLast2() throws IOException, SizeException{
		Dataframe test = new Dataframe("Test.csv");
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newOut));
		
		test.printLast(3);
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("2 M Karim 1982 Python ACER"));
		assertTrue(outPut.contains("3 M Jeremy 1979 Java ACER"));
		assertTrue(outPut.contains("4 M Benjamin 1996 C DELL"));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testaddSerie() throws IOException{
		Dataframe test = new Dataframe("Test.csv");
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newOut));
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Grenoble");
		list.add("Lyon");
		list.add("Paris");
		list.add("Grenoble");
		list.add("Grenoble");
		Series<String> serie = new Series("Ville",list);
		
		test.addSerie(serie);
		test.printAll();
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("  Sexe Prénom Année de naissance Langage Marque Ville"));
		assertTrue(outPut.contains("0 M Thibault 1994 TypeScript ACER Grenoble"));
		assertTrue(outPut.contains("1 F Béatrice 1984 Java HP Lyon"));
		assertTrue(outPut.contains("2 M Karim 1982 Python ACER Paris"));
		assertTrue(outPut.contains("3 M Jeremy 1979 Java ACER Grenoble"));
		assertTrue(outPut.contains("4 M Benjamin 1996 C DELL Grenoble"));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testselectByLabel(){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(9);
		list1.add(48);
		list1.add(42);
		list1.add(3);
		list1.add(7);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Bonjour");
		list2.add("Oui");
		list2.add("Non");
		list2.add("Bonsoir");
		list2.add("Test");
		list2.add("DevOps");
		Series<Integer> serie1 = new Series("Serie1",list1);
		Series<String> serie2 = new Series("Serie2",list2);
		ArrayList<Series> series = new ArrayList<Series>();
		series.add(serie1);
		series.add(serie2);
		Dataframe test = new Dataframe(series);
		
		ArrayList<String> labels = new ArrayList<String>();
		labels.add("Serie1");
	
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(newOut));
		
		Dataframe result = test.selectByLabel(labels);
		result.printAll();
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("  Serie1"));
		assertTrue(outPut.contains("0 5"));
		assertTrue(outPut.contains("1 9"));
		assertTrue(outPut.contains("2 48"));
		assertTrue(outPut.contains("3 42"));
		assertTrue(outPut.contains("4 3"));
		assertTrue(outPut.contains("5 7"));
	}
	
	public void testselectByIndex() throws IOException{
		Dataframe test = new Dataframe("Test.csv");
		
		PrintStream oldOut = System.out;
		ByteArrayOutputStream newOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(newOut));
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		indexes.add(1);
		indexes.add(3);
		
		Dataframe result = test.selectByIndexes(indexes);
		result.printAll();
		
		System.setOut(oldOut);
		
		String outPut = new String(newOut.toByteArray());
		
		assertTrue(outPut.contains("  Sexe Prénom Année de naissance Langage Marque"));
		assertTrue(outPut.contains("1 F Béatrice 1984 Java HP"));
		assertTrue(outPut.contains("3 M Jeremy 1979 Java ACER"));
	}

}
