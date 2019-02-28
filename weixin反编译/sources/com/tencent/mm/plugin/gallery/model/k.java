package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.g.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public abstract class k implements g {
    private static int mWT = 100;
    public static String mXb = "date_added";
    public static String mXc = "datetaken";
    public static String mXd = "date_mix";
    protected ContentResolver hOn = this.mContext.getContentResolver();
    protected Context mContext = ad.getContext();
    private boolean mXe = false;
    boolean mXf = false;
    long start = 0;

    protected abstract String BZ(String str);

    protected abstract Uri aOH();

    protected abstract String[] aOI();

    protected abstract String aOJ();

    protected abstract String aOK();

    protected abstract String[] getProjection();

    protected abstract String getSelection();

    protected abstract int getType();

    protected k() {
    }

    public ArrayList<AlbumItem> aOF() {
        Cursor query;
        ArrayList<AlbumItem> arrayList = new ArrayList();
        try {
            query = this.hOn.query(aOH(), getProjection(), getSelection(), null, aOJ());
        } catch (Exception e) {
            x.e("MicroMsg.MediaQueryBase", "query album list failed : [%s]", e.getMessage());
            query = null;
        }
        if (query == null) {
            x.d("MicroMsg.MediaQueryBase", "no media folder now");
            return arrayList;
        }
        if (query.moveToFirst()) {
            do {
                Long valueOf = Long.valueOf(0);
                try {
                    valueOf = Long.valueOf(bi.getLong(query.getString(query.getColumnIndexOrThrow("_id")), 0));
                } catch (NumberFormatException e2) {
                } catch (IllegalArgumentException e3) {
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                String string2 = query.getString(query.getColumnIndexOrThrow(aOK()));
                if (bi.oN(string2) && getType() == 2) {
                    x.e("MicroMsg.MediaQueryBase", "null or nill album name, ignore this folder");
                } else {
                    int i = query.getInt(3);
                    x.i("MicroMsg.MediaQueryBase", string + "====" + string2 + "=====" + valueOf + ", " + i);
                    if (i == 0 || (bi.oN(string) && bi.oN(null))) {
                        x.e("MicroMsg.MediaQueryBase", "query album failed, " + i + ", " + string + "," + null);
                    } else {
                        if (bi.oN(string) || !e.bO(string)) {
                            string = null;
                        }
                        if (!bi.oN(null)) {
                            e.bO(null);
                        }
                        if (string == null) {
                            x.e("MicroMsg.MediaQueryBase", "this item has no thumb path and orignal path");
                        } else {
                            MediaItem a = MediaItem.a(getType(), valueOf.longValue(), string, null, query.getString(query.getColumnIndexOrThrow("mime_type")));
                            AlbumItem albumItem = new AlbumItem(string2, i);
                            albumItem.mWO = a;
                            arrayList.add(albumItem);
                        }
                    }
                }
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    public final void aOG() {
        synchronized (this) {
            if (this.mXe) {
                this.mXf = true;
            }
        }
    }

    protected final synchronized boolean aOM() {
        return this.mXf;
    }

    public final ArrayList<MediaItem> a(String str, int i, c cVar, long j) {
        this.start = System.currentTimeMillis();
        synchronized (this) {
            this.mXe = true;
        }
        ArrayList<MediaItem> b = b(str, i, cVar, j);
        synchronized (this) {
            this.mXe = false;
        }
        x.i("MicroMsg.MediaQueryBase", "[queryEnd] cost:%s", Long.valueOf(System.currentTimeMillis() - this.start));
        return b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem> b(java.lang.String r23, int r24, com.tencent.mm.plugin.gallery.model.g.c r25, long r26) {
        /*
        r22 = this;
        r14 = new java.util.ArrayList;
        r14.<init>();
        r10 = 0;
        r0 = r22;
        r4 = r0.hOn;	 Catch:{ Exception -> 0x0045 }
        r5 = r22.aOH();	 Catch:{ Exception -> 0x0045 }
        r6 = r22.aOI();	 Catch:{ Exception -> 0x0045 }
        r7 = r22.BZ(r23);	 Catch:{ Exception -> 0x0045 }
        r8 = 0;
        r9 = r22.aOJ();	 Catch:{ Exception -> 0x0045 }
        r4 = r4.query(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0045 }
        r15 = r4;
    L_0x0020:
        if (r15 != 0) goto L_0x005b;
    L_0x0022:
        r4 = "MicroMsg.MediaQueryBase";
        r5 = new java.lang.StringBuilder;
        r6 = "query album failed: ";
        r5.<init>(r6);
        r0 = r23;
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r4, r5);
        if (r25 == 0) goto L_0x0043;
    L_0x003c:
        r0 = r25;
        r1 = r26;
        r0.a(r14, r1);
    L_0x0043:
        r4 = r14;
    L_0x0044:
        return r4;
    L_0x0045:
        r4 = move-exception;
        r5 = "MicroMsg.MediaQueryBase";
        r6 = "query media items in album failed : [%s]";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r4 = r4.getMessage();
        r7[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
        r15 = r10;
        goto L_0x0020;
    L_0x005b:
        r4 = 0;
        r5 = r15.moveToFirst();
        if (r5 == 0) goto L_0x01b6;
    L_0x0062:
        r13 = 0;
        r4 = 0;
        r4 = java.lang.Long.valueOf(r4);
        r5 = "_id";
        r5 = r15.getColumnIndexOrThrow(r5);	 Catch:{ NumberFormatException -> 0x024b, IllegalArgumentException -> 0x0248 }
        r5 = r15.getString(r5);	 Catch:{ NumberFormatException -> 0x024b, IllegalArgumentException -> 0x0248 }
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.getLong(r5, r6);	 Catch:{ NumberFormatException -> 0x024b, IllegalArgumentException -> 0x0248 }
        r4 = java.lang.Long.valueOf(r6);	 Catch:{ NumberFormatException -> 0x024b, IllegalArgumentException -> 0x0248 }
    L_0x007e:
        r5 = "_data";
        r5 = r15.getColumnIndexOrThrow(r5);
        r16 = r15.getString(r5);
        r5 = mXd;
        r5 = r15.getColumnIndexOrThrow(r5);
        r17 = r15.getString(r5);
        r5 = mXd;
        r5 = r15.getColumnIndexOrThrow(r5);
        r18 = r15.getLong(r5);
        r5 = mXb;
        r5 = r15.getColumnIndexOrThrow(r5);
        r20 = r15.getString(r5);
        r5 = mXc;
        r5 = r15.getColumnIndexOrThrow(r5);
        r21 = r15.getString(r5);
        if (r17 == 0) goto L_0x00cb;
    L_0x00b3:
        r5 = "";
        r0 = r17;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x00cb;
    L_0x00be:
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r17;
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01c7;
    L_0x00cb:
        r5 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r8 = 1;
        r10 = 1;
        r12 = 1;
        r5.a(r6, r8, r10, r12);
        r6 = 0;
        r5 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
        if (r5 == 0) goto L_0x00e9;
    L_0x00dd:
        r5 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r8 = 4;
        r10 = 1;
        r12 = 1;
        r5.a(r6, r8, r10, r12);
    L_0x00e9:
        if (r20 == 0) goto L_0x0103;
    L_0x00eb:
        r5 = "";
        r0 = r20;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x0103;
    L_0x00f6:
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r20;
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x0129;
    L_0x0103:
        if (r21 == 0) goto L_0x0129;
    L_0x0105:
        r5 = "";
        r0 = r21;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x0129;
    L_0x0110:
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r21;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x0129;
    L_0x011d:
        r5 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r8 = 3;
        r10 = 1;
        r12 = 1;
        r5.a(r6, r8, r10, r12);
    L_0x0129:
        if (r21 == 0) goto L_0x0143;
    L_0x012b:
        r5 = "";
        r0 = r21;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x0143;
    L_0x0136:
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r21;
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x0169;
    L_0x0143:
        if (r20 == 0) goto L_0x0169;
    L_0x0145:
        r5 = "";
        r0 = r20;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x0169;
    L_0x0150:
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r20;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x0169;
    L_0x015d:
        r5 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r8 = 2;
        r10 = 1;
        r12 = 1;
        r5.a(r6, r8, r10, r12);
    L_0x0169:
        r5 = r22.getType();
        r6 = r4.longValue();
        r5 = com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem.w(r5, r6);
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r16);
        if (r4 != 0) goto L_0x018c;
    L_0x017b:
        r4 = new java.io.File;
        r0 = r16;
        r4.<init>(r0);
        r4 = r4.exists();
        if (r4 == 0) goto L_0x018c;
    L_0x0188:
        r0 = r16;
        r5.hQc = r0;
    L_0x018c:
        r0 = r17;
        r1 = r20;
        r6 = cM(r0, r1);
        r5.mWS = r6;
        r4 = r5.hQc;
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r4 == 0) goto L_0x0217;
    L_0x019e:
        r4 = r5.mqO;
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r4 == 0) goto L_0x0217;
    L_0x01a6:
        r4 = "MicroMsg.MediaQueryBase";
        r5 = "thumb file and orignal file both not exist";
        com.tencent.mm.sdk.platformtools.x.e(r4, r5);
        r4 = r13;
    L_0x01b0:
        r5 = r15.moveToNext();
        if (r5 != 0) goto L_0x0062;
    L_0x01b6:
        r15.close();
        if (r4 != 0) goto L_0x01c4;
    L_0x01bb:
        if (r25 == 0) goto L_0x01c4;
    L_0x01bd:
        r0 = r25;
        r1 = r26;
        r0.a(r14, r1);
    L_0x01c4:
        r4 = r14;
        goto L_0x0044;
    L_0x01c7:
        if (r21 == 0) goto L_0x01e1;
    L_0x01c9:
        r5 = "";
        r0 = r21;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x01e1;
    L_0x01d4:
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r21;
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01ef;
    L_0x01e1:
        r5 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r8 = 6;
        r10 = 1;
        r12 = 1;
        r5.a(r6, r8, r10, r12);
        goto L_0x0169;
    L_0x01ef:
        if (r20 == 0) goto L_0x0209;
    L_0x01f1:
        r5 = "";
        r0 = r20;
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x0209;
    L_0x01fc:
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r20;
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x0169;
    L_0x0209:
        r5 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r8 = 5;
        r10 = 1;
        r12 = 1;
        r5.a(r6, r8, r10, r12);
        goto L_0x0169;
    L_0x0217:
        r4 = "mime_type";
        r4 = r15.getColumnIndexOrThrow(r4);
        r4 = r15.getString(r4);
        r6 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r6 == 0) goto L_0x022b;
    L_0x0228:
        r4 = "";
    L_0x022b:
        r5.mMimeType = r4;
        r14.add(r5);
        r4 = r14.size();
        r5 = mWT;
        r4 = r4 % r5;
        if (r4 != 0) goto L_0x024e;
    L_0x0239:
        if (r25 == 0) goto L_0x024e;
    L_0x023b:
        r0 = r25;
        r1 = r26;
        r0.a(r14, r1);
        r14.clear();
        r4 = 1;
        goto L_0x01b0;
    L_0x0248:
        r5 = move-exception;
        goto L_0x007e;
    L_0x024b:
        r5 = move-exception;
        goto L_0x007e;
    L_0x024e:
        r4 = r13;
        goto L_0x01b0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.k.b(java.lang.String, int, com.tencent.mm.plugin.gallery.model.g$c, long):java.util.ArrayList<com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static long cM(java.lang.String r9, java.lang.String r10) {
        /*
        r8 = 0;
        r0 = 0;
        r4 = java.lang.System.currentTimeMillis();
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r9);
        if (r2 != 0) goto L_0x0034;
    L_0x000d:
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NumberFormatException -> 0x0028 }
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.getLong(r9, r6);	 Catch:{ NumberFormatException -> 0x0028 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NumberFormatException -> 0x0028 }
        r0 = r2.convert(r6, r3);	 Catch:{ NumberFormatException -> 0x0028 }
        r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x0034;
    L_0x001f:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r4 / r2;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0034;
    L_0x0027:
        return r0;
    L_0x0028:
        r2 = move-exception;
        r3 = "MicroMsg.MediaQueryBase";
        r6 = "";
        r7 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r6, r7);
    L_0x0034:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r2 != 0) goto L_0x0027;
    L_0x003a:
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NumberFormatException -> 0x004d }
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bi.getLong(r10, r6);	 Catch:{ NumberFormatException -> 0x004d }
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ NumberFormatException -> 0x004d }
        r0 = r2.convert(r6, r3);	 Catch:{ NumberFormatException -> 0x004d }
        r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x0027;
    L_0x004c:
        goto L_0x0027;
    L_0x004d:
        r2 = move-exception;
        r3 = "MicroMsg.MediaQueryBase";
        r4 = "";
        r5 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.k.cM(java.lang.String, java.lang.String):long");
    }
}
