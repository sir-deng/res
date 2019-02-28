package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ao;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class q implements ap {
    public static HashMap<Integer, d> gyG;
    private b hIT;
    private com.tencent.mm.storage.ap hIU;

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.storage.ap.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        this.hIU = new com.tencent.mm.storage.ap(g.Dq().gRU);
        b Qk = Qk();
        x.i("MicroMsg.SubCoreSync", "getChatRoomMsgService %s", Qk);
        if (Qk != null) {
            Ql().Qi().a(Qk, as.Dt().oFY.getLooper());
            ((h) g.h(h.class)).aZO().a(Qk.hGq, as.Dt().oFY.getLooper());
            as.Dt().F(new Runnable() {
                public final void run() {
                    Cursor Tq = q.Ql().Qi().Tq();
                    if (Tq != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        if (Tq.moveToFirst()) {
                            while (!Tq.isAfterLast()) {
                                ao aoVar = new ao();
                                aoVar.b(Tq);
                                if (aoVar.field_originSvrId != 0) {
                                    if (currentTimeMillis > 604800000 + (aoVar.field_createTime * 1000)) {
                                        arrayList.add(aoVar);
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d] but expired and delete", Long.valueOf(aoVar.field_originSvrId));
                                    } else {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d]", Long.valueOf(aoVar.field_originSvrId));
                                        b.this.hGp.put(Long.valueOf(aoVar.field_originSvrId), aoVar);
                                    }
                                }
                                Tq.moveToNext();
                            }
                        }
                        Tq.close();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ao aoVar2 = (ao) it.next();
                            q.Ql().Qi().a((com.tencent.mm.sdk.e.c) aoVar2, false, "");
                        }
                    }
                }
            });
        }
    }

    public final com.tencent.mm.storage.ap Qi() {
        g.Dr();
        g.Do().CA();
        return this.hIU;
    }

    public static r Qj() {
        return ((b) g.h(b.class)).Qj();
    }

    public static b Qk() {
        g.Do().CA();
        if (Ql().hIT == null) {
            Ql().hIT = new b();
        }
        return Ql().hIT;
    }

    public static q Ql() {
        as.Hg();
        q qVar = (q) bq.ib(q.class.getName());
        if (qVar != null) {
            return qVar;
        }
        Object qVar2 = new q();
        as.Hg().a(q.class.getName(), qVar2);
        return qVar2;
    }

    public final void onAccountRelease() {
        Object obj = Ql().hIT;
        if (obj != null) {
            x.i("MicroMsg.GetChatRoomMsgService", "clear clearList.size:%d needGetInfosMap.size:%d respList.size:%d, currentListener:%s", Integer.valueOf(obj.hGn.size()), Integer.valueOf(obj.hGm.size()), Integer.valueOf(obj.hAk.size()), obj.hGo);
            obj.hAo.TN();
            obj.hAp.TN();
            obj.hGn.clear();
            obj.hGm.clear();
            obj.hAk.clear();
            obj.hGo = null;
            obj.hmq = false;
            Ql().Qi().j(obj);
            ((h) g.h(h.class)).aZO().a(obj.hGq);
        }
    }
}
