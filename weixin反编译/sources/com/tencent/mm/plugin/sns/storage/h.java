package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.plugin.sns.model.ae;

public final class h {
    public static m LQ(String str) {
        if (u.Ka(str)) {
            return ae.bwf().eS(u.Mk(str));
        }
        e eL = ae.bwi().eL(u.Mk(str));
        if (eL != null) {
            return eL.byH();
        }
        return null;
    }

    public static boolean a(String str, m mVar) {
        if (u.Ka(str)) {
            return ae.bwf().b(u.Mk(str), mVar);
        }
        return ae.bwi().b(u.Mk(str), mVar.bzl());
    }

    public static m LR(String str) {
        if (u.Ka(str)) {
            return ae.bwf().xG(u.Ml(str));
        }
        e xC = ae.bwi().xC(u.Ml(str));
        if (xC != null) {
            return xC.byH();
        }
        return null;
    }
}
