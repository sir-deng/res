package com.tencent.mm.plugin.card.model;

import com.tencent.mm.f.b.cr;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ak extends cr {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cardUserId";
        aVar.xrT.put("cardUserId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "cardUserId";
        aVar.columns[1] = "retryCount";
        aVar.xrT.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ak)) {
            return false;
        }
        if (this.field_cardUserId == ((ak) obj).field_cardUserId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_cardUserId == null ? 0 : this.field_cardUserId.hashCode();
    }

    public static ak a(ky kyVar) {
        ak akVar = new ak();
        akVar.field_cardUserId = kyVar.vZy;
        return akVar;
    }
}
