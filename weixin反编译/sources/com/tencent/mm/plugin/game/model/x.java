package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;

public final class x extends i<t> {
    public static final String[] gLy = new String[]{i.a(t.gKN, "GameRawMessage")};

    public x(e eVar) {
        super(eVar, t.gKN, "GameRawMessage", null);
    }

    public final t dw(long j) {
        c tVar = new t();
        tVar.field_msgId = j;
        return b(tVar, new String[0]) ? tVar : null;
    }

    public final LinkedList<t> b(int i, long j, int i2, int i3) {
        Object obj;
        String str;
        if (j == 0) {
            obj = "9223372036854775807";
        } else {
            String obj2 = String.valueOf(j);
        }
        if (i2 == 0) {
            str = "(isRead=1 or isRead=0) ";
        } else if (i2 == 1) {
            str = "isRead=0 ";
        } else if (i2 != 2) {
            return null;
        } else {
            str = "isRead=1 ";
        }
        String str2 = "";
        if (i != 65536) {
            str2 = "msgType=" + i + " and ";
        }
        String valueOf = String.valueOf(i3);
        str2 = String.format("select * from GameRawMessage where " + str2 + "msgId<%s and " + str + "order by createTime desc limit %s", new Object[]{obj2, valueOf});
        LinkedList<t> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery(str2, new String[0]);
        if (rawQuery == null) {
            return linkedList;
        }
        if (rawQuery.moveToFirst()) {
            do {
                t tVar = new t();
                tVar.b(rawQuery);
                linkedList.add(tVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return linkedList;
    }

    public final LinkedList<t> aRb() {
        LinkedList<t> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from GameRawMessage where msgType=20", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    t tVar = new t();
                    tVar.b(rawQuery);
                    linkedList.add(tVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public final t CB(String str) {
        Cursor rawQuery = rawQuery("select * from GameRawMessage where msgType=20 and appId= \"" + str + "\" limit 1", new String[0]);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            t tVar = new t();
            tVar.b(rawQuery);
            return tVar;
        }
        rawQuery.close();
        return null;
    }

    public final boolean e(long[] jArr) {
        if (jArr.length == 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("msgId in (");
        for (int i = 0; i < jArr.length; i++) {
            stringBuilder.append(jArr[i]);
            if (i != jArr.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        String stringBuilder2 = stringBuilder.toString();
        return fD("GameRawMessage", String.format("update GameRawMessage set isRead=1 where %s", new Object[]{stringBuilder2}));
    }

    public final void aRc() {
        fD("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
    }

    public final void aRd() {
        String str = "GameRawMessage";
        fD(str, "update GameRawMessage set isRead=1 where isRead=0 and " + j(2, 5, 6, 10, 11, 100) + " and isHidden = 0");
    }

    public final int aRe() {
        int i = 0;
        Cursor rawQuery = rawQuery("select count(*) from GameRawMessage where " + j(2, 5, 6, 10, 11, 100) + " and isRead=0 and showInMsgList" + " = 1 and isHidden" + " = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public static String j(int... iArr) {
        String str = "" + "(";
        for (int i = 0; i < 5; i++) {
            str = str + "msgType=" + iArr[i] + " or ";
        }
        return (str + "msgType=" + iArr[5]) + ")";
    }
}
