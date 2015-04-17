package com.cloudwick.training.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private  Calculator c;// create a calculator object

	@Before
	public void setUp() throws Exception {
		c=new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		c=null;
	}
	
	@Test
	public void testCalculateNumLessThanTen(){
		int result=c.calculate(5, 100);
		assertEquals(result,105);//(expected , gotoutput) it matches and tests the code
	}

}
