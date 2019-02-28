package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;

public final class j {
    private static int hcZ = 0;
    private static final int mWZ;
    private static final int mXa;

    static {
        int i;
        int i2 = 960;
        r2 = new int[2];
        Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
        r2[0] = defaultDisplay.getWidth();
        r2[1] = defaultDisplay.getHeight();
        if (r2[0] > 960) {
            i = r2[0];
        } else {
            i = 960;
        }
        mWZ = i;
        if (r2[1] > 960) {
            i2 = r2[1];
        }
        mXa = i2;
    }

    public static Bitmap a(long j, int i, String str, String str2) {
        if (c.aOl() == null) {
            return null;
        }
        Bitmap a;
        switch (i) {
            case 1:
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                a = a(str, str2, j, 12288, decodeResultLogger);
                if (a == null) {
                    x.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", str, str2);
                    if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        g.pWK.k(12712, KVStatHelper.getKVStatString(str2, 1, decodeResultLogger));
                        return a;
                    }
                }
                break;
            case 2:
                a = l(j, str2);
                if (a == null) {
                    return a(str, str2, j, 12288, null);
                }
                break;
            default:
                return null;
        }
        return a;
    }

    private static int aOL() {
        if (hcZ > 0) {
            return hcZ;
        }
        int b = b.b(ad.getContext(), 150.0f);
        hcZ = b;
        return b;
    }

    private static Bitmap a(String str, String str2, long j, int i, DecodeResultLogger decodeResultLogger) {
        x.d("MicroMsg.MediaManager", "current thread %s", Thread.currentThread().getName());
        if (bi.oN(str)) {
            x.e("MicroMsg.MediaManager", "filePath is null or nill");
            return null;
        }
        Bitmap bitmap;
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap a = d.a(str, aOL(), aOL(), false, null, 0);
        String str3 = "MicroMsg.MediaManager";
        String str4 = "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(a == null ? 0 : a.getWidth());
        objArr[2] = Integer.valueOf(a == null ? 0 : a.getHeight());
        objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        x.v(str3, str4, objArr);
        if (a == null) {
            x.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", str2);
            if (bi.oN(str2)) {
                x.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", str2);
            } else {
                currentTimeMillis = System.currentTimeMillis();
                a = d.a(str2, aOL(), aOL(), false, null, 0);
                str3 = "MicroMsg.MediaManager";
                str4 = "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]";
                objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = Integer.valueOf(a == null ? 0 : a.getWidth());
                objArr[3] = Integer.valueOf(a == null ? 0 : a.getHeight());
                objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                x.v(str3, str4, objArr);
                bitmap = a;
                return o(str2, bitmap);
            }
        }
        bitmap = a;
        return o(str2, bitmap);
    }

    private static Bitmap o(String str, Bitmap bitmap) {
        if (bitmap != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap b = d.b(bitmap, (float) ExifHelper.Vo(str));
            x.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(r1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    public static Bitmap Ca(String str) {
        Object obj = 1;
        if (bi.oN(str)) {
            x.e("MicroMsg.MediaManager", "filepath is null or nil");
            return null;
        }
        try {
            if (e.bO(str)) {
                int i = mWZ;
                int i2 = mXa;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                if (options.outWidth <= 0 || options.outHeight <= 0) {
                    x.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = " + str);
                    return null;
                }
                int i3;
                Object obj2 = (!z.bt(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
                if (!z.bs(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                    obj = null;
                }
                if (!(obj2 == null && obj == null)) {
                    i2 = options.outHeight;
                    i = options.outWidth;
                }
                int Vo = ExifHelper.Vo(str);
                if (Vo == 90 || Vo == 270) {
                    i3 = i2;
                    i2 = i;
                } else {
                    i3 = i;
                }
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                Bitmap a = d.a(str, i2, i3, false, decodeResultLogger, 0);
                if (a == null) {
                    x.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                    if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        g.pWK.k(12712, KVStatHelper.getKVStatString(str, 1, decodeResultLogger));
                    }
                    return null;
                }
                a = d.b(a, (float) Vo);
                x.i("MicroMsg.MediaManager", "bmp height = " + a.getHeight() + ",bmp width = " + a.getWidth());
                return a;
            }
            x.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = " + str);
            return null;
        } catch (Exception e) {
            x.e("MicroMsg.MediaManager", "decode bitmap err: " + e.getMessage());
            return null;
        }
    }

    @TargetApi(8)
    private static Bitmap l(long j, String str) {
        Bitmap thumbnail;
        try {
            thumbnail = Thumbnails.getThumbnail(ad.getContext().getContentResolver(), j, 1, null);
        } catch (Throwable e) {
            x.e("MicroMsg.MediaManager", "exception: %s", bi.i(e));
            thumbnail = null;
        }
        if (thumbnail == null) {
            x.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", Long.valueOf(j), str);
            if (VERSION.SDK_INT >= 8) {
                thumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            }
            if (thumbnail == null && !bi.oN(str)) {
                x.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", Long.valueOf(j), str);
                ad.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
            }
        }
        return thumbnail;
    }
}
