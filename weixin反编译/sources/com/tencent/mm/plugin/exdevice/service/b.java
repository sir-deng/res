package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.g.a.b.d;
import com.tencent.mm.plugin.g.a.c.a;
import com.tencent.mm.plugin.g.a.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b implements c {
    private static b lVD = null;
    private final Vector<r> lVA = new Vector();
    private final HashMap<Long, Integer> lVB = new HashMap();
    private final HashMap<Long, Integer> lVC = new HashMap();
    private CountDownLatch lVE;
    private com.tencent.mm.plugin.g.a.d.b lVz = null;
    private ag mHandler = new ag(v.aFu().hPO.oFY.getLooper());

    static /* synthetic */ void a(b bVar, long j, long j2) {
        boolean z = false;
        if (bVar.lVB.containsKey(Long.valueOf(j))) {
            bVar.lVz.b(j, j2, ((Integer) bVar.lVB.get(Long.valueOf(j))).intValue());
            return;
        }
        int intValue;
        v aFu = v.aFu();
        if (aFu.lWc.containsKey(Long.valueOf(j))) {
            intValue = ((Integer) aFu.lWc.get(Long.valueOf(j))).intValue();
        } else {
            x.e("MicroMsg.exdevice.MMExDevicePushCore", "getBluetoothVersionByDeviceId Failed!!! Cannot find BLuetoothVersion by DeviceId(%d)", Long.valueOf(j));
            intValue = -1;
        }
        Assert.assertTrue(-1 != intValue);
        String cL = com.tencent.mm.plugin.exdevice.j.b.cL(j);
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "insertDeviceIdTypeMap deviceid = %s, BTVersion = %d", cL, Integer.valueOf(intValue));
        Assert.assertNotNull(cL);
        if (1 == intValue || intValue == 0) {
            z = true;
        }
        Assert.assertTrue(z);
        long Aa = com.tencent.mm.plugin.exdevice.j.b.Aa(cL);
        if (!bVar.lVB.containsKey(Long.valueOf(Aa))) {
            bVar.lVB.put(Long.valueOf(Aa), Integer.valueOf(intValue));
        }
        bVar.lVz.b(j, j2, intValue);
    }

    static /* synthetic */ boolean a(b bVar, int i) {
        boolean a;
        com.tencent.mm.plugin.g.a.d.b bVar2 = bVar.lVz;
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***stopScan*** aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (bVar2.kFX != null) {
                    a = bVar2.kFX.a(false, new int[0]);
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                a = false;
                break;
            case 1:
                if (bVar2.kFY != null) {
                    a = bVar2.kFY.dW(false);
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                a = false;
                break;
            default:
                Assert.assertTrue(false);
                a = false;
                break;
        }
        if (a) {
            return true;
        }
        x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.stopScan failed!!!");
        return false;
    }

    static /* synthetic */ boolean a(b bVar, int i, r rVar, int[] iArr) {
        if (rVar == null) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            throw new IllegalArgumentException("scanImp: null == aCallback");
        }
        if (iArr == null ? bVar.lVz.a(i, new int[0]) : bVar.lVz.a(i, iArr)) {
            bVar.lVA.add(rVar);
            return true;
        }
        x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.scan failed!!!");
        if (rVar == null) {
            return false;
        }
        rVar.ws("scanImp: mBTSDKMrg.scan failed!!!");
        return false;
    }

    static /* synthetic */ boolean a(b bVar, long j) {
        boolean z = true;
        Assert.assertTrue(bVar.lVC.containsKey(Long.valueOf(j)));
        com.tencent.mm.plugin.g.a.d.b bVar2 = bVar.lVz;
        int intValue = ((Integer) bVar.lVC.get(Long.valueOf(j))).intValue();
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***connect*** aSessionId = " + j + " aBluetoothVersion = " + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.kFX != null) {
                    z = bVar2.kFX.connect(j);
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                z = false;
                break;
            case 1:
                if (bVar2.kFY != null) {
                    a aVar = bVar2.kFY;
                    x.i("MicroMsg.exdevice.BluetoothChatManager", "connect, session id = %d, secure = %s", Long.valueOf(j), "true");
                    Assert.assertTrue(aVar.mIsInit);
                    if (!aVar.asa()) {
                        x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                        z = false;
                        break;
                    }
                    com.tencent.mm.plugin.g.a.c.b bVar3 = (com.tencent.mm.plugin.g.a.c.b) aVar.kCx.get(Long.valueOf(j));
                    Assert.assertTrue(bVar3 != null);
                    x.i("MicroMsg.exdevice.BluetoothChatSession", "connect");
                    if (bVar3.kCP != null) {
                        bVar3.mState = 2;
                        if (bVar3.kFF != null) {
                            bVar3.kFF.disconnect();
                            bVar3.kFF = null;
                        }
                        bVar3.kFF = new com.tencent.mm.plugin.g.a.c.c.a(bVar3, aVar, bVar3.kCP, true);
                        com.tencent.mm.plugin.g.a.c.c.a aVar2 = bVar3.kFF;
                        x.i("MicroMsg.exdevice.ConnectThread", "------connect------");
                        if (!aVar2.mHandler.sendMessage(aVar2.mHandler.obtainMessage(0))) {
                            x.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", Integer.valueOf(0));
                            if (aVar2.kFL != null) {
                                aVar2.kFL.kFB.g(aVar2.kFK.mSessionId, false);
                                break;
                            }
                        }
                    }
                    x.e("MicroMsg.exdevice.BluetoothChatSession", "Can not found remote device(" + com.tencent.mm.plugin.g.a.e.a.bN(bVar3.kFE) + ")");
                    if (aVar != null) {
                        aVar.kFB.b(bVar3.mSessionId, 7, "Device not found");
                    }
                    z = false;
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                z = false;
                break;
                break;
            default:
                Assert.assertTrue(false);
                z = false;
                break;
        }
        if (!z) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.connect failed!!!");
            bVar.g(j, false);
        }
        return z;
    }

    static /* synthetic */ boolean a(b bVar, long j, byte[] bArr) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(bVar.lVC.containsKey(Long.valueOf(j)));
        com.tencent.mm.plugin.g.a.d.b bVar2 = bVar.lVz;
        int intValue = ((Integer) bVar.lVC.get(Long.valueOf(j))).intValue();
        Assert.assertNotNull(bArr);
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***SendData*** sessionId = " + j + "bluetoothVersion = " + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.kFX != null) {
                    com.tencent.mm.plugin.g.a.b.b bVar3 = bVar2.kFX;
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "------writeData------ sessionId = %d, data length = %d", Long.valueOf(j), Integer.valueOf(bArr.length));
                    Assert.assertTrue(bVar3.mIsInit);
                    if (!bVar3.arR()) {
                        x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                        z = false;
                        break;
                    }
                    d dVar = (d) bVar3.kCx.get(String.valueOf(j));
                    if (dVar != null) {
                        x.i("MicroMsg.exdevice.BluetoothLESession", "------writeData------length = %d", Integer.valueOf(bArr.length));
                        x.d("MicroMsg.exdevice.BluetoothLESession", "writeData data dump = %s", com.tencent.mm.plugin.exdevice.j.b.ar(bArr));
                        z = dVar.mHandler.sendMessage(dVar.mHandler.obtainMessage(3, bArr));
                        break;
                    }
                    x.w("MicroMsg.exdevice.BluetoothLEManager", "session is null, may be this session is closed");
                    z = false;
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                z = false;
                break;
            case 1:
                if (bVar2.kFY != null) {
                    a aVar = bVar2.kFY;
                    x.i("MicroMsg.exdevice.BluetoothChatManager", "writeData to: " + j);
                    Assert.assertTrue(aVar.mIsInit);
                    if (!aVar.asa()) {
                        x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                        z = false;
                        break;
                    }
                    com.tencent.mm.plugin.g.a.c.b bVar4 = (com.tencent.mm.plugin.g.a.c.b) aVar.kCx.get(Long.valueOf(j));
                    if (bVar4 == null) {
                        z2 = false;
                    }
                    Assert.assertTrue(z2);
                    x.i("MicroMsg.exdevice.BluetoothChatSession", "write");
                    if (bVar4.kFH == null) {
                        z = false;
                        break;
                    }
                    z = bVar4.kFH.ah(bArr);
                    break;
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                z = false;
                break;
            default:
                Assert.assertTrue(false);
                z = false;
                break;
        }
        if (!z) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.sendData failed!!!");
            bVar.h(j, false);
        }
        return z;
    }

    static /* synthetic */ void b(b bVar, long j) {
        boolean z = true;
        if (bVar.lVB.containsKey(Long.valueOf(j))) {
            com.tencent.mm.plugin.g.a.d.b bVar2 = bVar.lVz;
            int intValue = ((Integer) bVar.lVC.get(Long.valueOf(j))).intValue();
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***Destroy Session*** aSessionId = " + j + " aBluetoothVersion" + intValue);
            switch (intValue) {
                case 0:
                    if (bVar2.kFX == null) {
                        x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                        return;
                    }
                    com.tencent.mm.plugin.g.a.b.b bVar3 = bVar2.kFX;
                    x.i("MicroMsg.exdevice.BluetoothLEManager", "------destroySession------ sessionId = %d", Long.valueOf(j));
                    Assert.assertTrue(bVar3.mIsInit);
                    if (bVar3.arR()) {
                        d dVar = (d) bVar3.kCx.remove(String.valueOf(j));
                        if (dVar == null) {
                            x.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot find BluetoothLESession by sessionId(%d)", Long.valueOf(j));
                            return;
                        }
                        dVar.close();
                        return;
                    }
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    return;
                case 1:
                    if (bVar2.kFY == null) {
                        x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                        return;
                    }
                    a aVar = bVar2.kFY;
                    x.i("MicroMsg.exdevice.BluetoothChatManager", "------destroySession------ sessionId = %d", Long.valueOf(j));
                    Assert.assertTrue(aVar.mIsInit);
                    if (aVar.asa()) {
                        com.tencent.mm.plugin.g.a.c.b bVar4 = (com.tencent.mm.plugin.g.a.c.b) aVar.kCx.remove(Long.valueOf(j));
                        if (bVar4 == null) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        bVar4.disconnect();
                        return;
                    }
                    x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    return;
                default:
                    Assert.assertTrue(false);
                    return;
            }
        }
        x.w("MicroMsg.exdevice.BluetoothSDKAdapter", "the session not exist");
    }

    public b() {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(Looper.getMainLooper().getThread().getId()));
        if (VERSION.SDK_INT != 14 && VERSION.SDK_INT != 15) {
            this.lVz = new com.tencent.mm.plugin.g.a.d.b(ad.getContext(), this, v.aFu().hPO);
        } else if (r0 == r2) {
            x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
            this.lVz = new com.tencent.mm.plugin.g.a.d.b(ad.getContext(), this, v.aFu().hPO);
        } else {
            new ag(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable() {
                public final void run() {
                    b.this.lVz = new com.tencent.mm.plugin.g.a.d.b(ad.getContext(), b.this, v.aFu().hPO);
                    x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
                    b.this.lVE.countDown();
                }
            });
            this.lVE = new CountDownLatch(1);
            try {
                this.lVE.await();
            } catch (InterruptedException e) {
            }
            x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
        }
    }

    private static b aFh() {
        if (lVD != null) {
            return lVD;
        }
        b bVar = new b();
        lVD = bVar;
        return bVar;
    }

    public static boolean a(final int i, final r rVar, final int... iArr) {
        if (rVar == null) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            return false;
        }
        b aFh = aFh();
        boolean post = aFh.mHandler.post(new Runnable(aFh) {
            final /* synthetic */ b lVG;

            public final void run() {
                if (!b.a(this.lVG, i, rVar, iArr)) {
                    x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
        return post;
    }

    public static boolean pu(final int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", Integer.valueOf(i));
        b aFh = aFh();
        boolean post = aFh.mHandler.post(new Runnable(aFh) {
            final /* synthetic */ b lVG;

            public final void run() {
                if (!b.a(this.lVG, i)) {
                    x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
                }
            }
        });
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void createSession(long j, long j2) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", Long.valueOf(j), Long.valueOf(j2));
        b aFh = aFh();
        final long j3 = j;
        final long j4 = j2;
        if (!aFh.mHandler.post(new Runnable(aFh) {
            final /* synthetic */ b lVG;

            public final void run() {
                b.a(this.lVG, j3, j4);
            }
        })) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
        }
    }

    public static boolean sendData(final long j, final byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str2 = "----sendData---- aSessionId = %d, datalength = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        x.i(str, str2, objArr);
        Assert.assertNotNull(bArr);
        b aFh = aFh();
        boolean post = aFh.mHandler.post(new Runnable(aFh) {
            final /* synthetic */ b lVG;

            public final void run() {
                if (!b.a(this.lVG, j, bArr)) {
                    x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
                }
            }
        });
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static boolean connect(final long j) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", Long.valueOf(j));
        b aFh = aFh();
        boolean post = aFh.mHandler.post(new Runnable(aFh) {
            final /* synthetic */ b lVG;

            public final void run() {
                if (!b.a(this.lVG, j)) {
                    x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
                }
            }
        });
        if (!post) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
        }
        return post;
    }

    public static void destroySession(final long j) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", Long.valueOf(j));
        b aFh = aFh();
        if (!aFh.mHandler.post(new Runnable(aFh) {
            final /* synthetic */ b lVG;

            public final void run() {
                b.b(this.lVG, j);
            }
        })) {
            x.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
        }
    }

    public final void b(long j, long j2, long j3) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + j + " aDeviceID = " + j2);
        Assert.assertTrue(this.lVB.containsKey(Long.valueOf(j2)));
        if (!this.lVC.containsKey(Long.valueOf(j))) {
            this.lVC.put(Long.valueOf(j), this.lVB.get(Long.valueOf(j2)));
        }
        Java2CExDevice.onBluetoothSessionCreated(j2, j3, j);
    }

    public final void nv(int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", Integer.valueOf(i));
        if (this.lVA.isEmpty()) {
            x.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.lVA.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.nv(i);
            }
        }
        this.lVA.clear();
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BluetoothSDKAdapter";
        String str4 = "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.d(str3, str4, objArr);
        if (this.lVA.isEmpty()) {
            x.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            return;
        }
        Iterator it = this.lVA.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a(str, str2, i, i2, bArr);
        }
    }

    public final void g(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + j + "Connected = " + z);
        if (z) {
            Java2CExDevice.onBluetoothConnected(j);
        } else {
            Java2CExDevice.onBluetoothDisconnected(j);
        }
    }

    public final void b(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = " + j);
        Java2CExDevice.onBluetoothRecvData(j, bArr);
    }

    public final void h(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + j + "success = " + z);
        if (z) {
            Java2CExDevice.onBluetoothSendDataCompleted(j);
        } else {
            Java2CExDevice.onBluetoothError(j, 0);
        }
    }

    public final void bM(long j) {
        Java2CExDevice.onBluetoothError(j, 0);
    }
}
