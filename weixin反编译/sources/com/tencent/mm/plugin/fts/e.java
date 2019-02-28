package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.List;

public final class e implements i {
    public final Cursor i(String str, String[] strArr) {
        g.Dr();
        return g.Dq().gRV.a(str, strArr, 2);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        g.Dr();
        return g.Dq().gRV.a(str, strArr, 0);
    }

    public final x BB(String str) {
        x Xq = ((h) g.h(h.class)).Ff().Xq(str);
        if (Xq == null) {
            Xq = new x();
            Cursor i = i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[]{str});
            if (i.moveToNext()) {
                Xq.gKO = i.getLong(0);
                Xq.setUsername(i.getString(1));
                Xq.cZ(i.getString(2));
                Xq.da(i.getString(3));
                Xq.dc(i.getString(4));
                Xq.ez(i.getInt(5));
                Xq.setType(i.getInt(6));
                Xq.z(i.getBlob(7));
                Xq.dj(i.getString(8));
                Xq.eB(0);
            }
            i.close();
        }
        return Xq;
    }

    public final boolean BC(String str) {
        Cursor i = i(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[]{str});
        try {
            boolean moveToNext = i.moveToNext();
            return moveToNext;
        } finally {
            if (i != null) {
                i.close();
            }
        }
    }

    public final long BD(String str) {
        Cursor i = i("SELECT conversationTime FROM rconversation WHERE username=?;", new String[]{str});
        long j = 0;
        if (i != null && i.moveToFirst()) {
            j = i.getLong(0);
        }
        if (i != null) {
            i.close();
        }
        return j;
    }

    public final List<String> BE(String str) {
        List arrayList = new ArrayList();
        if (str.endsWith("\u0000")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.length() != 0) {
            Cursor i = i(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[]{str}), null);
            while (i.moveToNext()) {
                arrayList.add(i.getString(0));
            }
            i.close();
        }
        return arrayList;
    }
}
