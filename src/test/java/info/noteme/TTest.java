package info.noteme;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class TTest {

		@Rule
		public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

		@Test
		public void writesTextToSystemOut() {
			System.out.print("hello world");
			assertEquals("hello world", systemOutRule.getLog());
		}
		
		@Test
		public void printSimpleNote() {
			//notebook.printNote();
			System.out.print("body");
			assertEquals("body", systemOutRule.getLog());
		}

}
