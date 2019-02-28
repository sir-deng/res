package com.tencent.mm.plugin.freewifi.b;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.freewifi.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private boolean mJi;
    private Map<String, b> mJj;

    private static class a {
        private static a mJl = new a();
    }

    public static class b {
        String fqu;
        int mIj;
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.mJi = false;
        this.mJj = new LinkedHashMap<String, b>() {
            protected final boolean removeEldestEntry(Entry entry) {
                return size() > WXMediaMessage.TITLE_LENGTH_LIMIT;
            }
        };
    }

    private static String cG(String str, String str2) {
        return str + "-" + str2;
    }

    public final synchronized void c(String str, String str2, String str3, int i) {
        if (!(m.Bf(str) || m.Bf(str2) || m.Bf(str3) || (i != 4 && i != 31))) {
            b bVar = new b();
            bVar.fqu = str3;
            bVar.mIj = i;
            this.mJj.put(cG(str, str2), bVar);
        }
    }

    public final synchronized b cH(String str, String str2) {
        b bVar;
        if (m.Bf(str) || m.Bf(str2)) {
            bVar = null;
        } else {
            bVar = (b) this.mJj.get(cG(str, str2));
        }
        return bVar;
    }

    public final synchronized int size() {
        return this.mJj.size();
    }
}
