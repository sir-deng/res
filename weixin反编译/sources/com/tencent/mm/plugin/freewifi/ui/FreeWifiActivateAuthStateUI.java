package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public class FreeWifiActivateAuthStateUI extends FreeWifiActivateStateUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.cPf != 2) {
            d.a(this.ssid, 1, getIntent());
        }
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
    }

    protected final void initView() {
        super.initView();
        this.mMd = (Button) findViewById(R.h.coB);
        this.mMd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String string = FreeWifiActivateAuthStateUI.this.getString(R.l.ejZ);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bl.d.b(FreeWifiActivateAuthStateUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        setMMTitle(R.l.ekp);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(State state) {
        x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.Bo(this.ssid)) {
            aNe();
            aNg();
        }
    }

    protected final void afV() {
        j.aMA().a(this.ssid, new b() {
            public final void bp(String str, int i) {
                x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", str, FreeWifiActivateAuthStateUI.this.mKN, d.aMi());
                if (!bi.oN(str)) {
                    String str2 = str;
                    new a(FreeWifiActivateAuthStateUI.this.mKN, FreeWifiActivateAuthStateUI.this.ssid, r3, FreeWifiActivateAuthStateUI.this.mMe, str2, "", i, m.D(FreeWifiActivateAuthStateUI.this.getIntent())).b(new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            FreeWifiActivateAuthStateUI.this.mMg = false;
                            if (i == 0 && i2 == 0) {
                                x.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", ((a) kVar).aMD());
                                j.aMA().a(FreeWifiActivateAuthStateUI.this.ssid, r0, FreeWifiActivateAuthStateUI.this.getIntent());
                            } else if (i2 == -2014) {
                                d.a(FreeWifiActivateAuthStateUI.this.ssid, -2014, FreeWifiActivateAuthStateUI.this.getIntent());
                            } else {
                                d.a(FreeWifiActivateAuthStateUI.this.ssid, 3, FreeWifiActivateAuthStateUI.this.getIntent());
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
