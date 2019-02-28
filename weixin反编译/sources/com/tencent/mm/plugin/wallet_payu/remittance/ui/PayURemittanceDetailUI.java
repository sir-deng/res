package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;

public class PayURemittanceDetailUI extends RemittanceDetailUI {
    private int pUH;
    private String pVj;
    private int pgx;
    private int pgy;
    private String tka;
    private String tkb;
    private int tkc;
    private int tkd;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pUH = getIntent().getIntExtra("total_fee", 0);
        this.tka = getIntent().getStringExtra("fee_type");
        if (getIntent().getBooleanExtra("is_sender", false)) {
            this.tkb = q.FY();
            this.pVj = this.pUD;
            return;
        }
        this.tkb = this.pUD;
        this.pVj = q.FY();
    }

    protected final void vN(int i) {
        b(new f(this.pSc, this.pUD, this.pUA), true);
    }

    protected final void vO(int i) {
        b(new f(this.pSc, this.pUD, this.pUA, 1, i), true);
    }

    protected final void T(Intent intent) {
        d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
    }

    protected final void boD() {
        l(new c(this.pSc, this.pUH, this.tka, this.pUD));
    }

    protected final void boE() {
        l(new b(this.pSc, this.pUH, this.tka, this.pUD));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof f) {
            f fVar = (f) kVar;
            String string;
            CharSequence spannableString;
            a aVar;
            if (fVar.fvo != 0) {
                boolean equals;
                boolean z = false;
                if (i == 0 && i2 == 0) {
                    this.tkc = fVar.status;
                    this.tkd = fVar.pRe;
                    this.pgy = fVar.tjW;
                    this.pgx = fVar.tjX;
                    this.pUH = (int) (fVar.loS * 100.0d);
                    this.tka = fVar.pgf;
                    z = true;
                    equals = this.pVj.equals(q.FY());
                    this.pUx.setVisibility(8);
                    this.pUw.setText(e.d(((double) this.pUH) / 100.0d, this.tka));
                    int i3 = this.tkc;
                    String string2;
                    CharSequence spannableString2;
                    a aVar2;
                    switch (i3) {
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            if (equals) {
                                this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.e.uky);
                                this.pUx.setVisibility(0);
                                this.pUx.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        PayURemittanceDetailUI.this.boD();
                                    }
                                });
                                string = getString(i.uUj, new Object[]{Integer.valueOf(this.pUF)});
                                string2 = getString(i.uTX);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.piR = new a.a() {
                                    public final void onClick(View view) {
                                        h.a(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(i.uTT, new Object[]{RemittanceDetailUI.ax(PayURemittanceDetailUI.this.tkb, false)}), PayURemittanceDetailUI.this.getString(i.dGE), PayURemittanceDetailUI.this.getString(i.uTY), PayURemittanceDetailUI.this.getString(i.dEy), new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                PayURemittanceDetailUI.this.boE();
                                            }
                                        }, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                    }
                                };
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                this.omB.setText(spannableString2);
                            } else {
                                this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(i.uUg, new Object[]{RemittanceDetailUI.ax(this.pVj, true)}), this.pUv.getTextSize()));
                                string = getString(i.uUn, new Object[]{Integer.valueOf(this.pUF)});
                                string2 = getString(i.uUF);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.piR = new a.a() {
                                    public final void onClick(View view) {
                                        h.a(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(i.uTH), PayURemittanceDetailUI.this.getString(i.dGE), PayURemittanceDetailUI.this.getString(i.uUE), PayURemittanceDetailUI.this.getString(i.dEy), new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.putExtra("transaction_id", PayURemittanceDetailUI.this.pUC);
                                                intent.putExtra("receiver_name", PayURemittanceDetailUI.this.pVj);
                                                intent.putExtra("total_fee", PayURemittanceDetailUI.this.pUH);
                                                intent.putExtra("fee_type", PayURemittanceDetailUI.this.tka);
                                                PayURemittanceDetailUI.this.T(intent);
                                            }
                                        }, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                    }
                                };
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                this.omB.setText(spannableString2);
                            }
                            this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.e.uky);
                            this.pUy.setText(getString(i.uUo, new Object[]{e.gT(this.pgy)}));
                            this.pUy.setVisibility(0);
                            this.pUz.setVisibility(8);
                            equals = true;
                            break;
                        case 2001:
                            this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNg);
                            if (equals) {
                                this.pUv.setText(i.uUa);
                                Object string3 = getString(i.uTL);
                                spannableString = new SpannableString(string3);
                                aVar = new a(this);
                                aVar.piR = new a.a() {
                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.h.Y(PayURemittanceDetailUI.this, 0);
                                    }
                                };
                                spannableString.setSpan(aVar, 0, string3.length(), 33);
                                this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                this.omB.setText(spannableString);
                                this.omB.setVisibility(0);
                            } else {
                                this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, RemittanceDetailUI.ax(this.pVj, true) + " " + getString(i.uUa), this.pUv.getTextSize()));
                                this.omB.setVisibility(8);
                            }
                            this.pUy.setText(getString(i.uUo, new Object[]{e.gT(this.tkd)}));
                            this.pUy.setVisibility(0);
                            this.pUz.setText(getString(i.uTP, new Object[]{e.gT(this.pgx)}));
                            this.pUz.setVisibility(0);
                            equals = true;
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNh);
                                if (equals) {
                                    this.pUv.setText(i.uUc);
                                } else {
                                    this.pUv.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, RemittanceDetailUI.ax(this.pVj, true) + getString(i.uUc), this.pUv.getTextSize()));
                                }
                            } else {
                                this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNi);
                                this.pUv.setText(i.uUe);
                            }
                            if (equals) {
                                this.omB.setText("");
                            } else {
                                string = getString(i.uTU);
                                string2 = getString(i.uTL);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.piR = new a.a() {
                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.h.Y(PayURemittanceDetailUI.this, 0);
                                    }
                                };
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                                this.omB.setText(spannableString2);
                            }
                            this.omB.setVisibility(0);
                            this.pUy.setText(getString(i.uUo, new Object[]{e.gT(this.tkd)}));
                            this.pUy.setVisibility(0);
                            this.pUz.setText(getString(i.uTS, new Object[]{e.gT(this.pgy)}));
                            this.pUz.setVisibility(0);
                            equals = true;
                            break;
                        default:
                            finish();
                            break;
                    }
                }
                equals = z;
                if (fVar.fEo != 1) {
                    return equals;
                }
                g.Dr();
                if (((String) g.Dq().Db().get(327729, (Object) "0")).equals("0")) {
                    h.a(this.mController.xRr, i.uOG, i.vcE, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            h.bu(PayURemittanceDetailUI.this.mController.xRr, PayURemittanceDetailUI.this.getString(i.uTN));
                        }
                    });
                    g.Dr();
                    g.Dq().Db().set(327729, "1");
                    return equals;
                }
                h.bu(this.mController.xRr, getString(i.uTN));
                return equals;
            } else if (i == 0 && i2 == 0) {
                if (this.pUB == 1 && !getIntent().getBooleanExtra("is_sender", false)) {
                    this.pUu.setImageResource(com.tencent.mm.plugin.wxpay.a.e.uky);
                    this.pUv.setText(i.uUf);
                    this.pUw.setText(e.d(fVar.loS, fVar.pgf));
                    this.pUx.setVisibility(0);
                    this.pUx.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            PayURemittanceDetailUI.this.boD();
                        }
                    });
                    String string4 = getString(i.uUj, new Object[]{Integer.valueOf(this.pUF)});
                    string = getString(i.uTX);
                    spannableString = new SpannableString(string4 + string);
                    aVar = new a(this);
                    aVar.piR = new a.a() {
                        public final void onClick(View view) {
                            h.a(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(i.uTT, new Object[]{RemittanceDetailUI.ax(PayURemittanceDetailUI.this.pUD, false)}), PayURemittanceDetailUI.this.getString(i.dGE), PayURemittanceDetailUI.this.getString(i.uTY), PayURemittanceDetailUI.this.getString(i.dEy), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    PayURemittanceDetailUI.this.boE();
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    };
                    spannableString.setSpan(aVar, string4.length(), string4.length() + string.length(), 33);
                    this.omB.setMovementMethod(LinkMovementMethod.getInstance());
                    this.omB.setText(spannableString);
                    this.pUy.setText(getString(i.uUo, new Object[]{e.gT(fVar.pRe)}));
                    this.pUy.setVisibility(0);
                    this.pUz.setVisibility(8);
                }
                return true;
            } else {
                vO(0);
                return true;
            }
        } else if (!(kVar instanceof c) && !(kVar instanceof b)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                if (kVar instanceof c) {
                    vO(1);
                } else {
                    aE(0, getString(i.uTO));
                }
                return true;
            }
            aE(i2, str);
            return true;
        }
    }
}
