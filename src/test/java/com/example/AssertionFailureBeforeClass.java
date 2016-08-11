package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Permanent assertion failure in a method annotated with {@link
 * BeforeClass @BeforeClass}. Standard tests annotated with {@link Test @Test}
 * are never executed; the 1st {@code static} method annotated with {@link
 * BeforeClass @BeforeClass} is reported as the only assertion failure.</p>
 *
 * @see IgnoredBeforeClass
 * @see FlakyCodeBeforeClass
 * @see TestErrorBeforeClass
 */
@RunWith(JUnit4.class)
public final class AssertionFailureBeforeClass {
	@BeforeClass
	public static void setUpOnce() {
		System.out.println("About to fail an assertion...");
		assertTrue("Regular test methods won't run, nor will appear as ignored", false);
	}

	@Test
	public void neverRuns0() {
		assertTrue("This test failure is never reached", false);
	}

	@Test
	public void neverRuns1() {
		assertTrue("This test failure is never reached", false);
	}
}
