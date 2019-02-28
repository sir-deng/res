package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

final class e extends b {
    private static final Map<String, e> jEE = new ConcurrentHashMap();
    private final String jEF;
    private final String jEG;

    private static final class a extends al {
        a(final String str) {
            super(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    e.tH(str);
                    return false;
                }
            }, false);
        }
    }

    static e tH(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return (e) jEE.remove(str);
    }

    e(Context context, String str) {
        this.jEF = str;
        this.jEG = context.getClass().getName();
        jEE.put(str, this);
        al aVar = new a(str);
        long toMillis = TimeUnit.SECONDS.toMillis(300);
        aVar.K(toMillis, toMillis);
    }

    protected final String aiN() {
        return this.jEG;
    }
}
