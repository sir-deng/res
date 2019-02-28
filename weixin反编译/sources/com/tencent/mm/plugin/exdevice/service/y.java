package com.tencent.mm.plugin.exdevice.service;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import com.tencent.mm.plugin.g.a.a.f.AnonymousClass6;
import com.tencent.mm.plugin.g.a.a.f.AnonymousClass7;
import com.tencent.mm.plugin.g.a.b.e.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

public final class y extends com.tencent.mm.plugin.exdevice.service.h.a implements g, com.tencent.mm.plugin.g.a.a.b, com.tencent.mm.plugin.g.a.d.a.a {
    private a lWe;
    private RemoteCallbackList<k> lWf;
    private RemoteCallbackList<p> lWg;
    private RemoteCallbackList<j> lWh;
    private RemoteCallbackList<i> lWi;
    private RemoteCallbackList<q> lWj;
    private RemoteCallbackList<n> lWk;
    private final l lWl;
    private int lWm;
    private final com.tencent.mm.plugin.g.a.a.f lWn;
    private final com.tencent.mm.plugin.g.a.d.a lWo;
    private RemoteCallbackList<j> lWp;
    private RemoteCallbackList<k> lWq;
    private RemoteCallbackList<s> lWr;
    private RemoteCallbackList<t> lWs;
    com.tencent.mm.plugin.g.a.b.e lWt;
    private com.tencent.mm.plugin.g.a.b.e.a lWu;
    private final ag mHandler;

    private static final class b {
        long kGc;
        byte[] lPK;
        short lPQ;
        short lVu;
        int mErrorCode;

        private b() {
            this.kGc = 0;
            this.lPQ = (short) 0;
            this.lVu = (short) 0;
            this.lPK = null;
            this.mErrorCode = 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class d {
        String jfR = null;
        int lPJ = 0;
        int lPV = 0;
        long lVx = 0;
    }

    private static final class i {
        public byte[] kCs;
        public long lSK;
        public t lWB;

        private i() {
        }

        /* synthetic */ i(byte b) {
            this();
        }
    }

    private static final class k {
        long lVx;
        p lWD;

        public k(long j, p pVar) {
            this.lVx = j;
            this.lWD = pVar;
        }
    }

    private static final class c {
        long kDv;
        long kGc;
        int lPJ;
        int lVv;
        int lVw;

        private c() {
            this.kGc = 0;
            this.lVv = 0;
            this.lVw = 0;
            this.lPJ = 0;
            this.kDv = 0;
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private static final class e {
        public long lSK;
        public int lWx;
        public k lWy;

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    private static final class f {
        public byte[] kCs;
        public long lSK;

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    private static final class g {
        String kGg;
        String kGh;
        int kGi;
        byte[] lWA;
        boolean lWz;

        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }
    }

    private static final class h {
        public String jfR;
        public int lPJ;
        public int lPV;
        public long lSK;

        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }
    }

    private static final class l {
        long lVx;

        private l() {
            this.lVx = 0;
        }

        /* synthetic */ l(byte b) {
            this();
        }
    }

    private final class a extends ag {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    k kVar = (k) message.obj;
                    if (!y.this.b(kVar.lVx, kVar.lWD)) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                        return;
                    }
                    return;
                case 1:
                    if (!y.a(y.this, ((Long) message.obj).longValue())) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                        return;
                    }
                    return;
                case 2:
                    d dVar = (d) message.obj;
                    y.this.d(dVar.lVx, dVar.lPV, dVar.lPJ, dVar.jfR);
                    return;
                case 3:
                    j jVar = (j) message.obj;
                    if (!y.a(y.this, jVar.kGc, jVar.lWC, jVar.lWy)) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                        return;
                    }
                    return;
                case 4:
                    if (!y.b(y.this, ((Long) message.obj).longValue())) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                        return;
                    }
                    return;
                case 5:
                    c cVar = (c) message.obj;
                    y.a(y.this, cVar.kGc, cVar.lVv, cVar.lVw, cVar.lPJ);
                    return;
                case 6:
                    b bVar = (b) message.obj;
                    y.a(y.this, bVar.mErrorCode, bVar.kGc, bVar.lPQ, bVar.lVu, bVar.lPK);
                    return;
                case 7:
                    e eVar = (e) message.obj;
                    if (!y.this.c(eVar.lSK, eVar.lWx, eVar.lWy)) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
                        return;
                    }
                    return;
                case 8:
                    long longValue = ((Long) message.obj).longValue();
                    y yVar = y.this;
                    x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", Long.valueOf(longValue));
                    if (yVar.lWt != null) {
                        com.tencent.mm.plugin.g.a.b.e eVar2 = yVar.lWt;
                        x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", Long.valueOf(longValue));
                        if (eVar2.arR()) {
                            eVar2.t(new AnonymousClass5(longValue));
                            return;
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                            return;
                        }
                    }
                    return;
                case 9:
                    c cVar2 = (c) message.obj;
                    if (!y.this.b(cVar2.kGc, cVar2.lVv, cVar2.lVw, cVar2.lPJ, cVar2.kDv)) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
                        return;
                    }
                    return;
                case 10:
                    i iVar = (i) message.obj;
                    if (!y.this.c(iVar.lSK, iVar.kCs, iVar.lWB)) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
                        return;
                    }
                    return;
                case 11:
                    h hVar = (h) message.obj;
                    if (!y.this.e(hVar.lSK, hVar.lPV, hVar.lPJ, hVar.jfR)) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
                        return;
                    }
                    return;
                case 12:
                    f fVar = (f) message.obj;
                    y.this.d(fVar.lSK, fVar.kCs);
                    return;
                case 13:
                    y.a(y.this, (g) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    private static final class j {
        long kGc;
        int lWC;
        k lWy;

        public j(long j, int i, k kVar) {
            this.kGc = j;
            this.lWC = i;
            this.lWy = kVar;
        }
    }

    static /* synthetic */ void a(y yVar, int i, long j, short s, short s2, byte[] bArr) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequestImp errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        int beginBroadcast = yVar.lWi.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                i iVar = (i) yVar.lWi.getBroadcastItem(i2);
                if (iVar != null) {
                    iVar.a(i, j, s, s2, bArr);
                } else {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "get req callback failed, cmdId = %d", Short.valueOf(s2));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest Failed!!! i = " + i2);
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        yVar.lWi.finishBroadcast();
    }

    static /* synthetic */ void a(y yVar, long j, int i, int i2, int i3) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChangeImp deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        k kVar = (k) a(j, yVar.lWf, yVar.lWf.beginBroadcast());
        if (kVar == null) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            yVar.lWf.finishBroadcast();
            return;
        }
        try {
            kVar.a(j, i, i2, i3, 0);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        yVar.lWf.finishBroadcast();
    }

    static /* synthetic */ void a(y yVar, g gVar) {
        int beginBroadcast = yVar.lWp.beginBroadcast();
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnDiscoverCallback size=%d", Integer.valueOf(beginBroadcast));
        if (beginBroadcast <= 0) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "no simpleBTOnDiscoverCallback");
        }
        int i = 0;
        while (i < beginBroadcast) {
            try {
                if (gVar.lWz) {
                    ((j) yVar.lWp.getBroadcastItem(i)).a(2, 0, "scan finish", null, null, 0, null);
                    if (!yVar.lWp.unregister(yVar.lWp.getBroadcastItem(i))) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mSimpleOnScanCallbackList.unregister failed!!!");
                    }
                } else {
                    ((j) yVar.lWp.getBroadcastItem(i)).a(1, 0, "discover device", gVar.kGg, gVar.kGh, gVar.kGi, gVar.lWA);
                }
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception: " + e.toString());
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                return;
            } finally {
                yVar.lWp.finishBroadcast();
            }
        }
        yVar.lWp.finishBroadcast();
    }

    static /* synthetic */ boolean a(y yVar, long j) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp, task id = %d", Long.valueOf(j));
        if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            return false;
        }
        int beginBroadcast = yVar.lWg.beginBroadcast();
        IInterface iInterface = (p) a(j, yVar.lWg, beginBroadcast);
        if (iInterface == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask Failed, Cannot find such netCmd in RemoteCallbackList");
            yVar.lWg.finishBroadcast();
            return false;
        }
        a aVar = yVar.lWe;
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopTask taskId = %d", Long.valueOf(j));
        aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(9, Long.valueOf(j)));
        boolean a = a(yVar.lWg, j, iInterface, beginBroadcast);
        if (!a) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListTask.unregister Failed!!!");
        }
        yVar.lWg.finishBroadcast();
        return a;
    }

    static /* synthetic */ boolean a(y yVar, long j, int i, k kVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp deviceId = %d, bluetoothVersion = %d", Long.valueOf(j), Integer.valueOf(i));
        Assert.assertNotNull(kVar);
        v aFu = v.aFu();
        x.i("MicroMsg.exdevice.MMExDevicePushCore", "insertDeviceIdAndBluetoothVersion aDeviceId = %d, aBluetoothVersion = %d", Long.valueOf(j), Integer.valueOf(i));
        aFu.lWc.put(Long.valueOf(j), Integer.valueOf(i));
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange, deviceId = %d", Long.valueOf(j));
        boolean a = a(yVar.lWf, j, (IInterface) kVar);
        if (!a) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnStateChange.register Failed!!!");
        }
        if (a) {
            a aVar = yVar.lWe;
            x.i("MicroMsg.exdevice.BTDeviceManager", "startChannel deviceId = %d", Long.valueOf(j));
            if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(11, Long.valueOf(j)))) {
                return true;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startChannel Failed!!!");
            x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange, deviceId = %d", Long.valueOf(j));
            a = a(yVar.lWf, j, (IInterface) kVar, yVar.lWf.beginBroadcast());
            if (!a) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
            }
            yVar.lWf.finishBroadcast();
            if (!a) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange");
            }
            yVar.b(j, 1, 4, -1);
            return false;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange Failed!!!");
        yVar.b(j, 1, 4, -1);
        return false;
    }

    static /* synthetic */ boolean b(y yVar, long j) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp deviceId = %d", Long.valueOf(j));
        a aVar = yVar.lWe;
        x.i("MicroMsg.exdevice.BTDeviceManager", "stopChannel deviceId = " + j);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(12, Long.valueOf(j)))) {
            return true;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopChannel Failed!!!");
        return false;
    }

    public y() {
        this.lWe = null;
        this.lWf = new RemoteCallbackList();
        this.lWg = new RemoteCallbackList();
        this.lWh = new RemoteCallbackList();
        this.lWi = new RemoteCallbackList();
        this.lWj = new RemoteCallbackList();
        this.lWk = new RemoteCallbackList();
        this.lWl = new l();
        this.lWm = 0;
        this.lWp = new RemoteCallbackList();
        this.lWq = new RemoteCallbackList();
        this.lWr = new RemoteCallbackList();
        this.lWs = new RemoteCallbackList();
        this.lWe = new a(this);
        this.mHandler = new a(v.aFu().hPO.oFY.getLooper());
        if (VERSION.SDK_INT >= 18) {
            this.lWn = new com.tencent.mm.plugin.g.a.a.f(this);
        } else {
            this.lWn = null;
        }
        this.lWo = new com.tencent.mm.plugin.g.a.d.a(this);
        this.lWu = new com.tencent.mm.plugin.g.a.b.e.a() {
            public final void a(long j, boolean z, long j2) {
                String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
                String str2 = "onConnected. seesionId=%d, connected=%s, profileType=%d";
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(j);
                objArr[1] = z ? "true" : "false";
                objArr[2] = Long.valueOf(j2);
                x.d(str, str2, objArr);
                c cVar = new c();
                cVar.kGc = j;
                cVar.lVw = z ? 2 : 4;
                cVar.lVv = 1;
                cVar.lPJ = 0;
                cVar.kDv = j2;
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(9, cVar))) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(9));
                }
            }

            public final void b(long j, byte[] bArr) {
                f fVar = new f();
                fVar.lSK = j;
                fVar.kCs = bArr;
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(12, fVar))) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(12));
                }
            }

            public final void h(long j, boolean z) {
                String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
                String str2 = "onSend. sessionId=%d, success=%s";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j);
                objArr[1] = z ? "true" : "false";
                x.d(str, str2, objArr);
                h hVar = new h();
                hVar.lSK = j;
                if (z) {
                    hVar.lPV = 0;
                    hVar.lPJ = 0;
                } else {
                    hVar.lPV = -1;
                    hVar.lPJ = -1;
                }
                hVar.jfR = "";
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(11, hVar))) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(11));
                }
            }

            public final void a(String str, String str2, int i, byte[] bArr) {
                x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", str, str2);
                g gVar = new g();
                gVar.lWz = false;
                gVar.kGg = str;
                gVar.kGh = str2;
                gVar.kGi = i;
                gVar.lWA = bArr;
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(13, gVar))) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(13));
                }
            }

            public final void arS() {
                x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
                g gVar = new g();
                gVar.lWz = true;
                gVar.kGg = null;
                gVar.kGh = null;
                gVar.kGi = 0;
                gVar.lWA = null;
                if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(13, gVar))) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(13));
                }
            }
        };
        com.tencent.mm.compatible.a.a.a(18, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                y.this.lWt = new com.tencent.mm.plugin.g.a.b.e(y.this.lWu);
            }
        });
    }

    private static IInterface a(long j, RemoteCallbackList remoteCallbackList, int i) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", Long.valueOf(j), Integer.valueOf(i));
        for (int i2 = 0; i2 < i; i2++) {
            HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i2);
            if (hashMap.containsKey(Long.valueOf(j))) {
                return (IInterface) hashMap.get(Long.valueOf(j));
            }
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
        return null;
    }

    private boolean c(j jVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
        boolean unregister = this.lWh.unregister(jVar);
        if (unregister) {
            this.lWm--;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
        }
        return unregister;
    }

    public final boolean b(final int i, final j jVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = " + i);
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            return false;
        }
        boolean post = this.mHandler.post(new Runnable() {
            public final void run() {
                if (!y.this.f(i, jVar)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
        return post;
    }

    private boolean f(int i, j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            throw new IllegalArgumentException("scanImp: null == aCallback");
        }
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
        boolean register = this.lWh.register(jVar);
        if (register) {
            this.lWm++;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
        }
        if (register) {
            boolean z;
            r rVar = this.lWe;
            x.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", Integer.valueOf(i));
            if (b.a(i, rVar, new int[0])) {
                z = true;
            } else {
                x.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
                z = false;
            }
            if (!z) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
                try {
                    jVar.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
                } catch (Throwable e) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", e.getMessage());
                    x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
                if (!c(jVar)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
                }
            }
            return z;
        }
        try {
            jVar.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
        } catch (Throwable e2) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", e2.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        }
        return false;
    }

    public final boolean c(final int i, final j jVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = " + i);
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
            return false;
        }
        boolean post = this.mHandler.post(new Runnable() {
            public final void run() {
                if (!y.this.g(i, jVar)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
                }
            }
        });
        if (post) {
            return post;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
        return post;
    }

    private boolean g(int i, j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
            return false;
        }
        boolean pu = a.pu(i);
        if (!pu) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
            try {
                jVar.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", e.getMessage());
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        if (!c(jVar)) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        return pu;
    }

    public final long[] aFg() {
        return a.aFg();
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", Long.valueOf(j));
        if (remoteCallbackList == null || iInterface == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            return false;
        }
        int beginBroadcast = remoteCallbackList.beginBroadcast();
        do {
            beginBroadcast--;
            if (beginBroadcast < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(beginBroadcast).asBinder().equals(iInterface.asBinder()));
        HashMap hashMap;
        if (beginBroadcast < 0) {
            x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
            hashMap = new HashMap();
            hashMap.put(Long.valueOf(j), iInterface);
            remoteCallbackList.register(iInterface, hashMap);
            remoteCallbackList.finishBroadcast();
            return true;
        }
        hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(beginBroadcast);
        if (hashMap == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            remoteCallbackList.finishBroadcast();
            return false;
        }
        hashMap.put(Long.valueOf(j), iInterface);
        remoteCallbackList.finishBroadcast();
        return true;
    }

    private static boolean a(RemoteCallbackList remoteCallbackList, long j, IInterface iInterface, int i) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", Long.valueOf(j), Integer.valueOf(i));
        if (remoteCallbackList == null || iInterface == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
            return false;
        }
        do {
            i--;
            if (i < 0) {
                break;
            }
        } while (!remoteCallbackList.getBroadcastItem(i).asBinder().equals(iInterface.asBinder()));
        if (i < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
            return false;
        }
        HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i);
        if (hashMap == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
            return false;
        } else if (((IInterface) hashMap.remove(Long.valueOf(j))) == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
            return false;
        } else if (!hashMap.isEmpty()) {
            return true;
        } else {
            x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
            boolean unregister = remoteCallbackList.unregister(iInterface);
            if (unregister) {
                return unregister;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
            return unregister;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", Long.valueOf(j), Integer.valueOf(i));
        if (kVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
            return false;
        } else if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            return false;
        } else if (1 == i || i == 0) {
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(3, new j(j, i, kVar)))) {
                return true;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", Integer.valueOf(3));
            return false;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", Integer.valueOf(i));
            return false;
        }
    }

    public final boolean cG(long j) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", Long.valueOf(j));
        if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(j)))) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", Integer.valueOf(4));
            return false;
        }
    }

    public final boolean cH(long j) {
        return false;
    }

    private boolean b(long j, p pVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", Long.valueOf(j));
        if (pVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            d(j, -1, -1, "null == aTask");
            return false;
        }
        boolean z;
        a aVar = this.lWe;
        x.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", Long.valueOf(j));
        Assert.assertNotNull(pVar);
        if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(8, new g(j, pVar)))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", new StringBuilder("mBTDeviceMrg.startTask Failed ret = -1").toString());
            d(j, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
            return false;
        } else if (a(this.lWg, j, (IInterface) pVar)) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
            d(j, -1, -1, "registerRemoteCB Fail!!!");
            return false;
        }
    }

    public final long a(p pVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
        if (pVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
            return -1;
        }
        l lVar = this.lWl;
        if (Long.MAX_VALUE == lVar.lVx) {
            x.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
            lVar.lVx = 0;
        }
        long j = lVar.lVx;
        lVar.lVx = 1 + j;
        if (this.mHandler.sendMessage(this.mHandler.obtainMessage(0, new k(j, pVar)))) {
            return j;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", Integer.valueOf(0));
        return -1;
    }

    public final boolean cI(long j) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", Long.valueOf(j));
        if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(j)))) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", Integer.valueOf(1));
            return false;
        }
    }

    public final boolean a(i iVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
        boolean register = this.lWi.register(iVar);
        if (!register) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
        }
        return register;
    }

    public final boolean b(i iVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
        boolean unregister = this.lWi.unregister(iVar);
        if (!unregister) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
        }
        return unregister;
    }

    public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        int beginBroadcast = this.lWh.beginBroadcast();
        int i4 = 0;
        while (i4 < beginBroadcast) {
            try {
                ((j) this.lWh.getBroadcastItem(i4)).a(i, i2, str, str2, str3, i3, bArr);
                if (2 == i && !this.lWh.unregister(this.lWh.getBroadcastItem(i4))) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
                }
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = " + i4);
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            i4++;
        }
        this.lWh.finishBroadcast();
    }

    private void d(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        int beginBroadcast = this.lWg.beginBroadcast();
        IInterface iInterface = (p) a(j, this.lWg, beginBroadcast);
        if (iInterface == null) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = " + j);
            this.lWg.finishBroadcast();
            return;
        }
        try {
            iInterface.aFq().a(j, i, i2, str, iInterface);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
        }
        if (!a(this.lWg, j, iInterface, beginBroadcast)) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
        }
        this.lWg.finishBroadcast();
    }

    public final void c(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        d dVar = new d();
        dVar.lVx = j;
        dVar.lPV = i;
        dVar.lPJ = i2;
        dVar.jfR = str;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, dVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", Integer.valueOf(2));
        }
    }

    public final void a(int i, long j, short s, short s2, byte[] bArr) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Short.valueOf(s);
        objArr[3] = Short.valueOf(s2);
        objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        b bVar = new b();
        bVar.lVu = s2;
        bVar.lPK = bArr;
        bVar.kGc = j;
        bVar.lPQ = s;
        bVar.mErrorCode = i;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, bVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(6));
        }
    }

    public final void b(long j, int i, int i2, int i3) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + j + " oldState" + i + " newState = " + i2 + " errCode = " + i3);
        c cVar = new c();
        cVar.kGc = j;
        cVar.lVv = i;
        cVar.lVw = i2;
        cVar.lPJ = i3;
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, cVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", Integer.valueOf(5));
        }
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", Long.valueOf(j));
        a aVar = this.lWe;
        x.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", Long.valueOf(j));
        if (!aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(10, new f(j, bArr)))) {
            x.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", Integer.valueOf(10));
        }
    }

    public final boolean a(String str, boolean z, q qVar) {
        if (VERSION.SDK_INT < 18 || this.lWn == null) {
            return false;
        }
        boolean hasSystemFeature = ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!hasSystemFeature || defaultAdapter == null) {
            return false;
        }
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        if (this.lWj.register(qVar)) {
            try {
                UUID fromString = UUID.fromString(str);
                com.tencent.mm.plugin.g.a.a.f fVar = this.lWn;
                com.tencent.mm.plugin.g.a.a.f.kBP = ad.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                String str2 = "MicroMsg.exdevice.IBeaconServer";
                String str3 = "Ranging, uuid = %s, op = %s";
                Object[] objArr = new Object[2];
                objArr[0] = fromString == null ? "" : fromString.toString();
                objArr[1] = String.valueOf(z);
                x.d(str2, str3, objArr);
                if (fromString == null) {
                    x.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                    hasSystemFeature = false;
                } else {
                    hasSystemFeature = z ? fVar.mHandler.post(new AnonymousClass6(fromString)) : fVar.mHandler.post(new AnonymousClass7(fromString));
                }
                if (hasSystemFeature) {
                    return true;
                }
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
                if (!this.lWj.unregister(qVar)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
                }
                return false;
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", e.getMessage());
                return false;
            }
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
        return false;
    }

    public final void a(double d, com.tencent.mm.plugin.g.a.a.c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
            return;
        }
        com.tencent.mm.plugin.g.a.a.h hVar = cVar.kBG.kBK;
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", Double.valueOf(d), com.tencent.mm.plugin.exdevice.j.b.ar(hVar.kCl), Short.valueOf(hVar.kCm), Short.valueOf(hVar.kCn), Integer.valueOf(hVar.kCn & 65535));
        try {
            int beginBroadcast = this.lWj.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ((q) this.lWj.getBroadcastItem(i)).a(d, hVar.kCm, hVar.kCn, hVar.kCl, cVar.kBH, cVar.kBG.kBK.kCo, cVar.bpq);
                } catch (Throwable e) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", Integer.valueOf(i), e.toString());
                    x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", e2.toString());
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
        } finally {
            this.lWj.finishBroadcast();
        }
    }

    public final void nx(int i) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", Integer.valueOf(i));
        for (int beginBroadcast = this.lWk.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_state", i);
            try {
                ((n) this.lWk.getBroadcastItem(beginBroadcast)).i(0, bundle);
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", Integer.valueOf(beginBroadcast));
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
        }
        this.lWk.finishBroadcast();
    }

    public final void a(n nVar) {
        x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
        if (!this.lWk.register(nVar)) {
            x.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
        }
    }

    public final boolean d(int i, j jVar) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", Integer.valueOf(i));
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
            return false;
        } else if (i != 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
            return false;
        } else {
            boolean register = this.lWp.register(jVar);
            if (register) {
                x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
            } else {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
            }
            if (this.lWt != null) {
                boolean z;
                com.tencent.mm.plugin.g.a.b.e eVar = this.lWt;
                x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
                if (eVar.kCz != null) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                if (eVar.arR()) {
                    z = eVar.kCz.a(true, eVar.kCC);
                    if (z) {
                        eVar.kDh.clear();
                    }
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    z = false;
                }
                if (!z) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
                    try {
                        jVar.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
                    } catch (Throwable e) {
                        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", e.getMessage());
                        x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                    if (!register) {
                        return false;
                    }
                    this.lWp.unregister(jVar);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean e(int i, j jVar) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", Integer.valueOf(i));
        if (jVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
            return false;
        } else if (this.lWt == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
            return false;
        } else {
            boolean a;
            com.tencent.mm.plugin.g.a.b.e eVar = this.lWt;
            x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
            Assert.assertTrue(eVar.kCz != null);
            if (eVar.arR()) {
                eVar.mHandler.removeCallbacks(eVar.mRunnable);
                a = eVar.kCz.a(false, eVar.kCC);
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                a = false;
            }
            if (!a) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
                try {
                    jVar.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
                } catch (Throwable e) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", e.getMessage());
                    x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                }
            }
            return a;
        }
    }

    public final boolean b(long j, int i, k kVar) {
        if (kVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        } else if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            return false;
        } else if (i != 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", Integer.valueOf(i));
            return false;
        } else {
            e eVar = new e();
            eVar.lSK = j;
            eVar.lWx = i;
            eVar.lWy = kVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(7, eVar))) {
                return true;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(7));
            return false;
        }
    }

    public final boolean cJ(long j) {
        if (j < 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j));
            return false;
        } else if (this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(j)))) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(8));
            return false;
        }
    }

    public final boolean a(s sVar) {
        if (sVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        }
        boolean register = this.lWr.register(sVar);
        if (register) {
            return register;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
        return register;
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        if (0 > j) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
            return false;
        } else if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
            return false;
        } else if (tVar == null) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
            return false;
        } else {
            i iVar = new i();
            iVar.lSK = j;
            iVar.kCs = bArr;
            iVar.lWB = tVar;
            if (this.mHandler.sendMessage(this.mHandler.obtainMessage(10, iVar))) {
                return true;
            }
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", Integer.valueOf(10));
            return false;
        }
    }

    public final boolean c(long j, int i, k kVar) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", Long.valueOf(j), Integer.valueOf(i));
        if (a(this.lWq, j, (IInterface) kVar)) {
            try {
                kVar.a(j, -1, 1, -1, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            }
            if (this.lWt != null) {
                boolean connect;
                com.tencent.mm.plugin.g.a.b.e eVar = this.lWt;
                x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", Long.valueOf(j));
                if (eVar.arR()) {
                    com.tencent.mm.plugin.g.a.b.f fVar = (com.tencent.mm.plugin.g.a.b.f) eVar.kCx.get(Long.valueOf(j));
                    if (fVar != null) {
                        x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
                        connect = fVar.connect();
                    } else {
                        fVar = new com.tencent.mm.plugin.g.a.b.f(j, eVar.tI, eVar.kDj);
                        if (fVar.connect()) {
                            eVar.t(new com.tencent.mm.plugin.g.a.b.e.AnonymousClass4(j, fVar));
                            connect = true;
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
                            connect = false;
                        }
                    }
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                    connect = false;
                }
                if (!connect) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", Long.valueOf(j));
                    if (kVar != null) {
                        try {
                            kVar.a(j, 1, 4, -1, 0);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
        try {
            kVar.a(j, -1, 4, -1, 0);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e22, "", new Object[0]);
        }
        return false;
    }

    public final boolean c(long j, byte[] bArr, t tVar) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", Long.valueOf(j), com.tencent.mm.plugin.exdevice.j.b.ar(bArr));
        if (this.lWt != null) {
            boolean z;
            com.tencent.mm.plugin.g.a.b.e eVar = this.lWt;
            x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", Long.valueOf(j));
            if (eVar.arR()) {
                com.tencent.mm.plugin.g.a.b.f fVar = (com.tencent.mm.plugin.g.a.b.f) eVar.kCx.get(Long.valueOf(j));
                if (fVar == null) {
                    x.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
                    z = false;
                } else {
                    x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.j.b.cL(fVar.mSessionId), fVar.kCP.getName());
                    z = fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(3, bArr));
                }
            } else {
                x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                z = false;
            }
            if (!z) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
                if (tVar != null) {
                    try {
                        tVar.b(j, -1, -1, "start write data error");
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
                    }
                }
                return false;
            }
        }
        if (a(this.lWs, j, (IInterface) tVar)) {
            return true;
        }
        x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
        return false;
    }

    public final boolean b(long j, int i, int i2, int i3, long j2) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        k kVar = (k) a(j, this.lWq, this.lWq.beginBroadcast());
        if (kVar == null) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            this.lWq.finishBroadcast();
            return false;
        }
        try {
            kVar.a(j, i, i2, i3, j2);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.lWq.finishBroadcast();
        }
    }

    public final boolean e(long j, int i, int i2, String str) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str);
        t tVar = (t) a(j, this.lWs, this.lWs.beginBroadcast());
        if (tVar == null) {
            x.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + j);
            this.lWs.finishBroadcast();
            return false;
        }
        try {
            tVar.b(j, i, i2, str);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
            x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            return false;
        } finally {
            this.lWs.finishBroadcast();
            return false;
        }
        return true;
    }

    public final boolean d(long j, byte[] bArr) {
        int i = 0;
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "simpleBTOnRecvImpl. mac=%d, data = %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = bArr == null ? "null" : com.tencent.mm.plugin.exdevice.j.b.ar(bArr);
        x.d(str, str2, objArr);
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "SimpleOnRecvList size = %d", Integer.valueOf(this.lWr.beginBroadcast()));
        while (i < r2) {
            try {
                s sVar = (s) this.lWr.getBroadcastItem(i);
                if (sVar != null) {
                    sVar.c(j, bArr);
                } else {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ISimpleBTOnRecv_AIDL callback is null");
                }
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onDataRecv Failed!!!");
                x.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e, "", new Object[0]);
            } finally {
                this.lWr.finishBroadcast();
            }
        }
        this.lWr.finishBroadcast();
        return true;
    }
}
