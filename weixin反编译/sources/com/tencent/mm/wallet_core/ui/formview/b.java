package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;

final class b {
    private static int zRW = 0;
    private static int zRX = 0;
    private static final int zSO = f.uFj;

    static void a(TenpaySecureEditText tenpaySecureEditText, int i) {
        if (tenpaySecureEditText == null) {
            x.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
        } else if (i == 1) {
            tenpaySecureEditText.setIsPasswordFormat(true);
        } else if (i == 2) {
            tenpaySecureEditText.setIsSecurityAnswerFormat(true);
        } else if (i == 3) {
            tenpaySecureEditText.setIsCvvPaymentFormat(true);
        } else if (i == 4) {
            tenpaySecureEditText.setIsCvv4PaymentFormat(true);
        } else if (i == 5) {
            tenpaySecureEditText.setIsValidThru(true);
        } else if (i == 6) {
            tenpaySecureEditText.setIsBankcardFormat(true);
        } else if (i == 7) {
            tenpaySecureEditText.setIsMoneyAmountFormat(true);
        } else if (i == 8) {
            tenpaySecureEditText.setIsIdCardTailFormat(true);
        } else {
            tenpaySecureEditText.setIsCvv4PaymentFormat(false);
        }
    }

    public static void f(final MMActivity mMActivity, final WalletFormView walletFormView) {
        walletFormView.setOnClickListener(new OnClickListener() {
            int year = -1;
            int zSP = -1;

            public final void onClick(View view) {
                final a aVar = new a(mMActivity);
                if (aVar.zHc != null) {
                    CustomDatePicker customDatePicker = aVar.zHc;
                    customDatePicker.kiD = true;
                    customDatePicker.kiE = true;
                    customDatePicker.kiF = false;
                    if (customDatePicker.kiG != null) {
                        customDatePicker.kiG.setEnabled(true);
                        customDatePicker.kiG.setVisibility(0);
                    }
                    if (customDatePicker.kiH != null) {
                        customDatePicker.kiH.setEnabled(true);
                        customDatePicker.kiH.setVisibility(0);
                    }
                    if (customDatePicker.kiI != null) {
                        customDatePicker.kiI.setEnabled(false);
                        customDatePicker.kiI.setVisibility(8);
                    }
                }
                aVar.zHd = new a.a() {
                    public final void f(boolean z, Object obj) {
                        a aVar = aVar;
                        if (aVar.yQT != null) {
                            aVar.yQT.dismiss();
                        }
                        if (z) {
                            String str = (String) obj;
                            if (!bi.oN(str)) {
                                String[] split = str.split("-");
                                if (split.length >= 2) {
                                    x.d("MicroMsg.FormatViewUtil", "result: %s", obj);
                                    AnonymousClass1.this.year = bi.Wo(split[0]);
                                    AnonymousClass1.this.zSP = bi.Wo(split[1]) - 1;
                                    x.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", Integer.valueOf(AnonymousClass1.this.year), Integer.valueOf(AnonymousClass1.this.zSP));
                                    if (AnonymousClass1.this.year >= b.zRW || AnonymousClass1.this.zSP >= b.zRX) {
                                        DecimalFormat decimalFormat = new DecimalFormat("00");
                                        if (q.Gl()) {
                                            walletFormView.setTag(decimalFormat.format((long) (AnonymousClass1.this.zSP + 1)) + AnonymousClass1.this.year);
                                        } else {
                                            walletFormView.setTag(decimalFormat.format((long) AnonymousClass1.this.year).substring(2) + decimalFormat.format((long) (AnonymousClass1.this.zSP + 1)));
                                        }
                                        walletFormView.setText(decimalFormat.format((long) (AnonymousClass1.this.zSP + 1)) + decimalFormat.format((long) AnonymousClass1.this.year).substring(2));
                                    } else {
                                        h.b(mMActivity, mMActivity.getString(i.uXZ), null, true);
                                    }
                                    if (walletFormView.zST != null) {
                                        walletFormView.zST.hB(walletFormView.XX());
                                    }
                                }
                            }
                        }
                    }
                };
                if (this.year >= b.zRW && this.zSP >= b.zRX) {
                    int i = this.year;
                    int i2 = this.zSP + 1;
                    if (i >= 0 && i2 >= 0 && aVar.zHc != null) {
                        aVar.zHc.an(i, i2, 1);
                    }
                }
                if (aVar.yQT != null) {
                    if (aVar.zHc != null) {
                        aVar.zHc.aon();
                    }
                    aVar.yQT.show();
                }
            }
        });
    }

    public static void a(MMActivity mMActivity, int i, int i2) {
        if (i != -1) {
            mMActivity.addDialog(com.tencent.mm.wallet_core.ui.b.a(mMActivity, i, mMActivity.getResources().getString(i2), mMActivity.getResources().getString(i.uYs), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }));
        }
    }
}
