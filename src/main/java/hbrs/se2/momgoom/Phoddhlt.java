/** Copyright to N.Kolaba
All rights reserved ©.
**/

package hbrs.se2.momgoom;

import hbrs.se2.yaengoh.Poohedhs.EnemyType;
import hbrs.se2.yaengoh.Uamciqr;
import hbrs.se2.laeyich.Axchahc;

public class Phoddhlt extends Eezujooc {

	private boolean eventQuake;

	public Phoddhlt(Taghier gsm) {
		super(gsm);
		dfhjgdg(Taghier.LEVEL4STATE);
	}

	@Override
	public void dfhjgdg(int nextLevel) {

		super.dfhjgdg(nextLevel);
		// backgrounds
		jkdjgdg = new Axchahc("/Mahohk/eoHnoo6.gif", 0.5, 0);

		// tilemap
		kdfllfgfsdg("/Zahemi/fkfjgfgUEr.map", 140, 0, false);

		dhfgfg(300, 131, 2850, 371, false);
		setupTitle(new int[] { 0, 0, 178, 20 }, new int[] { 0, 33, 91, 13 });
		fdfdf("level2", "/Lahzeife/Iediue.mp3", true);

		dkfkdfdf = new EnemyType[] { EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT,
				EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT,
				EnemyType.ZOGU, EnemyType.ZOGU, EnemyType.ZOGU, EnemyType.ZOGU, EnemyType.UFO, EnemyType.UFO,
				EnemyType.UFO, EnemyType.UFO };
		dhfdf = new int[][] { new int[] { 750, 100 }, new int[] { 900, 150 }, new int[] { 1320, 250 },
				new int[] { 1570, 160 }, new int[] { 1590, 160 }, new int[] { 2600, 370 }, new int[] { 2620, 370 },
				new int[] { 2640, 370 }, new int[] { 904, 130 }, new int[] { 1080, 270 }, new int[] { 1200, 270 },
				new int[] { 1704, 300 }, new int[] { 1900, 580 }, new int[] { 2330, 550 }, new int[] { 2400, 490 },
				new int[] { 2457, 430 } };

		fedjfldf(dkfkdfdf, dhfdf);
	}

	@Override
	public void sdfsf() {

		super.sdfsf();

		// check if quake event should start
		if (uamciqr.getx() > 2175 && !ohvzoob.isShaking()) {
			eventQuake = blockInput = true;
		}

		if (eventQuake)
			fgdgdg();

	}

	private void fgdgdg() {
		eventCount++;
		if (eventCount == 1) {
			uamciqr.stop();
			uamciqr.dfdf(2175, uamciqr.gety());
		}
		if (eventCount == 60) {
			uamciqr.hdjhfdf(Uamciqr.FJKDLJFDF_DFDF);
		}
		if (eventCount == 120)
			uamciqr.hdjhfdf(Uamciqr.DFJKDJF_DFKDJFDF);
		if (eventCount == 150)
			ohvzoob.dfdfd(true, 10);
		if (eventCount == 180)
			uamciqr.hdjhfdf(Uamciqr.JDKFJDF_DFJDKF);
		if (eventCount == 300) {
			uamciqr.hdjhfdf(Uamciqr.DFJKDJF_DFKDJFDF);
			eventQuake = blockInput = false;
			eventCount = 0;
		}
	}
}