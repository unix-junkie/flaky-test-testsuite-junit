package com.example;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Test error in a method annotated with {@link After @After}.</p>
 *
 * @see AssertionFailureAfterMethod
 * @see IgnoredAfterMethod
 * @see FlakyCodeAfterMethod
 */
@RunWith(JUnit4.class)
public final class TestErrorAfterMethod {
	@After
	@SuppressWarnings("static-method")
	public void tearDown() {
		System.out.println("About to fail...");
		throw new RuntimeException();
	}

	@Test
	public void testError0() {
		// empty
	}

	@Test
	public void testError1() {
		// empty
	}
}
