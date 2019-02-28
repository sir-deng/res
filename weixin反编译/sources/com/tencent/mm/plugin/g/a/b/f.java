package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.g.a.b.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class f {
    static int kDy = 0;
    private int aen;
    private BluetoothAdapter kBQ;
    public BluetoothDevice kCP;
    private Context kCQ;
    private BluetoothGatt kCR;
    private a kCV;
    private Runnable kCW;
    private Runnable kCY;
    private final LinkedList<byte[]> kDa;
    private volatile boolean kDb;
    private volatile int kDc;
    private final BluetoothGattCallback kDd;
    private a kDr;
    private Runnable kDs;
    private f kDt;
    private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> kDu;
    private long kDv;
    private ArrayList<BluetoothGattCharacteristic> kDw;
    private boolean kDx;
    public ag mHandler;
    public long mSessionId;
    private HandlerThread mThread;

    public static abstract class a {
        public void a(long j, boolean z, long j2) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void h(long j, boolean z) {
        }
    }

    private static class b extends ag {
        private final WeakReference<f> kDf;

        public b(Looper looper, f fVar) {
            super(looper);
            this.kDf = new WeakReference(fVar);
        }

        public final void handleMessage(Message message) {
            f fVar = (f) this.kDf.get();
            if (fVar == null) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
                return;
            }
            switch (message.what) {
                case 0:
                    f.a(fVar);
                    return;
                case 1:
                    f.b(fVar);
                    return;
                case 2:
                    f.c(fVar);
                    return;
                case 3:
                    f.a(fVar, (byte[]) message.obj);
                    return;
                case 4:
                    f.a(fVar, message.arg1);
                    return;
                case 5:
                    if (!f.a(fVar, (BluetoothGatt) message.obj, message.arg1)) {
                        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
                        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(1))) {
                            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(1));
                            return;
                        }
                        return;
                    }
                    return;
                case 6:
                    Object obj = message.obj;
                    f.b(fVar, message.arg1);
                    return;
                case 7:
                    f.c(fVar, message.arg1);
                    return;
                case 8:
                    f.a(fVar, (BluetoothGattCharacteristic) message.obj);
                    return;
                case 9:
                    f.d(fVar);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connectImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
        if (1 == fVar.kDc) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connected !!!");
            if (fVar.kDr != null) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device has connected, just callback.");
                fVar.kDr.a(fVar.mSessionId, true, fVar.kDv);
            }
        } else if (fVar.kDc == 0) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connecting !!!");
        } else {
            fVar.arU();
            if (fVar.kCR == null) {
                fVar.kCR = fVar.kCP.connectGatt(fVar.kCQ, false, fVar.kDd);
                kDy++;
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------create resource------, objid=%d, resourceCount=%d, mac=%s, name=%s", Integer.valueOf(fVar.hashCode()), Integer.valueOf(kDy), com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
                if (fVar.kCR == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mDevice.connectGatt Failed!!!");
                    fVar.arX();
                    return;
                }
                fVar.kDc = 0;
                fVar.mHandler.postDelayed(fVar.kCY, 10000);
            } else if (fVar.kCR.connect()) {
                fVar.kDc = 0;
                fVar.mHandler.postDelayed(fVar.kCY, 10000);
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.connect() Failed!!!");
                fVar.arX();
            }
        }
    }

    static /* synthetic */ void a(f fVar, int i) {
        String str = "MicroMsg.exdevice.BluetoothLESimpleSession";
        String str2 = "------onConnectionStateChangeImp------ aState = %s, mac=%s, name=%s";
        Object[] objArr = new Object[3];
        objArr[0] = i == 2 ? "Connected" : "Disconnected";
        objArr[1] = com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId);
        objArr[2] = fVar.kCP.getName();
        x.i(str, str2, objArr);
        if (i == 2) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "PHY Connected is OK, mConnectState = %d", Integer.valueOf(fVar.kDc));
            if (3 == fVar.kDc) {
                x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Leave without discover Services");
                fVar.mHandler.removeCallbacks(fVar.kCY);
            } else if (1 == fVar.kDc) {
                x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Leave without discover Services");
                fVar.mHandler.removeCallbacks(fVar.kCY);
            } else if (fVar.kCR.discoverServices()) {
                fVar.mHandler.removeCallbacks(fVar.kCY);
                fVar.mHandler.postDelayed(fVar.kCY, 10000);
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "start discoverServices...");
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "discover Services start failed!!!");
                fVar.arW();
            }
        } else if (i == 0) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Disconnected from GATT server.");
            fVar.kDu.clear();
            fVar.kDw.clear();
            fVar.kDv = 0;
            fVar.arW();
        }
    }

    static /* synthetic */ void a(f fVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceiveImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
        if (bluetoothGattCharacteristic == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic is null");
            return;
        }
        byte[] value = bluetoothGattCharacteristic.getValue();
        String L = com.tencent.mm.plugin.exdevice.j.b.L(value, value.length);
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "data length = %d", Integer.valueOf(value.length));
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "data dump = %s", L);
        value = c.a(bluetoothGattCharacteristic, value);
        if (value == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse data error");
        } else if (fVar.kDr != null) {
            fVar.kDr.b(fVar.mSessionId, value);
        }
    }

    static /* synthetic */ void a(f fVar, byte[] bArr) {
        boolean z = true;
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeDataAsync------parserobj length = %d, mac=%s, name=%s", Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
        if (1 != fVar.kDc) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Not ready for write data, connectstate = %d", Integer.valueOf(fVar.kDc));
            if (fVar.kDr != null) {
                fVar.kDr.h(fVar.mSessionId, false);
                return;
            }
            return;
        }
        com.tencent.mm.plugin.g.a.b.a.a af = com.tencent.mm.plugin.g.a.b.a.a.af(bArr);
        if (af == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error, no match ProfileParser, connect state = %d", Integer.valueOf(fVar.kDc));
            if (fVar.kDr != null) {
                fVar.kDr.h(fVar.mSessionId, false);
                return;
            }
            return;
        }
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "rawData data dump = %s", com.tencent.mm.plugin.exdevice.j.b.ar(af.arZ()));
        String str = af.kEc;
        int i = af.kEd;
        HashMap hashMap = (HashMap) fVar.kDu.get(c.bL(af.kDv));
        String str2;
        if (hashMap == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found", str2);
            if (fVar.kDr != null) {
                fVar.kDr.h(fVar.mSessionId, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        String str3;
        if (bluetoothGattCharacteristic == null) {
            str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            str2 = "characteristic(%s) not found";
            Object[] objArr = new Object[1];
            objArr[0] = str == null ? "null" : str;
            x.e(str3, str2, objArr);
            if (fVar.kDr != null) {
                fVar.kDr.h(fVar.mSessionId, false);
            }
        } else if ((bluetoothGattCharacteristic.getProperties() | i) == 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "property not support. current = %d, provided = %d", Integer.valueOf(bluetoothGattCharacteristic.getProperties()), Integer.valueOf(i));
            if (fVar.kDr != null) {
                fVar.kDr.h(fVar.mSessionId, false);
            }
        } else if (i == 2) {
            boolean z2;
            if (bluetoothGattCharacteristic == null) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic not found");
                z2 = false;
            } else if (fVar.kCR.readCharacteristic(bluetoothGattCharacteristic)) {
                z2 = true;
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.readCharacteristic Failed!!!");
                z2 = false;
            }
            str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            str2 = "readCharacteristic state: %s";
            Object[] objArr2 = new Object[1];
            objArr2[0] = z2 ? "true" : "false";
            x.d(str3, str2, objArr2);
            if (fVar.kDr == null) {
                return;
            }
            if (z2) {
                fVar.kDr.h(fVar.mSessionId, true);
            } else {
                fVar.kDr.h(fVar.mSessionId, false);
            }
        } else {
            Assert.assertTrue(fVar.kCR != null);
            fVar.kDa.add(bArr);
            if (!fVar.kDb) {
                if (1 != fVar.kDa.size()) {
                    z = false;
                }
                Assert.assertTrue(z);
                fVar.arV();
            }
        }
    }

    static /* synthetic */ boolean a(f fVar, BluetoothGatt bluetoothGatt, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "onServicesDiscoveredImp, status = %d, mac=%s, name=%s", Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
        fVar.mHandler.removeCallbacks(fVar.kCY);
        if (3 == fVar.kDc) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Just Leave");
            return false;
        }
        if (1 == fVar.kDc) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Just Leave");
        } else if (i != 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Discover services error");
            fVar.arW();
            return false;
        } else {
            List services = bluetoothGatt.getServices();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= services.size()) {
                    break;
                }
                Object obj;
                BluetoothGattService bluetoothGattService = (BluetoothGattService) services.get(i3);
                if (bluetoothGattService == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service is null");
                    obj = null;
                } else if (c.b(bluetoothGattService)) {
                    fVar.kDv |= c.a(bluetoothGattService);
                    HashMap hashMap = new HashMap();
                    List characteristics = bluetoothGattService.getCharacteristics();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= characteristics.size()) {
                            break;
                        }
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristics.get(i5);
                        Object uuid = bluetoothGattCharacteristic.getUuid().toString();
                        int properties = bluetoothGattCharacteristic.getProperties();
                        int permissions = bluetoothGattCharacteristic.getPermissions();
                        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "found characteristic = %s, properties = %d, permission = %d", uuid, Integer.valueOf(properties), Integer.valueOf(permissions));
                        if (uuid == null) {
                            uuid = "null";
                        }
                        hashMap.put(uuid, bluetoothGattCharacteristic);
                        fVar.kDw.add(bluetoothGattCharacteristic);
                        i4 = i5 + 1;
                    }
                    fVar.kDu.put(bluetoothGattService.getUuid().toString(), hashMap);
                    obj = 1;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse service error");
                    obj = null;
                }
                if (obj == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parseService error. service uuid = %s", bluetoothGattService.getUuid().toString());
                }
                i2 = i3 + 1;
            }
            if (0 == fVar.kDv) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "the device hasn't pass test");
                fVar.arW();
                return false;
            } else if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(9));
            }
        }
        return true;
    }

    static /* synthetic */ void b(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnectImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
        if (3 == fVar.kDc) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "diconnect or close is called aready, just leave");
        } else if (2 == fVar.kDc) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "already disconnected, just leave");
        } else {
            fVar.arU();
            if (fVar.kCR == null) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect:BluetoothGatt not found");
                return;
            }
            fVar.kDc = 3;
            fVar.mHandler.removeCallbacks(fVar.kCY);
            if (fVar.kCR != null) {
                fVar.kCR.disconnect();
            }
        }
    }

    static /* synthetic */ void b(f fVar, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWriteImp------ status = %d, mac=%s, name=%s", Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(9));
        }
    }

    static /* synthetic */ void c(f fVar) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------closeImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
        if (3 == fVar.kDc) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close aready, Just leave");
            fVar.arX();
            return;
        }
        fVar.arU();
        if (fVar.kCR == null) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "close:BluetoothGatt not found");
            fVar.arX();
            return;
        }
        fVar.kDc = 3;
        fVar.mHandler.removeCallbacks(fVar.kCY);
        fVar.arX();
        if (fVar.kCR != null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect gatt, and wait gatt disconnected callback, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
            fVar.kCR.disconnect();
            fVar.kDx = true;
            fVar.mHandler.postDelayed(fVar.kDs, 10000);
        }
    }

    static /* synthetic */ void c(f fVar, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallbackImp------ status = %d, mac=%s, name=%s", Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
        fVar.mHandler.removeCallbacks(fVar.kCW);
        if (i != 0) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error: " + i);
            if (fVar.kDr != null) {
                fVar.kDr.h(fVar.mSessionId, false);
            }
            fVar.arV();
            return;
        }
        byte[] arP = fVar.kCV.arP();
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "Out data dump = %s", com.tencent.mm.plugin.exdevice.j.b.ar(arP));
        if (arP == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write data complete");
            if (fVar.kDr != null) {
                fVar.kDr.h(fVar.mSessionId, true);
            }
            fVar.arV();
            return;
        }
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write next chunk...");
        fVar.kCV.kCv.setValue(arP);
        fVar.kCR.writeCharacteristic(fVar.kCV.kCv);
        fVar.mHandler.postDelayed(fVar.kCW, 5000);
    }

    static /* synthetic */ void d(f fVar) {
        while (fVar.kDw.size() > 0) {
            int i;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) fVar.kDw.remove(0);
            f fVar2 = fVar.kDt;
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 48) == 0) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "no indicate and notify");
                i = 0;
            } else if (fVar2.kCR.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.kDG));
                if (descriptor == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not get configure descriptor");
                    i = 0;
                } else {
                    x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Configure descriptor permissions: " + descriptor.getPermissions());
                    byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                    if ((properties & 32) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1]);
                    }
                    if ((properties & 16) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[1]);
                    }
                    if (!descriptor.setValue(bArr)) {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not set configure descriptor value");
                        i = 0;
                    } else if (fVar2.kCR.writeDescriptor(descriptor)) {
                        boolean i2 = true;
                    } else {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not write configure descriptor value");
                        i2 = 0;
                    }
                }
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Unable to set indicator for read characteristic");
                i2 = 0;
            }
            if (i2 == 0) {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mSelfSession.setCharacteristicNotification Failed!!!. uuid = %s, properties = %d", bluetoothGattCharacteristic.getUuid().toString(), Integer.valueOf(bluetoothGattCharacteristic.getProperties()));
            } else {
                return;
            }
        }
        x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "onConnected = true");
        fVar.kDc = 1;
        fVar.mHandler.removeCallbacks(fVar.kCY);
        if (fVar.kDr != null) {
            fVar.kDr.a(fVar.mSessionId, true, fVar.kDv);
        }
    }

    final void arW() {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
        this.kDc = 2;
        this.mHandler.removeCallbacks(this.kCY);
        this.mHandler.removeCallbacks(this.kDs);
        arX();
        releaseResources();
    }

    @TargetApi(18)
    public f(long j, Context context, a aVar) {
        this.kDa = new LinkedList();
        this.kDb = false;
        this.kDu = new HashMap();
        this.kDv = 0;
        this.kDw = new ArrayList();
        this.kDd = new BluetoothGattCallback() {
            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(f.this.kDc));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(4, i2, 0))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(4));
                }
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", Integer.valueOf(i));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(5));
                }
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", Integer.valueOf(i));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(6));
                }
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
                }
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", Integer.valueOf(i));
                if (i == 0 && !f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
                }
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", Integer.valueOf(i));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(7, i, 0))) {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(7));
                }
            }
        };
        this.aen = -1;
        this.aen = hashCode();
        this.kDt = this;
        this.kDr = aVar;
        this.kCQ = context;
        this.kBQ = ((BluetoothManager) this.kCQ.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.kDc = 3;
        this.kCP = this.kBQ.getRemoteDevice(com.tencent.mm.plugin.g.a.e.a.bN(j));
        this.kCV = new a();
        this.kDx = false;
        this.mThread = e.WL("BluetoothLESimpleSession_handlerThread");
        this.mThread.start();
        this.mHandler = new b(this.mThread.getLooper(), this);
        this.kCW = new Runnable() {
            public final void run() {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(f.this.mSessionId), f.this.kCP.getName());
                if (f.this.kDr != null) {
                    f.this.kDr.h(f.this.mSessionId, false);
                }
                f.this.arV();
            }
        };
        this.kCY = new Runnable() {
            public final void run() {
                x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(f.this.mSessionId), f.this.kCP.getName());
                if (3 == f.this.kDc) {
                    x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
                } else if (f.this.kDc == 1) {
                    x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
                } else {
                    f.this.arW();
                }
            }
        };
        this.kDs = new Runnable() {
            public final void run() {
                if (f.this.kDx) {
                    if (f.this.kDr != null) {
                        f.this.kDr.a(f.this.mSessionId, false, f.this.kDv);
                    }
                    x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
                    f.this.releaseResources();
                }
            }
        };
    }

    private void releaseResources() {
        if (this.kCR == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", Integer.valueOf(hashCode()), com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
            return;
        }
        kDy--;
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", Integer.valueOf(hashCode()), Integer.valueOf(kDy), com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
        this.kDx = false;
        this.kCR.close();
        this.mThread.quitSafely();
        this.kCR = null;
        this.mThread = null;
    }

    public final boolean connect() {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    private void arU() {
        this.kDb = false;
        this.kDa.clear();
    }

    private void arX() {
        if (this.kDr == null) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
            return;
        }
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
        if (this.kDr != null) {
            this.kDr.a(this.mSessionId, false, this.kDv);
        }
        this.kDr = null;
    }

    private void arV() {
        if (this.kDa.isEmpty()) {
            this.kDb = false;
            return;
        }
        com.tencent.mm.plugin.g.a.b.a.a af = com.tencent.mm.plugin.g.a.b.a.a.af((byte[]) this.kDa.pop());
        byte[] arZ = af.arZ();
        String str = af.kEc;
        int i = af.kEd;
        HashMap hashMap = (HashMap) this.kDu.get(c.bL(af.kDv));
        if (hashMap == null) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", r4, com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
            if (this.kDr != null) {
                this.kDr.h(this.mSessionId, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        if (bluetoothGattCharacteristic == null) {
            String str2;
            String str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            String str4 = "characteristic(%s) not found, mac=%s, name=%s";
            Object[] objArr = new Object[3];
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            objArr[0] = str2;
            objArr[1] = com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId);
            objArr[2] = this.kCP.getName();
            x.e(str3, str4, objArr);
            if (this.kDr != null) {
                this.kDr.h(this.mSessionId, false);
            }
        } else if (i == 8) {
            this.kCV.kCv = bluetoothGattCharacteristic;
            this.kCV.setData(arZ);
            x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.ar(this.kCV.arP()), str, com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
            bluetoothGattCharacteristic.setValue(arZ);
            this.mHandler.postDelayed(this.kCW, 5000);
            if (this.kCR.writeCharacteristic(bluetoothGattCharacteristic)) {
                this.kDb = true;
                return;
            }
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
            if (this.kDr != null) {
                this.kDr.h(this.mSessionId, false);
            }
        } else {
            x.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.cL(this.mSessionId), this.kCP.getName());
            if (this.kDr != null) {
                this.kDr.h(this.mSessionId, false);
            }
        }
    }
}
