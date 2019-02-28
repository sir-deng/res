package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ad.k;
import com.tencent.mm.bu.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;

public abstract class WalletBaseUI extends MMActivity implements f {
    public static final int ild = a.fromDPToPix(ad.getContext(), 270);
    private static h zSk = null;
    public MyKeyboardWindow mKeyboard;
    public View okX;
    public a olj;
    public Bundle vf = new Bundle();
    private OnMenuItemClickListener yIc;
    private c zSh = null;
    public i zSi = null;
    private g zSj = null;
    private OnMenuItemClickListener zSl;
    public boolean zSm = false;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public final String bKA() {
        if (this.vf == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.fvC;
        }
        return "";
    }

    public void aXI() {
        x.d("MicroMsg.WalletBaseUI", "cancelforceScene");
        this.zSi.aXI();
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.tencent.mm.kernel.g.Do().CF()) {
            x.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
            com.tencent.mm.ui.base.h.a((Context) this, getString(com.tencent.mm.plugin.wxpay.a.i.uVi), "", false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.wallet_core.a.c(WalletBaseUI.this, null, -10000);
                }
            });
        }
        this.zSi = new i(this, this);
        this.zSi.jl(385);
        this.zSi.jl(1518);
        x.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
        c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null) {
            this.zSi.gQd = ag.aLn();
        }
        x.d("MicroMsg.WalletBaseUI", "proc " + ag);
        this.vf = com.tencent.mm.wallet_core.a.af(this);
        if (this.vf == null) {
            this.vf = new Bundle();
        }
        this.zSi.vf = this.vf;
        if (aYP() && !com.tencent.mm.wallet_core.a.ae(this)) {
            x.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
        }
        if (getLayoutId() > 0) {
            String str = "";
            if (!bi.oN(str)) {
                setMMSubTitle(str);
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (WalletBaseUI.this.bKK()) {
                    WalletBaseUI.this.aWY();
                    WalletBaseUI.this.showDialog(1000);
                } else {
                    WalletBaseUI.this.finish();
                }
                return true;
            }
        });
        this.zSj = cCU();
        if (this.zSj != null && this.zSj.p(new Object[0])) {
            uV(4);
        } else if (getLayoutId() <= 0) {
            uV(4);
        } else if (aYL()) {
            uV(4);
        } else {
            uV(0);
        }
    }

    public final int cCP() {
        return this.mController.contentView.getVisibility();
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.yIc = onMenuItemClickListener;
        super.setBackBtn(onMenuItemClickListener);
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.zSl = onMenuItemClickListener;
        super.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void a(String str, OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.zSl = onMenuItemClickListener;
        super.a(0, str, onMenuItemClickListener, i);
    }

    public void onResume() {
        super.onResume();
        if (n.cCh()) {
            k bVar;
            if (q.Gl()) {
                bVar = new b();
            } else {
                bVar = new m();
            }
            this.zSi.a(bVar, false);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.zSi.jm(385);
        this.zSi.jm(1518);
    }

    public void b(int i, int i2, String str, k kVar, boolean z) {
        x.d("MicroMsg.WalletBaseUI", "errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        TenpaySecureEditText.setSalt(n.cCi());
        if (kVar instanceof h) {
            h hVar = (h) kVar;
            zSk = hVar;
            if (this.vf != null) {
                if (hVar.sSh > 0) {
                    this.vf.putInt("key_is_gen_cert", hVar.sSh);
                }
                if (hVar.sSj > 0) {
                    this.vf.putInt("key_is_hint_crt", hVar.sSj);
                }
                if (hVar.sSl > 0) {
                    this.vf.putInt("key_is_ignore_cert", hVar.sSl);
                }
                if (!bi.oN(hVar.sSi)) {
                    this.vf.putString("key_crt_token", hVar.sSi);
                }
                if (!bi.oN(hVar.sSk)) {
                    this.vf.putString("key_crt_wording", hVar.sSk);
                }
            }
        }
        j(i, i2, str, kVar);
        f.a(this, i, i2, str, kVar, z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        cCU().onActivityResult(i, i2, intent);
    }

    public void uO(int i) {
    }

    public boolean j(int i, int i2, String str, k kVar) {
        return true;
    }

    public boolean aYP() {
        return true;
    }

    public boolean aYO() {
        return false;
    }

    public boolean aYL() {
        if (getLayoutId() > 0 && !this.zSi.aXJ()) {
            return false;
        }
        return true;
    }

    public boolean bKK() {
        return false;
    }

    public final void cCQ() {
        PayInfo payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (payInfo == null) {
            payInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        if (payInfo != null && !bi.oN(payInfo.njL)) {
            this.zSi.a(new d(payInfo.njL, payInfo.fvC), true, 1);
            payInfo.njL = null;
        }
    }

    public boolean Xm() {
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.okX != null && this.okX.isShown()) {
                Xj();
                return true;
            } else if (bKK()) {
                aWY();
                showDialog(1000);
                return true;
            } else if (this.yIc != null && Xm()) {
                this.yIc.onMenuItemClick(null);
                return true;
            } else if (this.zSl != null) {
                this.zSl.onMenuItemClick(null);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final boolean alr() {
        if (this.yIc != null) {
            this.yIc.onMenuItemClick(null);
            return true;
        } else if (this.zSl == null) {
            return super.alr();
        } else {
            this.zSl.onMenuItemClick(null);
            return true;
        }
    }

    public Dialog onCreateDialog(int i) {
        x.i("MicroMsg.WalletBaseUI", "onCreateDialog id = " + i);
        switch (i) {
            case 1000:
                int b;
                c ag = com.tencent.mm.wallet_core.a.ag(this);
                if (ag != null) {
                    b = ag.b((MMActivity) this, 1);
                } else {
                    b = -1;
                }
                if (b != -1) {
                    return com.tencent.mm.ui.base.h.a((Context) this, true, getString(b), "", getString(com.tencent.mm.plugin.wxpay.a.i.dHo), getString(com.tencent.mm.plugin.wxpay.a.i.dGc), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletBaseUI.this.cCQ();
                            c ag = com.tencent.mm.wallet_core.a.ag(WalletBaseUI.this);
                            if (ag == null) {
                                WalletBaseUI.this.finish();
                            } else if (!ag.h(WalletBaseUI.this, WalletBaseUI.this.vf)) {
                                ag.b(WalletBaseUI.this, WalletBaseUI.this.vf);
                            }
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            View findFocus = WalletBaseUI.this.mController.contentView == null ? null : WalletBaseUI.this.mController.contentView.findFocus();
                            if (findFocus != null && (findFocus instanceof EditText)) {
                                WalletBaseUI.this.showVKB();
                            }
                        }
                    });
                }
                if (ag != null) {
                    ag.b((Activity) this, this.vf);
                } else {
                    finish();
                }
                return super.onCreateDialog(i);
            default:
                return super.onCreateDialog(i);
        }
    }

    public final void e(View view, int i, boolean z) {
        a(view, i, z, true);
    }

    public void a(View view, int i, boolean z, boolean z2) {
        b(view, i, z, true);
    }

    @TargetApi(14)
    public final void b(View view, final int i, final boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.uDo);
        this.okX = findViewById(com.tencent.mm.plugin.wxpay.a.f.uDn);
        View findViewById = findViewById(com.tencent.mm.plugin.wxpay.a.f.ivH);
        final EditText editText = (EditText) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.uFa);
        if (this.mKeyboard != null && editText != null && this.okX != null) {
            e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                public final void onFocusChange(final View view, boolean z) {
                    if (!view.isFocused() || z3) {
                        new ag().postDelayed(new Runnable() {
                            public final void run() {
                                WalletBaseUI.this.Xj();
                                if (z3) {
                                    ((InputMethodManager) WalletBaseUI.this.mController.xRr.getSystemService("input_method")).showSoftInput(editText, 0);
                                }
                            }
                        }, 200);
                        return;
                    }
                    ((InputMethodManager) WalletBaseUI.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            AccessibilityDelegate cVar;
                            if (!WalletBaseUI.this.okX.isShown() && view.isShown() && (z4 || WalletBaseUI.this.zSm)) {
                                WalletBaseUI.this.zSm = true;
                                WalletBaseUI.this.cCS();
                            }
                            if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view2;
                                if ((q.Gl() || walletFormView.zSX == 100) && (!q.Gl() || walletFormView.zSX == 0)) {
                                    WalletBaseUI.this.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    cVar = new com.tencent.mm.ui.a.c();
                                    WalletBaseUI.this.mKeyboard.setSecureAccessibility(cVar);
                                    editText.setAccessibilityDelegate(cVar);
                                }
                            }
                            if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                cVar = new com.tencent.mm.ui.a.c();
                                WalletBaseUI.this.mKeyboard.setSecureAccessibility(cVar);
                                editText.setAccessibilityDelegate(cVar);
                            }
                            WalletBaseUI.this.HU(i2);
                            WalletBaseUI.this.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) WalletBaseUI.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }, 300);
                }
            });
            editText.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!WalletBaseUI.this.okX.isShown() && !z) {
                        WalletBaseUI.this.cCS();
                        WalletBaseUI.this.HU(i);
                    } else if (z) {
                        WalletBaseUI.this.Xj();
                        ((InputMethodManager) WalletBaseUI.this.mController.xRr.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                }
            });
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    WalletBaseUI.this.Xj();
                }
            });
        }
    }

    public final boolean nR(boolean z) {
        if (zSk == null || (!zSk.bhI() && !z)) {
            return false;
        }
        this.zSi.a(zSk, true);
        return true;
    }

    public static void cCR() {
        f.cCR();
    }

    public void Xj() {
        if (this.okX != null && this.okX.isShown()) {
            this.okX.setVisibility(8);
            if (this.olj != null) {
                this.olj.hE(false);
            }
        }
    }

    public final void cCS() {
        if (this.okX != null && !this.okX.isShown()) {
            this.okX.setVisibility(0);
            if (this.olj != null) {
                this.olj.hE(true);
            }
        }
    }

    public final void HU(int i) {
        this.mKeyboard.setXMode(i);
    }

    public final c cCT() {
        if (this.zSh == null) {
            this.zSh = com.tencent.mm.wallet_core.a.ag(this);
        }
        return this.zSh;
    }

    public final g cCU() {
        if (this.zSj == null) {
            c cCT = cCT();
            if (cCT != null) {
                this.zSj = cCT.a((MMActivity) this, this.zSi);
            }
            if (this.zSj == null) {
                this.zSj = new g(this, this.zSi) {
                    public final boolean d(int i, int i2, String str, k kVar) {
                        return false;
                    }

                    public final boolean k(Object... objArr) {
                        return false;
                    }
                };
            }
        }
        return this.zSj;
    }

    public final CharSequence uE(int i) {
        if (this.zSj == null) {
            return null;
        }
        return this.zSj.uE(i);
    }

    public void bKh() {
        cCT().a((Activity) this, 0, this.vf);
    }

    public final void jl(int i) {
        this.zSi.jl(i);
    }

    public final void jm(int i) {
        this.zSi.jm(i);
    }

    public final void b(k kVar, boolean z) {
        cCV();
        this.zSi.a(kVar, z, 1);
    }

    public final void l(k kVar) {
        cCV();
        this.zSi.a(kVar, true, 1);
    }

    public final void r(k kVar) {
        cCV();
        this.zSi.a(kVar, true);
    }

    public void cCV() {
        c cCT = cCT();
        if (cCT != null) {
            this.zSi.vf = cCT.mym;
        }
    }

    public void uV(int i) {
        super.uV(i);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("key_process_is_end", false) && !intent.getBooleanExtra("key_process_is_stay", true)) {
            setIntent(intent);
            Bundle extras = getIntent().getExtras();
            int i = (extras == null || !extras.containsKey("key_process_result_code")) ? 0 : extras.getInt("key_process_result_code", 0);
            if (i == -1) {
                x.i("MicroMsg.WalletBaseUI", "process end ok!");
                setResult(-1, getIntent());
            } else {
                x.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : " + i);
                setResult(0, getIntent());
            }
            finish();
        }
    }

    public final void a(final View view, View view2, int i) {
        if (view != null) {
            final int i2;
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int eC = (a.eC(this) - i2) - a.fromDPToPix(this, 30);
            x.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + view2.getHeight()), Integer.valueOf(a.eC(this)), Integer.valueOf(eC), Integer.valueOf(ild));
            if (eC > 0 && eC < ild) {
                i2 = ild - eC;
                x.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i2));
                view.post(new Runnable() {
                    public final void run() {
                        view.scrollBy(0, i2);
                    }
                });
            }
        }
    }
}
