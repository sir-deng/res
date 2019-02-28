package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements com.tencent.mm.ad.d {
    public final b b(a aVar) {
        int i = 1;
        bx bxVar = aVar.hoa;
        if (bxVar == null) {
            x.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
        } else if (bxVar.nlX != 56) {
            x.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", Integer.valueOf(bxVar.nlX));
        } else {
            String a = n.a(bxVar.vNM);
            String a2 = n.a(bxVar.vNN);
            as.Hm();
            if (!((String) c.Db().get(2, null)).equals(a)) {
                a2 = a;
            }
            as.Hm();
            com.tencent.mm.k.a Xv = c.Ff().Xv(a2);
            if (Xv == null || ((int) Xv.gKO) == 0) {
                as.Hm();
                c.Ff().S(new com.tencent.mm.storage.x(a2));
            }
            String a3 = n.a(bxVar.vNO);
            x.d("MicroMsg.TalkRoomExtension", "talkroom xml:" + a3);
            Map y = bj.y(a3, "talkroominfo");
            if (y != null) {
                try {
                    int i2;
                    String str;
                    String bc;
                    if (MV((String) y.get(".talkroominfo.tracksysmsgtype")) == 0) {
                        MV((String) y.get(".talkroominfo.sysmsgtype"));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    Object linkedList = new LinkedList();
                    MV((String) y.get(".talkroominfo.membersize"));
                    int i3 = 0;
                    while (true) {
                        str = ".talkroominfo.memberlist.member" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        a3 = (String) y.get(str + ".username");
                        if (bi.oN(a3)) {
                            break;
                        }
                        int MV = MV((String) y.get(str + ".memberid"));
                        bot bot = new bot();
                        bot.kyG = a3;
                        bot.wXZ = MV;
                        linkedList.add(bot);
                        i3++;
                    }
                    if (a2.equals(b.bFm().shV)) {
                        str = bb(linkedList);
                        bc = bi.oN(str) ? bc(linkedList) : null;
                    } else {
                        bc = null;
                        str = null;
                    }
                    e bFn = b.bFn();
                    if (i2 != 0) {
                        i = 0;
                    }
                    bFn.a(a2, linkedList, str, bc, i);
                } catch (Throwable e) {
                    x.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
                    x.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }

    private static int MV(String str) {
        int i = 0;
        if (bi.oN(str)) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[i]);
            return i;
        }
    }

    private static String bb(List<bot> list) {
        List<bot> aWi = b.bFm().aWi();
        List linkedList = new LinkedList();
        for (bot bot : list) {
            Object obj;
            for (bot bot2 : aWi) {
                if (bot2.kyG.equals(bot.kyG)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(bot.kyG);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(q.FY())) {
                return str;
            }
        }
        return null;
    }

    private static String bc(List<bot> list) {
        List<bot> aWi = b.bFm().aWi();
        List linkedList = new LinkedList();
        for (bot bot : aWi) {
            Object obj;
            for (bot bot2 : list) {
                if (bot2.kyG.equals(bot.kyG)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(bot.kyG);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(q.FY())) {
                return str;
            }
        }
        return null;
    }
}
