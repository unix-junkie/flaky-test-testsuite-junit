package com.example;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Flaky code in a method annotated with {@link BeforeClass @BeforeClass}.
 * Regular tests will only succeed if {@link #setUpOnce()} completes
 * normally. If, on the other hand, {@link #setUpOnce()} fails, a separate
 * failure will be recorded, but will never be marked as <em>flaky</em> due to
 * zero success rate (successful execution of {@link #setUpOnce()} is never
 * recorded as a passed test invocation).</p>
 *
 * @see AssertionFailureBeforeClass
 * @see IgnoredBeforeClass
 * @see TestErrorBeforeClass
 */
@RunWith(JUnit4.class)
public final class FlakyCodeBeforeClass {
	@BeforeClass
	@SuppressWarnings("all")
	public static void setUpOnce() {
		final Random random = new Random();
		final int upper = 10;
		assertTrue(upper % 2 == 0);
		final int i = random.nextInt(upper);
		assertTrue(format("Regular test methods won't run, nor will appear as ignored", upper / 2, upper), i >= upper / 2);
	}

	@Test
	public void willSucceedIfRuns0() {
		// empty
	}

	@Test
	public void willSucceedIfRuns1() {
		// empty
	}
}
