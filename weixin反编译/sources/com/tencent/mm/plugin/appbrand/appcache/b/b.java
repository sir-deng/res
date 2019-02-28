package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.mm.cc.g;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.plugin.appbrand.appcache.b.b.i;
import com.tencent.mm.protocal.c.bok;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import java.util.List;

public final class b {
    static void Z(List<bok> list) {
        if (!bi.cC(list)) {
            for (bok bok : list) {
                if (bok.wXT == null) {
                    x.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", bok.wXQ, bok.nqc);
                } else {
                    boolean z;
                    String str = "MicroMsg.AppBrand.PredownloadCmdProcessor";
                    String str2 = "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)";
                    Object[] objArr = new Object[8];
                    objArr[0] = bok.wXQ;
                    objArr[1] = bok.nqc;
                    objArr[2] = Boolean.valueOf(bok.wXT.xiK != null);
                    if (bok.wXT.xiL != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    if (bok.wXT.xiM != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[4] = Boolean.valueOf(z);
                    if (bok.wXT.xiN != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[5] = Boolean.valueOf(z);
                    if (bok.wXT.xiO != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[6] = Boolean.valueOf(z);
                    if (bok.wXT.xiP != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[7] = Boolean.valueOf(z);
                    x.i(str, str2, objArr);
                    if (bok.wXT.xiK != null) {
                        g.b(bok.wXQ, bok.nqc, bok.wXT.xiK).j(new d());
                    }
                    if (bok.wXT.xiL != null) {
                        g.b(bok.wXQ, bok.nqc, bok.wXT.xiL).j(new c()).f(new a<Void, Boolean>() {
                            public final /* synthetic */ Object call(Object obj) {
                                Boolean bool = (Boolean) obj;
                                if (bool != null && bool.booleanValue()) {
                                    i.iJI.aaE();
                                }
                                return null;
                            }
                        });
                    }
                    if (bok.wXT.xiM != null) {
                        g.b(bok.wXQ, bok.nqc, bok.wXT.xiM).j(new e());
                    }
                    if (bok.wXT.xiN != null) {
                        g.b(bok.wXQ, bok.nqc, bok.wXT.xiN).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.g());
                    }
                    if (bok.wXT.xiO != null) {
                        g.b(bok.wXQ, bok.nqc, bok.wXT.xiO).j(new f());
                    }
                    if (bok.wXT.xiP != null) {
                        g.b(bok.wXQ, bok.nqc, bok.wXT.xiP).j(new h());
                    }
                    if (bok.wXT.xiQ != null) {
                        g.b(bok.wXQ, bok.nqc, bok.wXT.xiQ).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.b());
                    }
                }
            }
        }
    }
}
