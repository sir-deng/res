package com.tencent.mm.plugin.aa.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ad.k;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity extends WalletBaseUI {
    private static final int ild = a.fromDPToPix(ad.getContext(), 300);
    private c gUB = new c();
    protected View ilc;

    static /* synthetic */ void a(BaseAAPresenterActivity baseAAPresenterActivity, EditText editText) {
        if (baseAAPresenterActivity.ilc != null) {
            int[] iArr = new int[2];
            editText.getLocationInWindow(iArr);
            int height = r1 - (iArr[1] + editText.getHeight());
            x.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + editText.getHeight()), Integer.valueOf(baseAAPresenterActivity.getWindow().getDecorView().getHeight() - baseAAPresenterActivity.getSupportActionBar().getHeight()), Integer.valueOf(height), Integer.valueOf(ild));
            if (height > 0 && height < ild) {
                x.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf((ild - height) + a.fromDPToPix(baseAAPresenterActivity, 5)));
                baseAAPresenterActivity.ilc.scrollBy(0, r0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUB.B(getIntent(), this);
        this.zSm = true;
    }

    public void onResume() {
        super.onResume();
        this.gUB.HF(2);
    }

    public void onPause() {
        super.onPause();
        this.gUB.HF(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.gUB.onDestroy();
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T q(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.gUB.a(this, cls);
    }

    public final <T extends com.tencent.mm.vending.app.a> T t(Class<? extends com.tencent.mm.vending.app.a> cls) {
        return this.gUB.b(this, cls);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final void a(View view, final int i, final boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uDo);
        this.okX = findViewById(f.uDn);
        View findViewById = findViewById(f.ivH);
        final EditText editText = (EditText) view.findViewById(f.uFa);
        if (this.mKeyboard != null && editText != null && this.okX != null) {
            this.okX.setVisibility(8);
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
                                BaseAAPresenterActivity.this.Xj();
                                ((InputMethodManager) BaseAAPresenterActivity.this.mController.xRr.getSystemService("input_method")).showSoftInput(editText, 0);
                            }
                        }, 200);
                        return;
                    }
                    ((InputMethodManager) BaseAAPresenterActivity.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            AccessibilityDelegate cVar;
                            if (!BaseAAPresenterActivity.this.okX.isShown() && view.isShown()) {
                                if (z4) {
                                    BaseAAPresenterActivity.this.cCS();
                                } else if (!BaseAAPresenterActivity.this.zSm) {
                                    BaseAAPresenterActivity.this.cCS();
                                }
                                BaseAAPresenterActivity.this.zSm = false;
                                BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, editText);
                            }
                            if ((view2 instanceof WalletFormView) && VERSION.SDK_INT >= 14) {
                                WalletFormView walletFormView = (WalletFormView) view2;
                                if ((q.Gl() || walletFormView.zSX == 100) && (!q.Gl() || walletFormView.zSX == 0)) {
                                    BaseAAPresenterActivity.this.mKeyboard.resetSecureAccessibility();
                                    editText.setAccessibilityDelegate(null);
                                } else {
                                    cVar = new com.tencent.mm.ui.a.c();
                                    BaseAAPresenterActivity.this.mKeyboard.setSecureAccessibility(cVar);
                                    editText.setAccessibilityDelegate(cVar);
                                }
                            }
                            if ((view2 instanceof EditHintPasswdView) && VERSION.SDK_INT >= 14) {
                                cVar = new com.tencent.mm.ui.a.c();
                                BaseAAPresenterActivity.this.mKeyboard.setSecureAccessibility(cVar);
                                editText.setAccessibilityDelegate(cVar);
                            }
                            BaseAAPresenterActivity.this.HU(i2);
                            BaseAAPresenterActivity.this.mKeyboard.setInputEditText((EditText) view);
                            ((InputMethodManager) BaseAAPresenterActivity.this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }, 300);
                }
            });
            editText.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!BaseAAPresenterActivity.this.okX.isShown() && !z) {
                        BaseAAPresenterActivity.this.cCS();
                        BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, editText);
                        BaseAAPresenterActivity.this.HU(i);
                    } else if (z) {
                        BaseAAPresenterActivity.this.Xj();
                        ((InputMethodManager) BaseAAPresenterActivity.this.mController.xRr.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                }
            });
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    BaseAAPresenterActivity.this.Xj();
                }
            });
        }
    }

    protected final void Xj() {
        super.Xj();
        if (this.ilc != null) {
            this.ilc.scrollTo(0, 0);
        }
    }
}
