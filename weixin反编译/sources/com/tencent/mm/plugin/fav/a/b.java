package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class b {
    public static String a(uz uzVar) {
        va vaVar = uzVar.wkH;
        String str = "";
        switch (uzVar.bjS) {
            case 1:
                return cD(str, uzVar.desc);
            case 4:
                if (vaVar.wlj != null) {
                    return cD(str, vaVar.wlj.title);
                }
                return str;
            case 5:
                if (vaVar.wlf != null) {
                    return cD(str, vaVar.wlf.title);
                }
                return str;
            case 6:
                str = cD(str, vaVar.iLo);
                if (vaVar.wld != null) {
                    return cD(cD(str, vaVar.wld.fEp), vaVar.wld.label);
                }
                return str;
            case 8:
                return cD(str, vaVar.title);
            case 10:
            case 11:
                if (vaVar.wlh != null) {
                    return cD(cD(str, vaVar.wlh.title), vaVar.wlh.desc);
                }
                return str;
            default:
                return cD(cD(str, vaVar.title), vaVar.desc);
        }
    }

    private static String cD(String str, String str2) {
        if (bi.oN(str)) {
            return str2;
        }
        if (bi.oN(str2)) {
            return str;
        }
        return str + "​" + str2;
    }

    public static long a(f fVar) {
        long j = 0;
        for (int i : a.mtC) {
            if (i == fVar.field_type) {
                long j2;
                if (fVar.field_favProto != null) {
                    Iterator it = fVar.field_favProto.wlY.iterator();
                    while (true) {
                        j2 = j;
                        if (!it.hasNext()) {
                            break;
                        }
                        j = ((uz) it.next()).wki + j2;
                    }
                } else {
                    j2 = 0;
                }
                fVar.field_datatotalsize = j2;
                x.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", Integer.valueOf(fVar.field_id), Long.valueOf(j2));
                return j2;
            }
        }
        return 0;
    }

    public static long b(f fVar) {
        if (fVar == null) {
            return 0;
        }
        int i = 0;
        Iterator it = fVar.field_favProto.wlY.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return (long) i2;
            }
            i = (int) (((uz) it.next()).wki + ((long) i2));
        }
    }
}
