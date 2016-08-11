package com.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Test error in a method annotated with {@link BeforeClass @BeforeClass}.
 * None of the standard tests annotated with {@link Test @Test} are ever run,
 * and the only test error is reported instead.</p>
 *
 * @see AssertionFailureBeforeClass
 * @see IgnoredBeforeClass
 * @see FlakyCodeBeforeClass
 */
@RunWith(JUnit4.class)
public final class TestErrorBeforeClass {
	@BeforeClass
	public static void setUpOnce() {
		System.out.println("About to fail...");
		throw new RuntimeException("Regular test methods won't run, nor will appear as ignored");
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
