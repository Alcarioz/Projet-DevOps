package lesPetitsPedestres;


import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SeriesTest extends TestCase {

	
	public SeriesTest(String testName){		
		super(testName);
	}
	
	public static Test suite(){
		return new TestSuite( SeriesTest.class );
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetLabel(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Series<Integer> test = new Series("Test",list);
		assert(test.getLabel()=="Test");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetArray(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(42);
		list.add(22);
		list.add(13);
		list.add(0);
		Series<Integer> test = new Series("Test",list);
		assert(test.getArray().equals(list));
	}
	
	public void testgetSize(){
		
		assert(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testaddVal(){
		ArrayList<String> list = new ArrayList<String>();	
		Series<String> test = new Series("Test",list);
		test.addVal("test JUnit");
		assert(true);
	}
	
	public void testgetVal(){
		
		assert(true);
	}
	

}
