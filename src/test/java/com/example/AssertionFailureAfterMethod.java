package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Permanent assertion failure in a method annotated with {@link
 * After @After}.</p>
 *
 * @see IgnoredAfterMethod
 * @see FlakyCodeAfterMethod
 * @see TestErrorAfterMethod
 */
@RunWith(JUnit4.class)
public final class AssertionFailureAfterMethod {
	@After
	@SuppressWarnings("static-method")
	public void tearDown() {
		System.out.println("About to fail an assertion...");
		assertTrue(false);
	}

	@Test
	public void willFail0() {
		// empty
	}

	@Test
	public void willFail1() {
		// empty
	}
}
