package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.game.c.ak;
import com.tencent.mm.plugin.game.c.ar;
import com.tencent.mm.plugin.game.c.bn;
import com.tencent.mm.plugin.game.c.ch;
import com.tencent.mm.plugin.game.c.dg;
import com.tencent.mm.plugin.game.c.dl;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.ba;
import com.tencent.mm.plugin.game.model.bj;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public class GameCenterUI5 extends GameCenterBaseUI implements e {
    private Dialog lTm;
    private boolean nsJ = true;
    private GameNewTopBannerView nsT;
    private GameIndexSearchView nsU;
    private GameIndexWxagView nsV;
    private GameMessageBubbleView nsW;
    private GameBlockView nsX;
    private GameRecomBlockView nsY;
    private GameNewClassifyView nsZ;
    private GameIndexListView nta;

    static /* synthetic */ void a(GameCenterUI5 gameCenterUI5, aj ajVar, int i) {
        if (gameCenterUI5.isFinishing()) {
            x.w("MicroMsg.GameCenterUI5", "GameCenterUI5 hasFinished");
        } else if (ajVar == null) {
            x.e("MicroMsg.GameCenterUI5", "Null data");
        } else {
            ImageView imageView;
            TextView textView;
            View view;
            GameNewTopBannerView gameNewTopBannerView = gameCenterUI5.nsT;
            ch chVar = ajVar.njv;
            int i2 = gameCenterUI5.niV;
            boolean z = gameCenterUI5.nsg;
            if (chVar == null || chVar.noJ == null || bi.oN(chVar.noJ.nlY)) {
                GameNewTopBannerView.aSq();
                gameNewTopBannerView.setVisibility(8);
            } else {
                gameNewTopBannerView.niV = i2;
                gameNewTopBannerView.jfO = chVar.noI != null ? ap.CD(chVar.noI.nlr) : null;
                if (!gameNewTopBannerView.nzv.equals(chVar.noJ.nlY)) {
                    gameNewTopBannerView.nzv = chVar.noJ.nlY;
                    com.tencent.mm.plugin.game.d.e.aSC().h(gameNewTopBannerView.nsr, chVar.noJ.nlY);
                    gameNewTopBannerView.nzt = gameNewTopBannerView.b(gameNewTopBannerView.nsr, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvr), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvq));
                    if (gameNewTopBannerView.nzt > 0) {
                        if (i == 2) {
                            ap.a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.niV, 0, null, null, gameNewTopBannerView.jfO);
                        }
                        if (gameNewTopBannerView.nzt <= 0 || chVar.noI == null || bi.oN(chVar.noI.nkM)) {
                            gameNewTopBannerView.nsq.setVisibility(8);
                        } else {
                            com.tencent.mm.plugin.game.d.e.aSC().h(gameNewTopBannerView.nsq, chVar.noI.nkM);
                            gameNewTopBannerView.nzu = gameNewTopBannerView.b(gameNewTopBannerView.nsq, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvo), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.bvq));
                            if (gameNewTopBannerView.nzu > 0) {
                                gameNewTopBannerView.nsq.setVisibility(0);
                                gameNewTopBannerView.nsq.setTag(chVar.noI.nkN);
                                gameNewTopBannerView.nsq.setOnClickListener(gameNewTopBannerView);
                            } else {
                                gameNewTopBannerView.nsq.setVisibility(8);
                            }
                        }
                        if (gameNewTopBannerView.nsq.getVisibility() == 0) {
                            if (chVar.noI.npU == g.cO(gameNewTopBannerView.mContext) || z) {
                                GameIndexListView.rp(gameNewTopBannerView.nzt - gameNewTopBannerView.nzu);
                            } else {
                                gameNewTopBannerView.nsr.setImageAlpha(0);
                                g.D(gameNewTopBannerView.mContext, chVar.noI.npU);
                                GameIndexListView.rp(0);
                            }
                            GameIndexListView.rk(gameNewTopBannerView.nzt - gameNewTopBannerView.nzu);
                            GameIndexListView.fK(true);
                        } else {
                            GameNewTopBannerView.aSq();
                        }
                        gameNewTopBannerView.setVisibility(0);
                    } else {
                        GameNewTopBannerView.aSq();
                        gameNewTopBannerView.setVisibility(8);
                    }
                } else if (i == 2) {
                    ap.a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.niV, 0, null, null, gameNewTopBannerView.jfO);
                }
            }
            ViewGroup viewGroup = gameCenterUI5.nsU;
            ch chVar2 = ajVar.njv;
            int i3 = gameCenterUI5.niV;
            if (chVar2 == null || chVar2.noJ == null || chVar2.noJ.npr == null) {
                viewGroup.setVisibility(8);
            } else {
                viewGroup.removeAllViews();
                dg dgVar = chVar2.noJ.npr;
                viewGroup.setVisibility(0);
                viewGroup.DF.inflate(R.i.dkF, viewGroup, true);
                imageView = (ImageView) viewGroup.findViewById(R.h.cJO);
                textView = (TextView) viewGroup.findViewById(R.h.cKj);
                a aVar = new a();
                if (bi.oN(dgVar.nlA)) {
                    imageView.setVisibility(8);
                } else {
                    com.tencent.mm.plugin.game.d.e.aSC().a(imageView, dgVar.nlA, aVar.aSD());
                }
                if (bi.oN(dgVar.fpg)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(dgVar.fpg);
                }
                viewGroup.setTag(dgVar.nkN);
                viewGroup.setOnClickListener(new com.tencent.mm.plugin.game.ui.GameIndexSearchView.AnonymousClass1(i3));
            }
            ViewGroup viewGroup2 = gameCenterUI5.nsV;
            ar arVar = ajVar.njz;
            int i4 = gameCenterUI5.niV;
            if (arVar == null) {
                viewGroup2.setVisibility(8);
            } else {
                viewGroup2.niV = i4;
                viewGroup2.setVisibility(0);
                viewGroup2.mContainer.removeAllViews();
                if (bi.cC(arVar.nmU) && arVar.nmV == null) {
                    viewGroup2.setVisibility(8);
                } else {
                    int i5;
                    int i6;
                    if (i == 2) {
                        ap.a(viewGroup2.getContext(), 10, 1025, 0, null, i4, ap.CD(arVar.nlr));
                    }
                    viewGroup2.DF.inflate(R.i.djM, viewGroup2, true);
                    TextView textView2 = (TextView) viewGroup2.findViewById(R.h.cZW);
                    LinearLayout linearLayout = (LinearLayout) viewGroup2.findViewById(R.h.cZU);
                    if (bi.oN(arVar.fpg)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(arVar.fpg);
                    }
                    i2 = 0;
                    while (true) {
                        i5 = i2;
                        if (i5 >= 4) {
                            break;
                        }
                        linearLayout.addView((LinearLayout) viewGroup2.DF.inflate(R.i.djL, viewGroup2, false), new LayoutParams(-1, -2, 1.0f));
                        i2 = i5 + 1;
                    }
                    i5 = 0;
                    if (!bi.cC(arVar.nmU)) {
                        i2 = 0;
                        while (true) {
                            int i7 = i2;
                            i6 = i5;
                            if (i7 >= arVar.nmU.size()) {
                                break;
                            }
                            dl dlVar = (dl) arVar.nmU.get(i7);
                            if (!(dlVar == null || dlVar.npy == null || dlVar.npy.nmc == null)) {
                                View childAt = linearLayout.getChildAt(i6);
                                textView = (TextView) childAt.findViewById(R.h.cZV);
                                com.tencent.mm.plugin.game.d.e.aSC().h((ImageView) childAt.findViewById(R.h.cZT), dlVar.npy.nmc.nlA);
                                textView.setText(dlVar.npy.nmc.noG);
                                if (i == 2) {
                                    ap.a(viewGroup2.getContext(), 10, 1025, i6 + 1, dlVar.npy.nmc.nlV, i4, null);
                                }
                                childAt.setTag(new a(i6 + 1, dlVar.npy.nmc));
                                childAt.setOnClickListener(viewGroup2);
                                i6++;
                                if (i6 >= 3) {
                                    break;
                                }
                            }
                            i5 = i6;
                            i2 = i7 + 1;
                        }
                    } else {
                        i6 = 0;
                    }
                    if (arVar.nmV != null) {
                        View childAt2 = linearLayout.getChildAt(i6);
                        textView = (TextView) childAt2.findViewById(R.h.cZV);
                        com.tencent.mm.plugin.game.d.e.aSC().h((ImageView) childAt2.findViewById(R.h.cZT), arVar.nmV.nlA);
                        textView.setText(arVar.nmV.noG);
                        childAt2.setTag(arVar.nmV);
                        childAt2.setOnClickListener(new com.tencent.mm.plugin.game.ui.GameIndexWxagView.AnonymousClass1(i4));
                    }
                    view = new View(viewGroup2.getContext());
                    view.setBackgroundColor(viewGroup2.getContext().getResources().getColor(R.e.bsr));
                    viewGroup2.addView(view, new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(viewGroup2.getContext(), 5)));
                }
            }
            if (gameCenterUI5.nsc) {
                gameCenterUI5.nsW.aSo();
            }
            ViewGroup viewGroup3 = gameCenterUI5.nsX;
            aj.a aVar2 = ajVar.njw;
            i4 = gameCenterUI5.niV;
            if (aVar2 == null) {
                viewGroup3.setVisibility(8);
            } else {
                viewGroup3.nrD.rg(i4);
                viewGroup3.setVisibility(0);
                viewGroup3.mAt.removeAllViews();
                if (aVar2.njs == null || bi.oN(aVar2.njs.field_appId) || bi.oN(aVar2.njs.field_appName)) {
                    viewGroup3.setVisibility(8);
                } else {
                    View findViewById;
                    if (i == 2) {
                        ap.a(viewGroup3.getContext(), 10, 1002, 0, aVar2.njs.field_appId, i4, null);
                    }
                    d dVar = aVar2.njs;
                    a aVar3 = new a();
                    View inflate = viewGroup3.DF.inflate(R.i.djG, viewGroup3.mAt, false);
                    aVar3.nrG = (ViewGroup) inflate.findViewById(R.h.cuW);
                    aVar3.nrs = (ImageView) inflate.findViewById(R.h.cmn);
                    aVar3.nrt = (TextView) inflate.findViewById(R.h.cmX);
                    aVar3.nrH = (TextView) inflate.findViewById(R.h.ckV);
                    aVar3.nrI = (GameDownloadView) inflate.findViewById(R.h.cma);
                    com.tencent.mm.plugin.game.d.e.aSC().a(aVar3.nrs, dVar.field_appId, com.tencent.mm.bu.a.getDensity(viewGroup3.getContext()));
                    CharSequence charSequence = dVar.field_appName;
                    if (!bi.oN(dVar.field_appName) && dVar.field_appName.length() > 8) {
                        charSequence = dVar.field_appName.substring(0, 7) + "...";
                    }
                    aVar3.nrt.setText(charSequence);
                    if (bi.oN(dVar.ngz)) {
                        aVar3.nrH.setVisibility(8);
                    } else {
                        aVar3.nrH.setText(dVar.ngz);
                        aVar3.nrH.setVisibility(0);
                    }
                    aVar3.nrI.a(new o(dVar));
                    aVar3.nrG.setOnClickListener(viewGroup3.nrD);
                    aVar3.nrG.setTag(dVar);
                    viewGroup3.mAt.addView(inflate);
                    view = new g(viewGroup3.getContext());
                    view.a(aVar2.njB, aVar2.njs.field_appId, i, i4);
                    viewGroup3.mAt.addView(view, viewGroup3.nrC);
                    view = new f(viewGroup3.getContext());
                    view.a(aVar2.njA, aVar2.njs.field_appId, i, i4);
                    viewGroup3.mAt.addView(view, viewGroup3.nrC);
                    if (aVar2.njC != null) {
                        imageView = (ImageView) viewGroup3.DF.inflate(R.i.dkl, viewGroup3, false);
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                        marginLayoutParams.leftMargin = com.tencent.mm.bu.a.fromDPToPix(viewGroup3.getContext(), 20);
                        imageView.setLayoutParams(marginLayoutParams);
                        viewGroup3.addView(imageView);
                        viewGroup3.DF.inflate(R.i.djH, viewGroup3, true);
                        findViewById = viewGroup3.findViewById(R.h.cxw);
                        ((TextView) viewGroup3.findViewById(R.h.cxx)).setText(aVar2.njC.nkL);
                        findViewById.setTag(aVar2.njC.nkN);
                        findViewById.setOnClickListener(new com.tencent.mm.plugin.game.ui.GameBlockView.AnonymousClass1(i4));
                    }
                    ViewGroup viewGroup4 = viewGroup3.mAt;
                    findViewById = new View(viewGroup3.getContext());
                    findViewById.setBackgroundColor(viewGroup3.getContext().getResources().getColor(R.e.bsr));
                    viewGroup4.addView(findViewById, new LayoutParams(-1, com.tencent.mm.bu.a.fromDPToPix(viewGroup3.getContext(), 5)));
                }
            }
            GameRecomBlockView gameRecomBlockView = gameCenterUI5.nsY;
            ak akVar = ajVar.njx;
            int i8 = gameCenterUI5.niV;
            if (akVar == null) {
                gameRecomBlockView.setVisibility(8);
            } else {
                gameRecomBlockView.niV = i8;
                gameRecomBlockView.setVisibility(0);
                gameRecomBlockView.a(akVar, i, i8);
            }
            gameCenterUI5.nsZ.a(ajVar.njy, i, gameCenterUI5.niV);
            gameCenterUI5.nta.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (as.Hp()) {
            GameIndexListView.rg(this.niV);
            as.CN().a(2994, (e) this);
            initView();
            c.Dt().F(new Runnable() {
                public final void run() {
                    byte[] CC = SubCoreGameCenter.aRO().CC("pb_index_4");
                    if (CC == null) {
                        ah.y(new Runnable() {
                            public final void run() {
                                if (!GameCenterUI5.this.isFinishing()) {
                                    GameCenterUI5.this.lTm = c.cS(GameCenterUI5.this);
                                    GameCenterUI5.this.lTm.show();
                                }
                            }
                        });
                    } else {
                        final aj ajVar = new aj(CC);
                        ah.y(new Runnable() {
                            public final void run() {
                                GameCenterUI5.a(GameCenterUI5.this, ajVar, 1);
                            }
                        });
                    }
                    SubCoreGameCenter.aRQ().init(GameCenterUI5.this);
                    c.U(g.aQE());
                    as.CN().a(new ba(w.cfV(), g.aQE(), GameCenterUI5.this.nsd, GameCenterUI5.this.nse, GameCenterUI5.this.nsf, GameCenterUI5.this.nsc), 0);
                    g.cM(GameCenterUI5.this.mController.xRr);
                    g.aQG();
                    a.nCD.aSy();
                }
            });
            x.i("MicroMsg.GameCenterUI5", "fromScene = %d", Integer.valueOf(this.niV));
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
        finish();
    }

    public void onResume() {
        super.onResume();
        if (as.Hp()) {
            if (!this.nsJ) {
                SubCoreGameCenter.aRQ().init(this);
                this.nsW.aSp();
                if (this.nsc) {
                    this.nsW.aSo();
                }
            }
            this.nsJ = false;
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
    }

    public void onDestroy() {
        x.i("MicroMsg.GameCenterUI5", "onDestroy");
        super.onDestroy();
        if (as.Hp()) {
            a.nCD.clearCache();
            as.CN().b(2994, (e) this);
            SubCoreGameCenter.aRQ().clearCache();
            bj.aRH();
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameCenterUI5.this.finish();
                return true;
            }
        });
        setMMTitle(R.l.enu);
        this.nta = (GameIndexListView) findViewById(R.h.cme);
        this.nta.setVisibility(8);
        View inflate = getLayoutInflater().inflate(R.i.dkE, this.nta, false);
        this.nta.addHeaderView(inflate);
        this.nsT = (GameNewTopBannerView) inflate.findViewById(R.h.cns);
        this.nsU = (GameIndexSearchView) inflate.findViewById(R.h.cmp);
        this.nsV = (GameIndexWxagView) inflate.findViewById(R.h.cmq);
        this.nsW = (GameMessageBubbleView) inflate.findViewById(R.h.cmS);
        this.nsX = (GameBlockView) inflate.findViewById(R.h.ckJ);
        this.nsY = (GameRecomBlockView) inflate.findViewById(R.h.cng);
        this.nsZ = (GameNewClassifyView) inflate.findViewById(R.h.cmY);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.hashCode()));
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 2994:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bp.a aVar = ((ba) kVar).lSH.hnR.hnY;
                    c.Dt().F(new Runnable() {
                        public final void run() {
                            bn bnVar;
                            if (aVar == null) {
                                bnVar = new bn();
                            } else {
                                bnVar = (bn) aVar;
                                SubCoreGameCenter.aRO().a("pb_index_4", bnVar);
                            }
                            final aj ajVar = new aj(bnVar);
                            ah.y(new Runnable() {
                                public final void run() {
                                    try {
                                        GameCenterUI5.a(GameCenterUI5.this, ajVar, 2);
                                    } catch (Exception e) {
                                        x.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", e.getMessage());
                                        GameCenterUI5.this.finish();
                                    }
                                    if (GameCenterUI5.this.lTm != null) {
                                        GameCenterUI5.this.lTm.dismiss();
                                    }
                                    x.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
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

    protected final int getLayoutId() {
        return R.i.djK;
    }
}
