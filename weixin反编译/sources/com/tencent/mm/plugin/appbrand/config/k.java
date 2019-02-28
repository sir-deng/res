package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.ccw;
import com.tencent.mm.protocal.c.go;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class k extends com.tencent.mm.ad.a<gp> {

    public enum a {
        DEFAULT,
        RECENTS_LIST,
        TASK_BAR,
        RECENTS_LIST_FROM_TASK_BAR
    }

    k(List<String> list, a aVar) {
        x.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", Integer.valueOf(list.size()), aVar.name(), Integer.valueOf(aVar.ordinal()));
        com.tencent.mm.bp.a goVar = new go();
        goVar.sfa = aVar.ordinal();
        for (String str : list) {
            if (!bi.oN(str)) {
                ccw ccw = new ccw();
                ccw.wXQ = str;
                ccw.vTY = r.rs(str);
                goVar.vSu.add(ccw);
            }
        }
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = goVar;
        aVar2.hnU = new gp();
        aVar2.hnS = 1192;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
        this.gLB = aVar2.Kf();
    }
}
