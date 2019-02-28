package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.cdg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.d;

public abstract class a<_Ret, _CmdStruct> implements com.tencent.mm.vending.c.a<_Ret, d<String, String, _CmdStruct>> {
    abstract cdg aY(_CmdStruct _cmdstruct);

    abstract String aaC();

    abstract _Ret b(String str, String str2, _CmdStruct _cmdstruct);

    public final /* synthetic */ Object call(Object obj) {
        Object obj2;
        d dVar = (d) obj;
        String str = (String) dVar.get(1);
        if (bi.oN(str)) {
            x.e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) invalid appId", aaC());
            obj2 = null;
        } else {
            cdg aY = aY(dVar.get(2));
            if (aY == null) {
                x.e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) null CmdBase", aaC());
                obj2 = null;
            } else {
                int i = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) aY.xiE, (long) com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJR.get(getClass()));
                long j = ((long) aY.xiC) & 4294967295L;
                x.i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) DealEndTime %d , now %d", aaC(), Long.valueOf(j), Long.valueOf(bi.Wx()));
                int i2;
                if (j < bi.Wx()) {
                    i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) aY.xiE, (long) com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJS.get(getClass()));
                    obj2 = null;
                } else {
                    long j2 = bi.getLong(e.Zw().get("PredownloadCmdSequence$" + aaC() + '$' + str, "0"), 0);
                    j = ((long) aY.xiD) & 4294967295L;
                    x.i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s), lastSeq %d, cmdSeq %d", aaC(), Long.valueOf(j2), Long.valueOf(j));
                    if (j2 > j) {
                        i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) aY.xiE, (long) com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJT.get(getClass()));
                        obj2 = null;
                    } else if (j2 == j) {
                        i2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) aY.xiE, (long) com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJU.get(getClass()));
                        obj2 = null;
                    } else {
                        e.Zw().aY("PredownloadCmdSequence$" + aaC() + '$' + str, Long.toString(j));
                        obj2 = 1;
                    }
                }
            }
        }
        if (obj2 != null) {
            return b((String) dVar.get(0), (String) dVar.get(1), dVar.get(2));
        }
        g.cAI().cm(null);
        return null;
    }
}
