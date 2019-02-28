package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.af.a;
import com.tencent.mm.ui.chatting.viewitems.af.b;
import com.tencent.mm.ui.chatting.viewitems.al.f;
import com.tencent.mm.ui.chatting.viewitems.al.g;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import com.tencent.mm.ui.chatting.viewitems.c.e;
import com.tencent.mm.ui.chatting.viewitems.i.c;
import com.tencent.mm.ui.chatting.viewitems.n.j;
import java.util.ArrayList;
import java.util.List;

public final class as {
    private static final List<b> yXD;

    public static b bs(au auVar) {
        for (b bVar : yXD) {
            if (bVar.ak(auVar.getType(), auVar.field_isSend == 1)) {
                try {
                    return (b) bVar.getClass().newInstance();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Chatting.ItemFactory", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    public static int cws() {
        return yXD.size() + 2;
    }

    public static int bt(au auVar) {
        for (int i = 0; i < yXD.size(); i++) {
            if (((b) yXD.get(i)).ak(auVar.getType(), auVar.field_isSend == 1)) {
                return i;
            }
        }
        return 0;
    }

    static {
        List arrayList = new ArrayList();
        yXD = arrayList;
        arrayList.add(new b());
        yXD.add(new a());
        yXD.add(new e());
        yXD.add(new d());
        yXD.add(new c());
        yXD.add(new i.b());
        yXD.add(new l.c());
        yXD.add(new l.b());
        yXD.add(new h.d());
        yXD.add(new h.c());
        yXD.add(new ac());
        yXD.add(new x.b());
        yXD.add(new s.b());
        yXD.add(new s.a());
        yXD.add(new ah.a());
        yXD.add(new ah.b());
        yXD.add(new z.a());
        yXD.add(new o.c());
        yXD.add(new o.b());
        yXD.add(new t.a());
        yXD.add(new ag.b());
        yXD.add(new ag.a());
        yXD.add(new y.b());
        yXD.add(new y.a());
        yXD.add(new f());
        yXD.add(new al.c());
        yXD.add(new g());
        yXD.add(new j());
        yXD.add(new al.d());
        yXD.add(new al.e());
        yXD.add(new ak());
        yXD.add(new ai());
        yXD.add(new aj());
        yXD.add(new ab.a());
        yXD.add(new ab.b());
        yXD.add(new am.c());
        yXD.add(new am.b());
        yXD.add(new q());
        yXD.add(new j.b());
        yXD.add(new j.c());
        yXD.add(new u());
        yXD.add(new v());
        yXD.add(new w());
        yXD.add(new k.c());
        yXD.add(new k.b());
        yXD.add(new d.c());
        yXD.add(new d.b());
        yXD.add(new g.c());
        yXD.add(new g.b());
        yXD.add(new e.c());
        yXD.add(new e.b());
        yXD.add(new f.c());
        yXD.add(new f.b());
        yXD.add(new m.b());
        yXD.add(new m.a());
        yXD.add(new x.a());
        yXD.add(new b() {
            public final boolean ak(int i, boolean z) {
                x.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", Integer.valueOf(i), Boolean.valueOf(z));
                return z;
            }
        });
        yXD.add(new a() {
            public final boolean ak(int i, boolean z) {
                x.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", Integer.valueOf(i), Boolean.valueOf(z));
                if (z) {
                    return false;
                }
                return true;
            }
        });
    }
}
