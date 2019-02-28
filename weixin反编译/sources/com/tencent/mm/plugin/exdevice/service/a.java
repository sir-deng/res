package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.LongWrapper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class a implements r {
    private static a lVq = null;
    private Object hrp = new Object();
    private final HashMap<Long, Long> lVr = new HashMap();
    private g lVs = null;
    ag mHandler = new a(v.aFu().hPO.oFY.getLooper());

    private static final class g {
        long lVx;
        p lVy;

        public g(long j, p pVar) {
            this.lVx = j;
            this.lVy = pVar;
        }
    }

    private static final class c {
        String kGg;
        String kGh;
        int kGi;
        byte[] kGj;

        public c(String str, String str2, int i, byte[] bArr) {
            this.kGg = str;
            this.kGh = str2;
            this.kGi = i;
            this.kGj = bArr;
        }
    }

    private static final class e {
        String jfR = null;
        int lPJ = 0;
        int lPV = 0;
        long lVx = 0;
    }

    private final class a extends ag {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    c cVar = (c) message.obj;
                    a.this.lVs.a(1, 0, null, cVar.kGg, cVar.kGh, cVar.kGi, cVar.kGj);
                    return;
                case 2:
                    a.this.lVs.a(2, 0, null, null, null, 0, null);
                    return;
                case 3:
                    e eVar = (e) message.obj;
                    a.this.lVs.c(eVar.lVx, eVar.lPV, eVar.lPJ, eVar.jfR);
                    return;
                case 4:
                    d dVar = (d) message.obj;
                    a.this.lVs.b(dVar.kGc, dVar.lVv, dVar.lVw, dVar.lPJ);
                    return;
                case 5:
                    b bVar = (b) message.obj;
                    a.this.lVs.a(message.arg1, bVar.kGc, bVar.lPQ, bVar.lVu, bVar.lPK);
                    return;
                case 8:
                    g gVar = (g) message.obj;
                    a.this.a(gVar.lVx, gVar.lVy);
                    return;
                case 9:
                    a.cx(((Long) message.obj).longValue());
                    return;
                case 10:
                    f fVar = (f) message.obj;
                    a.a(a.this, fVar.kGc, fVar.kCs);
                    return;
                case 11:
                    synchronized (a.this.hrp) {
                        a.a(a.this, ((Long) message.obj).longValue());
                    }
                    return;
                case 12:
                    synchronized (a.this.hrp) {
                        a.this.cv(((Long) message.obj).longValue());
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static final class b {
        long kGc;
        byte[] lPK;
        short lPQ;
        short lVu;

        private b() {
            this.kGc = 0;
            this.lPQ = (short) 0;
            this.lVu = (short) 0;
            this.lPK = null;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class d {
        long kGc;
        int lPJ;
        int lVv;
        int lVw;

        private d() {
            this.kGc = 0;
            this.lVv = 0;
            this.lVw = 0;
            this.lPJ = 0;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static final class f {
        byte[] kCs;
        long kGc;

        public f(long j, byte[] bArr) {
            this.kGc = j;
            this.kCs = bArr;
        }
    }

    static /* synthetic */ void a(a aVar, long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKeyImp------ deviceId = %d", Long.valueOf(j));
        if (aVar.lVr.containsKey(Long.valueOf(j))) {
            Java2CExDevice.setChannelSessionKey(((Long) aVar.lVr.get(Long.valueOf(j))).longValue(), bArr);
        } else {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        }
    }

    static /* synthetic */ boolean a(a aVar, long j) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "startChannelImp deviceId = %d", Long.valueOf(j));
        if (com.tencent.mm.plugin.exdevice.h.a.y("conneted_device", j)) {
            x.w("MicroMsg.exdevice.BTDeviceManager", "This deviceId is not call stop channel before startChannel, Call it");
            aVar.cv(j);
        }
        LongWrapper longWrapper = new LongWrapper();
        longWrapper.value = -1;
        int createChannel = Java2CExDevice.createChannel(j, longWrapper);
        if (createChannel != 0) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.createChannel Failed, ret = " + createChannel);
            aVar.lVs.b(j, 1, 4, -1);
            return false;
        }
        x.i("MicroMsg.exdevice.BTDeviceManager", "Create channel id is ok, deviceId = %d, channelId = %d", Long.valueOf(j), Long.valueOf(longWrapper.value));
        aVar.lVr.put(Long.valueOf(j), Long.valueOf(longWrapper.value));
        x.i("MicroMsg.exdevice.BTDeviceManager", "add the device to connected devices : [%d]", Long.valueOf(j));
        if (com.tencent.mm.plugin.exdevice.h.a.z("conneted_device", j)) {
            int startChannelService = Java2CExDevice.startChannelService(longWrapper.value);
            if (startChannelService == 0) {
                return true;
            }
            x.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startChannelService Failed, ret = " + startChannelService);
            aVar.lVs.b(j, 1, 4, -1);
            return false;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "addToSharedPreferences failed!!!");
        aVar.lVs.b(j, 1, 4, -1);
        return false;
    }

    static /* synthetic */ void cx(long j) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopTaskImp taskId = %d", Long.valueOf(j));
        Java2CExDevice.stopTask(j);
    }

    public a(g gVar) {
        this.lVs = gVar;
        lVq = this;
    }

    public static boolean pu(int i) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
        if (b.pu(i)) {
            return true;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
        return false;
    }

    public static long[] aFg() {
        return com.tencent.mm.plugin.exdevice.h.a.zK("conneted_device");
    }

    private boolean cv(long j) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = " + j);
        x.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", Long.valueOf(j));
        if (!com.tencent.mm.plugin.exdevice.h.a.A("conneted_device", j)) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
        }
        if (this.lVr.containsKey(Long.valueOf(j))) {
            Java2CExDevice.stopChannelService(((Long) this.lVr.get(Long.valueOf(j))).longValue());
            Java2CExDevice.destroyChannel(((Long) this.lVr.get(Long.valueOf(j))).longValue());
            return true;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
        return false;
    }

    private int a(long j, p pVar) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "startTaskImp, taskId = %d", Long.valueOf(j));
        Assert.assertNotNull(pVar);
        try {
            long aFk = pVar.aFp().aFk();
            if (!com.tencent.mm.plugin.exdevice.h.a.y("conneted_device", aFk)) {
                x.w("MicroMsg.exdevice.BTDeviceManager", "Cannot startTask because this channel is close aready!!!");
                e eVar = new e();
                eVar.lVx = j;
                eVar.lPJ = -1;
                eVar.lPV = -1;
                eVar.jfR = "Channel is close aready!!!";
                Assert.assertTrue(lVq.mHandler.sendMessage(lVq.mHandler.obtainMessage(3, 0, 0, eVar)));
                return -1;
            } else if (this.lVr.containsKey(Long.valueOf(aFk))) {
                AccessoryCmd accessoryCmd = new AccessoryCmd();
                accessoryCmd.channelID = ((Long) this.lVr.get(Long.valueOf(aFk))).longValue();
                try {
                    accessoryCmd.reqCmdID = pVar.aFp().aFm();
                    accessoryCmd.respCmdID = pVar.aFp().aFn();
                    try {
                        if (Java2CExDevice.startTask(j, (short) pVar.aFp().aFo(), accessoryCmd, pVar.aFp().aFl()) != 0) {
                            x.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startTask Failed!!!");
                            return -1;
                        }
                        x.i("MicroMsg.exdevice.BTDeviceManager", "------let task go------ taskId = %d, deviceId = %d, channelId = %d, seq = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j), Long.valueOf(aFk), Long.valueOf(accessoryCmd.channelID), Integer.valueOf(pVar.aFp().aFo()), Integer.valueOf(accessoryCmd.reqCmdID), Integer.valueOf(accessoryCmd.respCmdID));
                        return 0;
                    } catch (Throwable e) {
                        x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDataOut failed!!! %s", e.getMessage());
                        x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e, "", new Object[0]);
                        this.lVs.c(j, -1, -1, "Remote getDataOut failed!!!!!!");
                        return -1;
                    }
                } catch (Throwable e2) {
                    x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getResquestCmdId or getResponseCmdId failed!!! %s", e2.getMessage());
                    x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e2, "", new Object[0]);
                    this.lVs.c(j, -1, -1, "Remote getResquestCmdId or getResponseCmdId failed!!!");
                    return -1;
                }
            } else {
                x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find Channel by DeviceId(%s) in mMapDeviceChannelId", Long.valueOf(aFk));
                this.lVs.c(j, -1, -1, "Cannot find Channel by DeviceId!!!");
                return -1;
            }
        } catch (Throwable e22) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDeviceId failed!!! %s", e22.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e22, "", new Object[0]);
            this.lVs.c(j, -1, -1, "Remote getDeviceId failed!!!");
            return -1;
        }
    }

    public static void c(long j, int i, int i2, String str) {
        Assert.assertNotNull(lVq);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + j + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        e eVar = new e();
        eVar.lVx = j;
        eVar.lPJ = i2;
        eVar.lPV = i;
        eVar.jfR = str;
        Assert.assertTrue(lVq.mHandler.sendMessage(lVq.mHandler.obtainMessage(3, 0, 0, eVar)));
    }

    public static void b(long j, int i, int i2, int i3) {
        Assert.assertNotNull(lVq);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + j + " oldState = " + i + " newState = " + i2 + " errCode = " + i3);
        long cw = lVq.cw(j);
        if (-1 == cw) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        d dVar = new d();
        dVar.kGc = cw;
        dVar.lPJ = i3;
        dVar.lVw = i2;
        dVar.lVv = i;
        Assert.assertTrue(lVq.mHandler.sendMessage(lVq.mHandler.obtainMessage(4, 0, 0, dVar)));
    }

    private long cw(long j) {
        if (this.lVr.containsValue(Long.valueOf(j))) {
            for (Entry entry : this.lVr.entrySet()) {
                if (j == ((Long) entry.getValue()).longValue()) {
                    return ((Long) entry.getKey()).longValue();
                }
            }
            Assert.assertTrue(false);
            return -1;
        }
        x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceId by channelId");
        return -1;
    }

    public static void onDeviceRequest(long j, short s, short s2, byte[] bArr, int i) {
        String str = "MicroMsg.exdevice.BTDeviceManager";
        String str2 = "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Short.valueOf(s);
        objArr[2] = Short.valueOf(s2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Integer.valueOf(i);
        x.i(str, str2, objArr);
        Assert.assertNotNull(lVq);
        x.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + j + " seq = " + s + "cmdId = " + s2 + "errCode = " + i);
        long cw = lVq.cw(j);
        if (-1 == cw) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            return;
        }
        b bVar = new b();
        bVar.kGc = cw;
        bVar.lPK = bArr;
        bVar.lVu = s2;
        bVar.lPQ = s;
        Assert.assertTrue(lVq.mHandler.sendMessage(lVq.mHandler.obtainMessage(5, i, 0, bVar)));
    }

    public final void nv(int i) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = " + i);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
    }

    public final void a(String str, String str2, int i, int i2, byte[] bArr) {
        String str3 = "MicroMsg.exdevice.BTDeviceManager";
        String str4 = "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.d(str3, str4, objArr);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, new c(str, str2, i2, bArr))));
    }

    public final void ws(String str) {
        x.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", Integer.valueOf(-1), Integer.valueOf(-1));
        if (!this.mHandler.post(new Runnable() {
            public final void run() {
                a.this.lVs.a(0, -1, "", "", "", 0, null);
            }
        })) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
        }
    }
}
