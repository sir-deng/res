package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

@Deprecated
public class ProtocolThreeTwoUI extends MMActivity {
    protected int cPf;
    protected String fGh;
    protected int fei;
    private String fqu;
    private String fry;
    private int ftb = 1;
    protected String fwG;
    private final c hEY;
    private Intent intent;
    protected String mKN;
    protected String mKP;
    private a mKT;
    private int mKZ = 0;
    private String mLk;
    private TextView mMI;
    private ImageView mMV;
    private TextView mMW;
    private TextView mMX;
    private Button mMY;
    private Button mMZ;
    protected String mMe;
    private j.a mMk;
    private r mNX;
    protected String mNc;
    protected String mNd;
    protected String mNe;
    protected String mNf;
    private al mOA = new al(new al.a() {
        public final boolean uG() {
            if (!bi.oN(ProtocolThreeTwoUI.this.ssid)) {
                ProtocolThreeTwoUI.this.ftb = ProtocolThreeTwoUI.this.aNa();
                if (ProtocolThreeTwoUI.this.ftb != 2) {
                    x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), d.qo(ProtocolThreeTwoUI.this.ftb));
                    d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.this.am(33, "AUTH_302_TIMES_EXCESS");
                }
            }
            return false;
        }
    }, false);
    protected int mOc;
    protected String mOd;
    protected String mOe;
    private String openId;
    private String sign;
    protected String signature;
    protected String ssid;

    public ProtocolThreeTwoUI() {
        c.a aVar = new c.a();
        aVar.hFj = true;
        aVar.hFk = true;
        aVar.hFA = R.g.bCk;
        aVar.hFJ = true;
        aVar.hFK = 0.0f;
        this.hEY = aVar.PQ();
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        protocolThreeTwoUI.mKZ++;
        if (protocolThreeTwoUI.mKZ > 3) {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.D(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.E(protocolThreeTwoUI.getIntent())));
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.am(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.D(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.E(protocolThreeTwoUI.getIntent())), str);
        if (m.Bf(str)) {
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.am(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass11 = new com.tencent.mm.plugin.freewifi.a.a.a() {
            public final void e(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    ProtocolThreeTwoUI.f(ProtocolThreeTwoUI.this);
                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                    ProtocolThreeTwoUI.b(ProtocolThreeTwoUI.this, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())));
                    d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.this.am(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                x.e("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                ProtocolThreeTwoUI.this.am(101, m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLU();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass11);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLU();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass11);
    }

    static /* synthetic */ void c(ProtocolThreeTwoUI protocolThreeTwoUI) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", m.D(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.E(protocolThreeTwoUI.getIntent())), protocolThreeTwoUI.ssid);
        protocolThreeTwoUI.mKT.a(new a.a() {
            public final void onSuccess() {
                k.a aLL = k.aLL();
                aLL.ssid = ProtocolThreeTwoUI.this.ssid;
                aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol32UI");
                aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol32UI");
                aLL.fqu = ProtocolThreeTwoUI.this.fqu;
                aLL.mIh = ProtocolThreeTwoUI.this.fGh;
                aLL.mIi = m.D(ProtocolThreeTwoUI.this.intent);
                aLL.mIj = m.F(ProtocolThreeTwoUI.this.intent);
                aLL.mIk = b.AddNetwork.mIW;
                aLL.mIl = b.AddNetwork.name;
                aLL.result = 0;
                aLL.fDM = m.G(ProtocolThreeTwoUI.this.intent);
                aLL.mIm = ProtocolThreeTwoUI.this.fwG;
                aLL.aLN().aLM();
                final String aLI = b.mIb.aLI();
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.ssid, aLI);
                com.tencent.mm.plugin.freewifi.a.a.a anonymousClass1 = new com.tencent.mm.plugin.freewifi.a.a.a() {
                    int mLm = 0;
                    private final int mLn = 3;
                    private int mLo = 0;
                    private com.tencent.mm.plugin.freewifi.a.a.a mLp = new com.tencent.mm.plugin.freewifi.a.a.a() {
                        public final void e(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())));
                                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                ProtocolThreeTwoUI.this.am(35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                            } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                                AnonymousClass1.this.Bt(httpURLConnection.getHeaderField("Location"));
                            } else {
                                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())));
                                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                ProtocolThreeTwoUI.this.am(32, "INVALID_HTTP_RESP_CODE");
                            }
                        }

                        public final void h(Exception exception) {
                            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.this.am(101, m.e(exception));
                        }
                    };

                    public final void e(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())));
                            ProtocolThreeTwoUI.f(ProtocolThreeTwoUI.this);
                        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                            Bt(httpURLConnection.getHeaderField("Location"));
                        } else {
                            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())));
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.this.am(32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                        if (exception instanceof UnknownHostException) {
                            ProtocolThreeTwoUI.this.am(102, m.e(exception));
                            int i = this.mLm + 1;
                            this.mLm = i;
                            if (i <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.aLU();
                                    com.tencent.mm.plugin.freewifi.a.a.a(aLI, this);
                                    return;
                                } catch (InterruptedException e) {
                                    return;
                                }
                            }
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.this.am(101, m.e(exception));
                            return;
                        }
                        d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                        ProtocolThreeTwoUI.this.am(101, m.e(exception));
                    }

                    private void Bt(String str) {
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String Bh = m.Bh(parse.getQueryParameter("extend"));
                        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), str, queryParameter, Bh);
                        if (m.Bf(queryParameter)) {
                            this.mLo++;
                            if (this.mLo < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.aLU();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.mLp);
                                return;
                            }
                            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())));
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.this.am(36, "BLACK_302_TIMES_EXCESS");
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            stringBuilder.append("&extend=").append(Bh);
                        } else {
                            stringBuilder.append("?extend=").append(Bh);
                        }
                        stringBuilder.append("&openId=").append(m.Bh(ProtocolThreeTwoUI.this.openId)).append("&tid=").append(m.Bh(ProtocolThreeTwoUI.this.mLk)).append("&timestamp=").append(ProtocolThreeTwoUI.this.fry).append("&sign=").append(ProtocolThreeTwoUI.this.sign);
                        com.tencent.mm.plugin.freewifi.model.j.aMy().aMg().post(new Runnable(stringBuilder.toString()) {
                            public final void run() {
                                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), r3);
                                com.tencent.mm.plugin.freewifi.a.a.aLU();
                                com.tencent.mm.plugin.freewifi.a.a.a(r3, new com.tencent.mm.plugin.freewifi.a.a.a() {
                                    public final void e(HttpURLConnection httpURLConnection) {
                                        int responseCode = httpURLConnection.getResponseCode();
                                        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(responseCode));
                                        if (responseCode == 200) {
                                            ProtocolThreeTwoUI.f(ProtocolThreeTwoUI.this);
                                        } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                                            ProtocolThreeTwoUI.b(ProtocolThreeTwoUI.this, httpURLConnection.getHeaderField("Location"));
                                        } else {
                                            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())));
                                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                            ProtocolThreeTwoUI.this.am(32, "INVALID_HTTP_RESP_CODE");
                                        }
                                    }

                                    public final void h(Exception exception) {
                                        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), exception.getMessage());
                                        d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                        ProtocolThreeTwoUI.this.am(101, m.e(exception));
                                    }
                                });
                            }
                        });
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.aLU();
                com.tencent.mm.plugin.freewifi.a.a.a(aLI, anonymousClass1);
            }

            public final void qi(int i) {
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.ssid, Integer.valueOf(i));
                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                k.a aLL = k.aLL();
                aLL.ssid = ProtocolThreeTwoUI.this.ssid;
                aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol32UI");
                aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol32UI");
                aLL.fqu = ProtocolThreeTwoUI.this.fqu;
                aLL.mIh = ProtocolThreeTwoUI.this.fGh;
                aLL.mIi = m.D(ProtocolThreeTwoUI.this.intent);
                aLL.mIj = m.F(ProtocolThreeTwoUI.this.intent);
                aLL.mIk = b.AddNetwork.mIW;
                aLL.mIl = b.AddNetwork.name;
                aLL.result = i;
                aLL.fDM = m.G(ProtocolThreeTwoUI.this.intent);
                aLL.mIm = ProtocolThreeTwoUI.this.fwG;
                aLL.aLN().aLM();
            }
        });
    }

    static /* synthetic */ void f(ProtocolThreeTwoUI protocolThreeTwoUI) {
        protocolThreeTwoUI.am(0, "");
        com.tencent.mm.plugin.freewifi.model.j.aMy().aMg().post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.mKN, d.aMi(), d.aMk(), Integer.valueOf(d.aMj()));
                new com.tencent.mm.plugin.freewifi.d.a(ProtocolThreeTwoUI.this.mKN, r2, r3, r4, ProtocolThreeTwoUI.this.fei, m.D(ProtocolThreeTwoUI.this.getIntent())).b(new e() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                            em aMJ = ((com.tencent.mm.plugin.freewifi.d.a) kVar).aMJ();
                            if (aMJ != null) {
                                x.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", aMJ.nqc, aMJ.kzN, aMJ.kyG, Integer.valueOf(aMJ.vQy), aMJ.vQz, aMJ.hxh);
                                ProtocolThreeTwoUI.this.fGh = aMJ.nqc;
                                ProtocolThreeTwoUI.this.mKP = aMJ.kzN;
                                ProtocolThreeTwoUI.this.fwG = aMJ.kyG;
                                ProtocolThreeTwoUI.this.mOc = aMJ.vQy;
                                ProtocolThreeTwoUI.this.mOd = aMJ.vQz;
                                ProtocolThreeTwoUI.this.signature = aMJ.hxh;
                                ProtocolThreeTwoUI.this.mOe = aMJ.vQA;
                                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.fGh, ProtocolThreeTwoUI.this.mKP, ProtocolThreeTwoUI.this.fwG, Integer.valueOf(ProtocolThreeTwoUI.this.mOc), ProtocolThreeTwoUI.this.mOd, ProtocolThreeTwoUI.this.signature, ProtocolThreeTwoUI.this.mOe);
                            }
                            d.a(ProtocolThreeTwoUI.this.ssid, 2, ProtocolThreeTwoUI.this.getIntent());
                            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(2));
                        }
                    }
                });
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.intent = getIntent();
        this.fqu = getIntent().getStringExtra("free_wifi_ap_key");
        this.openId = getIntent().getStringExtra("free_wifi_openid");
        this.mLk = getIntent().getStringExtra("free_wifi_tid");
        this.fry = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
        this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.fqu);
        initView();
        if (bi.oN(this.ssid)) {
            x.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
        } else {
            com.tencent.mm.sdk.e.c cVar;
            int i;
            com.tencent.mm.sdk.e.c Bw = com.tencent.mm.plugin.freewifi.model.j.aMv().Bw(this.ssid);
            if (Bw == null) {
                Bw = new com.tencent.mm.plugin.freewifi.g.c();
                Bw.field_ssidmd5 = ac.VF(this.ssid);
                Bw.field_ssid = this.ssid;
                cVar = Bw;
                i = 1;
            } else {
                cVar = Bw;
                i = 0;
            }
            cVar.field_url = this.mKN;
            cVar.field_mid = this.mMe;
            cVar.field_wifiType = 32;
            cVar.field_connectState = 1;
            if (i != 0) {
                com.tencent.mm.plugin.freewifi.model.j.aMv().b(cVar);
            } else {
                com.tencent.mm.plugin.freewifi.model.j.aMv().c(cVar, new String[0]);
            }
            x.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", this.ssid, this.mMe, Integer.valueOf(this.cPf));
            this.mMk = new j.a() {
                private int mOg = -999999999;

                public final void a(String str, l lVar) {
                    ProtocolThreeTwoUI.this.ftb = ProtocolThreeTwoUI.this.aNa();
                    if (this.mOg != ProtocolThreeTwoUI.this.ftb) {
                        this.mOg = ProtocolThreeTwoUI.this.ftb;
                        ProtocolThreeTwoUI.this.qr(ProtocolThreeTwoUI.this.ftb);
                    }
                }
            };
            com.tencent.mm.plugin.freewifi.model.j.aMv().c(this.mMk);
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState));
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
            d.a(this.ssid, 4, getIntent());
        }
        com.tencent.mm.plugin.freewifi.l.r(d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.mMe = getIntent().getStringExtra("free_wifi_mid");
        this.mKN = getIntent().getStringExtra("free_wifi_url");
        this.cPf = getIntent().getIntExtra("free_wifi_source", 1);
        this.fei = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.fGh = getIntent().getStringExtra("free_wifi_appid");
        this.mNc = getIntent().getStringExtra("free_wifi_head_img_url");
        this.mNd = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.mNe = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.mNf = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mKP = getIntent().getStringExtra("free_wifi_app_nickname");
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.ssid, this.mMe, this.mKN, Integer.valueOf(this.cPf), Integer.valueOf(this.fei), this.fGh, this.mNc, this.mNd, this.mNf);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ProtocolThreeTwoUI.this.goBack();
                return true;
            }
        });
        findViewById(R.h.cUs).setVisibility(0);
        this.mMV = (ImageView) findViewById(R.h.cjj);
        this.mMW = (TextView) findViewById(R.h.cjV);
        this.mMX = (TextView) findViewById(R.h.cjI);
        this.mMI = (TextView) findViewById(R.h.cjq);
        this.mMY = (Button) findViewById(R.h.bXb);
        this.mMY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.freewifi.l.s(d.aMm(), ProtocolThreeTwoUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeTwoUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), d.qo(ProtocolThreeTwoUI.this.aNa()));
                if (ProtocolThreeTwoUI.this.aNa() == 2) {
                    ProtocolThreeTwoUI.this.finish();
                    return;
                }
                d.a(ProtocolThreeTwoUI.this.ssid, 1, ProtocolThreeTwoUI.this.getIntent());
                ProtocolThreeTwoUI.this.connect();
            }
        });
        this.mMZ = (Button) findViewById(R.h.cUt);
        this.mMZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ProtocolThreeTwoUI.this.mNf);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bl.d.b(ProtocolThreeTwoUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (bi.oN(this.ssid)) {
            this.mMX.setText(getString(R.l.ekn));
            this.mMY.setVisibility(4);
        }
        setMMTitle(getString(R.l.ekp));
    }

    protected final void connect() {
        this.ftb = aNa();
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), d.qo(this.ftb));
        if (this.ftb != 2) {
            this.mOA.K(45000, 45000);
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(60));
            this.mKT = new a(this.ssid, this);
            com.tencent.mm.plugin.freewifi.model.j.aMy().aMg().post(new Runnable() {
                public final void run() {
                    ProtocolThreeTwoUI.c(ProtocolThreeTwoUI.this);
                }
            });
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void qr(int i) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(i));
        switch (i) {
            case 1:
                this.mMI.setVisibility(4);
                this.mMY.setText(R.l.dUx);
                this.mNX = h.a(this.mController.xRr, getString(R.l.dUx), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(ProtocolThreeTwoUI.this.ssid, 4, ProtocolThreeTwoUI.this.getIntent());
                        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.D(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(4));
                    }
                });
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
                return;
            case 2:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mOA.TN();
                this.mMY.setText(R.l.dUu);
                this.mMY.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.fGh);
                intent.putExtra("free_wifi_app_nickname", this.mKP);
                intent.putExtra("free_wifi_app_username", this.fwG);
                intent.putExtra("free_wifi_signature", this.signature);
                intent.putExtra("free_wifi_finish_actioncode", this.mOc);
                intent.putExtra("free_wifi_finish_url", this.mOd);
                if (bi.oN(this.mOe)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.mOe);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                startActivity(intent);
                d.xd();
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
                return;
            case 3:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mOA.TN();
                this.mMI.setVisibility(0);
                this.mMY.setText(R.l.ekl);
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
                return;
            case 4:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mOA.TN();
                this.mMI.setVisibility(4);
                this.mMY.setText(R.l.dUA);
                if (this.cPf == 3) {
                    this.mMX.setText(getString(R.l.evp, new Object[]{this.ssid}));
                } else if (bi.oN(this.mNe)) {
                    this.mMX.setText(getString(R.l.dUw));
                } else {
                    this.mMX.setText(this.mNe);
                }
                if (!bi.oN(this.fGh)) {
                    if (!bi.oN(this.mKP)) {
                        this.mMW.setText(this.mKP);
                    }
                    if (!bi.oN(this.mNc)) {
                        o.PG().a(this.mNc, this.mMV, this.hEY);
                    }
                }
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.diE;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.freewifi.l.t(d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.ihN.i(new Intent(), this);
        finish();
    }

    protected final int aNa() {
        if (bi.oN(this.ssid)) {
            x.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c Bw = com.tencent.mm.plugin.freewifi.model.j.aMv().Bw(this.ssid);
        if (Bw == null || !Bw.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return Bw.field_connectState;
    }

    private void am(int i, String str) {
        k.a aLL = k.aLL();
        aLL.ssid = this.ssid;
        aLL.bssid = m.Bj("MicroMsg.FreeWifi.Protocol32UI");
        aLL.fqv = m.Bk("MicroMsg.FreeWifi.Protocol32UI");
        aLL.fqu = this.fqu;
        aLL.mIh = this.fGh;
        aLL.mIi = m.D(this.intent);
        aLL.mIj = m.F(this.intent);
        aLL.mIk = b.ThreeTwoAuth.mIW;
        aLL.mIl = b.ThreeTwoAuth.name;
        aLL.result = i;
        aLL.lfa = str;
        aLL.fDM = m.G(this.intent);
        aLL.mIm = this.fwG;
        aLL.aLN().aLM();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mMk != null) {
            com.tencent.mm.plugin.freewifi.model.j.aMv().j(this.mMk);
        }
        this.mOA.TN();
        com.tencent.mm.plugin.freewifi.model.j.aMy().release();
    }
}
