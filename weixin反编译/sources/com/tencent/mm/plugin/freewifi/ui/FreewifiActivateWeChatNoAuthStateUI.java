package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI extends FreeWifiActivateNoAuthStateUI {
    private int ful;
    private String mOw;
    private String mOx;

    protected final String aNb() {
        return getString(R.l.ekp);
    }

    public final void a(State state) {
        x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.Bo(this.ssid) && this.mMg) {
            aNe();
            this.mMg = false;
            this.mOw = d.aMi();
            this.mOx = d.aMk();
            this.ful = d.aMj();
            x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(this.ful), this.mOw, this.mOx);
            new a(this.mKN, this.mOw, this.mOx, this.ful, this.fei, m.D(getIntent())).b(new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    as.CN().b(640, (e) this);
                    x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
                        d.a(FreewifiActivateWeChatNoAuthStateUI.this.ssid, 2, FreewifiActivateWeChatNoAuthStateUI.this.getIntent());
                        return;
                    }
                    x.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.this.ful), FreewifiActivateWeChatNoAuthStateUI.this.mOw, FreewifiActivateWeChatNoAuthStateUI.this.mOx);
                    FreewifiActivateWeChatNoAuthStateUI.this.pB(-2014);
                    d.Bq(FreewifiActivateWeChatNoAuthStateUI.this.mOx);
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int aNa() {
        j.aMu();
        int Bn = d.Bn(this.ssid);
        x.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", Integer.valueOf(Bn));
        if (Bn == 0) {
            return -2014;
        }
        return Bn;
    }
}
