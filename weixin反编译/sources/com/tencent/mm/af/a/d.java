package com.tencent.mm.af.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.f.b.v;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicLong;

public final class d extends i<v> {
    public static final String[] gLy = new String[]{i.a(c.gKN, "BizChatInfo")};
    public e gLA;
    final k<a, b> hpN = new k<a, b>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };
    private AtomicLong hst = new AtomicLong(-1);

    public interface a {

        public enum a {
            ;

            static {
                hsv = 1;
                hsw = 2;
                hsx = 3;
                hsy = new int[]{hsv, hsw, hsx};
            }
        }

        public static class b {
            public String fsi;
            public c hsA;
            public long hsp;
            public int hsz;
        }

        void a(b bVar);
    }

    public d(e eVar) {
        super(eVar, c.gKN, "BizChatInfo", null);
        this.gLA = eVar;
        eVar.fD("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
        eVar.fD("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
        eVar.fD("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
        synchronized (this.hst) {
            Cursor a = this.gLA.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
            long j = 0;
            if (a.moveToFirst()) {
                j = (long) a.getInt(0);
                if (j > this.hst.get()) {
                    this.hst.set(j);
                }
            }
            a.close();
            x.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:" + j);
        }
    }

    public final void a(a aVar, Looper looper) {
        this.hpN.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hpN != null) {
            this.hpN.remove(aVar);
        }
    }

    public final c ag(long j) {
        c cVar = new c();
        cVar.field_bizChatLocalId = j;
        super.b(cVar, new String[0]);
        return cVar;
    }

    public final c ko(String str) {
        c cVar = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * ");
        stringBuilder.append(" from BizChatInfo");
        stringBuilder.append(" where bizChatServId = '").append(str).append("' ");
        stringBuilder.append(" limit 1");
        x.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", stringBuilder.toString());
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return cVar;
    }

    public final boolean aU(long j) {
        c ag = ag(j);
        boolean a = super.a(ag, "bizChatLocalId");
        if (a) {
            b bVar = new b();
            bVar.hsp = ag.field_bizChatLocalId;
            bVar.fsi = ag.field_brandUserName;
            bVar.hsz = a.hsw;
            bVar.hsA = ag;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        }
        return a;
    }

    public final boolean a(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
            return false;
        } else if (bi.oN(cVar.field_bizChatServId)) {
            x.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
            return false;
        } else {
            c ko = ko(cVar.field_bizChatServId);
            if (ko != null) {
                cVar.field_bizChatLocalId = ko.field_bizChatLocalId;
                x.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
                return true;
            }
            cVar.field_bizChatLocalId = MB();
            boolean b = super.b((c) cVar);
            if (!b) {
                return b;
            }
            b bVar = new b();
            bVar.hsp = cVar.field_bizChatLocalId;
            bVar.fsi = cVar.field_brandUserName;
            bVar.hsz = a.hsv;
            bVar.hsA = cVar;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
            return b;
        }
    }

    public final boolean b(c cVar) {
        boolean z = false;
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
        } else if (cVar.field_bizChatLocalId < 0) {
            x.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
        } else {
            c ag = ag(cVar.field_bizChatLocalId);
            if (bi.oN(ag.field_bizChatServId) || ag.field_bizChatServId.equals(cVar.field_bizChatServId)) {
                if (cVar == null || bi.oN(cVar.field_chatName)) {
                    x.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
                } else {
                    cVar.field_chatNamePY = com.tencent.mm.platformtools.c.oD(cVar.field_chatName);
                }
                z = super.a(cVar);
                if (z) {
                    e.g(cVar);
                    b bVar = new b();
                    bVar.hsp = cVar.field_bizChatLocalId;
                    bVar.fsi = cVar.field_brandUserName;
                    bVar.hsz = a.hsx;
                    bVar.hsA = cVar;
                    this.hpN.cb(bVar);
                    this.hpN.doNotify();
                }
            } else {
                x.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
            }
        }
        return z;
    }

    private long MB() {
        synchronized (this.hst) {
            x.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", Long.valueOf(this.hst.incrementAndGet()));
        }
        return r2;
    }
}
