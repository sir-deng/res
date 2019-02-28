package com.tencent.mm.plugin.favorite.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.a;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static boolean a(String str, LinkedList<uz> linkedList, long j) {
        if (str.length() == 0) {
            x.e("MicroMsg.FavPostLogic", "postNote null");
            return false;
        }
        f a;
        if (-1 == j) {
            a = a(linkedList, j);
        } else {
            a = h.getFavItemInfoStorage().dc(j);
        }
        a.B(a);
        return true;
    }

    public static f a(LinkedList<uz> linkedList, long j) {
        f fVar = null;
        if (j != -1) {
            fVar = h.getFavItemInfoStorage().dc(j);
            if (fVar == null) {
                fVar = j.dp(j);
            }
            fVar.field_favProto.wlY.clear();
        }
        if (fVar == null) {
            fVar = new f();
            fVar.field_type = 18;
            fVar.field_sourceType = 6;
            j(fVar);
            fVar.field_favProto.Dk(1);
            fVar.field_favProto.Dj(127);
        }
        fVar.field_edittime = bi.Wx();
        fVar.field_updateTime = bi.Wy();
        fVar.field_favProto.fC(fVar.field_edittime);
        fVar.field_favProto.wlW.fD(bi.Wy());
        fVar.field_favProto.aw(linkedList);
        return fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> aK(java.util.List<java.lang.String> r7) {
        /*
        if (r7 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r7.size();
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r7;
    L_0x0009:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r3 = new com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger;
        r3.<init>();
        r4 = r7.iterator();
    L_0x0017:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x005b;
    L_0x001d:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r2 = 0;
        r2 = com.tencent.mm.modelsfs.FileOp.openRead(r0);	 Catch:{ Exception -> 0x005d, all -> 0x0056 }
        if (r2 != 0) goto L_0x002e;
    L_0x002a:
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        goto L_0x0017;
    L_0x002e:
        r5 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.checkIsImageLegal(r2, r3);	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        if (r5 == 0) goto L_0x003b;
    L_0x0034:
        r1.add(r0);	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
    L_0x0037:
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        goto L_0x0017;
    L_0x003b:
        r0 = r3.getDecodeResult();	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        r5 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r0 < r5) goto L_0x0037;
    L_0x0043:
        r0 = 5;
        r0 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper.getKVStatString(r2, r0, r3);	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        r5 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        r6 = 12712; // 0x31a8 float:1.7813E-41 double:6.2806E-320;
        r5.k(r6, r0);	 Catch:{ Exception -> 0x0050, all -> 0x0056 }
        goto L_0x0037;
    L_0x0050:
        r0 = move-exception;
        r0 = r2;
    L_0x0052:
        com.tencent.mm.sdk.platformtools.bi.d(r0);
        goto L_0x0017;
    L_0x0056:
        r0 = move-exception;
        com.tencent.mm.sdk.platformtools.bi.d(r2);
        throw r0;
    L_0x005b:
        r7 = r1;
        goto L_0x0008;
    L_0x005d:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.a.c.aK(java.util.List):java.util.List<java.lang.String>");
    }

    public static boolean aL(List<String> list) {
        List<String> aK = aK(list);
        if (aK == null || aK.size() == 0) {
            x.e("MicroMsg.FavPostLogic", "postImgs path null");
            return false;
        }
        f fVar = new f();
        fVar.field_type = 2;
        fVar.field_sourceType = 6;
        j(fVar);
        for (String str : aK) {
            uz uzVar = new uz();
            uzVar.Uj(str);
            uzVar.Ui(j.bm(uzVar.toString(), 2));
            d.b(str, 150, 150, CompressFormat.JPEG, 90, j.i(uzVar));
            uzVar.Uk(j.i(uzVar));
            uzVar.Dc(2);
            fVar.field_favProto.wlY.add(uzVar);
        }
        a.B(fVar);
        g.pWK.h(10648, Integer.valueOf(2), Integer.valueOf(aK.size()));
        return true;
    }

    public static void j(f fVar) {
        String FY = q.FY();
        vt vtVar = new vt();
        vtVar.UN(FY);
        vtVar.UO(FY);
        vtVar.Dl(fVar.field_sourceType);
        vtVar.fD(bi.Wy());
        fVar.field_favProto.a(vtVar);
        fVar.field_fromUser = vtVar.fAJ;
        fVar.field_toUser = vtVar.toUser;
    }
}
