package com.example;

import static org.junit.Assume.assumeTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Assumption violation in a method annotated with {@link After}.</p>
 *
 * @see AssertionFailureAfterMethod
 * @see FlakyCodeAfterMethod
 * @see TestErrorAfterMethod
 */
@RunWith(JUnit4.class)
public final class IgnoredAfterMethod {
	@After
	@SuppressWarnings("static-method")
	public void tearDown() {
		System.out.println("About to violate an assumption...");
		assumeTrue("Test ignored", false);
	}

	@Test
	public void ignored0() {
		// empty
	}

	@Test
	public void ignored1() {
		// empty
	}
}
