package lesPetitsPedestres;

import java.io.ByteArrayOutputStream;
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
	
	public void testprintFirst(){
		assert(true);
	}
	
	public void testprintFirst2(){
		assert(true);
	}
	
	public void testprintLast(){
		assert(true);
	}
	
	public void testprintLast2(){
		assert(true);
	}
	
	public void testaddSerie(){
		assert(true);
	}
	
	public void testgetSerie(){
		assert(true);
	}
	
	public void testselectByLabel(){
		assert(true);
	}

}