package com.tencent.mm.sdk.platformtools;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import java.lang.ref.WeakReference;

public final class aw {
    private static final String xpX = Media.EXTERNAL_CONTENT_URI.toString();
    private static final String[] xpY = new String[]{"_display_name", "_data", "date_added"};
    private static ContentObserver xpZ;
    private static WeakReference<a> xqa;

    public interface a {
        void amn();
    }

    public static void a(a aVar) {
        x.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback callback[%s], stack[%s]", aVar, bi.chl());
        if (aVar == null) {
            if (xpZ != null) {
                ad.getContext().getContentResolver().unregisterContentObserver(xpZ);
                xpZ = null;
            }
            if (xqa != null) {
                xqa.clear();
                xqa = null;
                return;
            }
            return;
        }
        xqa = new WeakReference(aVar);
        if (xpZ == null) {
            xpZ = new ContentObserver(new Handler(Looper.myLooper())) {
                private long xqb;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onChange(boolean r18, android.net.Uri r19) {
                    /*
                    r17 = this;
                    r2 = "MicroMsg.ScreenShotUtil";
                    r3 = new java.lang.StringBuilder;
                    r4 = "summerscreenshot onChange: ";
                    r3.<init>(r4);
                    r0 = r18;
                    r3 = r3.append(r0);
                    r4 = ", uri:";
                    r3 = r3.append(r4);
                    r4 = r19.toString();
                    r3 = r3.append(r4);
                    r3 = r3.toString();
                    com.tencent.mm.sdk.platformtools.x.d(r2, r3);
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    if (r2 == 0) goto L_0x0037;
                L_0x002d:
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    r2 = r2.get();
                    if (r2 != 0) goto L_0x006e;
                L_0x0037:
                    r2 = "MicroMsg.ScreenShotUtil";
                    r3 = "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]";
                    r4 = 1;
                    r4 = new java.lang.Object[r4];
                    r5 = 0;
                    r6 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    r4[r5] = r6;
                    com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
                    r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
                    r2 = r2.getContentResolver();
                    r0 = r17;
                    r2.unregisterContentObserver(r0);
                    com.tencent.mm.sdk.platformtools.aw.xpZ = null;
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    if (r2 == 0) goto L_0x006a;
                L_0x0060:
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    r2.clear();
                    com.tencent.mm.sdk.platformtools.aw.xqa = null;
                L_0x006a:
                    super.onChange(r18, r19);
                    return;
                L_0x006e:
                    r9 = 0;
                    r10 = 0;
                    r2 = r19.toString();
                    r3 = com.tencent.mm.sdk.platformtools.aw.xpX;
                    r2 = r2.matches(r3);
                    if (r2 != 0) goto L_0x008d;
                L_0x007f:
                    r2 = r19.toString();
                    r3 = com.tencent.mm.sdk.platformtools.aw.xpX;
                    r2 = r2.contains(r3);
                    if (r2 == 0) goto L_0x006a;
                L_0x008d:
                    r8 = 0;
                    r2 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x0183, all -> 0x01a8 }
                    r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x0183, all -> 0x01a8 }
                    r4 = com.tencent.mm.sdk.platformtools.aw.xpY;	 Catch:{ Exception -> 0x0183, all -> 0x01a8 }
                    r5 = 0;
                    r6 = 0;
                    r7 = "date_added DESC limit 1";
                    r3 = r19;
                    r5 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0183, all -> 0x01a8 }
                    if (r5 == 0) goto L_0x01ee;
                L_0x00a7:
                    r2 = r5.moveToFirst();	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    if (r2 == 0) goto L_0x01ee;
                L_0x00ad:
                    r2 = "_data";
                    r2 = r5.getColumnIndex(r2);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r4 = r5.getString(r2);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r2 = "date_added";
                    r2 = r5.getColumnIndex(r2);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r6 = r5.getLong(r2);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
                    r2 = r2 / r12;
                    r8 = "MicroMsg.ScreenShotUtil";
                    r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r13 = "summerscreenshot path: ";
                    r12.<init>(r13);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r12 = r12.append(r4);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r13 = ", dateAdded: ";
                    r12 = r12.append(r13);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r12 = r12.append(r6);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r13 = ", currentTime: ";
                    r12 = r12.append(r13);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r12 = r12.append(r2);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r12 = r12.toString();	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    com.tencent.mm.sdk.platformtools.x.d(r8, r12);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r12 = r2 - r6;
                    r12 = java.lang.Math.abs(r12);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r14 = 10;
                    r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
                    if (r8 > 0) goto L_0x01ee;
                L_0x0102:
                    r0 = r17;
                    r12 = r0.xqb;	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r12 = r2 - r12;
                    r14 = 1;
                    r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
                    if (r8 <= 0) goto L_0x01ee;
                L_0x010e:
                    r8 = com.tencent.mm.sdk.platformtools.bi.oN(r4);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    if (r8 != 0) goto L_0x01ee;
                L_0x0114:
                    r8 = r4.toLowerCase();	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    r12 = "screenshot";
                    r8 = r8.contains(r12);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    if (r8 != 0) goto L_0x0133;
                L_0x0121:
                    r8 = "截屏";
                    r8 = r4.contains(r8);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    if (r8 != 0) goto L_0x0133;
                L_0x012a:
                    r8 = "截图";
                    r8 = r4.contains(r8);	 Catch:{ Exception -> 0x01e0, all -> 0x01db }
                    if (r8 == 0) goto L_0x01ee;
                L_0x0133:
                    r0 = r17;
                    r0.xqb = r2;	 Catch:{ Exception -> 0x01e6, all -> 0x01db }
                    r2 = r6;
                L_0x0138:
                    if (r5 == 0) goto L_0x013d;
                L_0x013a:
                    r5.close();
                L_0x013d:
                    r5 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
                    if (r5 != 0) goto L_0x006a;
                L_0x0143:
                    r5 = "MicroMsg.ScreenShotUtil";
                    r6 = new java.lang.StringBuilder;
                    r7 = "summerscreenshot added path: ";
                    r6.<init>(r7);
                    r4 = r6.append(r4);
                    r6 = ", time: ";
                    r4 = r4.append(r6);
                    r2 = r4.append(r2);
                    r2 = r2.toString();
                    com.tencent.mm.sdk.platformtools.x.i(r5, r2);
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    if (r2 == 0) goto L_0x01b0;
                L_0x016a:
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    r2 = r2.get();
                    if (r2 == 0) goto L_0x01b0;
                L_0x0174:
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    r2 = r2.get();
                    r2 = (com.tencent.mm.sdk.platformtools.aw.a) r2;
                    r2.amn();
                    goto L_0x006a;
                L_0x0183:
                    r2 = move-exception;
                    r5 = r2;
                    r6 = r8;
                    r4 = r9;
                    r2 = r10;
                L_0x0188:
                    r7 = "MicroMsg.ScreenShotUtil";
                    r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01dd }
                    r9 = "summerscreenshot fail e:";
                    r8.<init>(r9);	 Catch:{ all -> 0x01dd }
                    r5 = r5.getMessage();	 Catch:{ all -> 0x01dd }
                    r5 = r8.append(r5);	 Catch:{ all -> 0x01dd }
                    r5 = r5.toString();	 Catch:{ all -> 0x01dd }
                    com.tencent.mm.sdk.platformtools.x.w(r7, r5);	 Catch:{ all -> 0x01dd }
                    if (r6 == 0) goto L_0x013d;
                L_0x01a4:
                    r6.close();
                    goto L_0x013d;
                L_0x01a8:
                    r2 = move-exception;
                    r5 = r8;
                L_0x01aa:
                    if (r5 == 0) goto L_0x01af;
                L_0x01ac:
                    r5.close();
                L_0x01af:
                    throw r2;
                L_0x01b0:
                    r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
                    r2 = r2.getContentResolver();
                    r0 = r17;
                    r2.unregisterContentObserver(r0);
                    com.tencent.mm.sdk.platformtools.aw.xpZ = null;
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    if (r2 == 0) goto L_0x01d0;
                L_0x01c6:
                    r2 = com.tencent.mm.sdk.platformtools.aw.xqa;
                    r2.clear();
                    com.tencent.mm.sdk.platformtools.aw.xqa = null;
                L_0x01d0:
                    r2 = "MicroMsg.ScreenShotUtil";
                    r3 = "summerscreenshot unregisterContentObserver callback is null 2";
                    com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                    goto L_0x006a;
                L_0x01db:
                    r2 = move-exception;
                    goto L_0x01aa;
                L_0x01dd:
                    r2 = move-exception;
                    r5 = r6;
                    goto L_0x01aa;
                L_0x01e0:
                    r2 = move-exception;
                    r6 = r5;
                    r4 = r9;
                    r5 = r2;
                    r2 = r10;
                    goto L_0x0188;
                L_0x01e6:
                    r2 = move-exception;
                    r16 = r2;
                    r2 = r6;
                    r6 = r5;
                    r5 = r16;
                    goto L_0x0188;
                L_0x01ee:
                    r2 = r10;
                    r4 = r9;
                    goto L_0x0138;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.aw.1.onChange(boolean, android.net.Uri):void");
                }
            };
            ad.getContext().getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, xpZ);
        }
    }
}
