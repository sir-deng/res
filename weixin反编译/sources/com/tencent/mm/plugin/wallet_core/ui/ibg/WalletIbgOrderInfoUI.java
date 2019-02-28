package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletIbgOrderInfoUI extends WalletBaseUI {
    public static Orders sKw;
    private String mAppId = null;
    private String mTimeStamp = null;
    private String sJf = null;
    private String tdr = null;
    private String tds = null;
    private String tdt = null;
    private String tdu = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(1565);
        this.mAppId = getIntent().getStringExtra("appId");
        this.tdr = getIntent().getStringExtra("nonceStr");
        this.mTimeStamp = getIntent().getStringExtra("timeStamp");
        this.sJf = getIntent().getStringExtra("packageExt");
        this.tds = getIntent().getStringExtra("paySignature");
        this.tdt = getIntent().getStringExtra("signtype");
        this.tdu = getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
        r(new c(this.mAppId, this.tdr, this.mTimeStamp, this.sJf, this.tds, this.tdt, this.tdu));
    }

    protected final int getLayoutId() {
        return g.uKM;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar);
        if (kVar instanceof c) {
            jm(1565);
            if (i == 0 && i2 == 0) {
                c cVar = (c) kVar;
                sKw = cVar.sOZ;
                Parcelable parcelable = sKw;
                x.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", Integer.valueOf(cVar.sPk), parcelable);
                Intent intent;
                if (cVar.sPk == 1) {
                    intent = new Intent(this, WalletIbgOrderInfoNewUI.class);
                    intent.putExtra("key_orders", parcelable);
                    startActivity(intent);
                } else {
                    intent = new Intent(this, WalletIbgOrderInfoOldUI.class);
                    intent.putExtra("key_orders", parcelable);
                    startActivity(intent);
                }
                setResult(-1);
                finish();
                return true;
            }
            setResult(0);
            finish();
        }
        setResult(0);
        finish();
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1565);
    }
}
