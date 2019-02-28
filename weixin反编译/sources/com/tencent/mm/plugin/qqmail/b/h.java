package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class h {
    protected static String aBs = "weixin/android";
    protected static int gLT = 0;
    protected static String host = "";
    protected static String pue = "";

    public static class b {
        int puf;
        Map<String, String> pug;
        Map<String, String> puh;
        d pui;

        public b(int i, Map<String, String> map, Map<String, String> map2, d dVar) {
            this.puf = i;
            this.pug = map;
            this.puh = map2;
            this.pui = dVar;
        }

        public final String toString() {
            return "Request method:" + this.puf + ", params:" + (this.pug != null ? this.pug : "") + ", cookie:" + (this.puh != null ? this.puh : "");
        }
    }

    public static class d {
        String filePath;
        String fxA;

        public d(String str, String str2) {
            this.fxA = str;
            this.filePath = str2;
        }
    }

    public interface a {
        void bkO();
    }

    public static class c {
        String content;
        Map<String, String> puh;
        int status = 0;

        public c(int i, Map<String, String> map, String str) {
            this.status = i;
            this.puh = map;
            this.content = str;
        }

        public final String toString() {
            return "Response status:" + this.status + ", cookie:" + (this.puh != null ? this.puh : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
        }
    }

    public abstract c a(String str, String str2, b bVar, a aVar);

    public abstract void cancel();

    public static void setHost(String str) {
        x.host = str;
    }

    public static void setUserAgent(String str) {
        x.aBs = str;
    }

    public static void Im(String str) {
        pue = str;
    }

    protected static String b(String str, String str2, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(str2.startsWith("http://") || str2.startsWith("https://"))) {
            stringBuilder.append(str + host);
        }
        stringBuilder.append(str2);
        if (map == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append('?');
        Object obj = 1;
        Iterator it = map.keySet().iterator();
        while (true) {
            Object obj2 = obj;
            if (!it.hasNext()) {
                return stringBuilder.toString();
            }
            String str3 = (String) it.next();
            stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(bi.oM((String) map.get(str3)), ProtocolPackage.ServerEncoding));
            obj = null;
        }
    }

    protected static String M(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        Iterator it = map.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return stringBuilder.toString();
            }
            String str = (String) it.next();
            stringBuilder.append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) map.get(str), ProtocolPackage.ServerEncoding));
            i = i2 + 1;
            if (map.size() > i) {
                stringBuilder.append("; ");
            }
        }
    }

    protected static Map<String, String> In(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }
}
