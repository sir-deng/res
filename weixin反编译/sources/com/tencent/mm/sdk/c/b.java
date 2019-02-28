package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class b {
    protected final String aBs = "weixin/android";

    public static class b {
        public int gLT;
        public String host;
        public int puf = 0;
        public Map<String, String> pug = null;
        public Map<String, String> puh = null;
        public String uri;
        public String xmM;
        public a xmN = null;

        public final String getUrl() {
            StringBuilder stringBuilder = new StringBuilder();
            if (!(this.uri.startsWith("http://") || this.uri.startsWith("https://"))) {
                stringBuilder.append(this.xmM + this.host);
            }
            stringBuilder.append(this.uri);
            if (this.pug == null) {
                return stringBuilder.toString();
            }
            stringBuilder.append('?');
            Object obj = 1;
            Iterator it = this.pug.keySet().iterator();
            while (true) {
                Object obj2 = obj;
                if (!it.hasNext()) {
                    return stringBuilder.toString();
                }
                String str = (String) it.next();
                stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(bi.oM((String) this.pug.get(str)), ProtocolPackage.ServerEncoding));
                obj = null;
            }
        }

        public final String toString() {
            try {
                return getUrl();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.HttpWrapperBase", e, "", new Object[0]);
                return "";
            }
        }
    }

    public static class a {
        public String filePath;
    }

    public static class c {
        public String content;
        public Map<String, String> puh;
        public int status;
        public a xmN;

        public c(int i, Map<String, String> map, String str) {
            this.status = 0;
            this.status = 0;
            this.puh = null;
            this.content = str;
        }

        public String toString() {
            return "Response status:" + this.status + ", cookie:" + (this.puh != null ? this.puh : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
        }

        public void onComplete() {
        }
    }

    public abstract void a(b bVar, c cVar);

    public final void a(final b bVar, final c cVar, final ag agVar) {
        e.post(new Runnable() {
            public final void run() {
                b.this.a(bVar, cVar);
                if (agVar != null) {
                    agVar.post(new Runnable() {
                        public final void run() {
                            cVar.onComplete();
                        }
                    });
                } else {
                    cVar.onComplete();
                }
            }
        }, getClass().getName());
    }

    public static Map<String, String> In(String str) {
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
