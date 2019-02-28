package com.tencent.mm.plugin.n;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c implements b, com.tencent.mm.kernel.b.c {
    private static c nHn;

    private c() {
    }

    public static synchronized c aTt() {
        c cVar;
        synchronized (c.class) {
            if (nHn == null) {
                nHn = new c();
            }
            cVar = nHn;
        }
        return cVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"image/", "image2/"});
        return linkedList;
    }

    public static String Fp() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("image/").toString();
    }

    public static String Fq() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("image2/").toString();
    }

    public static String FF() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("sfs").toString();
    }
}
