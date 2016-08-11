package com.example;

import static org.junit.Assume.assumeTrue;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Assumption violation in a method annotated with {@link
 * AfterClass @AfterClass}. All standard tests annotated with {@link Test @Test}
 * are successful, and an extra ignored test is reported.</p>
 *
 * @see AssertionFailureAfterClass
 * @see FlakyCodeAfterClass
 * @see TestErrorAfterClass
 */
@RunWith(JUnit4.class)
public final class IgnoredAfterClass {
	@AfterClass
	public static void tearDownOnce() {
		System.out.println("About to violate an assumption...");
		assumeTrue("Extra ignored test", false);
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
