package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.bankcard.TenpaySegmentEditText;

public class WalletConfirmCardIDUI extends WalletBaseUI {
    private Button nvt;
    private TenpaySegmentEditText sZG;
    private boolean sZH = true;

    static /* synthetic */ void g(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        TenpaySegmentEditText.setSalt(n.cCi());
        walletConfirmCardIDUI.l(new t(walletConfirmCardIDUI.bKA(), walletConfirmCardIDUI.sZG.getEncryptDataWithHash(false), (PayInfo) walletConfirmCardIDUI.vf.getParcelable("key_pay_info"), walletConfirmCardIDUI.vf.getInt("entry_scene", -1)));
    }

    protected final int getLayoutId() {
        return g.uLr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                o.cCm();
                WalletConfirmCardIDUI.this.finish();
                return false;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        Object string = this.vf.getString("key_bankcard_id");
        String string2 = this.vf.getString("key_bankcard_des");
        Bitmap bitmap = (Bitmap) this.vf.getParcelable("key_bankcard_cropimg");
        if (TextUtils.isEmpty(string)) {
            x.e("MicroMsg.WalletConfirmCardIDUI", "cardID is empty");
            finish();
        } else if (bitmap == null) {
            x.e("MicroMsg.WalletConfirmCardIDUI", "cardID bitmap is null");
            finish();
        } else {
            setMMTitle(i.uXE);
            this.nvt = (Button) findViewById(f.cAl);
            this.sZG = (TenpaySegmentEditText) findViewById(f.uqm);
            this.sZG.setText(string, string2);
            this.mKeyboard = (MyKeyboardWindow) findViewById(f.uDo);
            this.okX = findViewById(f.uDn);
            ((ImageView) findViewById(f.unT)).setImageBitmap(bitmap);
            this.sZG.setKeyboard(this.mKeyboard);
            this.mKeyboard.setXMode(0);
            ((InputMethodManager) this.mController.xRr.getSystemService("input_method")).hideSoftInputFromWindow(this.sZG.getWindowToken(), 0);
            this.okX.setVisibility(8);
            this.sZG.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!(WalletConfirmCardIDUI.this.okX.isShown() || WalletConfirmCardIDUI.this.sZH)) {
                        WalletConfirmCardIDUI.this.okX.setVisibility(0);
                        WalletConfirmCardIDUI.this.mKeyboard.setVisibility(0);
                    }
                    WalletConfirmCardIDUI.this.sZH = false;
                }
            });
            final String str = this.sZG.get3DesEncrptData();
            this.nvt.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String str = WalletConfirmCardIDUI.this.sZG.get3DesEncrptData();
                    if (str == null || !str.equals(str)) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(11353, Integer.valueOf(0), Integer.valueOf(2));
                    } else {
                        com.tencent.mm.plugin.report.service.g.pWK.h(11353, Integer.valueOf(0), Integer.valueOf(1));
                    }
                    WalletConfirmCardIDUI.g(WalletConfirmCardIDUI.this);
                }
            });
            this.mKeyboard = (MyKeyboardWindow) findViewById(f.uDo);
            this.okX = findViewById(f.uDn);
            View findViewById = findViewById(f.ivH);
            if (!(this.mKeyboard == null || this.okX == null)) {
                findViewById.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        WalletConfirmCardIDUI.this.Xj();
                    }
                });
            }
            this.sZG.setFocusable(false);
            this.sZG.setFocusableInTouchMode(true);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Bundle bundle = new Bundle();
        boolean z = this.vf.getBoolean("key_is_reset_with_new_card", false);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                bundle.putBoolean("key_need_area", tVar.bLu());
                bundle.putBoolean("key_need_profession", tVar.bLv());
                bundle.putParcelableArray("key_profession_list", tVar.sOW);
                if (tVar.sOS == null) {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.sZG.getEncryptDataWithHash(false));
                    a.j(this, bundle);
                } else if (tVar.sOS.sSG && tVar.sOS.isError()) {
                    h.h(this, i.uWg, i.dGZ);
                    return true;
                } else {
                    bundle.putBoolean("key_is_reset_with_new_card", z);
                    bundle.putString("bank_name", tVar.sOS.nHt);
                    bundle.putParcelable("elemt_query", tVar.sOS);
                    bundle.putString("key_card_id", this.sZG.getEncryptDataWithHash(false));
                    a.j(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (kVar instanceof t)) {
            bundle.putString("bank_name", "");
            bundle.putBoolean("key_is_reset_with_new_card", z);
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.sZG.getEncryptDataWithHash(false));
            a.j(this, bundle);
            return true;
        }
        return false;
    }
}
