package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.af.a.a;
import com.tencent.mm.af.a.e;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.f;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bb;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class o extends e {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )"};

    public o(c cVar) {
        super(cVar);
        a(aZR(), "bizchatmessage");
        a(new b(16, "bizchatmessage", b.a(2500001, 3000000, 99000001, 102000000)));
    }

    public final String WW(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (f.eG(str)) {
            return "bizchatmessage";
        }
        return null;
    }

    private static String an(String str, long j) {
        return " bizChatId= " + j + " AND talker= '" + str + "'";
    }

    public final au ao(String str, long j) {
        if (bi.oN(str)) {
            return null;
        }
        au auVar = new au();
        Cursor a = aZR().a("select * from " + Fw(str) + " where" + an(str, j) + "order by createTime DESC limit 1", null, 0);
        if (a.getCount() != 0) {
            a.moveToFirst();
            auVar.b(a);
        }
        a.close();
        return auVar;
    }

    public final List<au> h(String str, long j, int i) {
        List<au> arrayList = new ArrayList();
        Cursor a = aZR().a("SELECT * FROM " + Fw(str) + " WHERE" + an(str, j) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + i, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                au auVar = new au();
                auVar.b(a);
                a.moveToNext();
                if (auVar.cjV()) {
                    arrayList.add(auVar);
                }
            }
        }
        a.close();
        return arrayList;
    }

    protected final boolean a(au auVar, bb.b bVar) {
        if (auVar == null) {
            x.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
            return false;
        }
        auVar.ar(-1);
        if (bVar != null) {
            if (f.eG(auVar.field_talker)) {
                if (bi.oN(bVar.hiu)) {
                    x.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", auVar.gkD);
                    return false;
                }
                com.tencent.mm.af.a.c cVar = new com.tencent.mm.af.a.c();
                cVar.field_bizChatServId = bVar.hiu;
                cVar.field_brandUserName = auVar.field_talker;
                if (!bi.oN(bVar.hiv)) {
                    cVar.field_chatVersion = bi.getInt(bVar.hiv, -1);
                }
                if (!bi.oN(bVar.hit)) {
                    cVar.field_chatType = bi.getInt(bVar.hit, -1);
                }
                x.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", bVar.hiu, bVar.userId);
                cVar = e.e(cVar);
                if (cVar != null) {
                    auVar.ar(cVar.field_bizChatLocalId);
                    auVar.field_bizChatUserId = bi.oM(bVar.userId);
                    auVar.gkr = true;
                    if (bVar.hix.equals("1")) {
                        auVar.eS(1);
                    }
                    if (!(auVar.field_isSend == 1 || bVar.userId == null)) {
                        if (bVar.userId.equals(y.Mp().cb(auVar.field_talker))) {
                            auVar.eS(1);
                        }
                    }
                    if (!bi.oN(bVar.userId)) {
                        j jVar = new j();
                        jVar.field_userId = bVar.userId;
                        jVar.field_userName = bVar.hiw;
                        jVar.field_brandUserName = auVar.field_talker;
                        y.Mp().c(jVar);
                    }
                } else {
                    x.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
                    return false;
                }
            } else if (!bi.oN(bVar.hiu)) {
                x.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
                return false;
            }
        }
        return true;
    }

    public final List<au> b(String str, long j, long j2, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", new StringBuilder("getImgMessage fail, argument is invalid, limit = 10").toString());
            return null;
        }
        long O = this.xuL.O(str, j2);
        if (O == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<au> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + Fw(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + an(str, j) + "AND " + this.xuL.aZZ() + " AND createTime > " + O + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + Fw(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + an(str, j) + "AND " + this.xuL.aZZ() + " AND createTime < " + O + "  order by createTime DESC limit 10";
        }
        Cursor a = aZR().a(str2, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                au auVar = new au();
                auVar.b(a);
                a.moveToNext();
                if (z) {
                    arrayList.add(auVar);
                } else {
                    arrayList.add(0, auVar);
                }
            }
        }
        a.close();
        x.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return arrayList;
    }

    public final Cursor ap(String str, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        Cursor a = aZR().a("select * from " + Fw(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + an(str, j) + "AND " + this.xuL.baa() + "  order by createTime", null, 0);
        x.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), r1);
        return a;
    }

    public final Cursor b(String str, long j, int i, int i2) {
        System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return aZR().a("select * from ( select * from " + Fw(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + an(str, j) + "AND " + this.xuL.aZZ() + " order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 0);
    }

    public final Cursor a(String str, long j, long j2, long j3) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        return aZR().a("select * from " + Fw(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + an(str, j) + "AND " + this.xuL.aZZ() + " AND createTime >= " + j2 + " AND createTime< " + j3 + " order by createTime ASC", null, 0);
    }

    public final int aq(String str, long j) {
        x.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", str, aj.cgv());
        fG(Fw(str), an(str, j));
        int delete = aZR().delete(Fw(str), an(str, j), null);
        if (delete != 0) {
            this.xuL.WI("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", null, delete, (byte) 0);
            cVar.ouF = -1;
            a(cVar);
        }
        return delete;
    }

    public final int Fj(String str) {
        x.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", str, aj.cgv());
        String str2 = "talker= '" + str + "'";
        fG(Fw(str), str2);
        int delete = aZR().delete(Fw(str), str2, null);
        if (delete != 0) {
            this.xuL.WI("delete_talker " + str);
            c.c cVar = new c.c(str, "delete", null, delete, (byte) 0);
            cVar.ouF = -1;
            a(cVar);
        }
        return delete;
    }

    public final Cursor ar(String str, long j) {
        return aZR().query(Fw(str), null, an(str, j), null, null, null, "createTime ASC ");
    }

    public final Cursor i(String str, long j, int i) {
        x.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", str, Long.valueOf(j), Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + Fw(str) + " WHERE" + an(str, j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        return aZR().a("SELECT * FROM ( SELECT * FROM " + Fw(str) + " WHERE" + an(str, j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null, 0);
    }

    public final int as(String str, long j) {
        if (str == null) {
            x.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", str, Long.valueOf(j));
            return -1;
        }
        a aT = y.Mo().aT(j);
        if (aT.field_msgCount != 0) {
            return aT.field_msgCount;
        }
        x.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", str);
        return at(str, j);
    }

    public final int at(String str, long j) {
        int i = 0;
        x.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", "SELECT COUNT(*) FROM " + Fw(str) + " WHERE " + an(str, j));
        Cursor a = aZR().a(r1, null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int au(String str, long j) {
        int i = 0;
        Cursor a = aZR().a("SELECT COUNT(*) FROM " + this.xuL.Fw(str) + " WHERE " + an(str, j) + "AND " + this.xuL.aZZ(), null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final int t(String str, long j, long j2) {
        int i = 0;
        cg dI = this.xuL.dI(j2);
        if (dI.field_msgId == 0) {
            x.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            Cursor a = aZR().a("SELECT COUNT(*) FROM " + Fw(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + an(str, j) + "AND " + this.xuL.aZZ() + " AND createTime < " + dI.field_createTime, null, 0);
            if (a.moveToLast()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final long av(String str, long j) {
        String str2 = "select createTime from " + Fw(str) + " where" + an(str, j) + "order by createTime DESC LIMIT 1 ";
        x.d("MicroMsg.BizChatMessageStorage", "get last message create time: " + str2);
        Cursor a = aZR().a(str2, null, 0);
        if (a == null) {
            x.e("MicroMsg.BizChatMessageStorage", "get last message create time failed " + str);
            return -1;
        } else if (a.moveToFirst()) {
            long j2 = a.getLong(0);
            a.close();
            return j2;
        } else {
            a.close();
            return -1;
        }
    }

    public final int b(String str, long j, long j2, long j3) {
        if (j3 >= j2) {
            long j4 = j3;
            j3 = j2;
            j2 = j4;
        }
        x.d("MicroMsg.BizChatMessageStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j3), Long.valueOf(j2));
        String str2 = "SELECT COUNT(msgId) FROM " + Fw(str) + " WHERE" + an(str, j) + "AND createTime >= " + j3 + " AND createTime <= " + j2;
        x.d("MicroMsg.BizChatMessageStorage", "get count sql: " + str2);
        Cursor a = aZR().a(str2, null, 0);
        if (a == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get count error, cursor is null");
            return 0;
        } else if (a.moveToFirst()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg count %d", Integer.valueOf(a.getInt(0)));
            a.close();
            return a.getInt(0);
        } else {
            a.close();
            return 0;
        }
    }

    public final Cursor c(String str, long j, long j2, long j3) {
        if (j3 >= j2) {
            long j4 = j3;
            j3 = j2;
            j2 = j4;
        }
        String str2 = "SELECT * FROM " + Fw(str) + " WHERE" + an(str, j) + "AND createTime >= " + j3 + " AND createTime <= " + j2 + " ORDER BY createTime ASC ";
        x.d("MicroMsg.BizChatMessageStorage", "get cursor: " + str2);
        return aZR().a(str2, null, 0);
    }

    public final long u(String str, long j, long j2) {
        x.d("MicroMsg.BizChatMessageStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), Integer.valueOf(18));
        x.d("MicroMsg.BizChatMessageStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + Fw(str) + " WHERE" + an(str, j) + "AND createTime < " + j2 + " ORDER BY createTime DESC  LIMIT 18");
        Cursor a = aZR().a(r0, null, 0);
        if (a == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get inc msg create time error, cursor is null");
            return j2;
        } else if (a.moveToLast()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            x.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }

    public final long v(String str, long j, long j2) {
        x.d("MicroMsg.BizChatMessageStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), Integer.valueOf(18));
        x.d("MicroMsg.BizChatMessageStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + Fw(str) + " WHERE" + an(str, j) + "AND createTime > " + j2 + " ORDER BY createTime ASC  LIMIT 18");
        Cursor a = aZR().a(r0, null, 0);
        if (a == null) {
            x.w("MicroMsg.BizChatMessageStorage", "get down inc msg create time error, cursor is null");
            return j2;
        } else if (a.moveToLast()) {
            x.d("MicroMsg.BizChatMessageStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            return a.getLong(0);
        } else {
            a.close();
            x.w("MicroMsg.BizChatMessageStorage", "get result fail");
            return j2;
        }
    }
}
