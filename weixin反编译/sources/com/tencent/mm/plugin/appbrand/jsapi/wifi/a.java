package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 316;
    public static final String NAME = "connectWifi";

    public static class a extends f {
        private static final int CTRL_INDEX = 322;
        private static final String NAME = "onWifiConnected";
    }

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        super.a(jVar, jSONObject, i);
        Map hashMap;
        if (!d.jAP) {
            x.e("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12000));
            jVar.E(i, e("fail:not invoke startWifi", hashMap));
        } else if (jSONObject == null || !jSONObject.has("SSID")) {
            x.e("MicroMsg.JsApiConenctWifi", "params is invalid");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            jVar.E(i, e("fail:invalid data", hashMap));
        } else {
            Context context = jVar.getContext();
            if (context == null) {
                x.e("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                jVar.E(i, e("fail:context is null", hashMap));
                return;
            }
            d.bZ(context);
            if (c.isWifiEnabled()) {
                final b dVar = new com.tencent.mm.plugin.appbrand.widget.c.d(context);
                dVar.setCancelable(false);
                ah.y(new Runnable() {
                    public final void run() {
                        jVar.iuk.a(dVar);
                    }
                });
                d.a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a() {
                    public final void tz(String str) {
                        d.a(null);
                        ah.y(new Runnable() {
                            public final void run() {
                                if (dVar != null) {
                                    dVar.dismiss();
                                }
                            }
                        });
                        if (str.equals("ok")) {
                            com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b aio = d.aio();
                            x.i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", aio);
                            Map hashMap;
                            if (aio == null) {
                                x.e("MicroMsg.JsApiConenctWifi", "[onWiFiConnect]currentWIfi is null");
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(0));
                                jVar.E(i, a.this.e("ok:can't gain current wifi may be not open GPS", hashMap));
                                return;
                            }
                            try {
                                Map hashMap2 = new HashMap();
                                hashMap2.put("wifi", aio.sO());
                                hashMap2.put("errCode", Integer.valueOf(0));
                                jVar.E(i, a.this.e("ok", hashMap2));
                                return;
                            } catch (Throwable e) {
                                x.e("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
                                x.printErrStackTrace("MicroMsg.JsApiConenctWifi", e, "", new Object[0]);
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12010));
                                jVar.E(i, a.this.e("fail:parse json err", hashMap));
                                return;
                            }
                        }
                        HashMap hashMap3 = new HashMap();
                        if (str.equals("duplicated request")) {
                            hashMap3.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_FAILED));
                        } else if (str.equals("password error")) {
                            hashMap3.put("errCode", Integer.valueOf(12002));
                        } else {
                            hashMap3.put("errCode", Integer.valueOf(12003));
                        }
                        x.e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errMsg:%s", str);
                        jVar.E(i, a.this.e("fail:" + str, hashMap3));
                    }
                });
                com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, new com.tencent.mm.plugin.appbrand.c.b() {
                    public final void onDestroy() {
                        x.d("MicroMsg.JsApiConenctWifi", "remove listener");
                        d.a(null);
                        com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, this);
                    }
                });
                String optString = jSONObject.optString("SSID");
                String optString2 = jSONObject.optString("BSSID");
                String optString3 = jSONObject.optString("password");
                if (optString.equals("")) {
                    x.e("MicroMsg.JsApiConenctWifi", "params is invalid");
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_PLAY_BEGIN));
                    jVar.E(i, e("fail:invalid data", hashMap));
                    return;
                }
                x.i("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", optString, optString2);
                d.C(optString, optString2, optString3);
                return;
            }
            x.e("MicroMsg.JsApiConenctWifi", "wifi is disable");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
            jVar.E(i, e("fail:wifi is disable", hashMap));
        }
    }
}
