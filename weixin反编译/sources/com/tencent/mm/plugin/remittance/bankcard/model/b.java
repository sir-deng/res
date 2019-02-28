package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Comparator;

public final class b implements Comparator<fd> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        fd fdVar = (fd) obj;
        fd fdVar2 = (fd) obj2;
        if (bi.oN(fdVar.nHt) || bi.oN(fdVar2.nHt)) {
            if (!(bi.oN(fdVar.nHt) && bi.oN(fdVar2.nHt))) {
                if (bi.oN(fdVar.nHt)) {
                    return 1;
                }
                if (bi.oN(fdVar2.nHt)) {
                    return -1;
                }
            }
            return 0;
        }
        char charAt = !bi.oN(fdVar.vRE) ? fdVar.vRE.toUpperCase().charAt(0) : a.IS(fdVar.nHt);
        char charAt2 = !bi.oN(fdVar2.vRE) ? fdVar2.vRE.toUpperCase().charAt(0) : a.IS(fdVar2.nHt);
        if (charAt < charAt2) {
            return -1;
        }
        return charAt > charAt2 ? 1 : 0;
    }
}
