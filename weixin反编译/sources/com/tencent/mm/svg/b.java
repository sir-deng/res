package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

final class b {
    private static a<Paint> xKH = new a();
    private static a<float[]> xKI = new a();
    private static a<Matrix> xKJ = new a();
    private static a<Path> xKK = new a();
    private static final float[] xKL = new float[9];

    protected static synchronized void d(Looper looper) {
        synchronized (b.class) {
            xKH.c(looper);
            xKI.c(looper);
            xKJ.c(looper);
            xKK.c(looper);
        }
    }

    protected static synchronized Paint a(Looper looper, Paint paint) {
        Paint paint2;
        synchronized (b.class) {
            paint2 = (Paint) xKH.clP();
            if (paint2 == null) {
                paint2 = new Paint();
            } else {
                paint2.reset();
            }
            if (paint != null) {
                paint2.set(paint);
            }
            xKH.a(looper, paint2);
        }
        return paint2;
    }

    protected static synchronized float[] e(Looper looper) {
        Object obj;
        synchronized (b.class) {
            obj = (float[]) xKI.clP();
            if (obj == null) {
                obj = new float[9];
            } else {
                System.arraycopy(xKL, 0, obj, 0, 9);
            }
            xKI.a(looper, obj);
        }
        return obj;
    }

    protected static synchronized Matrix f(Looper looper) {
        Matrix matrix;
        synchronized (b.class) {
            matrix = (Matrix) xKJ.clP();
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            xKJ.a(looper, matrix);
        }
        return matrix;
    }

    protected static synchronized Path g(Looper looper) {
        Path path;
        synchronized (b.class) {
            path = (Path) xKK.clP();
            if (path == null) {
                path = new Path();
            } else {
                path.reset();
            }
            xKK.a(looper, path);
        }
        return path;
    }
}
