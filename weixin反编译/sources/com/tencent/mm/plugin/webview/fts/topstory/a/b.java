package com.tencent.mm.plugin.webview.fts.topstory.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.topstory.a.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b {
    public static long sks;
    public static int ttT;
    public static int ttU;
    public static HashMap<String, d> ttV = new HashMap();
    public static List<d> ttW = new ArrayList();
    public static com.tencent.mm.plugin.aj.a.d ttX;
    public static a ttY;
    public static d ttZ;
    public static String tua;
    public static String tub;
    public static long tuc = 0;
    public static boolean tud = false;
    public static int tue = 0;
    public static boolean tuf = false;
    public static boolean tug = false;

    public static void init(Context context) {
        ttT = context.getResources().getDimensionPixelSize(R.f.bxp);
        ttU = context.getResources().getDimensionPixelSize(R.f.bxq);
        ttW = new ArrayList();
        tuc = 0;
        tud = false;
        tue = 0;
    }

    public static void reset() {
        ttX = null;
        ttZ = null;
        sks = -1;
        tua = null;
        tub = null;
        tuc = 0;
        tud = false;
        tue = 0;
        ttW.clear();
        ttV.clear();
    }

    public static void d(com.tencent.mm.plugin.aj.a.d dVar) {
        ttX = dVar;
    }

    public static void a(ArrayList<String> arrayList, d dVar, String str, String str2) {
        String str3;
        x.i("MicroMsg.WebSearch.TopStoryVideoListConfig", "setFirstVideoInfo, urls: %s, videoInfo: %s, expand: %s, searchId: %s", arrayList, dVar, str, str2);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str3 = (String) it.next();
                if (!bi.oN(str3)) {
                    break;
                }
            }
        }
        str3 = null;
        dVar.videoUrl = str3;
        ttZ = dVar;
        dVar.timestamp = bi.Wz();
        sks = ttZ.skI;
        tua = str;
        tub = str2;
        ttV.put(ttZ.skE, ttZ);
    }

    public static void h(List<d> list, boolean z) {
        if (list != null && list.size() > 0) {
            if (z) {
                ttW.clear();
                ttV.clear();
            }
            ttW.addAll(list);
            for (d dVar : list) {
                ttV.put(dVar.skE, dVar);
            }
        }
    }

    public static int bQb() {
        if (ttW != null) {
            return ttW.size();
        }
        return 0;
    }

    public static boolean bQc() {
        return ao.isWifi(ad.getContext());
    }

    public static void a(boolean z, long j, int i) {
        x.i("MicroMsg.WebSearch.TopStoryVideoListConfig", "setPreFetchAndReportInfo, isNeedPreFetch: %s, reportThresholdInMin: %s, maxReportVideoCount", Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i));
        tud = z;
        tuc = 60000 * j;
        tue = i;
    }

    public static String OE(String str) {
        int i;
        int size = ttW.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(((d) ttW.get(i2)).videoUrl)) {
                i = i2;
                break;
            }
        }
        i = -1;
        if (i < 0 || i + 1 >= size) {
            return null;
        }
        return ((d) ttW.get(i + 1)).videoUrl;
    }
}
