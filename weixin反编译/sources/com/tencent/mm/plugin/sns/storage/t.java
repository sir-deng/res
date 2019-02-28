package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class t extends i<s> implements k {
    public static final String[] gLy = new String[]{i.a(s.gKN, "snsTagInfo2")};
    private e gLA;

    public t(e eVar) {
        super(eVar, s.gKN, "snsTagInfo2", null);
        this.gLA = eVar;
    }

    public final s eU(long j) {
        String stringBuilder = new StringBuilder("select *, rowid from snsTagInfo2 where tagId = ? ").toString();
        Cursor a = this.gLA.a(stringBuilder, new String[]{String.valueOf(j)}, 2);
        s sVar = new s();
        if (a.moveToFirst()) {
            sVar.b(a);
        }
        a.close();
        return sVar;
    }

    public final List<String> ep(long j) {
        s eU = eU(j);
        if (eU.field_memberList == null || eU.field_memberList.equals("")) {
            return new ArrayList();
        }
        return bi.F(eU.field_memberList.split(","));
    }

    public final String eq(long j) {
        return eU(j).field_tagName;
    }

    public final List<Long> bzB() {
        Cursor a = this.gLA.a("snsTagInfo2", new String[]{"tagId"}, null, null, null, null, null, 2);
        List<Long> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        return arrayList;
    }

    public final boolean a(s sVar) {
        if (sVar.field_tagId == 0) {
            return false;
        }
        long j = sVar.field_tagId;
        String stringBuilder = new StringBuilder("select *, rowid from snsTagInfo2 where tagId = ? ").toString();
        Cursor a = this.gLA.a(stringBuilder, new String[]{String.valueOf(j)}, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            super.a(sVar);
        } else {
            super.b((c) sVar);
        }
        return true;
    }

    public final int eV(long j) {
        return this.gLA.delete("snsTagInfo2", " tagId = ? ", new String[]{String.valueOf(j)});
    }

    public final boolean p(long j, String str) {
        String str2 = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5" + " AND  tagName  =\"" + bi.oL(str) + "\" AND  tagId != " + j;
        x.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist " + str2);
        Cursor a = this.gLA.a(str2, null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }

    public final Cursor getCursor() {
        return this.gLA.rawQuery(new StringBuilder("select *, rowid from snsTagInfo2 where tagId > 5").toString(), null);
    }

    public final boolean ac(String str, long j) {
        s eU = eU(5);
        if (bi.oN(eU.field_memberList)) {
            return false;
        }
        return bi.F(eU.field_memberList.split(",")).contains(str);
    }

    public final boolean buS() {
        if (bzB().size() == 0) {
            return false;
        }
        return true;
    }
}
