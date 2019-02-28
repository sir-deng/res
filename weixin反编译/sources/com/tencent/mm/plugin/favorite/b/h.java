package com.tencent.mm.plugin.favorite.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class h {
    private static Map<String, a> mxg = new HashMap();
    private static f<String, Bitmap> mxh = new f(10);
    private static aa<String, Bitmap> mxi = new aa(20);
    public Context context;
    public e mxd;
    public HashMap<String, String[]> mxe = new HashMap();
    private HashMap<String, String[]> mxf = new HashMap();

    /* renamed from: com.tencent.mm.plugin.favorite.b.h$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ String hXI;
        final /* synthetic */ com.tencent.mm.plugin.fav.a.f mvo;
        final /* synthetic */ uz mvp;
        final /* synthetic */ boolean mxk = false;

        AnonymousClass3(boolean z, String str, com.tencent.mm.plugin.fav.a.f fVar, uz uzVar) {
            this.hXI = str;
            this.mvo = fVar;
            this.mvp = uzVar;
        }

        public final void run() {
            if (this.mxk || h.AQ(this.hXI)) {
                j.a(this.mvo, this.mvp, this.mxk);
            }
        }

        public final String toString() {
            return super.toString() + "|getBigImg";
        }
    }

    /* renamed from: com.tencent.mm.plugin.favorite.b.h$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String hXI;
        final /* synthetic */ com.tencent.mm.plugin.fav.a.f mvo;
        final /* synthetic */ uz mvp;

        public AnonymousClass2(String str, com.tencent.mm.plugin.fav.a.f fVar, uz uzVar) {
            this.hXI = str;
            this.mvo = fVar;
            this.mvp = uzVar;
        }

        public final void run() {
            if (h.AQ(this.hXI)) {
                j.a(this.mvo, this.mvp, false);
            }
        }

        public final String toString() {
            return super.toString() + "|attachImg";
        }
    }

    static /* synthetic */ boolean AQ(String str) {
        if (!new File(str).exists()) {
            a aVar = (a) mxg.get(str);
            if (aVar == null) {
                mxg.put(str, new a());
                return true;
            } else if (aVar.zp() > 30000) {
                x.v("MicroMsg.FavoriteImageLogic", "error diff time");
                aVar.gJu = SystemClock.elapsedRealtime();
                return true;
            }
        }
        return false;
    }

    public h(Context context, int i) {
        this.context = context;
        if (i <= 0) {
            i = 24;
        }
        this.mxd = new e(i);
    }

    public final void destory() {
        g gVar = this.mxd;
        synchronized (gVar.gUq) {
            x.d("MicroMsg.ImageEngine", "do clear mark");
            gVar.vDR.clear();
            gVar.vDS.clear();
            gVar.vDR = new HashMap();
            gVar.vDS = new HashMap();
        }
        this.mxe.clear();
        this.mxf.clear();
        this.mxd.destory();
        this.context = null;
        this.mxe = null;
        this.mxf = null;
        this.mxd = null;
    }

    public final void a(ImageView imageView, final uz uzVar, final com.tencent.mm.plugin.fav.a.f fVar, String str, int i, int i2, int i3) {
        String AH = j.AH(uzVar.mBr);
        String[] strArr = null;
        if (uzVar.mBr != null) {
            String[] strArr2 = (String[]) this.mxf.get(AH);
            if (strArr2 == null) {
                strArr = new String[]{j.i(uzVar)};
                this.mxf.put(AH, strArr);
            } else {
                strArr = strArr2;
            }
        }
        this.mxd.a(imageView, strArr, str, i, i2, i3);
        if (strArr != null && strArr.length > 0) {
            final String str2 = strArr[0];
            as.Dt().F(new Runnable() {
                public final void run() {
                    if (h.AQ(str2)) {
                        j.b(fVar, uzVar, true);
                    }
                }

                public final String toString() {
                    return super.toString() + "|mAttachThumb";
                }
            });
        }
    }

    public final void a(ImageView imageView, uz uzVar, com.tencent.mm.plugin.fav.a.f fVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.zl()) {
                imageView.setImageResource(R.g.bEj);
            } else if (fVar != null) {
                vm vmVar;
                switch (fVar.field_type) {
                    case 4:
                    case 16:
                        if (uzVar != null) {
                            a(imageView, uzVar, fVar, uzVar.fra, i, i2, i3);
                            return;
                        }
                        return;
                    case 5:
                        wc wcVar = fVar.field_favProto.wlf;
                        if (uzVar != null) {
                            String str2;
                            if (wcVar != null) {
                                str = wcVar.thumbUrl;
                            }
                            if (bi.oN(str)) {
                                str2 = uzVar.fra;
                            } else {
                                str2 = str;
                            }
                            a(imageView, uzVar, fVar, str2, i, i2, i3);
                            return;
                        } else if (wcVar != null) {
                            this.mxd.a(imageView, null, wcVar.thumbUrl, i, i2, i3);
                            return;
                        } else {
                            return;
                        }
                    case 7:
                        if (uzVar != null) {
                            a(imageView, uzVar, fVar, uzVar.fra, i, i2, i3);
                            return;
                        }
                        return;
                    case 10:
                        vmVar = fVar.field_favProto.wlh;
                        if (vmVar != null) {
                            this.mxd.a(imageView, null, vmVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        vmVar = fVar.field_favProto.wlh;
                        if (vmVar != null) {
                            this.mxd.a(imageView, null, vmVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 15:
                        vw vwVar = fVar.field_favProto.wlj;
                        if (vwVar != null) {
                            this.mxd.a(imageView, null, vwVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        x.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", Integer.valueOf(fVar.field_type));
                        return;
                }
            }
        }
    }

    public final void b(ImageView imageView, uz uzVar, com.tencent.mm.plugin.fav.a.f fVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.zl()) {
                imageView.setImageResource(R.g.bEj);
            } else if (fVar == null || uzVar == null) {
                imageView.setImageDrawable(com.tencent.mm.bu.a.b(this.context, i));
            } else {
                vm vmVar;
                switch (uzVar.bjS) {
                    case 4:
                    case 15:
                        a(imageView, uzVar, fVar, uzVar.fra, i, i2, i3);
                        return;
                    case 5:
                        wc wcVar;
                        String str2;
                        if (uzVar.wkH != null) {
                            wcVar = uzVar.wkH.wlf;
                        } else {
                            x.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", uzVar.mBr, Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id));
                            wcVar = null;
                        }
                        if (wcVar != null) {
                            str = wcVar.thumbUrl;
                        }
                        if (bi.oN(str)) {
                            str2 = uzVar.fra;
                        } else {
                            str2 = str;
                        }
                        a(imageView, uzVar, fVar, str2, i, i2, i3);
                        return;
                    case 7:
                        a(imageView, uzVar, fVar, uzVar.fra, i, i2, i3);
                        return;
                    case 10:
                        if (uzVar.wkH == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", uzVar.mBr, Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id));
                            return;
                        }
                        vmVar = uzVar.wkH.wlh;
                        if (vmVar != null) {
                            this.mxd.a(imageView, null, vmVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (uzVar.wkH == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", uzVar.mBr, Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id));
                            return;
                        }
                        vmVar = uzVar.wkH.wlh;
                        if (vmVar != null) {
                            this.mxd.a(imageView, null, vmVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 14:
                        if (uzVar.wkH == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", uzVar.mBr, Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id));
                            return;
                        }
                        vw vwVar = uzVar.wkH.wlj;
                        if (vwVar != null) {
                            this.mxd.a(imageView, null, vwVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        x.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", Integer.valueOf(fVar.field_type));
                        return;
                }
            }
        }
    }

    private static Bitmap a(uz uzVar, boolean z, boolean z2) {
        String i;
        if (z) {
            i = j.i(uzVar);
        } else {
            i = j.h(uzVar);
        }
        if (e.bO(i)) {
            return c.aY(i, z2);
        }
        x.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
        return null;
    }

    public static Bitmap b(uz uzVar, com.tencent.mm.plugin.fav.a.f fVar, int i) {
        if (!com.tencent.mm.compatible.util.f.zl()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
        }
        if (uzVar.mBr == null) {
            return null;
        }
        Bitmap bitmap;
        String h = j.h(uzVar);
        if (e.bO(h)) {
            bitmap = (Bitmap) mxh.get(h);
            if (bitmap != null) {
                x.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", h);
            } else {
                x.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
                Options options = new Options();
                options.inJustDecodeBounds = true;
                bitmap = BitmapFactory.decodeFile(h, options);
                if (bitmap != null) {
                    x.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", bitmap);
                    bitmap.recycle();
                }
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                x.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 > i) {
                    i3 = (options.outHeight * i) / options.outWidth;
                } else {
                    i = i2;
                }
                i2 = Math.max(1, i);
                i3 = Math.max(1, i3);
                x.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i2), Integer.valueOf(i3));
                int Vo = ExifHelper.Vo(h);
                if (Vo == 90 || Vo == 270) {
                    int i4 = i2;
                    i2 = i3;
                    i3 = i4;
                }
                bitmap = d.d(h, i3, i2, false);
                if (bitmap == null) {
                    x.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = " + h);
                    bitmap = null;
                } else {
                    bitmap = d.b(bitmap, (float) Vo);
                    mxh.put(h, bitmap);
                }
            }
        } else {
            x.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        as.Dt().F(new AnonymousClass3(false, j.h(uzVar), fVar, uzVar));
        return bitmap;
    }

    public static Bitmap j(uz uzVar) {
        if (!com.tencent.mm.compatible.util.f.zl()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
        }
        if (uzVar.mBr == null) {
            return null;
        }
        return a(uzVar, false, true);
    }

    public static Bitmap a(final uz uzVar, final com.tencent.mm.plugin.fav.a.f fVar, final boolean z) {
        if (!com.tencent.mm.compatible.util.f.zl()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
        }
        if (uzVar.mBr == null) {
            return null;
        }
        Bitmap a = a(uzVar, false, false);
        if (a != null) {
            return a;
        }
        final String h = j.h(uzVar);
        as.Dt().F(new Runnable() {
            public final void run() {
                if (z || h.AQ(h)) {
                    j.a(fVar, uzVar, z);
                }
            }

            public final String toString() {
                return super.toString() + "|getBigImg";
            }
        });
        return a;
    }

    public static Bitmap a(final uz uzVar, final com.tencent.mm.plugin.fav.a.f fVar) {
        if (!com.tencent.mm.compatible.util.f.zl()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj);
        }
        if (j.AH(uzVar.mBr) == null) {
            return null;
        }
        Bitmap a = a(uzVar, true, false);
        if (a != null) {
            return a;
        }
        final String i = j.i(uzVar);
        as.Dt().F(new Runnable() {
            public final void run() {
                if (h.AQ(i)) {
                    j.b(fVar, uzVar, true);
                }
            }

            public final String toString() {
                return super.toString() + "|getThumb";
            }
        });
        return a;
    }

    public static Bitmap b(String str, int i, int i2, boolean z) {
        IOException e;
        boolean z2 = false;
        if (e.bO(str)) {
            Bitmap bitmap = (Bitmap) mxi.get(str);
            if (bitmap != null || z) {
                String str2 = "MicroMsg.FavoriteImageLogic";
                String str3 = "return bm path %s, bm %s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap != null);
                x.d(str2, str3, objArr);
                return bitmap;
            }
            try {
                Bitmap decodeFile;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                d.decodeFile(str, options);
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                int Vo = ExifHelper.Vo(str);
                if (Vo == 90 || Vo == 270) {
                    z2 = true;
                    int i5 = i3;
                    i3 = i4;
                    i4 = i5;
                }
                options.inSampleSize = 1;
                while (i4 / options.inSampleSize > i2 && i3 / options.inSampleSize > i) {
                    options.inSampleSize++;
                }
                int i6 = (i3 * i2) / i;
                x.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i6), Boolean.valueOf(z2));
                if (i6 <= 0 || i4 <= i6) {
                    options.inJustDecodeBounds = false;
                    decodeFile = d.decodeFile(str, options);
                } else {
                    Rect rect = new Rect();
                    rect.top = 0;
                    rect.left = 0;
                    if (z2) {
                        rect.right = i6;
                        rect.bottom = i3;
                    } else {
                        rect.right = i3;
                        rect.bottom = i6;
                    }
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, true);
                    options.inJustDecodeBounds = false;
                    decodeFile = newInstance.decodeRegion(rect, options);
                }
                if (decodeFile == null || !z2) {
                    bitmap = decodeFile;
                } else {
                    try {
                        bitmap = d.b(decodeFile, (float) Vo);
                    } catch (IOException e2) {
                        IOException iOException = e2;
                        bitmap = decodeFile;
                        e = iOException;
                        x.e("MicroMsg.FavoriteImageLogic", e.getMessage());
                        return bitmap;
                    }
                }
                if (bitmap != null) {
                    x.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(i2));
                    mxi.put(str, bitmap);
                    return bitmap;
                }
                x.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
                return bitmap;
            } catch (IOException e3) {
                e = e3;
                x.e("MicroMsg.FavoriteImageLogic", e.getMessage());
                return bitmap;
            }
        }
        x.w("MicroMsg.FavoriteImageLogic", "file not exist");
        return null;
    }

    public static void a(ImageView imageView, int i, uz uzVar, com.tencent.mm.plugin.fav.a.f fVar, boolean z, int i2, int i3) {
        if (!com.tencent.mm.compatible.util.f.zl()) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.bEj));
        }
        if (uzVar.mBr == null) {
            imageView.setImageResource(i);
        }
        Bitmap a = a(uzVar, fVar);
        final String h = j.h(uzVar);
        if (e.bO(h)) {
            a = b(h, i2, i3, true);
        }
        if (a == null) {
            imageView.setImageResource(i);
            imageView.setTag(h);
            final int i4 = i2;
            final int i5 = i3;
            final com.tencent.mm.plugin.fav.a.f fVar2 = fVar;
            final uz uzVar2 = uzVar;
            final boolean z2 = z;
            final ImageView imageView2 = imageView;
            as.Dt().F(new Runnable() {
                public final void run() {
                    final Bitmap b = h.b(h, i4, i5, false);
                    if (b == null) {
                        h.c(fVar2, uzVar2, z2);
                        return;
                    }
                    String str = (String) imageView2.getTag();
                    if (str != null && str.equals(h)) {
                        as.Dt();
                        ah.y(new Runnable() {
                            public final void run() {
                                imageView2.setImageBitmap(b);
                            }
                        });
                    }
                }
            });
            return;
        }
        imageView.setImageBitmap(a);
    }

    private static void c(final com.tencent.mm.plugin.fav.a.f fVar, final uz uzVar, final boolean z) {
        final String h = j.h(uzVar);
        as.Dt().F(new Runnable() {
            public final void run() {
                if (z || h.AQ(h)) {
                    j.a(fVar, uzVar, z);
                }
            }

            public final String toString() {
                return super.toString() + "|reDownload";
            }
        });
    }

    public static void a(com.tencent.mm.plugin.fav.a.f fVar, uz uzVar) {
        c(fVar, uzVar, true);
    }
}
