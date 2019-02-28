package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.debugger.p.AnonymousClass8;
import com.tencent.mm.protocal.c.bwx;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class o {
    public static h rF(String str) {
        x.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", str);
        h hVar = new h();
        if (!bi.oN(str)) {
            try {
                JSONObject fA = g.fA(str);
                hVar.iTD = fA.optBoolean("open_remote", false);
                hVar.iTE = fA.optString("room_id");
                hVar.iTF = fA.optString("wxpkg_info");
                hVar.iTG = fA.optString("qrcode_id");
                hVar.iTH = fA.optInt("remote_network_type", 1);
                hVar.iRx = fA.optBoolean("disable_url_check", true);
                hVar.iTI = fA.optInt("remote_proxy_port", 9976);
            } catch (Exception e) {
                x.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", e);
            }
        }
        return hVar;
    }

    public static ByteBuffer c(a aVar) {
        try {
            return ByteBuffer.wrap(aVar.toByteArray());
        } catch (IOException e) {
            x.w("MicroMsg.RemoteDebugUtil", e.getMessage());
            return ByteBuffer.allocate(0);
        }
    }

    private static b d(a aVar) {
        try {
            return b.be(aVar.toByteArray());
        } catch (IOException e) {
            x.w("MicroMsg.RemoteDebugUtil", e.getMessage());
            return b.be(new byte[0]);
        }
    }

    public static j a(a aVar, g gVar, String str) {
        bxc bxc = new bxc();
        try {
            bxc.wgG = b.be(aVar.toByteArray());
        } catch (IOException e) {
            x.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", e);
        }
        bxc.hQv = gVar.iTm.incrementAndGet();
        if (gVar.iTo == 0) {
            bxc.xeJ = 0;
        } else {
            bxc.xeJ = (int) (System.currentTimeMillis() - gVar.iTo);
        }
        gVar.iTo = System.currentTimeMillis();
        bxc.category = str;
        x.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", Integer.valueOf(bxc.hQv));
        j jVar = new j();
        jVar.iTe = System.currentTimeMillis();
        jVar.iTT = bxc.wgG.oz.length;
        jVar.iTS = bxc;
        return jVar;
    }

    public static bxb a(int i, a aVar) {
        bxb bxb = new bxb();
        bxb.pK = i;
        bxb.njL = q.getDeviceID(ad.getContext()) + "-" + System.currentTimeMillis();
        bxb.wgG = d(aVar);
        return bxb;
    }

    public static boolean a(g gVar, int i, bwx bwx, p pVar, k kVar) {
        if (bwx == null) {
            x.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", Integer.valueOf(i));
            return false;
        }
        x.d("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, errorCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(bwx.fun), bwx.fuo);
        if (i == 1006) {
            if (-50011 == bwx.fun) {
                gVar.cw(true);
            } else {
                boolean isBusy = gVar.isBusy();
                gVar.cw(false);
                if (isBusy) {
                    kVar.acH();
                }
            }
        }
        if (bwx.fun == 0) {
            return true;
        }
        if (!(-50001 == bwx.fun || -50002 == bwx.fun || -50003 == bwx.fun || -50004 == bwx.fun || -50005 == bwx.fun || -50006 == bwx.fun || -50010 == bwx.fun)) {
            int i2 = bwx.fun;
        }
        ah.y(new AnonymousClass8(i, bwx));
        return false;
    }
}
