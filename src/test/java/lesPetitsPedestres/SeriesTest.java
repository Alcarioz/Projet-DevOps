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
		String result = test.getLabel();
		assertTrue(result=="Test");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetLabel2(){
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		Series<Boolean> test = new Series("Test2",list);
		String result = test.getLabel();
		assertTrue(result=="Test2");
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
		ArrayList<Integer> result = test.getArray();
		assertTrue(result.equals(list));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetArray2(){
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('c');
		list.add('r');
		list.add('g');
		list.add('z');
		Series<Character> test = new Series("Test",list);
		ArrayList<Character> result = test.getArray();
		assertTrue(result.equals(list));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetArray3(){
		ArrayList<Character> list = new ArrayList<Character>();
		Series<Character> test = new Series("Test",list);
		ArrayList<Character> result = test.getArray();
		assertTrue(result.equals(list));
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
		Integer result = test.getSize();
		assertTrue(result==list.size());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetSize2(){
		ArrayList<String> list = new ArrayList<String>();
		Series<String> test = new Series("Test",list);
		Integer result = test.getSize();
		assertTrue(result==list.size());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testaddVal(){
		ArrayList<String> list = new ArrayList<String>();	
		Series<String> test = new Series("Test",list);
		test.addVal("test JUnit");
		assertTrue(list.get(0)=="test JUnit");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testgetVal(){
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		list.add(true);
		list.add(false);
		list.add(true);
		list.add(true);
		Series<Boolean> test = new Series("Test",list);
		Boolean result = test.getVal(1);
		assertTrue(result==false);
	}

}
