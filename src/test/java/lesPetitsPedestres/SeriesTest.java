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
	public void testgetLabel2(){
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		Series<Boolean> test = new Series("Test2",list);
		assert(test.getLabel()=="Test2");
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetArray2(){
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('c');
		list.add('r');
		list.add('g');
		list.add('z');
		Series<Character> test = new Series("Test",list);
		assert(test.getArray().equals(list));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetSize(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Bonjour");
		list.add("Je fais des tests");
		list.add("Tu vas bien?");
		list.add("J'espère que tu vas bien");
		Series<String> test = new Series("Test",list);
		list.add("Oui");
		assert(test.getSize()==list.size());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetSize2(){
		ArrayList<String> list = new ArrayList<String>();
		Series<String> test = new Series("Test",list);
		assert(test.getSize()==list.size());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testaddVal(){
		ArrayList<String> list = new ArrayList<String>();	
		Series<String> test = new Series("Test",list);
		test.addVal("test JUnit");
		assert(list.get(0)=="test JUnit");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetVal(){
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		list.add(true);
		list.add(false);
		list.add(true);
		list.add(true);
		Series<Boolean> test = new Series("Test",list);
		assert(test.getVal(1)==false);
	}
	

}
