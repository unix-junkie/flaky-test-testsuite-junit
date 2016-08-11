package com.example;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public final class MultipleViaSpring {
	private int j;

	@Repeat(10)
	@Test
	public void multiple() {
		/*-
		 * Spring only repeats test runs until the 1st failure.
		 *
		 * Given the fact that:
		 *  - only the last invocation status is recorded, and
		 *  - the last (10th) invocation always fails,
		 * this test will have 100% rather than 10% failure rate.
		 */
		if (++this.j == 10) {
			fail("Failed during run #" + this.j);
		}
	}
}
