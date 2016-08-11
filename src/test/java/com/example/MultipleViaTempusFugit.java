package com.example;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.code.tempusfugit.concurrency.IntermittentTestRunner;
import com.google.code.tempusfugit.concurrency.annotations.Intermittent;

@RunWith(IntermittentTestRunner.class)
public final class MultipleViaTempusFugit {
	@Test
	@Intermittent(repetition = 10)
	@SuppressWarnings("all")
	public void flakyFailure() {
		final Random random = new Random();
		final int upper = 10;
		assertTrue(upper % 2 == 0);
		final int i = random.nextInt(upper);
		assertTrue(format("Should be i \u2209 [%d, %d)", upper / 2, upper), i >= upper / 2);
	}
}
