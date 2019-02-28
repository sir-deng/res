package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;

public final class i extends e implements a {
    protected String fry;
    private int mKZ;
    protected String mLc;
    protected String mLd;
    protected String mLe;
    private Uri mLf;
    private String mLg;
    protected String sign;

    static /* synthetic */ void a(i iVar, String str) {
        iVar.mKZ++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (iVar.mKZ > 3) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.D(iVar.intent), Integer.valueOf(m.E(iVar.intent)));
            freeWifiFrontPageUI = iVar.mKM;
            dVar = d.FAIL;
            aVar = new a();
            aVar.mMO = m.a(iVar.mKO, b.ThreeThreeAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.D(iVar.intent), Integer.valueOf(m.E(iVar.intent)), str);
        if (m.Bf(str)) {
            freeWifiFrontPageUI = iVar.mKM;
            dVar = d.FAIL;
            aVar = new a();
            aVar.mMO = m.a(iVar.mKO, b.ThreeThreeAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass2 = new com.tencent.mm.plugin.freewifi.a.a.a() {
            public final void e(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    i.this.aMV();
                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                    i.a(i.this, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.mKM;
                    d dVar = d.FAIL;
                    a aVar = new a();
                    aVar.mMO = m.a(i.this.mKO, b.ThreeThreeAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                }
            }

            public final void h(Exception exception) {
                x.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)), exception.getMessage(), m.f(exception));
                FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.mKM;
                d dVar = d.FAIL;
                a aVar = new a();
                aVar.mMO = m.a(i.this.mKO, b.ThreeThreeAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
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

    public i(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        this.mKZ = 0;
        this.mLg = this.intent.getStringExtra("free_wifi_schema_uri");
        this.mLf = Uri.parse(this.mLg);
        this.appId = this.mLf.getQueryParameter("appId");
        this.mLc = this.mLf.getQueryParameter("shopId");
        this.mLd = this.mLf.getQueryParameter("authUrl");
        this.mLe = this.mLf.getQueryParameter("extend");
        this.fry = this.mLf.getQueryParameter("timestamp");
        this.sign = this.mLf.getQueryParameter("sign");
        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.mLf, this.appId, this.mLc, this.mLd, this.mLe, this.fry, this.sign);
    }

    public final void connect() {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (m.Bf(this.ssid)) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", m.D(this.intent), Integer.valueOf(m.E(this.intent)));
            freeWifiFrontPageUI = this.mKM;
            dVar = d.FAIL;
            aVar = new a();
            aVar.mMO = m.a(this.mKO, b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else if (m.Bf(this.mLd)) {
            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", m.D(this.intent), Integer.valueOf(m.E(this.intent)));
            freeWifiFrontPageUI = this.mKM;
            dVar = d.FAIL;
            aVar = new a();
            aVar.mMO = m.a(this.mKO, b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else {
            StringBuilder stringBuilder = new StringBuilder(this.mLd);
            if (this.mLd.indexOf("?") == -1) {
                stringBuilder.append("?extend=").append(this.mLe);
            } else {
                stringBuilder.append("&extend=").append(this.mLe);
            }
            final String stringBuilder2 = stringBuilder.toString();
            j.aMy().aMg().post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)), stringBuilder2);
                    com.tencent.mm.plugin.freewifi.a.a.aLU();
                    com.tencent.mm.plugin.freewifi.a.a.a(stringBuilder2, new com.tencent.mm.plugin.freewifi.a.a.a() {
                        public final void e(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)), Integer.valueOf(responseCode));
                            if (responseCode == 200) {
                                i.this.aMV();
                            } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                                i.a(i.this, httpURLConnection.getHeaderField("Location"));
                            } else {
                                x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)));
                                FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.mKM;
                                d dVar = d.FAIL;
                                a aVar = new a();
                                aVar.mMO = m.a(i.this.mKO, b.ThreeThreeAuth, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                            }
                        }

                        public final void h(Exception exception) {
                            x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)), exception.getMessage(), m.f(exception));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.mKM;
                            d dVar = d.FAIL;
                            a aVar = new a();
                            aVar.mMO = m.a(i.this.mKO, b.ThreeThreeAuth, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                        }
                    });
                }
            });
        }
    }

    protected final void aMV() {
        j.aMy().aMg().post(new Runnable() {
            public final void run() {
                k.a aLL = k.aLL();
                aLL.ssid = i.this.ssid;
                aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol33");
                aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol33");
                aLL.fqu = i.this.fqu;
                aLL.mIi = m.D(i.this.intent);
                aLL.mIj = i.this.mKO;
                aLL.mIk = b.GetBackPage33.mIW;
                aLL.mIl = b.GetBackPage33.name;
                aLL.fDM = m.G(i.this.intent);
                aLL.result = 0;
                aLL.aLN().aLM();
                String aMi = com.tencent.mm.plugin.freewifi.model.d.aMi();
                String aMk = com.tencent.mm.plugin.freewifi.model.d.aMk();
                int aMj = com.tencent.mm.plugin.freewifi.model.d.aMj();
                x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)), "", aMi, aMk, Integer.valueOf(aMj));
                new f(i.this.ssid, m.Bj("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.mLc, i.this.mLd, i.this.mLe, i.this.fry, i.this.sign).b(new e() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                        x.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", m.D(i.this.intent), Integer.valueOf(m.E(i.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
                        k.a aLL = k.aLL();
                        aLL.ssid = i.this.ssid;
                        aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol33");
                        aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol33");
                        aLL.fqu = i.this.fqu;
                        aLL.mIi = m.D(i.this.intent);
                        aLL.mIj = m.F(i.this.intent);
                        aLL.mIk = b.GetBackPage33Return.mIW;
                        aLL.mIl = b.GetBackPage33Return.name;
                        aLL.fDM = m.G(i.this.intent);
                        aLL.result = i2;
                        aLL.lfa = str;
                        aLL.aLN().aLM();
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        a aVar;
                        if (i == 0 && i2 == 0) {
                            em aMJ = ((f) kVar).aMJ();
                            if (aMJ != null) {
                                x.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", aMJ.nqc, aMJ.kzN, aMJ.kyG, Integer.valueOf(aMJ.vQy), aMJ.vQz, aMJ.hxh, aMJ.vQA);
                                FreeWifiFrontPageUI freeWifiFrontPageUI2 = i.this.mKM;
                                d dVar2 = d.SUCCESS;
                                FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                                bVar.mNm = aMJ;
                                freeWifiFrontPageUI2.a(dVar2, bVar);
                                return;
                            }
                            freeWifiFrontPageUI = i.this.mKM;
                            dVar = d.FAIL;
                            aVar = new a();
                            aVar.mMO = m.a(i.this.mKO, b.GetBackPage33Return, 20);
                            freeWifiFrontPageUI.a(dVar, aVar);
                        } else if (i2 == -30032) {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", i.this.mKM.getString(R.l.ejQ));
                            intent.setClass(i.this.mKM, FreeWifiErrorUI.class);
                            i.this.mKM.finish();
                            i.this.mKM.startActivity(intent);
                        } else {
                            freeWifiFrontPageUI = i.this.mKM;
                            dVar = d.FAIL;
                            aVar = new a();
                            aVar.jHN = R.l.ejN;
                            aVar.mMO = m.a(i.this.mKO, b.GetBackPage33Return, i2);
                            freeWifiFrontPageUI.a(dVar, aVar);
                        }
                    }
                });
            }
        });
    }
}
