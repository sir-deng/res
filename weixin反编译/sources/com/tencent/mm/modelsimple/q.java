package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.aef;
import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.z;
import java.util.Iterator;
import java.util.Map;

public final class q extends k implements com.tencent.mm.network.k {
    public static String hOU;
    public static String hOV;
    public static String hOW;
    public static String hOX;
    public static String hOY;
    public static String hOZ;
    public static String hPa;
    public static String hPb;
    public static String hPc;
    public static String hPd;
    private static int hPe;
    private static int hPf = 0;
    private static int hPg = 22;
    private static int hPh = 0;
    private static boolean hPi = false;
    private e gLE;

    public static boolean iu(int i) {
        if (hPe == i) {
            return false;
        }
        return true;
    }

    public static int RX() {
        return hPf;
    }

    public static boolean RY() {
        return (hPh & 2) != 0;
    }

    public static boolean RZ() {
        return (hPg & 4) != 0;
    }

    public static void bV(boolean z) {
        if (z) {
            hPg |= 4;
        } else {
            hPg &= -5;
        }
    }

    public static int Sa() {
        return hPe;
    }

    public static boolean Sb() {
        return (hPh & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0;
    }

    public static boolean Sc() {
        return (hPh & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0;
    }

    public q(int i) {
        hPe = i;
    }

    public final int getType() {
        return 526;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        com.tencent.mm.bp.a aef = new aef();
        aef.lTZ = w.cfV();
        x.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", aef.lTZ);
        aVar.hnT = aef;
        aVar.hnU = new aeg();
        aVar.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
        aVar.hnS = 526;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLE = eVar2;
        return a(eVar, aVar.Kf(), this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aeg aeg = (aeg) ((b) qVar).hnR.hnY;
            hPf = aeg.wtx;
            x.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", Integer.valueOf(hPf), Integer.valueOf(aeg.vNC));
            Map y = bj.y(aeg.wtw, "summary");
            int i4 = hPg;
            if (y != null) {
                int i5;
                int i6;
                hOU = (String) y.get(".summary.banner");
                x.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", Integer.valueOf(aeg.wtu), aeg.wtw);
                aef aef = (aef) ((b) qVar).hnQ.hnY;
                Iterator it = aeg.wtv.iterator();
                while (it.hasNext()) {
                    auo auo = (auo) it.next();
                    if (auo.vRQ.cec().hashCode() != aef.wQE.vRQ.cec().hashCode()) {
                        Map y2 = bj.y(auo.wJj, "wording");
                        x.d("MicroMsg.NetSceneGetOnlineInfo", auo.wJj);
                        if (y2 != null) {
                            hOV = (String) y2.get(".wording.title");
                            hOW = (String) y2.get(".wording.notify");
                            hOX = (String) y2.get(".wording.mute_title");
                            hOY = (String) y2.get(".wording.mute_tips");
                            hOZ = (String) y2.get(".wording.exit");
                            hPa = (String) y2.get(".wording.exit_confirm");
                            hPb = (String) y2.get(".wording.lock_title");
                            hPc = (String) y2.get(".wording.mute_lock_title");
                            hPd = (String) y2.get(".wording.exit");
                        }
                        i5 = auo.wJl;
                        i6 = aeg.vNC;
                        hPh = i6;
                        if ((i6 & 2) != 0) {
                            hPi = true;
                        } else {
                            hPi = false;
                        }
                        if (i5 != hPg) {
                            hPg = i5;
                            as.Hm();
                            c.CB();
                        }
                    }
                }
                i5 = i4;
                i6 = aeg.vNC;
                hPh = i6;
                if ((i6 & 2) != 0) {
                    hPi = false;
                } else {
                    hPi = true;
                }
                if (i5 != hPg) {
                    hPg = i5;
                    as.Hm();
                    c.CB();
                }
            }
            if ((aeg.vNC & 64) != 0) {
                as.Hm();
                ag Xv = c.Ff().Xv("filehelper");
                if (Xv == null || bi.oN(Xv.field_username)) {
                    z.w(Xv);
                    as.Hm();
                    Xv = c.Ff().Xv("filehelper");
                }
                if (!(Xv == null || com.tencent.mm.k.a.ga(Xv.field_type))) {
                    Xv.An();
                    as.Hm();
                    c.Ff().a(Xv.field_username, Xv);
                }
                as.Hm();
                ae XF = c.Fk().XF("filehelper");
                if (XF == null) {
                    XF = new ae("filehelper");
                    XF.aj(bi.Wy());
                    as.Hm();
                    c.Fk().d(XF);
                } else {
                    XF.aj(bi.Wy());
                    as.Hm();
                    c.Fk().a(XF, "filehelper");
                }
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
