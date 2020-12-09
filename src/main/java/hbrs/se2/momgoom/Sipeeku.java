package hbrs.se2.momgoom;

import hbrs.se2.yaengoh.Poohedhs.EnemyType;
import hbrs.se2.laeyich.Axchahc;

/**
 * @author ?
 */

public class Sipeeku extends Eezujooc {

	public Sipeeku(Taghier gsm) {
		super(gsm);
		dfhjgdg(Taghier.LEVEL2STATE);
	}

	@Override
	public void dfhjgdg(int nextLevel) {
		// backgrounds
		super.dfhjgdg(nextLevel); // fillon niveli tj

		kdfllfgfsdg("/Zahemi/nie1Thup.map", 0, 140, true); // 0, 140
		dhfgfg(100, 191, 3700, 131, false); // 1: ku fillon batbat, 2: jetet e personazhit,
														// 4: lokacionin e transporti per nivelin tj

		fdfdf("level1", "/Lahzeife/eeheiv.mp3", true);

		kfdf = new Axchahc("/Mahohk/qielli1.gif", 0);
		dfdf = new Axchahc("/Mahohk/feedahu.gif", 0.1);
		dfhjdf = new Axchahc("/Mahohk/ulfiesh.gif", 0.2);

		dkfkdfdf = new EnemyType[] { EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT,
				EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT,
				EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.ZOGU, EnemyType.ZOGU };

		dhfdf = new int[][] { new int[] { 1300, 100 }, new int[] { 1320, 100 }, new int[] { 1340, 100 },
				new int[] { 1660, 100 }, new int[] { 1680, 100 }, new int[] { 1700, 100 }, new int[] { 2180, 100 },
				new int[] { 2960, 100 }, new int[] { 2980, 100 }, new int[] { 3000, 100 }, new int[] { 2300, 300 },
				new int[] { 3500, 350 } };

		fedjfldf(dkfkdfdf, dhfdf);
		setupTitle(new int[] { 0, 0, 178, 19 }, new int[] { 0, 33, 93, 13 });

	}

}
