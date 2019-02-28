package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.c.br;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.bb;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public class GameDownloadGuidanceUI extends GameCenterBaseUI implements e {
    private Dialog lTm;
    private LinearLayout mAt;
    private br njk;
    private boolean nsK;
    private String nsL = "";
    private TextView nvm;
    private TextView nvn;
    private TextView nvo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(2586, (e) this);
        initView();
        c.Dt().F(new Runnable() {
            public final void run() {
                byte[] CC = SubCoreGameCenter.aRO().CC("pb_download_guidance");
                if (CC == null) {
                    ah.y(new Runnable() {
                        public final void run() {
                            if (!GameDownloadGuidanceUI.this.isFinishing()) {
                                GameDownloadGuidanceUI.this.lTm = c.cS(GameDownloadGuidanceUI.this);
                                GameDownloadGuidanceUI.this.lTm.show();
                            }
                        }
                    });
                } else {
                    final com.tencent.mm.plugin.game.model.ah ahVar = new com.tencent.mm.plugin.game.model.ah(CC);
                    ah.y(new Runnable() {
                        public final void run() {
                            try {
                                GameDownloadGuidanceUI.this.a(ahVar, 1);
                            } catch (Exception e) {
                                x.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", e.getMessage());
                                GameDownloadGuidanceUI.this.finish();
                            }
                        }
                    });
                }
                as.CN().a(new bb(w.cfV(), g.aQE(), GameDownloadGuidanceUI.this.nsd, GameDownloadGuidanceUI.this.nse, GameDownloadGuidanceUI.this.nsf, GameDownloadGuidanceUI.this.nsc), 0);
                g.aQG();
                a.nCD.aSy();
            }
        });
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
        super.onDestroy();
        a.nCD.clearCache();
        as.CN().b(2586, (e) this);
        SubCoreGameCenter.aRQ().clearCache();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameDownloadGuidanceUI.this.finish();
                return true;
            }
        });
        setMMTitle(R.l.enu);
        this.mAt = (LinearLayout) findViewById(R.h.bYH);
        this.nvm = (TextView) findViewById(R.h.cuR);
        this.nvn = (TextView) findViewById(R.h.cKx);
        this.nvo = (TextView) findViewById(R.h.cKq);
    }

    public final void a(com.tencent.mm.plugin.game.model.ah ahVar, int i) {
        if (isFinishing()) {
            x.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
        } else if (ahVar == null || ahVar.aRq() == null) {
            x.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
        } else {
            if (ahVar == null || ahVar.aRr() == null) {
                this.nsL = "";
            } else {
                this.nsL = ahVar.aRr().nkN;
            }
            if (bi.oN(this.nsL)) {
                if (this.nsK) {
                    removeOptionMenu(0);
                    this.nsK = false;
                }
            } else if (!this.nsK) {
                addIconOptionMenu(0, R.k.dvn, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        ap.a(GameDownloadGuidanceUI.this.mController.xRr, 10, 1008, AuthorizedGameListUI.nqv, c.ac(GameDownloadGuidanceUI.this.mController.xRr, GameDownloadGuidanceUI.this.nsL), GameDownloadGuidanceUI.this.niV, null);
                        return true;
                    }
                });
                this.nsK = true;
            }
            this.mAt.setVisibility(0);
            q aRq = ahVar.aRq();
            if (bi.oN(aRq.nlJ)) {
                this.nvm.setVisibility(8);
            } else {
                this.nvm.setText(aRq.nlJ);
                this.nvm.setVisibility(0);
            }
            if (bi.oN(aRq.nlK)) {
                this.nvn.setVisibility(8);
            } else {
                this.nvn.setText(aRq.nlK);
                this.nvn.setVisibility(0);
            }
            if (bi.oN(aRq.nlL)) {
                this.nvo.setVisibility(8);
            } else {
                this.nvo.setText(aRq.nlL);
                this.nvo.setVisibility(0);
            }
            if (i == 2) {
                c.Dt().F(new Runnable() {
                    public final void run() {
                        SubCoreGameCenter.aRO().a("pb_over_sea", GameDownloadGuidanceUI.this.njk);
                    }
                });
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dkB;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.hashCode()));
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 2586:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final a aVar = ((bb) kVar).lSH.hnR.hnY;
                    c.Dt().F(new Runnable() {
                        public final void run() {
                            if (aVar == null) {
                                GameDownloadGuidanceUI.this.njk = new br();
                            } else {
                                GameDownloadGuidanceUI.this.njk = (br) aVar;
                            }
                            final com.tencent.mm.plugin.game.model.ah ahVar = new com.tencent.mm.plugin.game.model.ah(aVar);
                            ah.y(new Runnable() {
                                public final void run() {
                                    try {
                                        GameDownloadGuidanceUI.this.a(ahVar, 2);
                                    } catch (Exception e) {
                                        x.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", e.getMessage());
                                        GameDownloadGuidanceUI.this.finish();
                                    }
                                    if (GameDownloadGuidanceUI.this.lTm != null) {
                                        GameDownloadGuidanceUI.this.lTm.dismiss();
                                    }
                                    x.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                }
                            });
                        }
                    });
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.a.a.ihO.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.emK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lTm != null) {
            this.lTm.cancel();
        }
    }
}
