package com.example;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class FlakyTestUsingRandom {
	@Test
	@SuppressWarnings("all")
	public void flaky() {
		final Random random = new Random();
		final int upper = 10;
		assertTrue(upper % 2 == 0);
		final int i = random.nextInt(upper);
		assertTrue(i >= upper / 2);
	}

	@Test
	@SuppressWarnings("all")
	public void flakyWithMessage() {
		final Random random = new Random();
		final int upper = 10;
		assertTrue(upper % 2 == 0);
		final int i = random.nextInt(upper);
		assertTrue(format("Should be i \u2209 [%d, %d)", upper / 2, upper), i >= upper / 2);
	}
}
