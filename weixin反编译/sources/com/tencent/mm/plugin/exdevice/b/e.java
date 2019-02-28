package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.exdevice.e.f;
import com.tencent.mm.plugin.exdevice.e.g;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.CRC32;

public final class e extends d {
    public e(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        x.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    protected final a ap(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
            return null;
        }
        a fVar = new f();
        try {
            fVar.aH(bArr);
            x.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
            this.lPO = fVar;
            return fVar;
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + e.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        int[] iArr;
        int i4;
        int i5;
        x.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", Integer.valueOf(i), str, b.ar(bArr), b.ar(bArr2), Integer.valueOf(i2), Integer.valueOf(i3));
        a gVar = new g();
        gVar.lUt = aa(0, "ok");
        String FY = q.FY();
        if (bi.oN(FY)) {
            iArr = null;
        } else {
            long j;
            FY = ac.VF(FY).toLowerCase();
            x.i("MicroMsg.exdevice.Util", "user md5 : [%s]", FY);
            if (bi.oN(FY)) {
                x.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
                j = 0;
            } else {
                i4 = 0;
                char[] toCharArray = FY.toCharArray();
                if (toCharArray.length > 0) {
                    for (char c : toCharArray) {
                        i4 = (i4 * 31) + c;
                    }
                }
                x.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", Integer.valueOf(i4), Long.valueOf(((long) i4) & 4294967295L));
                j = r4;
            }
            iArr = new int[]{(int) ((j >> 32) & 4294967295L), (int) (j & 4294967295L)};
        }
        gVar.lUg = iArr[0];
        gVar.lUh = iArr[1];
        if (!bi.by(bArr2)) {
            if (bArr2 == null || bArr2.length == 0) {
                i5 = 0;
            } else {
                CRC32 crc32 = new CRC32();
                crc32.update(bArr2);
                i5 = (int) crc32.getValue();
            }
            gVar.lUi = i5;
        }
        if (!bi.by(bArr)) {
            if ((bArr[0] & 4) != 0) {
                gVar.kyL = d.vHf;
            }
            if ((bArr[0] & 8) != 0) {
                gVar.lUn = d.vHi;
            }
            if ((bArr[0] & 2) != 0) {
                gVar.lUm = 2;
            }
            if ((bArr[0] & 16) != 0) {
                gVar.lUo = (int) bi.Wx();
            }
            if ((bArr[0] & 32) != 0) {
                TimeZone timeZone = TimeZone.getDefault();
                i4 = timeZone.getRawOffset() / 1000;
                i5 = (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) ? 1 : 0;
                x.i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf((i4 / 3600) + i5));
                gVar.lUp = r4;
            }
            if ((bArr[0] & 64) != 0) {
                gVar.lUq = b.aGe();
            }
            if ((bArr[0] & 1) != 0) {
                gVar.lUl = q.Ga();
            }
        }
        gVar.lUj = i2;
        gVar.lUk = i3;
        this.lPN = gVar;
        this.lPL = (short) 20003;
    }
}
