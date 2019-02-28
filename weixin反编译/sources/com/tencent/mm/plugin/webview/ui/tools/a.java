package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, Integer> nbu;
    private static final Map<Integer, Integer> tCu;
    private static final Map<Integer, Integer> tCv;
    private static final Map<Integer, Integer> tCw;

    static {
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(-1), Integer.valueOf(5));
        hashMap.put(Integer.valueOf(-2), Integer.valueOf(6));
        hashMap.put(Integer.valueOf(-3), Integer.valueOf(7));
        hashMap.put(Integer.valueOf(-4), Integer.valueOf(8));
        hashMap.put(Integer.valueOf(-5), Integer.valueOf(9));
        hashMap.put(Integer.valueOf(-6), Integer.valueOf(10));
        hashMap.put(Integer.valueOf(-7), Integer.valueOf(11));
        hashMap.put(Integer.valueOf(-8), Integer.valueOf(12));
        hashMap.put(Integer.valueOf(-9), Integer.valueOf(13));
        hashMap.put(Integer.valueOf(-10), Integer.valueOf(14));
        hashMap.put(Integer.valueOf(-11), Integer.valueOf(15));
        hashMap.put(Integer.valueOf(-12), Integer.valueOf(16));
        hashMap.put(Integer.valueOf(-13), Integer.valueOf(17));
        hashMap.put(Integer.valueOf(-14), Integer.valueOf(18));
        hashMap.put(Integer.valueOf(-15), Integer.valueOf(19));
        tCu = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(Integer.valueOf(-1), Integer.valueOf(4));
        hashMap.put(Integer.valueOf(-2), Integer.valueOf(5));
        hashMap.put(Integer.valueOf(-3), Integer.valueOf(6));
        hashMap.put(Integer.valueOf(-4), Integer.valueOf(7));
        hashMap.put(Integer.valueOf(-5), Integer.valueOf(8));
        hashMap.put(Integer.valueOf(-6), Integer.valueOf(9));
        tCv = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), Integer.valueOf(0));
        hashMap.put(Integer.valueOf(1), Integer.valueOf(1));
        hashMap.put(Integer.valueOf(2), Integer.valueOf(2));
        tCw = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put(w.NAME, Integer.valueOf(2));
        hashMap.put("profile", Integer.valueOf(3));
        hashMap.put("addContact", Integer.valueOf(4));
        hashMap.put("shareTimeline", Integer.valueOf(7));
        hashMap.put("scanQRCode", Integer.valueOf(8));
        hashMap.put(v.NAME, Integer.valueOf(10));
        hashMap.put(o.NAME, Integer.valueOf(11));
        hashMap.put("editAddress", Integer.valueOf(12));
        hashMap.put("getLatestAddress", Integer.valueOf(13));
        hashMap.put("jumpWCMall", Integer.valueOf(14));
        hashMap.put("geoLocation", Integer.valueOf(15));
        hashMap.put("openProductView", Integer.valueOf(16));
        hashMap.put("openProductViewWithPid", Integer.valueOf(16));
        hashMap.put(e.NAME, Integer.valueOf(17));
        hashMap.put(u.NAME, Integer.valueOf(19));
        hashMap.put("connectToFreeWifi", Integer.valueOf(20));
        hashMap.put(JsApiStartRecordVoice.NAME, Integer.valueOf(21));
        hashMap.put("chooseImage", Integer.valueOf(22));
        hashMap.put("scanCover", Integer.valueOf(23));
        hashMap.put("openGameWebView", Integer.valueOf(28));
        nbu = Collections.unmodifiableMap(hashMap);
    }

    public static int AP(int i) {
        Integer num = (Integer) tCu.get(Integer.valueOf(i));
        if (num == null) {
            num = (Integer) tCu.get(Integer.valueOf(-1));
        }
        return num.intValue();
    }

    public static int AQ(int i) {
        Integer num = (Integer) tCv.get(Integer.valueOf(i));
        if (num == null) {
            num = (Integer) tCv.get(Integer.valueOf(-1));
        }
        return num.intValue();
    }

    public static int AR(int i) {
        Integer num = (Integer) tCw.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(-1);
        }
        return num.intValue();
    }

    public static int PB(String str) {
        Integer num = (Integer) nbu.get(str);
        if (num == null) {
            num = Integer.valueOf(-1);
        }
        return num.intValue();
    }

    public static int fk(long j) {
        if (j < 0) {
            return -1;
        }
        if (j <= 2000) {
            return 1;
        }
        if (j <= 6000) {
            return 2;
        }
        if (j <= 12000) {
            return 3;
        }
        if (j <= 60000) {
            return 4;
        }
        return 5;
    }
}
