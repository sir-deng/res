package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.f.a.tm;
import com.tencent.mm.f.a.tn;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bzy;
import com.tencent.mm.protocal.c.bzz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;

public final class i extends a {
    public bzy tps;

    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        if (i != TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN) {
            return null;
        }
        a.ei(1, 0);
        a.zS(0);
        b tmVar = new tm();
        tmVar.fMT.fMU = ad.getContext().getResources().getStringArray(R.c.bqQ);
        tmVar.fMT.fql = 1;
        com.tencent.mm.sdk.b.a.xmy.m(tmVar);
        byte[] aY = com.tencent.mm.plugin.wear.model.a.bPh().tok.aY(bArr);
        if (aY == null) {
            return null;
        }
        try {
            bzy bzy = new bzy();
            bzy.aH(aY);
            bzz bzz = new bzz();
            int i2 = 20;
            String str = null;
            while (i2 > 0) {
                str = q.FY();
                if (bi.oN(str)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    i2--;
                }
            }
            if (bi.oN(str)) {
                return null;
            }
            bzz.vPp = str;
            str = w.e(ad.getContext().getSharedPreferences(ad.cgf(), 0));
            String cfV = w.cfV();
            if (str.equals("language_default")) {
                bzz.lTZ = cfV;
            } else {
                bzz.lTZ = str;
            }
            aY = com.tencent.mm.plugin.wear.model.a.bPh().tok.aZ(bzz.toByteArray());
            if (aY == null) {
                return null;
            }
            this.tps = bzy;
            b tnVar = new tn();
            tnVar.fMV.fql = 9;
            com.tencent.mm.sdk.b.a.xmy.a(tnVar, Looper.getMainLooper());
            return aY;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Wear.HttpLoginServer", e2, "", new Object[0]);
            return null;
        }
    }
}
