package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.a;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class RegByMobileSendSmsUI extends MMActivity implements e {
    private String bgo;
    private String fsK;
    private al jcp;
    private String mHK;
    private String xWn = "";
    private String xXB = "";
    private boolean xYV;
    private String xZr = "";
    private String xZs = "";
    private a xZt;
    private ProgressDialog xZu;
    private int xZv;
    private Button xZw;
    private Button xZx;
    private int xZy = 15;
    private SecurityImage xZz;

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        regByMobileSendSmsUI.xZx.setEnabled(false);
        if (regByMobileSendSmsUI.jcp != null) {
            regByMobileSendSmsUI.jcp.TN();
            regByMobileSendSmsUI.xZy = 15;
            regByMobileSendSmsUI.xZv = 0;
            regByMobileSendSmsUI.jcp.K(0, 1000);
            return;
        }
        regByMobileSendSmsUI.jcp = new al(new al.a() {
            public final boolean uG() {
                if (RegByMobileSendSmsUI.this.xZy > 0) {
                    RegByMobileSendSmsUI.this.xZx.setText(RegByMobileSendSmsUI.this.getString(R.l.eEa, new Object[]{Integer.valueOf(RegByMobileSendSmsUI.this.xZy)}));
                    RegByMobileSendSmsUI.this.xZy = RegByMobileSendSmsUI.this.xZy - 1;
                    if (RegByMobileSendSmsUI.this.xZy % 4 != 0) {
                        return true;
                    }
                    RegByMobileSendSmsUI.p(RegByMobileSendSmsUI.this);
                    return true;
                }
                RegByMobileSendSmsUI.this.xZx.setText(R.l.eDT);
                RegByMobileSendSmsUI.this.xZx.setEnabled(true);
                return false;
            }
        }, true);
        regByMobileSendSmsUI.jcp.K(0, 1000);
    }

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI, String str, String str2) {
        as.CN().a(701, (e) regByMobileSendSmsUI);
        regByMobileSendSmsUI.xZt = new a(new a.a() {
            public final void b(ProgressDialog progressDialog) {
                RegByMobileSendSmsUI.this.xZu = progressDialog;
            }
        }, str, str2, regByMobileSendSmsUI.xZr);
        regByMobileSendSmsUI.xZt.j(regByMobileSendSmsUI);
    }

    static /* synthetic */ void p(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        regByMobileSendSmsUI.xZv++;
        if (regByMobileSendSmsUI.xZv <= 4) {
            k sVar = new s(regByMobileSendSmsUI.xZr, 15, "", 0, "");
            ((m.a) sVar.hoZ.Kh()).vIg.vTc = 1;
            g.CN().a(sVar, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xZr = bi.oM(getIntent().getStringExtra("from_mobile"));
        this.xZs = bi.oM(getIntent().getStringExtra("to_mobile"));
        this.xWn = bi.oM(getIntent().getStringExtra("verify_code"));
        this.xXB = bi.oM(getIntent().getStringExtra("regsession_id"));
        this.bgo = bi.oM(getIntent().getStringExtra("kintent_nickname"));
        this.mHK = bi.oM(getIntent().getStringExtra("kintent_password"));
        this.xYV = getIntent().getBooleanExtra("kintent_hasavatar", false);
        initView();
    }

    protected final void initView() {
        super.initView();
        ((TextView) findViewById(R.h.cLE)).setText(getString(R.l.eDX, new Object[]{this.xZr}));
        ((TextView) findViewById(R.h.cLD)).setText(Zg(getString(R.l.eDW, new Object[]{this.xWn})));
        ((TextView) findViewById(R.h.cLF)).setText(Zg(getString(R.l.eDZ, new Object[]{this.xZs})));
        this.xZw = (Button) findViewById(R.h.cLC);
        this.xZx = (Button) findViewById(R.h.cnM);
        if (bi.G(this.xZr, this.xZs, this.xWn)) {
            this.xZw.setEnabled(false);
            this.xZx.setEnabled(false);
        } else {
            this.xZx.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this);
                }
            });
        }
        if (bi.oN(q.getSimCountryIso())) {
            this.xZw.setVisibility(8);
        } else {
            this.xZw.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.this.xZs));
                    intent.putExtra("sms_body", RegByMobileSendSmsUI.this.xWn);
                    try {
                        RegByMobileSendSmsUI.this.startActivity(intent);
                        RegByMobileSendSmsUI.this.overridePendingTransition(R.a.bqB, R.a.bqA);
                    } catch (Exception e) {
                        x.e("MicroMsg.RegByMobileSendSmsUI", e.getMessage());
                    }
                }
            });
        }
        setMMTitle(R.l.eDY);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByMobileSendSmsUI.this.goBack();
                return true;
            }
        });
    }

    private j Zg(String str) {
        j jVar = new j(str);
        x.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", str);
        int indexOf = str.indexOf(32) + 1;
        jVar.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.f.bvv)), indexOf, str.length(), 33);
        jVar.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.bsE)), indexOf, str.length(), 33);
        return jVar;
    }

    protected final int getLayoutId() {
        return R.i.dqO;
    }

    protected void onResume() {
        super.onResume();
        g.CN().a((int) c.CTRL_INDEX, (e) this);
    }

    protected void onStop() {
        super.onStop();
        TN();
        g.CN().b((int) c.CTRL_INDEX, (e) this);
    }

    public final void a(int r19, int r20, java.lang.String r21, com.tencent.mm.ad.k r22) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r18 = this;
        r2 = "MicroMsg.RegByMobileSendSmsUI";
        r3 = "errType %s, errCode %d, errMsg %s";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r19);
        r4[r5] = r6;
        r5 = 1;
        r6 = java.lang.Integer.valueOf(r20);
        r4[r5] = r6;
        r5 = 2;
        r4[r5] = r21;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r0 = r18;
        r2 = r0.xZu;
        if (r2 == 0) goto L_0x002a;
    L_0x0023:
        r0 = r18;
        r2 = r0.xZu;
        r2.dismiss();
    L_0x002a:
        r2 = r22.getType();
        r3 = 145; // 0x91 float:2.03E-43 double:7.16E-322;
        if (r2 != r3) goto L_0x0205;
    L_0x0032:
        r2 = r22;
        r2 = (com.tencent.mm.modelfriend.s) r2;
        r2 = r2.IY();
        r3 = 15;
        if (r2 != r3) goto L_0x0205;
    L_0x003e:
        r22 = (com.tencent.mm.modelfriend.s) r22;
        r2 = r22.Oc();
        r0 = r18;
        r0.fsK = r2;
        if (r20 != 0) goto L_0x0113;
    L_0x004a:
        r18.TN();
        r2 = com.tencent.mm.y.bi.HU();
        r2 = r2.HV();
        if (r2 <= 0) goto L_0x00cb;
    L_0x0057:
        r2 = com.tencent.mm.y.as.CN();
        r3 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r0 = r18;
        r2.a(r3, r0);
        r2 = new com.tencent.mm.modelsimple.y;
        r3 = "";
        r0 = r18;
        r4 = r0.mHK;
        r0 = r18;
        r5 = r0.bgo;
        r6 = 0;
        r7 = "";
        r0 = r18;
        r8 = r0.xZr;
        r9 = "";
        r10 = "";
        r0 = r18;
        r11 = r0.fsK;
        r12 = 1;
        r13 = "";
        r14 = "";
        r15 = "";
        r16 = 1;
        r0 = r18;
        r0 = r0.xYV;
        r17 = r0;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        r0 = r18;
        r3 = r0.xXB;
        r2.mB(r3);
        r3 = 1;
        r2.iv(r3);
        r3 = com.tencent.mm.y.as.CN();
        r4 = 0;
        r3.a(r2, r4);
        r3 = com.tencent.mm.R.l.dGZ;
        r0 = r18;
        r0.getString(r3);
        r3 = com.tencent.mm.R.l.eEu;
        r0 = r18;
        r3 = r0.getString(r3);
        r4 = 1;
        r5 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$11;
        r0 = r18;
        r5.<init>(r2);
        r0 = r18;
        r2 = com.tencent.mm.ui.base.h.a(r0, r3, r4, r5);
        r0 = r18;
        r0.xZu = r2;
    L_0x00ca:
        return;
    L_0x00cb:
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "regsetinfo_ticket";
        r0 = r18;
        r4 = r0.fsK;
        r2.putExtra(r3, r4);
        r3 = "regsetinfo_user";
        r0 = r18;
        r4 = r0.xZr;
        r2.putExtra(r3, r4);
        r3 = "regsession_id";
        r0 = r18;
        r4 = r0.xXB;
        r2.putExtra(r3, r4);
        r3 = "mobile_check_type";
        r4 = 1;
        r2.putExtra(r3, r4);
        r3 = "regsetinfo_ismobile";
        r4 = 1;
        r2.putExtra(r3, r4);
        r3 = "regsetinfo_NextControl";
        r4 = r22.Oi();
        r2.putExtra(r3, r4);
        r3 = com.tencent.mm.ui.account.RegSetInfoUI.class;
        r0 = r18;
        r2.setClass(r0, r3);
        r0 = r18;
        r0.startActivity(r2);
        goto L_0x00ca;
    L_0x0113:
        r2 = -35;
        r0 = r20;
        if (r0 != r2) goto L_0x0158;
    L_0x0119:
        r18.TN();
        r2 = com.tencent.mm.g.a.eC(r21);
        if (r2 == 0) goto L_0x0138;
    L_0x0122:
        r3 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$12;
        r0 = r18;
        r1 = r22;
        r3.<init>(r1);
        r4 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$13;
        r0 = r18;
        r4.<init>();
        r0 = r18;
        r2.a(r0, r3, r4);
        goto L_0x00ca;
    L_0x0138:
        r2 = com.tencent.mm.R.l.dKO;
        r0 = r18;
        r2 = r0.getString(r2);
        r3 = 0;
        r4 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$14;
        r0 = r18;
        r1 = r22;
        r4.<init>(r1);
        r5 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$15;
        r0 = r18;
        r5.<init>();
        r0 = r18;
        com.tencent.mm.ui.base.h.a(r0, r2, r3, r4, r5);
        goto L_0x00ca;
    L_0x0158:
        r2 = -212; // 0xffffffffffffff2c float:NaN double:NaN;
        r0 = r20;
        if (r0 != r2) goto L_0x01e6;
    L_0x015e:
        r18.TN();
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.ui.account.mobile.MobileLoginOrForceReg.class;
        r0 = r18;
        r2.<init>(r0, r3);
        r3 = "ticket";
        r0 = r18;
        r4 = r0.fsK;
        r2.putExtra(r3, r4);
        r3 = "moble";
        r0 = r18;
        r4 = r0.xZr;
        r2.putExtra(r3, r4);
        r3 = "regsession_id";
        r0 = r18;
        r4 = r0.xXB;
        r2.putExtra(r3, r4);
        r3 = "next_controll";
        r4 = r22.Oi();
        r2.putExtra(r3, r4);
        r3 = "username";
        r4 = r22.getUsername();
        r2.putExtra(r3, r4);
        r3 = "password";
        r4 = r22.Ob();
        r2.putExtra(r3, r4);
        r3 = "nickname";
        r4 = r22.Op();
        r2.putExtra(r3, r4);
        r3 = "avatar_url";
        r4 = r22.Oo();
        r2.putExtra(r3, r4);
        r3 = "mobile_check_type";
        r4 = 1;
        r2.putExtra(r3, r4);
        r3 = "kintent_hasavatar";
        r0 = r18;
        r4 = r0.xYV;
        r2.putExtra(r3, r4);
        r3 = "kintent_nickname";
        r0 = r18;
        r4 = r0.bgo;
        r2.putExtra(r3, r4);
        r3 = "kintent_password";
        r0 = r18;
        r4 = r0.mHK;
        r2.putExtra(r3, r4);
        r0 = r18;
        r0.startActivity(r2);
        goto L_0x00ca;
    L_0x01e6:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r21);
        if (r2 != 0) goto L_0x00ca;
    L_0x01ec:
        r0 = r18;
        r2 = r0.xZv;
        r3 = 4;
        if (r2 < r3) goto L_0x00ca;
    L_0x01f3:
        r2 = com.tencent.mm.g.a.eC(r21);
        if (r2 == 0) goto L_0x00ca;
    L_0x01f9:
        r3 = 0;
        r4 = 0;
        r0 = r18;
        r2 = r2.a(r0, r3, r4);
        if (r2 == 0) goto L_0x00ca;
    L_0x0203:
        goto L_0x00ca;
    L_0x0205:
        r2 = r22.getType();
        r3 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        if (r2 != r3) goto L_0x00ca;
    L_0x020d:
        r12 = r22;
        r12 = (com.tencent.mm.modelsimple.y) r12;
        r2 = -6;
        r0 = r20;
        if (r0 == r2) goto L_0x0222;
    L_0x0216:
        r2 = -311; // 0xfffffffffffffec9 float:NaN double:NaN;
        r0 = r20;
        if (r0 == r2) goto L_0x0222;
    L_0x021c:
        r2 = -310; // 0xfffffffffffffeca float:NaN double:NaN;
        r0 = r20;
        if (r0 != r2) goto L_0x0273;
    L_0x0222:
        r0 = r18;
        r2 = r0.xZz;
        if (r2 != 0) goto L_0x0258;
    L_0x0228:
        r3 = com.tencent.mm.R.l.eEv;
        r4 = 0;
        r5 = r12.Ou();
        r6 = r12.Ov();
        r7 = "";
        r8 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$16;
        r0 = r18;
        r8.<init>(r12);
        r9 = 0;
        r10 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$2;
        r0 = r18;
        r10.<init>();
        r11 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$3;
        r0 = r18;
        r11.<init>(r12);
        r2 = r18;
        r2 = com.tencent.mm.ui.applet.SecurityImage.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        r0 = r18;
        r0.xZz = r2;
        goto L_0x00ca;
    L_0x0258:
        r0 = r18;
        r3 = r0.xZz;
        r4 = 0;
        r2 = r22;
        r2 = (com.tencent.mm.modelsimple.y) r2;
        r2 = r2.Ou();
        r22 = (com.tencent.mm.modelsimple.y) r22;
        r5 = r22.Ov();
        r6 = "";
        r3.a(r4, r2, r5, r6);
        goto L_0x00ca;
    L_0x0273:
        if (r19 != 0) goto L_0x0374;
    L_0x0275:
        if (r20 != 0) goto L_0x0374;
    L_0x0277:
        r0 = r18;
        r8 = r0.xZr;
        com.tencent.mm.y.as.unhold();
        r2 = 1;
        com.tencent.mm.y.as.bA(r2);
        r0 = r18;
        r2 = r0.xYV;
        if (r2 == 0) goto L_0x02ff;
    L_0x0288:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = com.tencent.mm.compatible.util.e.gJm;
        r2 = r2.append(r3);
        r3 = "temp.avatar";
        r2 = r2.append(r3);
        r7 = r2.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = com.tencent.mm.compatible.util.e.gJm;
        r2 = r2.append(r3);
        r3 = "temp.avatar.hd";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = new java.io.File;
        r3.<init>(r7);
        r4 = new java.io.File;
        r4.<init>(r2);
        r3.renameTo(r4);
        com.tencent.mm.loader.stub.b.deleteFile(r7);
        r3 = 96;
        r4 = 96;
        r5 = android.graphics.Bitmap.CompressFormat.JPEG;
        r6 = 90;
        com.tencent.mm.sdk.platformtools.d.b(r2, r3, r4, r5, r6, r7);
        r2 = new com.tencent.mm.pluginsdk.model.p;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = com.tencent.mm.compatible.util.e.gJm;
        r3 = r3.append(r4);
        r4 = "temp.avatar";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r0 = r18;
        r2.<init>(r0, r3);
        r3 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$4;
        r0 = r18;
        r3.<init>(r12, r8);
        r4 = new com.tencent.mm.ui.account.RegByMobileSendSmsUI$5;
        r0 = r18;
        r4.<init>(r12, r8);
        r2.a(r3, r4);
        goto L_0x00ca;
    L_0x02ff:
        r2 = r12.So();
        r0 = r18;
        r0.fsK = r2;
        r2 = com.tencent.mm.y.ar.hhz;
        r3 = "login_user_name";
        r2.S(r3, r8);
        r2 = com.tencent.mm.plugin.c.a.ihN;
        r0 = r18;
        r2 = r2.at(r0);
        r3 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r2.addFlags(r3);
        r3 = "LauncherUI.enter_from_reg";
        r4 = 1;
        r2.putExtra(r3, r4);
        r0 = r18;
        r0.startActivity(r2);
        r18.finish();
        r2 = "RE900_100";
        com.tencent.mm.plugin.c.b.oZ(r2);
        r2 = 0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = com.tencent.mm.y.as.CI();
        r3 = r3.append(r4);
        r4 = ",";
        r3 = r3.append(r4);
        r4 = r18.getClass();
        r4 = r4.getName();
        r3 = r3.append(r4);
        r4 = ",R200_600,";
        r3 = r3.append(r4);
        r4 = "R200_600";
        r4 = com.tencent.mm.y.as.fJ(r4);
        r3 = r3.append(r4);
        r4 = ",4";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.plugin.c.b.b(r2, r3);
        goto L_0x00ca;
    L_0x0374:
        r2 = com.tencent.mm.g.a.eC(r21);
        if (r2 == 0) goto L_0x00ca;
    L_0x037a:
        r3 = 0;
        r4 = 0;
        r0 = r18;
        r2.a(r0, r3, r4);
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.RegByMobileSendSmsUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }

    private void TN() {
        if (this.jcp != null) {
            this.jcp.TN();
        }
        this.xZx.setText(R.l.eDT);
        this.xZx.setEnabled(true);
    }

    private void goBack() {
        h.a((Context) this, getString(R.l.eDV), "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                RegByMobileSendSmsUI.this.TN();
                RegByMobileSendSmsUI.this.finish();
            }
        }, null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }
}
