package com.tencent.mm.plugin.emoji.a.a;

import android.content.Context;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public static void a(c cVar, a aVar) {
        if (q.Gk() && cVar != null && cVar.size() > 0 && aVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = cVar.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!(fVar == null || fVar.lAx == f.a.lAG)) {
                    sx sxVar = fVar.lAy;
                    boolean b = e.b(sxVar);
                    boolean a = e.a(sxVar);
                    if (!(b || a)) {
                        arrayList.add(sxVar.vPI);
                        ak yD = cVar.yD(sxVar.vPI);
                        if (yD != null) {
                            yD.xHc = 11;
                        }
                    }
                }
            }
            Context context = ad.getContext();
            if (arrayList.size() > 0) {
                i.a(context, (String[]) arrayList.toArray(new String[arrayList.size()]), aVar);
            }
        }
    }

    public static void a(ArrayList<com.tencent.mm.pluginsdk.model.q> arrayList, c cVar) {
        if (q.Gk() && cVar != null && arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mm.pluginsdk.model.q qVar = (com.tencent.mm.pluginsdk.model.q) it.next();
                if (qVar != null) {
                    ak yD = cVar.yD(qVar.frQ);
                    if (yD != null) {
                        int i;
                        if (qVar.vkp == 10232) {
                            yD.xHe = qVar.vkm;
                            yD.xHc = 12;
                            i = yD.xHa;
                            if (!(oZ(i) || pa(i))) {
                                yD.DH(4);
                            }
                        } else {
                            yD.xHc = 10;
                            yD.xHd = qVar.vkp;
                            i = yD.xHa;
                            if (!(oZ(i) || pa(i))) {
                                if ((i == 3 ? 1 : null) == null) {
                                    yD.DH(10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean oZ(int i) {
        return i == 7;
    }

    private static boolean pa(int i) {
        return i == 6;
    }
}
