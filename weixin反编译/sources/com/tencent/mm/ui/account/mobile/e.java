package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.ShowAgreementsUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;

public final class e implements com.tencent.mm.ad.e, b {
    private String fJB;
    String hPj;
    String mHK;
    private String pXJ;
    private String qmX;
    SecurityImage xSF = null;
    private String xXA;
    private String xXB;
    private String xXC;
    private int xXD;
    private boolean xXu = true;
    private int xXz;
    MobileInputUI ycs;
    int ycx;

    /* renamed from: com.tencent.mm.ui.account.mobile.e$9 */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] ycu = new int[a.cpn().length];

        static {
            try {
                ycu[a.ycR - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    static /* synthetic */ void a(e eVar, String str) {
        final k sVar = new s(str, 16, "", 0, "");
        as.CN().a(sVar, 0);
        MobileInputUI mobileInputUI = eVar.ycs;
        Context context = eVar.ycs;
        eVar.ycs.getString(R.l.dGZ);
        mobileInputUI.xXM = h.a(context, eVar.ycs.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(sVar);
            }
        });
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.ycs = mobileInputUI;
        mobileInputUI.ycI.setVisibility(0);
        this.hPj = mobileInputUI.getIntent().getStringExtra("binded_mobile");
        if (bi.oN(this.hPj)) {
            this.hPj = ap.VQ(mobileInputUI.ycK + mobileInputUI.pny);
        }
        mobileInputUI.ycE.setTextColor(mobileInputUI.getResources().getColor(R.e.bsO));
        mobileInputUI.ycE.setEnabled(false);
        mobileInputUI.ycE.setFocusable(false);
        mobileInputUI.ycD.setFocusable(false);
        mobileInputUI.ycD.setText(ap.VQ(this.hPj));
        mobileInputUI.ycD.setVisibility(0);
        bjk();
        mobileInputUI.ycJ.setVisibility(0);
        mobileInputUI.xYT.setText(R.l.etN);
        mobileInputUI.xYT.setVisibility(0);
        mobileInputUI.xYT.setEnabled(true);
        this.qmX = ar.hhz.H("login_weixin_username", "");
        this.pXJ = mobileInputUI.getIntent().getStringExtra("auth_ticket");
        if (!bi.oN(this.pXJ)) {
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    e.this.fR(f.coH(), f.coI());
                }
            }, 500);
        }
    }

    private void bjk() {
        if (this.ycs.hhQ == 6) {
            this.ycs.ycF.reset();
            this.ycs.ycJ.setText(R.l.etP);
            this.ycs.xYh.setVisibility(8);
            this.ycs.ycF.setVisibility(0);
            this.ycs.ycF.pwv.requestFocus();
            this.ycs.ycF.yjj = new OnClickListener() {
                public final void onClick(View view) {
                    h.a(e.this.ycs, e.this.ycs.getString(R.l.eEk) + e.this.hPj, e.this.ycs.getString(R.l.eEl), e.this.ycs.getString(R.l.dGf), e.this.ycs.getString(R.l.dEy), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            e.this.ycs.ycF.cpN();
                            e.a(e.this, e.this.hPj);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            e.this.ycs.ycF.reset();
                        }
                    });
                }
            };
            this.ycs.ycJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    e.this.ycs.ofG[1] = 2;
                    e.this.ycs.hhQ = 7;
                    e.this.ycs.ycF.reset();
                    as.CN().b((int) c.CTRL_INDEX, e.this);
                    e.this.bjk();
                }
            });
        } else if (this.ycs.hhQ == 7) {
            this.ycs.ycJ.setText(R.l.etQ);
            this.ycs.xYh.setVisibility(0);
            this.ycs.lYV.requestFocus();
            this.ycs.ycF.setVisibility(8);
            this.ycs.ycJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    e.this.ycs.ofG[1] = 1;
                    e.this.ycs.hhQ = 6;
                    as.CN().a((int) c.CTRL_INDEX, e.this);
                    e.this.bjk();
                }
            });
        }
    }

    public final void start() {
        as.CN().a(701, (com.tencent.mm.ad.e) this);
        as.CN().a((int) c.CTRL_INDEX, (com.tencent.mm.ad.e) this);
        com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",L200_100," + as.fJ("L200_100") + ",1");
        com.tencent.mm.plugin.c.b.oY("L200_100");
    }

    public final void stop() {
        as.CN().b(701, (com.tencent.mm.ad.e) this);
        as.CN().b((int) c.CTRL_INDEX, (com.tencent.mm.ad.e) this);
        com.tencent.mm.plugin.c.b.b(false, as.CI() + "," + getClass().getName() + ",L200_100," + as.fJ("L200_100") + ",2");
    }

    public final void EB(int i) {
        switch (AnonymousClass9.ycu[i - 1]) {
            case 1:
                this.ycs.aWY();
                switch (this.ycx) {
                    case 1:
                        coE();
                        return;
                    case 2:
                        cpk();
                        return;
                    default:
                        if (this.xXz == -355) {
                            m.c(this.ycs, this.xXA, 32046);
                            return;
                        } else if (this.xXz == -30) {
                            cpk();
                            return;
                        } else {
                            this.ycs.ycK = ap.VS(this.ycs.countryCode);
                            this.ycs.pny = this.ycs.ycE.getText().toString();
                            if (!bi.oN(this.ycs.ycK) && !bi.oN(this.ycs.pny)) {
                                if (this.ycs.hhQ == 7) {
                                    if (bi.oN(this.mHK)) {
                                        fR(this.hPj, this.ycs.lYV.getText().toString());
                                        return;
                                    } else {
                                        fR(this.hPj, this.mHK);
                                        return;
                                    }
                                } else if (this.ycs.hhQ == 6) {
                                    String trim = this.ycs.ycF.getText().toString().trim();
                                    if (bi.oN(trim)) {
                                        h.h(this.ycs, R.l.eTe, R.l.etJ);
                                        return;
                                    }
                                    this.ycs.aWY();
                                    final k sVar = new s(this.hPj, 17, trim, 0, "");
                                    as.CN().a(sVar, 0);
                                    MobileInputUI mobileInputUI = this.ycs;
                                    Context context = this.ycs;
                                    this.ycs.getString(R.l.dGZ);
                                    mobileInputUI.xXM = h.a(context, this.ycs.getString(R.l.dLI), true, new OnCancelListener() {
                                        public final void onCancel(DialogInterface dialogInterface) {
                                            as.CN().c(sVar);
                                        }
                                    });
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                }
            default:
                return;
        }
    }

    private void fR(String str, String str2) {
        if (bi.oN(str)) {
            h.h(this.ycs, R.l.eTf, R.l.etJ);
        } else if (bi.oN(str2)) {
            h.h(this.ycs, R.l.eTc, R.l.etJ);
        } else {
            this.ycs.lYV.setText(str2);
            this.ycs.aWY();
            final k vVar = new v(str, str2, null, 1);
            as.CN().a(vVar, 0);
            MobileInputUI mobileInputUI = this.ycs;
            Context context = this.ycs;
            this.ycs.getString(R.l.dGZ);
            mobileInputUI.xXM = h.a(context, this.ycs.getString(R.l.etS), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(vVar);
                }
            });
        }
    }

    private void cpk() {
        Intent intent = new Intent();
        intent.putExtra("regsetinfo_ticket", this.xXC);
        intent.putExtra("regsetinfo_user", this.hPj);
        intent.putExtra("regsession_id", this.xXB);
        intent.putExtra("regsetinfo_ismobile", 1);
        intent.putExtra("regsetinfo_NextControl", this.xXD);
        intent.setClass(this.ycs, RegSetInfoUI.class);
        com.tencent.mm.plugin.c.b.oZ("R200_950_olduser");
        this.ycs.startActivity(intent);
        com.tencent.mm.plugin.c.b.pa(as.CI() + "," + getClass().getName() + ",L200_900_phone," + as.fJ("L200_900_phone") + ",2");
    }

    final void coE() {
        Intent intent = new Intent(this.ycs, ShowAgreementsUI.class);
        intent.putExtra("agreement_type", 0);
        this.ycs.startActivityForResult(intent, 32047);
    }

    public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.ad.k r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r8 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r6 = 2;
        r7 = 0;
        r2 = 1;
        r1 = 0;
        r0 = "MicroMsg.MobileInputIndepPassLoginLogic";
        r3 = new java.lang.StringBuilder;
        r4 = "onSceneEnd: errType = ";
        r3.<init>(r4);
        r3 = r3.append(r11);
        r4 = " errCode = ";
        r3 = r3.append(r4);
        r3 = r3.append(r12);
        r4 = " errMsg = ";
        r3 = r3.append(r4);
        r3 = r3.append(r13);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r0 = r10.ycs;
        r0 = r0.xXM;
        if (r0 == 0) goto L_0x0043;
    L_0x0038:
        r0 = r10.ycs;
        r0 = r0.xXM;
        r0.dismiss();
        r0 = r10.ycs;
        r0.xXM = r7;
    L_0x0043:
        r0 = r14.getType();
        r3 = 145; // 0x91 float:2.03E-43 double:7.16E-322;
        if (r0 != r3) goto L_0x01e3;
    L_0x004b:
        r0 = r14;
        r0 = (com.tencent.mm.modelfriend.s) r0;
        r0 = r0.IY();
        r3 = 16;
        if (r0 != r3) goto L_0x0087;
    L_0x0056:
        r0 = -41;
        if (r12 != r0) goto L_0x006b;
    L_0x005a:
        r0 = r10.ycs;
        r0 = r0.ycF;
        r0.reset();
        r0 = r10.ycs;
        r1 = com.tencent.mm.R.l.eDR;
        r2 = com.tencent.mm.R.l.eDS;
        com.tencent.mm.ui.base.h.h(r0, r1, r2);
    L_0x006a:
        return;
    L_0x006b:
        r0 = -75;
        if (r12 != r0) goto L_0x01cf;
    L_0x006f:
        r0 = r10.ycs;
        r0 = r0.ycF;
        r0.reset();
        r0 = r10.ycs;
        r1 = r10.ycs;
        r3 = com.tencent.mm.R.l.dDQ;
        r1 = r1.getString(r3);
        r3 = "";
        com.tencent.mm.ui.base.h.b(r0, r1, r3, r2);
        goto L_0x006a;
    L_0x0087:
        r3 = 17;
        if (r0 != r3) goto L_0x01cf;
    L_0x008b:
        r10.xXz = r12;
        r10.xXA = r13;
        if (r11 != 0) goto L_0x00b2;
    L_0x0091:
        if (r12 != 0) goto L_0x00b2;
    L_0x0093:
        r1 = new com.tencent.mm.ui.account.mobile.a;
        r2 = new com.tencent.mm.ui.account.mobile.e$16;
        r2.<init>();
        r0 = r14;
        r0 = (com.tencent.mm.modelfriend.s) r0;
        r0 = r0.getUsername();
        r14 = (com.tencent.mm.modelfriend.s) r14;
        r3 = r14.Ob();
        r4 = r10.hPj;
        r1.<init>(r2, r0, r3, r4);
        r0 = r10.ycs;
        r1.j(r0);
        goto L_0x006a;
    L_0x00b2:
        r0 = r14;
        r0 = (com.tencent.mm.modelfriend.s) r0;
        r0 = r0.Oq();
        r10.xXB = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelfriend.s) r0;
        r0 = r0.Oc();
        r10.xXC = r0;
        r14 = (com.tencent.mm.modelfriend.s) r14;
        r0 = r14.Oi();
        r10.xXD = r0;
        r0 = -355; // 0xfffffffffffffe9d float:NaN double:NaN;
        if (r12 == r0) goto L_0x00d4;
    L_0x00d0:
        r0 = -30;
        if (r12 != r0) goto L_0x01ad;
    L_0x00d4:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = com.tencent.mm.y.as.CI();
        r0 = r0.append(r3);
        r3 = ",";
        r0 = r0.append(r3);
        r3 = r10.getClass();
        r3 = r3.getName();
        r0 = r0.append(r3);
        r3 = ",L200_900_phone,";
        r0 = r0.append(r3);
        r3 = "L200_900_phone";
        r3 = com.tencent.mm.y.as.fJ(r3);
        r0 = r0.append(r3);
        r3 = ",1";
        r0 = r0.append(r3);
        r0 = r0.toString();
        com.tencent.mm.plugin.c.b.pa(r0);
        r0 = com.tencent.mm.protocal.d.vHo;
        if (r0 == 0) goto L_0x0192;
    L_0x0118:
        r0 = r10.ycs;
        r3 = com.tencent.mm.R.l.dXX;
        r4 = new java.lang.Object[r6];
        r5 = new java.lang.StringBuilder;
        r6 = "0x";
        r5.<init>(r6);
        r6 = com.tencent.mm.protocal.d.vHl;
        r6 = java.lang.Integer.toHexString(r6);
        r5 = r5.append(r6);
        r5 = r5.toString();
        r4[r1] = r5;
        r5 = com.tencent.mm.sdk.platformtools.w.cfV();
        r4[r2] = r5;
        r0 = r0.getString(r3, r4);
        r3 = "MicroMsg.MobileInputIndepPassLoginLogic";
        r4 = new java.lang.StringBuilder;
        r5 = "url ";
        r4.<init>(r5);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.e(r3, r4);
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = "rawUrl";
        r3.putExtra(r4, r0);
        r0 = "showShare";
        r3.putExtra(r0, r1);
        r0 = "show_bottom";
        r3.putExtra(r0, r1);
        r0 = "needRedirect";
        r3.putExtra(r0, r1);
        r0 = "neverGetA8Key";
        r3.putExtra(r0, r2);
        r0 = "hardcode_jspermission";
        r1 = com.tencent.mm.protocal.JsapiPermissionWrapper.vHy;
        r3.putExtra(r0, r1);
        r0 = "hardcode_general_ctrl";
        r1 = com.tencent.mm.protocal.GeneralControlWrapper.vHv;
        r3.putExtra(r0, r1);
        r0 = com.tencent.mm.plugin.c.a.ihN;
        r1 = r10.ycs;
        r0.j(r3, r1);
        goto L_0x006a;
    L_0x0192:
        r0 = -355; // 0xfffffffffffffe9d float:NaN double:NaN;
        if (r12 != r0) goto L_0x019b;
    L_0x0196:
        r10.coE();
        goto L_0x006a;
    L_0x019b:
        r0 = com.tencent.mm.g.a.eC(r13);
        if (r0 == 0) goto L_0x006a;
    L_0x01a1:
        r1 = r10.ycs;
        r2 = new com.tencent.mm.ui.account.mobile.e$17;
        r2.<init>();
        r0.a(r1, r2, r7);
        goto L_0x006a;
    L_0x01ad:
        r0 = -51;
        if (r12 != r0) goto L_0x01c9;
    L_0x01b1:
        r0 = com.tencent.mm.g.a.eC(r13);
        if (r0 == 0) goto L_0x01be;
    L_0x01b7:
        r1 = r10.ycs;
        r0.a(r1, r7, r7);
        goto L_0x006a;
    L_0x01be:
        r0 = r10.ycs;
        r1 = com.tencent.mm.R.l.eDo;
        r2 = com.tencent.mm.R.l.bNC;
        com.tencent.mm.ui.base.h.h(r0, r1, r2);
        goto L_0x006a;
    L_0x01c9:
        r0 = r10.o(r11, r12, r13);
        if (r0 != 0) goto L_0x006a;
    L_0x01cf:
        r0 = com.tencent.mm.g.a.eC(r13);
        if (r0 == 0) goto L_0x006a;
    L_0x01d5:
        r1 = r10.ycs;
        if (r1 == 0) goto L_0x006a;
    L_0x01d9:
        r1 = r10.ycs;
        r0 = r0.a(r1, r7, r7);
        if (r0 == 0) goto L_0x006a;
    L_0x01e1:
        goto L_0x006a;
    L_0x01e3:
        r0 = r14.getType();
        r3 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r0 != r3) goto L_0x042f;
    L_0x01eb:
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Sf();
        r10.fJB = r0;
        r9 = new com.tencent.mm.ui.account.f;
        r9.<init>();
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Ov();
        r9.xXV = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Ou();
        r9.xXX = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Sh();
        r9.xXW = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Sg();
        r9.xXY = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.hPj;
        r9.hPj = r0;
        r0 = r10.ycs;
        r0 = r0.lYV;
        r0 = r0.getText();
        r0 = r0.toString();
        r9.xXT = r0;
        r0 = -75;
        if (r12 != r0) goto L_0x023d;
    L_0x0236:
        r0 = r10.ycs;
        com.tencent.mm.platformtools.m.bE(r0);
        goto L_0x006a;
    L_0x023d:
        r0 = -106; // 0xffffffffffffff96 float:NaN double:NaN;
        if (r12 != r0) goto L_0x024a;
    L_0x0241:
        r0 = r10.ycs;
        r1 = 32045; // 0x7d2d float:4.4905E-41 double:1.58323E-319;
        com.tencent.mm.platformtools.m.c(r0, r13, r1);
        goto L_0x006a;
    L_0x024a:
        r0 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
        if (r12 != r0) goto L_0x025b;
    L_0x024e:
        r0 = r10.ycs;
        r14 = (com.tencent.mm.modelsimple.v) r14;
        r1 = com.tencent.mm.pluginsdk.a.a.a(r14);
        com.tencent.mm.platformtools.m.a(r0, r1, r12);
        goto L_0x006a;
    L_0x025b:
        r0 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        if (r12 != r0) goto L_0x02b6;
    L_0x025f:
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Od();
        r10.pXJ = r0;
        r0 = r14;
        r0 = (com.tencent.mm.modelsimple.v) r0;
        r0 = r0.Si();
        r14 = (com.tencent.mm.modelsimple.v) r14;
        r3 = r14.Sl();
        r4 = "MicroMsg.MobileInputIndepPassLoginLogic";
        r5 = "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]";
        r6 = new java.lang.Object[r6];
        r7 = r10.pXJ;
        r7 = com.tencent.mm.sdk.platformtools.bi.Wz(r7);
        r6[r1] = r7;
        r6[r2] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        com.tencent.mm.ui.account.f.a(r9);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = "auth_ticket";
        r4 = r10.pXJ;
        r1.putExtra(r2, r4);
        r2 = "binded_mobile";
        r1.putExtra(r2, r0);
        r0 = "close_safe_device_style";
        r1.putExtra(r0, r3);
        r0 = "from_source";
        r2 = 6;
        r1.putExtra(r0, r2);
        r0 = com.tencent.mm.plugin.c.a.ihN;
        r2 = r10.ycs;
        r0.g(r2, r1);
        goto L_0x006a;
    L_0x02b6:
        r0 = -140; // 0xffffffffffffff74 float:NaN double:NaN;
        if (r12 != r0) goto L_0x02cb;
    L_0x02ba:
        r0 = r10.fJB;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x006a;
    L_0x02c2:
        r0 = r10.ycs;
        r1 = r10.fJB;
        com.tencent.mm.platformtools.m.j(r0, r13, r1);
        goto L_0x006a;
    L_0x02cb:
        r0 = 4;
        if (r11 != r0) goto L_0x0462;
    L_0x02ce:
        r0 = -16;
        if (r12 == r0) goto L_0x02d6;
    L_0x02d2:
        r0 = -17;
        if (r12 != r0) goto L_0x0462;
    L_0x02d6:
        r0 = com.tencent.mm.y.as.CN();
        r3 = new com.tencent.mm.y.be;
        r4 = new com.tencent.mm.ui.account.mobile.e$2;
        r4.<init>();
        r3.<init>(r4);
        r0.a(r3, r1);
        r0 = r2;
    L_0x02e8:
        r3 = -6;
        if (r12 == r3) goto L_0x02f3;
    L_0x02eb:
        r3 = -311; // 0xfffffffffffffec9 float:NaN double:NaN;
        if (r12 == r3) goto L_0x02f3;
    L_0x02ef:
        r3 = -310; // 0xfffffffffffffeca float:NaN double:NaN;
        if (r12 != r3) goto L_0x0359;
    L_0x02f3:
        r0 = r10.xSF;
        if (r0 != 0) goto L_0x0315;
    L_0x02f7:
        r0 = r10.ycs;
        r1 = com.tencent.mm.R.l.eEv;
        r2 = r9.xXY;
        r3 = r9.xXX;
        r4 = r9.xXV;
        r5 = r9.xXW;
        r6 = new com.tencent.mm.ui.account.mobile.e$3;
        r6.<init>(r9);
        r8 = new com.tencent.mm.ui.account.mobile.e$4;
        r8.<init>();
        r0 = com.tencent.mm.ui.applet.SecurityImage.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r10.xSF = r0;
        goto L_0x006a;
    L_0x0315:
        r0 = "MicroMsg.MobileInputIndepPassLoginLogic";
        r1 = new java.lang.StringBuilder;
        r2 = "imgSid:";
        r1.<init>(r2);
        r2 = r9.xXV;
        r1 = r1.append(r2);
        r2 = " img len";
        r1 = r1.append(r2);
        r2 = r9.xXX;
        r2 = r2.length;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.compatible.util.g.zo();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r10.xSF;
        r1 = r9.xXY;
        r2 = r9.xXX;
        r3 = r9.xXV;
        r4 = r9.xXW;
        r0.a(r1, r2, r3, r4);
        goto L_0x006a;
    L_0x0359:
        if (r0 != 0) goto L_0x035f;
    L_0x035b:
        if (r11 != 0) goto L_0x0404;
    L_0x035d:
        if (r12 != 0) goto L_0x0404;
    L_0x035f:
        com.tencent.mm.y.as.unhold();
        r0 = "MicroMsg.MobileInputIndepPassLoginLogic";
        r3 = "login username %s";
        r4 = new java.lang.Object[r2];
        r5 = r9.hPj;
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        r0 = r9.hPj;
        com.tencent.mm.platformtools.m.oJ(r0);
        r0 = com.tencent.mm.y.ar.hhz;
        r3 = "login_weixin_username";
        r4 = "";
        r0 = r0.H(r3, r4);
        r3 = r10.ycs;
        com.tencent.mm.modelsimple.d.bq(r3);
        r3 = r10.ycs;
        r3 = r3.xYl;
        if (r3 == 0) goto L_0x03b8;
    L_0x038d:
        r3 = com.tencent.mm.y.br.hju;
        r4 = r10.qmX;
        r3.V(r4, r0);
        r0 = com.tencent.mm.y.br.hju;
        r3 = com.tencent.mm.y.q.FY();
        r4 = com.tencent.mm.y.q.GH();
        r0.c(r3, r4);
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r3 = 14978; // 0x3a82 float:2.0989E-41 double:7.4E-320;
        r4 = new java.lang.Object[r6];
        r5 = java.lang.Integer.valueOf(r2);
        r4[r1] = r5;
        r5 = 9;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r2] = r5;
        r0.h(r3, r4);
    L_0x03b8:
        r0 = r10.ycs;
        r3 = new com.tencent.mm.ui.account.mobile.e$5;
        r3.<init>();
        com.tencent.mm.platformtools.m.a(r0, r3, r1, r6);
        r0 = r10.ycs;
        r0 = r0.hhQ;
        r3 = 6;
        if (r0 != r3) goto L_0x006a;
    L_0x03c9:
        r14 = (com.tencent.mm.modelsimple.v) r14;
        r0 = r14.Sn();
        r10.xXu = r0;
        r0 = com.tencent.mm.y.as.CN();
        r0.a(r8, r10);
        r0 = new com.tencent.mm.modelsimple.x;
        r0.<init>(r2);
        r3 = com.tencent.mm.y.as.CN();
        r3.a(r0, r1);
        r1 = r10.ycs;
        r3 = r10.ycs;
        r4 = r10.ycs;
        r5 = com.tencent.mm.R.l.dGZ;
        r4.getString(r5);
        r4 = r10.ycs;
        r5 = com.tencent.mm.R.l.eLT;
        r4 = r4.getString(r5);
        r5 = new com.tencent.mm.ui.account.mobile.e$6;
        r5.<init>(r0);
        r0 = com.tencent.mm.ui.base.h.a(r3, r4, r2, r5);
        r1.xXM = r0;
        goto L_0x006a;
    L_0x0404:
        r0 = r10.o(r11, r12, r13);
        if (r0 != 0) goto L_0x006a;
    L_0x040a:
        if (r11 != 0) goto L_0x040e;
    L_0x040c:
        if (r12 == 0) goto L_0x01cf;
    L_0x040e:
        r0 = r10.ycs;
        r3 = r10.ycs;
        r4 = com.tencent.mm.R.l.eiB;
        r5 = new java.lang.Object[r6];
        r6 = java.lang.Integer.valueOf(r11);
        r5[r1] = r6;
        r6 = java.lang.Integer.valueOf(r12);
        r5[r2] = r6;
        r2 = r3.getString(r4, r5);
        r0 = android.widget.Toast.makeText(r0, r2, r1);
        r0.show();
        goto L_0x01cf;
    L_0x042f:
        r0 = r14.getType();
        if (r0 != r8) goto L_0x01cf;
    L_0x0435:
        r0 = com.tencent.mm.y.as.CN();
        r0.b(r8, r10);
        if (r11 != 0) goto L_0x0440;
    L_0x043e:
        if (r12 == 0) goto L_0x006a;
    L_0x0440:
        r0 = r10.ycs;
        r1 = r10.xXu;
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.ui.account.RegByMobileSetPwdUI.class;
        r2.<init>(r0, r3);
        r3 = "kintent_hint";
        r4 = com.tencent.mm.R.l.eMi;
        r4 = r0.getString(r4);
        r2.putExtra(r3, r4);
        r3 = "kintent_cancelable";
        r2.putExtra(r3, r1);
        r0.startActivity(r2);
        goto L_0x006a;
    L_0x0462:
        r0 = r1;
        goto L_0x02e8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.account.mobile.e.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }

    private boolean o(int i, int i2, String str) {
        if (a.ihO.a(this.ycs, i, i2, str)) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        switch (i2) {
            case -140:
                if (!bi.oN(this.fJB)) {
                    m.j(this.ycs, str, this.fJB);
                }
                return true;
            case -100:
                String ac;
                as.hold();
                Context context = this.ycs;
                if (TextUtils.isEmpty(as.Cp())) {
                    ac = com.tencent.mm.bu.a.ac(this.ycs, R.l.euH);
                } else {
                    ac = as.Cp();
                }
                h.a(context, ac, this.ycs.getString(R.l.dGZ), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return true;
            case -34:
                Toast.makeText(this.ycs, R.l.dLe, 0).show();
                return true;
            case -33:
                h.a(this.ycs, R.l.dLL, R.l.bNC, null);
                return true;
            case -32:
                h.a(this.ycs, R.l.dLN, R.l.bNC, null);
                return true;
            case -9:
                h.h(this.ycs, R.l.etI, R.l.etJ);
                return true;
            case -4:
            case -3:
                h.h(this.ycs, R.l.ecw, R.l.etJ);
                return true;
            case -1:
                if (as.CN().Ks() != 5) {
                    return false;
                }
                h.h(this.ycs, R.l.exT, R.l.exS);
                return true;
            default:
                return false;
        }
    }
}
