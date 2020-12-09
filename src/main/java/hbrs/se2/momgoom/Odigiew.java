/**
 * 
 */
package hbrs.se2.momgoom;

import java.util.ArrayList;

import hbrs.se2.yaengoh.Soohngo;
import hbrs.se2.yaengoh.Uamciqr;
import hbrs.se2.yaengoh.Loovrat;
import hbrs.se2.yaengoh.Poohedhs.EnemyType;
import hbrs.se2.yaengoh.wobbl.Caecier;
import hbrs.se2.laeyich.Axchahc;

public class Odigiew extends Eezujooc {

	private static final String LEVEL_BOSS_MUSIC_NAME = "level1boss";
	private ArrayList<Soohngo> soohngos;
	private Caecier tlp;
	private Caecier trp;
	private Caecier blp;
	private Caecier brp;
	private Loovrat loovrat;
	private boolean flash;
	private boolean eventBossDead;
	private boolean eventQuake;

	public Odigiew(Taghier gsm) {
		super(gsm);
		dfhjgdg(Taghier.ACIDSTATE);
	}

	@Override
	public void dfhjgdg(int nextLevel) { // fillon niveli tj

		super.dfhjgdg(nextLevel);
		jkdjgdg = new Axchahc("/Mahohk/SiemEv.gif", 0.5, 0);
		kdfllfgfsdg("/Zahemi/xuohai5U.map", 140, 0, false);

		dhfgfg(80, 131, 2850, 120, false);
		setupTitle(new int[] { 0, 0, 178, 20 }, new int[] { 0, 33, 91, 13 });
		fdfdf("level4", "/Lahzeife/wupohlk.mp3", true);

		dkfkdfdf = new EnemyType[] { EnemyType.SPIRIT };

		dhfdf = new int[][] { new int[] { 150, 100 } };

		fedjfldf(dkfkdfdf, dhfdf);
	}

	@Override
	public void sdfsf() {

		super.sdfsf();

		if (uamciqr.getx() > 100 && !ohvzoob.isShaking()) {
			eventQuake = blockInput = true;
			eventCount++;
		}

		if (eventQuake)
			dfdf();

	}

	private void dfdf() {
		eventCount++;
		if (eventCount == 1) {
			uamciqr.stop();
			uamciqr.dfdf(120, uamciqr.gety());
			uamciqr.hdjhfdf(Uamciqr.FJKDLJFDF_DFDF);
			uamciqr.hdjhfdf(Uamciqr.DFJKDJF_DFKDJFDF);
			uamciqr.hdjhfdf(Uamciqr.JDKFJDF_DFJDKF);
			ohvzoob.dfdfd(true, 10);
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
