package com.aahmedse.props2json;

import java.util.Properties;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Props2JsonTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName name of the test case
	 */
	public Props2JsonTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(Props2JsonTest.class);
	}

	/**
	 * Simple Compound test
	 */
	public void testCompoundTest() {

		Properties p = new Properties();

		 p.setProperty("a", "123");
		 p.setProperty("b", "abc");
		 p.setProperty("c", "True");
		 p.setProperty("d.e", "true");
		 p.setProperty("d.f", "false");
		 p.setProperty("negativeNum", "-1");
		 p.setProperty("negativeFloat", "-0.189");
		 p.setProperty("positiveFloat", "0.189");
		 p.setProperty("e.list", "1,2,3,4,5,6,7,8,9,10");
		 p.setProperty("f.list", "-1,2.1,-3.14,0,0.0,true,false,TRUE,FALSE,David");

		assertEquals(
				PropsToJsonUtil.convertToJson(p),
					"{\"d\":{\"f\":false,\"e\":true},\"positiveFloat\":0.189,\"negativeFloat\":-0.189,\"e\":{\"list\":[1,2,3,4,5,6,7,8,9,10]},\"c\":true,\"b\":\"abc\",\"a\":123,\"f\":{\"list\":[-1,2.1,-3.14,0,0.0,true,false,true,false,\"David\"]},\"negativeNum\":-1}");
	}
}
