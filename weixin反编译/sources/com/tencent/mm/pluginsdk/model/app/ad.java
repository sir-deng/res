package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad extends w {
    private static final String[] vlx = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};

    public ad(List<String> list) {
        int i = 0;
        a aVar = new a();
        aVar.hnT = new yg();
        aVar.hnU = new yh();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfolist";
        aVar.hnS = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.a.CTRL_INDEX;
        this.lSH = aVar.Kf();
        yg ygVar = (yg) this.lSH.hnQ.hnY;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                if (!bi.oN(str)) {
                    linkedList.add(n.oK(str));
                }
                i++;
            }
        }
        ygVar.wpy = linkedList;
        ygVar.kyA = linkedList.size();
    }

    public final int getType() {
        return 7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((yh) this.lSH.hnR.hnY).wpz;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    hl hlVar = (hl) it.next();
                    if (hlVar != null) {
                        a(g.aZ(hlVar.nlV, false), hlVar);
                    }
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
    }

    private static void a(f fVar, hl hlVar) {
        boolean z;
        int i = 0;
        if (fVar == null) {
            fVar = new f();
            fVar.field_appId = hlVar.nlV;
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", hlVar.nlV, Integer.valueOf(hlVar.nlb), Long.valueOf(hlVar.vTW));
        x.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_status), Integer.valueOf(fVar.field_appInfoFlag));
        if (!fVar.bZq() || bi.oN(fVar.field_appName)) {
            fVar.field_appName = hlVar.nkW;
        }
        if (!fVar.bZq() || bi.oN(fVar.field_appName_en)) {
            fVar.field_appName_en = hlVar.vTI;
        }
        if (!fVar.bZq() || bi.oN(fVar.field_appName_tw)) {
            fVar.field_appName_tw = hlVar.vTK;
        }
        fVar.field_appDiscription = hlVar.vPF;
        fVar.field_appDiscription_en = hlVar.vTJ;
        fVar.field_appDiscription_tw = hlVar.vTL;
        fVar.field_appWatermarkUrl = hlVar.vTP;
        fVar.field_packageName = hlVar.vMN;
        fVar.field_signature = p.So(hlVar.vTQ);
        x.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", hlVar.vTQ, fVar.field_signature);
        fVar.field_appType = hlVar.vPL;
        if (!bi.oN(fVar.field_appType) && (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6"))) {
            fVar.field_appType = "," + fVar.field_appType;
        }
        fVar.field_appInfoFlag = hlVar.nlb;
        fVar.field_appVersion = hlVar.vTR;
        fVar.cN(hlVar.vPN);
        fVar.field_appWatermarkUrl = hlVar.vTP;
        if (!(bi.oN(hlVar.vTU) || bi.oN(hlVar.vTV))) {
            x.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", fVar.field_appName, hlVar.vTU, hlVar.vTV);
            fVar.cO(hlVar.vTU);
            fVar.cR(hlVar.vTV);
        }
        fVar.cS(hlVar.vMO);
        fVar.field_svrAppSupportContentType = hlVar.vTW;
        if (hlVar.vTS > fVar.fRy) {
            fVar.fRz = 1;
            fVar.fQS = true;
        }
        fVar.fRy = hlVar.vTS;
        fVar.fQS = true;
        String str = hlVar.vMN;
        String str2 = hlVar.vMN;
        int i2 = (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? true : 0;
        if (i2 != 0) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + hlVar.vMN + "appid: " + fVar.field_appId);
        }
        if (fVar.YI()) {
            b.Tq(fVar.field_appId);
        }
        i biT = com.tencent.mm.plugin.y.a.biT();
        if (z) {
            fVar.field_status = i2 != 0 ? 3 : 4;
            fVar.field_modifyTime = System.currentTimeMillis();
            fVar.field_appIconUrl = hlVar.vTN;
            if (fVar.field_appId != null) {
                while (i < vlx.length) {
                    if (fVar.field_appId.equals(vlx[i])) {
                        fVar.field_status = -1;
                        break;
                    }
                    i++;
                }
            }
            if (biT.l(fVar)) {
                com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 1);
                com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 2);
                com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 3);
                com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 4);
                com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 5);
                return;
            }
            x.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
            return;
        }
        fVar.field_status = i2 != 0 ? 3 : fVar.field_status;
        if (fVar.field_appId != null) {
            for (Object equals : vlx) {
                if (fVar.field_appId.equals(equals)) {
                    fVar.field_status = -1;
                    break;
                }
            }
        }
        z = (fVar == null || fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? true : (hlVar == null || hlVar.vTT == null || hlVar.vTT.length() == 0) ? false : !fVar.field_appIconUrl.equals(hlVar.vTN);
        if (z) {
            x.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", fVar.field_appIconUrl, hlVar.vTN);
            fVar.field_appIconUrl = hlVar.vTN;
            z = biT.a(fVar, new String[0]);
            com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 1);
            com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 2);
            com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 3);
            com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 4);
            com.tencent.mm.plugin.y.a.biR().cS(fVar.field_appId, 5);
        } else {
            z = biT.a(fVar, new String[0]);
        }
        x.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + z + ", appid = " + hlVar.nlV);
    }

    public final byte[] aRE() {
        try {
            return ((com.tencent.mm.ad.b.b) this.lSH.Kh()).Hw();
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void az(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
            return;
        }
        try {
            this.lSH.hnR.E(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", e, "", new Object[0]);
        }
    }
}
