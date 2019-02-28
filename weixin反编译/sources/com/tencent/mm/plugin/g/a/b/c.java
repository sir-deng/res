package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c implements LeScanCallback {
    private static c kCK;
    private BluetoothAdapter kBQ;
    private ArrayList<a> kCL;
    private boolean kCM;
    private Context mContext;
    private ag mHandler;

    public interface a {
        void arS();

        void c(BluetoothDevice bluetoothDevice, int i, byte[] bArr);
    }

    static /* synthetic */ boolean a(c cVar, boolean z, a aVar) {
        boolean z2;
        if (cVar.mContext == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "not found context");
            z2 = false;
        } else {
            z2 = cVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (!z2) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "this phone is not support BLE");
            return false;
        } else if (cVar.kBQ == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "not found BluetoothAdapter");
            return false;
        } else {
            if (z) {
                if (cVar.kCM) {
                    x.w("MicroMsg.exdevice.BluetoothLEScaner", "ble has scan. just add callback and return");
                    cVar.a(aVar);
                    return true;
                }
                x.d("MicroMsg.exdevice.BluetoothLEScaner", "start scan");
                z2 = cVar.kBQ.startLeScan(cVar);
                if (z2) {
                    cVar.kCM = true;
                    cVar.a(aVar);
                } else if (cVar.kCL.size() <= 0) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed and callbacklist size is 0,start retry,and bluetooth state is(12 is on ,10 is off): " + cVar.kBQ.getState());
                    int i = 0;
                    while (!z2 && i < 3) {
                        cVar.kBQ.stopLeScan(cVar);
                        cVar.kCM = false;
                        x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed,retry no " + i + " time");
                        boolean startLeScan = cVar.kBQ.startLeScan(cVar);
                        if (startLeScan) {
                            cVar.kCM = true;
                            cVar.a(aVar);
                        }
                        i++;
                        z2 = startLeScan;
                    }
                    return z2;
                } else if (cVar.kBQ.getState() == 12) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed when bluetooth state is on.");
                    cVar.kCM = true;
                    cVar.a(aVar);
                    z2 = true;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed");
                }
            } else if (cVar.kCM) {
                if (aVar == null) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
                } else {
                    x.d("MicroMsg.exdevice.BluetoothLEScaner", "remove callback " + cVar.kCL.remove(aVar));
                }
                if (aVar != null) {
                    aVar.arS();
                }
                x.d("MicroMsg.exdevice.BluetoothLEScaner", "stop deleteCallback");
                if (cVar.kCL.size() <= 0) {
                    x.d("MicroMsg.exdevice.BluetoothLEScaner", "stop scan");
                    cVar.kBQ.stopLeScan(cVar);
                    cVar.kCM = false;
                }
                z2 = true;
            } else {
                x.w("MicroMsg.exdevice.BluetoothLEScaner", "scan haven't started. just return, callback size = %d", Integer.valueOf(cVar.kCL.size()));
                return true;
            }
            return z2;
        }
    }

    public static c arT() {
        if (kCK != null) {
            return kCK;
        }
        c cVar = new c(ad.getContext());
        kCK = cVar;
        return cVar;
    }

    private c(Context context) {
        if (context == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
            return;
        }
        this.mContext = context;
        this.kCL = new ArrayList();
        this.kCM = false;
        this.kBQ = null;
        this.mHandler = null;
        this.kBQ = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
        this.mHandler = new ag(new ah("BluetoothLEScanerThread").oFY.getLooper());
    }

    public final boolean a(final boolean z, final a aVar) {
        Boolean bool = (Boolean) new bd<Boolean>() {
            protected final /* synthetic */ Object run() {
                return Boolean.valueOf(c.a(c.this, z, aVar));
            }
        }.b(this.mHandler);
        Assert.assertTrue(bool != null);
        return bool.booleanValue();
    }

    private boolean a(a aVar) {
        boolean z = false;
        if (aVar == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
            return false;
        }
        int i;
        while (true) {
            i = z;
            if (i >= this.kCL.size()) {
                i = -1;
                break;
            } else if (((a) this.kCL.get(i)) == aVar) {
                break;
            } else {
                z = i + 1;
            }
        }
        if (i < 0) {
            z = this.kCL.add(aVar);
            x.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback " + z);
            return z;
        }
        x.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
        return true;
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", bluetoothDevice.getAddress(), bluetoothDevice.getName(), b.ar(bArr));
        x.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", Integer.valueOf(this.kCL.size()));
        this.mHandler.post(new Runnable() {
            public final void run() {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < c.this.kCL.size()) {
                        ((a) c.this.kCL.get(i2)).c(bluetoothDevice, i, bArr);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }
}
