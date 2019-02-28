package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.plugin.game.c.cf;
import com.tencent.mm.plugin.game.c.dt;
import com.tencent.mm.plugin.game.c.y;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.ui.GameDetailRankUI.a;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2 extends MMActivity implements e {
    private String appId = null;
    private Dialog lTm;
    private d nhC = null;
    private int niV = 0;
    private LinearLayout nuA;
    private TextView nuB;
    private LinearLayout nuC;
    private TextView nuD;
    private LinearLayout nuE;
    private ImageView nuF;
    private View nuG;
    private TextView nuH;
    private TextView nuI;
    private View nuJ;
    private TextView nuK;
    private ImageView nuL;
    private TextView nuM;
    private TextView nuN;
    private LinearLayout nuO;
    private GameMediaList nuP;
    private TextView nuQ;
    private TextView nuR;
    private TextView nuS;
    private boolean nuT = false;
    private LinearLayout nuU;
    private TextView nuV;
    private LinearLayout nuW;
    private TextView nuX;
    private dt nuY;
    private OnClickListener nuZ = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            GameDetailUI2.this.nuq.aQQ();
            GameDetailUI2.this.nup.a(GameDetailUI2.this.nuw, GameDetailUI2.this.nuv, GameDetailUI2.this.nhC, GameDetailUI2.this.nuq);
        }
    };
    private String nuh = null;
    private String nui = null;
    private int nuk = 18;
    private boolean nul;
    private boolean num;
    private String nun = null;
    private b nuo = null;
    private e nup = null;
    private o nuq = null;
    private ViewGroup nur;
    private ImageView nus;
    private ImageView nut;
    private TextView nuu;
    private Button nuv;
    private TextProgressBar nuw;
    private TextView nux;
    private LinearLayout nuy;
    private GameDetailAutoScrollView nuz;
    private View.OnClickListener nva = new View.OnClickListener() {
        public final void onClick(View view) {
            if (GameDetailUI2.this.nhC == null) {
                x.e("MicroMsg.GameDetailUI2", "Null appInfo");
            } else if (GameDetailUI2.this.nuq == null) {
                x.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
            } else {
                GameDetailUI2.this.nuq.cQ(GameDetailUI2.this.mController.xRr);
                GameDetailUI2.this.nup.a(GameDetailUI2.this.nhC, GameDetailUI2.this.nuq);
            }
        }
    };
    private View.OnClickListener nvb = new View.OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof String) {
                c.a(view, GameDetailUI2.this);
                ap.a(GameDetailUI2.this.mController.xRr, 12, 1203, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.niV, null);
                return;
            }
            a aVar = new a();
            aVar.nuh = GameDetailUI2.this.nuh;
            aVar.nui = GameDetailUI2.this.nui;
            aVar.nuj = GameDetailUI2.this.nhC;
            String hC = u.hC("rankData");
            u.GQ().t(hC, true).o(GameDetailRankUI.nuf, aVar);
            Intent intent = new Intent(GameDetailUI2.this.mController.xRr, GameDetailRankUI.class);
            intent.putExtra(GameDetailRankUI.EXTRA_SESSION_ID, hC);
            GameDetailUI2.this.startActivity(intent);
            ap.a(GameDetailUI2.this.mController.xRr, 12, 1203, 999, 6, GameDetailUI2.this.appId, GameDetailUI2.this.niV, null);
        }
    };
    private View.OnClickListener nvc = new View.OnClickListener() {
        public final void onClick(View view) {
            c.a(view, GameDetailUI2.this);
            ap.a(GameDetailUI2.this.mController.xRr, 12, 1204, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.niV, null);
        }
    };
    private View.OnClickListener nvd = new View.OnClickListener() {
        public final void onClick(View view) {
            c.a(view, GameDetailUI2.this);
            ap.a(GameDetailUI2.this.mController.xRr, 12, 1205, 1, 7, GameDetailUI2.this.appId, GameDetailUI2.this.niV, null);
        }
    };
    private View.OnClickListener nve = new View.OnClickListener() {
        public final void onClick(View view) {
            c.a(view, GameDetailUI2.this);
            ap.a(GameDetailUI2.this.mController.xRr, 12, 1205, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.niV, null);
        }
    };
    private View.OnClickListener nvf = new View.OnClickListener() {
        public final void onClick(View view) {
            c.a(view, GameDetailUI2.this);
            ap.a(GameDetailUI2.this.mController.xRr, 12, 1206, 1, 7, GameDetailUI2.this.appId, GameDetailUI2.this.niV, null);
        }
    };

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, final dt dtVar) {
        g gVar = new g(gameDetailUI2.mController.xRr, g.zCt, false);
        gVar.rQF = new p.c() {
            public final void a(n nVar) {
                if (dtVar.npQ) {
                    nVar.a(0, GameDetailUI2.this.getString(R.l.eYt), R.k.dxb);
                }
                if (dtVar.npR) {
                    nVar.a(1, GameDetailUI2.this.getString(R.l.eYu), R.k.dwQ);
                }
            }
        };
        gVar.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        GameDetailUI2.p(GameDetailUI2.this);
                        return;
                    case 1:
                        GameDetailUI2.q(GameDetailUI2.this);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUX();
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, af afVar) {
        if (gameDetailUI2.isFinishing()) {
            x.w("MicroMsg.GameDetailUI2", "GameDetailUI2 hasFinished");
        } else if (afVar == null) {
            x.e("MicroMsg.GameDetailUI2", "Null data");
        } else {
            gameDetailUI2.nhC = afVar.njd;
            String str = afVar.njb.nnE == null ? null : bi.oN(afVar.njb.nnE.npA) ? null : afVar.njb.nnE.npA;
            gameDetailUI2.nuh = str;
            str = afVar.njb.nnE == null ? null : bi.oN(afVar.njb.nnE.npB) ? null : afVar.njb.nnE.npB;
            gameDetailUI2.nui = str;
            if (!gameDetailUI2.num) {
                gameDetailUI2.num = true;
                ap.a(gameDetailUI2, 12, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 0, 1, gameDetailUI2.appId, gameDetailUI2.niV, null);
            }
            d dVar = afVar.njd;
            com.tencent.mm.ap.a.a PG = com.tencent.mm.ap.o.PG();
            String str2 = afVar.njb.nnz;
            ImageView imageView = gameDetailUI2.nus;
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFk = true;
            PG.a(str2, imageView, aVar.PQ());
            ImageView imageView2 = gameDetailUI2.nut;
            str2 = gameDetailUI2.appId;
            float density = com.tencent.mm.bu.a.getDensity(gameDetailUI2);
            if (!(imageView2 == null || bi.oN(str2))) {
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str2, 1, density);
                if (b == null || b.isRecycled()) {
                    imageView2.setImageResource(R.g.bCD);
                    an.biT().c(new com.tencent.mm.plugin.game.ui.k.a.AnonymousClass1(str2, density, imageView2));
                } else {
                    imageView2.setImageBitmap(b);
                }
            }
            gameDetailUI2.nuu.setText(dVar != null ? dVar.field_appName : "");
            if (dVar == null || bi.oN(dVar.ngy)) {
                gameDetailUI2.nux.setVisibility(8);
            } else {
                gameDetailUI2.nux.setText(dVar.ngy);
                gameDetailUI2.nux.setVisibility(0);
            }
            if (gameDetailUI2.nhC == null) {
                gameDetailUI2.nuv.setVisibility(8);
            } else {
                gameDetailUI2.nuv.setVisibility(0);
                if (gameDetailUI2.nup == null) {
                    gameDetailUI2.nup = new e(gameDetailUI2);
                    gameDetailUI2.nup.nre = gameDetailUI2.nuZ;
                    gameDetailUI2.nup.niV = gameDetailUI2.niV;
                    gameDetailUI2.nup.nqO = gameDetailUI2.nun;
                }
                gameDetailUI2.nuv.setOnClickListener(gameDetailUI2.nva);
                gameDetailUI2.nuw.setOnClickListener(gameDetailUI2.nva);
                gameDetailUI2.nuq = new o(gameDetailUI2.nhC);
                gameDetailUI2.nuq.cQ(gameDetailUI2);
                gameDetailUI2.nuq.aQQ();
                gameDetailUI2.nup.a(gameDetailUI2.nuw, gameDetailUI2.nuv, gameDetailUI2.nhC, gameDetailUI2.nuq);
                x.i("MicroMsg.GameDetailUI2", "App Status: %d, Download Mode: %d, Download Status: %d", Integer.valueOf(gameDetailUI2.nhC.status), Integer.valueOf(gameDetailUI2.nuq.mode), Integer.valueOf(gameDetailUI2.nuq.status));
                if (!bi.oN(gameDetailUI2.appId)) {
                    if (gameDetailUI2.nuo != null) {
                        com.tencent.mm.plugin.game.model.n.a(gameDetailUI2.nuo);
                    } else {
                        gameDetailUI2.nuo = new b() {
                            public final void h(int i, String str, boolean z) {
                                if (GameDetailUI2.this.nhC != null) {
                                    GameDetailUI2.this.nuq.cQ(GameDetailUI2.this);
                                    GameDetailUI2.this.nuq.aQQ();
                                    if (z) {
                                        GameDetailUI2.this.nup.a(GameDetailUI2.this.nuw, GameDetailUI2.this.nuv, GameDetailUI2.this.nhC, GameDetailUI2.this.nuq);
                                    }
                                }
                            }
                        };
                        com.tencent.mm.plugin.game.model.n.a(gameDetailUI2.nuo);
                    }
                }
            }
            Collection arrayList = new ArrayList();
            if (afVar.njb.nnF != null) {
                Iterator it = afVar.njb.nnF.iterator();
                while (it.hasNext()) {
                    y yVar = (y) it.next();
                    if (bi.oN(yVar.kyG)) {
                        arrayList.add("");
                    } else {
                        as.Hm();
                        com.tencent.mm.storage.x Xv = com.tencent.mm.y.c.Ff().Xv(yVar.kyG);
                        if (Xv == null || Xv.gKO == 0) {
                            arrayList.add(yVar.kyG + " ");
                        } else {
                            arrayList.add(Xv.AX() + " ");
                        }
                    }
                    arrayList.add(yVar.nlZ);
                }
            }
            if (arrayList.size() != 0) {
                gameDetailUI2.nuz.setVisibility(0);
                GameDetailAutoScrollView gameDetailAutoScrollView = gameDetailUI2.nuz;
                gameDetailAutoScrollView.ntz.clear();
                gameDetailAutoScrollView.nrk.TN();
                if (arrayList.size() == 0 || arrayList.size() % 2 != 0) {
                    gameDetailAutoScrollView.ntA.setVisibility(8);
                    gameDetailAutoScrollView.ntD.setVisibility(8);
                } else {
                    gameDetailAutoScrollView.ntz.addAll(arrayList);
                    gameDetailAutoScrollView.lNI = 0;
                    gameDetailAutoScrollView.ntB.setText(i.b(gameDetailAutoScrollView.getContext(), (CharSequence) gameDetailAutoScrollView.ntz.get(0), gameDetailAutoScrollView.ntB.getTextSize()));
                    gameDetailAutoScrollView.ntC.setText((CharSequence) gameDetailAutoScrollView.ntz.get(1));
                    gameDetailAutoScrollView.ntA.setVisibility(0);
                    gameDetailAutoScrollView.ntD.setVisibility(8);
                    if (gameDetailAutoScrollView.ntz.size() / 2 != 1) {
                        gameDetailAutoScrollView.nrk.K(5000, 5000);
                    }
                }
            } else {
                gameDetailUI2.nuz.setVisibility(8);
            }
            gameDetailUI2.b(afVar.nje);
            CharSequence charSequence = afVar.njb.nnE == null ? null : bi.oN(afVar.njb.nnE.noy) ? null : afVar.njb.nnE.noy;
            String str3 = afVar.njb.nnE == null ? null : bi.oN(afVar.njb.nnE.noz) ? null : afVar.njb.nnE.noz;
            if (bi.oN(charSequence)) {
                gameDetailUI2.nuB.setVisibility(8);
            } else {
                gameDetailUI2.nuB.setText(charSequence);
                if (bi.oN(str3)) {
                    gameDetailUI2.nuB.setTag(null);
                } else {
                    gameDetailUI2.nuB.setTag(str3);
                }
                gameDetailUI2.nuB.setOnClickListener(gameDetailUI2.nvb);
            }
            gameDetailUI2.a(afVar);
            gameDetailUI2.b(afVar);
            if (bi.oN(afVar.aRk()) || bi.oN(afVar.aRl())) {
                gameDetailUI2.nuO.setVisibility(8);
            } else {
                gameDetailUI2.nuO.setVisibility(0);
                gameDetailUI2.nuP.S(afVar.aRj());
                gameDetailUI2.nuQ.setText(afVar.aRk());
                gameDetailUI2.nuR.setText(afVar.aRl());
            }
            if (afVar.njb.nnH == null) {
                gameDetailUI2.nuJ.setVisibility(8);
            } else {
                gameDetailUI2.nuJ.setVisibility(0);
                gameDetailUI2.nuK.setText(afVar.njb.nnH.title);
                com.tencent.mm.ap.o.PG().a(afVar.njb.nnH.hcs, gameDetailUI2.nuL);
                gameDetailUI2.nuM.setText(afVar.njb.nnH.noB);
                gameDetailUI2.nuN.setText(afVar.njb.nnH.desc);
                ((ViewGroup) gameDetailUI2.nuM.getParent().getParent()).setTag(afVar.njb.nnH.noC);
                ((ViewGroup) gameDetailUI2.nuM.getParent().getParent()).setOnClickListener(gameDetailUI2.nvf);
            }
            gameDetailUI2.c(afVar);
            gameDetailUI2.nuY = afVar.njb.nnG;
            if (gameDetailUI2.nuY == null || !(gameDetailUI2.nuY.npQ || gameDetailUI2.nuY.npR)) {
                gameDetailUI2.mController.removeAllOptionMenu();
            } else {
                super.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        GameDetailUI2.a(GameDetailUI2.this, GameDetailUI2.this.nuY);
                        ap.a(GameDetailUI2.this.mController.xRr, 12, 1207, 1, 2, GameDetailUI2.this.appId, GameDetailUI2.this.niV, null);
                        return false;
                    }
                });
            }
            gameDetailUI2.nur.removeView(gameDetailUI2.nuO);
            gameDetailUI2.nur.removeView(gameDetailUI2.nuJ);
            gameDetailUI2.nur.removeView(gameDetailUI2.nuU);
            if (afVar.njd.status == 1) {
                gameDetailUI2.nur.addView(gameDetailUI2.nuJ);
                gameDetailUI2.nur.addView(gameDetailUI2.nuO);
            } else {
                gameDetailUI2.nur.addView(gameDetailUI2.nuO);
                gameDetailUI2.nur.addView(gameDetailUI2.nuJ);
            }
            gameDetailUI2.nur.addView(gameDetailUI2.nuU);
        }
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, String str, String str2) {
        com.tencent.mm.x.g.a aVar = new com.tencent.mm.x.g.a();
        aVar.title = gameDetailUI2.nuY.npN;
        aVar.description = gameDetailUI2.nuY.npO;
        aVar.type = 5;
        if (bi.oN(gameDetailUI2.nuY.nkV)) {
            aVar.thumburl = gameDetailUI2.nhC.field_appIconUrl;
        } else {
            aVar.thumburl = gameDetailUI2.nuY.nkV;
        }
        aVar.url = gameDetailUI2.nuY.nkQ;
        l.a(aVar, gameDetailUI2.appId, gameDetailUI2.nhC.field_appName, str, null, null, null);
        if (!bi.oN(str2)) {
            com.tencent.mm.sdk.b.b otVar = new ot();
            otVar.fHD.fHE = str;
            otVar.fHD.content = str2;
            otVar.fHD.type = s.hs(str);
            otVar.fHD.flags = 0;
            com.tencent.mm.sdk.b.a.xmy.m(otVar);
        }
    }

    static /* synthetic */ void p(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
        com.tencent.mm.bl.d.a((Context) gameDetailUI2, ".ui.transmit.SelectConversationUI", intent, 2);
        gameDetailUI2.mController.xRr.overridePendingTransition(R.a.bqo, R.a.bqa);
    }

    static /* synthetic */ void q(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", gameDetailUI2.nuY.npP);
        String str = gameDetailUI2.nuY.nkV;
        if (bi.oN(str)) {
            str = gameDetailUI2.nhC.field_appIconUrl;
        }
        intent.putExtra("Ksnsupload_imgurl", str);
        intent.putExtra("Ksnsupload_link", gameDetailUI2.nuY.nkQ);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        str = u.hC("game_center");
        u.GQ().t(str, true).o("prePublishId", "game_center");
        intent.putExtra("reportSessionId", str);
        com.tencent.mm.bl.d.b(gameDetailUI2.mController.xRr, "sns", ".ui.SnsUploadUI", intent, 3);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        if (as.Hp()) {
            this.nul = true;
            this.num = false;
            this.appId = getIntent().getStringExtra("game_app_id");
            if (bi.oN(this.appId)) {
                x.e("MicroMsg.GameDetailUI2", "appid is null or nill");
                finish();
            } else {
                this.niV = getIntent().getIntExtra("game_report_from_scene", 0);
            }
            initView();
            as.CN().a(1217, (e) this);
            final byte[] CC = SubCoreGameCenter.aRO().CC(this.appId);
            if (CC == null || CC.length == 0) {
                x.i("MicroMsg.GameDetailUI2", "No cache found");
                z = false;
            } else {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        final af afVar = new af(CC);
                        ah.y(new Runnable() {
                            public final void run() {
                                GameDetailUI2.a(GameDetailUI2.this, afVar);
                            }
                        });
                    }
                });
            }
            if (!z) {
                this.lTm = c.cS(this);
                this.lTm.show();
            }
            as.CN().a(new ax(w.cfV(), this.appId, com.tencent.mm.pluginsdk.model.app.g.m((Context) this, this.appId)), 0);
            return;
        }
        x.e("MicroMsg.GameDetailUI2", "account not ready");
        finish();
    }

    protected final int getLayoutId() {
        return R.i.djY;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!(this.nhC == null || this.nuq == null)) {
            this.nuq.aQQ();
            this.nup.a(this.nuw, this.nuv, this.nhC, this.nuq);
        }
        if (this.nul) {
            this.nul = false;
        } else {
            b(new ag(this.appId));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(1217, (e) this);
        if (this.nuo != null) {
            com.tencent.mm.plugin.game.model.n.b(this.nuo);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!bi.oN(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        finish();
    }

    protected final void initView() {
        setMMTitle(R.l.emp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameDetailUI2.this.goBack();
                return true;
            }
        });
        this.nur = (ViewGroup) findViewById(R.h.ckX);
        this.nus = (ImageView) findViewById(R.h.ckY);
        this.nut = (ImageView) findViewById(R.h.cmn);
        this.nuu = (TextView) findViewById(R.h.cmX);
        this.nux = (TextView) findViewById(R.h.cmr);
        this.nuv = (Button) findViewById(R.h.ckC);
        this.nuw = (TextProgressBar) findViewById(R.h.cnb);
        this.nuw.rv(this.nuk);
        this.nuy = (LinearLayout) findViewById(R.h.clU);
        this.nuz = (GameDetailAutoScrollView) findViewById(R.h.clT);
        this.nuA = (LinearLayout) findViewById(R.h.clD);
        this.nuB = (TextView) findViewById(R.h.clF);
        this.nuC = (LinearLayout) findViewById(R.h.clf);
        this.nuD = (TextView) findViewById(R.h.clo);
        this.nuE = (LinearLayout) findViewById(R.h.clg);
        this.nuF = (ImageView) findViewById(R.h.clh);
        this.nuG = findViewById(R.h.cli);
        this.nuH = (TextView) findViewById(R.h.clk);
        this.nuI = (TextView) findViewById(R.h.clj);
        this.nuJ = findViewById(R.h.clp);
        this.nuK = (TextView) findViewById(R.h.clt);
        this.nuL = (ImageView) findViewById(R.h.cls);
        this.nuM = (TextView) findViewById(R.h.clq);
        this.nuN = (TextView) findViewById(R.h.clr);
        this.nuO = (LinearLayout) findViewById(R.h.clb);
        this.nuP = (GameMediaList) findViewById(R.h.clC);
        GameMediaList gameMediaList = this.nuP;
        String str = this.appId;
        int i = this.niV;
        gameMediaList.appId = str;
        gameMediaList.mln = 12;
        gameMediaList.nws = i;
        gameMediaList.mContext = this;
        this.nuP.nyA = R.i.dkR;
        this.nuQ = (TextView) findViewById(R.h.cld);
        this.nuR = (TextView) findViewById(R.h.clc);
        this.nuR.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (GameDetailUI2.this.nuR.getLineCount() > 3) {
                    GameDetailUI2.this.nuS.setVisibility(0);
                } else {
                    GameDetailUI2.this.nuS.setVisibility(8);
                }
            }
        });
        this.nuS = (TextView) findViewById(R.h.cle);
        this.nuS.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (GameDetailUI2.this.nuT) {
                    GameDetailUI2.this.nuR.setMaxLines(3);
                    GameDetailUI2.this.nuS.setText(GameDetailUI2.this.getResources().getText(R.l.emg));
                    GameDetailUI2.this.nuT = false;
                    return;
                }
                GameDetailUI2.this.nuR.setMaxLines(100);
                GameDetailUI2.this.nuS.setText(GameDetailUI2.this.getResources().getText(R.l.emh));
                GameDetailUI2.this.nuT = true;
            }
        });
        this.nuU = (LinearLayout) findViewById(R.h.clu);
        this.nuV = (TextView) findViewById(R.h.clB);
        this.nuW = (LinearLayout) findViewById(R.h.clv);
        this.nuX = (TextView) findViewById(R.h.clw);
    }

    private void b(ag agVar) {
        int i = 0;
        List list = agVar.njf;
        if (list == null || list.size() == 0) {
            this.nuA.setVisibility(8);
            this.nuB.setVisibility(8);
            return;
        }
        this.nuA.setVisibility(0);
        if (list.size() > 3) {
            this.nuB.setVisibility(0);
        } else {
            this.nuB.setVisibility(8);
        }
        this.nuA.removeAllViews();
        j jVar = new j(this.mController.xRr);
        jVar.DD = R.i.dkg;
        jVar.a(agVar);
        jVar.niV = this.niV;
        while (i < list.size() && i < 3) {
            this.nuA.addView(jVar.getView(i, null, this.nuy));
            i++;
        }
    }

    private void a(af afVar) {
        LinkedList linkedList = null;
        if (afVar.nje.njf == null || afVar.nje.njf.size() == 0) {
            linkedList = afVar.njb.nnA;
        }
        if (linkedList == null || linkedList.size() == 0) {
            this.nuy.setVisibility(8);
            return;
        }
        this.nuy.setVisibility(0);
        this.nuy.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.game.c.x xVar = (com.tencent.mm.plugin.game.c.x) it.next();
            View inflate = LayoutInflater.from(this.mController.xRr).inflate(R.i.dkj, this.nuy, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.clW);
            TextView textView = (TextView) inflate.findViewById(R.h.clX);
            TextView textView2 = (TextView) inflate.findViewById(R.h.clV);
            if (bi.oN(xVar.kyG)) {
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFJ = true;
                com.tencent.mm.ap.o.PG().a(xVar.nkV, imageView, aVar.PQ());
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, xVar.kyG, 0.5f, false);
            }
            textView.setText(xVar.fpg);
            textView2.setText(xVar.nlZ);
            this.nuy.addView(inflate);
        }
    }

    private void b(af afVar) {
        if (afVar.aRh() == null || afVar.aRh().isEmpty()) {
            this.nuC.setVisibility(8);
            return;
        }
        int i;
        af.a aVar;
        this.nuC.setVisibility(0);
        if (bi.oN(afVar.aRg())) {
            this.nuD.setVisibility(8);
        } else {
            this.nuD.setVisibility(0);
            this.nuD.setText(afVar.aRg());
        }
        this.nuE.removeAllViews();
        int i2;
        if (afVar.aRi() == 1) {
            this.nuE.setOrientation(1);
            i2 = R.i.dkb;
            this.nuF.setVisibility(8);
            i = i2;
        } else {
            this.nuE.setOrientation(0);
            i2 = R.i.dka;
            this.nuF.setVisibility(0);
            i = i2;
        }
        LinkedList aRh = afVar.aRh();
        if (aRh != null) {
            Iterator it = aRh.iterator();
            while (it.hasNext()) {
                af.b bVar = (af.b) it.next();
                View inflate = LayoutInflater.from(this.mController.xRr).inflate(i, this.nuE, false);
                com.tencent.mm.ap.o.PG().a(bVar.fED, (ImageView) inflate.findViewById(R.h.clm));
                if (afVar.aRi() == 1) {
                    ((TextView) inflate.findViewById(R.h.cln)).setText(bVar.title);
                }
                ((TextView) inflate.findViewById(R.h.cll)).setText(bVar.desc);
                if (afVar.aRi() == 1) {
                    inflate.setTag(bVar.url);
                    inflate.setOnClickListener(this.nvc);
                }
                this.nuE.addView(inflate);
            }
        }
        if (afVar.njb.nnI != null) {
            aVar = new af.a();
            aVar.title = afVar.njb.nnI.now;
            aVar.desc = afVar.njb.nnI.desc;
            aVar.url = afVar.njb.nnI.url;
        } else if (afVar.njb.nnD == null || bi.oN(afVar.njb.nnD.noy) || bi.oN(afVar.njb.nnD.noz)) {
            aVar = null;
        } else {
            aVar = new af.a();
            aVar.title = afVar.njb.nnD.noy;
            aVar.url = afVar.njb.nnD.noz;
        }
        if (aVar != null) {
            this.nuG.setVisibility(0);
            this.nuH.setText(aVar.title);
            if (bi.oN(aVar.desc)) {
                this.nuI.setVisibility(8);
            } else {
                this.nuI.setVisibility(0);
                this.nuI.setText(aVar.desc);
            }
            this.nuG.setTag(aVar.url);
            this.nuG.setOnClickListener(this.nvc);
            return;
        }
        this.nuG.setVisibility(8);
    }

    private void c(af afVar) {
        if (afVar.aRn() == null || afVar.aRn().isEmpty()) {
            this.nuU.setVisibility(8);
            return;
        }
        this.nuU.setVisibility(0);
        if (bi.oN(afVar.aRm())) {
            this.nuV.setVisibility(8);
        } else {
            this.nuV.setVisibility(0);
            this.nuV.setText(afVar.aRm());
        }
        this.nuW.removeAllViews();
        this.nuW.setOnClickListener(null);
        Iterator it = afVar.aRn().iterator();
        while (it.hasNext()) {
            cf cfVar = (cf) it.next();
            View inflate = LayoutInflater.from(this.mController.xRr).inflate(R.i.dkc, this.nuW, false);
            TextView textView = (TextView) inflate.findViewById(R.h.clA);
            TextView textView2 = (TextView) inflate.findViewById(R.h.clx);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.cly);
            ((TextView) inflate.findViewById(R.h.clz)).setText(cfVar.noE);
            textView.setText(cfVar.fpg);
            textView2.setText(cfVar.nlZ);
            com.tencent.mm.ap.o.PG().a(cfVar.noA, imageView);
            inflate.setTag(cfVar.nkQ);
            inflate.setOnClickListener(this.nvd);
            this.nuW.addView(inflate);
        }
        Pair pair = afVar.njb.nnD == null ? null : (bi.oN(afVar.njb.nnC.fpg) || bi.oN(afVar.njb.nnC.noz)) ? null : new Pair(afVar.njb.nnC.noy, afVar.njb.nnC.noz);
        if (pair != null) {
            this.nuX.setVisibility(0);
            this.nuX.setText((CharSequence) pair.first);
            this.nuX.setTag(pair.second);
            this.nuX.setOnClickListener(this.nve);
            return;
        }
        this.nuX.setVisibility(8);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1217:
                    final com.tencent.mm.bp.a aVar = ((ax) kVar).lSH.hnR.hnY;
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            final af afVar = new af(aVar);
                            ah.y(new Runnable() {
                                public final void run() {
                                    GameDetailUI2.a(GameDetailUI2.this, afVar);
                                    if (GameDetailUI2.this.lTm != null) {
                                        GameDetailUI2.this.lTm.dismiss();
                                    }
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

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                switch (i2) {
                    case 2:
                        if (this.nhC != null && this.nuq != null) {
                            this.nuq.aQR();
                            this.nup.a(this.nhC, this.nuq);
                            return;
                        }
                        return;
                    case 3:
                        if (this.nuq != null) {
                            this.nuq.aQQ();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            case 2:
                if (i2 == -1) {
                    final String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bi.oN(stringExtra)) {
                        String str = this.nuY.nkV;
                        if (bi.oN(str)) {
                            str = this.nhC.field_appIconUrl;
                        }
                        com.tencent.mm.pluginsdk.ui.applet.e.b(this.mController, this.nuY.npN, str, this.nuY.npO, null, getResources().getString(R.l.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                            public final void a(boolean z, String str, int i) {
                                if (z) {
                                    GameDetailUI2.a(GameDetailUI2.this, stringExtra, str);
                                    h.bu(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(R.l.dUo));
                                    ap.a(GameDetailUI2.this.mController.xRr, 12, 1207, 2, 14, GameDetailUI2.this.appId, GameDetailUI2.this.niV, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (i2 == -1) {
                    ap.a(this.mController.xRr, 12, 1207, 2, 15, this.appId, this.niV, null);
                    return;
                }
                return;
            default:
                x.e("MicroMsg.GameDetailUI2", "error request code");
                return;
        }
    }
}
