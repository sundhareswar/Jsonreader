package org.junit;

import org.utilities.BaseClass;

public class JunitTest extends BaseClass {
	static BaseClass b;

	@BeforeClass
	public static void goToPage() {
		b = new BaseClass();
		b.browserLaunch();
		b.windowMaximize();
	}

	@Before
	public void goToFbPage() {
		b = new BaseClass();
		b.urlLaunch("https://www.facebook.com/login/");
		b.currentTitle();
		b.currentUrl();
	}

	@Test

	public void testCase1() {
		System.out.println("Test case 1 passed.......");

	}

	@Test

	public void testCase2() {
		System.out.println("Test case 2 passed......");

	}

}
