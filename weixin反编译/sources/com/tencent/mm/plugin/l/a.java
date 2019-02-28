package com.tencent.mm.plugin.l;

import com.tencent.mm.ay.r;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.y.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends p implements b {
    private static a lwI;

    private a() {
        super(r.class);
    }

    public static synchronized a aAw() {
        a aVar;
        synchronized (a.class) {
            if (lwI == null) {
                lwI = new a();
            }
            aVar = lwI;
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"package/"});
        return linkedList;
    }

    public static String Fz() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("package/").toString();
    }
}
