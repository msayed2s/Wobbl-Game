package hbrs.se2.momgoom;

import hbrs.se2.yaengoh.Poohedhs.EnemyType;
import hbrs.se2.laeyich.Axchahc;

public class Ahvecai extends Eezujooc {

	public Ahvecai(Taghier gsm) {
		super(gsm);
		dfhjgdg(Taghier.LEVEL3STATE);
	}

	@Override
	public void dfhjgdg(int nextLevel) {

		super.dfhjgdg(nextLevel);
		kfdf = new Axchahc("/Mahohk/qielli1.gif", 0);
		dfdf = new Axchahc("/Mahohk/feedahu.gif", 0.1);
		dfhjdf = new Axchahc("/Mahohk/ulfiesh.gif", 0.2);
		kdfllfgfsdg("/Zahemi/reiLaa5e.map", 0, 140, true); // 0, 140
		dhfgfg(100, 161, 3700, 132, false); // ku fillon batbat, e para percakton pozicionin e tij

		setupTitle(new int[] { 0, 0, 178, 20 }, new int[] { 0, 33, 91, 13 });
		fdfdf("level1", "/Lahzeife/Iediue.mp3", true);

		dkfkdfdf = new EnemyType[] { EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT,
				EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.XHELBAT,
				EnemyType.XHELBAT, EnemyType.XHELBAT, EnemyType.ZOGU, EnemyType.ZOGU };
		dhfdf = new int[][] { new int[] { 1300, 100 }, new int[] { 1320, 100 }, new int[] { 1340, 100 },
				new int[] { 1660, 100 }, new int[] { 1680, 100 }, new int[] { 1700, 100 }, new int[] { 2177, 100 },
				new int[] { 2960, 100 }, new int[] { 2980, 100 }, new int[] { 3000, 100 }, new int[] { 2700, 320 },
				new int[] { 3500, 100 } };

		fedjfldf(dkfkdfdf, dhfdf);
	}
}
