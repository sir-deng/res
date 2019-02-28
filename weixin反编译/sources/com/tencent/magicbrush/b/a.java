package com.tencent.magicbrush.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.magicbrush.a.c.f;

@SuppressLint({"LongLogTag"})
public class a {
    private static volatile a boQ = null;
    public b boR = new a();

    private class a implements b {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void init() {
            f.i("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
        }

        public final Bitmap aI(int i, int i2) {
            f.i("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
    }

    public interface b {
        Bitmap aI(int i, int i2);

        void init();
    }

    public static a sG() {
        if (boQ != null) {
            return boQ;
        }
        a aVar;
        synchronized (a.class) {
            if (boQ == null) {
                boQ = new a();
            }
            aVar = boQ;
        }
        return aVar;
    }

    private a() {
        this.boR.init();
    }
}
