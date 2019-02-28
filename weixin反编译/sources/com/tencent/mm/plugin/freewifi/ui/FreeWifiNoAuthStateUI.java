package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public abstract class FreeWifiNoAuthStateUI extends FreeWifiStateUI {
    private String mHK;
    private int mLX;
    private boolean mLY;

    protected abstract String aNb();

    public void onCreate(Bundle bundle) {
        this.mLX = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.mHK = getIntent().getStringExtra("free_wifi_passowrd");
        this.mLY = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void initView() {
        super.initView();
        setMMTitle(aNb());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.Bo(this.ssid)) {
            aNe();
            this.mMg = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void afV() {
        aMZ();
    }

    protected final void aMZ() {
        if (this.mMg) {
            x.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
            return;
        }
        this.mMg = true;
        aNd();
        int d = d.d(this.ssid, this.mHK, this.mLX, this.mLY);
        a aLL = k.aLL();
        aLL.ssid = this.ssid;
        aLL.fqu = this.fqu;
        aLL.mIi = m.D(getIntent());
        aLL.mIj = m.F(getIntent());
        aLL.mIk = b.AddNetwork.mIW;
        aLL.mIl = b.AddNetwork.name;
        aLL.result = d;
        aLL.fDM = m.G(getIntent());
        aLL.mIh = this.fGh;
        aLL.mIm = this.fwG;
        aLL.aLN().aLM();
    }

    protected int aNa() {
        if (!d.Bo(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
