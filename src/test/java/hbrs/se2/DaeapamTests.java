package hbrs.se2;

import hbrs.se2.main.WobblSpringTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * @author ?
 *
 */

@RunWith(JUnitPlatform.class)
@DisplayName("Project Suite Tests")
@SelectPackages({ "hbrs.se2.main", "hbrs.se2.gamestate", "hbrs.se2.gamestate.entity",
		"hbrs.se2.gamestate.handlers" })
@SelectClasses({ WobblSpringTests.class })
@ExcludeClassNamePatterns({ "^.*ATests?$" })
public class DaeapamTests {

}
