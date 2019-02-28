package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.d.b.f.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.b.b;
import com.tencent.mm.plugin.walletlock.fingerprint.a.c;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI extends MMActivity {
    private String hAU;
    private TextView kso;
    private int mFG = 0;
    private String mFy = null;
    private i nFV = null;
    private ProgressDialog nFW = null;
    private boolean oFw = true;
    private boolean pud = false;
    private boolean tma = false;
    private TextView tmg;
    private TextView tmh;
    private Animation tmi;
    private String tmj;
    private String tmk;
    private d tml;
    private h tmm;
    private b tmn;
    private String tmo = "-1";
    private int tmp = -1;
    private int tmq = -1;
    private String vz;

    public class a implements b {
        private WeakReference<FingerprintWalletLockUI> mFU = null;

        public a(FingerprintWalletLockUI fingerprintWalletLockUI) {
            this.mFU = new WeakReference(fingerprintWalletLockUI);
        }

        private FingerprintWalletLockUI bOA() {
            if (this.mFU != null) {
                return (FingerprintWalletLockUI) this.mFU.get();
            }
            return null;
        }

        public final void bOB() {
            FingerprintWalletLockUI.this.bKl();
            FingerprintWalletLockUI.this.bOv();
        }

        public final void K(int i, String str) {
            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", Integer.valueOf(i), str, Boolean.valueOf(FingerprintWalletLockUI.this.pud));
            if (!FingerprintWalletLockUI.this.pud) {
                switch (i) {
                    case 0:
                        x.i("MicroMsg.FingerprintWalletLockUI", "identify success");
                        if (bOA() != null) {
                            FingerprintWalletLockUI.d(bOA());
                            return;
                        }
                        return;
                    case 1:
                        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
                        if (bOA() != null) {
                            FingerprintWalletLockUI.a(bOA(), i, FingerprintWalletLockUI.this.getString(g.tlC));
                            return;
                        }
                        return;
                    case 2:
                        if (bOA() != null) {
                            FingerprintWalletLockUI.b(bOA(), i, FingerprintWalletLockUI.this.getString(g.tlA));
                            return;
                        }
                        return;
                    case 3:
                        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", Integer.valueOf(i));
                        if (bOA() != null) {
                            FingerprintWalletLockUI.b(bOA(), i, FingerprintWalletLockUI.this.getString(g.tlB));
                            return;
                        }
                        return;
                    case 4:
                        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
                        return;
                    case 5:
                        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
                        if (bOA() != null) {
                            FingerprintWalletLockUI.a(bOA(), i, FingerprintWalletLockUI.this.getString(g.tlC));
                            return;
                        }
                        return;
                    case 8:
                        if (bOA() != null) {
                            FingerprintWalletLockUI.b(bOA(), i, FingerprintWalletLockUI.this.getString(g.tlJ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenFailed errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        com.tencent.mm.plugin.walletlock.b.h.aa(fingerprintWalletLockUI.tmq, 2, 1);
        fingerprintWalletLockUI.sC(str);
    }

    static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI, int i, String str) {
        x.e("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenError errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.bOt();
        fingerprintWalletLockUI.dismissDialog();
        if (i == 3) {
            com.tencent.mm.plugin.walletlock.b.h.aa(fingerprintWalletLockUI.tmq, 2, 2);
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.I(System.currentTimeMillis(), 0);
            fingerprintWalletLockUI.tmg.setText(g.tlB);
            fingerprintWalletLockUI.tmg.setTextColor(fingerprintWalletLockUI.getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.btC));
        } else if (i == 8) {
            fingerprintWalletLockUI.bOw();
        } else {
            fingerprintWalletLockUI.sC(str);
        }
    }

    static /* synthetic */ void d(FingerprintWalletLockUI fingerprintWalletLockUI) {
        com.tencent.mm.plugin.walletlock.b.h.aa(fingerprintWalletLockUI.tmq, 2, 0);
        com.tencent.d.a.c.i iVar = com.tencent.mm.plugin.walletlock.b.g.tnR.tnT;
        if (iVar != null) {
            fingerprintWalletLockUI.tmo = iVar.AlF;
            x.v("MicroMsg.FingerprintWalletLockUI", "alvinluo authSuccess and mFid: %s", fingerprintWalletLockUI.tmo);
            if (fingerprintWalletLockUI.tmk.equals("action.switch_on_pattern")) {
                fingerprintWalletLockUI.tmk = fingerprintWalletLockUI.tmj;
                fingerprintWalletLockUI.bOx();
            } else if (!fingerprintWalletLockUI.tmk.equals("action.verify_pattern")) {
            } else {
                if (com.tencent.mm.plugin.walletlock.fingerprint.a.a.Oj(fingerprintWalletLockUI.tmo)) {
                    fingerprintWalletLockUI.tmk = fingerprintWalletLockUI.tmj;
                    fingerprintWalletLockUI.bOx();
                    return;
                }
                fingerprintWalletLockUI.zN(2);
            }
        }
    }

    static /* synthetic */ void g(FingerprintWalletLockUI fingerprintWalletLockUI) {
        Intent intent = new Intent();
        intent.putExtra("key_wallet_lock_setting_scene", 1);
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).b((Activity) fingerprintWalletLockUI, intent, 3);
    }

    static /* synthetic */ void i(FingerprintWalletLockUI fingerprintWalletLockUI) {
        fingerprintWalletLockUI.dismissDialog();
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.bOq();
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.Oi(FingerprintWalletLockUI.this.tmo);
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.fi(-1);
                com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.tnR;
                com.tencent.mm.plugin.walletlock.b.g.ke(true);
            }
        });
        Toast.makeText(fingerprintWalletLockUI, g.tly, 0).show();
        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).zM(2);
        com.tencent.mm.plugin.walletlock.b.i.tnV.bPd();
        fingerprintWalletLockUI.q(-1, 0, "open fingerprint lock ok");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", Long.valueOf(System.currentTimeMillis()));
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
        Intent intent = getIntent();
        this.vz = intent.getStringExtra("action");
        this.tmk = this.vz;
        this.tmj = intent.getStringExtra("next_action");
        this.hAU = intent.getStringExtra("token");
        this.mFy = intent.getStringExtra("key_pay_passwd");
        this.tmq = intent.getIntExtra("scene", -1);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", this.vz, this.tmj);
        if (this.vz.equals("action.verify_pattern")) {
            this.tmp = 2;
            com.tencent.mm.plugin.walletlock.b.h.bPa();
        } else if (this.vz.equals("action.switch_on_pattern")) {
            this.tmp = 1;
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", Boolean.valueOf(this.oFw));
        if (this.oFw) {
            this.tml = new c();
            this.tmm = new h();
            this.pud = false;
            f.cHb().cHc();
            this.nFW = com.tencent.mm.ui.base.h.a((Context) this, getString(g.dHn), false, null);
            bOv();
            if (this.vz.equals("action.switch_on_pattern")) {
                this.tma = false;
            } else {
                this.tma = true;
            }
            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.tma));
            com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.tnR;
            boolean bOW = com.tencent.mm.plugin.walletlock.b.g.bOW();
            com.tencent.mm.plugin.walletlock.b.g gVar2 = com.tencent.mm.plugin.walletlock.b.g.tnR;
            if (com.tencent.mm.plugin.walletlock.b.g.bOr() && !bOW) {
                x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", Boolean.valueOf(bOW));
                if (e.bOC()) {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
                    ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).zM(1);
                    gVar = com.tencent.mm.plugin.walletlock.b.g.tnR;
                    com.tencent.mm.plugin.walletlock.b.g.ke(true);
                    finish();
                    Intent intent = new Intent(this, GestureGuardLogicUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra("action", "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
                    intent.setPackage(ad.getPackageName());
                    if (!com.tencent.mm.kernel.g.Dq().Db().getBoolean(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false)) {
                        intent.putExtra("verify_title", getString(g.tlO));
                        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, Boolean.valueOf(true));
                        com.tencent.mm.kernel.g.Dq().Db().lO(true);
                    }
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", Boolean.valueOf(r1));
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pWK.h(12097, Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                } else {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
                    bKl();
                    this.nFV = new com.tencent.mm.ui.base.i.a(this).ET(g.tlK).EV(g.tlN).a(new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
                            ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).b(FingerprintWalletLockUI.this, 1, 4);
                        }
                    }).d(new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
                            FingerprintWalletLockUI.this.finish();
                            com.tencent.mm.plugin.walletlock.b.i.tnV.bPe();
                        }
                    }).ale();
                    this.nFV.setCanceledOnTouchOutside(false);
                    this.nFV.b(getString(g.tlt), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
                            ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).k(FingerprintWalletLockUI.this, 5);
                        }
                    });
                    this.nFV.show();
                }
            } else if (com.tencent.d.a.a.if(this)) {
                Bundle bundle = new Bundle();
                bundle.putString("key_pay_passwd", this.mFy);
                bundle.putBoolean("key_fp_lock_offline_mode", this.tma);
                this.tml.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a() {
                    public final void ai(int i, String str) {
                        x.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", Integer.valueOf(i), str, Long.valueOf(System.currentTimeMillis()));
                        if (FingerprintWalletLockUI.this.pud) {
                            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
                        } else if (i == 0) {
                            FingerprintWalletLockUI.this.bOx();
                        } else {
                            FingerprintWalletLockUI.this.sC(FingerprintWalletLockUI.this.getString(g.tlA));
                        }
                    }
                }, bundle);
            } else {
                bOw();
            }
            x.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", Long.valueOf(System.currentTimeMillis()));
        }
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
        dismissDialog();
        release();
        this.oFw = true;
    }

    protected final void initView() {
        super.initView();
        this.tmg = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.tkK);
        this.tmh = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.tkN);
        this.kso = (TextView) findViewById(com.tencent.mm.plugin.walletlock.a.d.tkJ);
        this.tmh.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FingerprintWalletLockUI.this.zN(1);
            }
        });
        this.kso.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.walletlock.b.i.tnV.bPe();
                FingerprintWalletLockUI.this.q(-1, 4, "user cancel setting fingerprint lock");
            }
        });
    }

    private void bOv() {
        if (this.vz.equals("action.verify_pattern")) {
            this.tmg.setText(g.tlE);
            this.tmg.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.btv));
            this.tmh.setVisibility(0);
            return;
        }
        this.tmg.setText(g.tlz);
        this.tmg.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.btv));
        this.tmh.setVisibility(8);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.walletlock.a.e.tkP;
    }

    private void bOw() {
        bKl();
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", Integer.valueOf(this.tmp));
        if (this.tmp == 2) {
            aVar.ET(g.tlJ).EV(g.tlM).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
                }
            }).EW(g.dEy).b(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
                }
            });
        } else {
            aVar.ET(g.tlI).Zp(getString(g.dGf)).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FingerprintWalletLockUI.this.finish();
                    com.tencent.mm.plugin.walletlock.b.i.tnV.bPe();
                }
            });
        }
        this.nFV = aVar.ale();
        this.nFV.setCanceledOnTouchOutside(false);
        this.nFV.show();
    }

    private void dismissDialog() {
        bKl();
        if (this.nFV != null && this.nFV.isShowing()) {
            this.nFV.dismiss();
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
        finish();
        com.tencent.mm.plugin.walletlock.b.i.tnV.bPe();
    }

    private void bOx() {
        x.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", this.tmk);
        if (bi.oN(this.tmk)) {
            finish();
            return;
        }
        String str = this.tmk;
        boolean z = true;
        switch (str.hashCode()) {
            case -1423990800:
                if (str.equals("next_action.goto_protected_page")) {
                    z = true;
                    break;
                }
                break;
            case -1305462654:
                if (str.equals("action.verify_pattern")) {
                    z = true;
                    break;
                }
                break;
            case -639789777:
                if (str.equals("next_action.switch_on_pattern")) {
                    z = true;
                    break;
                }
                break;
            case 1420518755:
                if (str.equals("action.switch_on_pattern")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
                this.tmn = new a(this);
                this.tmo = "-1";
                if (this.tmm == null) {
                    this.tmm = new h();
                }
                h hVar = this.tmm;
                b bVar = this.tmn;
                com.tencent.d.b.c.b anonymousClass1 = new com.tencent.mm.plugin.walletlock.fingerprint.a.h.AnonymousClass1(bVar);
                hVar.mFo = new com.tencent.d.b.c.a();
                com.tencent.d.b.f.b bVar2 = new com.tencent.d.b.f.b.a().iq(this).a(hVar.mFo).ack(com.tencent.mm.plugin.walletlock.b.g.tnR.tnS).It(3).a(anonymousClass1).Aml;
                com.tencent.mm.plugin.walletlock.b.g.tnR.tnT = null;
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo start auth");
                com.tencent.d.b.a.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.h.AnonymousClass2(bVar), bVar2);
                return;
            case true:
                com.tencent.d.a.c.i iVar = com.tencent.mm.plugin.walletlock.b.g.tnR.tnT;
                if (iVar == null) {
                    sC(getString(g.tlA));
                    return;
                }
                String str2 = iVar.AlM;
                String str3 = iVar.signature;
                if (this.tml != null) {
                    this.nFW = com.tencent.mm.ui.base.h.a((Context) this, getString(g.tlF), false, null);
                    this.tml.a(new com.tencent.mm.plugin.walletlock.fingerprint.a.d.a() {
                        public final void ai(int i, String str) {
                            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                            if (i == 0) {
                                FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
                            } else {
                                FingerprintWalletLockUI.this.sC(FingerprintWalletLockUI.this.getString(g.tlx));
                            }
                        }
                    }, this.hAU, str2, str3);
                    return;
                }
                return;
            case true:
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.fi(SystemClock.elapsedRealtime());
                bOy();
                return;
            default:
                return;
        }
    }

    private void bOy() {
        this.oFw = false;
        ah.h(new Runnable() {
            public final void run() {
                FingerprintWalletLockUI.this.finish();
            }
        }, 200);
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
            com.tencent.mm.plugin.walletlock.b.i.tnV.ki(true);
            com.tencent.mm.plugin.walletlock.b.i.tnV.kj(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
            overridePendingTransition(com.tencent.mm.plugin.walletlock.a.a.bqz, com.tencent.mm.plugin.walletlock.a.a.bqC);
            return;
        }
        x.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
    }

    private void zN(int i) {
        Intent intent = new Intent();
        if (i == 1) {
            intent.putExtra("action", "action.touchlock_verify_by_paypwd");
        } else if (i == 2) {
            intent.putExtra("action", "action.touchlock_need_verify_paypwd");
            intent.putExtra("key_wallet_lock_input_new_fp_tips", getString(g.tlH));
        }
        intent.putExtra("key_wallet_lock_type", 2);
        com.tencent.mm.bl.d.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i);
    }

    private void bKl() {
        if (this.nFW != null && this.nFW.isShowing()) {
            this.nFW.dismiss();
        }
    }

    private void zk(String str) {
        if (bi.oN(str)) {
            str = getString(g.tlD);
        }
        dismissDialog();
        this.nFV = com.tencent.mm.ui.base.h.a((Context) this, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                FingerprintWalletLockUI.this.finish();
            }
        });
        this.nFV.setCanceledOnTouchOutside(false);
    }

    private void sC(String str) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - this.mFG > 1) {
            this.mFG = currentTimeMillis;
            dismissDialog();
            if (this.tmg != null) {
                this.tmg.setText(str);
                this.tmg.setTextColor(getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.btC));
                this.tmg.setVisibility(4);
                if (this.tmi == null) {
                    this.tmi = AnimationUtils.loadAnimation(this.mController.xRr, com.tencent.mm.plugin.walletlock.a.a.tkA);
                }
                this.tmg.startAnimation(this.tmi);
                ah.h(new Runnable() {
                    public final void run() {
                        FingerprintWalletLockUI.this.tmg.setVisibility(0);
                    }
                }, this.tmi.getDuration());
            }
        }
    }

    private void release() {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", Boolean.valueOf(this.pud));
        if (!this.pud) {
            this.pud = true;
            if (this.tmm != null) {
                h hVar = this.tmm;
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
                if (hVar.mFo != null) {
                    hVar.mFo.od(true);
                }
            }
            if (this.tml != null) {
                this.tml.release();
            }
            f.cHb().cHc();
        }
    }

    private void q(int i, int i2, String str) {
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", Integer.valueOf(-1), Integer.valueOf(i2), str);
        release();
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        setResult(-1, intent);
        finish();
    }

    public void finish() {
        super.finish();
        release();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            x.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        x.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", Integer.valueOf(intExtra));
        if (i == 1) {
            if (intExtra == 0) {
                bOy();
                com.tencent.mm.plugin.walletlock.b.h.bOY();
            } else if (intExtra == -1) {
                this.oFw = false;
                zk(getString(g.tlP));
            }
        } else if (i == 2) {
            if (intExtra == 0) {
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.Oi(this.tmo);
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.fi(SystemClock.elapsedRealtime());
                bOy();
            } else if (intExtra == -1) {
                this.oFw = false;
                zk(getString(g.tlP));
            }
        } else if (i == 3) {
            if (intExtra == 0) {
                bOy();
                return;
            }
            finish();
            com.tencent.mm.plugin.walletlock.b.i.tnV.bPe();
        } else if (i == 4) {
            if (intExtra == 0) {
                bOy();
            } else if (intExtra == -1) {
                this.oFw = false;
                zk(getString(g.tlG));
            } else {
                finish();
                com.tencent.mm.plugin.walletlock.b.i.tnV.bPe();
            }
        } else if (i != 5) {
        } else {
            if (intExtra == 0) {
                ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.walletlock.a.b.class)).zM(0);
                com.tencent.mm.plugin.walletlock.b.g gVar = com.tencent.mm.plugin.walletlock.b.g.tnR;
                com.tencent.mm.plugin.walletlock.b.g.bOt();
                Toast.makeText(this, getString(g.tlu), 0).show();
                bOy();
            } else if (intExtra == -1) {
                this.oFw = false;
                zk(getString(g.tlv));
            } else if (intExtra == 4) {
                finish();
                com.tencent.mm.plugin.walletlock.b.i.tnV.bPe();
            }
        }
    }
}
