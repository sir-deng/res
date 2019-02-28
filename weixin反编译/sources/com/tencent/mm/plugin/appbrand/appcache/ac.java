package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.azy;
import com.tencent.mm.protocal.c.cch;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum ac {
    ;

    public enum a {
        public static final int iHw = 0;
        public static final int iHx = 0;
        public static final int iHy = 0;
        private static final /* synthetic */ int[] iHz = null;

        static {
            iHw = 1;
            iHx = 2;
            iHy = 3;
            iHz = new int[]{iHw, iHx, iHy};
        }
    }

    public static void cs(final boolean z) {
        e.post(new Runnable() {
            public final void run() {
                if (z) {
                    x.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
                    g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_PUBLIC_LIB_UPDATE_NEXT_TIME_SEC_LONG, Long.valueOf(bi.Wx() - 1));
                }
                ac.yh();
            }
        }, "WxaCommLibVersionChecker");
    }

    private static void a(int i, cch cch, int i2) {
        if (com.tencent.mm.plugin.appbrand.app.e.Zz() != null) {
            PInt pInt = new PInt();
            com.tencent.mm.plugin.appbrand.app.e.Zz().a(cch, pInt);
            boolean z = com.tencent.mm.plugin.appbrand.app.e.Zz().ai("@LibraryAppId", 0) == cch.version ? ak.l(true, true).first == com.tencent.mm.plugin.appbrand.appcache.ak.a.iIy : false;
            x.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(cch.version), Integer.valueOf(cch.wNv), cch.frM, cch.url);
            if (z) {
                if (i <= 0 || bi.oN(cch.fzB)) {
                    l.iGR.A(-1, null);
                } else {
                    l.iGR.A(i, cch.fzB);
                }
                l.iGR.cp(true);
                c sVar = new s();
                sVar.field_key = "@LibraryAppId";
                sVar.field_version = cch.version;
                if (!com.tencent.mm.plugin.appbrand.app.e.ZF().b(sVar, "key", "version")) {
                    sVar.field_updateTime = bi.Wx();
                    sVar.field_scene = (i2 - 1) + 1;
                    com.tencent.mm.plugin.appbrand.app.e.ZF().b(sVar);
                }
            }
            if (cch.wNv > 0 && pInt.value > 0) {
                int i3 = cch.version;
                d.lN(2);
                return;
            }
            return;
        }
        x.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    }

    public static void a(int i, azy azy) {
        if (azy != null) {
            cch cch = new cch();
            cch.url = azy.url;
            cch.frM = azy.frM;
            cch.version = azy.version;
            cch.wNv = azy.wNv;
            cch.xhW = azy.wNu ? 1 : 0;
            cch.fzB = azy.fzB;
            a(i, cch, a.iHy);
        }
    }

    public static void a(cch cch) {
        a(-1, cch, a.iHx);
    }
}
