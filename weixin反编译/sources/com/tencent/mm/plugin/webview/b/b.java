package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class b {
    private static long trx = 2592000;
    private static b try;
    private Map<String, Long> trA = new HashMap();
    private long trB = 0;
    private c trz;

    static /* synthetic */ long OB(String str) {
        long j = bi.getLong(str, 604800);
        return j > trx ? trx : j;
    }

    static /* synthetic */ void b(b bVar) {
        c bPP = bVar.bPP();
        String format = String.format("delete from %s where %s<%s", new Object[]{"WebViewData", "expireTime", Long.valueOf(System.currentTimeMillis() / 1000)});
        x.d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: " + format);
        x.d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: " + bPP.fD("WebViewData", format));
    }

    public static b bPO() {
        if (try == null) {
            try = new b();
        }
        return try;
    }

    public final c bPP() {
        if (this.trz == null) {
            g.Dr();
            this.trz = new c(g.Dq().gRU);
        }
        return this.trz;
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, boolean z) {
        long j;
        long j2;
        Cursor rawQuery = bPP().rawQuery(String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", c.eP(str, str2)}), new String[0]);
        if (rawQuery == null) {
            j = 0;
        } else {
            j2 = 0;
            if (rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
            }
            rawQuery.close();
            j = j2;
        }
        long length = ((long) (str2.getBytes().length + str3.getBytes().length)) - j;
        if (this.trA.containsKey(str)) {
            j2 = ((Long) this.trA.get(str)).longValue();
        } else {
            c bPP = bPP();
            String format = String.format("select %s from %s where %s=\"%s\"", new Object[]{"size", "WebViewData", "appIdKey", c.ab(str, "###@@@@TOTAL@@@###SIZE####", "_")});
            x.d("MicroMsg.WebViewDataStorage", "getAppIdSize: " + format);
            j2 = 0;
            rawQuery = bPP.rawQuery(format, new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    j2 = rawQuery.getLong(0);
                }
                rawQuery.close();
            }
            x.d("MicroMsg.WebViewDataStorage", "getAppIdSize: " + j2);
        }
        final long j3 = j2 + length;
        final long j4 = str.equals("wx62d9035fd4fd2059") ? j3 - 52428800 : j3 - 10485760;
        x.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", Long.valueOf(j), Long.valueOf(r10), Long.valueOf(length), Long.valueOf(j3), Long.valueOf(j4));
        if (j4 > 0 && !z) {
            return false;
        }
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        as.Dt().F(new Runnable() {
            public final void run() {
                long j;
                if (j4 > 0) {
                    c bPP = b.this.bPP();
                    String str = str6;
                    long j2 = j4;
                    str = String.format("select * from %s where appId='%s' order by weight,timeStamp", new Object[]{"WebViewData", str});
                    x.d("MicroMsg.WebViewDataStorage", "deleteSize querySql: " + str);
                    Cursor rawQuery = bPP.rawQuery(str, new String[0]);
                    if (rawQuery == null) {
                        j = 0;
                    } else {
                        List<String> linkedList = new LinkedList();
                        long j3 = j2;
                        while (rawQuery.moveToFirst() && j3 > 0) {
                            str = rawQuery.getString(1);
                            long j4 = rawQuery.getLong(6);
                            linkedList.add(str);
                            j3 -= j4;
                        }
                        rawQuery.close();
                        if (linkedList.size() > 0) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("(");
                            for (String str2 : linkedList) {
                                stringBuilder.append("\"" + str2 + "\",");
                            }
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            stringBuilder.append(")");
                            str2 = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
                            x.d("MicroMsg.WebViewDataStorage", "deleteSize deleteSql: " + str2);
                            x.d("MicroMsg.WebViewDataStorage", "deleteSize: " + bPP.fD("WebViewData", str2));
                        }
                        j = j2 - j3;
                    }
                    b.this.trA.put(str6, Long.valueOf(j3 - j));
                } else {
                    b.this.trA.put(str6, Long.valueOf(j3));
                }
                c bPP2 = b.this.bPP();
                String str3 = str6;
                String str4 = str7;
                String str5 = str8;
                String aD = bi.aD(str9, "1");
                long OB = b.OB(str10);
                c aVar = new a();
                aVar.field_appId = str3;
                aVar.field_appIdKey = c.eP(str3, str4);
                aVar.field_value = str5;
                aVar.field_weight = aD;
                aVar.field_expireTime = OB + (System.currentTimeMillis() / 1000);
                aVar.field_size = (long) (str4.getBytes().length + str5.getBytes().length);
                aVar.field_timeStamp = System.currentTimeMillis() / 1000;
                x.d("MicroMsg.WebViewDataStorage", "setData: " + bPP2.a(aVar));
                c bPP3 = b.this.bPP();
                str5 = str6;
                j = b.this.trA.get(str6) == null ? 0 : ((Long) b.this.trA.get(str6)).longValue();
                c aVar2 = new a();
                aVar2.field_appId = str5;
                aVar2.field_appIdKey = c.ab(str5, "###@@@@TOTAL@@@###SIZE####", "_");
                aVar2.field_expireTime = Long.MAX_VALUE;
                aVar2.field_size = j;
                boolean a = bPP3.a(aVar2);
                x.d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", Boolean.valueOf(a), Long.valueOf(j));
                b.b(b.this);
            }
        });
        return true;
    }

    public final a eO(String str, String str2) {
        c bPP = bPP();
        String format = String.format("select * from %s where %s=\"%s\"", new Object[]{"WebViewData", "appIdKey", c.eP(str, str2)});
        x.d("MicroMsg.WebViewDataStorage", "getData: " + format);
        Cursor rawQuery = bPP.rawQuery(format, new String[0]);
        a aVar = new a();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                aVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return aVar;
    }

    public final void b(String str, JSONArray jSONArray) {
        c bPP = bPP();
        if (jSONArray != null && jSONArray.length() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    stringBuilder.append("\"" + c.eP(str, jSONArray.getString(i)) + "\",");
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewDataStorage", "clearData: " + e.getMessage());
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(")");
            String format = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
            x.d("MicroMsg.WebViewDataStorage", "deleteData: " + format);
            x.d("MicroMsg.WebViewDataStorage", "clearData: " + bPP.fD("WebViewData", format));
        }
    }

    public final void OA(String str) {
        c bPP = bPP();
        String format = String.format("delete from %s where %s=\"%s\"", new Object[]{"WebViewData", "appId", str});
        x.d("MicroMsg.WebViewDataStorage", "cleanAllData: " + format);
        x.d("MicroMsg.WebViewDataStorage", "cleanAllData: " + bPP.fD("WebViewData", format));
    }
}
