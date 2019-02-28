package com.tencent.mm.booter.notification;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    public e gBP;

    private static class a {
        private static final f gBQ = new f();
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        this.gBP = new e();
    }

    public final boolean a(String str, au auVar, int i, boolean z) {
        if (bi.oN(str)) {
            return false;
        }
        return c.a(str, auVar, i, z);
    }

    public final int a(NotificationItem notificationItem) {
        return this.gBP.a(notificationItem, null);
    }

    public final void n(int i, String str) {
        ArrayList arrayList;
        x.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", Integer.valueOf(i), str);
        if (i == -1) {
            i = com.tencent.mm.j.f.Ab();
        }
        c.fo(i);
        if (str == null || str.length() <= 0) {
            arrayList = new ArrayList();
            List Aa = com.tencent.mm.j.f.Aa();
            if (Aa == null) {
                Aa = new ArrayList();
            }
            for (String str2 : Aa) {
                a aVar = new a();
                aVar.userName = str2;
                aVar.gBu = com.tencent.mm.j.f.eV(str2);
                arrayList.add(aVar);
            }
        } else {
            a aVar2;
            ArrayList xl = c.xl();
            arrayList = xl == null ? new ArrayList() : xl;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar2 = (a) it.next();
                if (aVar2.userName.equals(str)) {
                    arrayList.remove(aVar2);
                    break;
                }
            }
            aVar2 = null;
            if (aVar2 == null) {
                aVar2 = new a();
            }
            aVar2.userName = str;
            aVar2.gBu = com.tencent.mm.j.f.eV(str);
            if (aVar2.gBu == 0 && arrayList.isEmpty()) {
                c.d(null);
                return;
            } else if (aVar2.gBu > 0) {
                arrayList.add(aVar2);
            }
        }
        c.d(arrayList);
    }
}
