package com.tencent.mm.storage;

import com.tencent.mm.f.b.dt;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bf extends dt {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "encryptUsername";
        aVar.xrT.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "encryptUsername";
        aVar.columns[1] = "conRemark";
        aVar.xrT.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactLabels";
        aVar.xrT.put("contactLabels", "TEXT default '' ");
        stringBuilder.append(" contactLabels TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "conDescription";
        aVar.xrT.put("conDescription", "TEXT default '' ");
        stringBuilder.append(" conDescription TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "conPhone";
        aVar.xrT.put("conPhone", "TEXT default '' ");
        stringBuilder.append(" conPhone TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public bf(String str) {
        this();
        this.field_conRemark = "";
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
    }

    public bf(String str, String str2) {
        this();
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
        if (str2 == null) {
            str2 = "";
        }
        this.field_conRemark = str2;
    }

    public bf() {
        this.field_encryptUsername = "";
        this.field_conRemark = "";
    }

    public final String vZ() {
        return this.field_encryptUsername;
    }

    public final String vV() {
        return this.field_conRemark;
    }

    protected final Object clone() {
        return super.clone();
    }
}
