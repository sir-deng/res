package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

@Deprecated
public class FreewifiWeChatNoAuthStateUI extends FreeWifiNoAuthStateUI {
    private int ful;
    private String mOw;
    private String mOx;

    protected final String aNb() {
        return getString(R.l.ekp);
    }

    public final void a(State state) {
        x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.Bo(this.ssid) && this.mMg) {
            aNe();
            this.mMg = false;
            this.mOw = d.aMi();
            this.mOx = d.aMk();
            this.ful = d.aMj();
            x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(this.ful), this.mOw, this.mOx);
            new a(this.mKN, this.mOw, this.mOx, this.ful, this.fei, m.D(getIntent())).b(new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    as.CN().b(640, (e) this);
                    x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
                        em aMJ = ((a) kVar).aMJ();
                        if (aMJ != null) {
                            x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", aMJ.nqc, aMJ.kzN, aMJ.kyG, Integer.valueOf(aMJ.vQy), aMJ.vQz, aMJ.hxh);
                            FreewifiWeChatNoAuthStateUI.this.fGh = aMJ.nqc;
                            FreewifiWeChatNoAuthStateUI.this.mKP = aMJ.kzN;
                            FreewifiWeChatNoAuthStateUI.this.fwG = aMJ.kyG;
                            FreewifiWeChatNoAuthStateUI.this.mOc = aMJ.vQy;
                            FreewifiWeChatNoAuthStateUI.this.mOd = aMJ.vQz;
                            FreewifiWeChatNoAuthStateUI.this.signature = aMJ.hxh;
                            FreewifiWeChatNoAuthStateUI.this.mOe = aMJ.vQA;
                        }
                        d.a(FreewifiWeChatNoAuthStateUI.this.ssid, 2, FreewifiWeChatNoAuthStateUI.this.getIntent());
                        return;
                    }
                    x.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(FreewifiWeChatNoAuthStateUI.this.ful), FreewifiWeChatNoAuthStateUI.this.mOw, FreewifiWeChatNoAuthStateUI.this.mOx);
                    d.a(FreewifiWeChatNoAuthStateUI.this.ssid, -2014, FreewifiWeChatNoAuthStateUI.this.getIntent());
                    d.Bq(FreewifiWeChatNoAuthStateUI.this.mOx);
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
        x.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", Integer.valueOf(Bn));
        if (Bn == 0) {
            return -2014;
        }
        return Bn;
    }
}
