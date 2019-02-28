package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.g.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public final class b implements e, com.tencent.mm.ui.account.mobile.MobileInputUI.b {
    private String xYO;
    private String xYP;
    private int xYY = 0;
    private MobileInputUI ycs;

    /* renamed from: com.tencent.mm.ui.account.mobile.b$5 */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] ycu = new int[a.cpn().length];

        static {
            try {
                ycu[a.ycR - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.ycs = mobileInputUI;
        mobileInputUI.ycE.requestFocus();
        mobileInputUI.showVKB();
        String string = mobileInputUI.getString(R.l.eEn);
        if (d.vHo) {
            string = string + mobileInputUI.getString(R.l.dDO);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.xYI.setVisibility(0);
        mobileInputUI.ycD.setVisibility(0);
        mobileInputUI.ycE.requestFocus();
        mobileInputUI.xYT.setText(R.l.dGb);
        mobileInputUI.xYT.setVisibility(0);
    }

    public final void start() {
        as.CN().a((int) c.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",F200_100," + as.fJ("F200_100") + ",1");
        com.tencent.mm.plugin.c.b.oY("F200_100");
        this.xYY = 0;
    }

    public final void stop() {
        as.CN().b((int) c.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(false, as.CI() + "," + getClass().getName() + ",F200_100," + as.fJ("F200_100") + ",2");
    }

    public final void EB(int i) {
        switch (AnonymousClass5.ycu[i - 1]) {
            case 1:
                this.ycs.ycK = ap.VS(this.ycs.countryCode);
                this.ycs.pny = this.ycs.ycD.getText().toString();
                String str = this.ycs.ycK + this.ycs.pny;
                if (this.ycs.xXM != null) {
                    x.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
                    return;
                }
                MobileInputUI mobileInputUI = this.ycs;
                Context context = this.ycs;
                this.ycs.getString(R.l.dGZ);
                mobileInputUI.xXM = h.a(context, this.ycs.getString(R.l.eDK), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                String obj = this.ycs.ycD.getText().toString();
                int i2 = (this.xYO == null || this.xYP == null || obj.equals(this.xYO) || !obj.equals(this.xYP)) ? (this.xYO == null || this.xYP == null || this.xYP.equals(this.xYO) || obj.equals(this.xYP)) ? 0 : 2 : 1;
                k sVar = new s(str, 12, "", 0, "");
                sVar.hH(this.xYY);
                sVar.hI(i2);
                as.CN().a(sVar, 0);
                this.xYO = this.ycs.ycD.getText().toString();
                this.xYY++;
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ycs.xXM != null) {
            this.ycs.xXM.dismiss();
            this.ycs.xXM = null;
        }
        a eC;
        if (i2 == -75) {
            h.h(this.ycs, R.l.dDR, R.l.eDj);
        } else if (i2 == -41 || i2 == -59) {
            eC = a.eC(str);
            if (eC != null) {
                eC.a(this.ycs, null, null);
            } else {
                h.h(this.ycs, R.l.eDR, R.l.eDS);
            }
        } else if (kVar.getType() == c.CTRL_INDEX) {
            int IY = ((s) kVar).IY();
            if (IY == 12) {
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    String Oe = ((s) kVar).Oe();
                    if (!bi.oN(Oe)) {
                        this.ycs.pny = Oe.trim();
                    }
                    this.ycs.pny = ap.VQ(this.ycs.pny);
                    this.xYP = this.ycs.ycK + this.ycs.pny;
                    com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",F200_200," + as.fJ("F200_200") + ",1");
                    eC = a.eC(str);
                    if (eC != null) {
                        eC.a(this.ycs, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.this.cpj();
                                com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",F200_200," + as.fJ("F200_200") + ",2");
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",F200_200," + as.fJ("F200_200") + ",2");
                            }
                        });
                        return;
                    }
                    cpj();
                    com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",F200_200," + as.fJ("F200_200") + ",2");
                    return;
                } else if (i2 == -34) {
                    h.b(this.ycs, this.ycs.getString(R.l.dLe), "", true);
                    return;
                } else {
                    Toast.makeText(this.ycs, this.ycs.getString(R.l.dLK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (IY == 8 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.ycs.ycK + " " + this.ycs.ycD.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.ycs.pny);
                intent.putExtra("country_name", this.ycs.hGi);
                intent.putExtra("couttry_code", this.ycs.countryCode);
                intent.putExtra("mobileverify_countdownsec", ((s) kVar).Oj());
                intent.putExtra("mobileverify_countdownstyle", ((s) kVar).Ok());
                intent.putExtra("mobileverify_fb", ((s) kVar).Ol());
                intent.putExtra("mobileverify_reg_qq", ((s) kVar).On());
                intent.putExtra("mobile_verify_purpose", 3);
                intent.setClass(this.ycs, MobileVerifyUI.class);
                this.ycs.startActivity(intent);
            }
        }
    }

    private void cpj() {
        MobileInputUI mobileInputUI = this.ycs;
        Context context = this.ycs;
        this.ycs.getString(R.l.dGZ);
        mobileInputUI.xXM = h.a(context, this.ycs.getString(R.l.eDK), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        as.CN().a(new s(this.ycs.ycK + this.ycs.pny, 8, "", 0, ""), 0);
    }
}
