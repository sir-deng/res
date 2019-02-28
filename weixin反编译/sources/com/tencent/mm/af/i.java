package com.tencent.mm.af;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends com.tencent.mm.sdk.e.i<g> {
    public static final String[] gLy = new String[]{com.tencent.mm.sdk.e.i.a(g.gKN, "BizKF")};
    public e gLA;

    public final /* synthetic */ boolean a(c cVar) {
        return b((g) cVar);
    }

    public i(e eVar) {
        super(eVar, g.gKN, "BizKF", null);
        this.gLA = eVar;
        eVar.fD("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
        eVar.fD("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    }

    public final g ke(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gLA.a("BizKF", null, "openId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.b(a);
            a.close();
            return gVar;
        }
        x.w("MicroMsg.BizKFStorage", "get null with openId:" + str);
        a.close();
        return null;
    }

    public static boolean a(g gVar) {
        if (gVar == null || System.currentTimeMillis() - gVar.field_updateTime < 86400000) {
            return false;
        }
        return true;
    }

    private boolean b(g gVar) {
        if (gVar == null || bi.oN(gVar.field_openId) || bi.oN(gVar.field_brandUsername)) {
            x.w("MicroMsg.BizKFStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.gLA.replace("BizKF", g.gKN.xrS, gVar.vP()) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", gVar.field_openId, gVar.field_brandUsername, Boolean.valueOf(z));
        return z;
    }

    public final g kf(String str) {
        if (bi.oN(str)) {
            return null;
        }
        Cursor a = this.gLA.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.b(a);
            a.close();
            return gVar;
        }
        x.w("MicroMsg.BizKFStorage", "get null with brandUsername:" + str);
        a.close();
        return null;
    }

    public final int d(LinkedList<g> linkedList) {
        if (linkedList.size() <= 0) {
            x.e("MicroMsg.BizKFStorage", "null kfs");
            return 0;
        }
        long dA;
        if (this.gLA instanceof h) {
            dA = ((h) this.gLA).dA(Thread.currentThread().getId());
        } else {
            dA = 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar != null && b(gVar)) {
                i++;
            }
            i = i;
        }
        if (this.gLA instanceof h) {
            g.Dq().gRU.fT(dA);
        }
        x.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", Integer.valueOf(i));
        return i;
    }
}
