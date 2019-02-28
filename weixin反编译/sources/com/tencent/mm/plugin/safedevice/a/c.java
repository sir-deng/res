package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.f.b.de;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends de {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "uid";
        aVar.xrT.put("uid", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "uid";
        aVar.columns[1] = "name";
        aVar.xrT.put("name", "TEXT default '' ");
        stringBuilder.append(" name TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "devicetype";
        aVar.xrT.put("devicetype", "TEXT default '' ");
        stringBuilder.append(" devicetype TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createtime";
        aVar.xrT.put("createtime", "LONG default '0' ");
        stringBuilder.append(" createtime LONG default '0' ");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public c() {
        this.field_uid = "0";
        this.field_name = "";
        this.field_devicetype = "";
        this.field_createtime = 0;
    }

    public c(bev bev) {
        this.field_createtime = (long) bev.pgR;
        this.field_devicetype = bev.vQr;
        this.field_name = bev.nkW;
        this.field_uid = bev.wfU;
    }
}
