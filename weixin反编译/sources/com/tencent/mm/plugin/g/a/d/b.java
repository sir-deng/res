package com.tencent.mm.plugin.g.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b {
    public com.tencent.mm.plugin.g.a.b.b kFX = null;
    public com.tencent.mm.plugin.g.a.c.a kFY = null;
    c kFZ = null;
    final HashSet<String> kGa = new HashSet();
    private ag mHandler = null;

    private static final class d {
        long kCJ;
        long kGc;
        long mSessionId;

        public d(long j, long j2, long j3) {
            this.mSessionId = j;
            this.kGc = j2;
            this.kCJ = j3;
        }
    }

    private static class e {
        long kGd;
        boolean kGe;

        public e(long j, boolean z) {
            this.kGd = j;
            this.kGe = z;
        }
    }

    private static final class g {
        private String kGf;
        private int mErrorCode;
        long mSessionId;

        public g(long j, int i, String str) {
            this.mSessionId = j;
            this.mErrorCode = i;
            this.kGf = str;
        }
    }

    private static final class i {
        String kGg;
        String kGh;
        int kGi;
        byte[] kGj;

        public i(String str, String str2, int i, byte[] bArr) {
            this.kGg = str;
            this.kGh = str2;
            this.kGi = i;
            this.kGj = bArr;
        }
    }

    class b extends com.tencent.mm.plugin.g.a.b.b.a {
        b() {
        }

        public final void b(long j, long j2, long j3) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(6, 0, 0, new d(j, j2, j3))));
        }

        public final void arS() {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
            b.this.kGa.clear();
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(2, 0, 0, null)));
        }

        public final void a(String str, String str2, int i, byte[] bArr) {
            x.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", str, str2);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(3, 0, 0, new i(str, str2, i, bArr))));
        }

        public final void g(long j, boolean z) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(4, 0, 0, new f(j, z))));
        }

        public final void b(long j, byte[] bArr) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = " + j);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(1, 0, 0, new h(j, bArr))));
        }

        public final void h(long j, boolean z) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(0, 0, 0, new j(j, z))));
        }
    }

    private static final class f extends e {
        public f(long j, boolean z) {
            super(j, z);
        }
    }

    private static final class h {
        byte[] kCs;
        long mSessionId;

        public h(long j, byte[] bArr) {
            this.mSessionId = j;
            this.kCs = bArr;
        }
    }

    class a extends com.tencent.mm.plugin.g.a.c.a.a {
        a() {
        }

        public final void b(long j, long j2, long j3) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(6, 1, 0, new d(j, j2, j3))));
        }

        public final void arS() {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
            b.this.kGa.clear();
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(2, 1, 0, null)));
        }

        public final void bS(String str, String str2) {
            int i;
            b bVar = b.this;
            if (str == null) {
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
                i = 0;
            } else if (bVar.kGa.contains(str)) {
                i = 0;
            } else {
                bVar.kGa.add(str);
                i = 1;
            }
            if (i != 0) {
                x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + str + "deviceName = " + str2);
                Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(3, 1, 0, new i(str, str2, 0, null))));
            }
        }

        public final void g(long j, boolean z) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + j + " Connected = " + z);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(4, 1, 0, new f(j, z))));
        }

        public final void b(long j, byte[] bArr) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = " + j);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(1, 1, 0, new h(j, bArr))));
        }

        public final void h(long j, boolean z) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + j + " success = " + z);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(0, 1, 0, new j(j, z))));
        }

        public final void b(long j, int i, String str) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + j + " errorCode = " + i + " errorInfo = " + str);
            Assert.assertTrue(b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(5, 1, 0, new g(j, i, str))));
        }
    }

    static class c extends ag {
        private WeakReference<b> kDf = null;

        public c(Looper looper, b bVar) {
            super(looper);
            this.kDf = new WeakReference(bVar);
        }

        public final void handleMessage(Message message) {
            b bVar = (b) this.kDf.get();
            if (bVar == null) {
                x.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
                return;
            }
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + message.what);
            switch (message.what) {
                case 0:
                    j jVar = (j) message.obj;
                    bVar.kFZ.h(jVar.kGd, jVar.kGe);
                    return;
                case 1:
                    h hVar = (h) message.obj;
                    bVar.kFZ.b(hVar.mSessionId, hVar.kCs);
                    return;
                case 2:
                    bVar.kFZ.nv(message.arg1);
                    return;
                case 3:
                    i iVar = (i) message.obj;
                    bVar.kFZ.a(iVar.kGg, iVar.kGh, message.arg1, iVar.kGi, iVar.kGj);
                    return;
                case 4:
                    f fVar = (f) message.obj;
                    bVar.kFZ.g(fVar.kGd, fVar.kGe);
                    return;
                case 5:
                    bVar.kFZ.bM(((g) message.obj).mSessionId);
                    return;
                case 6:
                    d dVar = (d) message.obj;
                    bVar.kFZ.b(dVar.mSessionId, dVar.kGc, dVar.kCJ);
                    return;
                default:
                    return;
            }
        }
    }

    private static final class j extends e {
        public j(long j, boolean z) {
            super(j, z);
        }
    }

    public b(Context context, c cVar, ah ahVar) {
        this.kFY = new com.tencent.mm.plugin.g.a.c.a(ahVar);
        if (VERSION.SDK_INT >= 18) {
            this.kFX = new com.tencent.mm.plugin.g.a.b.b(ahVar);
            com.tencent.mm.plugin.g.a.b.b bVar = this.kFX;
            com.tencent.mm.plugin.g.a.b.b.a bVar2 = new b();
            x.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
            Assert.assertNotNull(context);
            Assert.assertNotNull(bVar2);
            if (!bVar.mIsInit) {
                bVar.mIsInit = true;
                bVar.tI = context;
                bVar.kCw = bVar2;
                bVar.kCz = com.tencent.mm.plugin.g.a.b.c.arT();
                if (com.tencent.mm.compatible.util.f.fN(21)) {
                    bVar.kCA = com.tencent.mm.plugin.g.a.b.g.arY();
                }
                if (bVar.arR()) {
                    bVar.kBQ = ((BluetoothManager) bVar.tI.getSystemService("bluetooth")).getAdapter();
                } else {
                    x.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
                }
            }
        }
        com.tencent.mm.plugin.g.a.c.a aVar = this.kFY;
        com.tencent.mm.plugin.g.a.c.a.a aVar2 = new a();
        x.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
        Assert.assertNotNull(context);
        Assert.assertNotNull(aVar2);
        if (!aVar.mIsInit) {
            aVar.mIsInit = true;
            aVar.kFB = aVar2;
            aVar.kFC = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            aVar.kFC.registerReceiver(aVar.jle, intentFilter);
            aVar.kBQ = BluetoothAdapter.getDefaultAdapter();
        }
        this.mHandler = new c(v.aFu().hPO.oFY.getLooper(), this);
        this.kFZ = cVar;
    }

    public final boolean a(int i, int... iArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.kFX == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return false;
                } else if (iArr == null) {
                    return this.kFX.a(true, new int[0]);
                } else {
                    return this.kFX.a(true, iArr);
                }
            case 1:
                if (this.kFY != null) {
                    return this.kFY.dW(true);
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                return false;
            default:
                Assert.assertTrue(false);
                return false;
        }
    }

    public final void b(long j, long j2, int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + j + "aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.kFX == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return;
                }
                com.tencent.mm.plugin.g.a.b.b bVar = this.kFX;
                x.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", Long.valueOf(j), Long.valueOf(j2));
                Assert.assertTrue(bVar.mIsInit);
                if (bVar.arR()) {
                    Assert.assertTrue(bVar.mHandler.post(new b(j, j2)));
                    return;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    return;
                }
            case 1:
                if (this.kFY == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    return;
                }
                com.tencent.mm.plugin.g.a.c.a aVar = this.kFY;
                x.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
                Assert.assertTrue(aVar.mIsInit);
                if (aVar.asa()) {
                    Assert.assertTrue(aVar.mHandler.post(new b(j, j2)));
                    return;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    return;
                }
            default:
                Assert.assertTrue(false);
                return;
        }
    }
}
