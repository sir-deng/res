package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import com.tencent.c.e.a.a.a;
import com.tencent.c.f.b;
import com.tencent.c.f.d;
import com.tencent.c.f.i;
import com.tencent.c.f.l;

public final class c {
    private int Abk = -1;
    private com.tencent.c.c.a.c Abm = null;
    private Context mContext;
    private String mVersionName = null;

    public c(Context context) {
        this.mContext = context;
        a bF = i.bF(context, context.getPackageName());
        this.mVersionName = bF.versionName;
        this.Abk = bF.versionCode;
    }

    public final byte[] c(String str, String str2, com.tencent.c.e.a.b.a aVar) {
        try {
            l lVar = new l();
            lVar.cEF();
            lVar.abJ(str);
            lVar.abK(str2);
            lVar.abI("UTF-8");
            lVar.put("userInfo", a(aVar));
            lVar.put("req", aVar);
            byte[] q = b.q(lVar.tr());
            if (q != null) {
                return com.tencent.c.f.c.j(q, com.tencent.c.f.c.cEB());
            }
            throw new RuntimeException("compress data fail");
        } catch (Exception e) {
            return null;
        }
    }

    private com.tencent.c.c.a.c a(com.tencent.c.e.a.b.a aVar) {
        if (this.Abm == null) {
            this.Abm = new com.tencent.c.c.a.c();
            this.Abm.Abx = 82;
            this.Abm.AbC = this.Abk;
            this.Abm.Abu = aVar.fDM;
            this.Abm.Abt = aVar.Abt;
            try {
                int i;
                int i2;
                int i3;
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                } else {
                    i3 = Integer.parseInt(split[0]);
                    i2 = Integer.parseInt(split[1]);
                    i = Integer.parseInt(split[2]);
                }
                this.Abm.Aby = new com.tencent.c.c.a.b();
                this.Abm.Aby.Abq = i3;
                this.Abm.Aby.Abr = i2;
                this.Abm.Aby.Abs = i;
            } catch (Exception e) {
            }
            this.Abm.Abz = 0;
            this.Abm.AbB = d.cEC();
            this.Abm.imei = abz(aVar.imei);
            this.Abm.imsi = abz(aVar.imsi);
            this.Abm.Abv = abz(Build.MODEL);
            this.Abm.rkf = abz(d.gw(this.mContext));
            this.Abm.AbI = abz(d.nV(true));
            this.Abm.AbJ = abz(d.nV(false));
            this.Abm.AbA = 0;
        }
        this.Abm.Abw = getNetworkType();
        this.Abm.guid = abz(d.gy(this.mContext));
        return this.Abm;
    }

    private int getNetworkType() {
        try {
            return d.gx(this.mContext) == d.a.AdV ? 2 : 1;
        } catch (Throwable th) {
            return 2;
        }
    }

    private static String abz(String str) {
        return str == null ? "" : str;
    }
}
