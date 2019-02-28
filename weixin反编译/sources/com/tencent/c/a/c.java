package com.tencent.c.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static com.tencent.c.b.a Abf = null;

    public interface a {
        void e(int i, byte[] bArr);
    }

    public static void a(Context context, a aVar) {
        int i = 0;
        if (Abf == null) {
            Abf = new com.tencent.c.b.a(context);
        }
        com.tencent.c.b.a aVar2 = Abf;
        try {
            List gt = com.tencent.c.f.a.gt(aVar2.mContext);
            if (gt.size() == 0) {
                aVar.e(-10, null);
                return;
            }
            com.tencent.c.c.b.a aVar3 = new com.tencent.c.c.b.a();
            aVar3.AbN = com.tencent.c.b.a.cEi();
            aVar3.AbL = new com.tencent.c.c.b.c();
            aVar3.AbL.Aco = 6;
            aVar3.AbL.AbF = 1;
            aVar3.AbL.requestType = 0;
            aVar3.AbL.Acp = 0;
            aVar3.AbL.Acq = 0;
            aVar3.AbL.Acr = null;
            aVar3.AbL.Acs = 0;
            aVar3.AbL.Acw = 1;
            aVar3.AbM = new ArrayList();
            while (true) {
                int i2 = i;
                if (i2 >= gt.size()) {
                    break;
                }
                aVar3.AbM.add(com.tencent.c.b.a.a(aVar2.mContext, (a) gt.get(i2), i2));
                i = i2 + 1;
            }
            byte[] a = aVar2.Abi.a(aVar3);
            if (a == null) {
                aVar.e(-20, null);
            } else {
                aVar.e(0, a);
            }
        } catch (Throwable th) {
            aVar.e(-100, null);
        }
    }
}
