package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> rjw = new ConcurrentHashMap();
    private static volatile long rjx = 0;

    private static class b {
        int mHeight;
        String mMimeType;
        int mWidth;
        int rjA;
        long rjB;
        String rjy;

        private b() {
            this.rjy = "";
            this.mMimeType = "";
            this.mWidth = -1;
            this.mHeight = -1;
            this.rjA = -1;
            this.rjB = -1;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static class a {
        int mHeight;
        String mMimeType;
        int mWidth;
        int rjA;
        long rjB;
        long rjC;
        long rjD;
        String rjy;
        int rjz;

        private a() {
            this.rjy = "";
            this.rjz = 0;
            this.mMimeType = "";
            this.mWidth = -1;
            this.mHeight = -1;
            this.rjA = -1;
            this.rjB = -1;
            this.rjC = -1;
            this.rjD = -1;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static void bxa() {
        synchronized (rjw) {
            if (bi.bB(rjx) <= 120000) {
                return;
            }
            rjx = bi.Wz();
            rjw.clear();
        }
    }

    private static String Ly(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    public static void a(String str, String str2, int i, int i2, int i3, long j) {
        try {
            b bVar = new b();
            bVar.rjy = Ly(str);
            bVar.mMimeType = str2;
            bVar.mWidth = i;
            bVar.mHeight = i2;
            bVar.rjA = i3;
            bVar.rjB = j;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append(bVar.rjy).append(',').append(bVar.mMimeType).append(',').append(bVar.mWidth).append(',').append(bVar.mHeight).append(',').append(bVar.rjA).append(',').append(bVar.rjB);
            String stringBuilder2 = stringBuilder.toString();
            x.i("MicroMsg.SnsImgStats", "report up: " + stringBuilder2);
            g.pWK.k(13512, stringBuilder2);
        } catch (Exception e) {
        }
    }

    public static void a(String str, String str2, int i, String str3, int i2, int i3, int i4, long j, long j2) {
        try {
            a aVar = new a();
            aVar.rjy = Ly(str2);
            aVar.rjz = i;
            aVar.mMimeType = str3;
            aVar.mWidth = i2;
            aVar.mHeight = i3;
            aVar.rjA = i4;
            aVar.rjB = j;
            aVar.rjC = j2;
            rjw.put(str, aVar);
        } catch (Exception e) {
        }
    }

    public static void ae(String str, long j) {
        try {
            a aVar = (a) rjw.remove(str);
            if (aVar != null) {
                aVar.rjD = j;
                StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                stringBuilder.append(aVar.rjy).append(',').append(aVar.rjz).append(',').append(aVar.mMimeType).append(',').append(aVar.mWidth).append(',').append(aVar.mHeight).append(',').append(aVar.rjA).append(',').append(aVar.rjB).append(',').append(aVar.rjC).append(',').append(aVar.rjD);
                String stringBuilder2 = stringBuilder.toString();
                x.i("MicroMsg.SnsImgStats", "report dl: " + stringBuilder2);
                g.pWK.k(13513, stringBuilder2);
                bxa();
            }
        } catch (Exception e) {
        } finally {
            bxa();
        }
    }
}
