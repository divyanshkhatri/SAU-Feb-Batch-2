package mavenjunit.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestJunit1.class,
   JavaTest.class
})

public class TestSuite {

}
