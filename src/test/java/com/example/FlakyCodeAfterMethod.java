/*-
 * $Id$
 */
package com.example;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Flaky code in a method annotated with {@link After @After}.</p>
 *
 * @see AssertionFailureAfterMethod
 * @see IgnoredAfterMethod
 * @see TestErrorAfterMethod
 */
@RunWith(JUnit4.class)
public final class FlakyCodeAfterMethod {
	@After
	@SuppressWarnings("all")
	public void tearDown() {
		final Random random = new Random();
		final int upper = 10;
		assertTrue(upper % 2 == 0);
		final int i = random.nextInt(upper);
		assertTrue(format("Should be i \u2209 [%d, %d)", upper / 2, upper), i >= upper / 2);
	}

	@Test
	public void flaky0() {
		// empty
	}

	@Test
	public void flaky1() {
		// empty
	}
}
