package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * <p>Test error in a method annotated with {@link Before @Before}.</p>
 *
 * @see AssertionFailureBeforeMethod
 * @see IgnoredBeforeMethod
 * @see FlakyCodeBeforeMethod
 */
@RunWith(JUnit4.class)
public final class TestErrorBeforeMethod {
	@Before
	@SuppressWarnings("static-method")
	public void setUp() {
		System.out.println("About to fail...");
		throw new RuntimeException();
	}

	@Test
	public void testError0() {
		// empty
	}

	@Test
	public void testError1() {
		// empty
	}
}
