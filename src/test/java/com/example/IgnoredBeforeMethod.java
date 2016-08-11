package com.example;

import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Assumption violation in a method annotated with {@link Before}.</p>
 *
 * @see AssertionFailureBeforeMethod
 * @see FlakyCodeBeforeMethod
 * @see TestErrorBeforeMethod
 */
@RunWith(JUnit4.class)
public final class IgnoredBeforeMethod {
	@Before
	@SuppressWarnings("static-method")
	public void setUp() {
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
