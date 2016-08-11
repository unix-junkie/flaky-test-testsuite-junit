package com.example;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RepeatRule implements TestRule {
	private static final class RepeatStatement extends Statement {
		private final Statement statement;
		private final int repeat;

		public RepeatStatement(final Statement statement, final int repeat) {
			this.statement = statement;
			this.repeat = repeat;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see Statement#evaluate()
		 */
		@Override
		public void evaluate() throws Throwable {
			for (int i = 0; i < this.repeat; i++) {
				this.statement.evaluate();
			}
		}

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see TestRule#apply(Statement, Description)
	 */
	@Override
	public Statement apply(final Statement statement, final Description description) {
		Statement result = statement;
		final Repeat repeat = description.getAnnotation(Repeat.class);
		if (repeat != null) {
			final int times = repeat.value();
			result = new RepeatStatement(statement, times);
		}
		return result;
	}
}
