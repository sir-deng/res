package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class f extends i<e> {
    public static final String[] gLy = new String[]{i.a(e.gKN, "FreeWifiLog"), "CREATE INDEX IF NOT EXISTS idx_FreeWifiLog_key  on FreeWifiLog  (  id )"};
    public static LinkedHashMap<String, Class> mLU = new LinkedHashMap<String, Class>() {
        {
            put(SlookAirButtonFrequentContactAdapter.ID, String.class);
            put("protocolNumber", Integer.TYPE);
            put("logContent", String.class);
            put("createTime", Long.TYPE);
        }
    };

    public f(e eVar) {
        super(eVar, e.gKN, "FreeWifiLog", null);
    }

    public final LinkedList<wn> aMY() {
        Cursor rawQuery = rawQuery("select id, protocolNumber, logContent, createTime from FreeWifiLog", new String[0]);
        LinkedList<wn> linkedList = new LinkedList();
        while (rawQuery != null && rawQuery.moveToNext()) {
            wn wnVar = new wn();
            wnVar.id = rawQuery.getString(0);
            wnVar.mKO = rawQuery.getInt(1);
            wnVar.wnG = rawQuery.getString(2);
            wnVar.wnH = rawQuery.getLong(3);
            linkedList.add(wnVar);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, String str2, long j) {
        x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "save. id=%s, protocolNumber=%d, logContent=%s, createTime=%d", str, Integer.valueOf(i), str2, Long.valueOf(j));
        if (m.Bf(str)) {
            return false;
        }
        Cursor rawQuery = rawQuery("select * from FreeWifiLog where id = '" + str + "'", new String[0]);
        boolean b;
        try {
            c eVar = new e();
            eVar.field_id = str;
            eVar.field_protocolNumber = i;
            eVar.field_logContent = str2;
            eVar.field_createTime = j;
            if (rawQuery.getCount() == 0) {
                b = b(eVar);
                x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "insert ret" + b);
                return b;
            }
            b = c(eVar, new String[0]);
            x.i("MicroMsg.FreeWifi.FreeWifiLogStorage", "update ret" + b);
            rawQuery.close();
            return b;
        } catch (Exception e) {
            b = e;
            b = m.f(b);
            x.e("MicroMsg.FreeWifi.FreeWifiLogStorage", b);
            return false;
        } finally {
            rawQuery.close();
        }
    }
}
