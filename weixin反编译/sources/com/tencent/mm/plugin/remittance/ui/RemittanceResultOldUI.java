package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceResultOldUI extends RemittanceResultUI {
    private int pRF;
    private Orders pVi;
    private String pVj;
    private boolean pVk;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uKG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pVi = (Orders) this.vf.getParcelable("key_orders");
        initView();
        if (this.pRF == 31) {
            String str = "";
            if (this.pVi.sUf.size() > 0) {
                str = ((Commodity) this.pVi.sUf.get(0)).fvD;
            }
            x.i("MicroMsg.RemittanceResultOldUI", "transId: %s", str);
            b.bnS().bnV().dW(str, this.pVj);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boG();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void initView() {
        int i = 1;
        boolean z = false;
        setMMTitle(getString(i.uUK));
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        TextView textView = (TextView) findViewById(f.uCD);
        if (this.pVi != null) {
            textView.setText(e.d(this.pVi.pTQ, this.pVi.pgf));
        }
        PayInfo payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (payInfo == null) {
            x.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
            finish();
            return;
        }
        String str = "";
        if (payInfo.vGl != null) {
            this.pVk = payInfo.vGl.getBoolean("extinfo_key_4");
            str = payInfo.vGl.getString("extinfo_key_1");
        }
        int i2 = payInfo.fDQ;
        this.pRF = i2;
        this.pVj = str;
        str = e.gw(str);
        if (i2 == 31) {
            textView = (TextView) findViewById(f.uCF);
            CharSequence string = getString(i.uCF, new Object[]{str});
            if (bi.oN(string)) {
                textView.setVisibility(8);
            } else {
                textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, string, textView.getTextSize()));
                textView.setVisibility(0);
            }
            findViewById(f.uCw).setVisibility(8);
            if (this.pVi.pQx > 0.0d) {
                ((TextView) findViewById(f.uob)).setText(getResources().getString(i.uUI, new Object[]{e.d(this.pVi.pQx, this.pVi.pgf)}));
                findViewById(f.uoc).setVisibility(0);
            }
        } else {
            String str2 = "";
            if (payInfo.vGl != null) {
                str2 = payInfo.vGl.getString("extinfo_key_2");
            }
            if (i2 == 32 || i2 == 33) {
                str2 = str;
            } else if (bi.oN(str2)) {
                str2 = str + getString(i.uUO);
            } else {
                str2 = str + "（" + e.abk(str2) + "）";
            }
            TextView textView2 = (TextView) findViewById(f.uCF);
            if (bi.oN(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(i.uUJ, new Object[]{str2}), textView2.getTextSize()));
                textView2.setVisibility(0);
            }
            if (i2 == 33 || i2 == 32) {
                View findViewById = findViewById(f.uCB);
                textView2 = (TextView) findViewById(f.uCC);
                TextView textView3 = (TextView) findViewById(f.uCA);
                CharSequence string2 = payInfo.vGl.getString("extinfo_key_3");
                CharSequence string3 = payInfo.vGl.getString("extinfo_key_8");
                if (bi.oN(string2)) {
                    findViewById.setVisibility(8);
                    boolean z2 = false;
                } else {
                    textView3.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, string2, textView3.getTextSize()));
                    findViewById.setVisibility(0);
                    if (bi.oN(string3)) {
                        i2 = 1;
                    } else {
                        textView2.setText(string3);
                        i2 = 1;
                    }
                }
                View findViewById2 = findViewById(f.uCy);
                textView2 = (TextView) findViewById(f.uCz);
                textView3 = (TextView) findViewById(f.uCx);
                string3 = payInfo.vGl.getString("extinfo_key_6");
                CharSequence string4 = payInfo.vGl.getString("extinfo_key_7");
                if (bi.oN(string4)) {
                    findViewById2.setVisibility(8);
                    i = 0;
                } else {
                    textView3.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, string4, textView3.getTextSize()));
                    textView3.setVisibility(0);
                    if (!bi.oN(string3)) {
                        textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, string3, textView2.getTextSize()));
                    }
                }
                if (i2 == 0 && i == 0) {
                    findViewById(f.uCw).setVisibility(8);
                }
            } else if (!(i2 != 5 || this.pVi.sUf == null || this.pVi.sUf.get(0) == null || TextUtils.isEmpty(((Commodity) this.pVi.sUf.get(0)).pfU))) {
                textView2.setText(((Commodity) this.pVi.sUf.get(0)).pfU);
            }
        }
        ((Button) findViewById(f.uCE)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RemittanceResultOldUI.this.boG();
            }
        });
        com.tencent.mm.kernel.g.Dr();
        Object obj = com.tencent.mm.kernel.g.Dq().Db().get(w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.valueOf(false));
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            x.i("MicroMsg.RemittanceResultOldUI", "has show the finger print auth guide!");
            return;
        }
        c ag = com.tencent.mm.wallet_core.a.ag(this);
        Bundle bundle = new Bundle();
        if (ag != null) {
            bundle = ag.mym;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            x.i("MicroMsg.RemittanceResultOldUI", "pwd is empty, not show the finger print auth guide!");
        } else if (ag != null) {
            ag.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void boG() {
        if (this.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RemittanceResultOldUI.this.boH();
                    }
                });
                this.vf.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        boH();
    }

    private void boH() {
        cCT().b((Activity) this, this.vf);
        new ag().postDelayed(new Runnable() {
            public final void run() {
                if (RemittanceResultOldUI.this.pRF == 33 || RemittanceResultOldUI.this.pRF == 32) {
                    RemittanceResultOldUI.this.finish();
                } else if (bi.oN(RemittanceResultOldUI.this.pVj) || RemittanceResultOldUI.this.pVk) {
                    RemittanceResultOldUI.this.finish();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", RemittanceResultOldUI.this.pVj);
                    intent.putExtra("finish_direct", false);
                    d.a(RemittanceResultOldUI.this, ".ui.chatting.ChattingUI", intent);
                }
            }
        }, 100);
    }

    protected final boolean boI() {
        return false;
    }
}
