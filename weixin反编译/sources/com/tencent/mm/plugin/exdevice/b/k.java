package com.tencent.mm.plugin.exdevice.b;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.f.b.br;
import com.tencent.mm.plugin.exdevice.i.h;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.bhb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;
import junit.framework.Assert;

public final class k implements com.tencent.mm.ad.e {
    public static k lPS = null;
    private final HashMap<Long, e> lPR;
    public HashMap<String, Integer> lPT;
    public ag mHandler;

    private static final class b {
        public String jfR;
        public int lPJ;
        public int lPV;
        public com.tencent.mm.ad.k lPW;

        private b() {
            this.lPJ = 0;
            this.lPV = 0;
            this.jfR = null;
            this.lPW = null;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class c {
        public byte[] kCs;
        public long mSessionId;

        private c() {
            this.mSessionId = 0;
            this.kCs = null;
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    private static final class e {
        f lPY;
        private d lPZ;
        int lQa;

        private e() {
            this.lPY = null;
            this.lPZ = null;
            this.lQa = 0;
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public final void a(f fVar) {
            Assert.assertNotNull(fVar);
            this.lPY = fVar;
        }

        public final void a(d dVar) {
            Assert.assertNotNull(dVar);
            this.lPZ = dVar;
        }

        public final f aEt() {
            Assert.assertNotNull(this.lPY);
            return this.lPY;
        }

        public final d aEu() {
            Assert.assertNotNull(this.lPZ);
            return this.lPZ;
        }
    }

    public static final class f {
        private static f lQc = null;
        private long lQb;

        public f() {
            long j = 0;
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("local_message_seq", 0);
                x.i("MicroMsg.exdevice.Util", "lasted seq id is %d", Long.valueOf(j));
            }
            this.lQb = j;
        }

        public static long aEv() {
            if (lQc == null) {
                lQc = new f();
            }
            f fVar = lQc;
            if (Long.MAX_VALUE == fVar.lQb) {
                x.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
                fVar.lQb = 0;
            }
            long j = fVar.lQb + 1;
            fVar.lQb = j;
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                x.i("MicroMsg.exdevice.Util", "save locall seq id : %d", Long.valueOf(j));
                sharedPreferences.edit().putLong("local_message_seq", j).commit();
            }
            return j;
        }
    }

    private final class d implements Runnable {
        private long lPX = -1;

        public d(long j) {
            Assert.assertTrue(j >= 0);
            this.lPX = j;
        }

        public final void run() {
            x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", Long.valueOf(this.lPX));
            k.this.mHandler.obtainMessage(0, Long.valueOf(this.lPX)).sendToTarget();
        }
    }

    private class a extends ag {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", Integer.valueOf(message.what));
            e eVar;
            switch (message.what) {
                case 0:
                    long longValue = ((Long) message.obj).longValue();
                    e eVar2 = (e) k.this.lPR.get(Long.valueOf(longValue));
                    if (eVar2 == null) {
                        x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", Long.valueOf(longValue));
                        return;
                    }
                    eVar2.aEt().b(-1, "", null);
                    u.aFt().a(new h(eVar2.aEt()));
                    k.this.lPR.remove(Long.valueOf(longValue));
                    return;
                case 1:
                    f fVar = (f) message.obj;
                    if (!u.aFs().cE(fVar.kGc)) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", Long.valueOf(fVar.kGc));
                        fVar.b(-2, "", new byte[0]);
                        u.aFt().a(new h(fVar));
                        return;
                    } else if (-5 == message.arg1 || -3 == message.arg1 || -4 == message.arg1) {
                        x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(message.arg1));
                        fVar.b(-1, "", new byte[0]);
                        u.aFt().a(new h(fVar));
                        return;
                    } else {
                        br zL = com.tencent.mm.plugin.exdevice.model.ad.aER().zL(fVar.kGc);
                        if (zL == null) {
                            x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                            return;
                        }
                        if (System.currentTimeMillis() / 1000 < ((long) zL.ggI)) {
                            x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
                            fVar.b(-5, "Device Is Block", null);
                            u.aFt().a(new h(fVar));
                            return;
                        }
                        long aEv = f.aEv();
                        com.tencent.mm.plugin.exdevice.e.k kVar = (com.tencent.mm.plugin.exdevice.e.k) fVar.aEq();
                        if (kVar == null) {
                            x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
                            fVar.b(-4, "Decode failed", null);
                            u.aFt().a(new h(fVar));
                            return;
                        }
                        Integer num = (Integer) k.this.lPT.get(zL.field_deviceID);
                        if (num == null) {
                            num = Integer.valueOf(0);
                        }
                        x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", num);
                        d dVar;
                        e eVar3;
                        if (num.intValue() != 0) {
                            if ((num.intValue() & 1) != 0) {
                                com.tencent.mm.plugin.exdevice.model.ad.aFc();
                                com.tencent.mm.plugin.exdevice.model.e.c(zL.field_deviceID, zL.field_brandName, kVar.kyn.toByteArray());
                            }
                            if ((num.intValue() & 2) != 0) {
                                as.CN().a(new w(fVar.kGc, zL.field_deviceType, zL.field_deviceID, aEv, bi.Wy(), kVar.kyn.toByteArray(), kVar.kzz), 0);
                                dVar = new d(aEv);
                                k.this.mHandler.postDelayed(dVar, 30000);
                                eVar3 = new e();
                                eVar3.a(fVar);
                                eVar3.a(dVar);
                                eVar3.lQa = 0;
                                k.this.lPR.put(Long.valueOf(aEv), eVar3);
                                return;
                            }
                            return;
                        } else if (kVar.kzz == 10001) {
                            com.tencent.mm.plugin.exdevice.model.ad.aFc();
                            com.tencent.mm.plugin.exdevice.model.e.c(zL.field_deviceID, zL.field_brandName, kVar.kyn.toByteArray());
                            return;
                        } else {
                            as.CN().a(new w(fVar.kGc, zL.field_deviceType, zL.field_deviceID, aEv, bi.Wy(), kVar.kyn.toByteArray(), kVar.kzz), 0);
                            dVar = new d(aEv);
                            k.this.mHandler.postDelayed(dVar, 30000);
                            eVar3 = new e();
                            eVar3.a(fVar);
                            eVar3.a(dVar);
                            eVar3.lQa = 0;
                            k.this.lPR.put(Long.valueOf(aEv), eVar3);
                            return;
                        }
                    }
                case 2:
                    b bVar = (b) message.obj;
                    if (bVar.lPV != 0 || bVar.lPJ != 0) {
                        w wVar = (w) bVar.lPW;
                        Assert.assertNotNull(wVar.lSH);
                        long j = ((bhb) wVar.lSH.hnQ.hnY).wSt.wym;
                        eVar = (e) k.this.lPR.get(Long.valueOf(j));
                        if (eVar == null) {
                            x.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", Long.valueOf(j));
                            return;
                        }
                        int i;
                        f aEt = eVar.aEt();
                        switch (bVar.lPJ) {
                            case -417:
                                i = -5;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                        aEt.b(i, bVar.jfR, null);
                        u.aFt().a(new h(eVar.aEt()));
                        k.this.mHandler.removeCallbacks(eVar.aEu());
                        k.this.lPR.remove(Long.valueOf(j));
                        return;
                    }
                    return;
                case 3:
                    c cVar = (c) message.obj;
                    eVar = (e) k.this.lPR.get(Long.valueOf(cVar.mSessionId));
                    if (eVar == null) {
                        x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", Long.valueOf(cVar.mSessionId));
                        return;
                    }
                    eVar.lPY.b(0, "", cVar.kCs);
                    u.aFt().a(new h(eVar.aEt()));
                    k.this.mHandler.removeCallbacks(eVar.aEu());
                    k.this.lPR.remove(Long.valueOf(cVar.mSessionId));
                    return;
                default:
                    x.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", Integer.valueOf(message.what));
                    return;
            }
        }
    }

    public static k aEs() {
        if (lPS != null) {
            return lPS;
        }
        k kVar = new k();
        lPS = kVar;
        return kVar;
    }

    private k() {
        this.lPR = new HashMap();
        this.mHandler = null;
        this.lPT = new HashMap();
        this.mHandler = new a(as.Dt().oFY.getLooper());
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        b bVar = new b();
        bVar.lPJ = i2;
        bVar.lPV = i;
        bVar.jfR = str;
        bVar.lPW = kVar;
        this.mHandler.obtainMessage(2, bVar).sendToTarget();
    }
}
