package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public class FreeWifiAuthStateUI extends FreeWifiStateUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
    }

    protected final void initView() {
        super.initView();
        setMMTitle(R.l.ekp);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.Bo(this.ssid)) {
            aNe();
            aNg();
        }
    }

    protected final void afV() {
        j.aMA().a(this.ssid, new b() {
            public final void bp(String str, int i) {
                x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", str, FreeWifiAuthStateUI.this.mKN, d.aMi());
                if (!bi.oN(str)) {
                    String str2 = str;
                    new a(FreeWifiAuthStateUI.this.mKN, FreeWifiAuthStateUI.this.ssid, r3, FreeWifiAuthStateUI.this.mMe, str2, "", i, m.D(FreeWifiAuthStateUI.this.getIntent())).b(new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            FreeWifiAuthStateUI.this.mMg = false;
                            if (i == 0 && i2 == 0) {
                                a aVar = (a) kVar;
                                x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", aVar.aMD());
                                em aMJ = aVar.aMJ();
                                if (aMJ != null) {
                                    x.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", aMJ.nqc, aMJ.kzN, aMJ.kyG, Integer.valueOf(aMJ.vQy), aMJ.vQz, aMJ.hxh);
                                    FreeWifiAuthStateUI.this.fGh = aMJ.nqc;
                                    FreeWifiAuthStateUI.this.mKP = aMJ.kzN;
                                    FreeWifiAuthStateUI.this.fwG = aMJ.kyG;
                                    FreeWifiAuthStateUI.this.mOc = aMJ.vQy;
                                    FreeWifiAuthStateUI.this.mOd = aMJ.vQz;
                                    FreeWifiAuthStateUI.this.signature = aMJ.hxh;
                                    FreeWifiAuthStateUI.this.mOe = aMJ.vQA;
                                }
                                j.aMA().a(FreeWifiAuthStateUI.this.ssid, r0, FreeWifiAuthStateUI.this.getIntent());
                            } else if (i2 == -2014) {
                                d.a(FreeWifiAuthStateUI.this.ssid, -2014, FreeWifiAuthStateUI.this.getIntent());
                            } else {
                                d.a(FreeWifiAuthStateUI.this.ssid, 3, FreeWifiAuthStateUI.this.getIntent());
                            }
                        }
                    });
                }
            }
        }, this.fei, getIntent());
    }

    protected final void aMZ() {
        aNd();
        d.Bp(this.ssid);
    }

    protected final int aNa() {
        j.aMu();
        return d.Bn(this.ssid);
    }
}
