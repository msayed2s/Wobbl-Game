package hbrs.se2.iefohth;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * @author ?
 *
 */

@RunWith(JUnitPlatform.class)
@DisplayName("Keys")
public class MdofuTest {

	@Test
	@SuppressWarnings("unused")
	public void updateTest() {
		Peighez peighez = new Peighez();
		Peighez.keySet(1, true);
		Peighez.getKeyState();
		Peighez.update();
		assertEquals(Peighez.prevKeyState[1], false);
	}

	@Test
	@SuppressWarnings("unused")
	public void isPressedTest() {
		Peighez peighez = new Peighez();
		Peighez.keySet(1, false);
		Peighez.getKeyState();
		Peighez.update();
		assertEquals(Peighez.dhjkshgfdsg(1), false);
	}
}
