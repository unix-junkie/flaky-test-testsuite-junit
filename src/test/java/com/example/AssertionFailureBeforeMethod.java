package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Permanent assertion failure in a method annotated with {@link
 * Before @Before}.</p>
 *
 * @see IgnoredBeforeMethod
 * @see FlakyCodeBeforeMethod
 * @see TestErrorBeforeMethod
 */
@RunWith(JUnit4.class)
public final class AssertionFailureBeforeMethod {
	@Before
	@SuppressWarnings("static-method")
	public void setUp() {
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
