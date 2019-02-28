package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;

public final class g implements q {
    public final boolean a(cg cgVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        vn vnVar = new vn();
        vt vtVar = new vt();
        uz uzVar = new uz();
        uzVar.Dc(5);
        uzVar.Uk(str7);
        uzVar.Ub(str3);
        uzVar.Db(i);
        uzVar.TV(str);
        uzVar.TW(str2);
        uzVar.Ut(str11);
        vc vcVar = new vc();
        vcVar.hfb = str;
        vcVar.wlG = i;
        vcVar.heZ = str3;
        vcVar.hfd = str5;
        vcVar.hfc = str4;
        vcVar.hfe = str6;
        vcVar.hff = str9;
        vcVar.hfg = str10;
        uzVar.a(vcVar);
        vtVar.UN(str8);
        vtVar.UO(com.tencent.mm.y.q.FY());
        vtVar.Dl(0);
        vtVar.fD(bi.Wy());
        vnVar.a(vtVar);
        vnVar.wlY.add(uzVar);
        cgVar.frk.title = uzVar.title;
        cgVar.frk.desc = uzVar.title;
        cgVar.frk.frm = vnVar;
        cgVar.frk.type = 4;
        return true;
    }

    public final boolean a(cg cgVar, Intent intent) {
        return f.a(cgVar, intent);
    }

    public final boolean a(cg cgVar, long j) {
        return f.a(cgVar, j);
    }

    public final boolean a(cg cgVar, String str, String str2, String str3, String str4, String str5, String str6) {
        String format = String.format("%s#%s", new Object[]{str, ""});
        vn vnVar = new vn();
        vt vtVar = new vt();
        vtVar.UN(str2);
        vtVar.Dl(2);
        vtVar.fD(System.currentTimeMillis());
        vtVar.US(str);
        vtVar.UP(format);
        uz uzVar = new uz();
        uzVar.Un(format);
        uzVar.lA(true);
        uzVar.Dc(5);
        uzVar.TV(str3);
        uzVar.TW(str4);
        uzVar.Uu(str5);
        uzVar.lz(true);
        vnVar.wlY.add(uzVar);
        wc wcVar = new wc();
        wcVar.Vd(str6);
        vnVar.b(wcVar);
        vnVar.a(vtVar);
        cgVar.frk.frm = vnVar;
        cgVar.frk.desc = str3;
        cgVar.frk.type = 5;
        return true;
    }
}
