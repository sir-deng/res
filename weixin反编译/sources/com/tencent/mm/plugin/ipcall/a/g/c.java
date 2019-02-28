package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.f.b.bw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class c extends bw {
    public static a gKN;
    public ArrayList<String> nMo;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wechatUsername";
        aVar.xrT.put("wechatUsername", "TEXT");
        stringBuilder.append(" wechatUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "systemAddressBookUsername";
        aVar.xrT.put("systemAddressBookUsername", "TEXT");
        stringBuilder.append(" systemAddressBookUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactId";
        aVar.xrT.put("contactId", "TEXT");
        stringBuilder.append(" contactId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sortKey";
        aVar.xrT.put("sortKey", "TEXT");
        stringBuilder.append(" sortKey TEXT");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public static boolean dc(String str, String str2) {
        if (str == null && str2 != null) {
            return false;
        }
        if (str == null || str.equals(str2)) {
            return true;
        }
        return false;
    }
}
