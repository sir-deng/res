package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.f.b.dr;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.List;

public final class s extends dr {
    protected static a gKN;
    public int rvx;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tagId";
        aVar.xrT.put("tagId", "LONG default '0' ");
        stringBuilder.append(" tagId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "tagName";
        aVar.xrT.put("tagName", "TEXT default '' ");
        stringBuilder.append(" tagName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "count";
        aVar.xrT.put("count", "INTEGER default '0' ");
        stringBuilder.append(" count INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "memberList";
        aVar.xrT.put("memberList", "TEXT default '' ");
        stringBuilder.append(" memberList TEXT default '' ");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final void bU(List<bet> list) {
        this.field_memberList = "";
        for (bet bet : list) {
            this.field_memberList += bet.wRo + ",";
        }
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.rvx = (int) this.xrR;
    }
}
