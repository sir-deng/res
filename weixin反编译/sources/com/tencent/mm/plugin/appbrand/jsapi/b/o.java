package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class o extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 177;
    private static final String NAME = "stopBluetoothDevicesDiscovery";

    private static class a extends f {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.kv(101);
        x.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBluetoothDevicesDiscovery!");
        Map hashMap = new HashMap();
        if (com.tencent.mm.compatible.util.f.fO(18)) {
            x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(103, 105);
        } else if (b.jkS) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothManager is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(103, 107);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothAdapter is null or not enable!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(103, 108);
                return;
            }
            com.tencent.mm.plugin.appbrand.jsapi.b.n.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.b.n.a) b.g(jVar).get("key_bluetooth_le_scaner", null);
            if (aVar == null) {
                x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetoothLEScaner is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                jVar.E(i, e("fail", hashMap));
                a.bG(103, 109);
                return;
            }
            adapter.stopLeScan(aVar);
            hashMap.put("isDiscovering", Boolean.valueOf(false));
            jVar.E(i, e("ok", hashMap));
            a aVar2 = new a();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("available", true);
                jSONObject2.put("discovering", false);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "put JSON data error : %s", e);
            }
            x.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChange %s", jSONObject2.toString());
            f aA = aVar2.aA(jVar.mAppId, jVar.hashCode());
            aA.mData = jSONObject2.toString();
            aA.afI();
            a.kw(102);
        } else {
            x.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(103, 106);
        }
    }
}
