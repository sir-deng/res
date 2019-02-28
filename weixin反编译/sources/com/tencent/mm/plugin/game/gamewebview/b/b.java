package com.tencent.mm.plugin.game.gamewebview.b;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public final class b {
    public static Map<String, a> ndo;

    public static void a(a aVar) {
        if (!bi.oN(aVar.getName())) {
            ndo.put(aVar.getName(), aVar);
        }
    }
}
