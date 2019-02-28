package com.tencent.mm.ac;

import android.graphics.Bitmap;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.q;

public final class b {
    public static String ab(String str, String str2) {
        return str + "?access_token=" + str2;
    }

    public static Bitmap iR(String str) {
        return a(str + "@google", false, -1);
    }

    private static String iS(String str) {
        return "http://graph.facebook.com/" + str + "/picture";
    }

    public static void iT(String str) {
        if (!bi.oN(str)) {
            String str2 = str + "@fb";
            h jp = n.JW().jp(str2);
            if (jp == null || !str2.equals(jp.getUsername()) || 3 != jp.fWZ) {
                if (jp == null) {
                    jp = new h();
                }
                jp.username = str2;
                jp.fWZ = 3;
                jp.hni = iS(str);
                jp.hnh = iS(str);
                jp.bC(true);
                jp.fEo = 31;
                n.JW().a(jp);
            }
        }
    }

    public static Bitmap iU(String str) {
        return a(str + "@fb", false, -1);
    }

    public static long iV(String str) {
        long j = -1;
        if (!x.Xh(str)) {
            return j;
        }
        try {
            return bi.getLong(str.split("@")[0], -1);
        } catch (Exception e) {
            return j;
        }
    }

    private static String aO(long j) {
        return new o(j) + "@qqim";
    }

    public static long iW(String str) {
        long j = -1;
        if (!x.Xf(str)) {
            return j;
        }
        try {
            return bi.getLong(str.split("@")[0], -1);
        } catch (Exception e) {
            return j;
        }
    }

    public static boolean c(long j, int i) {
        if (i != 3) {
            return false;
        }
        return iX(aO(j));
    }

    public static boolean iX(String str) {
        if (str == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        } else if (str.endsWith("@qqim")) {
            h hVar = new h();
            hVar.username = str;
            hVar.fWZ = 3;
            hVar.fEo = 3;
            return n.JW().a(hVar);
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        }
    }

    public static Bitmap aP(long j) {
        return a(aO(j), false, -1);
    }

    public static boolean I(String str, int i) {
        if (bi.oN(str)) {
            return false;
        }
        h jp = n.JW().jp(str);
        if (jp != null && str.equals(jp.getUsername()) && i == jp.fWZ) {
            return true;
        }
        if (jp == null) {
            jp = new h();
        }
        jp.username = str;
        jp.fWZ = i;
        jp.fEo = 3;
        return n.JW().a(jp);
    }

    public static Bitmap iY(String str) {
        return a(str, false, -1);
    }

    public static Bitmap c(String str, int i, int i2, int i3) {
        if (bi.oN(str) || !g.Do().CF()) {
            return null;
        }
        Bitmap bitmap;
        n.JF();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (bi.oN(str)) {
            bitmap = null;
        } else {
            bitmap = d.a(d.x(str, true), i, i2, null, 0, 0, 1);
        }
        if (bitmap == null) {
            final e eVar = new e();
            eVar.a(str, new com.tencent.mm.ac.e.b() {
                public final int ba(int i, int i2) {
                    eVar.JJ();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                    return 0;
                }
            });
            return a(str, false, i3);
        } else if (i3 > 5) {
            return d.a(bitmap, false, (float) i3);
        } else {
            return bitmap;
        }
    }

    public static Bitmap a(String str, boolean z, int i) {
        if (bi.oN(str) || !g.Do().CF()) {
            return null;
        }
        if (!g.Dq().De()) {
            return n.JF().bg(ad.getContext());
        }
        if (x.gB(str)) {
            str = x.Xk(str);
        }
        return n.JY().b(str, z, i);
    }

    public static String iZ(String str) {
        if (bi.oN(str) || !g.Do().CF() || !g.Dq().De()) {
            return null;
        }
        if (x.gB(str)) {
            n.JF();
            return d.x(x.Xk(str), false);
        }
        n.JF();
        return d.x(str, false);
    }

    public static void ja(String str) {
        h jp = n.JW().jp(str);
        if (jp != null && str.equals(jp.getUsername())) {
            jp.hnk = 0;
            jp.fEo = 64;
            n.JW().a(jp);
        }
    }

    public static h a(String str, asc asc) {
        h hVar = new h();
        hVar.fEo = -1;
        hVar.username = str;
        hVar.hnh = asc.wbZ;
        hVar.hni = asc.wbY;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", hVar.getUsername(), hVar.JM(), hVar.JN());
        hVar.bC(asc.wGo != 0);
        if (asc.wGj == 3 || asc.wGj == 4) {
            hVar.fWZ = asc.wGj;
        } else if (asc.wGj == 2) {
            hVar.fWZ = 3;
            if (!q.FY().equals(str)) {
                n.JF();
                d.y(str, false);
                n.JF();
                d.y(str, true);
                n.JY().jb(str);
            }
        }
        return hVar;
    }
}
