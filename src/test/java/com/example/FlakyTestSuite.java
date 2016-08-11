package com.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AssertionFailureAfterClass.class,
	AssertionFailureAfterMethod.class,
	AssertionFailureBeforeClass.class,
	AssertionFailureBeforeMethod.class,
	BrokenConcurrencyWithoutVolatile.class,
	BrokenConcurrencyWithVolatile.class,
	FlakyCodeAfterClass.class,
	FlakyCodeAfterMethod.class,
	FlakyCodeBeforeClass.class,
	FlakyCodeBeforeMethod.class,
	FlakyTestUsingRandom.class,
	IgnoredAfterClass.class,
	IgnoredAfterMethod.class,
	IgnoredBeforeClass.class,
	IgnoredBeforeMethod.class,
	Main.class,
	MultipleViaCustomRule.class,
	MultipleViaParameterized.class,
	MultipleViaSpring.class,
	MultipleViaTempusFugit.class,
	TestErrorAfterClass.class,
	TestErrorAfterMethod.class,
	TestErrorBeforeClass.class,
	TestErrorBeforeMethod.class,
})
public final class FlakyTestSuite {
	// empty
}
