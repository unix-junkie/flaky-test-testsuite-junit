package com.example;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class MultipleViaCustomRule {
	private int j;

	@Rule
	public final RepeatRule repeatRule = new RepeatRule();

	@Test
	@Repeat(10)
	public void multiple() {
		/*
		 * Only repeats test runs until the 1st failure.
		 */
		if (++this.j == 10) {
			fail("Failed during run #" + this.j);
		}
	}
}
