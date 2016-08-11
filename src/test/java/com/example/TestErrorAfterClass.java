package com.example;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Test error in a method annotated with {@link AfterClass @AfterClass}. All
 * standard tests annotated with {@link Test @Test} are successful, and an extra
 * test error is reported.</p>
 *
 * @see AssertionFailureAfterClass
 * @see IgnoredAfterClass
 * @see FlakyCodeAfterClass
 */
@RunWith(JUnit4.class)
public final class TestErrorAfterClass {
	@AfterClass
	public static void tearDownOnce() {
		System.out.println("About to fail...");
		throw new RuntimeException("Extra test error");
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
