package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.pay.a.b;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(7)
public class WalletLoanRepaymentUI extends WalletBaseUI {
    private String desc;
    private String mFe;
    private double pQI;
    private String pgf = "CNY";
    protected n sFl;
    private String sLd;
    private String sLe;
    private String sLf;
    private String sLg;
    private String sLh;
    private String sLi;
    private String sLj;
    private String sLk;
    private int sLl;
    private String token;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.sLi = intent.getStringExtra("appId");
        this.sLd = intent.getStringExtra("timeStamp");
        this.sLe = intent.getStringExtra("nonceStr");
        this.sLf = intent.getStringExtra("packageExt");
        this.sLg = intent.getStringExtra("signtype");
        this.sLh = intent.getStringExtra("paySignature");
        this.sLj = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        this.sLl = intent.getIntExtra("pay_channel", 0);
        jl(580);
        r(new com.tencent.mm.plugin.wallet_core.c.a(this.sLi, this.sLd, this.sLe, this.sLf, this.sLg, this.sLh, this.sLj, 7, "getWebPayCheckoutCounterRequst", this.sLl));
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void Ns(String str) {
        b(new b(str), true);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                f.TF(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bLs());
                this.token = ((com.tencent.mm.plugin.wallet_core.c.a) kVar).biB();
                Ns(this.token);
                return true;
            } else if (kVar instanceof b) {
                b bVar = (b) kVar;
                this.pgf = bVar.pgf;
                this.pQI = bVar.pQI;
                this.desc = bVar.desc;
                ad bMd = o.bMd();
                if (bMd.bMn()) {
                    Bankcard bMo = bMd.bMo();
                    if (bMo == null || !bi.oN(bMo.field_forbidWord)) {
                        bKM();
                    } else {
                        a(bMo, this.pQI, this.pgf);
                    }
                } else {
                    h.a((Context) this, getResources().getString(i.uYP), "", getString(i.vaV), getString(i.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
                            WalletLoanRepaymentUI.this.bKN();
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (WalletLoanRepaymentUI.this.aYL()) {
                                WalletLoanRepaymentUI.this.finish();
                            }
                        }
                    });
                }
                return true;
            } else if (kVar instanceof s) {
                s sVar = (s) kVar;
                if (sVar.bLt()) {
                    x.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.mFe);
                    bundle.putString("key_jsapi_token", this.token);
                    bundle.putString("key_relation_key", sVar.sOQ);
                    bundle.putInt("key_verify_scene", 8);
                    bundle.putString("key_mobile", sVar.sOP);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.ui.k.class, bundle);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", sVar.sON);
                    intent.putExtra("bind_serial", this.sLk);
                    setResult(-1, intent);
                    finish();
                }
                return true;
            }
        }
        return false;
    }

    private void a(Bankcard bankcard, double d, String str) {
        c anonymousClass1 = new c() {
            public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                WalletLoanRepaymentUI.this.mFe = str;
                WalletLoanRepaymentUI.this.l(new s(WalletLoanRepaymentUI.this.mFe, WalletLoanRepaymentUI.this.token, (byte) 0));
            }
        };
        View.OnClickListener anonymousClass2 = new View.OnClickListener() {
            public final void onClick(View view) {
                WalletLoanRepaymentUI.this.bKM();
                if (WalletLoanRepaymentUI.this.sFl != null) {
                    WalletLoanRepaymentUI.this.sFl.dismiss();
                }
            }
        };
        OnCancelListener anonymousClass3 = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (WalletLoanRepaymentUI.this.sFl != null) {
                    WalletLoanRepaymentUI.this.sFl.cancel();
                    WalletLoanRepaymentUI.this.setResult(0);
                    WalletLoanRepaymentUI.this.finish();
                }
            }
        };
        this.sLk = bankcard.field_bindSerial;
        this.sFl = n.a((Context) this, this.desc, d, str, bankcard, anonymousClass1, anonymousClass2, anonymousClass3);
    }

    private void bKM() {
        x.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
        startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    }

    protected final void bKN() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 8);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("kreq_token", this.token);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.loan.a.class, bundle, new com.tencent.mm.wallet_core.c.a() {
            public final Intent l(int i, Bundle bundle) {
                if (i == -1) {
                    WalletLoanRepaymentUI.this.Ns(WalletLoanRepaymentUI.this.token);
                } else {
                    ad bMd = o.bMd();
                    if (bMd.bMn()) {
                        WalletLoanRepaymentUI.this.a(bMd.bMo(), WalletLoanRepaymentUI.this.pQI, WalletLoanRepaymentUI.this.pgf);
                    } else {
                        WalletLoanRepaymentUI.this.setResult(0, null);
                    }
                }
                return null;
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        x.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
        if (extras.containsKey("intent_bind_end")) {
            x.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
            Ns(this.token);
        } else if (extras.containsKey("jsapi_verifycode_process_end")) {
            x.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
            Intent intent2 = new Intent();
            intent2.putExtra("token", intent.getStringExtra("token"));
            intent2.putExtra("bind_serial", this.sLk);
            setResult(-1, intent2);
            finish();
        } else {
            x.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Bankcard NB;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            int intExtra = intent.getIntExtra("ret", DownloadResult.CODE_UNDEFINED);
            if (intExtra == -1003) {
                x.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
                bKN();
            } else if (intExtra == 0) {
                x.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
                NB = o.bMd().NB(intent.getStringExtra("bindSerial"));
                if (NB == null) {
                    x.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
                    finish();
                    return;
                }
                a(NB, this.pQI, this.pgf);
            } else {
                x.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
            }
        } else {
            ad bMd = o.bMd();
            if (bMd.bMn()) {
                NB = bMd.bMo();
                if (NB == null || !bi.oN(NB.field_forbidWord)) {
                    finish();
                    return;
                } else {
                    a(NB, this.pQI, this.pgf);
                    return;
                }
            }
            x.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
