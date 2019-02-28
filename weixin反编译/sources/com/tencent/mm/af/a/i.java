package com.tencent.mm.af.a;

import com.tencent.mm.af.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;

public final class i {
    public static void f(int i, String str, String str2) {
        if ("EnterpriseChatStatus".equals(str)) {
            String[] split = str2.split(";");
            String str3 = split[0];
            String str4 = split[1];
            bi.getInt(split[2], 0);
            if (i == 7) {
                al(str4, str3);
            } else if (i == 8) {
                al(str4, str3);
            } else if (i == 9) {
                al(str4, str3);
            }
        }
    }

    private static void al(String str, String str2) {
        long kw = e.kw(str);
        if (kw == -1) {
            x.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", str);
            return;
        }
        int i = y.Mo().aT(kw).field_newUnReadCount;
        y.Mo().aV(kw);
        c ag = y.Mn().ag(kw);
        ae XF = ((h) g.h(h.class)).Fk().XF(str2);
        if (XF == null) {
            x.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", str2);
        } else if (ag.hr(1)) {
            if (XF.field_unReadMuteCount <= i) {
                XF.eW(0);
                ((h) g.h(h.class)).Fk().a(XF, str2);
                ((a) g.k(a.class)).getNotification().cancelNotification(str2);
                return;
            }
            XF.eW(XF.field_unReadMuteCount - i);
            ((h) g.h(h.class)).Fk().a(XF, str2);
        } else if (XF.field_unReadCount <= i) {
            ((h) g.h(h.class)).Fk().XH(str2);
            ((a) g.k(a.class)).getNotification().cancelNotification(str2);
        } else {
            XF.eV(0);
            XF.eP(XF.field_unReadCount - i);
            ((h) g.h(h.class)).Fk().a(XF, str2);
        }
    }
}
