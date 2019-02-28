package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.e;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Iterator;

public final class a {
    private static String filename = "heavy_user_id_mapping.dat";
    private static Object lock = new Object();
    private a pVL;
    private int pVM;
    private int pVN;
    private int pVO;
    private int pVP;

    public interface a {
    }

    public a() {
        this.pVL = null;
        this.pVM = 0;
        this.pVN = 1;
        this.pVO = 2;
        this.pVP = 3;
        this.pVL = null;
    }

    private static void a(akq akq, boolean z) {
        Iterator it;
        atb atb;
        if (z) {
            x.i("MicroMsg.HeavyUserIDMappingStg", "################################# svr heavy user strategy #############################");
            x.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + akq.wyx + ", ret:" + akq.wyz);
            it = akq.wyy.iterator();
            while (it.hasNext()) {
                atb = (atb) it.next();
                x.i("MicroMsg.HeavyUserIDMappingStg", "origin:" + atb.wHp + ", userid:" + atb.wHq);
            }
            x.i("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
            return;
        }
        x.d("MicroMsg.HeavyUserIDMappingStg", "################################# Local heavy user strategy #############################");
        x.d("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + akq.wyx + ", ret:" + akq.wyz);
        it = akq.wyy.iterator();
        while (it.hasNext()) {
            atb = (atb) it.next();
            x.d("MicroMsg.HeavyUserIDMappingStg", "origin:" + atb.wHp + ", userid:" + atb.wHq);
        }
        x.d("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
    }

    public final void a(akq akq, int i) {
        x.i("MicroMsg.HeavyUserIDMappingStg", "saveIDMapping, channel:" + i);
        int i2;
        if (akq == null) {
            x.w("MicroMsg.HeavyUserIDMappingStg", "HeavyUserRespInfo is null");
        } else if (this.pVM != akq.wyz) {
            String str = "MicroMsg.HeavyUserIDMappingStg";
            StringBuilder stringBuilder = new StringBuilder("heavyUserRespInfo.RespType Unnormal, type:");
            i2 = akq.wyz;
            String str2 = this.pVN == i2 ? "服务器过载" : this.pVO == i2 ? "服务器没有配置表" : this.pVP == i2 ? "服务器配置表错误" : "非法的错误类型";
            x.e(str, stringBuilder.append(str2).append(",version:").append(akq.wyx).toString());
        } else {
            i2 = vP(i);
            int i3 = akq.wyx;
            if (i2 == i3) {
                x.d("MicroMsg.HeavyUserIDMappingStg", "client has same version with Srv, version:" + i3);
                return;
            }
            x.i("MicroMsg.HeavyUserIDMappingStg", "version changed, client:" + vP(i) + ", svr:" + i3);
            a(akq, true);
            try {
                byte[] toByteArray = akq.toByteArray();
                synchronized (lock) {
                    x.i("MicroMsg.HeavyUserIDMappingStg", "new version:" + akq.wyx);
                    e.a(w.hbv, filename, toByteArray);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
            }
        }
    }

    public static akq boJ() {
        byte[] e;
        x.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
        synchronized (lock) {
            e = e.e(w.hbv + filename, 0, -1);
        }
        if (e == null) {
            x.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
            return null;
        }
        akq akq = new akq();
        try {
            akq.aH(e);
            a(akq, false);
            return akq;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e2, "", new Object[0]);
            return null;
        }
    }

    public final int vP(int i) {
        x.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:" + i);
        akq boJ = boJ();
        if (boJ == null) {
            return 0;
        }
        int i2 = boJ.wyx;
        x.i("MicroMsg.HeavyUserIDMappingStg", "version:" + i2);
        return i2;
    }
}
