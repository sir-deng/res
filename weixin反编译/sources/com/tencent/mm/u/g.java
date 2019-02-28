package com.tencent.mm.u;

import android.util.Log;
import com.tencent.mm.by.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;
import org.json.JSONObject;

public final class g {
    private static volatile int gQL = 0;
    private static volatile boolean gQM = false;

    public static void initialize() {
        a.post(new Runnable() {
            public final void run() {
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.gOV;
                c fp = com.tencent.mm.ipcinvoker.wx_extension.a.a.fp("100295");
                if (fp == null) {
                    x.i("MicroMsg.JSONFactory", "JSON lib type ABTest item is null.");
                } else if (fp.isValid()) {
                    try {
                        g.gz(bi.getInt((String) fp.civ().get("jsonLibType"), 1));
                        x.i("MicroMsg.JSONFactory", "current jsonLibType is : %d", Integer.valueOf(g.gQL));
                    } catch (Throwable e) {
                        x.w("MicroMsg.JSONFactory", "parse jsonLibType error : %s", Log.getStackTraceString(e));
                    }
                } else {
                    g.gz(1);
                }
            }
        });
    }

    public static JSONObject fA(String str) {
        if (!gQM) {
            initialize();
        }
        if (gQL == 1) {
            return new h(str);
        }
        return new JSONObject(str);
    }

    public static c Ck() {
        if (gQL == 1) {
            return new k();
        }
        return new d();
    }

    public static c n(Map map) {
        if (gQL == 1) {
            return new k(map);
        }
        return new d(map);
    }

    public static c fB(String str) {
        if (gQL == 1) {
            return new k(str);
        }
        return new d(str);
    }

    public static a Cl() {
        if (gQL == 1) {
            return new j();
        }
        return new b();
    }

    public static a fC(String str) {
        if (gQL == 1) {
            return new j(str);
        }
        return new b(str);
    }

    public static void gz(int i) {
        gQL = i;
        gQM = true;
    }

    public static int Cm() {
        return gQL;
    }
}
