package com.tencent.mm.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class i {
    public String fex;
    private Map<String, a> fey = new HashMap();
    public int versionCode;

    public static class a {
        public String feA;
        public String feB;
        String fez;
        public int size;
        public String url;

        public a(String str, String str2, String str3, String str4, int i) {
            this.fez = str;
            this.feA = str2;
            this.feB = str3;
            this.size = i;
            this.url = str4;
        }
    }

    public i(String str, int i) {
        if (str == null) {
            this.fex = "http://dldir1.qq.com/weixin/android/";
        } else {
            this.fex = str;
        }
        this.versionCode = i;
    }

    public final void a(a aVar) {
        this.fey.put(aVar.fez, aVar);
    }

    public final a ci(String str) {
        return (a) this.fey.get(str);
    }

    public final String ts() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[]{this.fex, Integer.valueOf(this.fey.size()), Integer.valueOf(this.versionCode)}));
        for (Entry value : this.fey.entrySet()) {
            a aVar = (a) value.getValue();
            stringBuilder.append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[]{aVar.fez, aVar.feA, aVar.feB, aVar.url, Integer.valueOf(aVar.size)}));
        }
        stringBuilder.append("</patchupdate>");
        return stringBuilder.toString();
    }

    public static i cj(String str) {
        Map y = f.y(str, "patchupdate");
        if (y == null) {
            return null;
        }
        i iVar = new i((String) y.get(".patchupdate.$base"), j.ck((String) y.get(".patchupdate.$versioncode")));
        int ck = j.ck((String) y.get(".patchupdate.$count"));
        int i = 0;
        while (i < ck) {
            Object obj;
            String str2 = ".patchupdate.item" + (i > 0 ? Integer.valueOf(i) : "");
            a aVar = new a((String) y.get(new StringBuilder(String.valueOf(str2)).append(".$old").toString()), (String) y.get(new StringBuilder(String.valueOf(str2)).append(".$new").toString()), (String) y.get(new StringBuilder(String.valueOf(str2)).append(".$patch").toString()), (String) y.get(new StringBuilder(String.valueOf(str2)).append(".$url").toString()), j.ck((String) y.get(new StringBuilder(String.valueOf(str2)).append(".$size").toString())));
            if (aVar.fez == null || aVar.feA == null || aVar.feB == null || aVar.url == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                iVar.fey.put(aVar.fez, aVar);
            }
            i++;
        }
        return iVar;
    }
}
