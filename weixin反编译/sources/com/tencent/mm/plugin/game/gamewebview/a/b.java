package com.tencent.mm.plugin.game.gamewebview.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<String, Integer> nbu;

    static {
        Map hashMap = new HashMap();
        nbu = hashMap;
        hashMap.put("addDownloadTaskStraight", Integer.valueOf(1));
        nbu.put(f.NAME, Integer.valueOf(2));
        nbu.put("pauseDownloadTask", Integer.valueOf(3));
        nbu.put("resumeDownloadTask", Integer.valueOf(4));
        nbu.put(ab.NAME, Integer.valueOf(5));
        nbu.put(af.NAME, Integer.valueOf(6));
        nbu.put(GameJsApiSendAppMessage.NAME, Integer.valueOf(7));
    }

    public static int Ce(String str) {
        if (nbu.containsKey(str)) {
            return ((Integer) nbu.get(str)).intValue();
        }
        return 0;
    }
}
