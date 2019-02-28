package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class n extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 176;
    private static final String NAME = "startBluetoothDevicesDiscovery";
    boolean jlg;
    JSONObject jlh;

    public class a implements LeScanCallback {
        private Map<String, JSONObject> jkV;
        private j jli;
        private al jlj = null;
        public final ParcelUuid jlk = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");

        public a(j jVar) {
            this.jli = jVar;
            this.jkV = b.agi();
            this.jlj = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    c cVar = new c();
                    Map agi = b.agi();
                    JSONArray jSONArray = new JSONArray();
                    for (String str : agi.keySet()) {
                        jSONArray.put(agi.get(str));
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("devices", jSONArray);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e, "", new Object[0]);
                    }
                    if (jSONArray.length() > 0 && b.jkS) {
                        f aA = cVar.aA(a.this.jli.mAppId, a.this.jli.hashCode());
                        aA.mData = jSONObject.toString();
                        aA.afI();
                        b.agn();
                        x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", " run OnBluetoothDeviceFoundEvent in onTimerExpired!");
                    }
                    return true;
                }
            }, false);
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            b(bluetoothDevice, i, bArr);
        }

        private synchronized void b(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice == null) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "scan device null,return..");
            } else {
                String oM = bi.oM(bluetoothDevice.getName());
                String address = bluetoothDevice.getAddress();
                x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "onLeScan for deviceId : " + address + ",name : " + oM);
                if (!bi.oN(address)) {
                    Object str;
                    n.this.jlg = n.this.jlh.optBoolean("allowDuplicatesKey");
                    List<ParcelUuid> arrayList = new ArrayList();
                    String T = T(bArr);
                    JSONObject S = S(bArr);
                    byte[] a = a(bArr, arrayList);
                    if (a != null) {
                        str = new String(Base64.encode(a, 2));
                    } else {
                        str = null;
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (ParcelUuid uuid : arrayList) {
                        jSONArray.put(uuid.getUuid().toString().toUpperCase());
                    }
                    c cVar = new c();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("deviceId", address);
                        jSONObject.put("name", oM);
                        jSONObject.put("RSSI", i);
                        jSONObject.put("advertisData", str);
                        jSONObject.put("advertisServiceUUIDs", jSONArray);
                        jSONObject.put("localName", T);
                        if (S.length() != 0) {
                            jSONObject.put("serviceData", S);
                        }
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e);
                    }
                    synchronized (this) {
                        if (n.this.jlg || !this.jkV.containsKey(address)) {
                            this.jkV.put(address, jSONObject);
                            int optInt = n.this.jlh.optInt("interval");
                            JSONArray jSONArray2 = new JSONArray();
                            jSONArray2.put(jSONObject);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("devices", jSONArray2);
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e2, "", new Object[0]);
                            }
                            if (optInt > 0) {
                                if (this.jlj.cgx()) {
                                    long j = (long) optInt;
                                    this.jlj.K(j, j);
                                    x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "start timer interval %s", Integer.valueOf(optInt));
                                }
                            } else if (b.jkS) {
                                f aA = cVar.aA(this.jli.mAppId, this.jli.hashCode());
                                aA.mData = jSONObject2.toString();
                                aA.afI();
                            } else {
                                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetooth is not init,return...");
                            }
                        } else {
                            this.jkV.put(address, jSONObject);
                            x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "DuplicatesKey,deviceId : " + address);
                        }
                    }
                }
            }
        }

        private JSONObject S(byte[] bArr) {
            JSONObject jSONObject = new JSONObject();
            if (bArr == null) {
                return jSONObject;
            }
            int i = 0;
            while (i < bArr.length) {
                int i2 = i + 1;
                i = bArr[i] & 255;
                if (i == 0) {
                    return jSONObject;
                }
                int i3 = i - 1;
                int i4 = i2 + 1;
                switch (bArr[i2] & 255) {
                    case 22:
                        try {
                            x.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[parseServiceDataFromBytes]uuid:%s, data:%s", U(n(bArr, i4, 2)).getUuid().toString().toUpperCase(), new String(Base64.encode(n(bArr, i4 + 2, i3 - 2), 2)));
                            jSONObject.put(r0, r3);
                            break;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e, "", new Object[0]);
                            break;
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e2, "", new Object[0]);
                            break;
                        }
                    default:
                        break;
                }
                i = i4 + i3;
            }
            return jSONObject;
        }

        private static String T(byte[] bArr) {
            if (bArr == null) {
                return "";
            }
            String str = "";
            int i = 0;
            while (i < bArr.length) {
                int i2 = i + 1;
                i = bArr[i] & 255;
                if (i == 0) {
                    return str;
                }
                i--;
                int i3 = i2 + 1;
                switch (bArr[i2] & 255) {
                    case 8:
                    case 9:
                        str = new String(n(bArr, i3, i));
                        break;
                    default:
                        break;
                }
                i += i3;
            }
            return str;
        }

        private byte[] a(byte[] bArr, List<ParcelUuid> list) {
            byte[] bArr2 = null;
            if (bArr != null) {
                int i = 0;
                while (i < bArr.length) {
                    int i2 = i + 1;
                    i = bArr[i] & 255;
                    if (i != 0) {
                        byte[] bArr3;
                        int i3 = i - 1;
                        int i4 = i2 + 1;
                        switch (bArr[i2] & 255) {
                            case 2:
                            case 3:
                                a(bArr, i4, i3, 2, list);
                                bArr3 = bArr2;
                                break;
                            case 4:
                            case 5:
                                a(bArr, i4, i3, 4, list);
                                bArr3 = bArr2;
                                break;
                            case 6:
                            case 7:
                                a(bArr, i4, i3, 16, list);
                                bArr3 = bArr2;
                                break;
                            case 8:
                            case 9:
                                bArr3 = bArr2;
                                break;
                            case 255:
                                bArr3 = n(bArr, i4, i3);
                                break;
                            default:
                                bArr3 = bArr2;
                                break;
                        }
                        bArr2 = bArr3;
                        i = i4 + i3;
                    }
                }
            }
            return bArr2;
        }

        private static byte[] n(byte[] bArr, int i, int i2) {
            Object obj = new byte[i2];
            System.arraycopy(bArr, i, obj, 0, i2);
            return obj;
        }

        private int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
            while (i2 > 0) {
                list.add(U(n(bArr, i, i3)));
                i2 -= i3;
                i += i3;
            }
            return i;
        }

        private ParcelUuid U(byte[] bArr) {
            if (bArr == null) {
                throw new IllegalArgumentException("uuidBytes cannot be null");
            }
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + length);
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                long j;
                if (length == 2) {
                    j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
                } else {
                    j = ((((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8))) + ((long) ((bArr[2] & 255) << 16))) + ((long) ((bArr[3] & 255) << 24));
                }
                return new ParcelUuid(new UUID(this.jlk.getUuid().getMostSignificantBits() + (j << 32), this.jlk.getUuid().getLeastSignificantBits()));
            }
        }
    }

    private static class c extends f {
        private static final int CTRL_INDEX = 190;
        private static final String NAME = "onBluetoothDeviceFound";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private static class b extends f {
        private static final int CTRL_INDEX = 189;
        private static final String NAME = "onBluetoothAdapterStateChange";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        a.kv(11);
        if (jSONObject != null) {
            x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data %s", jSONObject.toString());
        }
        this.jlh = jSONObject;
        Map hashMap = new HashMap();
        if (com.tencent.mm.compatible.util.f.fO(18)) {
            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "API version is below 18!");
            hashMap.put("errCode", Integer.valueOf(10009));
            jVar.E(i, e("fail", hashMap));
            a.bG(13, 15);
        } else if (b.jkS) {
            BluetoothManager bluetoothManager = (BluetoothManager) jVar.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothManager is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(13, 17);
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            if (adapter == null || !adapter.isEnabled()) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothAdapter is null!");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10001));
                jVar.E(i, e("fail", hashMap));
                a.bG(13, 19);
                return;
            }
            if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                LocationManager locationManager = (LocationManager) ad.getContext().getSystemService("location");
                if (locationManager != null) {
                    boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                    x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable" + locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER));
                }
            }
            com.tencent.mm.y.u.b g = b.g(jVar);
            LeScanCallback leScanCallback = (a) g.get("key_bluetooth_le_scaner", null);
            if (leScanCallback == null) {
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetoothLEScaner is null!");
                leScanCallback = new a(jVar);
                g.o("key_bluetooth_le_scaner", leScanCallback);
            }
            if (adapter.isEnabled()) {
                boolean startLeScan;
                UUID[] uuidArr = null;
                if (this.jlh.has("services")) {
                    List arrayList = new ArrayList();
                    try {
                        JSONArray jSONArray = new JSONArray(this.jlh.optString("services"));
                        uuidArr = new UUID[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String toUpperCase = jSONArray.getString(i2).toUpperCase();
                            arrayList.add(toUpperCase);
                            x.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "servicesUuid %s", toUpperCase);
                            uuidArr[i2] = UUID.fromString(toUpperCase);
                        }
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
                        hashMap.put("isDiscovering", Boolean.valueOf(false));
                        hashMap.put("errCode", Integer.valueOf(10004));
                        jVar.E(i, e("fail", hashMap));
                        return;
                    }
                }
                if (uuidArr == null || uuidArr.length <= 0) {
                    startLeScan = adapter.startLeScan(leScanCallback);
                } else {
                    startLeScan = adapter.startLeScan(uuidArr, leScanCallback);
                }
                if (startLeScan) {
                    hashMap.put("isDiscovering", Boolean.valueOf(true));
                    hashMap.put("errCode", Integer.valueOf(0));
                    jVar.E(i, e("ok", hashMap));
                    b bVar = new b();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("available", true);
                        jSONObject2.put("discovering", true);
                    } catch (JSONException e2) {
                        x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", e2);
                    }
                    x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChange %s", jSONObject2.toString());
                    f aA = bVar.aA(jVar.mAppId, jVar.hashCode());
                    aA.mData = jSONObject2.toString();
                    aA.afI();
                    a.kw(12);
                    return;
                }
                x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startLeScan fail...");
                hashMap.put("isDiscovering", Boolean.valueOf(false));
                hashMap.put("errCode", Integer.valueOf(10008));
                jVar.E(i, e("fail", hashMap));
                a.bG(13, 20);
                return;
            }
            hashMap.put("isDiscovering", Boolean.valueOf(false));
            hashMap.put("errCode", Integer.valueOf(10001));
            jVar.E(i, e("fail", hashMap));
            a.bG(13, 18);
        } else {
            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetooth is not init!");
            hashMap.put("errCode", Integer.valueOf(10000));
            jVar.E(i, e("fail", hashMap));
            a.bG(13, 16);
        }
    }
}
