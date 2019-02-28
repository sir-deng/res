package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class p implements ICallBack {
    private static long ibr = 0;
    private static int ibs = 0;
    private final String TAG = "IPxxCallback";

    public final String getUplodLogExtrasInfo() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Device:").append(d.vHf).append(" ").append(d.vHg).append("\n");
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public final void setNewDnsDebugHostInfo(String str, int i) {
        MMLogic.setNewDnsDebugHost(str, String.valueOf(i));
    }

    public final String getCrashFilePath(int i) {
        String str = e.hbx + "crash_" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis() - (((long) i) * 86400000))) + ".txt";
        return com.tencent.mm.a.e.bO(str) ? str : null;
    }

    public final void recoverLinkAddrs() {
        MMLogic.recoverLinkAddrs();
    }

    public final void uploadLogResponse(long j, long j2) {
        int i = 100;
        int i2 = 0;
        x.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(ibs));
        long Wx = bi.Wx();
        if (Wx - 1 >= ibr) {
            ibr = Wx;
            if (j2 >= 0 && j > 0 && j2 < j) {
                i2 = (int) ((100 * j2) / j);
            }
            if (i2 <= 100) {
                i = i2;
            }
            if (ibs > i) {
                i = ibs;
            }
            ibs = i;
            iS(i);
        }
    }

    public final void uploadLogFail() {
        ibs = 0;
        iS(-1);
    }

    public final void uploadLogSuccess() {
        ibs = 0;
        iS(100);
    }

    private static void iS(int i) {
        try {
            t VX = aa.VX();
            if (VX.ibF != null) {
                try {
                    VX.ibF.en(i);
                } catch (Throwable e) {
                    x.e("MicroMsg.AutoAuth", "exception:%s", bi.i(e));
                }
            }
        } catch (Throwable e2) {
            x.e("IPxxCallback", "exception:%s", bi.i(e2));
        }
    }
}
