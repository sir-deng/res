package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.lg;
import com.tencent.mm.f.a.nc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.c.b;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.bpl;
import com.tencent.mm.protocal.c.nq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(3)
public class WalletCheckPwdUI extends WalletBaseUI {
    private String fvC;
    private int fyB = 0;
    private TextView iks;
    private ScrollView jmE;
    private String mFe;
    public EditHintPasswdView sHK;
    private Animation sZA;
    private boolean sZp = false;
    private LinearLayout sZq;
    private ImageView sZr;
    private TextView sZs;
    private boolean sZt = false;
    private boolean sZu = false;
    private String sZv;
    private int sZw = 0;
    private int sZx;
    private String sZy;
    private String sZz;

    static /* synthetic */ void a(WalletCheckPwdUI walletCheckPwdUI) {
        c cCT = walletCheckPwdUI.cCT();
        x.i("Micromsg.WalletCheckPwdUI", "onbackbtn click");
        if (cCT != null) {
            if (cCT instanceof com.tencent.mm.plugin.wallet_core.id_verify.a) {
                cCT.d(walletCheckPwdUI, 0);
            } else if (walletCheckPwdUI.sZu) {
                cCT.mym.putInt("key_process_result_code", 0);
                cCT.b((Activity) walletCheckPwdUI, cCT.mym);
            } else if (cCT.aLn().equals("OpenECardProcess")) {
                walletCheckPwdUI.vf.putInt("key_process_result_code", 0);
                walletCheckPwdUI.setResult(-1);
                cCT.ah(walletCheckPwdUI.mController.xRr);
            }
        }
        walletCheckPwdUI.finish();
    }

    static /* synthetic */ void b(WalletCheckPwdUI walletCheckPwdUI, String str) {
        x.i("Micromsg.WalletCheckPwdUI", "do check pwd by fp");
        walletCheckPwdUI.b(new s(walletCheckPwdUI.sZv, str), true);
        g.pWK.h(15021, Integer.valueOf(2));
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uLq;
    }

    public final void uV(int i) {
        this.mController.contentView.setVisibility(i);
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        CharSequence uE = uE(1);
        if (bi.N(uE)) {
            setMMTitle(u.gh(this));
        } else {
            setMMTitle(uE.toString());
        }
        Intent intent = getIntent();
        if (intent == null || !getIntent().hasExtra("scene")) {
            c ag = com.tencent.mm.wallet_core.a.ag(this);
            if (ag != null) {
                int i2 = ag.mym.getInt("scene", -1);
                boolean z = i2 == 1 && "UnbindProcess".equals(ag.aLn());
                this.sZu = z;
                i = i2;
            }
        } else {
            i = intent.getIntExtra("scene", -1);
        }
        if (i == 1) {
            this.sZt = true;
            x.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
            uV(4);
            this.mController.hideTitleView();
            Bundle bundle2 = null;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            int i3;
            k bVar;
            if (this.sZu) {
                c ag2 = com.tencent.mm.wallet_core.a.ag(this);
                if (ag2 != null) {
                    bundle2 = ag2.mym;
                }
                if (bundle2 == null) {
                    x.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
                    setResult(1);
                    finish();
                }
                string = bundle2.getString("appId");
                string2 = bundle2.getString("timeStamp");
                string3 = bundle2.getString("nonceStr");
                string4 = bundle2.getString("packageExt");
                string5 = bundle2.getString("signtype");
                string6 = bundle2.getString("paySignature");
                string7 = bundle2.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                i3 = bundle2.getInt("pay_channel", 0);
                if (this.sZu) {
                    bVar = new b(string, string2, string3, string4, string5, string6, string7, "verifyWCPayPassword", i3);
                } else {
                    x.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bi.oN(string));
                    bVar = new com.tencent.mm.plugin.wallet_core.c.a(string, string2, string3, string4, string5, string6, string7, 10, "verifyWCPayPassword", i3);
                }
                r(bVar);
            } else if (getIntent() == null) {
                x.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
            } else {
                bundle2 = getIntent().getExtras();
                string = bundle2.getString("appId");
                string2 = bundle2.getString("timeStamp");
                string3 = bundle2.getString("nonceStr");
                string4 = bundle2.getString("packageExt");
                string5 = bundle2.getString("signtype");
                string6 = bundle2.getString("paySignature");
                string7 = bundle2.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                i3 = bundle2.getInt("pay_channel", 0);
                if (this.sZu) {
                    bVar = new b(string, string2, string3, string4, string5, string6, string7, "verifyWCPayPassword", i3);
                } else {
                    x.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bi.oN(string));
                    bVar = new com.tencent.mm.plugin.wallet_core.c.a(string, string2, string3, string4, string5, string6, string7, 10, "verifyWCPayPassword", i3);
                }
                r(bVar);
            }
            initView();
        } else {
            uV(0);
            this.mController.showTitleView();
            if (!this.vf.getBoolean("key_is_expired_bankcard", false)) {
                initView();
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletCheckPwdUI.a(WalletCheckPwdUI.this);
                return false;
            }
        });
        findViewById(f.uon).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCheckPwdUI.a(WalletCheckPwdUI.this);
            }
        });
    }

    protected final void aXI() {
        x.d("Micromsg.WalletCheckPwdUI", "check pwd ");
        this.zSi.aXI();
    }

    public void onResume() {
        if (this.sHK != null) {
            this.sHK.bnq();
        }
        jl(580);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        jm(580);
    }

    public void onDestroy() {
        super.onDestroy();
        bNl();
    }

    protected final void initView() {
        TextView textView = (TextView) findViewById(f.urA);
        CharSequence uE = uE(0);
        if (bi.N(uE)) {
            textView.setText(i.uXz);
        } else {
            textView.setText(uE);
            if (uE instanceof SpannableString) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        this.sHK = (EditHintPasswdView) findViewById(f.ury);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sHK);
        this.sHK.zSM = new EditHintPasswdView.a() {
            public final void hB(boolean z) {
                if (z) {
                    WalletCheckPwdUI.this.mFe = WalletCheckPwdUI.this.sHK.getText();
                    c ag = com.tencent.mm.wallet_core.a.ag(WalletCheckPwdUI.this);
                    Object obj = null;
                    if (ag != null) {
                        obj = ag.aLn();
                    }
                    if (!WalletCheckPwdUI.this.sZt || "UnbindProcess".equals(obj)) {
                        if (!WalletCheckPwdUI.this.cCU().k(WalletCheckPwdUI.this.mFe, WalletCheckPwdUI.this.bKA())) {
                            WalletCheckPwdUI.this.l(new r(WalletCheckPwdUI.this.mFe, 1, WalletCheckPwdUI.this.bKA()));
                            return;
                        }
                        return;
                    }
                    WalletCheckPwdUI.this.l(new s(WalletCheckPwdUI.this.mFe, WalletCheckPwdUI.this.sZv, (byte) 0));
                    g.pWK.h(15021, Integer.valueOf(1));
                }
            }
        };
        this.jmE = (ScrollView) findViewById(f.uHh);
        this.sZq = (LinearLayout) findViewById(f.urb);
        this.sZr = (ImageView) findViewById(f.ura);
        this.sZs = (TextView) findViewById(f.urc);
        this.iks = (TextView) findViewById(f.uHg);
        this.iks.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCheckPwdUI.bNl();
                if (WalletCheckPwdUI.this.fyB == 0) {
                    WalletCheckPwdUI.this.fyB = 1;
                    WalletCheckPwdUI.this.bNk();
                } else {
                    WalletCheckPwdUI.this.fyB = 0;
                }
                WalletCheckPwdUI.this.bNj();
            }
        });
        this.olj = new com.tencent.mm.wallet_core.ui.a() {
            public final void hE(final boolean z) {
                x.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", Boolean.valueOf(z));
                WalletCheckPwdUI.this.jmE.post(new Runnable() {
                    public final void run() {
                        if (z) {
                            WalletCheckPwdUI.this.jmE.fullScroll(130);
                        } else {
                            WalletCheckPwdUI.this.jmE.fullScroll(33);
                        }
                    }
                });
            }
        };
        e(this.sHK, 0, false);
    }

    private void a(axi axi) {
        findViewById(f.uGy).setVisibility(0);
        findViewById(f.urA).setVisibility(8);
        if (axi == null || bi.oN(axi.title)) {
            ((TextView) findViewById(f.uGz)).setText(i.uXv);
        } else {
            ((TextView) findViewById(f.uGz)).setText(axi.title);
        }
        if (axi == null || bi.oN(axi.wLx)) {
            ((TextView) findViewById(f.uGx)).setText(i.uXu);
        } else {
            ((TextView) findViewById(f.uGx)).setText(axi.wLx);
        }
        if (this.sHK.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) this.sHK.getLayoutParams();
            layoutParams.leftMargin = BackwardSupportUtil.b.b((Context) this, 47.0f);
            layoutParams.rightMargin = BackwardSupportUtil.b.b((Context) this, 47.0f);
            this.sHK.setLayoutParams(layoutParams);
        }
        this.mController.hideTitleView();
    }

    private void bNj() {
        x.i("Micromsg.WalletCheckPwdUI", "change mode: %s", Integer.valueOf(this.fyB));
        if (this.fyB == 1) {
            this.sZq.setVisibility(0);
            this.sHK.setVisibility(8);
            this.iks.setText(i.uXs);
            Xj();
            if (bi.oN(this.sZz)) {
                ((TextView) findViewById(f.uGx)).setText(i.uXu);
                return;
            } else {
                ((TextView) findViewById(f.uGx)).setText(this.sZz);
                return;
            }
        }
        this.sZq.setVisibility(8);
        this.sHK.bnq();
        this.sHK.setVisibility(0);
        this.iks.setText(i.uXr);
        cCS();
        if (bi.oN(this.sZy)) {
            ((TextView) findViewById(f.uGx)).setText(i.uXu);
        } else {
            ((TextView) findViewById(f.uGx)).setText(this.sZy);
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        x.d("Micromsg.WalletCheckPwdUI", " errCode: " + i2 + " errMsg :" + str);
        c ag;
        if (i != 0 || i2 != 0) {
            if (this.sHK != null) {
                this.sHK.bnq();
            }
            if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) && !(kVar instanceof b)) {
                return false;
            }
            x.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
            ag = com.tencent.mm.wallet_core.a.ag(this);
            if (ag == null || !ag.aLn().equals("UnbindProcess")) {
                setResult(0);
                finish();
                return true;
            }
            setResult(1);
            ag.mym.putInt("key_process_result_code", 1);
            com.tencent.mm.wallet_core.a.j(this, ag.mym);
            return true;
        } else if (kVar instanceof r) {
            Bundle bundle = this.vf;
            bundle.putString("key_pwd1", this.sHK.getText());
            com.tencent.mm.wallet_core.a.j(this, bundle);
            if (this.sHK != null) {
                this.sHK.bnq();
            }
            finish();
            return true;
        } else if (kVar instanceof y) {
            h.bu(this, getString(i.uXD));
            ag = com.tencent.mm.wallet_core.a.ag(this);
            if (ag != null) {
                ag.mym.putInt("key_process_result_code", -1);
            }
            com.tencent.mm.wallet_core.a.j(this, ag.mym);
            if (this.sHK != null) {
                this.sHK.bnq();
            }
            finish();
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            com.tencent.mm.pluginsdk.wallet.f.TF(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bLs());
            this.sZv = ((com.tencent.mm.plugin.wallet_core.c.a) kVar).biB();
            setResult(-1);
            axi axi = ((nq) ((com.tencent.mm.plugin.wallet_core.c.a) kVar).gLB.hnR.hnY).wds;
            if (((com.tencent.mm.plugin.wallet_core.c.a) kVar).sOr == 5) {
                a(axi);
            } else {
                this.mController.showTitleView();
                findViewById(f.uGy).setVisibility(8);
            }
            uV(0);
            return true;
        } else if (kVar instanceof b) {
            b bVar = (b) kVar;
            this.sZv = bVar.sOs.token;
            this.fvC = bVar.sOs.vGu;
            com.tencent.mm.pluginsdk.wallet.f.TF(bVar.sOs.vGu);
            if (bVar.sOs.wds != null) {
                this.sZy = bVar.sOs.wds.wLx;
                this.sZz = bVar.sOs.wds.wLy;
            }
            setResult(-1);
            a(bVar.sOs.wds);
            bpl bpl = bVar.sOs.wdF;
            if (bpl != null) {
                l lVar = (l) com.tencent.mm.kernel.g.h(l.class);
                if (bpl.wYG == 1 && lVar.aKL() && lVar.aKK() && !lVar.aKF()) {
                    x.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                    this.fyB = 1;
                    com.tencent.mm.plugin.wallet_core.model.s.sVy.mFv = bpl.vWf.cec();
                    com.tencent.mm.plugin.wallet_core.model.s.sVy.mFw = bpl.vWg == 1;
                    bNk();
                    this.iks.setVisibility(0);
                }
            }
            bNj();
            uV(0);
            return true;
        } else if (!(kVar instanceof s)) {
            return true;
        } else {
            s sVar = (s) kVar;
            if (sVar.bLt()) {
                x.i("Micromsg.WalletCheckPwdUI", "need free sms");
                Bundle bundle2 = new Bundle();
                bundle2.putString("key_pwd1", this.mFe);
                bundle2.putString("key_jsapi_token", this.sZv);
                bundle2.putString("key_relation_key", sVar.sOQ);
                bundle2.putString("key_mobile", sVar.sOP);
                com.tencent.mm.wallet_core.a.a((Activity) this, k.class, bundle2, new c.a() {
                    public final Intent l(int i, Bundle bundle) {
                        Intent intent = new Intent();
                        intent.putExtra("token", bundle.getString("key_jsapi_token"));
                        intent.putExtra("key_process_result_code", i);
                        intent.setClass(WalletCheckPwdUI.this.mController.xRr, WalletCheckPwdUI.class);
                        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.putExtra("key_process_is_stay", false);
                        return intent;
                    }
                });
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra("token", ((s) kVar).sON);
            setResult(-1, intent);
            finish();
            return true;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.okX == null || !this.okX.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.okX.setVisibility(8);
        return true;
    }

    public boolean bKK() {
        if (this.vf.getInt("key_pay_flag", 0) != 0) {
            return true;
        }
        return false;
    }

    public final void uO(int i) {
        if (this.sZp) {
            finish();
        } else if (this.sHK != null) {
            this.sHK.bnq();
        }
    }

    public final boolean aYL() {
        return this.sZp;
    }

    public int getForceOrientation() {
        return 1;
    }

    private void bNk() {
        com.tencent.mm.plugin.soter.c.a.bDx();
        final com.tencent.mm.sdk.b.b lgVar = new lg();
        lgVar.fDr.fxT = this.fvC;
        lgVar.fDr.fDt = 1;
        lgVar.fDr.fDv = new Runnable() {
            public final void run() {
                x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
                lg.b bVar = lgVar.fDs;
                if (bVar == null) {
                    x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
                    return;
                }
                int i = bVar.errCode;
                x.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), bVar.foE);
                if (i == 0) {
                    x.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", bVar.fDw);
                    WalletCheckPwdUI.this.sZs.setVisibility(8);
                    WalletCheckPwdUI.b(WalletCheckPwdUI.this, bVar.fDw);
                    com.tencent.mm.plugin.soter.c.a.ys(0);
                    return;
                }
                boolean z;
                x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int j = currentTimeMillis - WalletCheckPwdUI.this.sZx;
                if (j > 1) {
                    WalletCheckPwdUI.this.sZx = currentTimeMillis;
                    WalletCheckPwdUI.this.sZw = WalletCheckPwdUI.this.sZw + 1;
                }
                boolean z2 = i == 2 || i == 10308;
                if (bVar.fDx == 2) {
                    z = true;
                } else {
                    z = false;
                }
                x.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(WalletCheckPwdUI.this.sZw), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (WalletCheckPwdUI.this.sZw < 3 && j > 1)) && !z2) {
                    x.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
                    if (WalletCheckPwdUI.this.sZA == null) {
                        WalletCheckPwdUI.this.sZA = com.tencent.mm.ui.c.a.fB(WalletCheckPwdUI.this.mController.xRr);
                    }
                    WalletCheckPwdUI.this.sZs.setVisibility(0);
                    WalletCheckPwdUI.this.sZs.startAnimation(WalletCheckPwdUI.this.sZA);
                    WalletCheckPwdUI.this.sZA.setFillAfter(true);
                    com.tencent.mm.plugin.soter.c.a.ys(1);
                } else if (WalletCheckPwdUI.this.sZw >= 3 || z2) {
                    x.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
                    WalletCheckPwdUI.bNl();
                    WalletCheckPwdUI.this.fyB = 0;
                    WalletCheckPwdUI.this.bNj();
                    WalletCheckPwdUI.this.iks.setVisibility(8);
                    com.tencent.mm.plugin.soter.c.a.ys(2);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.a(lgVar, Looper.getMainLooper());
    }

    private static void bNl() {
        x.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.xmy.m(new nc());
    }
}
