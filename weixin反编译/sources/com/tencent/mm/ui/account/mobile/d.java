package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.g.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.RegByMobileSendSmsUI;
import com.tencent.mm.ui.account.ShowAgreementsUI;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public final class d implements e, b {
    private String xXB;
    private String xYO;
    private String xYP;
    private int xYY = 0;
    private MobileInputUI ycs;
    int ycx = 1;

    /* renamed from: com.tencent.mm.ui.account.mobile.d$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] ycu = new int[a.cpn().length];

        static {
            try {
                ycu[a.ycR - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(final MobileInputUI mobileInputUI) {
        this.ycs = mobileInputUI;
        String string = mobileInputUI.getString(R.l.eEm);
        if (com.tencent.mm.protocal.d.vHo) {
            string = string + mobileInputUI.getString(R.l.dDO);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.showOptionMenu(false);
        mobileInputUI.ycH.setVisibility(0);
        mobileInputUI.ycH.setVisibility(0);
        mobileInputUI.xYI.setVisibility(0);
        mobileInputUI.ycD.setVisibility(0);
        mobileInputUI.ycE.requestFocus();
        mobileInputUI.ycG.setVisibility(0);
        mobileInputUI.xYT.setVisibility(0);
        mobileInputUI.xYT.setText(R.l.etU);
        if (mobileInputUI.xYS != null) {
            mobileInputUI.xYS.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    bi.F(mobileInputUI, mobileInputUI.getString(R.l.eSB));
                }
            });
        }
        string = mobileInputUI.getString(R.l.esY);
        String str = "  ";
        String string2;
        String string3;
        String string4;
        CharSequence newSpannable;
        if (w.cfS()) {
            string2 = mobileInputUI.getString(R.l.esZ);
            string3 = mobileInputUI.getString(R.l.eBj);
            string4 = mobileInputUI.getString(R.l.dDT);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    bi.F(mobileInputUI.mController.xRr, mobileInputUI.getString(R.l.eSB));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    bi.F(mobileInputUI, ad.getResources().getString(R.l.ete, new Object[]{w.eM(mobileInputUI), w.cfU()}));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + str.length()) + string2.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            mobileInputUI.xYR.setText(newSpannable);
        } else {
            string2 = mobileInputUI.getString(R.l.etf);
            string3 = mobileInputUI.getString(R.l.etb);
            string4 = mobileInputUI.getString(R.l.dDT);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    bi.F(mobileInputUI.mController.xRr, mobileInputUI.getString(R.l.eSD));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    bi.F(mobileInputUI, ad.getResources().getString(R.l.ete, new Object[]{w.eM(mobileInputUI), w.cfU()}));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            mobileInputUI.xYR.setText(newSpannable);
        }
        mobileInputUI.xYR.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void start() {
        as.CN().a((int) c.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",R200_100," + as.fJ("R200_100") + ",1");
        com.tencent.mm.plugin.c.b.oY("R200_100");
        this.xYY = 0;
    }

    public final void stop() {
        as.CN().b((int) c.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(false, as.CI() + "," + getClass().getName() + ",R200_100," + as.fJ("R200_100") + ",2");
    }

    public final void EB(int i) {
        switch (AnonymousClass2.ycu[i - 1]) {
            case 1:
                this.ycs.aWY();
                switch (this.ycx) {
                    case 1:
                        Intent intent = new Intent(this.ycs, ShowAgreementsUI.class);
                        intent.putExtra("agreement_type", 0);
                        if (ap.VS(this.ycs.countryCode).equals("+86")) {
                            intent.putExtra("country_code", "CN");
                        } else {
                            intent.putExtra("country_code", "US");
                        }
                        this.ycs.startActivityForResult(intent, 32047);
                        break;
                    case 2:
                        cpj();
                        break;
                    default:
                        this.ycs.ycK = ap.VS(this.ycs.countryCode);
                        this.ycs.pny = this.ycs.ycD.getText().toString();
                        String str = this.ycs.ycK + this.ycs.pny;
                        if (this.ycs.xXM == null) {
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
                            break;
                        }
                        x.d("MicroMsg.MobileInputRegLogic", "already checking ");
                        break;
                        break;
                }
                this.ycx = 0;
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ycs.xXM != null) {
            this.ycs.xXM.dismiss();
            this.ycs.xXM = null;
        }
        if (i2 == -75) {
            h.h(this.ycs, R.l.dDR, R.l.eDj);
        } else if (kVar.getType() != c.CTRL_INDEX) {
        } else {
            a eC;
            if (i2 == -41 || i2 == -59) {
                eC = a.eC(str);
                if (eC != null) {
                    eC.a(this.ycs, null, null);
                    return;
                } else {
                    h.h(this.ycs, R.l.eDR, R.l.eDS);
                    return;
                }
            }
            String Oe;
            int IY = ((s) kVar).IY();
            if (IY == 12) {
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    Oe = ((s) kVar).Oe();
                    if (!bi.oN(Oe)) {
                        this.ycs.pny = Oe.trim();
                    }
                    this.ycs.pny = ap.VQ(this.ycs.pny);
                    this.xYP = this.ycs.ycK + this.ycs.pny;
                    this.xXB = ((s) kVar).Oq();
                    com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",R200_200," + as.fJ("R200_200") + ",1");
                    eC = a.eC(str);
                    if (eC != null) {
                        eC.a(this.ycs, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                d.this.cpj();
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",R200_200," + as.fJ("R200_200") + ",2");
                            }
                        });
                        return;
                    }
                    cpj();
                    com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",R200_200," + as.fJ("R200_200") + ",2");
                    return;
                } else if (i2 == -355) {
                    m.c(this.ycs, str, 32046);
                    return;
                } else if (i2 == -34) {
                    h.b(this.ycs, this.ycs.getString(R.l.dLe), "", true);
                    return;
                } else {
                    Toast.makeText(this.ycs, this.ycs.getString(R.l.dLK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (IY != 14) {
                return;
            }
            if (i2 == 0 || str == null) {
                if (((s) kVar).Of() == 1) {
                    String str2 = this.ycs.ycK + this.ycs.pny;
                    Oe = ((s) kVar).Oh();
                    String Og = ((s) kVar).Og();
                    Intent intent = new Intent(this.ycs, RegByMobileSendSmsUI.class);
                    intent.putExtra("from_mobile", str2);
                    intent.putExtra("to_mobile", Oe);
                    intent.putExtra("verify_code", Og);
                    intent.putExtra("regsession_id", this.xXB);
                    this.ycs.startActivity(intent);
                    return;
                }
                com.tencent.mm.plugin.c.b.oZ("R200_300");
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.ycs.ycK + " " + this.ycs.ycD.getText().toString());
                intent2.putExtra("bindmcontact_shortmobile", this.ycs.pny);
                intent2.putExtra("country_name", this.ycs.hGi);
                intent2.putExtra("couttry_code", this.ycs.countryCode);
                intent2.putExtra("mobileverify_countdownsec", ((s) kVar).Oj());
                intent2.putExtra("mobileverify_countdownstyle", ((s) kVar).Ok());
                intent2.putExtra("mobileverify_fb", ((s) kVar).Ol());
                intent2.putExtra("mobileverify_reg_qq", ((s) kVar).On());
                intent2.putExtra("mobile_verify_purpose", 2);
                intent2.setClass(this.ycs, MobileVerifyUI.class);
                this.ycs.startActivity(intent2);
                com.tencent.mm.plugin.accountsync.a.c.jh(com.tencent.mm.plugin.accountsync.a.c.a.inj);
            } else if (i2 == -34) {
                h.b(this.ycs, this.ycs.getString(R.l.dLe), "", true);
            } else if (!com.tencent.mm.plugin.c.a.ihO.a(this.ycs, i, i2, str)) {
                Toast.makeText(this.ycs, this.ycs.getString(R.l.dLK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
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
        k sVar = new s(this.ycs.ycK + this.ycs.pny, 14, "", 0, "");
        sVar.le(this.xXB);
        as.CN().a(sVar, 0);
    }
}
