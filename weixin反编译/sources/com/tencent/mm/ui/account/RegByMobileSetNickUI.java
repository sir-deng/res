package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.y.as;

@Deprecated
public class RegByMobileSetNickUI extends MMActivity implements e {
    private String fBa;
    private ProgressDialog inI = null;
    private EditText xZG;
    private i xZH = null;
    private boolean xZI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xZI = getIntent().getBooleanExtra("is_sync_addr", false);
        this.fBa = getIntent().getExtras().getString("bindmcontact_mobile");
        initView();
        as.CN().a(126, (e) this);
    }

    public void onDestroy() {
        if (this.xZH != null) {
            i iVar = this.xZH;
            u uVar = iVar.xYy;
            uVar.cancel();
            uVar.fia.TN();
            uVar.reset();
            iVar.text = null;
        }
        as.CN().b(126, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dqP;
    }

    protected final void initView() {
        setMMTitle(R.l.eEb);
        this.xZG = (EditText) findViewById(R.h.cHz);
        this.xZG.addTextChangedListener(new c(this.xZG, null, 16));
        addTextOptionMenu(0, getString(R.l.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = RegByMobileSetNickUI.this.xZG.getText().toString().trim();
                if (trim == null || trim.length() <= 0) {
                    h.h(RegByMobileSetNickUI.this, R.l.eSV, R.l.eEe);
                } else {
                    RegByMobileSetNickUI.this.aWY();
                    final k yVar = new y("", RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_pwd"), trim, 0, "", RegByMobileSetNickUI.this.fBa, RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_ticket"), 4);
                    as.CN().a(yVar, 0);
                    RegByMobileSetNickUI regByMobileSetNickUI = RegByMobileSetNickUI.this;
                    Context context = RegByMobileSetNickUI.this;
                    RegByMobileSetNickUI.this.getString(R.l.dGZ);
                    regByMobileSetNickUI.inI = h.a(context, RegByMobileSetNickUI.this.getString(R.l.eEu), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(yVar);
                        }
                    });
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByMobileSetNickUI.this.aWY();
                RegByMobileSetNickUI.this.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, int r9, java.lang.String r10, com.tencent.mm.ad.k r11) {
        /*
        r7 = this;
        r2 = 2;
        r6 = 0;
        r3 = 0;
        r1 = 1;
        r0 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "onSceneEnd: errType = ";
        r4.<init>(r5);
        r4 = r4.append(r8);
        r5 = " errCode = ";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r5 = " errMsg = ";
        r4 = r4.append(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r4);
        r0 = r7.inI;
        if (r0 == 0) goto L_0x003b;
    L_0x0034:
        r0 = r7.inI;
        r0.dismiss();
        r7.inI = r6;
    L_0x003b:
        r0 = com.tencent.mm.sdk.platformtools.bi.bF(r7);
        if (r0 != 0) goto L_0x0042;
    L_0x0041:
        return;
    L_0x0042:
        if (r8 != 0) goto L_0x0104;
    L_0x0044:
        if (r9 != 0) goto L_0x0104;
    L_0x0046:
        r0 = com.tencent.mm.y.q.Gc();
        r3 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "Reg By mobile status = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r5 = " isSync = ";
        r4 = r4.append(r5);
        r5 = r7.xZI;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.d(r3, r4);
        r3 = r7.xZI;
        if (r3 == 0) goto L_0x00f2;
    L_0x0071:
        r3 = -131073; // 0xfffffffffffdffff float:NaN double:NaN;
        r0 = r0 & r3;
        com.tencent.mm.modelfriend.m.NQ();
        r7.getApplicationContext();
        com.tencent.mm.modelfriend.a.Ns();
    L_0x007e:
        r3 = "MicroMsg.RegByMobileSetNickUI";
        r4 = new java.lang.StringBuilder;
        r5 = "Reg By mobile update = ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.d(r3, r4);
        com.tencent.mm.y.as.Hm();
        r3 = com.tencent.mm.y.c.Db();
        r4 = 7;
        r0 = java.lang.Integer.valueOf(r0);
        r3.set(r4, r0);
        r0 = r7.xZI;
        if (r0 != 0) goto L_0x00f6;
    L_0x00a7:
        r0 = r1;
    L_0x00a8:
        com.tencent.mm.y.as.Hm();
        r2 = com.tencent.mm.y.c.Fe();
        r3 = new com.tencent.mm.ax.g;
        r4 = 17;
        r3.<init>(r4, r0);
        r2.b(r3);
        r0 = com.tencent.mm.plugin.c.a.ihO;
        r0.un();
        r0 = com.tencent.mm.y.ar.hhz;
        r2 = "login_user_name";
        r3 = r7.fBa;
        r0.S(r2, r3);
        r0 = com.tencent.mm.plugin.c.a.ihN;
        r0 = r0.at(r7);
        r2 = "LauncherUI.enter_from_reg";
        r0.putExtra(r2, r1);
        r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r0.addFlags(r2);
        r11 = (com.tencent.mm.modelsimple.y) r11;
        r2 = r11.hPK;
        if (r2 == 0) goto L_0x00f8;
    L_0x00df:
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.ui.bindqq.BindQQUI.class;
        r2.<init>(r7, r3);
        r3 = "bindqq_regbymobile";
        r1 = r2.putExtra(r3, r1);
        com.tencent.mm.ui.MMWizardActivity.b(r7, r1, r0);
        goto L_0x0041;
    L_0x00f2:
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r0 = r0 | r3;
        goto L_0x007e;
    L_0x00f6:
        r0 = r2;
        goto L_0x00a8;
    L_0x00f8:
        r1 = new android.content.Intent;
        r2 = com.tencent.mm.ui.account.BindFacebookUI.class;
        r1.<init>(r7, r2);
        com.tencent.mm.ui.MMWizardActivity.b(r7, r1, r0);
        goto L_0x0041;
    L_0x0104:
        r0 = r11.getType();
        r4 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        if (r0 != r4) goto L_0x0117;
    L_0x010c:
        r0 = com.tencent.mm.g.a.eC(r10);
        if (r0 == 0) goto L_0x0117;
    L_0x0112:
        r0.a(r7, r6, r6);
        goto L_0x0041;
    L_0x0117:
        r0 = com.tencent.mm.plugin.c.a.ihO;
        r4 = r7.mController;
        r4 = r4.xRr;
        r0 = r0.a(r4, r8, r9, r10);
        if (r0 == 0) goto L_0x0143;
    L_0x0123:
        r0 = r1;
    L_0x0124:
        if (r0 != 0) goto L_0x0041;
    L_0x0126:
        r0 = com.tencent.mm.R.l.ejm;
        r2 = new java.lang.Object[r2];
        r4 = java.lang.Integer.valueOf(r8);
        r2[r3] = r4;
        r4 = java.lang.Integer.valueOf(r9);
        r2[r1] = r4;
        r0 = r7.getString(r0, r2);
        r0 = android.widget.Toast.makeText(r7, r0, r3);
        r0.show();
        goto L_0x0041;
    L_0x0143:
        switch(r8) {
            case 4: goto L_0x0148;
            default: goto L_0x0146;
        };
    L_0x0146:
        r0 = r3;
        goto L_0x0124;
    L_0x0148:
        r0 = -7;
        if (r9 == r0) goto L_0x014f;
    L_0x014b:
        r0 = -10;
        if (r9 != r0) goto L_0x0158;
    L_0x014f:
        r0 = com.tencent.mm.R.l.eDi;
        r4 = com.tencent.mm.R.l.eDj;
        com.tencent.mm.ui.base.h.h(r7, r0, r4);
        r0 = r1;
        goto L_0x0124;
    L_0x0158:
        r0 = -75;
        if (r9 != r0) goto L_0x0146;
    L_0x015c:
        r0 = com.tencent.mm.R.l.dDR;
        r4 = com.tencent.mm.R.l.eDj;
        com.tencent.mm.ui.base.h.h(r7, r0, r4);
        r0 = r1;
        goto L_0x0124;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.RegByMobileSetNickUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }
}
