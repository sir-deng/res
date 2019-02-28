package com.tencent.mm.plugin.appbrand.q;

import android.database.Cursor;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    private static LinkedList<d> gDp = new LinkedList();
    private static HashSet<a> jXn = new HashSet();
    private static boolean jXo = false;
    private static boolean jXp = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.q.b$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String gKi;
        final /* synthetic */ int jXq = 10;

        AnonymousClass1(String str, int i) {
            this.gKi = str;
        }

        public final void run() {
            q hG;
            b.gDp.clear();
            if (s.eX(this.gKi)) {
                hG = ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fo().hG(this.gKi);
            } else {
                hG = null;
            }
            int i = 0;
            int i2 = 100;
            while (true) {
                int i3 = i;
                if (i2 < 100 || b.gDp.size() >= this.jXq) {
                    x.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", Integer.valueOf(b.gDp.size()));
                    ah.y(new Runnable() {
                        public final void run() {
                            b.done();
                        }
                    });
                } else {
                    Cursor bB = ((h) g.h(h.class)).aZO().bB(this.gKi, i3);
                    if (bB != null) {
                        i2 = bB.getCount();
                    } else {
                        i2 = 0;
                    }
                    while (bB != null && bB.moveToNext()) {
                        cg auVar = new au();
                        auVar.ao(bB.getLong(0));
                        auVar.ap(bB.getLong(1));
                        auVar.aq(bB.getLong(2));
                        auVar.setContent(bB.getString(3));
                        auVar.eS(bB.getInt(4));
                        String str = auVar.field_content;
                        if (str != null) {
                            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
                            if (fV != null && b.lY(fV.type)) {
                                Object obj;
                                String a = b.a(auVar, s.eX(this.gKi), this.gKi);
                                ag Xv = ((h) g.h(h.class)).Ff().Xv(a);
                                String str2 = "";
                                if (hG != null) {
                                    str2 = hG.gw(a);
                                }
                                d dVar = new d(auVar.field_createTime, fV.type, fV.title, auVar.field_msgId, Xv.field_username, Xv.AW(), Xv.field_conRemark, str2, bi.aD(fV.hfj, fV.appId), fV, auVar.field_msgSvrId);
                                Iterator it = b.gDp.iterator();
                                while (it.hasNext()) {
                                    if (bi.fA(dVar.hfj, ((d) it.next()).hfj)) {
                                        obj = 1;
                                        break;
                                    }
                                }
                                obj = null;
                                if (obj == null) {
                                    dVar.desc = fV.title;
                                    WxaAttributes rf = ((c) g.h(c.class)).rf(dVar.fFo.hfi);
                                    if (rf != null) {
                                        str = rf.field_nickname;
                                    } else {
                                        try {
                                            str = dVar.fFo.fHv;
                                        } catch (Throwable th) {
                                            if (bB != null) {
                                                bB.close();
                                            }
                                        }
                                    }
                                    dVar.title = str;
                                    dVar.imagePath = rf != null ? rf.field_brandIconURL : dVar.fFo.hfr;
                                    b.gDp.add(dVar);
                                }
                                if (b.gDp.size() >= this.jXq) {
                                    break;
                                }
                            }
                        }
                    }
                    if (bB != null) {
                        bB.close();
                    }
                    i = i3 + i2;
                }
            }
            x.i("MicroMsg.AppBrandHistoryListLogic", "[loadData] data:%s", Integer.valueOf(b.gDp.size()));
            ah.y(/* anonymous class already generated */);
        }
    }

    public interface a {
        void u(LinkedList<d> linkedList);
    }

    public static synchronized void reset() {
        synchronized (b.class) {
            jXo = false;
            jXp = false;
            gDp.clear();
            jXn.clear();
        }
    }

    public static synchronized void a(String str, a aVar) {
        synchronized (b.class) {
            if (jXo) {
                jXn.add(aVar);
            } else if (jXp) {
                aVar.u(gDp);
            } else {
                jXo = true;
                jXn.add(aVar);
                g.Dr();
                g.Dt().F(new AnonymousClass1(str, 10));
            }
        }
    }

    private static synchronized void done() {
        synchronized (b.class) {
            x.i("MicroMsg.AppBrandHistoryListLogic", "done");
            jXp = true;
            jXo = false;
            Iterator it = jXn.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.u(gDp);
                }
            }
            jXn.clear();
        }
    }

    public static boolean lY(int i) {
        return 33 == i || 36 == i;
    }

    protected static String a(au auVar, boolean z, String str) {
        if (auVar.field_isSend == 1) {
            return com.tencent.mm.y.q.FY();
        }
        String str2 = null;
        if (z) {
            str2 = bb.hS(auVar.field_content);
        }
        if (bi.oN(str2)) {
            return str;
        }
        return str2;
    }
}
