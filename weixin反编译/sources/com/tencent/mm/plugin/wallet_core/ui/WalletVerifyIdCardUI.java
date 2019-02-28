package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.f.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class WalletVerifyIdCardUI extends WalletBaseUI {
    private TextView jOY;
    private boolean tdf = false;
    private h tdg = new h();
    private a tdh = new a() {
        public final void bNK() {
            WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
        }
    };
    private EditHintPasswdView tdk;

    static /* synthetic */ boolean a(WalletVerifyIdCardUI walletVerifyIdCardUI, a aVar) {
        if (walletVerifyIdCardUI.tdf) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "isCertInstalled passed");
            return false;
        }
        String string = walletVerifyIdCardUI.vf.getString("key_cre_type");
        String text = walletVerifyIdCardUI.tdk.getText();
        if (walletVerifyIdCardUI.tdg.bLM()) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall %s", aVar);
            if (bi.oN(text)) {
                x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall sms error %s", aVar);
                return false;
            }
            g.pWK.h(13731, Integer.valueOf(6));
            walletVerifyIdCardUI.l(new f(string, text, walletVerifyIdCardUI.bKA(), aVar, true));
            return true;
        } else if (walletVerifyIdCardUI.tdg.bLL()) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isNeedInstall %s", aVar);
            g.pWK.h(13731, Integer.valueOf(6));
            walletVerifyIdCardUI.l(new f(string, text, walletVerifyIdCardUI.bKA(), aVar, false));
            return true;
        } else {
            x.i("MicroMsg.WalletVerifyIdCardUI", "no need installcert");
            return false;
        }
    }

    static /* synthetic */ void b(WalletVerifyIdCardUI walletVerifyIdCardUI) {
        if (walletVerifyIdCardUI.cCU() != null) {
            x.d("MicroMsg.WalletVerifyIdCardUI", "3des text: %s", walletVerifyIdCardUI.tdk.getText());
            p pVar = new p();
            pVar.sVs = walletVerifyIdCardUI.vf.getString("key_pwd1");
            pVar.pHW = (PayInfo) walletVerifyIdCardUI.vf.getParcelable("key_pay_info");
            pVar.fDu = 1;
            pVar.sVw = walletVerifyIdCardUI.vf.getString("key_cre_type");
            pVar.sVv = walletVerifyIdCardUI.tdk.getText();
            pVar.token = bi.aD(walletVerifyIdCardUI.vf.getString("kreq_token"), "");
            switch (walletVerifyIdCardUI.vf.getInt("key_pay_flag", 0)) {
                case 1:
                    pVar.flag = "1";
                    break;
                case 2:
                    if (!walletVerifyIdCardUI.bNL()) {
                        pVar.flag = "2";
                        break;
                    } else {
                        pVar.flag = "5";
                        break;
                    }
                case 3:
                    if (!walletVerifyIdCardUI.bNL()) {
                        pVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                        break;
                    } else {
                        pVar.flag = "6";
                        break;
                    }
            }
            Bankcard bankcard = (Bankcard) walletVerifyIdCardUI.vf.getParcelable("key_bankcard");
            if (bankcard != null) {
                pVar.pff = bankcard.field_bankcardType;
                pVar.pfg = bankcard.field_bindSerial;
                pVar.sQK = bi.aD(bankcard.field_arrive_type, "");
            } else {
                pVar.pff = walletVerifyIdCardUI.vf.getString("key_bank_type");
                if (bi.oN(pVar.pff)) {
                    pVar.pff = walletVerifyIdCardUI.vf.getString("key_bind_card_type", "");
                }
            }
            walletVerifyIdCardUI.cCU().k(pVar);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tdg = new h(this.vf);
        initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.white)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            customView = customView.findViewById(com.tencent.mm.plugin.wxpay.a.f.divider);
            if (customView != null) {
                customView.setBackgroundColor(getResources().getColor(c.transparent));
            }
        }
        if (d.fN(21)) {
            if (d.fN(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletVerifyIdCardUI.this.finish();
                return false;
            }
        }, com.tencent.mm.plugin.wxpay.a.h.dvZ);
    }

    protected final void initView() {
        this.jOY = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uHl);
        this.tdk = (EditHintPasswdView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uHk);
        String string = this.vf.getString("key_true_name");
        String string2 = this.vf.getString("key_cre_name");
        String string3 = this.vf.getString("key_cre_type");
        this.jOY.setText(getString(i.uYu, new Object[]{string, string2}));
        EditHintPasswdView editHintPasswdView = this.tdk;
        if (editHintPasswdView.zSI != null) {
            InputFilter[] filters = editHintPasswdView.zSI.getFilters();
            InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
            for (int i = 0; i < filters.length; i++) {
                inputFilterArr[i] = filters[i];
            }
            inputFilterArr[inputFilterArr.length - 1] = new LengthFilter(4);
            editHintPasswdView.zSI.setFilters(inputFilterArr);
        }
        EditHintPasswdView editHintPasswdView2 = this.tdk;
        if (editHintPasswdView2.zSI != null) {
            editHintPasswdView2.zSI.setTextSize(34.0f);
        }
        this.tdk.zSM = new EditHintPasswdView.a() {
            public final void hB(final boolean z) {
                WalletVerifyIdCardUI.this.tdk.postDelayed(new Runnable() {
                    public final void run() {
                        if (z && !WalletVerifyIdCardUI.a(WalletVerifyIdCardUI.this, WalletVerifyIdCardUI.this.tdh)) {
                            WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
                        }
                    }
                }, 50);
            }
        };
        if ("1".equals(string3)) {
            e(this.tdk, 1, false);
        } else {
            e(this.tdk, 1, true);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof f)) {
            return false;
        }
        if (i2 == 0 || !((f) kVar).fIo) {
            this.tdk.bnq();
        } else {
            com.tencent.mm.ui.base.h.a(this.mController.xRr, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return true;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uMB;
    }

    private boolean bNL() {
        return this.vf.getBoolean("key_is_oversea", false);
    }

    public final boolean j(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", Integer.valueOf(i2), kVar);
        if ((kVar instanceof f) && i2 == 0) {
            this.tdf = true;
            u.makeText(this, i.vaH, 0).show();
            x.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
        }
        return true;
    }
}
