package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

public final class h extends e implements a {
    private String mKY = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    private int mKZ = 0;

    static /* synthetic */ void a(h hVar, String str) {
        hVar.mKZ++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (hVar.mKZ > 3) {
            x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.D(hVar.intent), Integer.valueOf(m.E(hVar.intent)));
            freeWifiFrontPageUI = hVar.mKM;
            dVar = d.FAIL;
            aVar = new a();
            aVar.mMO = m.a(hVar.mKO, b.ThreeOneAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.am(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.D(hVar.intent), Integer.valueOf(m.E(hVar.intent)), str);
        if (m.Bf(str)) {
            freeWifiFrontPageUI = hVar.mKM;
            dVar = d.FAIL;
            aVar = new a();
            aVar.mMO = m.a(hVar.mKO, b.ThreeOneAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.am(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass2 = new com.tencent.mm.plugin.freewifi.a.a.a() {
            public final void e(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.D(h.this.intent), Integer.valueOf(m.E(h.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    h.this.am(0, "");
                    m.a(h.this.intent, h.this.fqu, h.this.mKO, h.this.fei, h.this.mKM, "MicroMsg.FreeWifi.ProtocolThreeOne");
                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                    h.a(h.this, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.D(h.this.intent), Integer.valueOf(m.E(h.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.mKM;
                    d dVar = d.FAIL;
                    a aVar = new a();
                    aVar.mMO = m.a(h.this.mKO, b.ThreeOneAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    h.this.am(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                x.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.D(h.this.intent), Integer.valueOf(m.E(h.this.intent)), exception.getMessage(), m.f(exception));
                FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.mKM;
                d dVar = d.FAIL;
                a aVar = new a();
                aVar.mMO = m.a(h.this.mKO, b.ThreeOneAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                h.this.am(m.g(exception), m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLU();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass2);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLU();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass2);
    }

    public h(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.mKY);
    }

    public final void connect() {
        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.mKY);
        final String str = this.mKY;
        j.aMy().aMg().post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.D(h.this.intent), Integer.valueOf(m.E(h.this.intent)), str);
                com.tencent.mm.plugin.freewifi.a.a.aLU();
                com.tencent.mm.plugin.freewifi.a.a.a(str, new com.tencent.mm.plugin.freewifi.a.a.a() {
                    public final void e(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.D(h.this.intent), Integer.valueOf(m.E(h.this.intent)), Integer.valueOf(responseCode));
                        if (responseCode == 200) {
                            h.this.am(0, "");
                            m.a(h.this.intent, h.this.fqu, h.this.mKO, h.this.fei, h.this.mKM, "MicroMsg.FreeWifi.ProtocolThreeOne");
                        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                            h.a(h.this, httpURLConnection.getHeaderField("Location"));
                        } else {
                            x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(h.this.intent), Integer.valueOf(m.E(h.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.mKM;
                            d dVar = d.FAIL;
                            a aVar = new a();
                            aVar.mMO = m.a(h.this.mKO, b.ThreeOneAuth, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            h.this.am(32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        x.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", m.D(h.this.intent), Integer.valueOf(m.E(h.this.intent)), exception.getMessage(), m.f(exception));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.mKM;
                        d dVar = d.FAIL;
                        a aVar = new a();
                        aVar.mMO = m.a(h.this.mKO, b.ThreeOneAuth, m.g(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        h.this.am(m.g(exception), m.e(exception));
                    }
                });
            }
        });
    }

    private void am(int i, String str) {
        k.a aLL = k.aLL();
        aLL.ssid = this.ssid;
        aLL.bssid = m.Bj("MicroMsg.FreeWifi.ProtocolThreeOne");
        aLL.fqv = m.Bk("MicroMsg.FreeWifi.ProtocolThreeOne");
        aLL.fqu = this.fqu;
        aLL.mIh = this.appId;
        aLL.mIi = m.D(this.intent);
        aLL.mIj = 31;
        aLL.mIk = b.ThreeOneAuth.mIW;
        aLL.mIl = b.ThreeOneAuth.name;
        aLL.result = i;
        aLL.lfa = str;
        aLL.fDM = m.G(this.intent);
        aLL.aLN().b(this.intent, i != 0).aLM();
    }
}
