package com.example;

import static java.lang.System.nanoTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class Main {
	@Test
	@SuppressWarnings("static-method")
	public void environmentDependentAndFlaky0() {
		if (System.getProperty("os.name").startsWith("Windows")) {
			assertEquals("Always flaky on Windows", 0, nanoTime() % 2);
		}
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependentAndFlaky1() {
		if (!System.getProperty("os.name").startsWith("Windows")) {
			assertEquals("Never flaky on Windows", 0, nanoTime() % 2);
		}
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependentAndFlaky2() {
		if (System.getProperty("os.name").startsWith("Linux")) {
			assertEquals("Always flaky on Linux", 0, nanoTime() % 2);
		}
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependentAndFlaky3() {
		if (!System.getProperty("os.name").startsWith("Linux")) {
			assertEquals("Never flaky on Linux", 0, nanoTime() % 2);
		}
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependent0() {
		assertTrue("Always failing on Windows", !System.getProperty("os.name").startsWith("Windows"));
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependent1() {
		assertTrue("Never failing on Windows", System.getProperty("os.name").startsWith("Windows"));
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependent2() {
		assertTrue("Always failing on Linux", !System.getProperty("os.name").startsWith("Linux"));
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependent3() {
		assertTrue("Never failing on Linux", System.getProperty("os.name").startsWith("Linux"));
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependent4() {
		assumeTrue("Always ignored on Windows", !System.getProperty("os.name").startsWith("Windows"));
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependent5() {
		assumeTrue("Never ignored on Windows", System.getProperty("os.name").startsWith("Windows"));
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependent6() {
		assumeTrue("Always ignored on Linux", !System.getProperty("os.name").startsWith("Linux"));
	}

	@Test
	@SuppressWarnings("static-method")
	public void environmentDependent7() {
		assumeTrue("Never ignored on Linux", System.getProperty("os.name").startsWith("Linux"));
	}

	@Test
	@SuppressWarnings("static-method")
	public void flaky0() {
		assertEquals(0, nanoTime() % 2);
	}

	@Test
	@SuppressWarnings("static-method")
	public void flaky1() {
		assertEquals(0, nanoTime() % 2);
	}

	@Test
	@SuppressWarnings("static-method")
	public void flaky2() {
		assertEquals(0, nanoTime() % 2);
	}

	@Test
	@SuppressWarnings("static-method")
	public void flaky3() {
		assertEquals(0, nanoTime() % 2);
	}

	@Test
	@SuppressWarnings("static-method")
	public void flaky4() {
		assertEquals(0, nanoTime() % 2);
	}

	@Test
	@SuppressWarnings("static-method")
	public void flaky5() {
		assertEquals(0, nanoTime() % 2);
	}

	@Test
	@SuppressWarnings("static-method")
	public void willSucceed() {
		assertTrue(true);
	}

	@Test
	@SuppressWarnings("static-method")
	public void willFail() {
		assertTrue(false);
	}

	@Test
	@SuppressWarnings("static-method")
	public void ignored() {
		assumeTrue(false);
	}

	@Test
	@Ignore
	public void ignoredViaAnnotation() {
		// empty
	}

	@Test
	@Ignore("This is an ignored test with a custom message")
	public void ignoredViaAnnotationWithMessage() {
		// empty
	}

	@Test
	@SuppressWarnings("static-method")
	public void testError() {
		throw new RuntimeException("Test hasn't completed");
	}
}
