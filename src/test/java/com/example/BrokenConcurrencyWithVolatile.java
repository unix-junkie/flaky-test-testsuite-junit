package com.example;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class BrokenConcurrencyWithVolatile {
	volatile long l = 0L;

	@Test
	public void flaky1() throws InterruptedException {
		test(1);
	}

	@Test
	public void flaky10() throws InterruptedException {
		test(10);
	}

	@Test
	public void flaky100() throws InterruptedException {
		test(100);
	}

	@Test
	public void flaky1000() throws InterruptedException {
		test(1000);
	}

	@Test
	public void flaky10000() throws InterruptedException {
		test(1000);
	}

	private void test(final int n) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			test(i <= 1000, i);
		}
	}

	private void test(final boolean sleep, final int pass) throws InterruptedException {
		this.l = 0L;
		final Thread t0 = new Thread() {
			/**
			 * {@inheritDoc}
			 *
			 * @see Thread#run()
			 */
			@Override
			public void run() {
				BrokenConcurrencyWithVolatile.this.l = 1L;
			}
		}; 
		t0.start(); // HB

		if (sleep) {
			Thread.sleep(0, 500);
		}
		assertEquals(format("Pass %d: ", pass), 1L, BrokenConcurrencyWithVolatile.this.l);

		t0.join(); // HB
	}
}
