package com.tencent.mm.plugin.game.d;

import com.tencent.mm.plugin.y.a.a.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    public static void a(f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.GameDataUtil", "Null appInfo");
        } else if (bi.oN(fVar.field_appId)) {
            x.e("MicroMsg.GameDataUtil", "Invalid appId");
        } else {
            f fVar2;
            boolean z;
            boolean l;
            String str = fVar.field_appId;
            f aZ = g.aZ(str, true);
            if (aZ == null) {
                aZ = new f();
                aZ.field_appId = str;
                fVar2 = aZ;
                z = true;
            } else {
                fVar2 = aZ;
                z = false;
            }
            String cfV = w.cfV();
            if (cfV.equals("zh_CN")) {
                fVar2.field_appName = fVar.field_appName;
            } else if (cfV.equals("zh_TW") || cfV.equals("zh_HK")) {
                fVar2.field_appName_tw = fVar.field_appName;
            } else {
                fVar2.field_appName_en = fVar.field_appName;
            }
            fVar2.field_appType = fVar.field_appType;
            fVar2.field_packageName = fVar.field_packageName;
            fVar2.cO(fVar.fRx);
            fVar2.cR(fVar.fRC);
            fVar2.ev(fVar.fRG);
            fVar2.cS(fVar.fRD);
            fVar2.cX(fVar.fRJ);
            fVar2.cY(fVar.fRK);
            fVar2.cV(fVar.fRH);
            fVar2.cW(fVar.fRI);
            fVar2.ew(fVar.fRM);
            if (!bi.oN(fVar.fRA)) {
                fVar2.cP(fVar.fRA);
            }
            if (z) {
                l = an.biT().l(fVar2);
                a.biY().HM(str);
            } else if (fVar2.field_appVersion < fVar.field_appVersion) {
                x.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", Integer.valueOf(fVar2.field_appVersion), Integer.valueOf(fVar.field_appVersion));
                l = an.biT().a(fVar2, new String[0]);
                a.biY().HM(str);
            } else {
                boolean z2 = (fVar2 == null || bi.oN(fVar2.field_appIconUrl)) ? true : (fVar == null || bi.oN(fVar.field_appIconUrl)) ? false : !fVar2.field_appIconUrl.equals(fVar.field_appIconUrl);
                if (z2) {
                    x.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", fVar2.field_appIconUrl, fVar.field_appIconUrl);
                    fVar2.field_appIconUrl = fVar.field_appIconUrl;
                    l = an.biT().a(fVar2, new String[0]);
                    an.biR().cS(str, 1);
                    an.biR().cS(str, 2);
                    an.biR().cS(str, 3);
                    an.biR().cS(str, 4);
                    an.biR().cS(str, 5);
                } else {
                    l = an.biT().a(fVar2, new String[0]);
                }
            }
            x.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", str, Boolean.valueOf(z), Boolean.valueOf(l));
        }
    }

    public static void V(LinkedList<? extends f> linkedList) {
        if (linkedList == null) {
            x.e("MicroMsg.GameDataUtil", "Null appInfos");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a((f) it.next());
        }
    }
}
