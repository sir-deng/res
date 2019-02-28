package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.annotation.TargetApi;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 221;
    private static final String NAME = "startBeaconDiscovery";
    com.tencent.mm.plugin.appbrand.c.b jkY = null;
    private com.tencent.mm.plugin.appbrand.jsapi.d.a.a.a jnd;

    private static class b extends f {
        private static final int CTRL_INDEX = 224;
        private static final String NAME = "onBeaconUpdated";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static class a extends f {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", jSONObject);
        UUID[] q = q(jSONObject);
        if (q == null || q.length <= 0) {
            Map hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS));
            jVar.E(i, e("fail", hashMap));
            return;
        }
        int i2;
        String str = jVar.mAppId;
        com.tencent.mm.plugin.appbrand.jsapi.d.a.a sK = a.sK(jVar.mAppId);
        if (sK == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
            sK = new com.tencent.mm.plugin.appbrand.jsapi.d.a.a();
            a.a(str, sK);
        }
        if (this.jnd == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
            this.jnd = new com.tencent.mm.plugin.appbrand.jsapi.d.a.a.a() {
                b jng = new b();
                a jnh = new a();

                public final void x(Map<String, JSONObject> map) {
                    JSONArray jSONArray = new JSONArray();
                    for (JSONObject jSONObject : map.values()) {
                        if (jSONObject != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("beacons", jSONArray);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", e);
                    }
                    f aA = this.jng.aA(jVar.mAppId, jVar.hashCode());
                    aA.mData = jSONObject2.toString();
                    aA.afI();
                }

                public final void cM(boolean z) {
                    x.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", Boolean.valueOf(z));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("available", z);
                        jSONObject.put("discovering", false);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", e);
                    }
                    x.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject.toString());
                    f aA = this.jnh.aA(jVar.mAppId, jVar.hashCode());
                    aA.mData = jSONObject.toString();
                    aA.afI();
                }
            };
        }
        if (this.jkY == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
            this.jkY = new com.tencent.mm.plugin.appbrand.c.b() {
                public final void onDestroy() {
                    x.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
                    com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, this);
                    com.tencent.mm.plugin.appbrand.jsapi.d.a.a sK = a.sK(jVar.mAppId);
                    if (sK != null) {
                        sK.vp();
                        a.remove(jVar.mAppId);
                    }
                    c.this.jkY = null;
                }
            };
            com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, this.jkY);
        }
        sK.jnc = q;
        sK.jnd = this.jnd;
        x.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", Integer.valueOf(sK.hashCode()));
        if (sK.agz()) {
            x.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", Integer.valueOf(sK.hashCode()));
            i2 = TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY;
        } else if (com.tencent.mm.compatible.util.f.fO(18)) {
            x.e("MicroMsg.BeaconManager", "API version is below 18!");
            i2 = CdnLogic.kMediaTypeExposeImage;
        } else if (sK.jna == null) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            i2 = TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS;
        } else if (!sK.jna.isEnabled()) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            i2 = TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS;
        } else if (sK.jna.isDiscovering()) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
            i2 = TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY;
        } else {
            sK.jnb.clear();
            x.i("MicroMsg.BeaconManager", "startLeScan:%b", Boolean.valueOf(sK.jna.startLeScan(sK.jne)));
            if (sK.jna.startLeScan(sK.jne)) {
                sK.fBn = true;
                i2 = 0;
            } else {
                i2 = TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL;
            }
        }
        Map hashMap2 = new HashMap();
        hashMap2.put("errCode", Integer.valueOf(i2));
        jVar.E(i, e(i2 == 0 ? "ok" : "fail", hashMap2));
    }

    private static UUID[] q(JSONObject jSONObject) {
        UUID[] uuidArr = null;
        if (jSONObject.has("uuids")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("uuids"));
                uuidArr = new UUID[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    x.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", jSONArray.getString(i));
                    uuidArr[i] = UUID.fromString(r3);
                }
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
            }
        }
        return uuidArr;
    }
}
