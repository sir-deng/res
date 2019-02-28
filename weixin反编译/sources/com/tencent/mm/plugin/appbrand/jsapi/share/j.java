package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;

public final class j {
    public static Bitmap b(p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar.aff();
    }

    public static String a(final p pVar, String str, boolean z) {
        if (pVar == null) {
            return null;
        }
        final String str2 = pVar.mAppId;
        if (bi.oN(str)) {
            if (!z) {
                return null;
            }
            pVar.a(1, null, new Object[0]);
            final String genMediaFilePath = AppBrandLocalMediaObjectManager.genMediaFilePath(str2, "share_" + System.currentTimeMillis());
            c.a(str2, new b() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(com.tencent.mm.plugin.appbrand.c.c r11) {
                    /*
                    r10 = this;
                    r5 = 3;
                    r9 = 2;
                    r8 = 0;
                    r7 = 1;
                    r0 = r1;
                    com.tencent.mm.plugin.appbrand.c.b(r0, r10);
                    r0 = new android.os.Bundle;
                    r0.<init>();
                    r1 = "action";
                    r0.putInt(r1, r7);
                    r1 = "com.tencent.mm";
                    r2 = com.tencent.mm.plugin.appbrand.jsapi.share.a.class;
                    r3 = 0;
                    com.tencent.mm.ipcinvoker.f.a(r1, r0, r2, r3);
                    r0 = java.lang.System.currentTimeMillis();
                    r2 = r7;
                    r2 = com.tencent.mm.plugin.appbrand.jsapi.share.j.b(r2);
                    r3 = "MicroMsg.ShareHelper";
                    r4 = "cropCover(appId : %s, pageView : %s, cropCost : %sms)";
                    r5 = new java.lang.Object[r5];
                    r6 = r7;
                    r6 = r6.mAppId;
                    r5[r8] = r6;
                    r6 = r7;
                    r6 = r6.hashCode();
                    r6 = java.lang.Integer.valueOf(r6);
                    r5[r7] = r6;
                    r6 = java.lang.System.currentTimeMillis();
                    r0 = r6 - r0;
                    r0 = java.lang.Long.valueOf(r0);
                    r5[r9] = r0;
                    com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
                    if (r2 == 0) goto L_0x00b7;
                L_0x0052:
                    r0 = r2.isRecycled();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    if (r0 != 0) goto L_0x00b7;
                L_0x0058:
                    r0 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r3 = 100;
                    r4 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r5 = r0;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r6 = 1;
                    com.tencent.mm.sdk.platformtools.d.a(r2, r3, r4, r5, r6);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r3 = "MicroMsg.ShareHelper";
                    r4 = "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)";
                    r5 = 3;
                    r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r6 = 0;
                    r7 = r7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r7 = r7.mAppId;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r5[r6] = r7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r6 = 1;
                    r7 = r7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r7 = r7.hashCode();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r7 = java.lang.Integer.valueOf(r7);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r5[r6] = r7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r6 = 2;
                    r8 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r8 = r8 - r0;
                    r7 = java.lang.Long.valueOf(r8);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r5[r6] = r7;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r3 = new android.os.Bundle;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r3.<init>();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r4 = "delay_load_img_path";
                    r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r6 = "file://";
                    r5.<init>(r6);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r6 = r0;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r5 = r5.append(r6);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r5 = r5.toString();	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r3.putString(r4, r5);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r4 = new com.tencent.mm.plugin.appbrand.jsapi.share.j$1$1;	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    r4.<init>(r0, r3);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                    com.tencent.mm.by.a.post(r4);	 Catch:{ IOException -> 0x00c3, Exception -> 0x00df }
                L_0x00b7:
                    if (r2 == 0) goto L_0x00c2;
                L_0x00b9:
                    r0 = r2.isRecycled();
                    if (r0 != 0) goto L_0x00c2;
                L_0x00bf:
                    r2.recycle();
                L_0x00c2:
                    return;
                L_0x00c3:
                    r0 = move-exception;
                    r1 = "MicroMsg.ShareHelper";
                    r3 = "save temp bitmap to file failed, . exception : %s";
                    r4 = 1;
                    r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00fb }
                    r5 = 0;
                    r4[r5] = r0;	 Catch:{ all -> 0x00fb }
                    com.tencent.mm.sdk.platformtools.x.w(r1, r3, r4);	 Catch:{ all -> 0x00fb }
                    if (r2 == 0) goto L_0x00c2;
                L_0x00d5:
                    r0 = r2.isRecycled();
                    if (r0 != 0) goto L_0x00c2;
                L_0x00db:
                    r2.recycle();
                    goto L_0x00c2;
                L_0x00df:
                    r0 = move-exception;
                    r1 = "MicroMsg.ShareHelper";
                    r3 = "save temp bitmap to file failed, . exception : %s";
                    r4 = 1;
                    r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00fb }
                    r5 = 0;
                    r4[r5] = r0;	 Catch:{ all -> 0x00fb }
                    com.tencent.mm.sdk.platformtools.x.w(r1, r3, r4);	 Catch:{ all -> 0x00fb }
                    if (r2 == 0) goto L_0x00c2;
                L_0x00f1:
                    r0 = r2.isRecycled();
                    if (r0 != 0) goto L_0x00c2;
                L_0x00f7:
                    r2.recycle();
                    goto L_0x00c2;
                L_0x00fb:
                    r0 = move-exception;
                    if (r2 == 0) goto L_0x0107;
                L_0x00fe:
                    r1 = r2.isRecycled();
                    if (r1 != 0) goto L_0x0107;
                L_0x0104:
                    r2.recycle();
                L_0x0107:
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.share.j.1.a(com.tencent.mm.plugin.appbrand.c$c):void");
                }
            });
            return "delayLoadFile://" + genMediaFilePath;
        } else if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            File ql = pVar.iuk.isU.ql(str);
            if (ql == null || !ql.exists()) {
                return null;
            }
            return "file://" + ql.getAbsolutePath();
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            return null;
        } else {
            str2 = AppBrandLocalMediaObjectManager.genMediaFilePath(str2, "share_" + System.currentTimeMillis());
            Bitmap j = o.j(pVar.iuk, str);
            if (j == null || j.isRecycled()) {
                return null;
            }
            try {
                d.a(j, 100, CompressFormat.PNG, str2, true);
                if (!(j == null || j.isRecycled())) {
                    j.recycle();
                }
            } catch (IOException e) {
                x.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", e);
                if (!(j == null || j.isRecycled())) {
                    j.recycle();
                }
            } catch (Throwable th) {
                if (!(j == null || j.isRecycled())) {
                    j.recycle();
                }
            }
            return "file://" + str2;
        }
    }

    public static boolean te(String str) {
        if (bi.oN(str)) {
            return true;
        }
        return false;
    }

    public static String tf(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("file://")) {
            return str.replace("file://", "");
        }
        if (str.startsWith("delayLoadFile://")) {
            return str.replace("delayLoadFile://", "");
        }
        return str;
    }
}
