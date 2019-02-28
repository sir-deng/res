package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l {
    private static int iUj = -1;

    public static void a(bxb bxb, f fVar) {
        if (fVar != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - fVar.iTe);
            g.pWK.h(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(fVar.size), Integer.valueOf(bxb.bkL()), Integer.valueOf(0), "", "", Integer.valueOf(acL()), Integer.valueOf(acM()));
        }
    }

    public static void a(a aVar, int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() - aVar.iTe);
        g.pWK.h(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(aVar.size), Integer.valueOf(i), Integer.valueOf(1), "", bi.oM(aVar.fpd), Integer.valueOf(acL()), Integer.valueOf(acM()));
    }

    public static void a(String str, LinkedList<String> linkedList, long j, int i, int i2) {
        String str2 = "";
        if ((str.equals("invokeHandler") || str.equals("publishHandler")) && linkedList.size() > 0) {
            str2 = (String) linkedList.get(0);
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        g.pWK.h(15190, Integer.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(2), str, str2, Integer.valueOf(acL()), Integer.valueOf(acM()));
    }

    public static String rD(String str) {
        Matcher matcher = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private static int acL() {
        if (iUj >= 0) {
            return iUj;
        }
        int iSPCode = ao.getISPCode(ad.getContext());
        iUj = iSPCode;
        return iSPCode;
    }

    public static int acM() {
        Context context = ad.getContext();
        if (!ao.isConnected(context)) {
            return 0;
        }
        if (ao.is2G(context)) {
            return 1;
        }
        if (ao.is3G(context)) {
            return 2;
        }
        if (ao.is4G(context)) {
            return 3;
        }
        if (ao.isWifi(context)) {
            return 4;
        }
        return 5;
    }
}
