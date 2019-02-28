package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a<Bitmap> {
    private static int hbA = 20971520;
    public static final c hbB = new c();

    public final /* synthetic */ Object a(Comparable comparable) {
        return d((Integer) comparable);
    }

    public final /* synthetic */ Object a(Integer num) {
        return d(num);
    }

    public final /* synthetic */ void aM(Object obj) {
        g((Bitmap) obj);
    }

    @TargetApi(19)
    protected final /* synthetic */ long aN(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap == null) {
            return 0;
        }
        return (long) (d.fO(19) ? bitmap.getByteCount() : bitmap.getAllocationByteCount());
    }

    protected final /* synthetic */ Comparable aO(Object obj) {
        return f((Bitmap) obj);
    }

    protected final /* synthetic */ Comparable b(Comparable comparable) {
        return c((Integer) comparable);
    }

    protected final /* synthetic */ d c(Comparable comparable) {
        return new b(((Integer) comparable).intValue());
    }

    protected final /* synthetic */ Object d(Comparable comparable) {
        return Bitmap.createBitmap(1, ((Integer) comparable).intValue(), k.hbK);
    }

    private c() {
        x.i("MicroMsg.BitmapPool", "BitmapPool %dMB", Integer.valueOf(((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass()));
        if (((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) {
            hbA = 20971520;
        } else {
            hbA = 10485760;
        }
        EB();
    }

    protected static Integer c(Integer num) {
        return Integer.valueOf(num.intValue() * 4);
    }

    protected final long Ex() {
        return (long) hbA;
    }

    protected final long Ey() {
        return 1048576;
    }

    public final synchronized Bitmap d(Integer num) {
        Bitmap bitmap;
        bitmap = (Bitmap) super.a(num);
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            bitmap = null;
        } else {
            x.d("MicroMsg.BitmapPool", "get stored element: %s, width: %s, height: %s, size: %s, requireSize: %s", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), f(bitmap), num);
        }
        return bitmap;
    }

    private static Integer f(Bitmap bitmap) {
        if (bitmap == null) {
            return Integer.valueOf(0);
        }
        int byteCount;
        if (d.fO(19)) {
            byteCount = bitmap.getByteCount();
        } else {
            byteCount = bitmap.getAllocationByteCount();
        }
        return Integer.valueOf(byteCount);
    }

    public final synchronized void g(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.isMutable() && !bitmap.isRecycled()) {
                x.i("MicroMsg.BitmapPool", "release: %s", bitmap);
                super.aM(bitmap);
            }
        }
    }

    public final void Ez() {
        super.Ez();
    }
}
