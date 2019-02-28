package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j extends e implements a {
    String fry = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    private a mKT;
    private int mKZ = 0;
    String mLk = this.intent.getStringExtra("free_wifi_tid");
    String openId = this.intent.getStringExtra("free_wifi_openid");
    String sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");

    /* renamed from: com.tencent.mm.plugin.freewifi.e.j$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String val$url;

        AnonymousClass3(String str) {
            this.val$url = str;
        }

        public final void run() {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), this.val$url);
            com.tencent.mm.plugin.freewifi.a.a.aLU();
            com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new com.tencent.mm.plugin.freewifi.a.a.a() {
                public final void e(HttpURLConnection httpURLConnection) {
                    int responseCode = httpURLConnection.getResponseCode();
                    x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), Integer.valueOf(responseCode));
                    if (responseCode == 200) {
                        j.this.an(0, "");
                        m.a(j.this.intent, j.this.fqu, j.this.mKO, j.this.fei, j.this.mKM, "MicroMsg.FreeWifi.Protocol32");
                    } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                        j.a(j.this, httpURLConnection.getHeaderField("Location"));
                    } else {
                        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mKM;
                        d dVar = d.FAIL;
                        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                        aVar.mMO = m.a(j.this.mKO, b.ThreeTwoAuth, 32);
                        freeWifiFrontPageUI.a(dVar, aVar);
                        j.this.an(32, "INVALID_HTTP_RESP_CODE");
                    }
                }

                public final void h(Exception exception) {
                    x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), exception.getMessage(), m.f(exception));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mKM;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.mMO = m.a(j.this.mKO, b.ThreeTwoAuth, m.g(exception));
                    freeWifiFrontPageUI.a(dVar, aVar);
                    j.this.an(m.g(exception), m.e(exception));
                }
            });
        }
    }

    static /* synthetic */ void a(j jVar) {
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", m.D(jVar.intent), Integer.valueOf(m.E(jVar.intent)), jVar.ssid);
        jVar.mKT.a(new a.a() {
            public final void onSuccess() {
                k.a aLL = k.aLL();
                aLL.ssid = j.this.ssid;
                aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol32");
                aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol32");
                aLL.fqu = j.this.fqu;
                aLL.mIh = j.this.appId;
                aLL.mIi = m.D(j.this.intent);
                aLL.mIj = m.F(j.this.intent);
                aLL.mIk = b.AddNetwork.mIW;
                aLL.mIl = b.AddNetwork.name;
                aLL.result = 0;
                aLL.fDM = m.G(j.this.intent);
                aLL.aLN().aLM();
                final String aLI = b.mIb.aLI();
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), j.this.ssid, aLI);
                com.tencent.mm.plugin.freewifi.a.a.a anonymousClass1 = new com.tencent.mm.plugin.freewifi.a.a.a() {
                    int mLm = 0;
                    private final int mLn = 3;
                    private int mLo = 0;
                    private com.tencent.mm.plugin.freewifi.a.a.a mLp = new com.tencent.mm.plugin.freewifi.a.a.a() {
                        public final void e(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            FreeWifiFrontPageUI freeWifiFrontPageUI;
                            d dVar;
                            FreeWifiFrontPageUI.a aVar;
                            if (responseCode == 200) {
                                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)));
                                freeWifiFrontPageUI = j.this.mKM;
                                dVar = d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.mMO = m.a(j.this.mKO, b.ThreeTwoBlack, 35);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                j.this.an(35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                            } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                                AnonymousClass1.this.Bt(httpURLConnection.getHeaderField("Location"));
                            } else {
                                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)));
                                freeWifiFrontPageUI = j.this.mKM;
                                dVar = d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.mMO = m.a(j.this.mKO, b.ThreeTwoBlack, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                j.this.an(32, "INVALID_HTTP_RESP_CODE");
                            }
                        }

                        public final void h(Exception exception) {
                            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), exception.getMessage(), m.f(exception));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mKM;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.mMO = m.a(j.this.mKO, b.ThreeTwoBlack, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.this.an(m.g(exception), m.e(exception));
                        }
                    };

                    public final void e(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)));
                            j.this.an(0, "");
                            m.a(j.this.intent, j.this.fqu, j.this.mKO, j.this.fei, j.this.mKM, "MicroMsg.FreeWifi.Protocol32");
                        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                            Bt(httpURLConnection.getHeaderField("Location"));
                        } else {
                            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mKM;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.mMO = m.a(j.this.mKO, b.ThreeTwoBlack, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.b(j.this, 32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        FreeWifiFrontPageUI.a aVar;
                        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), exception.getMessage(), m.f(exception));
                        if (exception instanceof UnknownHostException) {
                            j.b(j.this, 102, m.e(exception));
                            x.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.mLm);
                            int i = this.mLm + 1;
                            this.mLm = i;
                            if (i <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.aLU();
                                    com.tencent.mm.plugin.freewifi.a.a.a(aLI, this);
                                    return;
                                } catch (InterruptedException e) {
                                    x.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", m.f(exception));
                                    j.b(j.this, 103, m.e(exception));
                                    freeWifiFrontPageUI = j.this.mKM;
                                    dVar = d.FAIL;
                                    aVar = new FreeWifiFrontPageUI.a();
                                    aVar.mMO = m.a(j.this.mKO, b.ThreeTwoBlack, 103);
                                    freeWifiFrontPageUI.a(dVar, aVar);
                                    return;
                                }
                            }
                            freeWifiFrontPageUI = j.this.mKM;
                            dVar = d.FAIL;
                            aVar = new FreeWifiFrontPageUI.a();
                            aVar.mMO = m.a(j.this.mKO, b.ThreeTwoBlack, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.b(j.this, m.g(exception), m.e(exception));
                            return;
                        }
                        freeWifiFrontPageUI = j.this.mKM;
                        dVar = d.FAIL;
                        aVar = new FreeWifiFrontPageUI.a();
                        aVar.mMO = m.a(j.this.mKO, b.ThreeTwoBlack, m.g(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        j.b(j.this, m.g(exception), m.e(exception));
                    }

                    private void Bt(String str) {
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String Bh = m.Bh(parse.getQueryParameter("extend"));
                        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), str, queryParameter, Bh);
                        if (m.Bf(queryParameter)) {
                            this.mLo++;
                            if (this.mLo < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.aLU();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.mLp);
                                return;
                            }
                            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mKM;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.mMO = m.a(j.this.mKO, b.ThreeTwoBlack, 36);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.this.an(36, "BLACK_302_TIMES_EXCESS");
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            stringBuilder.append("&extend=").append(Bh);
                        } else {
                            stringBuilder.append("?extend=").append(Bh);
                        }
                        stringBuilder.append("&openId=").append(m.Bh(j.this.openId)).append("&tid=").append(m.Bh(j.this.mLk)).append("&timestamp=").append(j.this.fry).append("&sign=").append(j.this.sign);
                        com.tencent.mm.plugin.freewifi.model.j.aMy().aMg().post(new AnonymousClass3(stringBuilder.toString()));
                        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), stringBuilder.toString());
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.aLU();
                com.tencent.mm.plugin.freewifi.a.a.a(aLI, anonymousClass1);
            }

            public final void qi(int i) {
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), j.this.ssid, Integer.valueOf(i));
                FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mKM;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.mMO = m.a(j.this.mKO, b.AddNetwork, i);
                freeWifiFrontPageUI.a(dVar, aVar);
                k.a aLL = k.aLL();
                aLL.ssid = j.this.ssid;
                aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol32");
                aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol32");
                aLL.fqu = j.this.fqu;
                aLL.mIh = j.this.appId;
                aLL.mIi = m.D(j.this.intent);
                aLL.mIj = m.F(j.this.intent);
                aLL.mIl = b.AddNetwork.name;
                aLL.mIk = b.AddNetwork.mIW;
                aLL.result = i;
                aLL.fDM = m.G(j.this.intent);
                aLL.aLN().aLM();
            }
        });
    }

    static /* synthetic */ void a(j jVar, String str) {
        jVar.mKZ++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI.a aVar;
        if (jVar.mKZ > 3) {
            x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.D(jVar.intent), Integer.valueOf(m.E(jVar.intent)));
            freeWifiFrontPageUI = jVar.mKM;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.mMO = m.a(jVar.mKO, b.ThreeTwoAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.an(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.D(jVar.intent), Integer.valueOf(m.E(jVar.intent)), str);
        if (m.Bf(str)) {
            freeWifiFrontPageUI = jVar.mKM;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.mMO = m.a(jVar.mKO, b.ThreeTwoAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.an(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass4 = new com.tencent.mm.plugin.freewifi.a.a.a() {
            public final void e(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    j.this.an(0, "");
                    m.a(j.this.intent, j.this.fqu, j.this.mKO, j.this.fei, j.this.mKM, "MicroMsg.FreeWifi.Protocol32");
                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                    j.a(j.this, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mKM;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.mMO = m.a(j.this.mKO, b.ThreeTwoAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    j.this.an(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                x.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.D(j.this.intent), Integer.valueOf(m.E(j.this.intent)), exception.getMessage(), m.f(exception));
                FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mKM;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.mMO = m.a(j.this.mKO, b.ThreeTwoAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                j.this.an(m.g(exception), m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLU();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass4);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLU();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass4);
    }

    static /* synthetic */ void b(j jVar, int i, String str) {
        k.a aLL = k.aLL();
        aLL.ssid = jVar.ssid;
        aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol32");
        aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol32");
        aLL.fqu = jVar.fqu;
        aLL.mIh = jVar.appId;
        aLL.mIi = m.D(jVar.intent);
        aLL.mIj = 32;
        aLL.mIk = b.ThreeTwoAuth.mIW;
        aLL.mIl = b.ThreeTwoAuth.name;
        aLL.result = i;
        aLL.lfa = str;
        aLL.fDM = m.G(jVar.intent);
        aLL.aLN().aLM();
    }

    public j(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        x.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.openId, this.mLk, this.fry, this.sign);
    }

    public final void connect() {
        this.mKT = new a(this.ssid, this.mKM);
        com.tencent.mm.plugin.freewifi.model.j.aMy().aMg().post(new Runnable() {
            public final void run() {
                j.a(j.this);
            }
        });
    }

    private void an(int i, String str) {
        k.a aLL = k.aLL();
        aLL.ssid = this.ssid;
        aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol32");
        aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol32");
        aLL.fqu = this.fqu;
        aLL.mIh = this.appId;
        aLL.mIi = m.D(this.intent);
        aLL.mIj = 32;
        aLL.mIk = b.ThreeTwoAuth.mIW;
        aLL.mIl = b.ThreeTwoAuth.name;
        aLL.result = i;
        aLL.lfa = str;
        aLL.fDM = m.G(this.intent);
        aLL.aLN().aLM();
    }
}
