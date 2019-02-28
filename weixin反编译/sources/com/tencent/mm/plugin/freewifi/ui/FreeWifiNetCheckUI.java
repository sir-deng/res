package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class FreeWifiNetCheckUI extends MMActivity {
    private String aAM;
    private int fDM;
    private al fia;
    private Intent intent;
    ImageView mNB;
    private final int mNE = 1;
    private final int mNF = 2;
    private int[] mNH = new int[]{R.g.bCl, R.g.bCm, R.g.bCn, R.g.bCo, R.g.bCp};
    ag mNI = new ag() {
        int i = 0;

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.i >= FreeWifiNetCheckUI.this.mNH.length) {
                    this.i = 0;
                }
                FreeWifiNetCheckUI.this.mNB.setImageResource(FreeWifiNetCheckUI.this.mNH[this.i]);
                this.i++;
            } else if (message.what == 2) {
                FreeWifiNetCheckUI.this.mNB.setImageResource(FreeWifiNetCheckUI.this.mNH[FreeWifiNetCheckUI.this.mNH.length - 1]);
            }
            super.handleMessage(message);
        }
    };
    private b mNP;
    private int scene;

    static /* synthetic */ void a(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiNetCheckUI, FreeWifiErrorUI.class);
        freeWifiNetCheckUI.finish();
        freeWifiNetCheckUI.startActivity(intent);
    }

    static /* synthetic */ void c(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        Intent intent = new Intent();
        intent.setClass(freeWifiNetCheckUI, FreeWifiNoWifiUI.class);
        freeWifiNetCheckUI.startActivity(intent);
    }

    public void finish() {
        if (this.fia != null) {
            this.fia.TN();
        }
        this.mNI.sendEmptyMessage(2);
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ekp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiNetCheckUI.this.finish();
                return true;
            }
        });
        this.intent = getIntent();
        m.C(this.intent);
        this.aAM = getIntent().getStringExtra("free_wifi_ap_key");
        this.scene = getIntent().getIntExtra("free_wifi_source", 1);
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", m.D(this.intent), Integer.valueOf(m.E(this.intent)), this.aAM, d.aMk());
        this.mNB = (ImageView) findViewById(R.h.cjj);
        this.fia = new al(new a() {
            public final boolean uG() {
                FreeWifiNetCheckUI.this.mNI.sendEmptyMessage(1);
                return true;
            }
        }, true);
        this.fia.K(200, 200);
        String str;
        switch (this.scene) {
            case 1:
                getIntent().putExtra("free_wifi_channel_id", 2);
                this.fDM = 2;
                if (!bi.oN(this.aAM)) {
                    Uri uri = null;
                    str = "";
                    try {
                        uri = Uri.parse(this.aAM);
                        str = uri.getQueryParameter("q");
                    } catch (Exception e) {
                        finish();
                    }
                    if (!"pc".equalsIgnoreCase(str)) {
                        "_test".equals(str);
                        aNs();
                        break;
                    }
                    str = uri.getQueryParameter("appid");
                    final String queryParameter = uri.getQueryParameter("shopid");
                    final String queryParameter2 = uri.getQueryParameter("ticket");
                    m.d(getIntent(), queryParameter2);
                    k.a aLL = k.aLL();
                    aLL.mIg = queryParameter;
                    aLL.mIh = str;
                    aLL.mIi = queryParameter2;
                    aLL.mIk = b.GetPcFrontPage.mIW;
                    aLL.mIl = b.GetPcFrontPage.name;
                    aLL.aLN().aLM();
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), queryParameter, str, queryParameter2);
                    new h(str, Integer.valueOf(queryParameter).intValue(), queryParameter2).b(new e() {
                        public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                            if (i == 0 && i2 == 0) {
                                wr aMG = ((h) kVar).aMG();
                                if (aMG != null) {
                                    Intent intent = FreeWifiNetCheckUI.this.getIntent();
                                    intent.putExtra("free_wifi_appid", aMG.nqc);
                                    intent.putExtra("free_wifi_head_img_url", aMG.nlG);
                                    intent.putExtra("free_wifi_welcome_msg", aMG.wnL);
                                    intent.putExtra("free_wifi_welcome_sub_title", aMG.nls);
                                    intent.putExtra("free_wifi_privacy_url", aMG.wnM);
                                    intent.putExtra("free_wifi_app_nickname", aMG.kzN);
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", queryParameter);
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", queryParameter2);
                                    intent.setClass(FreeWifiNetCheckUI.this, FreeWifiPcUI.class);
                                    FreeWifiNetCheckUI.this.finish();
                                    FreeWifiNetCheckUI.this.startActivity(intent);
                                }
                            } else if (!m.cE(i, i2) || m.Bf(str)) {
                                FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, FreeWifiNetCheckUI.this.getString(R.l.ejR), FreeWifiNetCheckUI.this.getString(R.l.ejS));
                            } else {
                                FreeWifiNetCheckUI.a(FreeWifiNetCheckUI.this, str + "(" + m.a(m.F(FreeWifiNetCheckUI.this.intent), b.GetPcFrontPageReturn, i2) + ")", "");
                            }
                            k.a aLL = k.aLL();
                            aLL.mIg = queryParameter;
                            aLL.mIh = str;
                            aLL.mIi = queryParameter2;
                            aLL.mIk = b.GetPcFrontPageReturn.mIW;
                            aLL.mIl = b.GetPcFrontPageReturn.name;
                            aLL.result = i2;
                            aLL.aLN().aLM();
                            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", m.D(FreeWifiNetCheckUI.this.getIntent()), Integer.valueOf(m.E(FreeWifiNetCheckUI.this.getIntent())), Integer.valueOf(i2));
                        }
                    });
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 4:
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if ("1".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 9);
                    this.fDM = 9;
                } else if ("0".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 8);
                    this.fDM = 8;
                } else {
                    getIntent().putExtra("free_wifi_channel_id", 4);
                    this.fDM = 4;
                }
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if (!str.equals("0") || !bi.oN(this.aAM)) {
                    if (!str.equals("0")) {
                        if (!str.equals("1")) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
                            finish();
                            break;
                        }
                        str = getIntent().getStringExtra("free_wifi_jsapi_param_username");
                        if (!d.isWifiEnabled()) {
                            d.aMh();
                        }
                        b.mKj.a(new com.tencent.mm.plugin.freewifi.model.h.a() {
                            public final void aS(List<ScanResult> list) {
                                if (list == null || list.size() == 0) {
                                    FreeWifiNetCheckUI.this.finish();
                                    FreeWifiNetCheckUI.c(FreeWifiNetCheckUI.this);
                                    return;
                                }
                                bfc bfc = new bfc();
                                bfc.wRv = new LinkedList();
                                for (ScanResult scanResult : list) {
                                    if (scanResult != null) {
                                        cq cqVar = new cq();
                                        cqVar.mac = scanResult.BSSID;
                                        cqVar.vOr = scanResult.level;
                                        cqVar.ssid = scanResult.SSID;
                                        bfc.wRv.add(cqVar);
                                    }
                                }
                                k.a aLL = k.aLL();
                                aLL.mIi = m.D(FreeWifiNetCheckUI.this.intent);
                                aLL.mIk = b.ScanNearFieldWifiAndReport.mIW;
                                aLL.mIl = b.ScanNearFieldWifiAndReport.name;
                                aLL.fDM = 9;
                                aLL.aLN().aLM();
                                new com.tencent.mm.plugin.freewifi.d.k(str, bfc, 9, m.D(FreeWifiNetCheckUI.this.getIntent())).b(new e() {
                                    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                                        String aMQ = ((com.tencent.mm.plugin.freewifi.d.k) kVar).aMQ();
                                        if (bi.oN(aMQ)) {
                                            FreeWifiNetCheckUI.this.finish();
                                            FreeWifiNetCheckUI.c(FreeWifiNetCheckUI.this);
                                            return;
                                        }
                                        FreeWifiNetCheckUI.this.aAM = aMQ;
                                        FreeWifiNetCheckUI.this.getIntent().putExtra("free_wifi_ap_key", aMQ);
                                        FreeWifiNetCheckUI.this.fDM = 9;
                                        FreeWifiNetCheckUI.this.aNs();
                                    }
                                });
                            }
                        });
                        break;
                    }
                    aNs();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
                finish();
                break;
                break;
            case 5:
                this.fDM = getIntent().getIntExtra("free_wifi_channel_id", 1);
                if (!bi.oN(this.aAM)) {
                    aNs();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 6:
                getIntent().putExtra("free_wifi_channel_id", 10);
                this.fDM = 10;
                if (!bi.oN(this.aAM)) {
                    aNs();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            default:
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
                finish();
                break;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", m.D(getIntent()), Integer.valueOf(m.E(this.intent)), Integer.valueOf(this.fDM));
    }

    private void aNs() {
        if (bi.oN(this.aAM)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
            return;
        }
        this.mNP = new b(this, this.aAM, this.fDM);
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", m.D(getIntent()), Integer.valueOf(m.E(this.intent)), this.aAM, Integer.valueOf(this.fDM));
        b bVar = this.mNP;
        if (bi.oN(bVar.fqu)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            bVar.activity.finish();
        }
        bVar.activity.getIntent().putExtra("free_wifi_url", bVar.fqu);
        bVar.activity.getIntent().putExtra("free_wifi_ap_key", bVar.fqu);
        if (bi.oN(bVar.fqu)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
            bVar.activity.finish();
            return;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), bVar.fqu, Integer.valueOf(bVar.fDM));
        k.a aLL = k.aLL();
        aLL.fqu = bVar.fqu;
        aLL.mIi = m.D(bVar.intent);
        aLL.mIk = b.GetFrontPage.mIW;
        aLL.mIl = b.GetFrontPage.name;
        aLL.fDM = bVar.fDM;
        aLL.mIj = m.F(bVar.intent);
        aLL.aLN().b(bVar.intent, false).aLM();
        new com.tencent.mm.plugin.freewifi.d.a(bVar.fqu, bVar.fDM, m.D(bVar.intent)).v(bVar.activity).b(new e() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                k.a aLL = k.aLL();
                aLL.fqu = b.this.fqu;
                aLL.mIi = m.D(b.this.intent);
                aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.mIW;
                aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.name;
                aLL.mIj = m.F(b.this.intent);
                aLL.fDM = b.this.fDM;
                aLL.result = i2;
                aLL.lfa = str;
                aLL.aLN().b(b.this.intent, i2 != 0).aLM();
                x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", m.D(b.this.intent), Integer.valueOf(m.E(b.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    b bVar = b.this;
                    if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                        com.tencent.mm.plugin.freewifi.d.a aVar = (com.tencent.mm.plugin.freewifi.d.a) kVar;
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", aVar.aMF());
                        wr aMG = aVar.aMG();
                        if (aMG != null) {
                            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), aMG.nqc, aMG.kzN, aMG.kyG, aMG.nlG, aMG.wnL, aMG.wnM, aMG.vSO, aMG.wdm, Integer.valueOf(aMG.vKM));
                            bVar.intent.putExtra("free_wifi_appid", aMG.nqc);
                            bVar.intent.putExtra("free_wifi_head_img_url", aMG.nlG);
                            bVar.intent.putExtra("free_wifi_welcome_msg", aMG.wnL);
                            bVar.intent.putExtra("free_wifi_privacy_url", aMG.wnM);
                            bVar.intent.putExtra("free_wifi_app_nickname", aMG.kzN);
                            bVar.intent.putExtra("free_wifi_welcome_sub_title", aMG.nls);
                        }
                        if (bVar.fDM != 2) {
                            bVar.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
                        }
                        bas aME = aVar.aME();
                        if (aME == null) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
                            bVar.activity.finish();
                            aLL = k.aLL();
                            aLL.fqu = bVar.fqu;
                            aLL.mIi = m.D(bVar.intent);
                            aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.mIW;
                            aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                            aLL.mIj = m.F(bVar.intent);
                            aLL.fDM = bVar.fDM;
                            aLL.result = -1;
                            aLL.lfa = "qstrInfo is null.";
                            aLL.aLN().b(bVar.intent, true).aLM();
                            return;
                        } else if (m.Bf(aME.lTP)) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
                            bVar.activity.finish();
                            aLL = k.aLL();
                            aLL.fqu = bVar.fqu;
                            aLL.mIi = m.D(bVar.intent);
                            aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.mIW;
                            aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                            aLL.mIj = m.F(bVar.intent);
                            aLL.fDM = bVar.fDM;
                            aLL.result = -1;
                            aLL.lfa = "qstrInfo.Ssid is empty.";
                            aLL.aLN().b(bVar.intent, true).aLM();
                            return;
                        } else {
                            bVar.intent.putExtra("free_wifi_ssid", aME.lTP);
                            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), Integer.valueOf(aME.wOt), aME.lTP, aME.wju);
                            String aMH = aVar.aMH();
                            String aMI = aVar.aMI();
                            bVar.intent.putExtra("free_wifi_openid", aMH);
                            bVar.intent.putExtra("free_wifi_tid", aMI);
                            bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", aMG.vSO);
                            bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", aMG.wdm);
                            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), aMH, aMI);
                            bVar.intent.putExtra("free_wifi_protocol_type", aME.wOt);
                            if (aME.wOt == 10) {
                                if (bi.oN(aME.lTP) || bi.oN(aME.wju)) {
                                    x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                    bVar.activity.finish();
                                    return;
                                }
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
                                bVar.intent.putExtra("free_wifi_auth_type", 2);
                                bVar.intent.putExtra("free_wifi_passowrd", aME.wju);
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                                return;
                            } else if (aME.wOt == 11) {
                                if (bi.oN(aME.lTP) || bi.oN(aME.wju)) {
                                    x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                    bVar.activity.finish();
                                    return;
                                }
                                bVar.intent.putExtra("free_wifi_auth_type", 2);
                                bVar.intent.putExtra("free_wifi_passowrd", aME.wju);
                                bVar.intent.setClass(bVar.activity, FreewifiActivateWeChatNoAuthStateUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                                return;
                            } else if (aME.wOt == 12) {
                                bVar.intent.putExtra("free_wifi_auth_type", 1);
                                bVar.intent.setClass(bVar.activity, FreeWifiActivateAuthStateUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                                return;
                            } else if (aME.wOt == 31) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                                x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)));
                                String stringExtra = bVar.intent.getStringExtra("free_wifi_schema_ticket");
                                x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), stringExtra);
                                if (bi.oN(stringExtra)) {
                                    bVar.activity.finish();
                                    aLL = k.aLL();
                                    aLL.fqu = bVar.fqu;
                                    aLL.mIi = m.D(bVar.intent);
                                    aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.mIW;
                                    aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                    aLL.fDM = bVar.fDM;
                                    aLL.mIj = m.F(bVar.intent);
                                    aLL.result = -1;
                                    aLL.lfa = "31 ticket is empty.";
                                    aLL.aLN().b(bVar.intent, true).aLM();
                                    return;
                                }
                                String str2 = aME.lTP;
                                String str3 = aMG.vSO;
                                String str4 = aMG.wdm;
                                WifiInfo aMl = d.aMl();
                                if (aMl == null) {
                                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)));
                                    bVar.By(bVar.activity.getString(R.l.ejV));
                                    aLL = k.aLL();
                                    aLL.fqu = bVar.fqu;
                                    aLL.mIi = m.D(bVar.intent);
                                    aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.mIW;
                                    aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                    aLL.fDM = bVar.fDM;
                                    aLL.mIj = m.F(bVar.intent);
                                    aLL.result = -1;
                                    aLL.lfa = "wifiInfo is empty.";
                                    aLL.aLN().b(bVar.intent, true).aLM();
                                    return;
                                }
                                boolean Bo = d.Bo(str2);
                                String str5 = "MicroMsg.FreeWifi.FreeWifiNetCheckUI";
                                String str6 = "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. wifiInfo=%s, is_current_connected_ssid_equals_target_ssid=%b";
                                Object[] objArr = new Object[4];
                                objArr[0] = m.D(bVar.intent);
                                objArr[1] = Integer.valueOf(m.E(bVar.intent));
                                objArr[2] = aMl == null ? "null" : aMl.toString();
                                objArr[3] = Boolean.valueOf(Bo);
                                x.i(str5, str6, objArr);
                                str5 = m.Bg(aMl.getSSID());
                                str6 = aMl.getBSSID();
                                String macAddress = aMl.getMacAddress();
                                if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                                    macAddress = m.aLQ();
                                }
                                x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)), bVar.fqu, str5, str6, macAddress, stringExtra);
                                aLL = k.aLL();
                                aLL.fqu = bVar.fqu;
                                aLL.mIi = m.D(bVar.intent);
                                aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.mIW;
                                aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                aLL.fDM = bVar.fDM;
                                aLL.mIj = m.F(bVar.intent);
                                aLL.result = 0;
                                aLL.lfa = "";
                                aLL.aLN().b(bVar.intent, true).aLM();
                                aLL = k.aLL();
                                aLL.ssid = bVar.intent.getStringExtra("free_wifi_ssid");
                                aLL.fqu = bVar.fqu;
                                aLL.mIh = bVar.intent.getStringExtra("free_wifi_appid");
                                aLL.mIi = m.D(bVar.intent);
                                aLL.mIj = m.F(bVar.intent);
                                aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfo.mIW;
                                aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfo.name;
                                aLL.fDM = m.G(bVar.intent);
                                aLL.mIj = m.F(bVar.intent);
                                aLL.aLN().b(bVar.intent, false).aLM();
                                new i(bVar.fqu, str5, str6, macAddress, stringExtra, m.D(bVar.intent)).v(bVar.activity).b(new AnonymousClass2(aMH, aMI, str3, str4));
                                return;
                            } else if (aME.wOt == 32) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
                                x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", m.D(bVar.intent), Integer.valueOf(m.E(bVar.intent)));
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                                return;
                            } else if (aME.wOt == 1) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
                                bVar.intent.putExtra("free_wifi_auth_type", 1);
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.bqB, R.a.bqA);
                                return;
                            } else {
                                bVar.activity.finish();
                                bVar.By(bVar.activity.getString(R.l.ejX));
                                return;
                            }
                        }
                    }
                    bVar.By(bVar.activity.getString(R.l.ejV));
                } else if (m.cE(i, i2) && !m.Bf(str)) {
                    b.this.By(str + "(" + m.a(m.F(b.this.intent), com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn, i2) + ")");
                } else if (i2 == -30031) {
                    b.this.By(b.this.activity.getString(R.l.ejW));
                } else {
                    b.this.By(b.this.activity.getString(R.l.ejV) + "(" + String.format("%02d", new Object[]{Integer.valueOf(m.F(b.this.intent))}) + com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.mIW + Math.abs(i2) + ")");
                }
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.diH;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mNP != null) {
            this.mNP = null;
        }
        this.fia.TN();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }
}
