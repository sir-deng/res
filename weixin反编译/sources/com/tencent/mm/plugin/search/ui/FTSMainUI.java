package com.tencent.mm.plugin.search.ui;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bb.g;
import com.tencent.mm.bb.i;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.kx;
import com.tencent.mm.f.a.se;
import com.tencent.mm.f.a.tq;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.search.ui.i.b;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayout;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FTSMainUI extends FTSBaseVoiceSearchUI implements a {
    long jEJ;
    private Dialog lTm;
    private int mUl;
    int qhN = -1;
    private FTSMainUIEducationLayout qiO;
    private LinearLayout qiP;
    private LinearLayout qiQ;
    private LinearLayout qiR;
    private View qiS;
    private View qiT;
    private h qiU;
    private TextView qiV;
    private TextView qiW;
    private View qiX;
    private View qiY;
    private TextView qiZ;
    private String qja;
    i qjb;
    private Map<String, Integer> qjc = new HashMap();
    private i qjd;
    private b qje = new b() {
        public final void bqU() {
            h a = FTSMainUI.this.qiU;
            String str = a.fEe != null ? a.fEe : "";
            if (FTSMainUI.this.qiU.getVisibility() == 0 && !bi.oN(str) && !FTSMainUI.this.qjc.containsKey(str)) {
                FTSMainUI.this.qjc.put(str, Integer.valueOf(1));
                a = FTSMainUI.this.qiU;
                String str2 = a.iVa != null ? a.iVa : "";
                long currentTimeMillis = System.currentTimeMillis();
                a = FTSMainUI.this.qiU;
                StringBuilder stringBuilder = new StringBuilder("");
                if (a.qiy != null) {
                    for (bem bem : a.qiy) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("|");
                        }
                        stringBuilder.append(bem.wRb);
                    }
                }
                g.a(str, str2, currentTimeMillis, stringBuilder.toString());
            }
        }
    };
    private e qjf = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (kVar.getType() == 1944) {
                FTSMainUI.this.qjb = null;
                if (i != 0 || i2 != 0) {
                    x.w("MicroMsg.FTS.FTSMainUI", "search local page error" + str);
                } else if (FTSMainUI.this.qiS.getVisibility() == 0) {
                    i iVar = (i) kVar;
                    if (FTSMainUI.this.qiU.a(((bgf) iVar.gLB.hnR.hnY).wRU, ((bgf) iVar.gLB.hnR.hnY).vWw, ((bge) iVar.gLB.hnQ.hnY).wRS)) {
                        FTSMainUI.this.qiU.setVisibility(0);
                    }
                }
            }
        }
    };
    private OnClickListener qjg = new OnClickListener() {
        public final void onClick(View view) {
            int optInt;
            String charSequence;
            FTSMainUI fTSMainUI;
            Intent QT;
            Map b;
            try {
                if (view.getTag() != null) {
                    optInt = ((JSONObject) view.getTag()).optInt("businessType");
                    if (optInt == 0) {
                        charSequence = ((TextView) view).getText().toString();
                        if (charSequence.equals(FTSMainUI.this.getString(R.l.eJd))) {
                            optInt = 2;
                        } else if (charSequence.equals(FTSMainUI.this.getString(R.l.eJf))) {
                            optInt = 8;
                        } else if (charSequence.equals(FTSMainUI.this.getString(R.l.eJe))) {
                            optInt = 1;
                        }
                    }
                    if (optInt != 0) {
                        fTSMainUI = FTSMainUI.this;
                        if (System.currentTimeMillis() - fTSMainUI.jEJ > 1000) {
                            fTSMainUI.jEJ = System.currentTimeMillis();
                            if (com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                                x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
                            }
                            g.b(optInt, 14, h.Oz("searchID"));
                            x.i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", Integer.valueOf(optInt), r5);
                            fTSMainUI.aWY();
                            QT = com.tencent.mm.bb.b.QT();
                            QT.putExtra("ftsneedkeyboard", true);
                            QT.putExtra("ftsbizscene", 14);
                            QT.putExtra("ftsType", optInt);
                            b = com.tencent.mm.bb.b.b(14, true, optInt);
                            b.put("sessionId", com.tencent.mm.bb.e.hMt);
                            b.put("subSessionId", com.tencent.mm.bb.e.hMt);
                            QT.putExtra("sessionId", com.tencent.mm.bb.e.hMt);
                            QT.putExtra("subSessionId", com.tencent.mm.bb.e.hMt);
                            QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(b));
                            QT.putExtra("key_load_js_without_delay", true);
                            d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QT);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
            }
            optInt = 0;
            if (optInt == 0) {
                charSequence = ((TextView) view).getText().toString();
                if (charSequence.equals(FTSMainUI.this.getString(R.l.eJd))) {
                    optInt = 2;
                } else if (charSequence.equals(FTSMainUI.this.getString(R.l.eJf))) {
                    optInt = 8;
                } else if (charSequence.equals(FTSMainUI.this.getString(R.l.eJe))) {
                    optInt = 1;
                }
            }
            if (optInt != 0) {
                fTSMainUI = FTSMainUI.this;
                if (System.currentTimeMillis() - fTSMainUI.jEJ > 1000) {
                    fTSMainUI.jEJ = System.currentTimeMillis();
                    if (com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                        g.b(optInt, 14, h.Oz("searchID"));
                        x.i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", Integer.valueOf(optInt), r5);
                        fTSMainUI.aWY();
                        QT = com.tencent.mm.bb.b.QT();
                        QT.putExtra("ftsneedkeyboard", true);
                        QT.putExtra("ftsbizscene", 14);
                        QT.putExtra("ftsType", optInt);
                        b = com.tencent.mm.bb.b.b(14, true, optInt);
                        b.put("sessionId", com.tencent.mm.bb.e.hMt);
                        b.put("subSessionId", com.tencent.mm.bb.e.hMt);
                        QT.putExtra("sessionId", com.tencent.mm.bb.e.hMt);
                        QT.putExtra("subSessionId", com.tencent.mm.bb.e.hMt);
                        QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(b));
                        QT.putExtra("key_load_js_without_delay", true);
                        d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QT);
                        return;
                    }
                    x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
                }
            }
        }
    };
    private c<tq> qjh = new c<tq>() {
        {
            this.xmG = tq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            FTSMainUI.this.qiO.av();
            return false;
        }
    };

    static /* synthetic */ void a(FTSMainUI fTSMainUI, Map map) {
        fTSMainUI.qjd.qit = true;
        String str = fTSMainUI.fEe;
        if (str != null && !bi.oN(str.trim()) && System.currentTimeMillis() - fTSMainUI.jEJ > 1000) {
            fTSMainUI.jEJ = System.currentTimeMillis();
            if (com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                Intent QT = com.tencent.mm.bb.b.QT();
                QT.putExtra("ftsbizscene", 3);
                QT.putExtra("ftsQuery", fTSMainUI.fEe);
                Map b = com.tencent.mm.bb.b.b(3, true, 0);
                b.put("query", fTSMainUI.fEe);
                str = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) b.get("scene")));
                b.put("sessionId", str);
                QT.putExtra("key_session_id", str);
                b.putAll(map);
                QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(b));
                QT.putExtra("key_preload_biz", 3);
                com.tencent.mm.sdk.b.b kxVar = new kx();
                kxVar.fCZ.scene = 0;
                com.tencent.mm.sdk.b.a.xmy.m(kxVar);
                QT.putExtra("ftsInitToSearch", true);
                d.b(fTSMainUI.mController.xRr, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QT);
                g.is(3);
                fTSMainUI.qiS.setEnabled(false);
                return;
            }
            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    static /* synthetic */ void b(FTSMainUI fTSMainUI, final String str) {
        b bVar = fTSMainUI.qjd;
        bVar.qit = true;
        if (!bi.oN(bVar.fEe)) {
            g.d(bVar.fEe, bVar.qhJ, 1, 3);
        }
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            fTSMainUI.qhN = Character.isDigit(str.charAt(0)) ? 15 : 3;
            final e anonymousClass11 = new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    int i3 = true;
                    as.CN().b(106, (e) this);
                    if (i == 4 && i2 == -4) {
                        ah.y(new Runnable() {
                            public final void run() {
                                if (FTSMainUI.this.lTm != null) {
                                    FTSMainUI.this.lTm.dismiss();
                                    FTSMainUI.this.lTm = null;
                                }
                            }
                        });
                        com.tencent.mm.ui.base.h.a(FTSMainUI.this, R.l.dDo, 0, true, null);
                        return;
                    }
                    ah.y(/* anonymous class already generated */);
                    if (i == 0 && i2 == 0) {
                        bfr Sv = ((ac) kVar).Sv();
                        Intent intent;
                        if (((bi.oN(Sv.wfM.wRo) ? 0 : 1) + Sv.wrp) + Sv.wRJ > 1) {
                            try {
                                intent = new Intent();
                                intent.putExtra("result", Sv.toByteArray());
                                com.tencent.mm.plugin.search.a.ihN.w(intent, FTSMainUI.this.mController.xRr);
                                return;
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.FTS.FTSMainUI", e, "", new Object[0]);
                                return;
                            }
                        } else if (bi.oM(n.a(Sv.wfM)).length() > 0) {
                            if (2 == Sv.wRE) {
                                FTSMainUI.this.qhN = 15;
                            } else if (1 == Sv.wRE) {
                                FTSMainUI.this.qhN = 1;
                            }
                            intent = new Intent();
                            com.tencent.mm.pluginsdk.ui.tools.c.a(intent, Sv, FTSMainUI.this.qhN);
                            if (FTSMainUI.this.qhN == 15) {
                                intent.putExtra("Contact_Search_Mobile", str.trim());
                            }
                            intent.putExtra("add_more_friend_search_scene", 2);
                            com.tencent.mm.plugin.search.a.ihN.d(intent, FTSMainUI.this);
                            return;
                        } else if (!Sv.wRK.isEmpty()) {
                            Intent intent2 = new Intent();
                            bgg bgg = (bgg) Sv.wRK.getFirst();
                            if (2 == bgg.wRE) {
                                i3 = 15;
                            } else if (1 != bgg.wRE) {
                                i3 = 0;
                            }
                            com.tencent.mm.pluginsdk.ui.tools.c.a(intent2, bgg, i3);
                            com.tencent.mm.plugin.search.a.ihN.d(intent2, FTSMainUI.this);
                            return;
                        } else {
                            return;
                        }
                    }
                    switch (i2) {
                        case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                            com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                            if (eC != null) {
                                com.tencent.mm.ui.base.h.a(FTSMainUI.this, eC.desc, eC.fpg, true, null);
                                break;
                            }
                            break;
                        case -4:
                            Toast.makeText(FTSMainUI.this, FTSMainUI.this.getString(R.l.ejs), 0).show();
                            break;
                    }
                    x.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                }
            };
            as.CN().a(106, anonymousClass11);
            final k acVar = new ac(str, 3);
            as.CN().a(acVar, 0);
            fTSMainUI.getString(R.l.dGZ);
            fTSMainUI.lTm = com.tencent.mm.ui.base.h.a((Context) fTSMainUI, fTSMainUI.getString(R.l.dDr), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(acVar);
                    as.CN().b(106, anonymousClass11);
                    FTSMainUI.this.lTm = null;
                }
            });
        }
    }

    static /* synthetic */ void c(FTSMainUI fTSMainUI) {
        fTSMainUI.qjd.qit = true;
        String str = fTSMainUI.fEe;
        if (str != null && !bi.oN(str.trim()) && System.currentTimeMillis() - fTSMainUI.jEJ > 1000) {
            fTSMainUI.jEJ = System.currentTimeMillis();
            if (com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                Intent QT = com.tencent.mm.bb.b.QT();
                QT.putExtra("ftsbizscene", 3);
                QT.putExtra("ftsQuery", fTSMainUI.fEe);
                QT.putExtra("ftsInitToSearch", true);
                Map b = com.tencent.mm.bb.b.b(3, true, 0);
                try {
                    b.put("query", p.encode(fTSMainUI.fEe, "UTF-8"));
                } catch (Exception e) {
                    b.put("query", fTSMainUI.fEe);
                }
                b.put("sessionId", com.tencent.mm.bb.e.hMt);
                QT.putExtra("sessionId", com.tencent.mm.bb.e.hMt);
                QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(b));
                QT.putExtra("key_preload_biz", 3);
                com.tencent.mm.sdk.b.b kxVar = new kx();
                kxVar.fCZ.scene = 0;
                com.tencent.mm.sdk.b.a.xmy.m(kxVar);
                QT.putExtra("key_load_js_without_delay", true);
                d.b(fTSMainUI.mController.xRr, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QT);
                g.is(3);
                if (!bi.oN(fTSMainUI.fEe)) {
                    g.d(fTSMainUI.fEe, 2, 2, 3);
                }
                fTSMainUI.qiS.setEnabled(false);
                return;
            }
            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.bb.e.hMt = com.tencent.mm.plugin.aj.a.g.zZ(3);
        com.tencent.mm.bb.e.iq(this.mUl);
        this.qiO = (FTSMainUIEducationLayout) findViewById(R.h.cJJ);
        this.qiR = (LinearLayout) findViewById(R.h.cJT);
        this.qiO.p(this.qjg);
        this.qiO.znq = new OnClickListener() {
            public final void onClick(View view) {
                FTSMainUI.this.onClickSnsHotArticle((String) view.getTag());
            }
        };
        this.qiO.cxW();
        com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
        com.tencent.mm.plugin.search.a.c.bqA();
        com.tencent.mm.modelgeo.c.OV().a((a) this, true);
        if (com.tencent.mm.plugin.search.a.c.bqz() == null) {
            finish();
            return;
        }
        com.tencent.mm.plugin.search.a.c.bqz().aOa();
        h.Ao(3);
        com.tencent.mm.sdk.b.a.xmy.a(this.qjh);
        as.CN().a(1944, this.qjf);
    }

    protected final void bqH() {
        switch (getIntent().getIntExtra("from_tab_index", -1)) {
            case 0:
                this.mUl = 1;
                return;
            case 1:
                this.mUl = 2;
                return;
            case 2:
                this.mUl = 3;
                return;
            case 3:
                this.mUl = 4;
                return;
            default:
                this.mUl = 0;
                return;
        }
    }

    protected final boolean bqO() {
        return w.cfS();
    }

    protected final b a(c cVar) {
        this.qjd = new i(cVar, this.mUl, this.qje);
        return this.qjd;
    }

    protected final int getLayoutId() {
        return R.i.djh;
    }

    public final void a(com.tencent.mm.plugin.fts.d.a.b bVar) {
    }

    protected void onDestroy() {
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b gnVar = new gn();
                gnVar.fxx.context = ad.getContext();
                gnVar.fxx.actionCode = 3;
                com.tencent.mm.sdk.b.a.xmy.m(gnVar);
            }
        });
        com.tencent.mm.modelgeo.c.OV().c(this);
        if (com.tencent.mm.plugin.fts.d.h.aOe() != null) {
            com.tencent.mm.plugin.fts.d.h.aOe().aOb();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.qjh);
        as.CN().b(1944, this.qjf);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.sdk.b.b seVar = new se();
        seVar.fKK.fqN = 0;
        com.tencent.mm.sdk.b.a.xmy.m(seVar);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.qiS != null) {
            this.qiS.setEnabled(true);
        }
        if (!bi.oN(this.qja)) {
            this.fEe = this.qja;
            this.qja = null;
        }
        com.tencent.mm.bb.b.QY();
    }

    public void finish() {
        aWY();
        super.finish();
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        x.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2));
        com.tencent.mm.modelgeo.c.OV().c(this);
        return false;
    }

    private void bqV() {
        this.qiO.setVisibility(0);
        this.qiO.av();
    }

    private void bqW() {
        this.qiO.setVisibility(8);
    }

    protected final void bqP() {
        super.bqP();
        bqW();
        this.qiR.setVisibility(8);
    }

    protected final void bqQ() {
        super.bqQ();
        bqV();
        this.qiR.setVisibility(8);
    }

    protected final void bqN() {
        super.bqN();
        bqV();
        this.qiR.setVisibility(8);
    }

    protected final void bqM() {
        super.bqM();
        bqW();
        this.qiR.setVisibility(8);
    }

    protected final void bqL() {
        super.bqL();
        bqW();
        this.qiR.setVisibility(8);
        this.qhV.setVisibility(0);
        this.nBh.setVisibility(8);
    }

    protected final void bqK() {
        super.bqK();
        bqW();
        this.qiR.setVisibility(8);
    }

    public final View awb() {
        if (this.qiP == null) {
            this.qiP = (LinearLayout) getLayoutInflater().inflate(R.i.dje, null);
            this.qiV = (TextView) this.qiP.findViewById(R.h.cJW);
            this.qiW = (TextView) this.qiP.findViewById(R.h.ckl);
            try {
                x.i("MicroMsg.FTS.FTSMainUI", "set searchNetworkTips %s", h.Oy("webSearchBar").optString("wording"));
                this.qiW.setText(r0);
            } catch (Exception e) {
            }
            this.qiT = this.qiP.findViewById(R.h.cJU);
            this.qiS = this.qiP.findViewById(R.h.cJV);
            this.qiS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    FTSMainUI.c(FTSMainUI.this);
                }
            });
            this.qiU = new h(this);
            this.qiU.qix = new h.b() {
                public final void a(bem bem, String str, int i) {
                    String str2 = FTSMainUI.this.fEe;
                    if (bem.nne == 1) {
                        FTSMainUI.this.qja = FTSMainUI.this.fEe;
                        FTSMainUI.this.fEe = bem.wRb;
                        Map hashMap = new HashMap();
                        hashMap.put("prefixSug", FTSMainUI.this.qja);
                        hashMap.put("sugId", str);
                        hashMap.put("sceneActionType", "6");
                        FTSMainUI.a(FTSMainUI.this, hashMap);
                    } else if (bem.nne == 4 && !bi.oN(bem.nkN)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", bem.nkN);
                        intent.putExtra("convertActivityFromTranslucent", false);
                        d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    g.b(str2, str, i, bem.wRb);
                }
            };
            int indexOfChild = this.qiP.indexOfChild(this.qiS);
            if (indexOfChild >= 0 && indexOfChild < this.qiP.getChildCount()) {
                this.qiP.addView(this.qiU, indexOfChild + 1);
            }
            this.qiZ = (TextView) this.qiP.findViewById(R.h.cJD);
            this.qiY = this.qiP.findViewById(R.h.cJB);
            this.qiX = this.qiP.findViewById(R.h.cJC);
            this.qiX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    FTSMainUI.b(FTSMainUI.this, FTSMainUI.this.fEe);
                }
            });
            this.qiQ = (LinearLayout) this.qiP.findViewById(R.h.cja);
        }
        return this.qiP;
    }

    public final boolean pc(String str) {
        return super.pc(str);
    }

    protected final void bqR() {
        if (this.qiQ != null) {
            this.qiQ.setVisibility(0);
        }
    }

    protected final void bqS() {
        if (this.qiQ != null) {
            this.qiQ.setVisibility(8);
        }
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
        super.a(z, strArr, j, i);
        if (z) {
            d.a((Context) this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", strArr).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
            return;
        }
        d.a((Context) this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", new String[0]).putExtra("VoiceSearchResultUI_Error", this.mController.xRr.getString(R.l.eiR)).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
    }

    public final void I(int i, boolean z) {
        super.I(i, z);
        this.qiU.setVisibility(8);
        if (this.qjb != null) {
            as.CN().c(this.qjb);
            this.qjb = null;
        }
        if (!z && i == 0 && this.qjd.qiK) {
            this.qiR.setVisibility(0);
        } else {
            this.qiR.setVisibility(8);
        }
        if (z) {
            boolean Jv = com.tencent.mm.plugin.search.a.b.Jv(this.fEe);
            boolean Jw = com.tencent.mm.plugin.search.a.b.Jw(this.fEe);
            if (i > 0) {
                if (Jv || Jw) {
                    this.qiY.setVisibility(0);
                }
                this.qiT.setVisibility(0);
            } else {
                this.qiY.setVisibility(8);
                if (Jv || Jw) {
                    this.qiT.setVisibility(0);
                } else {
                    this.qiT.setVisibility(8);
                }
            }
            if (Jv || Jw) {
                this.qiX.setVisibility(0);
            }
            this.qiS.setVisibility(0);
            if (this.fEe != null && this.fEe.length() > 0) {
                this.qjb = new i(this.fEe);
                as.CN().a(this.qjb, 0);
                return;
            }
            return;
        }
        this.qiS.setVisibility(8);
        this.qiX.setVisibility(8);
    }

    protected final void bqE() {
        super.bqE();
        this.qiV.setText(com.tencent.mm.pluginsdk.ui.d.i.c(this, f.a(getString(R.l.ekU), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fEe, this.fEe)).mVW, com.tencent.mm.bu.a.aa(this, R.f.bvL)));
        CharSequence charSequence = null;
        if (com.tencent.mm.plugin.search.a.b.Jv(this.fEe)) {
            charSequence = f.a(getString(R.l.ekE), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fEe, this.fEe)).mVW;
        } else if (com.tencent.mm.plugin.search.a.b.Jw(this.fEe)) {
            charSequence = f.a(getString(R.l.ekF), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fEe, this.fEe)).mVW;
        }
        this.qiZ.setText(com.tencent.mm.pluginsdk.ui.d.i.c(this, charSequence, com.tencent.mm.bu.a.aa(this, R.f.bvL)));
    }

    public void onClickSnsHotArticle(String str) {
        if (System.currentTimeMillis() - this.jEJ > 1000) {
            this.jEJ = System.currentTimeMillis();
            if (com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                Intent QT = com.tencent.mm.bb.b.QT();
                QT.putExtra("ftsbizscene", 15);
                QT.putExtra("ftsQuery", str);
                QT.putExtra("title", str);
                QT.putExtra("isWebwx", str);
                QT.putExtra("ftscaneditable", false);
                Map b = com.tencent.mm.bb.b.b(15, false, 2);
                b.put("query", str);
                b.put("sceneActionType", "2");
                QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(b));
                com.tencent.mm.sdk.b.b kxVar = new kx();
                kxVar.fCZ.scene = 0;
                com.tencent.mm.sdk.b.a.xmy.m(kxVar);
                QT.putExtra("ftsInitToSearch", true);
                d.b(this.mController.xRr, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", QT);
                g.u(15, str);
                return;
            }
            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }
}
