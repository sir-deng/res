package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.su;
import com.tencent.mm.f.a.sw;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletBindUI extends WalletBaseUI {
    private p osg = new p();
    private PayInfo pHW = new PayInfo();
    private boolean sIP = false;
    private String sIQ;
    private int sIR = -1;
    private com.tencent.mm.plugin.wallet_core.c.a sIS = null;
    private boolean sIT = false;
    c sIU = new c<su>() {
        {
            this.xmG = su.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            WalletBindUI.this.finish();
            return false;
        }
    };
    private String token = null;

    public void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        jl(580);
        this.osg.tdo = new p.b() {
            public final int aYZ() {
                return 1;
            }

            public final Context getContext() {
                return WalletBindUI.this;
            }
        };
        this.sIQ = getIntent().getStringExtra("key_import_key");
        this.sIR = getIntent().getIntExtra("key_bind_scene", -1);
        if (getIntent() != null) {
            i = getIntent().getIntExtra("key_bind_scene", 13);
        }
        b swVar = new sw();
        if (i == 4) {
            swVar.fLz.scene = 20;
        } else {
            swVar.fLz.scene = 13;
        }
        swVar.frD = new Runnable() {
            public final void run() {
                if (!WalletBindUI.this.sIT) {
                    if (WalletBindUI.this.sIR == 4) {
                        WalletBindUI.this.osg.a(new p.a() {
                            public final void aYX() {
                                WalletBindUI.this.bKt();
                            }

                            public final void cancel() {
                                WalletBindUI.this.finish();
                            }

                            public final void aYY() {
                                WalletBindUI.this.bKt();
                            }
                        }, new ae().bMu());
                    } else {
                        WalletBindUI.this.bKt();
                    }
                    if (!WalletBindUI.this.sIT) {
                        WalletBindUI.this.sIT = true;
                    }
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.m(swVar);
        com.tencent.mm.sdk.b.a.xmy.b(this.sIU);
        com.tencent.mm.wallet_core.c.p.fw(6, 0);
    }

    private void bKt() {
        this.pHW.fDR = this.sIR;
        this.vf.putParcelable("key_pay_info", this.pHW);
        if (this.sIR == 2) {
            if (bi.oN(this.sIQ)) {
                zk("");
                return;
            }
            x.d("MicroMsg.WalletBindUI", "importKey " + this.sIQ);
            r(new com.tencent.mm.plugin.wallet.bind.a.c(this.sIQ, this.pHW));
        } else if (this.sIR == 4) {
            o.HS(4);
            if (getIntent() == null) {
                zk("");
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            int intExtra = getIntent().getIntExtra("pay_channel", 0);
            if (this.sIR == 6) {
                this.sIS = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 2, "getBrandWCPayCreateCreditCardRequest", intExtra);
            } else {
                this.sIS = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 1, "getBrandWCPayBindCardRequest", intExtra);
            }
            r(this.sIS);
        } else if (this.sIR == 6) {
            bKu();
        } else {
            zu(this.sIR);
        }
    }

    private void zu(int i) {
        x.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bi.chl().toString());
        Bundle bundle = this.vf;
        bundle.putParcelable("key_pay_info", this.pHW);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
        com.tencent.mm.plugin.wallet.a.p.bKx();
        if (com.tencent.mm.plugin.wallet.a.p.bKy().bMx()) {
            x.i("MicroMsg.WalletBindUI", "user status invalid");
            if (i == 4) {
                r(new y(null, 20));
                return;
            } else {
                r(new y(null, 12));
                return;
            }
        }
        com.tencent.mm.plugin.wallet.a.p.bKx();
        if (com.tencent.mm.plugin.wallet.a.p.bKy().bMy()) {
            x.i("MicroMsg.WalletBindUI", "user status reg");
            this.sIP = true;
            this.pHW.fDR = this.sIR;
            bundle.putInt("key_bind_scene", this.pHW.fDR);
            if (!bi.oN(this.token)) {
                bundle.putString("kreq_token", this.token);
            }
            com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
            return;
        }
        x.i("MicroMsg.WalletBindUI", "user status unreg");
        this.sIP = true;
        if (this.sIR >= 0) {
            this.pHW.fDR = this.sIR;
        } else {
            this.pHW.fDR = 1;
        }
        bundle.putInt("key_bind_scene", this.pHW.fDR);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
    }

    private void bKu() {
        com.tencent.mm.plugin.wallet.a.p.bKx();
        if (com.tencent.mm.plugin.wallet.a.p.bKy().bMx()) {
            r(new y(null, 12));
            return;
        }
        String str = getIntent().getStringExtra("packageExt");
        String[] split = str.split("&");
        if (!bi.oN(str) && split.length >= 2) {
            String str2 = null;
            str = null;
            for (String str3 : split) {
                if (str3.startsWith("bankType=")) {
                    str2 = str3.replace("bankType=", "");
                } else if (str3.startsWith("bankName=")) {
                    str = str3.replace("bankName=", "");
                }
            }
            if (!(bi.oN(str) || bi.oN(str2))) {
                com.tencent.mm.plugin.wallet.a.p.bKx();
                if (com.tencent.mm.plugin.wallet.a.p.bKy().NC(str2)) {
                    Bundle bundle = new Bundle();
                    Object bankcard = new Bankcard();
                    bankcard.field_bankName = str;
                    bankcard.field_bankcardType = str2;
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a((Activity) this, "WXCreditOpenProcess", bundle, null);
                    return;
                }
            }
        }
        finish();
    }

    public void onResume() {
        if (this.sIP) {
            finish();
        }
        super.onResume();
        this.osg.onResume();
    }

    public void onPause() {
        super.onPause();
        this.osg.onPause();
    }

    public void onDestroy() {
        jm(580);
        com.tencent.mm.sdk.b.a.xmy.c(this.sIU);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.osg.aYX();
            return;
        }
        this.osg.cancel();
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            this.sIP = true;
        }
        if (i != 0 || i2 != 0) {
            zk(str);
            return true;
        } else if (kVar instanceof y) {
            if (this.sIR == 6) {
                bKu();
            } else {
                bKt();
            }
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            com.tencent.mm.plugin.wallet.bind.a.c cVar = (com.tencent.mm.plugin.wallet.bind.a.c) kVar;
            Bundle bundle = this.vf;
            bundle.putBoolean("key_is_import_bind", true);
            if (cVar.sFo == null || cVar.sFo.size() <= 0) {
                if (bi.oN(str)) {
                    str = getString(i.uWu);
                }
                h.a((Context) this, str, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletBindUI.this.finish();
                    }
                });
            } else {
                Bankcard bankcard = (Bankcard) cVar.sFo.get(0);
                if (bankcard.sRv) {
                    h.a((Context) this, i.uWV, 0, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletBindUI.this.finish();
                        }
                    });
                } else {
                    bundle.putBoolean("key_need_bind_response", true);
                    bundle.putString("kreq_token", cVar.token);
                    bundle.putString("key_bank_username", cVar.sHS);
                    bundle.putString("key_recommand_desc", cVar.sHT);
                    bundle.putParcelable("key_import_bankcard", bankcard);
                    this.sIP = true;
                    bundle.putInt("key_bind_scene", 2);
                    com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, new com.tencent.mm.wallet_core.c.a() {
                        public final Intent l(int i, Bundle bundle) {
                            return new Intent(WalletBindUI.this.mController.xRr, WalletBankcardManageUI.class);
                        }
                    });
                }
            }
            return true;
        } else {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                if (this.sIS == null || !this.sIS.equals(kVar)) {
                    o.cCm();
                } else {
                    f.TF(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bLs());
                    this.token = ((com.tencent.mm.plugin.wallet_core.c.a) kVar).biB();
                    zu(4);
                    return true;
                }
            }
            return false;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("key_is_jump", this.sIP);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.sIP = bundle.getBoolean("key_is_jump", false);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean aYP() {
        return false;
    }

    protected void onNewIntent(Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
            setResult(0);
            finish();
            return;
        }
        super.onNewIntent(intent);
        x.v("MicroMsg.WalletBindUI", "onNewIntent");
        setIntent(intent);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            x.i("MicroMsg.WalletBindUI", "pay cancel");
            setResult(0);
        } else {
            x.d("MicroMsg.WalletBindUI", "pay done... errCode:" + intent.getBooleanExtra("intent_bind_end", false));
            setResult(-1, getIntent());
        }
        finish();
    }

    private void zk(String str) {
        if (bi.oN(str)) {
            str = getString(i.vdG);
        }
        h.a((Context) this, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                WalletBindUI.this.finish();
            }
        });
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
