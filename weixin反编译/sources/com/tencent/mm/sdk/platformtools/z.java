package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.compatible.d.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class z {
    public static boolean bs(int i, int i2) {
        return ((double) i2) > ((double) i) * 2.0d;
    }

    public static boolean bt(int i, int i2) {
        return ((double) i) > ((double) i2) * 2.0d;
    }

    public static int VE(String str) {
        Bitmap bitmap = null;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            bitmap = MMBitmapFactory.decodeStream(FileOp.openRead(str), null, options, 0);
        } catch (FileNotFoundException e) {
        }
        if (bitmap != null) {
            x.i("MicroMsg.LongBitmapHandler", "isLongPicture bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
        float f = ((float) options.outWidth) / ((float) options.outHeight);
        float f2 = ((float) options.outHeight) / ((float) options.outWidth);
        if (f >= 2.0f) {
            return 1;
        }
        if (f2 >= 2.0f) {
            return 2;
        }
        return -1;
    }

    public static Bitmap k(String str, int i, int i2, int i3) {
        return a(str, i, i2, null, i3);
    }

    private static Bitmap a(String str, int i, int i2, DecodeResultLogger decodeResultLogger, int i3) {
        Throwable e;
        InputStream inputStream;
        x.i("MicroMsg.LongBitmapHandler", "hy: createLongPictureBitmap: path: %s, minShorter: %d, maxLonger: %d, type: %d, rotateDegree: %d, decodeStrategy: %d", str, Integer.valueOf(56), Integer.valueOf(e.CTRL_INDEX), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        int i4 = a.gEm;
        a.aC(0);
        if (bi.oN(str) || !(i == 2 || i == 1)) {
            x.w("MicroMsg.LongBitmapHandler", "hy: createLongPictureBitmap precheck failed!");
            i4 = a.gEm;
            a.aC(1);
            return null;
        }
        Point Vr = d.Vr(str);
        if (Vr == null || Vr.x <= 0 || Vr.y <= 0) {
            x.w("MicroMsg.LongBitmapHandler", "hy: can not retrieve original picture size!");
            i4 = a.gEm;
            a.aC(3);
            return null;
        }
        int i5;
        int i6;
        int i7;
        float f;
        Bitmap decodeRegion;
        int i8 = Vr.x;
        int i9 = Vr.y;
        boolean z = i == 1 ? ((double) i8) / ((double) i9) > 2.5d : ((double) i9) / ((double) i8) > 2.5d;
        if (!z) {
            i5 = i == 1 ? i8 : i9;
            if (i == 1) {
                i4 = i9;
            } else {
                i4 = i8;
            }
            int i10 = i4;
            i4 = i5;
            i5 = i9;
            i9 = i10;
            i6 = 0;
            i7 = i8;
            i8 = 0;
        } else if (i == 1) {
            i4 = (int) (((double) i9) * 2.5d);
            i8 = (int) ((((double) i8) - (((double) i9) * 2.5d)) / 2.0d);
            i6 = 0;
            i7 = i4;
            i5 = i9;
        } else {
            i4 = (int) (((double) i8) * 2.5d);
            i6 = (int) ((((double) i9) - (((double) i8) * 2.5d)) / 2.0d);
            i7 = i8;
            i9 = i8;
            i8 = 0;
            i5 = i4;
        }
        x.d("MicroMsg.LongBitmapHandler", "hy: need crop: %b, croppedWidth: %d, croppedHeight: %d, rectStartX: %d, rectStartY: %d", Boolean.valueOf(z), Integer.valueOf(i7), Integer.valueOf(i5), Integer.valueOf(i8), Integer.valueOf(i6));
        if (i4 > e.CTRL_INDEX) {
            i9 = d.v(i9, i4, i9, e.CTRL_INDEX);
            x.d("MicroMsg.LongBitmapHandler", "hy: need sample. use sampleSize: %d, need post scale: %f", Integer.valueOf(i9), Float.valueOf(144.0f / ((float) (i4 / i9))));
            float f2 = r2;
            i4 = i9;
            f = f2;
        } else if (i9 < 56) {
            x.d("MicroMsg.LongBitmapHandler", "hy: need scale larger. scale times: %f", Float.valueOf(56.0f / ((float) i9)));
            f = r2;
            i4 = 1;
        } else {
            f = 1.0f;
            i4 = 1;
        }
        Options options = new Options();
        options.inSampleSize = i4;
        if (z) {
            InputStream inputStream2 = null;
            try {
                inputStream2 = FileOp.openRead(str);
                try {
                    decodeRegion = MMBitmapFactory.decodeRegion(inputStream2, new Rect(i8, i6, i7 + i8, i5 + i6), options, null);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    inputStream = inputStream2;
                } catch (Throwable th) {
                    e = th;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                inputStream = inputStream2;
            } catch (Throwable th2) {
                e = th2;
                inputStream = inputStream2;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw e;
            }
        }
        decodeRegion = MMBitmapFactory.decodeFile(str, options, null, i3, new int[0]);
        if (decodeRegion == null) {
            x.e("MicroMsg.LongBitmapHandler", "hy: can not decode non matrixed bitmap!!");
            i4 = a.gEm;
            a.aC(5);
            return null;
        }
        i8 = a.gEm;
        a.aC(6);
        if (f == 1.0f && i2 == 0) {
            x.d("MicroMsg.LongBitmapHandler", "hy: not need to post handle. return directly");
            return decodeRegion;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        matrix.postRotate((float) i2);
        Bitmap createBitmap = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix, true);
        if (createBitmap != decodeRegion) {
            decodeRegion.recycle();
        }
        if (createBitmap != null) {
            x.d("MicroMsg.LongBitmapHandler", "hy: created bitmap is %d * %d", Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
        }
        return createBitmap;
        return null;
        try {
            x.printErrStackTrace("MicroMsg.LongBitmapHandler", e, "hy: file not found when decode region", new Object[0]);
            i4 = a.gEm;
            a.aC(4);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            return null;
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw e;
        }
    }

    private static boolean a(String str, CompressFormat compressFormat, int i, String str2, int i2, PInt pInt, PInt pInt2) {
        Bitmap k = k(str, i2, 0, 1);
        try {
            pInt.value = k.getWidth();
            pInt2.value = k.getHeight();
            d.a(k, 90, compressFormat, str2, true);
            return true;
        } catch (IOException e) {
            x.e("MicroMsg.LongBitmapHandler", "create thumbnail from orig failed: " + str2);
            return false;
        }
    }

    public static boolean a(String str, CompressFormat compressFormat, String str2, int i) {
        return a(str, compressFormat, 90, str2, i, new PInt(), new PInt());
    }
}
