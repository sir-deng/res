package com.tencent.mm.plugin.search.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bb.b;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.ag;
import com.tencent.mm.f.a.kx;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.y.as;
import java.util.List;
import java.util.Map;

public class FTSAddFriendUI extends FTSBaseUI {
    private long jEJ;
    private Dialog lTm;
    private String mAq = "";
    private bfr mfB;
    private View qhA;
    private ImageView qhB;
    private TextView qhC;
    private TextView qhD;
    private TextView qhE;
    private TextView qhF;
    private TextView qhG;
    private boolean qhH;
    protected boolean qhI;
    private int qhJ = 1;
    private a qhK;
    private int qhL;
    private int qhM;
    int qhN = -1;
    private View qhv;
    private View qhw;
    private View qhx;
    private View qhy;
    private View qhz;

    static /* synthetic */ void a(FTSAddFriendUI fTSAddFriendUI) {
        String str = fTSAddFriendUI.fEe;
        if (str != null && !bi.oN(str.trim()) && System.currentTimeMillis() - fTSAddFriendUI.jEJ > 1000) {
            fTSAddFriendUI.jEJ = System.currentTimeMillis();
            if (g.Ae(0)) {
                if (!bi.oN(fTSAddFriendUI.fEe)) {
                    fTSAddFriendUI.qhI = true;
                    com.tencent.mm.bb.g.d(fTSAddFriendUI.fEe, 2, 2, 16);
                }
                Intent QT = b.QT();
                QT.putExtra("ftsbizscene", 16);
                QT.putExtra("ftsQuery", fTSAddFriendUI.fEe);
                Map b = b.b(16, true, 0);
                b.put("query", fTSAddFriendUI.fEe);
                str = g.zZ(bi.Wo((String) b.get("scene")));
                b.put("sessionId", str);
                QT.putExtra("sessionId", str);
                QT.putExtra("rawUrl", b.r(b));
                com.tencent.mm.sdk.b.b kxVar = new kx();
                kxVar.fCZ.scene = 0;
                a.xmy.m(kxVar);
                QT.putExtra("ftsInitToSearch", true);
                QT.putExtra("key_load_js_without_delay", true);
                d.b(fTSAddFriendUI.mController.xRr, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QT);
                com.tencent.mm.bb.g.is(16);
                return;
            }
            x.e("MicroMsg.FTS.FTSAddFriendUI", "fts h5 template not avail");
        }
    }

    static /* synthetic */ void g(FTSAddFriendUI fTSAddFriendUI) {
        final com.tencent.mm.sdk.b.b agVar = new ag();
        agVar.foU.context = fTSAddFriendUI;
        agVar.foU.fromScene = 16;
        agVar.foU.foW = fTSAddFriendUI.fEe;
        agVar.foU.foY = false;
        agVar.foU.title = fTSAddFriendUI.getString(R.l.dfg);
        agVar.foU.foX = 1;
        Runnable anonymousClass6 = new Runnable() {
            public final void run() {
                FTSAddFriendUI.this.bqG();
                if (agVar.foV.fpa) {
                    FTSAddFriendUI.this.qhM = 1;
                } else {
                    FTSAddFriendUI.this.qhM = -1;
                }
                FTSAddFriendUI.h(FTSAddFriendUI.this);
            }
        };
        agVar.foU.foZ = anonymousClass6;
        agVar.foU.action = 1;
        if (!a.xmy.m(agVar)) {
            agVar.foV.fpa = false;
            anonymousClass6.run();
        }
    }

    static /* synthetic */ void h(FTSAddFriendUI fTSAddFriendUI) {
        if (fTSAddFriendUI.qhL != 0 && fTSAddFriendUI.qhM != 0) {
            fTSAddFriendUI.bqG();
            if (fTSAddFriendUI.qhL <= 0 || fTSAddFriendUI.qhM >= 0) {
                if (fTSAddFriendUI.qhL > 0) {
                    bfr bfr = fTSAddFriendUI.mfB;
                    String a = n.a(bfr.wfM);
                    CharSequence a2 = n.a(bfr.wzM);
                    CharSequence charSequence = bfr.hxh;
                    fTSAddFriendUI.qhV.setVisibility(8);
                    fTSAddFriendUI.qhv.setVisibility(0);
                    fTSAddFriendUI.qhw.setVisibility(0);
                    fTSAddFriendUI.qhA.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (!bi.oN(FTSAddFriendUI.this.fEe)) {
                                FTSAddFriendUI.this.qhI = true;
                                com.tencent.mm.bb.g.d(FTSAddFriendUI.this.fEe, FTSAddFriendUI.this.qhJ, 1, 16);
                            }
                            FTSAddFriendUI.this.bqF();
                        }
                    });
                    fTSAddFriendUI.qhC.setText(a2);
                    fTSAddFriendUI.qhD.setText(charSequence);
                    com.tencent.mm.pluginsdk.ui.a.b.a(fTSAddFriendUI.qhB, a);
                    fTSAddFriendUI.qhx.setVisibility(8);
                    fTSAddFriendUI.qhy.setVisibility(8);
                    fTSAddFriendUI.qhz.setVisibility(8);
                } else {
                    fTSAddFriendUI.qhV.setVisibility(8);
                    fTSAddFriendUI.qhv.setVisibility(0);
                    fTSAddFriendUI.qhw.setVisibility(8);
                    fTSAddFriendUI.qhx.setVisibility(0);
                    fTSAddFriendUI.qhy.setVisibility(8);
                    fTSAddFriendUI.qhz.setVisibility(8);
                }
                if (fTSAddFriendUI.qhM > 0) {
                    fTSAddFriendUI.qhy.setVisibility(0);
                    fTSAddFriendUI.qhz.setVisibility(0);
                    fTSAddFriendUI.qhE.setText(f.a(fTSAddFriendUI.getString(R.l.ekU), "", com.tencent.mm.plugin.fts.d.b.a.d(fTSAddFriendUI.fEe, fTSAddFriendUI.fEe)).mVW);
                    fTSAddFriendUI.qhJ = 2;
                    fTSAddFriendUI.qhz.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            FTSAddFriendUI.a(FTSAddFriendUI.this);
                        }
                    });
                    return;
                }
                fTSAddFriendUI.qhy.setVisibility(8);
                fTSAddFriendUI.qhz.setVisibility(8);
                return;
            }
            fTSAddFriendUI.qhI = true;
            fTSAddFriendUI.bqF();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qhv = findViewById(R.h.bXh);
        this.qhw = findViewById(R.h.coi);
        this.qhA = findViewById(R.h.bXi);
        this.qhx = findViewById(R.h.cAy);
        this.qhy = findViewById(R.h.cvX);
        this.qhz = findViewById(R.h.cJG);
        this.qhB = (ImageView) findViewById(R.h.bXg);
        this.qhC = (TextView) findViewById(R.h.bYw);
        this.qhD = (TextView) findViewById(R.h.bXl);
        this.qhE = (TextView) findViewById(R.h.cKk);
        this.qhF = (TextView) findViewById(R.h.bXm);
        this.qhG = (TextView) findViewById(R.h.cJH);
        try {
            x.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", h.Oy("webSearchBar").optString("wording"));
            this.qhG.setText(r0);
        } catch (Exception e) {
        }
        this.mController.contentView.postDelayed(new Runnable() {
            public final void run() {
                FTSAddFriendUI.this.qhY.znx.cxS();
                FTSAddFriendUI.this.qhY.znx.cxR();
            }
        }, 128);
    }

    protected final b a(c cVar) {
        if (this.qhK == null) {
            this.qhK = new a(cVar);
        }
        return this.qhK;
    }

    public final void a(com.tencent.mm.plugin.fts.d.a.b bVar) {
        if (bVar instanceof com.tencent.mm.plugin.search.ui.a.a) {
            this.mAq = bVar.mRM.mRl;
            Jx(bVar.mRM.mRl);
        }
    }

    public final void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView.b bVar) {
        super.a(str, str2, list, bVar);
        this.qhH = false;
    }

    public final boolean als() {
        Jx(this.fEe);
        aWY();
        return true;
    }

    protected final int getLayoutId() {
        return R.i.diQ;
    }

    protected final void bqE() {
        super.bqE();
        this.qhv.setVisibility(8);
    }

    protected final void stopSearch() {
        super.stopSearch();
        this.qhv.setVisibility(8);
    }

    private void bqF() {
        int i = 15;
        if (bi.oM(n.a(this.mfB.wfM)).length() > 0) {
            if (2 == this.mfB.wRE) {
                this.qhN = 15;
            } else if (1 == this.mfB.wRE) {
                this.qhN = 1;
            }
            Intent intent = new Intent();
            c.a(intent, this.mfB, this.qhN);
            if (this.qhN == 15 && 2 == this.mfB.wRE) {
                intent.putExtra("Contact_Search_Mobile", this.mAq.trim());
            }
            intent.putExtra("add_more_friend_search_scene", 2);
            com.tencent.mm.plugin.search.a.ihN.d(intent, (Context) this);
        } else if (!this.mfB.wRK.isEmpty()) {
            Intent intent2 = new Intent();
            bgg bgg = (bgg) this.mfB.wRK.getFirst();
            if (2 != bgg.wRE) {
                if (1 == bgg.wRE) {
                    i = 1;
                } else {
                    i = 0;
                }
            }
            c.a(intent2, bgg, i);
            com.tencent.mm.plugin.search.a.ihN.d(intent2, (Context) this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qhH && !this.qhI) {
            com.tencent.mm.bb.g.d(this.fEe, this.qhJ, 3, 16);
        }
    }

    private void Jx(String str) {
        this.qhH = true;
        this.qhI = false;
        this.qhJ = 1;
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            this.qhN = Character.isDigit(str.charAt(0)) ? 15 : 3;
            final e anonymousClass4 = new e() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.ad.k r9) {
                    /*
                    r5 = this;
                    r1 = 0;
                    r2 = 1;
                    r0 = com.tencent.mm.y.as.CN();
                    r3 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
                    r0.b(r3, r5);
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r0.bqG();
                    if (r6 != 0) goto L_0x0014;
                L_0x0012:
                    if (r7 == 0) goto L_0x0066;
                L_0x0014:
                    switch(r7) {
                        case -24: goto L_0x0048;
                        case -4: goto L_0x0033;
                        default: goto L_0x0017;
                    };
                L_0x0017:
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r0 = r0.qhF;
                    r1 = com.tencent.mm.R.l.eyn;
                    r0.setText(r1);
                L_0x0022:
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r1 = -1;
                    r0.qhL = r1;
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r0.qhM = r2;
                L_0x002d:
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    com.tencent.mm.plugin.search.ui.FTSAddFriendUI.h(r0);
                L_0x0032:
                    return;
                L_0x0033:
                    r0 = 4;
                    if (r6 == r0) goto L_0x0017;
                L_0x0036:
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r0 = r0.qhF;
                    r1 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r3 = com.tencent.mm.R.l.ejs;
                    r1 = r1.getString(r3);
                    r0.setText(r1);
                    goto L_0x0022;
                L_0x0048:
                    r0 = com.tencent.mm.g.a.eC(r8);
                    if (r0 == 0) goto L_0x005a;
                L_0x004e:
                    r1 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r1 = r1.qhF;
                    r0 = r0.desc;
                    r1.setText(r0);
                    goto L_0x0022;
                L_0x005a:
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r0 = r0.qhF;
                    r1 = com.tencent.mm.R.l.eyn;
                    r0.setText(r1);
                    goto L_0x0022;
                L_0x0066:
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r9 = (com.tencent.mm.modelsimple.ac) r9;
                    r3 = r9.Sv();
                    r0.mfB = r3;
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r0 = r0.mfB;
                    r0 = r0.wfM;
                    r0 = r0.wRo;
                    r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                    if (r0 == 0) goto L_0x00d0;
                L_0x0081:
                    r0 = r1;
                L_0x0082:
                    r3 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r3 = r3.mfB;
                    r3 = r3.wrp;
                    r0 = r0 + r3;
                    r3 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r3 = r3.mfB;
                    r3 = r3.wRJ;
                    r0 = r0 + r3;
                    if (r0 <= r2) goto L_0x00c4;
                L_0x0096:
                    r0 = new android.content.Intent;	 Catch:{ IOException -> 0x00b8 }
                    r0.<init>();	 Catch:{ IOException -> 0x00b8 }
                    r3 = "result";
                    r4 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;	 Catch:{ IOException -> 0x00b8 }
                    r4 = r4.mfB;	 Catch:{ IOException -> 0x00b8 }
                    r4 = r4.toByteArray();	 Catch:{ IOException -> 0x00b8 }
                    r0.putExtra(r3, r4);	 Catch:{ IOException -> 0x00b8 }
                    r3 = com.tencent.mm.plugin.search.a.ihN;	 Catch:{ IOException -> 0x00b8 }
                    r4 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;	 Catch:{ IOException -> 0x00b8 }
                    r4 = r4.mController;	 Catch:{ IOException -> 0x00b8 }
                    r4 = r4.xRr;	 Catch:{ IOException -> 0x00b8 }
                    r3.w(r0, r4);	 Catch:{ IOException -> 0x00b8 }
                    goto L_0x0032;
                L_0x00b8:
                    r0 = move-exception;
                    r3 = "MicroMsg.FTS.FTSAddFriendUI";
                    r4 = "";
                    r1 = new java.lang.Object[r1];
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r0, r4, r1);
                L_0x00c4:
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    r0.qhL = r2;
                    r0 = com.tencent.mm.plugin.search.ui.FTSAddFriendUI.this;
                    com.tencent.mm.plugin.search.ui.FTSAddFriendUI.g(r0);
                    goto L_0x002d;
                L_0x00d0:
                    r0 = r2;
                    goto L_0x0082;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.FTSAddFriendUI.4.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
                }
            };
            this.qhL = 0;
            this.qhM = 0;
            as.CN().a(106, anonymousClass4);
            final k acVar = new ac(str, 3);
            as.CN().a(acVar, 0);
            getString(R.l.dGZ);
            this.lTm = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dDr), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(acVar);
                    as.CN().b(106, anonymousClass4);
                    FTSAddFriendUI.this.lTm = null;
                }
            });
        }
    }

    private void bqG() {
        ah.y(new Runnable() {
            public final void run() {
                if (FTSAddFriendUI.this.lTm != null) {
                    FTSAddFriendUI.this.lTm.dismiss();
                    FTSAddFriendUI.this.lTm = null;
                }
            }
        });
    }

    public void onClickBg(View view) {
    }

    public final void cs(View view) {
        super.cs(view);
        if (!this.qhY.znx.yqL.hasFocus()) {
            this.qhY.znx.cxS();
            showVKB();
        }
    }
}
