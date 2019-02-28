package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.b.h;
import com.tencent.mm.plugin.walletlock.b.i;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.protocal.c.aut;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.bcz;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI extends MMActivity implements OnClickListener, com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a {
    private String hAU = null;
    private ag mHandler = new ag(Looper.getMainLooper());
    private int mStatus;
    private int nbA = 0;
    private int tmA = 0;
    private a[] tmB = null;
    private Animation tmC = null;
    private List<f> tmD = null;
    private List<f> tmE = null;
    private boolean tmF = false;
    private int tmG = 0;
    private k tmH = null;
    private k tmI = null;
    private String tmJ = null;
    private ViewFlipper tmK = null;
    private Dialog tmL = null;
    private boolean tmM = true;
    private boolean tmN = false;
    private String tmO;
    private int tmq = -1;
    private int tmz = 0;

    private interface a {
        void onDone();
    }

    static /* synthetic */ void bOQ() {
        aj.a(q.FY(), 9, "PatternLockUpdate", "");
        g.pWK.h(11473, new Object[0]);
    }

    static /* synthetic */ int k(GestureGuardLogicUI gestureGuardLogicUI) {
        int i = gestureGuardLogicUI.tmG + 1;
        gestureGuardLogicUI.tmG = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!ad.getPackageName().equals(intent.getPackage()) || bi.oN(intent.getStringExtra("action")) || bi.oN(intent.getStringExtra("next_action"))) {
            x.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
            finish();
            return;
        }
        this.tmK = new ViewFlipper(this);
        this.tmB = new a[]{new a(this), new a(this), new a(this)};
        a[] aVarArr = this.tmB;
        int length = aVarArr.length;
        while (i < length) {
            a aVar = aVarArr[i];
            this.tmK.addView(aVar.mView);
            aVar.tmX.tnz = this;
            aVar.tmY.setOnClickListener(this);
            i++;
        }
        setContentView(this.tmK);
        this.hAU = getIntent().getStringExtra("token");
        this.tmJ = getIntent().getStringExtra(Columns.TYPE);
        this.tmO = getIntent().getStringExtra("verify_title");
        this.tmq = getIntent().getIntExtra("scene", -1);
        if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            h.bPa();
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.mStatus == 0) {
            int i;
            com.tencent.mm.plugin.walletlock.gesture.a.g bOG = d.bOG();
            if (bOG.tmx != -1) {
                e.a(bOG);
                if (bOG.tmy / 1000 < 600) {
                    d.J(bOG.tmx, bOG.tmy);
                    i = 1;
                    if (i != 0) {
                        this.tmG = d.bOK();
                        if (this.tmG != -1) {
                            return;
                        }
                    }
                    this.tmG = 0;
                }
                d.bOH();
            }
            i = 0;
            if (i != 0) {
                this.tmG = d.bOK();
                if (this.tmG != -1) {
                    return;
                }
            }
            this.tmG = 0;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tmH != null) {
            com.tencent.mm.kernel.g.CN().c(this.tmH);
            this.tmH = null;
        }
        if (this.tmI != null) {
            com.tencent.mm.kernel.g.CN().c(this.tmI);
            this.tmI = null;
        }
        if (this.tmL != null && this.tmL.isShowing()) {
            this.tmL.dismiss();
        }
        if (this.tmK != null) {
            this.tmK.removeAllViews();
            this.tmK = null;
        }
        for (int i = 0; i < this.tmB.length; i++) {
            a aVar = this.tmB[i];
            aVar.tmX.setOnClickListener(null);
            aVar.tmY.setOnClickListener(null);
            aVar.mView = null;
            aVar.tmV = null;
            aVar.tmW = null;
            aVar.tmX = null;
            aVar.tmY = null;
            this.tmB[i] = null;
        }
        this.tmB = null;
    }

    protected final void initView() {
        aWY();
        setMMSubTitle(com.tencent.mm.plugin.walletlock.a.g.eXI);
        this.tmC = AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.walletlock.a.a.tkB);
        this.tmz = getResources().getColor(b.tkD);
        this.tmA = getResources().getColor(b.tkE);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("action");
        intent.getStringExtra("next_action");
        if ("action.switch_on_pattern".equals(stringExtra)) {
            this.mStatus = 16;
            S(1, false);
        } else if ("action.verify_pattern".equals(stringExtra)) {
            if (com.tencent.mm.plugin.walletlock.gesture.a.b.bOD()) {
                this.tmF = true;
                this.mStatus = 20;
            } else {
                this.tmF = false;
                this.mStatus = 0;
            }
            S(0, false);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!GestureGuardLogicUI.this.bOM()) {
                    GestureGuardLogicUI.this.q(0, 4, "user cancel when setting gesture");
                }
                return true;
            }
        });
        x.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[]{Integer.valueOf(this.mStatus)}));
        bON();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.walletlock.a.e.tkQ;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (intent == null) {
            x.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", 0);
        if (intExtra == 0) {
            this.hAU = intent.getStringExtra("key_token");
            this.tmJ = intent.getStringExtra("key_type");
            String stringExtra = getIntent().getStringExtra("next_action");
            if ("next_action.goto_protected_page".equals(stringExtra) || "next_action.modify_pattern".equals(stringExtra)) {
                if ("next_action.modify_pattern".equals(stringExtra)) {
                    this.tmN = true;
                }
                this.tmM = false;
                setBackBtn(null);
                mc(false);
                this.mStatus = 16;
                S(1, false);
            } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                String str = this.hAU;
                final com.tencent.mm.ad.u.a anonymousClass12 = new com.tencent.mm.ad.u.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                        if (i2 == 0) {
                            d.bOL();
                            d.bOF();
                            d.bOH();
                            Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlq), 0).show();
                        } else {
                            Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlb), 0).show();
                        }
                        GestureGuardLogicUI.this.hAU = null;
                        GestureGuardLogicUI.this.tmJ = null;
                        GestureGuardLogicUI.this.finish();
                        return 0;
                    }
                };
                b(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        GestureGuardLogicUI.this.tmB[GestureGuardLogicUI.this.nbA].tmX.bOT();
                        if (GestureGuardLogicUI.this.tmH != null && !GestureGuardLogicUI.this.tmH.aBT) {
                            com.tencent.mm.kernel.g.CN().c(GestureGuardLogicUI.this.tmH);
                        }
                    }
                });
                if (str == null) {
                    bKl();
                    anonymousClass12.a(3, -6, getString(com.tencent.mm.plugin.walletlock.a.g.tld), null, null);
                } else {
                    com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                    aVar.hnT = new bcy();
                    aVar.hnU = new bcz();
                    aVar.hnS = 688;
                    aVar.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
                    com.tencent.mm.ad.b Kf = aVar.Kf();
                    bcy bcy = (bcy) Kf.hnQ.hnY;
                    bcy.wPH = new bes().bl(str.getBytes());
                    bcy.pK = 3;
                    u.a(Kf, new com.tencent.mm.ad.u.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                            x.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                            GestureGuardLogicUI.this.bKl();
                            if (i == 0 && i2 == 0) {
                                d.a(((bcz) bVar.hnR.hnY).wJx);
                                com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.tnR;
                                com.tencent.mm.plugin.walletlock.b.g.kd(false);
                                GestureGuardLogicUI.bOQ();
                            }
                            i.tnV.bPd();
                            if (anonymousClass12 != null) {
                                return anonymousClass12.a(i, i2, str, bVar, kVar);
                            }
                            return 0;
                        }
                    }, false);
                }
            } else {
                this.mStatus = 1;
            }
            bON();
        } else if (intExtra == -1) {
            Toast.makeText(this, getString(com.tencent.mm.plugin.walletlock.a.g.tlb), 0).show();
        }
    }

    public void onClick(View view) {
        if (view.getId() == com.tencent.mm.plugin.walletlock.a.d.tkO) {
            Intent intent = new Intent();
            intent.putExtra("action", "action.verify_paypwd");
            intent.putExtra("key_wallet_lock_type", 1);
            com.tencent.mm.bl.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, 1001);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (bOM()) {
            return false;
        }
        q(0, 4, "user cancel when setting gesture");
        return false;
    }

    private void q(int i, int i2, String str) {
        x.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        setResult(i, intent);
        finish();
    }

    private boolean bOM() {
        if (this.mStatus == 20 || this.mStatus == 0 || this.mStatus == 2 || this.mStatus == 1) {
            bOP();
            return false;
        }
        if (this.tmM) {
            String stringExtra = getIntent().getStringExtra("next_action");
            stringExtra = ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) ? getString(com.tencent.mm.plugin.walletlock.a.g.tkY) : getString(com.tencent.mm.plugin.walletlock.a.g.tkZ);
            new com.tencent.mm.ui.base.i.a(this).mp(false).Zn(stringExtra).EV(com.tencent.mm.plugin.walletlock.a.g.tkW).a(new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    GestureGuardLogicUI.this.bOP();
                    GestureGuardLogicUI.this.q(0, 4, "user cancel when setting gesture");
                }
            }).EW(com.tencent.mm.plugin.walletlock.a.g.tkU).b(new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).ale().show();
        } else {
            new com.tencent.mm.ui.base.i.a(this).mp(true).ET(com.tencent.mm.plugin.walletlock.a.g.tla).EV(com.tencent.mm.plugin.walletlock.a.g.tkV).a(new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).ale().show();
        }
        return true;
    }

    private void bON() {
        while (true) {
            final a aVar = this.tmB[this.nbA];
            String stringExtra;
            List list;
            com.tencent.mm.ad.b.a aVar2;
            aut aut;
            long elapsedRealtime;
            switch (this.mStatus) {
                case 0:
                    setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.tln));
                    this.tmF = false;
                    aVar.tmX.tnn = true;
                    aVar.tmX.tnz = this;
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        aVar.tmV.setText(getString(com.tencent.mm.plugin.walletlock.a.g.tll));
                    } else if (bi.oN(this.tmO)) {
                        aVar.tmV.setText(getString(com.tencent.mm.plugin.walletlock.a.g.tlm));
                    } else {
                        aVar.tmV.setText(this.tmO);
                    }
                    aVar.tmV.setTextColor(this.tmz);
                    if (aVar.tmY.getVisibility() != 0) {
                        aVar.tmY.setVisibility(0);
                        return;
                    }
                    return;
                case 1:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        aVar.tmX.bOT();
                        S(1, true);
                        this.mStatus = 16;
                    } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                        list = this.tmE;
                        final com.tencent.mm.ad.u.a anonymousClass26 = new com.tencent.mm.ad.u.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlq), 0).show();
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlb), 0).show();
                                }
                                GestureGuardLogicUI.this.tmE = null;
                                GestureGuardLogicUI.this.finish();
                                return 0;
                            }
                        };
                        b(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                GestureGuardLogicUI.this.tmB[GestureGuardLogicUI.this.nbA].tmX.bOT();
                                if (GestureGuardLogicUI.this.tmI != null && !GestureGuardLogicUI.this.tmI.aBT) {
                                    com.tencent.mm.kernel.g.CN().c(GestureGuardLogicUI.this.tmI);
                                }
                            }
                        });
                        aVar2 = new com.tencent.mm.ad.b.a();
                        aVar2.hnT = new aut();
                        aVar2.hnU = new auu();
                        aVar2.hnS = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.ad.b Kf = aVar2.Kf();
                        aut = (aut) Kf.hnQ.hnY;
                        aut.pK = 3;
                        aut.wJv = new bes().bl(e.ck(list));
                        u.a(Kf, new com.tencent.mm.ad.u.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                                x.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                                GestureGuardLogicUI.this.bKl();
                                if (i == 0 && i2 == 0) {
                                    d.a(((auu) bVar.hnR.hnY).wJx);
                                    com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.tnR;
                                    com.tencent.mm.plugin.walletlock.b.g.kd(false);
                                    GestureGuardLogicUI.this.tmF = false;
                                    GestureGuardLogicUI.bOQ();
                                }
                                if (anonymousClass26 != null) {
                                    return anonymousClass26.a(i, i2, str, bVar, kVar);
                                }
                                return 0;
                            }
                        }, false);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra)) {
                        d.fi(SystemClock.elapsedRealtime());
                        bOO();
                        h.aa(this.tmq, 1, 0);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    d.J(elapsedRealtime, 0);
                    d.zO(this.tmG);
                    d.bOt();
                    if (this.tmG == 5) {
                        this.tmF = true;
                        d.I(elapsedRealtime, 0);
                        aVar.tmX.bOT();
                        aVar.tmX.tnn = false;
                        this.mStatus = 20;
                        bON();
                        com.tencent.mm.ui.base.i.a aVar3 = new com.tencent.mm.ui.base.i.a(this);
                        aVar3.mp(false).Zn(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.tkX), new Object[]{Long.valueOf(10)}));
                        aVar3.EV(com.tencent.mm.plugin.walletlock.a.g.tkT).a(new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.this.tmB[GestureGuardLogicUI.this.nbA].tmY);
                            }
                        });
                        aVar3.EW(com.tencent.mm.plugin.walletlock.a.g.tkS).b(new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                GestureGuardLogicUI.this.bOP();
                                GestureGuardLogicUI.this.finish();
                            }
                        });
                        aVar3.ale().show();
                    } else {
                        aVar.tmX.tnn = false;
                        aVar.tmX.a(PatternLockView.b.Wrong);
                        a(String.format(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.tle), new Object[]{Integer.valueOf(5 - this.tmG)}), new a() {
                            public final void onDone() {
                                GestureGuardLogicUI.this.mStatus = 0;
                                aVar.tmX.bOT();
                                aVar.tmX.tnn = true;
                            }
                        });
                    }
                    x.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", getIntent().getStringExtra("next_action"));
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        return;
                    }
                    if (this.tmG == 5) {
                        h.aa(this.tmq, 1, 2);
                        return;
                    } else {
                        h.aa(this.tmq, 1, 1);
                        return;
                    }
                case 16:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) {
                        setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.tlo));
                    } else {
                        setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.tlp));
                    }
                    this.tmF = false;
                    aVar.tmX.tnn = true;
                    aVar.tmX.tnz = this;
                    aVar.tmV.setText(getString(com.tencent.mm.plugin.walletlock.a.g.tlk));
                    aVar.tmV.setTextColor(getResources().getColor(b.tkD));
                    if (aVar.tmY.getVisibility() != 8) {
                        aVar.tmY.setVisibility(8);
                        return;
                    }
                    return;
                case 17:
                    aVar.tmV.setText(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.tli));
                    aVar.tmV.setTextColor(this.tmz);
                    aVar.tmX.bOT();
                    aVar.tmX.tnn = true;
                    if (aVar.tmY.getVisibility() != 8) {
                        aVar.tmY.setVisibility(8);
                        return;
                    }
                    return;
                case 18:
                    String stringExtra2 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra2)) {
                        if (this.tmN) {
                            this.tmN = false;
                            a(this.hAU, this.tmD, new com.tencent.mm.ad.u.a() {
                                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                                    if (i2 == 0) {
                                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tls), 0).show();
                                        g.pWK.h(11474, new Object[0]);
                                    } else {
                                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlb), 0).show();
                                    }
                                    GestureGuardLogicUI.this.hAU = null;
                                    GestureGuardLogicUI.this.tmD = null;
                                    GestureGuardLogicUI.this.finish();
                                    return 0;
                                }
                            });
                            return;
                        }
                        list = this.tmE;
                        List list2 = this.tmD;
                        final com.tencent.mm.ad.u.a anonymousClass22 = new com.tencent.mm.ad.u.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tls), 0).show();
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlb), 0).show();
                                }
                                GestureGuardLogicUI.this.tmE = null;
                                GestureGuardLogicUI.this.tmD = null;
                                GestureGuardLogicUI.this.finish();
                                return 0;
                            }
                        };
                        aVar2 = new com.tencent.mm.ad.b.a();
                        b(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                GestureGuardLogicUI.this.tmB[GestureGuardLogicUI.this.nbA].tmX.bOT();
                                if (GestureGuardLogicUI.this.tmI != null && !GestureGuardLogicUI.this.tmI.aBT) {
                                    com.tencent.mm.kernel.g.CN().c(GestureGuardLogicUI.this.tmI);
                                }
                            }
                        });
                        aVar2.hnT = new aut();
                        aVar2.hnU = new auu();
                        aVar2.hnS = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.ad.b Kf2 = aVar2.Kf();
                        aut = (aut) Kf2.hnQ.hnY;
                        aut.pK = 1;
                        aut.wJv = new bes().bl(e.ck(list));
                        aut.wJw = new bes().bl(e.ck(list2));
                        u.a(Kf2, new com.tencent.mm.ad.u.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                                x.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                                GestureGuardLogicUI.this.bKl();
                                if (i == 0 && i2 == 0) {
                                    d.a(((auu) bVar.hnR.hnY).wJx);
                                    GestureGuardLogicUI.bOQ();
                                }
                                i.tnV.bPd();
                                if (anonymousClass22 != null) {
                                    return anonymousClass22.a(i, i2, str, bVar, kVar);
                                }
                                return 0;
                            }
                        }, false);
                        return;
                    } else if ("next_action.switch_on_pattern".equals(stringExtra2)) {
                        a(this.hAU, this.tmD, new com.tencent.mm.ad.u.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                                GestureGuardLogicUI.this.hAU = null;
                                GestureGuardLogicUI.this.tmD = null;
                                if (i2 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlr), 0).show();
                                    GestureGuardLogicUI.this.q(-1, 0, "open gesture ok");
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlb), 0).show();
                                    GestureGuardLogicUI.this.q(-1, -1, "open gesture failed");
                                }
                                return 0;
                            }
                        });
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra2)) {
                        a(this.hAU, this.tmD, new com.tencent.mm.ad.u.a() {
                            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                                if (i2 == 0) {
                                    d.fi(SystemClock.elapsedRealtime());
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tls), 0).show();
                                    GestureGuardLogicUI.this.bOO();
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlb), 0).show();
                                }
                                GestureGuardLogicUI.this.hAU = null;
                                GestureGuardLogicUI.this.tmD = null;
                                return 0;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                case 19:
                    aVar.tmX.tnn = false;
                    aVar.tmX.a(PatternLockView.b.Wrong);
                    a(getResources().getString(com.tencent.mm.plugin.walletlock.a.g.tlj), new a() {
                        public final void onDone() {
                            GestureGuardLogicUI.this.mHandler.postDelayed(new Runnable() {
                                public final void run() {
                                    GestureGuardLogicUI.this.mHandler.removeCallbacks(this);
                                    aVar.tmX.bOT();
                                    GestureGuardLogicUI.this.mStatus = 16;
                                    GestureGuardLogicUI.this.S(1, true);
                                    GestureGuardLogicUI.this.bON();
                                }
                            }, 500);
                        }
                    });
                    return;
                case 20:
                    setMMTitle(getString(com.tencent.mm.plugin.walletlock.a.g.tln));
                    this.tmF = true;
                    aVar.tmX.tnn = false;
                    aVar.tmX.tnz = null;
                    elapsedRealtime = (long) Math.ceil(((double) (600 - (d.bOE().tmy / 1000))) / 60.0d);
                    aVar.tmV.setText(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.tlh), new Object[]{Long.valueOf(elapsedRealtime)}));
                    aVar.tmV.setTextColor(getResources().getColor(b.tkE));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(final PatternLockView patternLockView, final List<f> list) {
        boolean z = true;
        if (this.mStatus == 16) {
            if (list.size() < 4) {
                patternLockView.tnn = false;
                patternLockView.a(PatternLockView.b.Wrong);
                a(String.format(getString(com.tencent.mm.plugin.walletlock.a.g.tlf), new Object[]{Integer.valueOf(4)}), new a() {
                    public final void onDone() {
                        patternLockView.bOT();
                        patternLockView.tnn = true;
                    }
                });
                return;
            }
            this.tmD = list;
            patternLockView.bOT();
            this.mStatus = 17;
            S(2, true);
        } else if (this.mStatus == 0) {
            final com.tencent.mm.ad.u.a anonymousClass3 = new com.tencent.mm.ad.u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                    if (i2 == 0) {
                        GestureGuardLogicUI.this.tmF = false;
                        GestureGuardLogicUI.this.tmG = 0;
                        d.bOL();
                        d.bOF();
                        d.bOH();
                        GestureGuardLogicUI.this.tmE = list;
                        GestureGuardLogicUI.this.mStatus = 1;
                        GestureGuardLogicUI.this.bON();
                    } else if (i2 == -3) {
                        GestureGuardLogicUI.k(GestureGuardLogicUI.this);
                        GestureGuardLogicUI.this.mStatus = 2;
                        GestureGuardLogicUI.this.bON();
                    } else {
                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(com.tencent.mm.plugin.walletlock.a.g.tlc), 0).show();
                    }
                    return 0;
                }
            };
            awn bOJ = d.bOJ();
            awm bOI = d.bOI();
            g.pWK.h(11453, new Object[0]);
            b(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    GestureGuardLogicUI.this.tmB[GestureGuardLogicUI.this.nbA].tmX.bOT();
                    if (GestureGuardLogicUI.this.tmI != null && !GestureGuardLogicUI.this.tmI.aBT) {
                        com.tencent.mm.kernel.g.CN().c(GestureGuardLogicUI.this.tmI);
                    }
                }
            });
            boolean z2 = e.b(bOI) ? e.b(bOJ) ? bOI.version < bOJ.wKE : false : true;
            x.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[]{Boolean.valueOf(e.b(bOJ)), Boolean.valueOf(e.b(bOI)), Boolean.valueOf(z2)}));
            if (z2) {
                com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                aVar.hnT = new aut();
                aVar.hnU = new auu();
                aVar.hnS = 689;
                aVar.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                com.tencent.mm.ad.b Kf = aVar.Kf();
                aut aut = (aut) Kf.hnQ.hnY;
                aut.pK = 2;
                aut.wJv = new bes().bl(e.ck(list));
                u.a(Kf, new com.tencent.mm.ad.u.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                        x.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                        GestureGuardLogicUI.this.bKl();
                        if (i == 0 && i2 == 0) {
                            d.a(((auu) bVar.hnR.hnY).wJx);
                        }
                        if (anonymousClass3 != null) {
                            return anonymousClass3.a(i, i2, str, bVar, kVar);
                        }
                        return 0;
                    }
                }, false);
                return;
            }
            bKl();
            awm bOI2 = d.bOI();
            if (bOI2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.Do();
                stringBuilder.append(new o(com.tencent.mm.kernel.a.Cn()).longValue());
                stringBuilder.append('_');
                stringBuilder.append(new String(e.ck(list)));
                z = new String(bOI2.wKB.wRm.oz).equals(com.tencent.mm.a.g.s(stringBuilder.toString().getBytes()));
            }
            if (z) {
                anonymousClass3.a(3, 0, null, null, null);
                return;
            } else {
                anonymousClass3.a(3, -3, null, null, null);
                return;
            }
        } else if (this.mStatus != 17) {
            return;
        } else {
            if (this.tmD.equals(list)) {
                patternLockView.bOT();
                this.tmF = false;
                this.tmG = 0;
                d.bOL();
                d.bOF();
                d.bOH();
                d.bOt();
                this.mStatus = 18;
            } else {
                this.mStatus = 19;
            }
        }
        bON();
    }

    private void a(String str, List<f> list, final com.tencent.mm.ad.u.a aVar) {
        b(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                GestureGuardLogicUI.this.tmB[GestureGuardLogicUI.this.nbA].tmX.bOT();
                if (GestureGuardLogicUI.this.tmH != null && !GestureGuardLogicUI.this.tmH.aBT) {
                    com.tencent.mm.kernel.g.CN().c(GestureGuardLogicUI.this.tmH);
                }
            }
        });
        if (str == null) {
            bKl();
            aVar.a(3, -6, getString(com.tencent.mm.plugin.walletlock.a.g.tld), null, null);
            return;
        }
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = new bcy();
        aVar2.hnU = new bcz();
        aVar2.hnS = 688;
        aVar2.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
        com.tencent.mm.ad.b Kf = aVar2.Kf();
        bcy bcy = (bcy) Kf.hnQ.hnY;
        bcy.wPH = new bes().bl(str.getBytes());
        bcy.wPI = new bes().bl(e.ck(list));
        u.a(Kf, new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                GestureGuardLogicUI.this.bKl();
                if (i == 0 && i2 == 0) {
                    d.a(((bcz) bVar.hnR.hnY).wJx);
                    GestureGuardLogicUI.bOQ();
                    ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).zM(1);
                }
                i.tnV.bPd();
                if (aVar != null) {
                    return aVar.a(i, i2, str, bVar, kVar);
                }
                return 0;
            }
        }, false);
    }

    private void bOO() {
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            i.tnV.ki(true);
            i.tnV.kj(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
        } else {
            x.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
        }
        finish();
    }

    private void bOP() {
        String stringExtra = getIntent().getStringExtra("next_action");
        if (this.mStatus == 20 || "next_action.goto_protected_page".equals(stringExtra)) {
            i.tnV.bPe();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.tmB[this.nbA];
        if (motionEvent.getAction() != 2 && motionEvent.getAction() != 7) {
            return super.dispatchTouchEvent(motionEvent);
        }
        motionEvent.offsetLocation((float) (-aVar.tmW.getLeft()), (float) ((-aVar.tmW.getTop()) - getWindow().findViewById(16908290).getTop()));
        return aVar.tmW.dispatchTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        a aVar = this.tmB[this.nbA];
        if (aVar.tmX != null) {
            PatternLockView patternLockView = aVar.tmX;
            boolean z2 = z && !this.tmF;
            patternLockView.tnn = z2;
        }
    }

    public final void a(PatternLockView patternLockView) {
        patternLockView.a(PatternLockView.b.Correct);
    }

    private void S(int i, boolean z) {
        int i2 = i - this.nbA;
        if (i2 != 0) {
            this.nbA = i;
            if (!z) {
                this.tmK.setInAnimation(null);
                this.tmK.setOutAnimation(null);
            } else if (i2 > 0) {
                this.tmK.setInAnimation(this, com.tencent.mm.plugin.walletlock.a.a.bqB);
                this.tmK.setOutAnimation(this, com.tencent.mm.plugin.walletlock.a.a.bqA);
            } else {
                this.tmK.setInAnimation(this, com.tencent.mm.plugin.walletlock.a.a.bqz);
                this.tmK.setOutAnimation(this, com.tencent.mm.plugin.walletlock.a.a.bqC);
            }
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.tmK.showNext();
                }
                return;
            }
            while (i2 < 0) {
                this.tmK.showPrevious();
                i2++;
            }
        }
    }

    private void a(String str, final a aVar) {
        TextView textView = this.tmB[this.nbA].tmV;
        textView.getText().toString();
        textView.setText(str);
        textView.setTextColor(this.tmA);
        textView.startAnimation(this.tmC);
        this.tmC.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                GestureGuardLogicUI.this.tmC.setAnimationListener(null);
                if (aVar != null) {
                    aVar.onDone();
                }
            }
        });
    }

    private void b(OnCancelListener onCancelListener) {
        if (this.tmL == null) {
            this.tmL = com.tencent.mm.ui.base.h.a((Context) this, getString(com.tencent.mm.plugin.walletlock.a.g.tlg), false, onCancelListener);
        } else {
            this.tmL.show();
        }
    }

    private void bKl() {
        if (this.tmL != null && this.tmL.isShowing()) {
            this.tmL.dismiss();
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
