package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae extends w {
    List<String> vly;

    public ae(List<String> list) {
        a aVar = new a();
        aVar.hnT = new yk();
        aVar.hnU = new yl();
        aVar.uri = "/cgi-bin/micromsg-bin/getappsetting";
        aVar.hnS = com.tencent.mm.plugin.appbrand.game.d.a.CTRL_INDEX;
        this.lSH = aVar.Kf();
        this.vly = list;
        x.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + list.size());
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (str != null && str.length() > 0) {
                df dfVar = new df();
                dfVar.nkU = str;
                linkedList.add(dfVar);
            }
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
        }
        yk ykVar = (yk) this.lSH.hnQ.hnY;
        ykVar.wpD = linkedList;
        ykVar.wpC = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            yl ylVar = (yl) this.lSH.hnR.hnY;
            x.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + ylVar.wpC);
            LinkedList linkedList = ylVar.wpE;
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
                return;
            }
            i biT = com.tencent.mm.plugin.y.a.biT();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                de deVar = (de) it.next();
                f aZ = g.aZ(deVar.nkU, false);
                if (aZ != null) {
                    aZ.field_authFlag = deVar.vPc;
                    aZ.field_openId = deVar.nng;
                    x.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + biT.a(aZ, new String[0]) + ", appId = " + deVar.nkU);
                }
            }
            return;
        }
        x.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
    }

    public final byte[] aRE() {
        try {
            return ((b) this.lSH.Kh()).Hw();
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
            return null;
        }
    }

    public final void az(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
            return;
        }
        try {
            this.lSH.hnR.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 1;
    }
}
