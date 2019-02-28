package com.tencent.mm.aq;

import android.content.Context;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public final class b {
    private static Map<String, a> hGe = null;
    private static String hGf = null;

    public static class a {
        public String hGg;
        public String hGh;
        public String hGi;
    }

    public static boolean PV() {
        return !w.eM(ad.getContext()).equals("zh_CN");
    }

    public static boolean PW() {
        return bi.PZ();
    }

    public static boolean PX() {
        if (q.FX() == 0 && bi.PZ()) {
            return false;
        }
        return true;
    }

    public static boolean PY() {
        if (!w.cfV().equals("zh_CN")) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() == TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return false;
        }
        return true;
    }

    public static boolean PZ() {
        return bi.PZ();
    }

    public static a h(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(hGf)) {
                hGe = null;
            }
        } catch (Exception e) {
        }
        if (hGe == null) {
            hGe = new HashMap();
            hGf = str3;
            InputStream inputStream = null;
            String str4 = "";
            try {
                inputStream = context.getAssets().open("country_code.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str3 = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bi.i(e2));
                    }
                }
            } catch (Throwable e3) {
                x.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bi.i(e3));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str3 = str4;
                    } catch (Throwable e32) {
                        x.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bi.i(e32));
                        str3 = str4;
                    }
                } else {
                    str3 = str4;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e22) {
                        x.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bi.i(e22));
                    }
                }
            }
            String[] split = str3.trim().split("\n");
            String[] split2 = bi.oM(str2).trim().split(",");
            for (String str42 : split) {
                String[] split3 = str42.trim().split(" ");
                if (split3.length < 2) {
                    x.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", split[r0]);
                } else {
                    a aVar = new a();
                    aVar.hGg = split3[0];
                    aVar.hGh = split3[1];
                    for (String trim : split2) {
                        String[] split4 = trim.trim().split(":");
                        if (split4.length < 2) {
                            x.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", trim);
                        } else {
                            if (split3[1].equals(split4[0])) {
                                aVar.hGi = split4[1];
                                break;
                            }
                        }
                    }
                    hGe.put(aVar.hGg, aVar);
                }
            }
        }
        return (a) hGe.get(str.toUpperCase());
    }

    public static boolean lJ(String str) {
        if (str == null || str.length() <= 1 || !str.startsWith("+") || str.startsWith("+86")) {
            return false;
        }
        return true;
    }

    public static String lK(String str) {
        if (str.startsWith("+886") || str.startsWith("+86")) {
            return "zh-TW";
        }
        if (str.startsWith("+852") || str.startsWith("+853")) {
            return "zh-HK";
        }
        if (str.startsWith("+81")) {
            return "ja";
        }
        if (str.startsWith("+82")) {
            return "ko";
        }
        if (str.startsWith("+66")) {
            return "th";
        }
        if (str.startsWith("+84")) {
            return "vi";
        }
        if (str.startsWith("+62")) {
            return SlookAirButtonFrequentContactAdapter.ID;
        }
        if (str.startsWith("+55")) {
            return "pt";
        }
        if (str.startsWith("+34")) {
            return "es-419";
        }
        return "en";
    }
}
