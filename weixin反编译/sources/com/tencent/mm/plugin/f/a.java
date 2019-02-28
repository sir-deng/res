package com.tencent.mm.plugin.f;

import com.tencent.mm.ac.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.k;
import com.tencent.mm.y.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends p implements b {
    private static a kob;

    private a() {
        super(n.class);
    }

    public static synchronized a aoK() {
        a aVar;
        synchronized (a.class) {
            if (kob == null) {
                kob = new a();
            }
            aVar = kob;
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"avatar/"});
        return linkedList;
    }

    public static String aoL() {
        return g.Dq().gRT + "avatar/";
    }

    public final void fP(String str) {
        super.fP(str);
        String str2 = "avatar/";
        if (f.zl()) {
            g.Dr();
            if (g.Dq().gRS.equals(e.bnF)) {
                g.Dr();
                com.tencent.mm.sdk.f.e.post(new k(g.Dq().cachePath, str, str2), "Account_moveDataFiles_" + str2);
            }
        }
    }
}
