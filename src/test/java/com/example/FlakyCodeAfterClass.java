package com.example;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Flaky code in a method annotated with {@link AfterClass @AfterClass}.
 * Regular tests will always succeed. If {@link #tearDownOnce()} fails, a
 * separate failure will be recorded, but will never be marked as <em>flaky</em>
 * due to zero success rate (successful execution of {@link #tearDownOnce()} is
 * never recorded as a passed test invocation).</p>
 *
 * @see AssertionFailureAfterClass
 * @see IgnoredAfterClass
 * @see TestErrorAfterClass
 */
@RunWith(JUnit4.class)
public final class FlakyCodeAfterClass {
	@AfterClass
	@SuppressWarnings("all")
	public static void tearDownOnce() {
		final Random random = new Random();
		final int upper = 10;
		assertTrue(upper % 2 == 0);
		final int i = random.nextInt(upper);
		assertTrue(format("Regular test methods successful; 1 extra failure", upper / 2, upper), i >= upper / 2);
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
