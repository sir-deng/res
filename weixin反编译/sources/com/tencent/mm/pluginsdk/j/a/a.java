package com.tencent.mm.pluginsdk.j.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a {
    public static final String[] voY = new String[]{"LDPI", "HDPI", "MDPI"};
    public String desc;
    public String hjN;
    public String hjO;
    public String id;
    public int pIO;
    public String platform;
    public String title;
    public String url;
    public String voR;
    public boolean voS;
    public boolean voT;
    public int voU;
    public Rect voV;
    public Rect voW;
    public Map<String, String> voX;

    public enum a {
        ASSET,
        DOWNLOAD,
        ERROR
    }

    private a(String str, String str2, String str3, boolean z, boolean z2) {
        this.id = str;
        this.platform = str2;
        this.voR = str3;
        this.voS = z;
        this.voT = z2;
    }

    private boolean cat() {
        long Wy = bi.Wy();
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            if (this.hjO != null) {
                j = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hjO).getTime();
            }
            if (this.hjN != null) {
                j2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hjN).getTime();
            }
            x.d("MicroMsg.PushMessage", "CHECKTIME : [" + j2 + "," + j + "]");
            if (j <= Wy || j2 > Wy) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public final String toString() {
        return "ad.id=" + this.id + ", platform=" + this.platform + ", device=" + this.voR + (this.voS ? ", closable" : "") + (this.voT ? ", trans-closable" : "");
    }

    public static String SG(String str) {
        a SH = SH(str);
        if (SH == a.ASSET) {
            return str;
        }
        if (SH != a.DOWNLOAD) {
            return null;
        }
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int lastIndexOf = str.lastIndexOf("/");
            str2 = (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) ? null : str.substring(lastIndexOf + 1);
        }
        if (str2 == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.Fp()).append(str2).toString();
    }

    public static a SH(String str) {
        if (str.indexOf("tips/") == 0) {
            return a.ASSET;
        }
        if (str.indexOf("weixin://") == 0) {
            return a.DOWNLOAD;
        }
        return a.ERROR;
    }

    public static ArrayList<a> bb(Context context, String str) {
        if (str == null || str.length() < 0) {
            return null;
        }
        HashSet hashSet;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str2 = displayMetrics.heightPixels + "x" + displayMetrics.widthPixels;
        if (str2 == null) {
            hashSet = null;
        } else {
            HashSet hashSet2 = new HashSet();
            hashSet2.add(str2);
            str2 = b.eH(context);
            x.d("MicroMsg.PushMessage", "getDisplaySizeType :" + str2);
            if (str2 != null) {
                String[] split = str2.split("_");
                str2 = (split == null || split.length < 2) ? null : split[0];
                hashSet2.add(str2 + "_L");
                hashSet2.add(str2 + "_P");
            }
            hashSet = hashSet2;
        }
        if (hashSet == null || hashSet.size() <= 0) {
            return null;
        }
        Map y = bj.y(str, "tips");
        if (y == null) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            String str3 = ".tips.tip" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (y.get(str3) == null) {
                break;
            }
            String str4 = (String) y.get(str3 + ".$id");
            x.d("MicroMsg.PushMessage", "parseMessages id:" + str4);
            String str5 = (String) y.get(str3 + ".$platform");
            if (str5.equals("android")) {
                a aVar = new a(str4, str5, (String) y.get(str3 + ".$device"), bi.b(Boolean.valueOf((String) y.get(str3 + ".$enableclose"))), bi.b(Boolean.valueOf((String) y.get(str3 + ".$transparentclose"))));
                int i3 = bi.getInt((String) y.get(str3 + ".title.$x"), 0);
                int i4 = bi.getInt((String) y.get(str3 + ".title.$y"), 0);
                int i5 = bi.getInt((String) y.get(str3 + ".title.$width"), 0);
                int i6 = bi.getInt((String) y.get(str3 + ".title.$font"), 0);
                int Wg = bi.Wg((String) y.get(str3 + ".title.$color"));
                aVar.title = (String) y.get(str3 + ".title");
                aVar.voU = Wg;
                aVar.voV = new Rect(i3, i4, i5 + i3, i6 + i4);
                i3 = bi.getInt((String) y.get(str3 + ".description.$x"), 0);
                i4 = bi.getInt((String) y.get(str3 + ".description.$y"), 0);
                i5 = bi.getInt((String) y.get(str3 + ".description.$width"), 0);
                i6 = bi.getInt((String) y.get(str3 + ".description.$font"), 0);
                Wg = bi.Wg((String) y.get(str3 + ".description.$color"));
                aVar.desc = (String) y.get(str3 + ".description");
                aVar.pIO = Wg;
                aVar.voW = new Rect(i3, i4, i5 + i3, i6 + i4);
                aVar.url = (String) y.get(str3 + ".url");
                aVar.hjN = (String) y.get(str3 + ".time.start");
                aVar.hjO = (String) y.get(str3 + ".time.end");
                x.d("MicroMsg.PushMessage", "parseMessages id:" + aVar.id + " start:" + aVar.hjN + " end:" + aVar.hjO);
                Map hashMap = new HashMap();
                int i7 = 0;
                while (true) {
                    i4 = i7;
                    str5 = str3 + ".images.image" + (i4 > 0 ? Integer.valueOf(i4) : "");
                    str4 = (String) y.get(str5);
                    x.d("MicroMsg.PushMessage", " img res:" + str4);
                    if (str4 == null) {
                        break;
                    }
                    str5 = (String) y.get(str5 + ".$type");
                    if (hashSet.contains(str5)) {
                        hashMap.put(str5, str4);
                    }
                    i7 = i4 + 1;
                }
                if (hashMap.size() > 0) {
                    aVar.voX = hashMap;
                }
                x.d("MicroMsg.PushMessage", "msgid :" + aVar.id);
                arrayList.add(aVar);
            }
            i = i2 + 1;
        }
        x.d("MicroMsg.PushMessage", "msgs size: " + arrayList.size());
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public static void cau() {
        as.Hm();
        c.Db().set(8193, "");
        as.Hm();
        c.Db().set(8449, Long.valueOf(0));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.pluginsdk.j.a.a en(android.content.Context r10) {
        /*
        r2 = 1;
        r3 = 0;
        r1 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r4 = 8449; // 0x2101 float:1.184E-41 double:4.1744E-320;
        r0 = r0.get(r4, r1);
        r0 = com.tencent.mm.sdk.platformtools.bi.p(r0, r3);
        r4 = (long) r0;
        r6 = com.tencent.mm.sdk.platformtools.bi.Wx();
        r6 = r6 - r4;
        r8 = 0;
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x002c;
    L_0x0020:
        r4 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x002c;
    L_0x0027:
        cau();
    L_0x002a:
        r0 = r1;
    L_0x002b:
        return r0;
    L_0x002c:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r4 = 8193; // 0x2001 float:1.1481E-41 double:4.048E-320;
        r0 = r0.get(r4, r1);
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r4 != 0) goto L_0x002a;
    L_0x0041:
        r4 = "id=\"setavatar\"";
        r4 = r0.contains(r4);
        if (r4 == 0) goto L_0x004e;
    L_0x004a:
        cau();
        goto L_0x002a;
    L_0x004e:
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r4 != 0) goto L_0x0081;
    L_0x0054:
        r0 = bb(r10, r0);
        if (r0 == 0) goto L_0x0060;
    L_0x005a:
        r4 = r0.size();
        if (r4 == r2) goto L_0x0067;
    L_0x0060:
        r0 = r1;
    L_0x0061:
        if (r0 != 0) goto L_0x002b;
    L_0x0063:
        cau();
        goto L_0x002a;
    L_0x0067:
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.pluginsdk.j.a.a) r0;
        r4 = r0.voX;
        if (r4 == 0) goto L_0x0083;
    L_0x0071:
        r4 = r0.voX;
        r4 = r4.size();
        if (r4 <= 0) goto L_0x0083;
    L_0x0079:
        if (r2 == 0) goto L_0x0081;
    L_0x007b:
        r2 = r0.cat();
        if (r2 != 0) goto L_0x0061;
    L_0x0081:
        r0 = r1;
        goto L_0x0061;
    L_0x0083:
        r2 = r3;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.j.a.a.en(android.content.Context):com.tencent.mm.pluginsdk.j.a.a");
    }
}
