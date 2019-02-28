package com.tencent.mm.y;

import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

public final class l {
    public static boolean gc(String str) {
        if (!s.eX(str)) {
            return false;
        }
        long j;
        boolean z;
        ae XF = ((h) g.h(h.class)).Fk().XF(str);
        if (XF != null) {
            if (XF.field_lastSeq == 0 || ((h) g.h(h.class)).aZO().H(str, XF.field_lastSeq).field_msgId != 0) {
                j = 0;
                z = false;
            } else {
                j = XF.field_lastSeq;
                z = true;
            }
            if (XF.field_firstUnDeliverSeq != 0) {
                XF.am(0);
                XF.al(0);
                ((h) g.h(h.class)).Fk().a(XF, str);
                x.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            }
        } else {
            j = 0;
            z = false;
        }
        if (!z) {
            cg FA = ((h) g.h(h.class)).aZO().FA(str);
            if (!(FA == null || FA.field_msgId == 0)) {
                z = true;
            }
        }
        if (j == 0) {
            j = ((h) g.h(h.class)).aZO().Fz(str);
        }
        if (j != 0) {
            ((h) g.h(h.class)).FQ().D(str, j);
        }
        x.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z), Long.valueOf(j));
        return z;
    }

    public static List<Boolean> A(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String gc : list) {
            arrayList.add(Boolean.valueOf(gc(gc)));
        }
        return arrayList;
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3) {
        a(str, list, str2, z, str3, 2);
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3, int i) {
        au auVar = new au();
        auVar.dU(str);
        auVar.setType(10000);
        auVar.aq(System.currentTimeMillis());
        auVar.eR(4);
        auVar.eS(i);
        CharSequence stringBuffer = new StringBuffer();
        if (list != null) {
            String FY = q.FY();
            String string = ad.getContext().getString(a.dQK);
            for (String str4 : list) {
                if (!str4.equals(FY)) {
                    com.tencent.mm.k.a Xv = ((h) g.h(h.class)).Ff().Xv(str4);
                    if (Xv == null || ((int) Xv.gKO) == 0) {
                        if (z) {
                            stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + str4 + "</a>" + string);
                        } else {
                            stringBuffer.append(str4 + string);
                        }
                    } else if (z) {
                        stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + Xv.AX() + "</a>" + string);
                    } else {
                        stringBuffer.append(Xv.AX() + string);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(string));
            }
        }
        auVar.setContent(str2.replace("%s", stringBuffer));
        ((h) g.h(h.class)).aZO().Q(auVar);
    }
}
