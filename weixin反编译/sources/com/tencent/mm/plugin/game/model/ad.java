package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ad {
    public static d a(e eVar) {
        d dVar = null;
        if (eVar == null) {
            x.e("MicroMsg.GamePBData", "Invalid pb object");
        } else if (bi.oN(eVar.nkU)) {
            x.e("MicroMsg.GamePBData", "No AppID field, abort");
        } else {
            x.i("MicroMsg.GamePBData", "Parsing AppID: %s", eVar.nkU);
            dVar = new d();
            dVar.field_appId = eVar.nkU;
            dVar.field_appName = eVar.nkW;
            dVar.field_appIconUrl = eVar.nkV;
            dVar.field_appType = ",1,";
            dVar.field_packageName = eVar.nkY;
            dVar.field_appVersion = eVar.kzy;
            dVar.field_appInfoFlag = eVar.nlb;
            if (eVar.nla != null) {
                dVar.cO(eVar.nla.nlM);
                dVar.cR(eVar.nla.nlN);
                dVar.ev(eVar.nla.nlQ);
                dVar.cS(eVar.nla.nlO);
                dVar.ngS = eVar.nla.nlS;
                dVar.ngT = (long) eVar.nla.nlR;
                dVar.fxC = eVar.nla.nlT;
            }
            if (!(eVar.nla == null || eVar.nla.nlP == null)) {
                dVar.cX(eVar.nla.nlP.nlM);
                dVar.cY(eVar.nla.nlP.nqg);
                dVar.cV(eVar.nla.nlP.nqh);
                dVar.cW(eVar.nla.nlP.nqi);
                dVar.ew(eVar.nla.nlP.nqk);
            }
            dVar.ngz = eVar.nkL;
            dVar.ngy = eVar.nkX;
            dVar.status = eVar.kyY;
            dVar.ngB = eVar.nkQ;
            dVar.versionCode = eVar.nkZ;
            dVar.fpi = eVar.nkS;
            dVar.ngD = eVar.nlc;
            dVar.ngL = eVar.nlh;
            if (!(eVar.nla == null || eVar.nla.nlP == null)) {
                dVar.ngE = eVar.nla.nlP.nqj;
                dVar.ngF = eVar.nla.nlP.nql;
                dVar.ngG = eVar.nla.nlP.nqm;
            }
            dVar.hvd = eVar.nlj;
            dVar.ngU = eVar.nlk;
        }
        return dVar;
    }
}
