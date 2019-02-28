package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wallet_core.ui.m.b;
import com.tencent.mm.protocal.c.bpk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletPayCustomUI extends WalletBaseUI {
    private int itU = 0;
    private String mTitle = "";
    protected m sLn;
    private bpk sLo;
    private String sLp = "";
    private boolean sLq = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uV(8);
        this.sLp = getIntent().getStringExtra("INTENT_PAYFEE");
        this.mTitle = getIntent().getStringExtra("INTENT_TITLE");
        this.sLq = getIntent().getIntExtra("INTENT_CAN_TOUCH", 0) == 1;
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_TOKENMESS");
        this.sLo = new bpk();
        try {
            this.sLo.aH(byteArrayExtra);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletPayCustomUI", e, "", new Object[0]);
        }
        x.i("MicroMsg.WalletPayCustomUI", "mTokeMess packageex:%s busi_id:%s sign:%s can_use_touch %s mPayFee %s mTitle %s", this.sLo.wYE, this.sLo.wpr, this.sLo.sign, Boolean.valueOf(this.sLq), this.sLp, this.mTitle);
        this.sLn = m.a(this, this.mTitle, this.sLp, "", this.sLq, new b() {
            public final void b(String str, boolean z, String str2) {
                WalletPayCustomUI.this.b(new w(str, WalletPayCustomUI.this.sLo.wYF, WalletPayCustomUI.this.sLo.wYE, WalletPayCustomUI.this.sLo.sign, WalletPayCustomUI.this.sLo.kZO, WalletPayCustomUI.this.sLo.wpr, z ? 1 : 0, str2, ""), true);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                WalletPayCustomUI.this.finish();
            }
        }, new m.a() {
            public final void bhU() {
                WalletPayCustomUI.this.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletPayCustomUI", "errorType %s errCode %s, errmsg %s, scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar);
        if (kVar instanceof w) {
            if (i == 0 && i2 == 0) {
                w wVar = (w) kVar;
                Intent intent = new Intent();
                intent.putExtra("INTENT_RESULT_TOKEN", wVar.sOX);
                setResult(-1, intent);
            }
            finish();
        }
        return false;
    }
}
