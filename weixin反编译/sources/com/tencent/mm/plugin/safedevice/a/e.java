package com.tencent.mm.plugin.safedevice.a;

import android.content.Context;
import android.os.Build;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.protocal.c.bew;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.List;

public final class e {
    public static void x(boolean z, boolean z2) {
        if (as.Hp()) {
            int Ge = q.Ge();
            if (z) {
                Ge |= 16384;
            } else {
                Ge &= -16385;
            }
            as.Hm();
            c.Db().set(40, Integer.valueOf(Ge));
            if (z2) {
                a wuVar = new wu();
                wuVar.wnP = 28;
                wuVar.wnQ = z ? 1 : 2;
                as.Hm();
                c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wuVar));
                com.tencent.mm.plugin.c.a.ihO.un();
            }
        }
    }

    static void a(bew bew) {
        if (bew != null && bew.kyB != null) {
            List<bev> list = bew.kyB;
            if (list != null && list.size() >= 0) {
                f.bpa().fD("SafeDeviceInfo", "delete from SafeDeviceInfo");
                for (bev cVar : list) {
                    f.bpa().a(new c(cVar));
                }
            }
        }
    }

    public static String dr(Context context) {
        return context == null ? f.xmW ? ad.getContext().getString(R.l.eGS) : ad.getContext().getString(R.l.eGR) : f.xmW ? context.getString(R.l.eGS) : context.getString(R.l.eGR);
    }

    public static String boY() {
        return Build.MANUFACTURER + "-" + Build.MODEL;
    }
}
