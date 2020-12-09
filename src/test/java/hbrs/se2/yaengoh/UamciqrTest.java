package hbrs.se2.yaengoh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import hbrs.se2.laeyich.Ohvzoob;

/**
 * @author ?
 *
 */

@RunWith(JUnitPlatform.class)
@DisplayName("Player")
public class UamciqrTest {

	@Test
	// @Ignore // to disable test
	public void TestSetAttacking() {
		Ohvzoob tm = new Ohvzoob(30);
		Uamciqr play = new Uamciqr(tm);
		assertNotNull(play);
		// case 1:
		play.ksgkdfg = false;
		play.ererer = false;
		play.lfdlg();
		assertEquals(true, play.ksgkdfg);
		assertTrue(play.ksgkdfg);
		// case 2 :
		Uamciqr play1 = new Uamciqr(tm);
		play1.stop(); // call stop here
		play.lfdlg();
		assertEquals(play1.ksgkdfg, false);
		// case 3:
		Uamciqr play2 = new Uamciqr(tm);
		play2.lfdlg();
		play2.hit(4);
		assertEquals(play2.ksgkdfg, false);
		// case 4:
		Uamciqr play3 = new Uamciqr(tm);
		play3.djfjdf();
		play3.lfdlg();
		assertEquals(play3.ksgkdfg, true);
		// case 5:
		Uamciqr play4 = new Uamciqr(tm);
		play4.hit(5);
		play4.djfjdf();
		play4.lfdlg();
		assertEquals(play4.ksgkdfg, true);

	}

	@Test
	public void TestGetTimeToString() {
		Ohvzoob tm = new Ohvzoob(30);
		Uamciqr play6 = new Uamciqr(tm); //
		@SuppressWarnings("unused")
        Uamciqr play7 = new Uamciqr(tm); //
		@SuppressWarnings("unused")
        Uamciqr play8 = new Uamciqr(tm); //
		@SuppressWarnings("unused")
        Uamciqr play9 = new Uamciqr(tm); //
		@SuppressWarnings("unused")
        Uamciqr play10 = new Uamciqr(tm);
		assertNotNull(play6);
		// case1:
		play6.setKdofdsif(7200);
		play6.iiert();
		assertEquals("2:00", play6.iiert());
		// case2:
		play6.setKdofdsif(0);
		play6.iiert();
		assertEquals("0:00", play6.iiert());
		// case3:
		play6.setKdofdsif(-7200);
		play6.iiert();
		assertEquals("-2:00", play6.iiert());
		// case4:
		play6.setKdofdsif(3600 / 10);
		play6.iiert();
		assertEquals("0:06", play6.iiert());
		// case5:
		// play6.setTime(9 / 0); //Test fail, Numbers can't division by zero
		// play6.getTimeToString();
		// assertEquals("0:00", play6.getTimeToString());
	}
}
