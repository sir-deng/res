package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.ap;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameCenterUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.GameCenterUI", "onCreate");
        if (getIntent().getBooleanExtra("game_check_float", false)) {
            int intExtra = getIntent().getIntExtra("game_sourceScene", 0);
            SubCoreGameCenter.aRL();
            t aQW = w.aQW();
            if (aQW != null) {
                aQW.aQT();
                if (!bi.oN(aQW.nij.url)) {
                    c.a(getBaseContext(), aQW, "game_center_h5_floatlayer");
                }
            }
            c.a(aQW, intExtra);
            finish();
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        i aQI = i.aQI();
        ap apVar = null;
        if (aQI.nho != null) {
            apVar = aQI.nho.nnq;
            if (apVar != null) {
                x.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", Integer.valueOf(apVar.nmk), apVar.nkN);
            }
        } else {
            aQI.XQ();
        }
        if (apVar != null) {
            Intent intent;
            Bundle extras;
            switch (apVar.nmk) {
                case 0:
                    fL(booleanExtra);
                    break;
                case 1:
                    if (!bi.oN(apVar.nkN)) {
                        CM(apVar.nkN);
                        break;
                    } else {
                        fL(booleanExtra);
                        break;
                    }
                case 2:
                    intent = new Intent(this, GameOverSeaCenterUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(R.a.bqe, R.a.bqe);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.xSL, MMFragmentActivity.a.xSM);
                    }
                    rl(6);
                    break;
                case 3:
                    intent = new Intent(this, GameDownloadGuidanceUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(R.a.bqe, R.a.bqe);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.xSL, MMFragmentActivity.a.xSM);
                    }
                    rl(6);
                    break;
            }
        }
        fL(booleanExtra);
        finish();
    }

    private void fL(boolean z) {
        if (bi.chp()) {
            x.i("MicroMsg.GameCenterUI", "GP version");
        } else {
            b.a rd = b.rd(getIntent().getIntExtra("game_report_from_scene", 0));
            if (rd.fEo == 2 && !bi.oN(rd.url)) {
                CM(rd.url);
                return;
            }
        }
        Intent intent = new Intent(this, GameRouteUI.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
        if (z) {
            overridePendingTransition(R.a.bqe, R.a.bqe);
        } else {
            overridePendingTransition(MMFragmentActivity.a.xSL, MMFragmentActivity.a.xSM);
        }
        rl(6);
    }

    private void CM(String str) {
        rl(7);
        Intent intent = getIntent();
        if (this != null && !bi.oN(str) && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
            int intExtra = intent.getIntExtra("game_report_from_scene", 0);
            SubCoreGameCenter.aRL();
            t aQW = w.aQW();
            String a = p.a(str, aQW);
            if (booleanExtra) {
                p.a(this, a, "game_center_entrance", true, aQW, intExtra);
                SubCoreGameCenter.aRL();
                w.aQV();
            } else {
                p.a(this, a, "game_center_entrance", false, aQW, intExtra);
            }
            finish();
        }
    }

    private void rl(int i) {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
            SubCoreGameCenter.aRL();
            t aQU = w.aQU();
            if (aQU == null) {
                com.tencent.mm.plugin.game.model.ap.a((Context) this, 9, 901, 1, i, 0, com.tencent.mm.plugin.game.model.ap.cS("resource", "0"));
                return;
            }
            aQU.aQT();
            int i2 = aQU.field_msgType;
            if (aQU.field_msgType == 100) {
                i2 = aQU.niA;
            }
            com.tencent.mm.plugin.game.model.ap.a((Context) this, 9, 901, 1, i, 0, aQU.field_appId, 0, i2, aQU.field_gameMsgId, aQU.niB, com.tencent.mm.plugin.game.model.ap.cS("resource", String.valueOf(aQU.nhU.niI)));
            SubCoreGameCenter.aRL();
            w.aQV();
        }
    }
}
