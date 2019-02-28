package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI extends WalletBaseUI {
    private Button lXK;
    private WalletPayUSecurityQuestionView tkm;
    private WalletFormView tkn;
    private m tkr;
    private String tks = "";
    private a tkt;

    protected class a {
        protected a() {
        }

        static /* synthetic */ void a(a aVar) {
            if (aVar.bOl()) {
                WalletPayUSecurityQuestionSettingUI.this.lXK.setEnabled(true);
            } else {
                WalletPayUSecurityQuestionSettingUI.this.lXK.setEnabled(false);
            }
        }

        protected final boolean bOl() {
            boolean z;
            if (bi.oN(WalletPayUSecurityQuestionSettingUI.this.tkm.tkx)) {
                z = false;
            } else {
                z = true;
            }
            return z && WalletPayUSecurityQuestionSettingUI.this.tkn.XX();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tkr = new m(this);
        this.tkr.nD(true);
        this.tkr.rQF = new c() {
            public final void a(n nVar) {
                nVar.clear();
                ArrayList a = WalletPayUSecurityQuestionSettingUI.this.vf.getParcelableArrayList("key_security_question_list");
                if (a != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < a.size()) {
                            nVar.add(((PayUSecurityQuestion) a.get(i2)).desc);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        };
        this.tkr.rQG = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                WalletPayUSecurityQuestionSettingUI.this.tkm.Og(((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.this.vf.getParcelableArrayList("key_security_question_list").get(i)).desc);
                WalletPayUSecurityQuestionSettingUI.this.tks = ((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.this.vf.getParcelableArrayList("key_security_question_list").get(i)).id;
                WalletPayUSecurityQuestionSettingUI.this.tkn.bnq();
                a.a(WalletPayUSecurityQuestionSettingUI.this.tkt);
            }
        };
        this.tkt = new a();
        this.tkm = (WalletPayUSecurityQuestionView) findViewById(f.uzR);
        this.tkn = (WalletFormView) findViewById(f.uzQ);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.tkn);
        this.lXK = (Button) findViewById(f.uzP);
        this.tkm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletPayUSecurityQuestionSettingUI.this.tkr.dN();
            }
        });
        this.tkn.zST = new com.tencent.mm.wallet_core.ui.formview.WalletFormView.a() {
            public final void hB(boolean z) {
                a.a(WalletPayUSecurityQuestionSettingUI.this.tkt);
            }
        };
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (WalletPayUSecurityQuestionSettingUI.this.tkt.bOl()) {
                    WalletPayUSecurityQuestionSettingUI.this.vf.putString("key_question_id", WalletPayUSecurityQuestionSettingUI.this.tks);
                    WalletPayUSecurityQuestionSettingUI.this.vf.putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.this.tkn.getText());
                    com.tencent.mm.wallet_core.a.j(WalletPayUSecurityQuestionSettingUI.this, WalletPayUSecurityQuestionSettingUI.this.vf);
                    return;
                }
                a.a(WalletPayUSecurityQuestionSettingUI.this.tkt);
            }
        });
        a.a(this.tkt);
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) && this.tkr.isShowing()) {
            this.tkr.dismiss();
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.uJR;
    }

    protected final boolean bKK() {
        return true;
    }
}
