package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.f.a.dl;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.model.d.AnonymousClass4;
import com.tencent.mm.plugin.exdevice.service.q.a;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a {
    private static e lVR = new e();

    private e() {
    }

    public static e aFj() {
        return lVR;
    }

    public final boolean ai(final String str, final boolean z) {
        x.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        if (str == null) {
            x.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
            return false;
        } else if (u.aFt().lQh != null) {
            return u.aFt().lQh.a(str, z, (q) this);
        } else {
            x.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
            d aEY = ad.aEY();
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    if (u.aFt().lQh != null) {
                        u.aFt().lQh.a(str, z, e.this);
                    }
                }
            };
            x.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
            if (aEY.lQm == null) {
                aEY.lQm = new c();
                aEY.lQm.lVO = new AnonymousClass4(anonymousClass1);
                aEY.lQm.cy(com.tencent.mm.sdk.platformtools.ad.getContext());
                return false;
            }
            aEY.lQm.v(anonymousClass1);
            return false;
        }
    }

    public final void a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
        x.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), b.ar(bArr), Double.valueOf(d2), str, Integer.valueOf(i3));
        com.tencent.mm.sdk.b.b dlVar = new dl();
        String ar = b.ar(bArr);
        if (ar.length() >= 32) {
            ar = ar.substring(0, 8) + "-" + ar.substring(8, 12) + "-" + ar.substring(12, 16) + "-" + ar.substring(16, 20) + "-" + ar.substring(20);
        }
        dlVar.fsT.fsR = ar;
        dlVar.fsT.fsW = d;
        dlVar.fsT.fsU = i;
        dlVar.fsT.fsV = i2;
        dlVar.fsT.fsX = d2;
        dlVar.fsT.fsY = str;
        dlVar.fsT.fsZ = i3;
        com.tencent.mm.sdk.b.a.xmy.m(dlVar);
    }
}
