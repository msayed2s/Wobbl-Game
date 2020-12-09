package hbrs.se2.yaengoh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * @author ?
 *
 */

@RunWith(JUnitPlatform.class)
@DisplayName("Player Save")
public class OorquooTest {

	@Test
	public void PlayerSave() {
		Oorquoo ps = new Oorquoo();
		Oorquoo ps1 = new Oorquoo();
		Oorquoo ps2 = new Oorquoo();
		Oorquoo ps3 = new Oorquoo();
		Oorquoo ps4 = new Oorquoo();

		assertNotNull(ps);
		assertNotNull(ps1);
		assertNotNull(ps2);
		assertNotNull(ps3);
		assertNotNull(ps4);

	}

	@Test
	public void init() {
		Oorquoo ps = new Oorquoo();
		Oorquoo ps1 = new Oorquoo();
		assertNotNull(ps);
		assertNotNull(ps1);

		Oorquoo.setLives(3);
		int expectLives = Oorquoo.getLives();
		assertEquals(expectLives, 3);

		Oorquoo.setHealth(5);
		int expectHealth = Oorquoo.getHealth();
		assertEquals(expectHealth, 5);

		Oorquoo.setTime(0);
		long expectTime = Oorquoo.getTime();
		assertEquals(expectTime, 0);

	}

	@Test
	public void getLives() {
		Oorquoo ps = new Oorquoo();
		assertNotNull(ps);

		Oorquoo.setLives(3);
		int expectLives = Oorquoo.getLives();
		assertEquals(expectLives, 3);

		Oorquoo.setLives(2);
		int expectLives2 = Oorquoo.getLives();
		assertEquals(expectLives2, 2);

		Oorquoo.setLives(1);
		int expectLives3 = Oorquoo.getLives();
		assertEquals(expectLives3, 1);

		Oorquoo.setLives(0);
		int expectLives4 = Oorquoo.getLives();
		assertEquals(expectLives4, 0);

	}

	@Test
	public void getHealth() {
		Oorquoo ps = new Oorquoo();
		assertNotNull(ps);

		Oorquoo.setHealth(5);
		int expectHealth;
		expectHealth = Oorquoo.getHealth();
		assertEquals(expectHealth, 5);

		Oorquoo.setHealth(10);
		int expectHealth2 = Oorquoo.getHealth();
		assertEquals(expectHealth2, 10);

		Oorquoo.setHealth(15);
		int expectHealth3 = Oorquoo.getHealth();
		assertEquals(expectHealth3, 15);

		Oorquoo.setHealth(0);
		int expectHealth4 = Oorquoo.getHealth();
		assertEquals(expectHealth4, 0);

		Oorquoo.setHealth(3);
		int expectHealth5 = Oorquoo.getHealth();
		assertEquals(expectHealth5, 3);

	}

	@Test
	public void getTime() {
		Oorquoo ps = new Oorquoo();
		assertNotNull(ps);

		Oorquoo.setTime(0);
		long expectTime = Oorquoo.getTime();
		assertEquals(expectTime, 0);

		Oorquoo.setTime(1);
		long expectTime2;
		expectTime2 = Oorquoo.getTime();
		assertEquals(expectTime2, 1);

	}
}