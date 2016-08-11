package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Permanent assertion failure in a method annotated with {@link
 * AfterClass @AfterClass}. All standard tests annotated with {@link Test @Test}
 * are successful; the 1st {@code static} method annotated with {@link
 * AfterClass @AfterClass} is reported as a separate assertion failure.</p>
 *
 * @see IgnoredAfterClass
 * @see FlakyCodeAfterClass
 * @see TestErrorAfterClass
 */
@RunWith(JUnit4.class)
public final class AssertionFailureAfterClass {
	@AfterClass
	public static void tearDownOnce() {
		System.out.println("About to fail an assertion...");
		assertTrue("Extra test failure", false);
	}

	@Test
	public void willSucceed0() {
		// empty
	}

	@Test
	public void willSucceed1() {
		// empty
	}
}
