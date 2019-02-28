package com.tencent.mm.af.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.af.f;
import com.tencent.mm.af.o;
import com.tencent.mm.af.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.s;

public final class b extends i<a> implements com.tencent.mm.sdk.e.m.b {
    public static final String[] gLy = new String[]{i.a(a.gKN, "BizChatConversation")};
    public e gLA;
    final k<a, b> hpN = new k<a, b>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };

    public interface a {

        public enum a {
            ;

            static {
                hsk = 1;
                hsl = 2;
                hsm = 3;
                hsn = new int[]{hsk, hsl, hsm};
            }
        }

        public static class b {
            public String fsi;
            public int hso;
            public long hsp;
            public a hsq;
        }

        void a(b bVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((a) cVar);
    }

    public b(e eVar) {
        super(eVar, a.gKN, "BizChatConversation", null);
        this.gLA = eVar;
        eVar.fD("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
        eVar.fD("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
        eVar.fD("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        Object obj = null;
        Cursor a = eVar.a("PRAGMA table_info( BizChatConversation)", null, 2);
        while (a.moveToNext()) {
            int columnIndex = a.getColumnIndex("name");
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(a.getString(columnIndex))) {
                    obj = 1;
                    break;
                }
            }
        }
        a.close();
        if (obj == null) {
            eVar.fD("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
        }
        ((h) g.h(h.class)).Ff().a(this);
    }

    protected final void finalize() {
        ((h) g.h(h.class)).Ff().b(this);
    }

    public final void a(a aVar, Looper looper) {
        this.hpN.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hpN != null) {
            this.hpN.remove(aVar);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        x.i("MicroMsg.BizConversationStorage", "onNotifyChange");
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (f.eG(str) && !s.gH(str)) {
                e.A(str, true);
            }
        }
    }

    public final a aT(long j) {
        c aVar = new a();
        aVar.field_bizChatId = j;
        super.b(aVar, new String[0]);
        return aVar;
    }

    public final boolean aU(long j) {
        c aT = aT(j);
        boolean a = super.a(aT, "bizChatId");
        if (a) {
            b bVar = new b();
            bVar.hsp = aT.field_bizChatId;
            bVar.fsi = aT.field_brandUserName;
            bVar.hso = a.hsl;
            bVar.hsq = aT;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        }
        return a;
    }

    public final boolean a(a aVar) {
        x.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
        if (aVar == null) {
            x.w("MicroMsg.BizConversationStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b((c) aVar);
        x.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", Boolean.valueOf(b));
        if (b) {
            b bVar = new b();
            bVar.hsp = aVar.field_bizChatId;
            bVar.fsi = aVar.field_brandUserName;
            bVar.hso = a.hsk;
            bVar.hsq = aVar;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        }
        return b;
    }

    public final boolean b(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.BizConversationStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a(aVar);
        x.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", Boolean.valueOf(a));
        if (a) {
            e.g(y.Mn().ag(aVar.field_bizChatId));
            b bVar = new b();
            bVar.hsp = aVar.field_bizChatId;
            bVar.fsi = aVar.field_brandUserName;
            bVar.hso = a.hsm;
            bVar.hsq = aVar;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        }
        return a;
    }

    public final Cursor km(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" order by flag desc , ").append("lastMsgTime desc");
        x.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", stringBuilder.toString());
        return this.gLA.rawQuery(stringBuilder.toString(), null);
    }

    public static void a(a aVar, int i, int i2) {
        if (aVar.field_msgCount == 0) {
            aVar.field_msgCount = ((o) g.h(o.class)).Fi().at(aVar.field_brandUserName, aVar.field_bizChatId);
            x.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aVar.field_msgCount -= i;
            if (aVar.field_msgCount < 0) {
                x.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
                aVar.field_msgCount = 0;
            }
        } else if (i2 > 0) {
            aVar.field_msgCount += i2;
        }
        x.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(aVar.field_msgCount), Long.valueOf(aVar.field_bizChatId), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final boolean aV(long j) {
        a aT = aT(j);
        if (!(aT.field_unReadCount == 0 && aT.field_bizChatId == j)) {
            aT.field_unReadCount = 0;
            aT.field_atCount = 0;
            b(aT);
        }
        return true;
    }

    public static long a(a aVar, int i, long j) {
        if (aVar == null) {
            return 0;
        }
        if (j == 0) {
            j = bi.Wy();
        }
        switch (i) {
            case 2:
                return a(aVar, j) | 4611686018427387904L;
            case 3:
                return a(aVar, j) & -4611686018427387905L;
            case 4:
                return a(aVar, j) & 4611686018427387904L;
            default:
                return a(aVar, j);
        }
    }

    private static long a(a aVar, long j) {
        return (aVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }

    public final boolean aW(long j) {
        return c(aT(j));
    }

    public static boolean c(a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (a(aVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean aX(long j) {
        aT(j);
        a aT = aT(j);
        boolean fD = this.gLA.fD("BizChatConversation", "update BizChatConversation set flag = " + a(aT, 2, 0) + " where bizChatId = " + aT.field_bizChatId);
        if (fD) {
            aT = aT(aT.field_bizChatId);
            b bVar = new b();
            bVar.hsp = aT.field_bizChatId;
            bVar.fsi = aT.field_brandUserName;
            bVar.hso = a.hsm;
            bVar.hsq = aT;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        }
        return fD;
    }

    public final boolean aY(long j) {
        a aT = aT(j);
        boolean fD = this.gLA.fD("BizChatConversation", "update BizChatConversation set flag = " + a(aT, 3, aT.field_lastMsgTime) + " where bizChatId = " + aT.field_bizChatId);
        if (fD) {
            aT = aT(aT.field_bizChatId);
            b bVar = new b();
            bVar.hsp = aT.field_bizChatId;
            bVar.fsi = aT.field_brandUserName;
            bVar.hso = a.hsm;
            bVar.hsq = aT;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        }
        return fD;
    }
}
