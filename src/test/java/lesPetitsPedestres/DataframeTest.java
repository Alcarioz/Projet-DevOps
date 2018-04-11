package lesPetitsPedestres;

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
	
	public void testprintAll(){
		
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
