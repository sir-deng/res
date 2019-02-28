package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class e extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 180;
    private static final String NAME = "createBLEConnection";
    private com.tencent.mm.plugin.appbrand.c.b jkY;

    private static class c extends f {
        private static final int CTRL_INDEX = 188;
        private static final String NAME = "onBLEConnectionStateChanged";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private class a extends BluetoothGattCallback {
        private int jfG;
        private WeakReference<j> jla;
        private String mAppId;

        /* synthetic */ a(e eVar, j jVar, int i, byte b) {
            this(jVar, i);
        }

        private a(j jVar, int i) {
            this.jla = new WeakReference(jVar);
            this.mAppId = jVar.mAppId;
            this.jfG = i;
        }

        private void sE(String str) {
            if (this.jla.get() != null) {
                ((j) this.jla.get()).E(this.jfG, str);
            }
        }

        public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            boolean z;
            String str = "MicroMsg.JsApiCreateBLEConnection";
            String str2 = "onConnectionStateChange BluetoothGatt %s, status:%d, newState:%d";
            Object[] objArr = new Object[3];
            objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            x.i(str, str2, objArr);
            if (i2 == 2) {
                x.i("MicroMsg.JsApiCreateBLEConnection", "Attempting to start service discovery");
                bluetoothGatt.discoverServices();
                z = true;
            } else {
                if (i2 == 0) {
                    bluetoothGatt.close();
                    x.e("MicroMsg.JsApiCreateBLEConnection", "device not connected!");
                    Map hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(10003));
                    sE(e.this.e("fail", hashMap));
                    a.bG(27, 36);
                }
                z = false;
            }
            c cVar = new c();
            JSONObject jSONObject = new JSONObject();
            String address = bluetoothGatt.getDevice().getAddress();
            if (z) {
                Map agi = b.agi();
                if (!agi.containsKey(address)) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONObject2.put("deviceId", address);
                        jSONObject2.put("name", bluetoothGatt.getDevice().getName());
                        jSONObject2.put("RSSI", 0);
                        jSONObject2.put("advertisData", "");
                        jSONObject2.put("advertisServiceUUIDs", jSONArray);
                        jSONObject2.put("localName", "");
                        agi.put(address, jSONObject2);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiCreateBLEConnection", "put JSON data error : %s", e);
                    }
                }
            }
            x.i("MicroMsg.JsApiCreateBLEConnection", "onConnectionStateChange with deviceId : " + address);
            try {
                jSONObject.put("deviceId", address);
                jSONObject.put("connected", z);
            } catch (JSONException e2) {
                x.e("MicroMsg.JsApiCreateBLEConnection", "put JSON data error : %s", e2);
            }
            x.i("MicroMsg.JsApiCreateBLEConnection", "deviceId %s, state %s", address, Boolean.valueOf(z));
            if (b.jkS) {
                f aA = cVar.aA(this.mAppId, 0);
                aA.mData = jSONObject.toString();
                aA.afI();
                return;
            }
            x.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init,return...");
        }

        public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            String str = "MicroMsg.JsApiCreateBLEConnection";
            String str2 = "onServicesDiscovered, gatt:%s, status:%d";
            Object[] objArr = new Object[2];
            objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
            objArr[1] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            if (this.jla.get() != null) {
                Map hashMap;
                if (i == 0) {
                    str2 = bluetoothGatt.getDevice().getAddress();
                    x.i("MicroMsg.JsApiCreateBLEConnection", "onServicesDiscovered GATT_SUCCESS with deviceId : " + str2);
                    com.tencent.mm.y.u.b g = b.g((j) this.jla.get());
                    Map hashMap2 = new HashMap();
                    for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                        boolean z = bluetoothGattService.getType() == 0;
                        String toUpperCase = bluetoothGattService.getUuid().toString().toUpperCase();
                        hashMap2.put(toUpperCase, Boolean.valueOf(z));
                        x.i("MicroMsg.JsApiCreateBLEConnection", "type %s, serviceId %s", Boolean.valueOf(z), toUpperCase);
                        String str3 = ("key_bluetooth_gatt_service" + str2 + toUpperCase).hashCode();
                        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                        JSONArray jSONArray = new JSONArray();
                        if (characteristics != null) {
                            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                String toUpperCase2 = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                                int properties = bluetoothGattCharacteristic.getProperties();
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("read", (properties & 2) != 0);
                                    String str4 = "write";
                                    z = ((properties & 8) == 0 && (properties & 4) == 0) ? false : true;
                                    jSONObject.put(str4, z);
                                    jSONObject.put("notify", (properties & 16) != 0);
                                    jSONObject.put("indicate", (properties & 32) != 0);
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("uuid", toUpperCase2);
                                    jSONObject2.put("properties", jSONObject);
                                    jSONArray.put(jSONObject2);
                                } catch (JSONException e) {
                                    x.e("MicroMsg.JsApiCreateBLEConnection", "JSONException %s", e.getMessage());
                                }
                                g.o(str2 + toUpperCase + toUpperCase2, bluetoothGattCharacteristic);
                            }
                        }
                        x.i("MicroMsg.JsApiCreateBLEConnection", "jsonArray %s", jSONArray.toString());
                        g.o(str3, jSONArray);
                    }
                    g.o("key_bluetooth_services_uuid" + str2, hashMap2);
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(0));
                    sE(e.this.e("ok", hashMap));
                    a.kw(26);
                    return;
                }
                x.i("MicroMsg.JsApiCreateBLEConnection", "onServicesDiscovered fail..");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10006));
                sE(e.this.e("fail", hashMap));
                a.bG(27, 37);
            }
        }

        public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            String str = "MicroMsg.JsApiCreateBLEConnection";
            String str2 = "onCharacteristicRead, gatt:%s, status:%d";
            Object[] objArr = new Object[2];
            objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
            objArr[1] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            if (i == 0) {
                b bVar = new b();
                str2 = new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2));
                String toUpperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                String address = bluetoothGatt.getDevice().getAddress();
                String toUpperCase2 = bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Columns.VALUE, str2);
                    jSONObject.put("serviceId", toUpperCase2);
                    jSONObject.put("characteristicId", toUpperCase);
                    jSONObject.put("deviceId", address);
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiCreateBLEConnection", "put JSON data error : %s", e);
                }
                x.i("MicroMsg.JsApiCreateBLEConnection", "read value %s, serviceId %s, uuid %s, deviceId %s", str2, toUpperCase2, toUpperCase, address);
                if (b.jkS) {
                    f aA = bVar.aA(this.mAppId, 0);
                    aA.mData = jSONObject.toString();
                    aA.afI();
                    return;
                }
                x.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init,return...");
            }
        }

        public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String str = "MicroMsg.JsApiCreateBLEConnection";
            String str2 = "onCharacteristicChanged gatt:%s";
            Object[] objArr = new Object[1];
            objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
            x.i(str, str2, objArr);
            b bVar = new b();
            str2 = new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2));
            String toUpperCase = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            String address = bluetoothGatt.getDevice().getAddress();
            String toUpperCase2 = bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Columns.VALUE, str2);
                jSONObject.put("serviceId", toUpperCase2);
                jSONObject.put("characteristicId", toUpperCase);
                jSONObject.put("deviceId", address);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiCreateBLEConnection", "put JSON data error : %s", e);
            }
            x.i("MicroMsg.JsApiCreateBLEConnection", "value %s, serviceId %s, uuid %s, deviceId %s", str2, toUpperCase2, toUpperCase, address);
            if (b.jkS) {
                f aA = bVar.aA(this.mAppId, 0);
                aA.mData = jSONObject.toString();
                aA.afI();
                return;
            }
            x.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init,return...");
        }

        public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            String str = "MicroMsg.JsApiCreateBLEConnection";
            String str2 = "onCharacteristicWrite, gatt:%s, status:%d";
            Object[] objArr = new Object[2];
            objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
            objArr[1] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            String str3 = new String(bluetoothGattCharacteristic.getValue());
            str = bluetoothGatt.getDevice().getName();
            str2 = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
            x.i("MicroMsg.JsApiCreateBLEConnection", "write name %s, uuid %s, value %s, status %s", str, str2, str3, Integer.valueOf(i));
            if (!b.jkS) {
                x.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init,return...");
            } else if (i == 0) {
                b.agk().E(b.agl(), "{\"errCode\":0,\"errMsg\":\"writeBLECharacteristicValue:ok\"}");
                a.kw(57);
            } else {
                b.agk().E(b.agl(), "{\"errCode\":10008,\"errMsg\":\"writeBLECharacteristicValue:fail\"}");
                a.bG(58, 67);
            }
        }

        public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        }
    }

    private static class b extends f {
        private static final int CTRL_INDEX = 187;
        private static final String NAME = "onBLECharacteristicValueChange";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        a.kv(25);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiCreateBLEConnection", "JsApiCreateBLEConnection data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        x.i("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data %s", jSONObject.toString());
        Map hashMap;
        if (com.tencent.mm.compatible.util.f.fO(18)) {
            x.e("MicroMsg.JsApiCreateBLEConnection", "API version is below 18!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(27, 29);
        } else if (b.jkS) {
            String optString = jSONObject.optString("deviceId");
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiCreateBLEConnection", "bluetoothManager is null!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(27, 31);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null) {
                x.e("MicroMsg.JsApiCreateBLEConnection", "bluetoothAdapter is null!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(27, 32);
            } else if (adapter.isEnabled()) {
                x.i("MicroMsg.JsApiCreateBLEConnection", " get bluetoothDevice with deviceId : " + optString);
                try {
                    BluetoothDevice remoteDevice = adapter.getRemoteDevice(optString);
                    if (remoteDevice == null) {
                        x.e("MicroMsg.JsApiCreateBLEConnection", "bluetoothDevice is null!");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(10002));
                        jVar.E(i, e("fail", hashMap));
                        return;
                    }
                    com.tencent.mm.y.u.b g = b.g(jVar);
                    BluetoothGatt connectGatt = remoteDevice.connectGatt(jVar.getContext(), false, new a(this, jVar, i, (byte) 0));
                    if (connectGatt == null) {
                        x.e("MicroMsg.JsApiCreateBLEConnection", "bluetoothGatt is null!");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(10003));
                        jVar.E(i, e("fail", hashMap));
                        a.bG(27, 34);
                        return;
                    }
                    x.i("MicroMsg.JsApiCreateBLEConnection", "create BluetoothGatt %s", connectGatt.toString());
                    g.o("key_bluetooth_gatt" + optString, connectGatt);
                    if (this.jkY == null) {
                        this.jkY = new com.tencent.mm.plugin.appbrand.c.b() {
                            public final void onDestroy() {
                                x.i("MicroMsg.JsApiCreateBLEConnection", "onDestroy, release resource");
                                com.tencent.mm.y.u.b g = b.g(jVar);
                                if (g == null) {
                                    x.e("MicroMsg.JsApiCreateBLEConnection", "keyValueSet is null, err");
                                    return;
                                }
                                for (String str : g.GR()) {
                                    if (str.startsWith("key_bluetooth_gatt")) {
                                        BluetoothGatt bluetoothGatt = (BluetoothGatt) g.get(str, null);
                                        if (bluetoothGatt == null) {
                                            x.e("MicroMsg.JsApiCreateBLEConnection", "get bluetoothGatt failed, bluetoothGatt is null!");
                                        } else {
                                            x.i("MicroMsg.JsApiCreateBLEConnection", "close %s", str);
                                            bluetoothGatt.disconnect();
                                            bluetoothGatt.close();
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.appbrand.c.b(jVar.mAppId, this);
                            }
                        };
                        com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, this.jkY);
                    }
                } catch (IllegalArgumentException e) {
                    x.e("MicroMsg.JsApiCreateBLEConnection", "macAddress is wrong!");
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(10002));
                    jVar.E(i, e("fail", hashMap));
                    a.bG(27, 35);
                }
            } else {
                hashMap = new HashMap();
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(27, 32);
            }
        } else {
            x.e("MicroMsg.JsApiCreateBLEConnection", "bluetooth is not init!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(27, 30);
        }
    }
}
