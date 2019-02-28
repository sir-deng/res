package com.tencent.mm.av;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bpi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;

public final class d implements e {
    public a hKe = null;

    public interface a {
        void c(ay ayVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.NewTipsManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 597 && i == 0 && i2 == 0) {
            boolean z = ((a) kVar).hJN;
            ay DK = com.tencent.mm.plugin.x.a.bfT().DK(((a) kVar).hJO);
            if (DK != null) {
                DK.field_isReject = z;
                x.i("MicroMsg.NewTipsManager", "Newtips push is reject: %s", Boolean.valueOf(z));
                com.tencent.mm.plugin.x.a.bfT().a(DK, new String[0]);
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, String str2) {
        ay DK = com.tencent.mm.plugin.x.a.bfT().DK(i);
        if (DK == null) {
            DK = new ay();
            DK.field_tipId = i;
            DK.field_tipVersion = 1;
            DK.field_tipkey = str;
            DK.field_tipType = i3;
            if (DK.field_tipsShowInfo == null) {
                DK.field_tipsShowInfo = new bpi();
            }
            DK.field_tipsShowInfo.path = str2;
            com.tencent.mm.plugin.x.a.bfT().d(DK);
            if (i3 != b.hJP) {
                return;
            }
            if (!DK.field_isExit || 1 != DK.field_tipVersion) {
                g.CN().a(new a(i, 1, str), 0);
                x.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
                return;
            }
            return;
        }
        if (i3 == b.hJP && !(DK.field_isExit && 1 == DK.field_tipVersion)) {
            g.CN().a(new a(i, 1, str), 0);
            x.d("MicroMsg.NewTipsManager", "dancy doScene NetScenePushNewTips！！");
        }
        if ((i3 == b.hJP && 1 != DK.field_tipVersion) || (i3 == b.hJQ && DK.field_tipVersion <= 0)) {
            DK.field_tipId = i;
            DK.field_tipVersion = 1;
            DK.field_tipkey = str;
            DK.field_tipType = i3;
            DK.field_isExit = false;
            if (DK.field_tipsShowInfo == null) {
                DK.field_tipsShowInfo = new bpi();
            }
            DK.field_tipsShowInfo.path = str2;
            com.tencent.mm.plugin.x.a.bfT().a(DK, new String[0]);
        }
    }

    public static void ik(int i) {
        ay DK = com.tencent.mm.plugin.x.a.bfT().DK(i);
        if (DK == null) {
            x.e("MicroMsg.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
            return;
        }
        x.i("MicroMsg.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", Integer.valueOf(i), Boolean.valueOf(true));
        if (DK.field_tipType == b.hJP) {
            DK.field_hadRead = true;
            com.tencent.mm.plugin.x.a.bfT().a(DK, new String[0]);
        }
        if (DK.field_tipType == b.hJQ) {
            az bfT = com.tencent.mm.plugin.x.a.bfT();
            String str = "delete from NewTipsInfo where tipId = " + DK.field_tipId;
            x.i("MicroMsg.NewTipsInfoStorage", "delete sql: " + str);
            bfT.gLA.fD("NewTipsInfo", str);
            bfT.b(DK.field_tipId, 5, Integer.valueOf(DK.field_tipId));
        }
    }
}
