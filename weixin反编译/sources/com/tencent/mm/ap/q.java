package com.tencent.mm.ap;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.b;

public final class q {
    private static String[] hEA = null;

    public static boolean PK() {
        boolean z;
        if (hEA == null) {
            PL();
        }
        if (VERSION.SDK_INT < 14 || hEA == null || hEA.length <= 0 || com.tencent.mm.compatible.e.q.gHP.gHk != 1) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.WebpUtil", "isSupportWebp: %b", Boolean.valueOf(z));
        return z;
    }

    private static void PL() {
        try {
            String value = ((a) g.h(a.class)).Af().getValue("BizEnableWebpUrl");
            x.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", value);
            if (!bi.oN(value)) {
                hEA = value.split(";");
                x.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", Integer.valueOf(hEA.length));
            }
        } catch (b e) {
            x.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
        } catch (Exception e2) {
            x.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", e2.getMessage());
        }
    }

    private static boolean ly(String str) {
        if (hEA == null || hEA.length <= 0 || bi.oN(str)) {
            return false;
        }
        for (String startsWith : hEA) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static String lz(String str) {
        if (hEA == null || hEA.length == 0) {
            x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
            PL();
        }
        if (ly(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("wxtype");
                if (bi.oN(queryParameter)) {
                    return str;
                }
                queryParameter = queryParameter.toLowerCase();
                x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, wxtype:%s", queryParameter);
                if (queryParameter.equals("gif") || queryParameter.contains("gif")) {
                    return str;
                }
                String queryParameter2 = parse.getQueryParameter("tp");
                if ((!bi.oN(queryParameter2) && queryParameter2.equals("webp")) || bi.oN(queryParameter)) {
                    return str;
                }
                x.d("MicroMsg.WebpUtil", "webpURL: %s", parse.buildUpon().appendQueryParameter("tp", "webp").build().toString());
                return parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
            } catch (Exception e) {
                return str;
            }
        }
        x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
        return str;
    }

    public static boolean lA(String str) {
        try {
            if (bi.oN(str) || !ly(str)) {
                return false;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("tp");
            if (bi.oN(queryParameter) || !queryParameter.equals("webp")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int PM() {
        Context context = ad.getContext();
        if (ao.isWifi(context)) {
            return 1;
        }
        if (ao.is4G(context)) {
            return 4;
        }
        if (ao.is3G(context)) {
            return 3;
        }
        if (ao.is2G(context)) {
            return 2;
        }
        return 0;
    }

    public static String ib(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(PM()), Integer.valueOf(2)});
    }

    public static String ic(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(PM()), Integer.valueOf(1)});
    }

    public static String lB(String str) {
        try {
            if (!ly(str)) {
                return null;
            }
            String toLowerCase = Uri.parse(str).getQueryParameter("wxtype").toLowerCase();
            if (bi.oN(toLowerCase)) {
                return null;
            }
            return toLowerCase.toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }
}
