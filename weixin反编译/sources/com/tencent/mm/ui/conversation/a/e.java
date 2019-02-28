package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.a.f;
import com.tencent.mm.y.a.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.az;
import com.tencent.mm.y.b.b.b;
import com.tencent.mm.y.ba;
import com.tencent.mm.y.c;

public final class e {

    /* renamed from: com.tencent.mm.ui.conversation.a.e$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] zjz = new int[a.cxH().length];

        static {
            try {
                zjz[a.zjB - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zjz[a.zjC - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zjz[a.zjD - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zjz[a.zjE - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zjz[a.zjF - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zjz[a.zjA - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                zjz[a.zjG - 1] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                zjz[a.zjH - 1] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                zjz[a.zjI - 1] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                zjz[a.zjJ - 1] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                zjz[a.zjK - 1] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public enum a {
        ;

        public static int[] cxH() {
            return (int[]) zjL.clone();
        }

        static {
            zjA = 1;
            zjB = 2;
            zjC = 3;
            zjD = 4;
            zjE = 5;
            zjF = 6;
            zjG = 7;
            zjH = 8;
            zjI = 9;
            zjJ = 10;
            zjK = 11;
            zjL = new int[]{zjA, zjB, zjC, zjD, zjE, zjF, zjG, zjH, zjI, zjJ, zjK};
        }
    }

    public static com.tencent.mm.pluginsdk.ui.b.a a(Context context, int i, Object[] objArr) {
        boolean z = false;
        String obj;
        String obj2;
        switch (AnonymousClass1.zjz[i - 1]) {
            case 1:
                if (objArr == null || objArr.length != 2) {
                    return null;
                }
                obj = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj2 = objArr[1].toString();
                } else {
                    obj2 = null;
                }
                if (as.Hm().FM() == null) {
                    x.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
                }
                if (as.Hm().FM() == null) {
                    return null;
                }
                if (as.Hm().FM().in(obj) || as.Hm().FM().in(obj2)) {
                    return new f(context, obj, obj2);
                }
                return null;
            case 2:
                if (objArr == null || objArr.length != 3) {
                    return null;
                }
                String obj3;
                boolean z2;
                obj2 = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj3 = objArr[1].toString();
                } else {
                    obj3 = null;
                }
                if (objArr[2] == null || !(objArr[2] instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) objArr[2]).booleanValue();
                }
                if ((as.Hp() && as.Hm().FN() != null && as.Hm().FN().in(obj2)) || as.Hm().FN().in(obj3)) {
                    return new g(context, obj2, obj3, z2);
                }
                return null;
            case 3:
                return new n(context);
            case 4:
                return new h(context);
            case 5:
                return new a(context);
            case 6:
                ba.Hy();
                az Hz = ba.Hz();
                if (Hz != null) {
                    return new k(context, Hz);
                }
                return null;
            case 7:
                com.tencent.mm.y.a.e ih = g.Ip().ih("4");
                if (ih == null) {
                    return null;
                }
                obj = ih.value;
                if (bi.oN(obj) || obj.equals("0")) {
                    return null;
                }
                Object obj4;
                com.tencent.mm.pluginsdk.ui.b.a kVar;
                if (obj.equals("1")) {
                    as.Hm();
                    obj4 = c.Db().get(328195, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        x.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
                        return null;
                    }
                    ba.Hy();
                    int HA = ba.HA();
                    if (HA == com.tencent.mm.y.ba.a.hig || HA == com.tencent.mm.y.ba.a.hih) {
                        x.i("MicroMsg.BannerFactory", "already Bind the Mobile");
                        return null;
                    }
                    kVar = new k(context, new az(1, 1, ""));
                    f.il("4");
                    return kVar;
                } else if (!obj.equals("2")) {
                    return null;
                } else {
                    as.Hm();
                    obj4 = c.Db().get(328196, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        x.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
                        return null;
                    }
                    ba.Hy();
                    if (ba.HA() == com.tencent.mm.y.ba.a.hig) {
                        x.i("MicroMsg.BannerFactory", "already upload the Mobile");
                        return null;
                    }
                    kVar = new k(context, new az(2, 1, ""));
                    f.il("4");
                    return kVar;
                }
            case 8:
                return new l(context);
            case 9:
                return new o(context);
            case 10:
                return new j(context);
            case 11:
                b bVar;
                if (objArr == null || objArr.length <= 0) {
                    bVar = b.Main;
                } else {
                    bVar = (b) objArr[0];
                }
                return new com.tencent.mm.ui.d.a(context, bVar);
            default:
                return null;
        }
    }
}
