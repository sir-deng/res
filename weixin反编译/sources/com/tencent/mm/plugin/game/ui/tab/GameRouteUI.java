package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.aq;
import com.tencent.mm.plugin.game.c.bp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.as;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.io.IOException;
import java.util.List;

@a(19)
public class GameRouteUI extends GameCenterActivity {
    private int niV;

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        initView();
        this.niV = getIntent().getIntExtra("game_report_from_scene", 0);
        bp aSw = aSw();
        if (aSw == null || bi.cC(aSw.nmz)) {
            as.a(new as.a() {
                public final void b(bp bpVar) {
                    if (bpVar == null || bi.cC(bpVar.nmz)) {
                        x.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
                        GameRouteUI.this.exit();
                        return;
                    }
                    GameRouteUI.this.e(bpVar.nmz, false);
                }
            });
            return;
        }
        x.i("MicroMsg.GameRouteUI", "use cache data");
        as.a(null);
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        getIntent().removeExtra("switch_country_no_anim");
        List list = aSw.nmz;
        if (!booleanExtra) {
            z = true;
        }
        e(list, z);
    }

    protected final int getLayoutId() {
        return R.i.dll;
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameRouteUI.this.exit();
                return true;
            }
        });
        setMMTitle(R.l.enu);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        exit();
        return true;
    }

    protected final boolean aRX() {
        return false;
    }

    public final int aRY() {
        return 0;
    }

    public final int aRZ() {
        return 0;
    }

    public final int aSa() {
        return 0;
    }

    private void exit() {
        if (!isFinishing() && !isDestroyed()) {
            finish();
            overridePendingTransition(MMFragmentActivity.a.xSN, MMFragmentActivity.a.xSO);
        }
    }

    private void e(List<aq> list, boolean z) {
        if (!isFinishing() && !isDestroyed()) {
            Parcelable aX = GameTabData.aX(list);
            if (aX == null || bi.cC(aX.aRD())) {
                x.e("MicroMsg.GameRouteUI", "game tab data is null");
                exit();
                return;
            }
            List aRD = aX.aRD();
            int i = 0;
            TabItem tabItem = null;
            while (i < aRD.size()) {
                TabItem tabItem2;
                TabItem tabItem3 = (TabItem) aRD.get(i);
                if (tabItem3 != null) {
                    if (tabItem3.njR) {
                        tabItem2 = tabItem3;
                    } else {
                        tabItem2 = tabItem;
                    }
                    ap.a((Context) this, 18, tabItem3.fGe, tabItem3.njZ, null, this.niV, ap.CD(tabItem3.ngQ));
                } else {
                    tabItem2 = tabItem;
                }
                i++;
                tabItem = tabItem2;
            }
            if (tabItem == null) {
                tabItem = (TabItem) aRD.get(0);
            }
            if (tabItem == null) {
                x.e("MicroMsg.GameRouteUI", "game tab entry item is null");
                exit();
                return;
            }
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putParcelable("tab_data", aX);
            getIntent().putExtras(extras);
            GameTabWidget.a(this, tabItem, z, true, true);
        }
    }

    private static bp aSw() {
        byte[] CC = SubCoreGameCenter.aRO().CC("game_index4_tab_nav");
        if (bi.by(CC)) {
            return null;
        }
        try {
            bp bpVar = new bp();
            try {
                bpVar.aH(CC);
                return bpVar;
            } catch (IOException e) {
                return bpVar;
            }
        } catch (IOException e2) {
            return null;
        }
    }
}
