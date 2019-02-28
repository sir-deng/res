package com.tencent.mm.plugin.appbrand.i;

public final class a {
    public static boolean b(com.tencent.mm.ad.a.a<?> aVar) {
        if (aVar != null) {
            boolean z = aVar.errType == 0 && aVar.errCode == 0 && aVar.fKE != null;
            if (z) {
                return true;
            }
        }
        return false;
    }
}
