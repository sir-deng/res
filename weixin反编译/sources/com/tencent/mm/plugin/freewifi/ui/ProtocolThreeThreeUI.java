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
import com.tencent.mm.ad.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeThreeUI extends MMActivity {
    protected String appId;
    protected String bssid;
    protected int cPf;
    protected int fei;
    protected String fry;
    private int ftb = 1;
    protected String fwG;
    protected String mKP;
    private int mKZ = 0;
    protected String mLc;
    protected String mLd;
    protected String mLe;
    private Uri mLf;
    private String mLg;
    private TextView mMI;
    private ImageView mMV;
    private TextView mMW;
    private TextView mMX;
    private Button mMY;
    private Button mMZ;
    private a mMk;
    private r mNX;
    private al mOA = new al(new al.a() {
        public final boolean uG() {
            if (!bi.oN(ProtocolThreeThreeUI.this.ssid)) {
                ProtocolThreeThreeUI.this.ftb = ProtocolThreeThreeUI.this.aNa();
                if (ProtocolThreeThreeUI.this.ftb != 2) {
                    x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), d.qo(ProtocolThreeThreeUI.this.ftb));
                    d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                }
            }
            return false;
        }
    }, false);
    protected int mOc;
    protected String mOd;
    protected String mOe;
    protected String sign;
    protected String signature;
    protected String ssid;

    static /* synthetic */ void a(ProtocolThreeThreeUI protocolThreeThreeUI, String str) {
        protocolThreeThreeUI.mKZ++;
        if (protocolThreeThreeUI.mKZ > 3) {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.D(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.E(protocolThreeThreeUI.getIntent())));
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.D(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.E(protocolThreeThreeUI.getIntent())), str);
        if (m.Bf(str)) {
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass7 = new com.tencent.mm.plugin.freewifi.a.a.a() {
            public final void e(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    j.aMy().aMg().post(new Runnable() {
                        public final void run() {
                            String aMi = d.aMi();
                            String aMk = d.aMk();
                            int aMj = d.aMj();
                            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), "", aMi, aMk, Integer.valueOf(aMj));
                            new f(ProtocolThreeThreeUI.this.ssid, ProtocolThreeThreeUI.this.bssid, ProtocolThreeThreeUI.this.appId, ProtocolThreeThreeUI.this.mLc, ProtocolThreeThreeUI.this.mLd, ProtocolThreeThreeUI.this.mLe, ProtocolThreeThreeUI.this.fry, ProtocolThreeThreeUI.this.sign).b(new e() {
                                public final void a(int i, int i2, String str, k kVar) {
                                    x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str);
                                    if (i == 0 && i2 == 0) {
                                        em aMJ = ((f) kVar).aMJ();
                                        if (aMJ != null) {
                                            x.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", aMJ.nqc, aMJ.kzN, aMJ.kyG, Integer.valueOf(aMJ.vQy), aMJ.vQz, aMJ.hxh);
                                            ProtocolThreeThreeUI.this.mKP = aMJ.kzN;
                                            ProtocolThreeThreeUI.this.fwG = aMJ.kyG;
                                            ProtocolThreeThreeUI.this.mOc = aMJ.vQy;
                                            ProtocolThreeThreeUI.this.mOd = aMJ.vQz;
                                            ProtocolThreeThreeUI.this.signature = aMJ.hxh;
                                            ProtocolThreeThreeUI.this.mOe = aMJ.vQA;
                                            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), ProtocolThreeThreeUI.this.appId, ProtocolThreeThreeUI.this.mKP, ProtocolThreeThreeUI.this.fwG, Integer.valueOf(ProtocolThreeThreeUI.this.mOc), ProtocolThreeThreeUI.this.mOd, ProtocolThreeThreeUI.this.signature, ProtocolThreeThreeUI.this.mOe);
                                        }
                                        d.a(ProtocolThreeThreeUI.this.ssid, 2, ProtocolThreeThreeUI.this.getIntent());
                                        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(2));
                                    } else if (i2 == -30032) {
                                        Intent intent = new Intent();
                                        intent.putExtra("free_wifi_error_ui_error_msg", ProtocolThreeThreeUI.this.getString(R.l.ejQ));
                                        intent.setClass(ProtocolThreeThreeUI.this, FreeWifiErrorUI.class);
                                        ProtocolThreeThreeUI.this.finish();
                                        ProtocolThreeThreeUI.this.startActivity(intent);
                                    } else {
                                        d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                                        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i2));
                                    }
                                }
                            });
                        }
                    });
                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                    ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, httpURLConnection.getHeaderField("Location"));
                } else {
                    x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())));
                    d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                }
            }

            public final void h(Exception exception) {
                x.e("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), exception.getMessage());
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aLU();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass7);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aLU();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass7);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mLg = getIntent().getStringExtra("free_wifi_schema_uri");
        this.mLf = Uri.parse(this.mLg);
        this.appId = this.mLf.getQueryParameter("appId");
        this.mLc = this.mLf.getQueryParameter("shopId");
        this.mLd = this.mLf.getQueryParameter("authUrl");
        this.mLe = this.mLf.getQueryParameter("extend");
        this.fry = this.mLf.getQueryParameter("timestamp");
        this.sign = this.mLf.getQueryParameter("sign");
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.mLg);
        initView();
        if (bi.oN(this.ssid)) {
            x.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
        } else {
            c cVar;
            int i;
            c Bw = j.aMv().Bw(this.ssid);
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
            cVar.field_url = "";
            cVar.field_mid = "";
            cVar.field_wifiType = 33;
            cVar.field_connectState = 1;
            if (i != 0) {
                j.aMv().b(cVar);
            } else {
                j.aMv().c(cVar, new String[0]);
            }
            x.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", this.ssid, "", Integer.valueOf(this.cPf));
            this.mMk = new a() {
                private int mOg = -999999999;

                public final void a(String str, l lVar) {
                    ProtocolThreeThreeUI.this.ftb = ProtocolThreeThreeUI.this.aNa();
                    if (this.mOg != ProtocolThreeThreeUI.this.ftb) {
                        this.mOg = ProtocolThreeThreeUI.this.ftb;
                        ProtocolThreeThreeUI.this.qr(ProtocolThreeThreeUI.this.ftb);
                    }
                }
            };
            j.aMv().c(this.mMk);
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState));
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
            d.a(this.ssid, 4, getIntent());
        }
        com.tencent.mm.plugin.freewifi.l.r(d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
        this.ssid = m.Bi("MicroMsg.FreeWifi.Protocol33UI");
        this.bssid = m.Bj("MicroMsg.FreeWifi.Protocol33UI");
        this.cPf = getIntent().getIntExtra("free_wifi_source", 1);
        this.fei = getIntent().getIntExtra("free_wifi_channel_id", 0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ProtocolThreeThreeUI.this.goBack();
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
                com.tencent.mm.plugin.freewifi.l.s(d.aMm(), ProtocolThreeThreeUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeThreeUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), d.qo(ProtocolThreeThreeUI.this.aNa()));
                if (ProtocolThreeThreeUI.this.aNa() == 2) {
                    ProtocolThreeThreeUI.this.finish();
                    return;
                }
                d.a(ProtocolThreeThreeUI.this.ssid, 1, ProtocolThreeThreeUI.this.getIntent());
                ProtocolThreeThreeUI.this.connect();
            }
        });
        this.mMZ = (Button) findViewById(R.h.cUt);
        this.mMZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        if (bi.oN(this.ssid)) {
            this.mMX.setText(getString(R.l.ekn));
            this.mMY.setVisibility(4);
        }
        setMMTitle(getString(R.l.ekp));
    }

    protected final void connect() {
        if (m.Bf(this.ssid)) {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
            d.a(this.ssid, 3, getIntent());
        } else if (m.Bf(this.mLd)) {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
            d.a(this.ssid, 3, getIntent());
        } else {
            this.ftb = aNa();
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), d.qo(this.ftb));
            if (this.ftb != 2) {
                this.mOA.K(30000, 30000);
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(60));
                m.Bf(this.mLd);
                StringBuilder stringBuilder = new StringBuilder(this.mLd);
                if (this.mLd.indexOf("?") == -1) {
                    stringBuilder.append("?extend=").append(this.mLe);
                } else {
                    stringBuilder.append("&extend=").append(this.mLe);
                }
                final String stringBuilder2 = stringBuilder.toString();
                j.aMy().aMg().post(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), stringBuilder2);
                        com.tencent.mm.plugin.freewifi.a.a.aLU();
                        com.tencent.mm.plugin.freewifi.a.a.a(stringBuilder2, new com.tencent.mm.plugin.freewifi.a.a.a() {
                            public final void e(HttpURLConnection httpURLConnection) {
                                int responseCode = httpURLConnection.getResponseCode();
                                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(responseCode));
                                if (responseCode == 200) {
                                    j.aMy().aMg().post(/* anonymous class already generated */);
                                } else if (responseCode == HardCoderJNI.SCENE_QUIT_CHATTING) {
                                    ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, httpURLConnection.getHeaderField("Location"));
                                } else {
                                    x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())));
                                    d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                                }
                            }

                            public final void h(Exception exception) {
                                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), exception.getMessage());
                                d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                            }
                        });
                    }
                });
                return;
            }
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void qr(int i) {
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), Integer.valueOf(i));
        switch (i) {
            case 1:
                this.mMI.setVisibility(4);
                this.mMY.setText(R.l.dUx);
                this.mNX = h.a(this.mController.xRr, getString(R.l.dUx), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(ProtocolThreeThreeUI.this.ssid, 4, ProtocolThreeThreeUI.this.getIntent());
                        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.D(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.E(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(4));
                    }
                });
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
                return;
            case 2:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mOA.TN();
                this.mMY.setText(R.l.dUu);
                this.mMY.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.appId);
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
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
                return;
            case 3:
                if (this.mNX != null) {
                    this.mNX.dismiss();
                }
                this.mOA.TN();
                this.mMI.setVisibility(0);
                this.mMY.setText(R.l.ekl);
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
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
                } else {
                    this.mMX.setText(getString(R.l.dUy, new Object[]{this.ssid}));
                }
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
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
            x.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c Bw = j.aMv().Bw(this.ssid);
        if (Bw == null || !Bw.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return Bw.field_connectState;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mMk != null) {
            j.aMv().j(this.mMk);
        }
        this.mOA.TN();
        j.aMy().release();
    }
}
