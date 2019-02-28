package com.tencent.mm.af;

import com.tencent.mm.bp.a;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bb.AnonymousClass5;
import com.tencent.wcdb.FileUtils;
import java.util.List;

public final class f {
    public static d jV(String str) {
        d jN = y.Ml().jN(str);
        return jN.field_updateTime > 0 ? jN : null;
    }

    public static boolean jW(String str) {
        d jV = jV(str);
        if (jV != null && jV.Lh()) {
            return true;
        }
        return false;
    }

    public static boolean jX(String str) {
        d jV = jV(str);
        if (jV == null) {
            return false;
        }
        return jV.Li();
    }

    public static boolean jY(String str) {
        d jV = jV(str);
        if (jV != null && jV.Lj()) {
            return true;
        }
        return false;
    }

    public static boolean jZ(String str) {
        d jV = jV(str);
        if (jV != null && jV.Ll()) {
            return true;
        }
        return false;
    }

    public static boolean ka(String str) {
        if (str == null) {
            return false;
        }
        d jV = jV(str);
        if (jV == null || !jV.Lk()) {
            return false;
        }
        return true;
    }

    public static boolean eG(String str) {
        d jV = jV(str);
        if (jV != null && jV.Lm()) {
            return true;
        }
        return false;
    }

    public static boolean kb(String str) {
        d jV = jV(str);
        if (jV != null && jV.Ln()) {
            return true;
        }
        return false;
    }

    public static boolean kc(String str) {
        d jV = jV(str);
        if (jV == null) {
            return false;
        }
        return jV.Lc();
    }

    public static void f(d dVar) {
        if (dVar == null) {
            x.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
            return;
        }
        a arv = new arv();
        arv.hxs = dVar.field_brandFlag;
        arv.kyG = dVar.field_username;
        ag Xu = ((h) g.h(h.class)).Ff().Xu(dVar.field_username);
        if (Xu == null || !com.tencent.mm.k.a.ga(Xu.field_type)) {
            ((h) g.h(h.class)).Fe().b(new e.a(58, arv));
        } else {
            ((h) g.h(h.class)).Fe().b(new e.a(47, arv));
        }
        boolean c = y.Ml().c(dVar, new String[0]);
        x.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", Boolean.valueOf(c), Integer.valueOf(dVar.field_brandFlag));
    }

    public static void g(d dVar) {
        if (dVar != null) {
            a arv = new arv();
            arv.hxs = dVar.field_brandFlag;
            arv.kyG = dVar.field_username;
            ((h) g.h(h.class)).Fe().b(new e.a(47, arv));
            y.Ml().c(dVar, new String[0]);
        }
    }

    public static boolean LR() {
        return y.Ml().hu(1) > 0;
    }

    public static List<String> LS() {
        return y.Ml().ht(2);
    }

    public static boolean LT() {
        return y.Ml().hu(4) > 0;
    }

    public static boolean LU() {
        return y.Ml().hu(8) > 0;
    }

    public static List<String> LV() {
        return y.Ml().ht(16);
    }

    public static boolean LW() {
        return y.Ml().hu(16) > 0;
    }

    public static List<String> LX() {
        return y.Ml().ht(32);
    }

    public static boolean LY() {
        return y.Ml().hu(64) > 0;
    }

    public static List<String> LZ() {
        return y.Ml().ht(FileUtils.S_IWUSR);
    }

    public static boolean Ma() {
        return y.Ml().hu(FileUtils.S_IWUSR) > 0;
    }

    public static boolean Mb() {
        return y.Ml().hu(256) > 0;
    }

    public static boolean Mc() {
        return y.Ml().hu(WXMediaMessage.TITLE_LENGTH_LIMIT) > 0;
    }

    public static void kd(String str) {
        int i = 0;
        y.Ml();
        String jR = e.jR(str);
        if (jR != null) {
            ((o) g.h(o.class)).Fi().Fj(jR);
        }
        ((h) g.h(h.class)).Fk().XE(str);
        d jV = jV(str);
        if (jV == null) {
            y.Ms().iI(str);
            return;
        }
        if (jV.Lk()) {
            ((h) g.h(h.class)).Fk().XU(str);
            y.Ml();
            List jQ = e.jQ(str);
            if (jQ == null || jQ.size() <= 0) {
                x.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
            } else {
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", bi.chl());
                com.tencent.mm.sdk.f.e.post(new AnonymousClass5(jQ), "deleteMsgByTalkers");
            }
            while (i < jQ.size()) {
                String str2 = (String) jQ.get(i);
                if (eG(str2)) {
                    com.tencent.mm.af.a.e.A(str2, true);
                }
                y.Ml().jO(str2);
                i++;
            }
        }
        if (jV.Lm()) {
            com.tencent.mm.af.a.e.A(str, true);
        }
        y.Ml().c(jV);
        y.Ms().iI(str);
    }
}
