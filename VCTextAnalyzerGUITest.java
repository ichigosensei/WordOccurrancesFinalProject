package Module2;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author s.trinidad
 *
 */
public class VCTextAnalyzerGUITest {

	/**
	 * This shows a pass or fail test on JUnit
	 */
	@Test
	public void TestAnalyzerGUI() {

	}		
		/**
		 * @param args
		 */
		public static void main(String[] args) {
		      Result TestAnalyzerResults = JUnitCore.runClasses(VCTextAnalyzerGUI.class);
				
		      for (Failure failure : TestAnalyzerResults.getFailures()) {
		         System.out.println(failure.toString());
		      }
				
		      System.out.println(TestAnalyzerResults.wasSuccessful());
	
	}
}
