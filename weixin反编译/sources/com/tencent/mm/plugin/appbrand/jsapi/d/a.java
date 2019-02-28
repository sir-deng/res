package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static BroadcastReceiver jmY;
    public static boolean jmZ;
    public static Map<String, a> map = new ConcurrentHashMap();

    public static class a {
        volatile boolean fBn = false;
        BluetoothAdapter jna;
        Map<String, JSONObject> jnb = new HashMap();
        UUID[] jnc = null;
        a jnd;
        LeScanCallback jne = new LeScanCallback() {
            public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (bi.by(bArr)) {
                    x.e("MicroMsg.BeaconManager", "valueByte is null or nil");
                    return;
                }
                int i2;
                int i3 = 2;
                Object obj = null;
                while (true) {
                    i2 = i3;
                    if (i2 <= 5) {
                        if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                            obj = 1;
                            break;
                        }
                        i3 = i2 + 1;
                    } else {
                        break;
                    }
                }
                if (obj != null) {
                    int i4;
                    Object obj2 = new byte[16];
                    System.arraycopy(bArr, i2 + 4, obj2, 0, 16);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i5 = 0; i5 < 16; i5++) {
                        i4 = obj2[i5] & 255;
                        if (i4 < 16) {
                            stringBuilder.append("0");
                        }
                        stringBuilder.append(Integer.toHexString(i4));
                    }
                    String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
                    if (bi.oN(toUpperCase)) {
                        x.e("MicroMsg.BeaconManager", "hexString is null, err");
                        return;
                    }
                    int i6;
                    UUID fromString = UUID.fromString(toUpperCase.substring(0, 8) + "-" + toUpperCase.substring(8, 12) + "-" + toUpperCase.substring(12, 16) + "-" + toUpperCase.substring(16, 20) + "-" + toUpperCase.substring(20, 32));
                    obj = null;
                    for (UUID equals : a.this.jnc) {
                        if (equals.equals(fromString)) {
                            obj = 1;
                            break;
                        }
                    }
                    if (obj != null) {
                        double d;
                        i4 = ((bArr[i2 + 20] & 255) * 256) + (bArr[i2 + 21] & 255);
                        i6 = ((bArr[i2 + 22] & 255) * 256) + (bArr[i2 + 23] & 255);
                        byte b = bArr[i2 + 24];
                        double d2 = (double) i;
                        if (d2 == 0.0d) {
                            d = -1.0d;
                        } else {
                            d = (d2 * 1.0d) / ((double) b);
                            d = d < 1.0d ? Math.pow(d, 10.0d) : (Math.pow(d, 9.9476d) * 0.92093d) + 0.54992d;
                        }
                        String address = bluetoothDevice.getAddress();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("uuid", fromString);
                            jSONObject.put("major", i4);
                            jSONObject.put("minor", i6);
                            jSONObject.put("proximity", 0);
                            jSONObject.put("accuracy", d);
                            jSONObject.put("rssi", i);
                            a.this.jnb.put(address, jSONObject);
                            x.d("MicroMsg.BeaconManager", "found device ibeacon %s", jSONObject);
                        } catch (JSONException e) {
                            x.e("MicroMsg.BeaconManager", "put JSON data error : %s", e);
                        }
                        if (a.this.jnd != null) {
                            a.this.jnd.x(a.this.jnb);
                        }
                    }
                }
            }
        };

        public interface a {
            void cM(boolean z);

            void x(Map<String, JSONObject> map);
        }

        public a() {
            BluetoothManager bluetoothManager = (BluetoothManager) ad.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                x.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
                return;
            }
            this.jna = bluetoothManager.getAdapter();
            if (this.jna == null) {
                x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            } else {
                a.jmZ = this.jna.isEnabled();
            }
        }

        final synchronized boolean agz() {
            return this.fBn;
        }

        public final boolean vp() {
            x.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", Integer.valueOf(hashCode()));
            if (agz()) {
                this.jnb.clear();
                this.jna.stopLeScan(this.jne);
                this.fBn = false;
                return true;
            }
            x.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", Integer.valueOf(hashCode()));
            return false;
        }
    }

    public static void a(String str, a aVar) {
        map.put(str, aVar);
        if (jmY == null) {
            x.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
            jmY = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    boolean z = true;
                    if (intent == null) {
                        x.i("MicroMsg.BeaconManager", "Receive intent failed");
                        return;
                    }
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        int state = defaultAdapter.getState();
                        x.d("MicroMsg.BeaconManager", "state:%d", Integer.valueOf(state));
                        if (!(state == 12 || state == 11)) {
                            z = (state == 10 || state == 13) ? false : false;
                        }
                        if ((a.jmZ && !z) || (!a.jmZ && z)) {
                            for (a aVar : a.map.values()) {
                                if (aVar.agz() && !z) {
                                    aVar.vp();
                                }
                                if (aVar.jnd != null) {
                                    aVar.jnd.cM(z);
                                }
                            }
                        }
                        a.jmZ = z;
                    }
                }
            };
            ad.getContext().registerReceiver(jmY, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public static a sK(String str) {
        return (a) map.get(str);
    }

    public static void remove(String str) {
        map.remove(str);
        x.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", str);
        if (map.size() == 0 && jmY != null) {
            x.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
            ad.getContext().unregisterReceiver(jmY);
            jmY = null;
        }
    }
}
