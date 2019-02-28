package com.tencent.mm.bb;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public final class m {
    public static String Ro() {
        File file = new File(e.hbw.replace("/data/user/0", "/data/data"), "wxa_fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static Properties o(File file) {
        Throwable e;
        Properties properties = new Properties();
        if (file != null && file.isFile()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    com.tencent.mm.a.e.c(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                        com.tencent.mm.a.e.c(fileInputStream);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        com.tencent.mm.a.e.c(fileInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                com.tencent.mm.a.e.c(fileInputStream);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                com.tencent.mm.a.e.c(fileInputStream);
                throw e;
            }
        }
        return properties;
    }

    public static int Rp() {
        return Integer.valueOf(o(new File(Ro(), "config.conf")).getProperty("version", "0")).intValue();
    }

    public static String r(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(Ro());
        stringBuffer.append("/app.html?");
        for (Entry entry : map.entrySet()) {
            stringBuffer.append("&");
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) entry.getValue());
        }
        if (!map.containsKey("sessionId")) {
            stringBuffer.append("&");
            stringBuffer.append("sessionId");
            stringBuffer.append("=");
            stringBuffer.append(g.zZ(bi.Wo((String) map.get("scene"))));
        }
        return stringBuffer.toString();
    }

    public static Map<String, String> b(int i, boolean z, int i2) {
        return a(i, z, i2, "");
    }

    public static Map<String, String> a(int i, boolean z, int i2, String str) {
        boolean z2;
        Map<String, String> hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put(Columns.TYPE, String.valueOf(i2));
        hashMap.put("lang", w.eM(ad.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(Rp()));
        hashMap.put("isHomePage", z ? "1" : "0");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        c fp = com.tencent.mm.y.c.c.IL().fp("100192");
        if (fp.isValid() && "1".equals(fp.civ().get("openSearchSuggestion"))) {
            z2 = true;
        } else {
            z2 = false;
        }
        x.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2));
        if (z2) {
            hashMap.put("isSug", "1");
        }
        return hashMap;
    }

    public static final boolean Rq() {
        c fp = com.tencent.mm.y.c.c.IL().fp("100223");
        if (!fp.isValid()) {
            return false;
        }
        if (bi.getInt((String) fp.civ().get("switchWeAppTemplate"), 0) == 1) {
            return true;
        }
        return false;
    }
}
