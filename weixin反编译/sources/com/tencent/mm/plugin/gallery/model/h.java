package com.tencent.mm.plugin.gallery.model;

import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Media;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.g.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class h extends k {
    private static int mWT = 100;
    private i mWU = new i();
    private n mWV = new n();
    private MediaMetadataRetriever mWW = new MediaMetadataRetriever();
    int mWX = 0;

    public final ArrayList<AlbumItem> aOF() {
        Cursor query;
        Cursor cursor = null;
        ArrayList<AlbumItem> arrayList = new ArrayList();
        try {
            query = this.hOn.query(Media.EXTERNAL_CONTENT_URI, this.mWV.getProjection(), "0==0) GROUP BY (bucket_display_name", null, this.mWV.aOJ());
        } catch (Exception e) {
            x.e("MicroMsg.ImageAndVideoQuery", "query video album list failed : [%s]", e.getMessage());
            query = cursor;
        }
        if (query == null) {
            x.d("MicroMsg.ImageAndVideoQuery", "no video folder now");
        } else {
            if (query.moveToFirst()) {
                AlbumItem b;
                MediaItem mediaItem = cursor;
                int i = 0;
                do {
                    b = b(query, 2, "bucket_display_name");
                    if (b != null) {
                        i += b.fuA;
                        if (mediaItem == null) {
                            mediaItem = b.mWO;
                        }
                    }
                } while (query.moveToNext());
                b = new AlbumItem(ad.getContext().getString(R.l.elk), i);
                b.mWO = mediaItem;
                arrayList.add(b);
            }
            query.close();
        }
        try {
            cursor = this.hOn.query(Images.Media.EXTERNAL_CONTENT_URI, this.mWU.getProjection(), "0==0) GROUP BY (bucket_display_name", null, this.mWU.aOJ());
        } catch (Exception e2) {
            x.e("MicroMsg.ImageAndVideoQuery", "query image album list failed : [%s]", e2.getMessage());
        }
        if (cursor == null) {
            x.d("MicroMsg.ImageAndVideoQuery", "no image folder now");
        } else {
            if (cursor.moveToFirst()) {
                do {
                    AlbumItem b2 = b(cursor, 1, "bucket_display_name");
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return arrayList;
    }

    public final ArrayList<MediaItem> b(String str, int i, c cVar, long j) {
        Cursor query;
        Cursor cursor;
        Cursor cursor2;
        x.i("MicroMsg.ImageAndVideoQuery", "queryMediaItemsInAlbum: %s", str);
        ArrayList<MediaItem> arrayList = new ArrayList();
        if (i == 1 || i == 3) {
            try {
                query = this.hOn.query(Images.Media.EXTERNAL_CONTENT_URI, this.mWU.aOI(), this.mWU.BZ(str), null, this.mWU.aOJ());
            } catch (Exception e) {
                x.e("MicroMsg.ImageAndVideoQuery", "query image items in album failed : [%s]", e.getMessage());
                cursor = null;
            }
        } else {
            query = null;
        }
        cursor = query;
        if (i == 2 || i == 3) {
            try {
                query = this.hOn.query(Media.EXTERNAL_CONTENT_URI, this.mWV.aOI(), this.mWV.BZ(str), null, this.mWV.aOJ());
            } catch (Exception e2) {
                x.e("MicroMsg.ImageAndVideoQuery", "query video items in album failed : [%s]", e2.getMessage());
                cursor2 = null;
            }
        } else {
            query = null;
        }
        cursor2 = query;
        boolean z = cursor != null && cursor.moveToFirst();
        boolean z2 = cursor2 != null && cursor2.moveToFirst();
        if (z || z2) {
            MediaItem mediaItem = null;
            Object obj = null;
            boolean z3 = z2;
            boolean z4 = z;
            MediaItem mediaItem2 = null;
            boolean z5 = z4;
            while (true) {
                if (!z5 && !z3 && mediaItem == null && mediaItem2 == null) {
                    break;
                } else if (aOM()) {
                    synchronized (this) {
                        this.mXf = false;
                        break;
                    }
                } else {
                    MediaItem b;
                    if (mediaItem == null && z5) {
                        mediaItem = b(cursor, 1);
                        z2 = cursor.moveToNext();
                    } else {
                        z2 = z5;
                    }
                    if (mediaItem2 == null && z3) {
                        b = b(cursor2, 2);
                        z = cursor2.moveToNext();
                    } else {
                        b = mediaItem2;
                        z = z3;
                    }
                    if (mediaItem != null) {
                        if (b == null || mediaItem.a(b) > 0) {
                            x.d("MicroMsg.ImageAndVideoQuery", "image_id:%s mix_date:%s", Long.valueOf(bi.c(Long.valueOf(mediaItem.mWR))), Long.valueOf(bi.c(Long.valueOf(mediaItem.mWS))));
                            arrayList.add(mediaItem);
                            mediaItem = null;
                        } else {
                            arrayList.add(b);
                            b = null;
                        }
                    } else if (b != null) {
                        arrayList.add(b);
                        b = null;
                    } else {
                        x.w("MicroMsg.ImageAndVideoQuery", "Image item and video item are all null");
                    }
                    if (arrayList.size() % mWT != 0 || cVar == null) {
                        z3 = z;
                        obj = null;
                        mediaItem2 = b;
                        z5 = z2;
                    } else {
                        cVar.a(arrayList, j);
                        arrayList.clear();
                        obj = 1;
                        z3 = z;
                        mediaItem2 = b;
                        z5 = z2;
                    }
                }
            }
            if (this.mWX > 1) {
                g.pWK.a(363, 0, (long) this.mWX, true);
                g.pWK.a(363, 7, 1, true);
                this.mWX = 0;
            }
            if (cursor != null) {
                cursor.close();
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            if (obj == null && cVar != null) {
                cVar.a(arrayList, j);
            }
            return arrayList;
        }
        x.d("MicroMsg.ImageAndVideoQuery", "query album failed: " + str);
        if (cVar != null) {
            cVar.a(arrayList, j);
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem b(android.database.Cursor r18, int r19, java.lang.String r20) {
        /*
        r2 = 0;
        r2 = java.lang.Long.valueOf(r2);
        r3 = "_id";
        r0 = r18;
        r3 = r0.getColumnIndexOrThrow(r3);	 Catch:{ NumberFormatException -> 0x0255, IllegalArgumentException -> 0x0252 }
        r0 = r18;
        r3 = r0.getString(r3);	 Catch:{ NumberFormatException -> 0x0255, IllegalArgumentException -> 0x0252 }
        r4 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bi.getLong(r3, r4);	 Catch:{ NumberFormatException -> 0x0255, IllegalArgumentException -> 0x0252 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0255, IllegalArgumentException -> 0x0252 }
    L_0x001f:
        r3 = "_data";
        r0 = r18;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r18;
        r11 = r0.getString(r3);
        r0 = r18;
        r1 = r20;
        r3 = r0.getColumnIndexOrThrow(r1);
        r0 = r18;
        r12 = r0.getString(r3);
        r3 = com.tencent.mm.plugin.gallery.model.k.mXd;
        r0 = r18;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r18;
        r13 = r0.getString(r3);
        r3 = com.tencent.mm.plugin.gallery.model.k.mXd;
        r0 = r18;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r18;
        r14 = r0.getLong(r3);
        r3 = com.tencent.mm.plugin.gallery.model.k.mXb;
        r0 = r18;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r18;
        r16 = r0.getString(r3);
        r3 = com.tencent.mm.plugin.gallery.model.k.mXc;
        r0 = r18;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r18;
        r17 = r0.getString(r3);
        if (r13 == 0) goto L_0x008a;
    L_0x0076:
        r3 = "";
        r3 = r13.equals(r3);
        if (r3 != 0) goto L_0x008a;
    L_0x007f:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r3 = r13.equals(r3);
        if (r3 == 0) goto L_0x0139;
    L_0x008a:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 1;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        r4 = 0;
        r3 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r3 == 0) goto L_0x00a8;
    L_0x009c:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 4;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x00a8:
        if (r16 == 0) goto L_0x00c2;
    L_0x00aa:
        r3 = "";
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x00c2;
    L_0x00b5:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x00e8;
    L_0x00c2:
        if (r17 == 0) goto L_0x00e8;
    L_0x00c4:
        r3 = "";
        r0 = r17;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x00e8;
    L_0x00cf:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r17;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x00e8;
    L_0x00dc:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 3;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x00e8:
        if (r17 == 0) goto L_0x0102;
    L_0x00ea:
        r3 = "";
        r0 = r17;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0102;
    L_0x00f5:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r17;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0128;
    L_0x0102:
        if (r16 == 0) goto L_0x0128;
    L_0x0104:
        r3 = "";
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0128;
    L_0x010f:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0128;
    L_0x011c:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 2;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x0128:
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r12);
        if (r3 == 0) goto L_0x0187;
    L_0x012e:
        r2 = "MicroMsg.ImageAndVideoQuery";
        r3 = "null or nill album name, ignore this folder";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r2 = 0;
    L_0x0138:
        return r2;
    L_0x0139:
        if (r17 == 0) goto L_0x0153;
    L_0x013b:
        r3 = "";
        r0 = r17;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0153;
    L_0x0146:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r17;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0160;
    L_0x0153:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 6;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        goto L_0x0128;
    L_0x0160:
        if (r16 == 0) goto L_0x017a;
    L_0x0162:
        r3 = "";
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x017a;
    L_0x016d:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0128;
    L_0x017a:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 5;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        goto L_0x0128;
    L_0x0187:
        r3 = 3;
        r0 = r18;
        r9 = r0.getInt(r3);
        r3 = "MicroMsg.ImageAndVideoQuery";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r11);
        r5 = "====";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = "=====";
        r4 = r4.append(r5);
        r4 = r4.append(r2);
        r5 = ", ";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.i(r3, r4);
        if (r9 == 0) goto L_0x01d1;
    L_0x01c4:
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r11);
        if (r3 == 0) goto L_0x0201;
    L_0x01ca:
        r3 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r3 == 0) goto L_0x0201;
    L_0x01d1:
        r2 = "MicroMsg.ImageAndVideoQuery";
        r3 = new java.lang.StringBuilder;
        r4 = "query album failed, ";
        r3.<init>(r4);
        r3 = r3.append(r9);
        r4 = ", ";
        r3 = r3.append(r4);
        r3 = r3.append(r11);
        r4 = ",";
        r3 = r3.append(r4);
        r4 = 0;
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r2 = 0;
        goto L_0x0138;
    L_0x0201:
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r11);
        if (r3 != 0) goto L_0x020d;
    L_0x0207:
        r3 = com.tencent.mm.a.e.bO(r11);
        if (r3 != 0) goto L_0x0258;
    L_0x020d:
        r6 = 0;
    L_0x020e:
        r3 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r3 != 0) goto L_0x0219;
    L_0x0215:
        r3 = 0;
        com.tencent.mm.a.e.bO(r3);
    L_0x0219:
        if (r6 != 0) goto L_0x0227;
    L_0x021b:
        r2 = "MicroMsg.ImageAndVideoQuery";
        r3 = "this item has no thumb path and original path";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r2 = 0;
        goto L_0x0138;
    L_0x0227:
        r3 = "mime_type";
        r0 = r18;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r18;
        r8 = r0.getString(r3);
        r4 = r2.longValue();
        r7 = 0;
        r3 = r19;
        r3 = com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem.a(r3, r4, r6, r7, r8);
        r0 = r16;
        r4 = com.tencent.mm.plugin.gallery.model.k.cM(r13, r0);
        r3.mWS = r4;
        r2 = new com.tencent.mm.plugin.gallery.model.GalleryItem$AlbumItem;
        r2.<init>(r12, r9);
        r2.mWO = r3;
        goto L_0x0138;
    L_0x0252:
        r3 = move-exception;
        goto L_0x001f;
    L_0x0255:
        r3 = move-exception;
        goto L_0x001f;
    L_0x0258:
        r6 = r11;
        goto L_0x020e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.h.b(android.database.Cursor, int, java.lang.String):com.tencent.mm.plugin.gallery.model.GalleryItem$AlbumItem");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem b(android.database.Cursor r17, int r18) {
        /*
        r2 = 0;
        r2 = java.lang.Long.valueOf(r2);
        r3 = "_id";
        r0 = r17;
        r3 = r0.getColumnIndexOrThrow(r3);	 Catch:{ NumberFormatException -> 0x01ba, IllegalArgumentException -> 0x01b7 }
        r0 = r17;
        r3 = r0.getString(r3);	 Catch:{ NumberFormatException -> 0x01ba, IllegalArgumentException -> 0x01b7 }
        r4 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bi.getLong(r3, r4);	 Catch:{ NumberFormatException -> 0x01ba, IllegalArgumentException -> 0x01b7 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ NumberFormatException -> 0x01ba, IllegalArgumentException -> 0x01b7 }
    L_0x001f:
        r3 = "_data";
        r0 = r17;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r17;
        r11 = r0.getString(r3);
        r3 = com.tencent.mm.plugin.gallery.model.k.mXd;
        r0 = r17;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r17;
        r12 = r0.getString(r3);
        r3 = com.tencent.mm.plugin.gallery.model.k.mXd;
        r0 = r17;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r17;
        r14 = r0.getLong(r3);
        r3 = com.tencent.mm.plugin.gallery.model.k.mXb;
        r0 = r17;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r17;
        r13 = r0.getString(r3);
        r3 = com.tencent.mm.plugin.gallery.model.k.mXc;
        r0 = r17;
        r3 = r0.getColumnIndexOrThrow(r3);
        r0 = r17;
        r16 = r0.getString(r3);
        if (r12 == 0) goto L_0x007c;
    L_0x0068:
        r3 = "";
        r3 = r12.equals(r3);
        if (r3 != 0) goto L_0x007c;
    L_0x0071:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r3 = r12.equals(r3);
        if (r3 == 0) goto L_0x0150;
    L_0x007c:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 1;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        r4 = 0;
        r3 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r3 == 0) goto L_0x009a;
    L_0x008e:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 4;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x009a:
        if (r13 == 0) goto L_0x00b0;
    L_0x009c:
        r3 = "";
        r3 = r13.equals(r3);
        if (r3 != 0) goto L_0x00b0;
    L_0x00a5:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r3 = r13.equals(r3);
        if (r3 == 0) goto L_0x00d6;
    L_0x00b0:
        if (r16 == 0) goto L_0x00d6;
    L_0x00b2:
        r3 = "";
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x00d6;
    L_0x00bd:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x00d6;
    L_0x00ca:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 3;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x00d6:
        if (r16 == 0) goto L_0x00f0;
    L_0x00d8:
        r3 = "";
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x00f0;
    L_0x00e3:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0112;
    L_0x00f0:
        if (r13 == 0) goto L_0x0112;
    L_0x00f2:
        r3 = "";
        r3 = r13.equals(r3);
        if (r3 != 0) goto L_0x0112;
    L_0x00fb:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r3 = r13.equals(r3);
        if (r3 != 0) goto L_0x0112;
    L_0x0106:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 2;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x0112:
        r2 = r2.longValue();
        r0 = r18;
        r3 = com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem.w(r0, r2);
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r11);
        if (r2 != 0) goto L_0x012f;
    L_0x0122:
        r2 = new java.io.File;
        r2.<init>(r11);
        r2 = r2.exists();
        if (r2 == 0) goto L_0x012f;
    L_0x012d:
        r3.hQc = r11;
    L_0x012f:
        r4 = com.tencent.mm.plugin.gallery.model.k.cM(r12, r13);
        r3.mWS = r4;
        r2 = r3.hQc;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 == 0) goto L_0x019b;
    L_0x013d:
        r2 = r3.mqO;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 == 0) goto L_0x019b;
    L_0x0145:
        r2 = "MicroMsg.ImageAndVideoQuery";
        r3 = "thumb file and orignal file both not exist";
        com.tencent.mm.sdk.platformtools.x.w(r2, r3);
        r2 = 0;
    L_0x014f:
        return r2;
    L_0x0150:
        if (r16 == 0) goto L_0x016a;
    L_0x0152:
        r3 = "";
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x016a;
    L_0x015d:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r16;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0177;
    L_0x016a:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 6;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        goto L_0x0112;
    L_0x0177:
        if (r13 == 0) goto L_0x018d;
    L_0x0179:
        r3 = "";
        r3 = r13.equals(r3);
        if (r3 != 0) goto L_0x018d;
    L_0x0182:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r3 = r13.equals(r3);
        if (r3 == 0) goto L_0x0112;
    L_0x018d:
        r3 = com.tencent.mm.plugin.report.service.g.pWK;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 5;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        goto L_0x0112;
    L_0x019b:
        r2 = "mime_type";
        r0 = r17;
        r2 = r0.getColumnIndexOrThrow(r2);
        r0 = r17;
        r2 = r0.getString(r2);
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r4 == 0) goto L_0x01b3;
    L_0x01b0:
        r2 = "";
    L_0x01b3:
        r3.mMimeType = r2;
        r2 = r3;
        goto L_0x014f;
    L_0x01b7:
        r3 = move-exception;
        goto L_0x001f;
    L_0x01ba:
        r3 = move-exception;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.h.b(android.database.Cursor, int):com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem");
    }

    protected final int getType() {
        return 3;
    }

    protected final Uri aOH() {
        return Images.Media.EXTERNAL_CONTENT_URI;
    }

    protected final String[] getProjection() {
        return null;
    }

    protected final String[] aOI() {
        return null;
    }

    protected final String getSelection() {
        return null;
    }

    protected final String aOJ() {
        return null;
    }

    protected final String aOK() {
        return null;
    }

    protected final String BZ(String str) {
        return null;
    }
}
