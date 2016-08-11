package com.example;

import static org.junit.Assume.assumeTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Assumption violation in a method annotated with {@link
 * BeforeClass @BeforeClass} (should this happen within a test method, the
 * corresponding test would have been ignored). Standard tests annotated with
 * {@link Test @Test} are never executed; the 1st {code static} method annotated
 * with {@link BeforeClass @BeforeClass} is reported as the only ignored test.
 * </p>
 *
 * @see AssertionFailureBeforeClass
 * @see FlakyCodeBeforeClass
 * @see TestErrorBeforeClass
 */
@RunWith(JUnit4.class)
public final class IgnoredBeforeClass {
	@BeforeClass
	public static void setUpOnce() {
		System.out.println("About to violate an assumption...");
		assumeTrue("Regular test methods won't run, nor will appear as ignored", false);
	}

	@Test
	public void neverRuns0() {
		// empty
	}

	@Test
	public void neverRuns1() {
		// empty
	}
}
